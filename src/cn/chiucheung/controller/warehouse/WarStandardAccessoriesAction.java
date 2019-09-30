package cn.chiucheung.controller.warehouse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessories;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesFile;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;
import cn.chiucheung.service.warehouse.StandardAccessoriesService;
import cn.chiucheung.utils.ResourcesUtil;

@Controller
@RequestMapping("/warehouse/standardAccessories")
public class WarStandardAccessoriesAction {
	
	@Autowired
	private StandardAccessoriesService standardAccessoriesService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="ik",pid="ii")
	public String index(){
		return "warehouse/standardAccessories";
	}
	
	/**
	 * 根据条件查找所有的标准配件
	 * @param standardAccessoriesQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findAllWarStandardAccessoriesList")
	@ResponseBody
	@AnnotationLimit(mid="ik",pid="ii")
	public Map<String, Object> findAllWarStandardAccessoriesList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<WarStandardAccessoriesCustom> list = standardAccessoriesService.findAllWarStandardAccessoriesList(standardAccessoriesQueryVo);
		String total = standardAccessoriesService.findAllWarStandardAccessoriesTotal(standardAccessoriesQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 新增物料
	 * @param standardAccessories
	 * @param attachment
	 * @param session
	 * @return
	 */
	@RequestMapping("saveWarStandardAccessories")
	@ResponseBody
	@AnnotationLimit(mid="ika",pid="ik")
	public JSONObject saveWarStandardAccessories(WarStandardAccessories standardAccessories, MultipartFile attachment){
		JSONObject jsonObject = new JSONObject();
		try{
			standardAccessoriesService.saveWarStandardAccessories(standardAccessories,attachment);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 查看物料的附件
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("readFileById")
	@ResponseBody
	@AnnotationLimit(mid="ik",pid="ii")
	public String readFileById(String id, HttpServletRequest request, HttpServletResponse response){
		WarStandardAccessoriesFile standardAccessoriesFile = standardAccessoriesService.findfindWarStandardAccessoriesFileById(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/warStandardAccessories",standardAccessoriesFile.getFilePath());
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (FileNotFoundException e) {
			try {
				response.getWriter().write("file not found");
			} catch (IOException e1) {
				e1.printStackTrace();
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
		return null;
	}
	
	/**
	 * 根据id查找物料，用于页面的修改
	 * @param id
	 * @return
	 */
	@RequestMapping("findWarStandardAccessoriesByIdForEdit")
	@ResponseBody
	@AnnotationLimit(mid="ikb",pid="ik")
	public JSONObject findWarStandardAccessoriesByIdForEdit(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			WarStandardAccessories standardAccessories = standardAccessoriesService.findWarStandardAccessoriesByIdForEdit(id);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("standardAccessories", standardAccessories);
			WarStandardAccessoriesFile standardAccessoriesFile = standardAccessoriesService.findWarStandardAccessoriesFileByWarStandardAccessoriesId(id);
			if (standardAccessoriesFile != null){
				jsonObject.accumulate("standardAccessoriesFile", standardAccessoriesFile);
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 更新物料
	 * @param standardAccessories
	 * @param attachment
	 * @param session
	 * @return
	 */
	@RequestMapping("updateWarStandardAccessories")
	@ResponseBody
	@AnnotationLimit(mid="ikb",pid="ik")
	public JSONObject updateWarStandardAccessories(WarStandardAccessories standardAccessories, MultipartFile attachment){
		JSONObject jsonObject = new JSONObject();
		try{
			standardAccessoriesService.updateWarStandardAccessories(standardAccessories, attachment);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据standardAccessoriesFile的id删除WarStandardAccessoriesFile
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("deleteWarStandardAccessoriesFileById")
	@ResponseBody
	@AnnotationLimit(mid="ikc",pid="ik")
	public JSONObject deleteWarStandardAccessoriesFileById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			standardAccessoriesService.deleteWarStandardAccessoriesFileById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据id删除物料
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("deleteWarStandardAccessoriesById")
	@ResponseBody
	@AnnotationLimit(mid="ikc",pid="ik")
	public JSONObject deleteWarStandardAccessoriesById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			standardAccessoriesService.deleteWarStandardAccessoriesById(id);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
}
