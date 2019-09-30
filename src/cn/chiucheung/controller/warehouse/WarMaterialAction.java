package cn.chiucheung.controller.warehouse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.po.warehouse.material.WarMaterialFile;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.service.warehouse.MaterialService;
import cn.chiucheung.utils.ResourcesUtil;

@Controller
@RequestMapping("/warehouse/material")
public class WarMaterialAction {
	
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="eh",pid="ee")
	public String index(){
		return "warehouse/material";
	}
	
	/**
	 * 根据条件查找所有的物料
	 * @param materialQueryVo 查询条件
	 */
	@RequestMapping("findAllWarMaterialList")
	@ResponseBody
    @AnnotationLimit(mid="eh",pid="ee")
	public Object findAllWarMaterialList(WarMaterialQueryVo materialQueryVo){
		if (StringUtils.isNotBlank(materialQueryVo.getMaterialCodeForExpand())){
			return materialService.findAllWarMaterialList(materialQueryVo);
		}else{
			Map<String, Object> map = new HashMap<>();
			String total = materialService.findAllWarMaterialTotal(materialQueryVo);
			List<WarMaterial> list = materialService.findAllWarMaterialList(materialQueryVo);
			map.put("rows", list);
			map.put("total", total);
			map.put("query", materialQueryVo);
			return map;
		}
	}
	
	/**
	 * 新增物料
	 * @param material 物料信息
	 * @param attachment 关于物料的附属文件信息
	 */
	@RequestMapping("saveMaterial")
	@ResponseBody
	@AnnotationLimit(mid="eha",pid="eh")
	public JSONObject saveMaterial(WarMaterial material, MultipartFile attachment){
		JSONObject jsonObject = new JSONObject();
		try{
			String parentId = materialService.saveMaterial(material,attachment);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("parentId", parentId);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}

	/**
	 * 查看物料的附件
	 * @param id 物料文件Id
	 * @param response 响应
	 */
	@RequestMapping("readFileById")
	@ResponseBody
    @AnnotationLimit(mid="eh",pid="ee")
	public String readFileById(String id, HttpServletResponse response){
		WarMaterialFile materialFile = materialService.findMaterialFileById(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/material",materialFile.getFilePath());

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
	 * @param id 物料id
	 */
	@RequestMapping("findMaterialByIdForEdit")
	@ResponseBody
	@AnnotationLimit(mid="ehb",pid="eh")
	public Map<String, Object> findMaterialByIdForEdit(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			WarMaterial material = materialService.findMaterialByIdForEdit(id);
			map.put("success", true);
			map.put("material", material);
			WarMaterialFile materialFile = materialService.findMaterialFileByWarMaterialId(id);
			if (materialFile != null){
				map.put("materialFile", materialFile);
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}

	/**
	 * 根据id查找物料，用于页面的复制
	 * @param id 物料id
	 */
	@RequestMapping("findMaterialByIdForCopy")
	@ResponseBody
	@AnnotationLimit(mid="ehb",pid="eh")
	public Map<String, Object> findMaterialByIdForCopy(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			WarMaterial material = materialService.findMaterialByIdForEdit(id);
			map.put("success", true);
			map.put("material", material);
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}

	/**
	 * 更新物料
	 * @param material 物料信息
	 * @param attachment 物料文件信息
	 */
	@RequestMapping("updateMaterial")
	@ResponseBody
	@AnnotationLimit(mid="ehb",pid="eh")
	public JSONObject updateMaterial(WarMaterial material, MultipartFile attachment){
		JSONObject jsonObject = new JSONObject();
		try{
			String parentId = materialService.updateWarMaterial(material, attachment);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("parentId", parentId);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}

	/**
	 * 根据materialFile的id删除WarMaterialFile
	 * @param id 物料文件id
	 */
	@RequestMapping("deleteWarMaterialFileById")
	@ResponseBody
	@AnnotationLimit(mid="ehc",pid="eh")
	public JSONObject deleteWarMaterialFileById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			materialService.deleteWarMaterialFileById(id);
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
	 * @param id 物料id
	 */
	@RequestMapping("deleteWarMaterialById")
	@ResponseBody
	@AnnotationLimit(mid="ehc",pid="eh")
	public JSONObject deleteWarMaterialById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			materialService.deleteWarMaterialById(id);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
}
