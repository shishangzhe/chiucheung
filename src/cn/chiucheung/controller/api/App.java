package cn.chiucheung.controller.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.po.logistics.travelclockin.LogTravelClockIn;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelOtherSpending;
import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFile;
import cn.chiucheung.po.market.devicenameserialnumber.MarDeviceNameSerialNumber;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInCustom;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustom;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForApp;
import cn.chiucheung.service.logistics.TravelClockInService;
import cn.chiucheung.service.logistics.TravelSpendingRecordsService;
import cn.chiucheung.service.logistics.TravelUserService;
import cn.chiucheung.service.market.ConductPropagandaFileService;
import cn.chiucheung.service.market.DeviceNameSerialNumberService;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;

@Controller
@RequestMapping("/api/app")
public class App {
	
	@Autowired
	private TravelUserService travelUserService;
	
	@Autowired
	private TravelSpendingRecordsService travelSpendingRecordsService;
	
	@Autowired
	private TravelClockInService travelClockInService;
	
	@Autowired
	private DeviceNameSerialNumberService deviceNameSerialNumberService;
	
	@Autowired
	private ConductPropagandaFileService conductPropagandaFileService;
	
	@RequestMapping(value="login")
	@ResponseBody
	public JSONObject login(LogTravelUser travelUser,HttpServletResponse response,HttpSession session){
		//response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isNotBlank(travelUser.getWorkNo()) && StringUtils.isNotBlank(travelUser.getPassword())){
			List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
			if (list != null && list.size() > 0){
				if ("1".equals(list.get(0).getIsAllowedLogin())){
					if (StringUtils.isNotBlank(list.get(0).getDeviceSerialNumber())){//绑定了设备,则一定是新版本登陆
						if (list.get(0).getDeviceSerialNumber().equals(travelUser.getDeviceSerialNumber())){//绑定的设备登陆
							jsonObject.accumulate("success", true);
							jsonObject.accumulate("bind", true);
							jsonObject.accumulate("username", list.get(0).getUsername());
						}else{//有可能双卡双待的手机问题，需要吧,号前后颠倒
							if (list.get(0).getDeviceSerialNumber().indexOf(",") != -1 && travelUser.getDeviceSerialNumber().indexOf(",") != -1){
								String[] deviceSerialNumberSplit = list.get(0).getDeviceSerialNumber().split(",");
								if (travelUser.getDeviceSerialNumber().equals(deviceSerialNumberSplit[1] + "," + deviceSerialNumberSplit[0])){
									jsonObject.accumulate("success", true);
									jsonObject.accumulate("bind", true);
									jsonObject.accumulate("username", list.get(0).getUsername());
								}else{
									jsonObject.accumulate("success", false);
									jsonObject.accumulate("message", "不在绑定的设备上登陆，如已更换手机，请联系管理员解除绑定");
								}
							}else{//不是绑定的设备登陆
								jsonObject.accumulate("success", false);
								jsonObject.accumulate("message", "不在绑定的设备上登陆，如已更换手机，请联系管理员解除绑定");
							}
						}
					}else{//没有绑定设备
						if (StringUtils.isNotBlank(travelUser.getDeviceSerialNumber())){//新版本第一次登陆，没有绑定，需要提示绑定
							jsonObject.accumulate("success", true);
							jsonObject.accumulate("bind", false);
							jsonObject.accumulate("username", list.get(0).getUsername());
							jsonObject.accumulate("id", list.get(0).getId());
						}else{//旧版本登陆
							jsonObject.accumulate("success", true);
							jsonObject.accumulate("username", list.get(0).getUsername());
							//jsonObject.accumulate("message", "请将APP更新到最新版本，此次更新为强制更新！");
						}
					}
				}else{
					jsonObject.accumulate("success", false);
					jsonObject.accumulate("message", "该用户不允许登陆");
				}
			}else{
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "账户或密码错误");
			}
		}else{
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("success", "账户或密码不能为空");
		}
		return jsonObject;
	}
	
	
	@RequestMapping("bindDevice")
	@ResponseBody
	public JSONObject bindDevice(LogTravelUser travelUser){
		JSONObject jsonObject = new JSONObject();
		try{
			travelUserService.updateTravelUser(travelUser);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", "绑定失败");
		}
		return jsonObject;
	}
	
	
	@RequestMapping("saveTravelSpendingRecords")
	@ResponseBody
	public JSONObject saveTravelSpendingRecords(LogTravelSpendingRecordsCustom travelSpendingRecordsCustom){
		JSONObject jsonObject = new JSONObject();
		try{
			if (StringUtils.isNotBlank(travelSpendingRecordsCustom.getWorkNo()) && StringUtils.isNotBlank(travelSpendingRecordsCustom.getPassword())){
				LogTravelUser travelUser = new LogTravelUser();
				travelUser.setWorkNo(travelSpendingRecordsCustom.getWorkNo());
				travelUser.setPassword(travelSpendingRecordsCustom.getPassword());
				travelUser.setDeviceSerialNumber(travelSpendingRecordsCustom.getDeviceSerialNumber());
				
				List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
				
				checkLogin(list, travelUser);
				
				List<LogTravelOtherSpending> subsidies = travelSpendingRecordsCustom.getSubsidies();
				boolean b = false;
				if (subsidies != null && subsidies.size() >0){
					for (LogTravelOtherSpending travelOtherSpending : subsidies) {
						if ("".equals(travelOtherSpending.getDescription())){
							b = true;
						}
					}
				}
				if ("上班".equals(travelSpendingRecordsCustom.getLunchType())){
					jsonObject.accumulate("success", false);
					jsonObject.accumulate("message", "午餐的餐费分类更改，请更新您的APP版本");
				}else if (b){
					jsonObject.accumulate("success", false);
					jsonObject.accumulate("message", "请更新您的APP版本");
				}else{
					travelSpendingRecordsCustom.setLogTravelUserId(list.get(0).getId());
					travelSpendingRecordsService.saveTravelSpendingRecords(travelSpendingRecordsCustom);
					jsonObject.accumulate("success", true);
				}
			}else{
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "参数错误");
			}
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@RequestMapping("findAllTravelSpendingRecords")
	@ResponseBody
	public JSONObject findAllTravelSpendingRecords(LogTravelUser travelUser, String lastCreateTime, int pageSize){
		JSONObject jsonObject = new JSONObject();
		try{
			if (StringUtils.isNotBlank(travelUser.getWorkNo())  && StringUtils.isNotBlank(travelUser.getPassword())){
				List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
				
				checkLogin(list, travelUser);
						
				List<LogTravelSpendingRecordsCustomForApp> travelSpendingRecordsCustomForApps = travelSpendingRecordsService.findAllTravelSpendingRecordsByLogTravelUserIdForApp(list.get(0).getId(), lastCreateTime, pageSize);
				jsonObject.accumulate("success", true);
				jsonObject.accumulate("travelSpendingRecords", travelSpendingRecordsCustomForApps);
			}else{
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "参数错误");
			}
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@RequestMapping("findTravelSpendingRecordsByIdForEdit")
	@ResponseBody
	public Map<String, Object> findTravelSpendingRecordsByIdForEdit(LogTravelUser travelUser,String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if (StringUtils.isNotBlank(travelUser.getWorkNo()) && StringUtils.isNotBlank(travelUser.getPassword())){
				List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
				
				checkLogin(list, travelUser);
				
				LogTravelSpendingRecordsCustom travelSpendingRecordsCustom = travelSpendingRecordsService.findTravelSpendingRecordsByIdForEdit(id);
				map.put("success", true);
				map.put("travelSpendingRecordsCustom", travelSpendingRecordsCustom);
			}else{
				map.put("success", false);
				map.put("message", "参数错误");
			}
		}catch(Exception e){
			map.put("success", false);
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("updateTravelSpendingRecords")
	@ResponseBody
	public JSONObject updateTravelSpendingRecords(LogTravelSpendingRecordsCustom travelSpendingRecordsCustom){
		JSONObject jsonObject = new JSONObject();
		try{
			if (StringUtils.isNotBlank(travelSpendingRecordsCustom.getWorkNo()) && StringUtils.isNotBlank(travelSpendingRecordsCustom.getPassword())){
				LogTravelUser travelUser = new LogTravelUser();
				travelUser.setWorkNo(travelSpendingRecordsCustom.getWorkNo());
				travelUser.setPassword(travelSpendingRecordsCustom.getPassword());
				travelUser.setDeviceSerialNumber(travelSpendingRecordsCustom.getDeviceSerialNumber());
				List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
				
				checkLogin(list, travelUser);
				
				travelSpendingRecordsCustom.setLogTravelUserId(list.get(0).getId());
				travelSpendingRecordsService.updateTravelSpendingRecords(travelSpendingRecordsCustom);
				jsonObject.accumulate("success", true);
			}else{
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "参数错误");
			}
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@RequestMapping("deleteTravelSpendingRecordsById")
	@ResponseBody
	public JSONObject deleteTravelSpendingRecordsById(LogTravelUser travelUser, String id){
		JSONObject jsonObject = new JSONObject();
		try{
			if (StringUtils.isNotBlank(travelUser.getWorkNo()) && StringUtils.isNotBlank(travelUser.getPassword())){
				List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
				
				checkLogin(list, travelUser);
				
				travelSpendingRecordsService.deleteTravelSpendingRecordsById(id);
				jsonObject.accumulate("success", true);
			}else{
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "参数错误");
			}
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@RequestMapping("findTravelSpendingRecordsByIdForCopyData")
	@ResponseBody
	public Map<String, Object> findTravelSpendingRecordsByIdForCopyData(LogTravelUser travelUser,String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if (StringUtils.isNotBlank(travelUser.getWorkNo()) && StringUtils.isNotBlank(travelUser.getPassword())){
				List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
				
				checkLogin(list, travelUser);
				
				LogTravelSpendingRecordsCustom travelSpendingRecordsCustom = travelSpendingRecordsService.findTravelSpendingRecordsByIdForCopyData(id);
				map.put("success", true);
				map.put("travelSpendingRecordsCustom", travelSpendingRecordsCustom);
			}else{
				map.put("success", false);
				map.put("message", "参数错误");
			}
		}catch(Exception e){
			map.put("success", false);
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("changePassword")
	@ResponseBody
	public JSONObject changePassword(LogTravelUser travelUser, String password1){
		JSONObject jsonObject = new JSONObject();
		try{
			if (StringUtils.isNotBlank(travelUser.getWorkNo()) && StringUtils.isNotBlank(travelUser.getPassword())){
				List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
				if (list != null && list.size() > 0){
					
					checkLogin(list, travelUser);
					
					travelUser.setPassword(password1);
					int i = travelUserService.updateTravelUserByAppChangePassowrd(travelUser);
					if (i > 0){
						jsonObject.accumulate("success", true);
						jsonObject.accumulate("message", "密码更改成功，请重新登陆！");
					}else{
						jsonObject.accumulate("success", false);
						jsonObject.accumulate("message", "密码更改失败！");
					}
				}else{
					jsonObject.accumulate("success", false);
					jsonObject.accumulate("message", "原始密码错误");
				}
			}else{
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "参数错误");
			}
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@RequestMapping("checkNewVersion")
	@ResponseBody
	public JSONObject checkNewVersion(String version){
		String serverVersion = ResourcesUtil.getValue("appVersion", "version");
		JSONObject jsonObject = new JSONObject();
		if (serverVersion.equals(version)){
			jsonObject.accumulate("newVersion", false);
		}else{
			jsonObject.accumulate("newVersion", true);
		}
		
		jsonObject.accumulate("success", true);
		
		return jsonObject;
	}
	
	/**
	 * 下载报账软件的APP
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("downloadAPP")
	@ResponseBody
	public String downloadAPP(HttpServletResponse response){
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path"),"apk");
		File apkFile = file.listFiles()[0];
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(apkFile);
			
			String fileName = apkFile.getName();
			fileName = URLEncoder.encode(fileName, "utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+fileName);  
			response.setHeader("Content-Length", inputStream.available()+"");
			response.setContentType("application/octet-stream; charset=utf-8");  
			
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (Exception e) {
			if (!e.toString().split(":")[0].equals("ClientAbortException")){//当用户取消时候，e.toString()= "ClientAbortException:  java.io.IOException"
				e.printStackTrace();
			}
		}finally{
			try{
				if (inputStream != null){
					inputStream.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}finally{
				inputStream = null;
			}
		}
		return null;
	}
	
	
	/**
	 * 保存打卡
	 * @param travelClockInCustom
	 * @return
	 */
	@RequestMapping("saveTravelClockIn")
	@ResponseBody
	public JSONObject saveTravelClockIn(LogTravelClockInCustom travelClockInCustom){
		JSONObject jsonObject = new JSONObject();
		try{
			if (StringUtils.isNotBlank(travelClockInCustom.getWorkNo()) && StringUtils.isNotBlank(travelClockInCustom.getPassword())){
				LogTravelUser travelUser = new LogTravelUser();
				travelUser.setWorkNo(travelClockInCustom.getWorkNo());
				travelUser.setPassword(travelClockInCustom.getPassword());
				travelUser.setDeviceSerialNumber(travelClockInCustom.getDeviceSerialNumber());
				List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
				
				checkLogin(list, travelUser);
				
				LogTravelClockIn travelClockIn = new LogTravelClockIn();
				travelClockIn.setId(UUIDBuild.getUUID());
				travelClockIn.setAddress(travelClockInCustom.getAddress());
				travelClockIn.setClockOn(new Date());
				travelClockIn.setLogTravelUserId(list.get(0).getId());
				
				travelClockInService.saveTravelClockIn(travelClockIn);
				
				jsonObject.accumulate("success", true);
			}else{
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "参数错误");
			}
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 查询打卡
	 * @param travelClockInCustom
	 * @return
	 */
	@RequestMapping("findAllTravelClockIn")
	@ResponseBody
	public JSONObject findAllTravelClockIn(LogTravelUser travelUser, String lastClockOn, int pageSize){
		JSONObject jsonObject = new JSONObject();
		try{
			if (StringUtils.isNotBlank(travelUser.getWorkNo())  && StringUtils.isNotBlank(travelUser.getPassword())){
				List<LogTravelUser> list = travelUserService.findTravelUserByWorkNoAndPassword(travelUser);
				
				checkLogin(list, travelUser);
						
				List<LogTravelClockInCustom> travelClockIns = travelClockInService.findAllTravelClockInListForApp(list.get(0).getId(), lastClockOn, pageSize);
				jsonObject.accumulate("success", true);
				jsonObject.accumulate("travelClockIns", travelClockIns);
			}else{
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "参数错误");
			}
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	
	/**
	 * 
	 * @param list 根据workNo和password从后台取出来的数据
	 * @param travelUser 用户传过来的数据
	 */
	private void checkLogin(List<LogTravelUser> list, LogTravelUser travelUser){
		if (list == null || list.size() <= 0){
			throw new RuntimeException("用户信息错误，请重新登陆");
		}
		
		if (!"1".equals(list.get(0).getIsAllowedLogin())){
			throw new RuntimeException("用户已被禁止使用");
		}
		
		if (StringUtils.isBlank(travelUser.getDeviceSerialNumber())){//旧版本
			throw new RuntimeException("请将APP更新到最新版本，此次更新为强制更新！");
		}
		
		if (StringUtils.isBlank(list.get(0).getDeviceSerialNumber())){//新版本进来，但是又没绑定设备
			throw new RuntimeException("请重新登陆，并绑定设备");
		}
		
		if (!list.get(0).getDeviceSerialNumber().equals(travelUser.getDeviceSerialNumber())){
			if (list.get(0).getDeviceSerialNumber().indexOf(",") != -1 && travelUser.getDeviceSerialNumber().indexOf(",") != -1){
				String[] deviceSerialNumberSplit = list.get(0).getDeviceSerialNumber().split(",");
				if (!travelUser.getDeviceSerialNumber().equals(deviceSerialNumberSplit[1] + "," + deviceSerialNumberSplit[0])){
					throw new RuntimeException("不在绑定的设备上操作");
				}
			}else{
				throw new RuntimeException("不在绑定的设备上操作");
			}
		}
	}
	
	
	
	//下面是销售用APP的
	
	
	
	
	/**
	 * 下载销售用的APP
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("downloadSaleAPP")
	@ResponseBody
	public String downloadSaleAPP(HttpServletResponse response){
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path"), "saleApk");
		File apkFile = file.listFiles()[0];
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(apkFile);
			
			String fileName = apkFile.getName();
			fileName = URLEncoder.encode(fileName, "utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+fileName);  
			response.setHeader("Content-Length", inputStream.available()+"");
			response.setContentType("application/octet-stream; charset=utf-8");  
			
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (Exception e) {
			if (!e.toString().split(":")[0].equals("ClientAbortException")){//当用户取消时候，e.toString()= "ClientAbortException:  java.io.IOException"
				e.printStackTrace();
			}
		}finally{
			try{
				if (inputStream != null){
					inputStream.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}finally{
				inputStream = null;
			}
		}
		return null;
	}
	
	/**
	 * 获取宣传文件的列表
	 * @return
	 */
	@RequestMapping("findConductPropagandaFileList")
	@ResponseBody
	public JSONObject findConductPropagandaFileList(String serialNumber){
		JSONObject jsonObject = new JSONObject();
		try{
			List<MarDeviceNameSerialNumber> deviceNameSerialNumbers = deviceNameSerialNumberService.checkSerialNumber(serialNumber);
			if (deviceNameSerialNumbers == null || deviceNameSerialNumbers.size() <= 0 || !deviceNameSerialNumbers.get(0).getIsAllowedDownload()){
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "该设备不能获取列表");
			}else{
				List<MarConductPropagandaFile> list = conductPropagandaFileService.findConductPropagandaFileList();
				jsonObject.accumulate("success", true);
				jsonObject.accumulate("data", list);
			}
		}catch (Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 检测该设备是否可以下载，并且根据flag来判断是第一次下载，还是更新，第一次下载，要确定该文件存在，更新的话，要确定是否是最新
	 * @param serialNumber
	 * @return
	 */
	@RequestMapping("checkSerialNumberAndGetDownLoadInfo")
	@ResponseBody
	public JSONObject checkSerialNumberAndGetDownLoadInfo(String serialNumber, String flag, String fileName, Float fileVersion){
		JSONObject jsonObject = new JSONObject();
		try{
			List<MarDeviceNameSerialNumber> deviceNameSerialNumbers = deviceNameSerialNumberService.checkSerialNumber(serialNumber);
			if (deviceNameSerialNumbers == null || deviceNameSerialNumbers.size() <= 0 || !deviceNameSerialNumbers.get(0).getIsAllowedDownload()){
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "该设备不能下载");
			}else{
				List<MarConductPropagandaFile> conductPropagandaFiles = conductPropagandaFileService.findMaxVersionFormConductPropagandaFileByFileName(fileName);
				if ("add".equals(flag)){//第一次下载
					if(conductPropagandaFiles != null && conductPropagandaFiles.size() > 0){
						jsonObject.accumulate("success", true);
						jsonObject.accumulate("fileVersion", conductPropagandaFiles.get(0).getFileVersion()+"");
						jsonObject.accumulate("id", conductPropagandaFiles.get(0).getId());
					}else{
						jsonObject.accumulate("success", false);
						jsonObject.accumulate("message", "没有找到该文件");
					}
				}else if ("update".equals(flag)){//更新
					if(conductPropagandaFiles != null && conductPropagandaFiles.size() > 0){
						if (fileVersion - conductPropagandaFiles.get(0).getFileVersion() != 0){
							jsonObject.accumulate("success", true);
							jsonObject.accumulate("fileVersion", conductPropagandaFiles.get(0).getFileVersion()+"");
							jsonObject.accumulate("id", conductPropagandaFiles.get(0).getId());
						}else{
							jsonObject.accumulate("success", false);
							jsonObject.accumulate("message", "当前是最新版本");
						}
					}else{
						jsonObject.accumulate("success", false);
						jsonObject.accumulate("message", "没有找到该文件的任何版本信息");
					}
				}else{//参数错误
					jsonObject.accumulate("success", false);
					jsonObject.accumulate("message", "参数错误");
				}
			}
		}catch (Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	@RequestMapping("downloadDocument")
	public void downloadDocument(HttpServletResponse response, String id){
		InputStream inputStream = null;
		try {
			MarConductPropagandaFile conductPropagandaFile = conductPropagandaFileService.findConductPropagandaFileById(id);
			
			File file = new File(ResourcesUtil.getValue("fileRootPath", "path"),"marConductPropagandaFile");
			File documentFile = new File(file, conductPropagandaFile.getId());
			
			inputStream = new FileInputStream(documentFile);
			
			String filename = conductPropagandaFile.getFileName();
			response.setHeader("Content-Disposition", "attachment; filename="+id+filename.substring(filename.lastIndexOf(".")));  
			response.setHeader("Content-Length", inputStream.available()+"");
			response.setContentType("application/octet-stream; charset=utf-8");  
			
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (Exception e) {
			if (!e.toString().split(":")[0].equals("ClientAbortException")){//当用户取消时候，e.toString()= "ClientAbortException:  java.io.IOException"
				e.printStackTrace();
			}
			response.setStatus(500);
		}finally{
			try{
				if (inputStream != null){
					inputStream.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}finally{
				inputStream = null;
			}
		}
	}
}
