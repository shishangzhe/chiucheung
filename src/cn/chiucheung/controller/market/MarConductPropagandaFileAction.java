package cn.chiucheung.controller.market;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFile;
import cn.chiucheung.pojo.market.conductpropagandafile.MarConductPropagandaFileQueryVo;
import cn.chiucheung.service.market.ConductPropagandaFileService;
import cn.chiucheung.utils.ResourcesUtil;

@Controller
@RequestMapping("/market/conductPropagandaFile")
public class MarConductPropagandaFileAction {
	
	@Autowired
	ConductPropagandaFileService conductPropagandaFileService;
	
	/**
	 * 页面的跳转
	 * @return
	 */
	@RequestMapping("index")
	@AnnotationLimit(pid="ff",mid="fh")
	public String index(){
		return "market/conductPropagandaFile";
	}
	
	/**
	 * 查询所有的宣传文件
	 * @param conductPropagandaFile
	 * @return
	 */
	@RequestMapping(value="findAllConductPropagandaFile")
	@ResponseBody
	@AnnotationLimit(pid="ff",mid="fh")
	public Map<String, Object> findAllConductPropagandaFile(MarConductPropagandaFileQueryVo conductPropagandaFileQueryVo){
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<MarConductPropagandaFile> list = conductPropagandaFileService.findAllConductPropagandaFile(conductPropagandaFileQueryVo);
			String total = conductPropagandaFileService.findAllConductPropagandaFileTotal(conductPropagandaFileQueryVo);
			
			map.put("rows", list);
			map.put("total", total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据新版本的文件，查找老版本的文件
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findAllOldConductPropagandaFileByNewId")
	@ResponseBody
	@AnnotationLimit(pid="ff",mid="fh")
	public List<MarConductPropagandaFile> findAllOldConductPropagandaFileByNewId(String id){
		return conductPropagandaFileService.findAllOldConductPropagandaFileByNewId(id);
	}
	
	
	/**
	 * 新增宣传文件
	 * @param conductPropagandaFile
	 * @return
	 */
	@RequestMapping(value="saveConductPropagandaFile")
	@ResponseBody
	@AnnotationLimit(pid="fh",mid="fha")
	public JSONObject saveConductPropagandaFile(MultipartFile file){
		JSONObject jsonObject = new JSONObject();
		try{
			conductPropagandaFileService.saveConductPropagandaFile(file);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	/**
	 * 查找是否存在该文件名的文件
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value="checkFileNameIsRepeat")
	@ResponseBody
	@AnnotationLimit(pid="fh",mid="fha")
	public JSONObject checkFileNameIsRepeat(String fileName){
		JSONObject jsonObject = new JSONObject();
		try{
			List<MarConductPropagandaFile> list = conductPropagandaFileService.checkFileNameIsRepeat(fileName);
			if (list != null && list.size() > 0 ){
				jsonObject.accumulate("isRepeat", true);
			}else{
				jsonObject.accumulate("isRepeat", false);
			}
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	/**
	 * 更新宣传文件
	 * @param request
	 * @param fileName 更新的文件名
	 * @param file
	 * @return
	 */
	@RequestMapping("updateConductPropagandaFile")
	@ResponseBody
	@AnnotationLimit(pid="fh",mid="fhb")
	public JSONObject updateConductPropagandaFile(String fileName, MultipartFile file){
		JSONObject jsonObject = new JSONObject();
		try{
			conductPropagandaFileService.updateConductPropagandaFile(fileName, file);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	/**
	 * 根据id删除工咭信息
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteConductPropagandaFileById")
	@ResponseBody
	@AnnotationLimit(pid="fh",mid="fhc")
	public JSONObject deleteConductPropagandaFileById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			conductPropagandaFileService.deleteConductPropagandaFileById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@RequestMapping("readConductPropagandaFileById")
	@AnnotationLimit(pid="fh",mid="fhd")
	public String readConductPropagandaFileById(HttpServletRequest request, HttpServletResponse response, String id){
		MarConductPropagandaFile conductPropagandaFile = conductPropagandaFileService.findConductPropagandaFileById(id);
		String fileName = conductPropagandaFile.getFileName();
		String suffix = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
		String str = "ods,xls,xlsb,xlsm,xlsx,odp,pot,potm,potx,pps,ppsm,ppsx,ppt,pptm,pptx,doc,docm,docx,dot,dotm,dotx,odt,pdf";
		try {
			if (str.contains(suffix)){
				String url = ResourcesUtil.getValue("owa", "officeViewUrl")+URLEncoder.encode(ResourcesUtil.getValue("owa", "myUrl")+"/market/conductPropagandaFile/downloadConductPropagandaFileById.action?id="+id+"&origin=OfficeWebApps");
				response.sendRedirect(url);
			}else if (suffix.equals("mp4")){
				request.setAttribute("title", fileName);
				request.setAttribute("url", "/market/conductPropagandaFile/downloadConductPropagandaFileById.action?id="+id);
				return "media";
			}else{
				request.setAttribute("error", "该文件类型不支持预览");
				return "error";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 下载文件
	 * @param request
	 * @param response
	 * @param id
	 */
	@RequestMapping("downloadConductPropagandaFileById")
	@AnnotationLimit(pid="fh",mid="fhd")
	public String downloadConductPropagandaFileById(HttpServletRequest request, HttpServletResponse response, String id){
		InputStream inputStream = null;
		try {
			
			MarConductPropagandaFile conductPropagandaFile = conductPropagandaFileService.findConductPropagandaFileById(id);
			if (conductPropagandaFile == null){
				throw new RuntimeException("没有找到数据，请刷新");
			}
			
			File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path"),"marConductPropagandaFile");
			File file = new File(fileDir, conductPropagandaFile.getId());
			
			inputStream = new FileInputStream(file);
			
			String fileName = conductPropagandaFile.getFileName();
			fileName = URLEncoder.encode(fileName, "utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+fileName);  
			response.setHeader("Content-Length", inputStream.available()+"");
			response.setContentType("application/octet-stream; charset=utf-8");  
			
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (FileNotFoundException e){
			request.setAttribute("error", "系统找不到指定文件");
			return "error";
		} catch (Exception e) {
			if (!e.toString().split(":")[0].equals("ClientAbortException")){//当用户取消时候，e.toString()= "ClientAbortException:  java.io.IOException"
				e.printStackTrace();
			}
			//response.setStatus(500);
			request.setAttribute("error", e.getMessage());
			return "error";
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
	 * 获取上传进度
	 * @param id
	 * @return
	 */
	@RequestMapping("getPorgress")
	@ResponseBody
	public JSONObject getPorgress(HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try{
			//Progress status = (Progress) session.getAttribute("status");
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("status", session.getAttribute("status"));
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
}
