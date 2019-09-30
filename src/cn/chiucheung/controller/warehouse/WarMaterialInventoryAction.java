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

import cn.chiucheung.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.warehouse.material.WarMaterialFile;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesFile;
import cn.chiucheung.pojo.warehouse.material.WarMaterialInventoryCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesInventoryCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;
import cn.chiucheung.service.warehouse.MaterialInventoryService;
import cn.chiucheung.service.warehouse.MaterialService;
import cn.chiucheung.utils.ResourcesUtil;

@Controller
@RequestMapping("/warehouse/materialInventory")
public class WarMaterialInventoryAction {
	
	@Autowired
	MaterialInventoryService materialInventoryService;
	
	@Autowired
	MaterialService materialService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="il",pid="ii")
	public String index(){
		return "warehouse/materialInventory";
	}
	
	/**
	 * 查找所有的物料库存
	 * @param materialQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findAllWarMaterialInventoryList")
	@ResponseBody
	@AnnotationLimit(mid="il",pid="ii")
	public Map<String, Object> findAllWarMaterialInventoryList(WarMaterialQueryVo materialQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<WarMaterialInventoryCustom> list = materialInventoryService.findAllWarMaterialInventoryList(materialQueryVo);
		String total = materialInventoryService.findAllWarMaterialInventoryTotal(materialQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 根据materialFile的id查询附件
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("readFileById")
	@ResponseBody
	@AnnotationLimit(mid="il",pid="ii")
	public void readFileById(String id, HttpServletRequest request, HttpServletResponse response){
		WarMaterialFile materialFile = materialService.findMaterialFileById(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/material",materialFile.getFilePath());
        FileUtils.downloadFile(response, file);
	}
}
