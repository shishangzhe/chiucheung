package cn.chiucheung.controller.sales;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.engineering.workhours.EngWorkHours;
import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFile;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfo;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfoPic;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoCustom;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoQueryVo;
import cn.chiucheung.service.sales.ProjectInfoService;
import cn.chiucheung.utils.JxlExcelUtils;
import cn.chiucheung.utils.ResourcesUtil;

@Controller
@RequestMapping("/sales/projectInfo")
public class SalProjectInfoAction {
	
	@Autowired ProjectInfoService projectInfoService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="dk",pid="dd")
	public String index(){
		return "sales/projectInfo";
	}

	
	/**
	 * 查找所有的项目信息
	 * @return
	 */
	@RequestMapping(value="findAllProjectInfoList")
	@ResponseBody
	@AnnotationLimit(mid="dk",pid="dd")
	public Map<String, Object> findAllProjectInfoList(SalProjectInfoQueryVo projectInfoQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<SalProjectInfoCustom> list =  projectInfoService.findAllProjectInfoList(projectInfoQueryVo);
			String total = projectInfoService.findAllProjectInfoTotal(projectInfoQueryVo);
			
			map.put("rows", list);
			map.put("total", total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 新增项目信息
	 * @param projectInfo
	 * @param pic
	 * @return
	 */
	@RequestMapping(value="saveSalProjectInfo")
	@ResponseBody
	@AnnotationLimit(mid="dka",pid="dk")
	public JSONObject saveSalProjectInfo(SalProjectInfo projectInfo, @RequestParam("pic") MultipartFile[] pic){
		JSONObject jsonObject = new JSONObject();
		try{
			projectInfoService.saveSalProjectInfo(projectInfo, pic);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	
	/**
	 * 根据id查找项目信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findSalProjectInfoById")
	@ResponseBody
	@AnnotationLimit(mid="dkb",pid="dk")
	public Map<String, Object> findSalProjectInfoById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			SalProjectInfoCustom projectInfoCustom = projectInfoService.findSalProjectInfoById(id);
			map.put("success", true);
			map.put("projectInfo", projectInfoCustom);
		}catch(Exception e){
			map.put("success", false);
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 更新项目信息
	 * @param projectInfo
	 * @return
	 */
	@RequestMapping(value="updateSalProjectInfo")
	@ResponseBody
	@AnnotationLimit(mid="dkb",pid="dk")
	public JSONObject updateSalProjectInfo(SalProjectInfo projectInfo, @RequestParam("pic") MultipartFile[] pic){
		JSONObject jsonObject = new JSONObject();
		try{
			projectInfoService.updateSalProjectInfo(projectInfo, pic);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 删除项目信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteSalProjectInfoById")
	@ResponseBody
	@AnnotationLimit(mid="dkd",pid="dk")
	public JSONObject deleteSalProjectInfoById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			projectInfoService.deleteSalProjectInfoById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@RequestMapping("getPicIoById")
	@AnnotationLimit(mid="dk",pid="dd")
	public String getPicIoById(HttpServletResponse response, String id, boolean thumbnails){
		InputStream inputStream = null;
		SalProjectInfoPic projectInfoPic = projectInfoService.findSalProjectInfoPicById(id);
		if (projectInfoPic != null){
			try {
				String path;
				if (thumbnails){//缩略图
					path = ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo/thumbnails";
					
				}else{
					path = ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo";
				}
				
				
				File fileDir = new File(path);
				File file = new File(fileDir, id + projectInfoPic.getSuffix());
				
				inputStream = new FileInputStream(file);
				
				byte[] b = new byte[1024];
				int i = 0;
				while ((i = inputStream.read(b)) != -1) {
					response.getOutputStream().write(b, 0, i);
				}
			} catch (Exception e) {
				e.printStackTrace();
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
		return null;
	}
	
	/**
	 * 删除项目信息图片
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteSalProjectInfoPicById")
	@ResponseBody
	@AnnotationLimit(mid="dkc",pid="dk")
	public JSONObject deleteSalProjectInfoPicById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			projectInfoService.deleteSalProjectInfoPicById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 导入Excel到SalProjectInfo
	 * @param id
	 * @return
	 */
	@RequestMapping(value="importExcel")
	@ResponseBody
	@AnnotationLimit(mid="dke",pid="dk")
	public JSONObject importExcel(MultipartFile excel){
		JSONObject jsonObject = new JSONObject();
		try{
			int i = projectInfoService.insertListForImportExcel(excel);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("message", "成功导入" + i + "条记录");
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@RequestMapping("exportExcel")
	@AnnotationLimit(mid="dke",pid="dk")
	public void exportExcel(HttpServletResponse response){
		List<SalProjectInfo> list = projectInfoService.findAllProjectInfoListForExport();
		
		List<Map<String, List<Object>>> objData = new ArrayList<Map<String,List<Object>>>();
		int i = 1;
		for (SalProjectInfo projectInfo : list){
			List<Object> list2 = new ArrayList<Object>();
			list2.add(projectInfo.getWorkCardNo());
			list2.add(projectInfo.getYear());
			list2.add(projectInfo.getCountry());
			list2.add(projectInfo.getProvince());
			list2.add(projectInfo.getCity());
			list2.add(projectInfo.getIndustry());
			list2.add(projectInfo.getCustom());
			Map<String, List<Object>> map = new HashMap<String, List<Object>>();
			map.put(i+"", list2);
			objData.add(map);
			i++;
		}
		
		List<String> columns = new ArrayList<String>();
		columns.add("工咭号");
		columns.add("年");
		columns.add("国家");
		columns.add("省份");
		columns.add("市");
		columns.add("行业");
		columns.add("客户");
		
		List<Integer> columnsWidth = new ArrayList<Integer>();
		columnsWidth.add(10);
		columnsWidth.add(10);
		columnsWidth.add(10);
		columnsWidth.add(10);
		columnsWidth.add(15);
		columnsWidth.add(15);
		columnsWidth.add(30);
		
		//提供下载
		String filename = "工咭信息_" + new Date().toLocaleString()+".xls";
		//response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
		//response.setContentType(this.getServletContext().getMimeType(filename));
		JxlExcelUtils.exportexcle(response, filename, objData, "Sheet1", columns, columnsWidth);
	}
	
	@RequestMapping("insertPicByDirectory")
	@ResponseBody
	@AnnotationLimit(mid="dkf",pid="dk")
	public JSONObject insertPicByDirectory(){
		JSONObject jsonObject = new JSONObject();
		try{
			int i = projectInfoService.insertPicByDirectory();
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("data", i);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("errorMsg", e.getMessage());
		}
		return jsonObject;
	}
}