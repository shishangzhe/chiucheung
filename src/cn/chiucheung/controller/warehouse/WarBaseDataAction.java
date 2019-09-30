package cn.chiucheung.controller.warehouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.warehouse.basedata.WarBaseData;
import cn.chiucheung.service.warehouse.BaseDataService;

@Controller
@RequestMapping("/warehouse/baseData")
public class WarBaseDataAction {
	
	@Autowired
	BaseDataService baseDataService;
	
	/**
	 * 页面的跳转
	 * @return
	 */
	@RequestMapping("index")
	@AnnotationLimit(mid="ij",pid="ii")
	public String index(){
		return "warehouse/baseData";
	}
	
	/**
	 * 加载类型的下拉列表框的数据
	 * @return
	 */
	@RequestMapping("findAllKeywordByDistinct")
	@ResponseBody
	public List<WarBaseData> findAllKeywordByDistinct(){
		return baseDataService.findAllKeywordByDistinct();
	}
	
	/**
	 * 下拉选择了数据，表格根据该选择项加载的数据
	 * @param keyword
	 * @return
	 */
	@RequestMapping("findAllWarBaseDataByKeyword")
	@ResponseBody
	public List<WarBaseData> findAllWarBaseDataByKeyword(String keyword){
		return baseDataService.findAllWarBaseDataByKeyword(keyword);
	}
	
	/**
	 * 对该类型进行查找，是否存在，用于前台校验
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value="checkKeywordIsRepeat")
	@ResponseBody
	@AnnotationLimit(mid="ija",pid="ij")
	public String checkKeywordIsRepeat(String keyword){
		List<WarBaseData> list = baseDataService.findAllWarBaseDataByKeyword(keyword);
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
	 * @param baseData
	 * @return
	 */
	@RequestMapping(value="saveWarBaseData",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="ija",pid="ij")
	public String saveWarBaseData(WarBaseData baseData){
		try{
			baseDataService.saveWarBaseData(baseData);
			return "保存成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 更新数据字典
	 * @param baseData
	 * @return
	 */
	@RequestMapping(value="updateWarBaseData",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="ijb",pid="ij")
	public String updateWarBaseData(WarBaseData baseData){
		try{
			baseDataService.updateWarBaseData(baseData);
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
	@RequestMapping(value="deleteWarBaseDataById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="ijc",pid="ij")
	public String deleteWarBaseDataById(String id){
		try{
			baseDataService.deleteWarBaseDataById(id);
			return "删除成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"删除失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
}
