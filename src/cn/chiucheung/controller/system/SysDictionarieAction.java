package cn.chiucheung.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.system.dictionarie.SysDictionarie;
import cn.chiucheung.service.system.DictionarieService;

@Controller
@RequestMapping("/system/dictionarie")
public class SysDictionarieAction {
	
	@Autowired
	DictionarieService dictionarieService;
	
	/**
	 * 页面的跳转
	 * @return
	 */
	@RequestMapping("index")
	@AnnotationLimit(mid="bd",pid="bb")
	public String index(){
		return "system/dictionarie";
	}
	
	/**
	 * 加载类型的下拉列表框的数据
	 * @return
	 */
	@RequestMapping("findAllKeywordByDistinct")
	@ResponseBody
	public List<SysDictionarie> findAllKeywordByDistinct(){
		return dictionarieService.findAllKeywordByDistinct();
	}
	
	/**
	 * 下拉选择了数据，表格根据该选择项加载的数据
	 * @param keyword
	 * @return
	 */
	@RequestMapping("findAllDictionarieByKeyword")
	@ResponseBody
	public List<SysDictionarie> findAllDictionarieByKeyword(String keyword){
		return dictionarieService.findAllDictionarieByKeyword(keyword);
	}
	
	/**
	 * 对该类型进行查找，是否存在，用于前台校验
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value="checkKeywordIsRepeat")
	@ResponseBody
	@AnnotationLimit(mid="bda",pid="bd")
	public String checkKeywordIsRepeat(String keyword){
		List<SysDictionarie> list = dictionarieService.findAllDictionarieByKeyword(keyword);
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
	@RequestMapping(value="saveSysDictionarie",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bda",pid="bd")
	public String saveSysDictionarie(SysDictionarie dictionarie){
		try{
			dictionarieService.saveSysDictionarie(dictionarie);
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
	@RequestMapping(value="updateSysDictionarie",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bdb",pid="bd")
	public String updateSysDictionarie(SysDictionarie dictionarie){
		try{
			dictionarieService.updateSysDictionarie(dictionarie);
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
	@RequestMapping(value="deleteSysDictionarieById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bdc",pid="bd")
	public String deleteSysDictionarieById(String id){
		try{
			dictionarieService.deleteSysDictionarieById(id);
			return "删除成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"删除失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
}
