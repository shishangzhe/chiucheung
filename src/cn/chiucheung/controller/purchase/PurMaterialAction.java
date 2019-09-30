package cn.chiucheung.controller.purchase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.purchase.material.PurMaterial;
import cn.chiucheung.po.system.dictionarie.SysDictionarie;
import cn.chiucheung.pojo.purchase.material.PurMaterialQueryVo;
import cn.chiucheung.service.purchase.MaterialService;

@Controller
@RequestMapping("/purchase/material")
public class PurMaterialAction {
	
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping("index")
	@AnnotationLimit(pid="ee",mid="ef")
	public String index(){
		return "purchase/material";
	}
	
	
	/**
	 * 查找所有的物料
	 * @param materialQueryVo
	 * @return
	 */
	@RequestMapping("findAllPurMaterialList")
	@ResponseBody
	@AnnotationLimit(pid="ee",mid="ef")
	public Map<String, Object> findAllPurMaterialList(PurMaterialQueryVo materialQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<PurMaterial> materials = materialService.findAllPurMaterialList(materialQueryVo);
		String total  = materialService.findAllPurMaterialTotal(materialQueryVo);
		map.put("total", total);
		map.put("rows", materials);
		return map;
	}
	
	/**
	 * 新增物料
	 * @param material
	 * @return
	 */
	@RequestMapping(value="savePurMaterial",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(pid="ef",mid="efa")
	public String savePurMaterial(PurMaterial material){
		try{
			materialService.savePurMaterial(material);
			return "保存成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 根据id查找物料
	 * @param id
	 * @return
	 */
	@RequestMapping("findPurMaterialById")
	@ResponseBody
	@AnnotationLimit(pid="ef",mid="efb")
	public PurMaterial findPurMaterialById(String id){
		return materialService.findPurMaterialById(id);
	}
	
	
	/**
	 * 更新物料
	 * @param material
	 * @return
	 */
	@RequestMapping(value="updatePurMaterial",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(pid="ef",mid="efc")
	public String updatePurMaterial(PurMaterial material){
		try{
			materialService.updatePurMaterial(material);
			return "保存成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
	/**
	 * 根据id删除物料
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deletePurMaterialById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(pid="ef",mid="efc")
	public String deletePurMaterialById(String id){
		try{
			materialService.deletePurMaterialById(id);
			return "删除成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"删除失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
}
