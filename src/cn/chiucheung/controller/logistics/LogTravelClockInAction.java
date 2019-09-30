package cn.chiucheung.controller.logistics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInQueryVo;
import cn.chiucheung.service.logistics.TravelClockInService;


@Controller
@RequestMapping("/logistics/travelClockIn")
public class LogTravelClockInAction {
	
	@Autowired
	private TravelClockInService clockInService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="hl",pid="hh")
	public String index(){
		return "logistics/travelClockIn";
	}
	
	/**
	 * 查询所有的差旅(APP)用户
	 * @param travelUser 查询条件
	 * @return
	 */
	@RequestMapping("findAllTravelClockInList")
	@ResponseBody
	@AnnotationLimit(mid="hl",pid="hh")
	public Map<String, Object> findAllTravelClockInList(LogTravelClockInQueryVo travelClockInQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<LogTravelUser> list = clockInService.findAllTravelClockInList(travelClockInQueryVo);
		String total = clockInService.findAllTravelClockInTotal(travelClockInQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	//时间类型转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
