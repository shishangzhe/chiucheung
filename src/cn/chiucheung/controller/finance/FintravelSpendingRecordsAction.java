package cn.chiucheung.controller.finance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustom;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsQueryVo;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsSubsidiaryCustom;
import cn.chiucheung.service.logistics.TravelSpendingRecordsService;
import cn.chiucheung.service.logistics.TravelUserService;

@Controller
@RequestMapping("/finance/travelSpendingRecords")
public class FintravelSpendingRecordsAction {
	@Autowired
	private TravelSpendingRecordsService travelSpendingRecordsService;
	
	@Autowired
	private TravelUserService travelUserService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="gj",pid="gg")
	public String index(){
		return "finance/travelSpendingRecords";
	}
	
	/**
	 * 根据查询条件查询所有的差旅记录表
	 * @param travelSpendingRecordsQueryVo
	 * @return
	 */
	@RequestMapping("findAllTravelSpendingRecords")
	@ResponseBody
	@AnnotationLimit(mid="gj",pid="gg")
	public Map<String, Object> findAllTravelSpendingRecords(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		travelSpendingRecordsQueryVo.setIsNull(false);
		List<LogTravelSpendingRecordsCustom> list = travelSpendingRecordsService.findAllTravelSpendingRecordsList(travelSpendingRecordsQueryVo);
		String total = travelSpendingRecordsService.findAllTravelSpendingRecordsTotal(travelSpendingRecordsQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 用于页面的数据展开
	 * @param id
	 * @return
	 */
	@RequestMapping("findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId")
	@ResponseBody
	@AnnotationLimit(mid="gj",pid="gg")
	public List<LogTravelSpendingRecordsSubsidiaryCustom> findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(String id){
		return travelSpendingRecordsService.findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(id);
	}
	
	/**
	 * 根据workCardNo计算出差的成本
	 * @param workCardNo
	 * @return
	 */
	@RequestMapping("calculateCostByWorkCardNo")
	@ResponseBody
	@AnnotationLimit(mid="gja",pid="gj")
	public JSONObject calculateCostByWorkCardNo(String workCardNo){
		JSONObject jsonObject = new JSONObject();
		try{
			String results = travelSpendingRecordsService.calculateCostByWorkCardNo(workCardNo);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("results", results);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	
	//时间类型转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
