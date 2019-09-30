package cn.chiucheung.controller.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.purchase.material.PurMaterialBaseData;
import cn.chiucheung.po.system.dictionarie.SysDictionarie;
import cn.chiucheung.pojo.purchase.material.PurMaterialBaseDataCustom;
import cn.chiucheung.service.purchase.MaterialBaseDataService;
import cn.chiucheung.service.system.DictionarieService;

@Controller
@RequestMapping("/purchase/materialBaseData")
public class PurMaterialBaseDataAction {
	
	@Autowired
	MaterialBaseDataService materialBaseDataService;
	
	/**
	 * 页面的跳转
	 * @return
	 */
	@RequestMapping("index")
	@AnnotationLimit(mid="eg",pid="ee")
	public String index(){
		return "purchase/materialBaseData";
	}
	
	/**
	 * 加载类型的下拉列表框的数据
	 * @return
	 */
	@RequestMapping("findAllKeywordByDistinct")
	@ResponseBody
	public List<PurMaterialBaseData> findAllKeywordByDistinct(){
		return materialBaseDataService.findAllKeywordByDistinct();
	}
	
	/**
	 * 下拉选择了数据，表格根据该选择项加载的数据
	 * @param keyword
	 * @return
	 */
	@RequestMapping("findAllPurMaterialBaseDataByKeyword")
	@ResponseBody
	public List<PurMaterialBaseData> findAllPurMaterialBaseDataByKeyword(String keyword){
		return materialBaseDataService.findAllPurMaterialBaseDataByKeyword(keyword);
	}
	
	/**
	 * 下拉选择了数据，表格根据该选择项加载的数据
	 * @param keyword
	 * @return
	 */
	@RequestMapping("findAllPurMaterialBaseDataByKeywordForDensity")
	@ResponseBody
	public List<PurMaterialBaseDataCustom> findAllPurMaterialBaseDataByKeywordForDensity(){
		return materialBaseDataService.findAllPurMaterialBaseDataByKeywordForDensity();
	}
	
	/**
	 * 对该类型进行查找，是否存在，用于前台校验
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value="checkKeywordIsRepeat")
	@ResponseBody
	public String checkKeywordIsRepeat(String keyword){
		List<PurMaterialBaseData> list = materialBaseDataService.findAllPurMaterialBaseDataByKeyword(keyword);
		String message = "";
		if (list != null && list.size()>0){
			message = "no";
		}else{
			message = "ok";
		}
		return message;
	}
	
	/**
	 * 新增数据字典
	 * @param dictionarie
	 * @return
	 */
	@RequestMapping(value="savePurMaterialBaseData",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="ega",pid="eg")
	public String savePurMaterialBaseData(PurMaterialBaseData materialBaseData){
		try{
			materialBaseDataService.savePurMaterialBaseData(materialBaseData);
			return "保存成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 更新数据字典
	 * @param dictionarie
	 * @return
	 */
	@RequestMapping(value="updatePurMaterialBaseData",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="egb",pid="eg")
	public String updatePurMaterialBaseData(PurMaterialBaseData materialBaseData){
		try{
			materialBaseDataService.updatePurMaterialBaseData(materialBaseData);
			return "保存成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 根据id删除数据字典
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deletePurMaterialBaseDataById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="egc",pid="eg")
	public String deletePurMaterialBaseDataById(String id){
		try{
			materialBaseDataService.deletePurMaterialBaseDataById(id);
			return "删除成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"删除失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
}
