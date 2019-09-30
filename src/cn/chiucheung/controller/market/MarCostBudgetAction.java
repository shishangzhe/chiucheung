package cn.chiucheung.controller.market;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.market.costbudget.MarCostBudget;
import cn.chiucheung.po.purchase.material.PurMaterial;
import cn.chiucheung.pojo.market.costbudget.MarCostBudgetCustom;
import cn.chiucheung.pojo.market.costbudget.MarCostBudgetVo;
import cn.chiucheung.pojo.purchase.material.PurMaterialQueryVo;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerCustom;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerQueryVo;
import cn.chiucheung.service.market.CostBudgetService;
import cn.chiucheung.service.purchase.MaterialService;
import cn.chiucheung.service.sales.ReviewerService;
import cn.chiucheung.utils.JxlExcelUtils;

@Controller
@RequestMapping("/market/costBudget")
public class MarCostBudgetAction {
	
	@Autowired
	private CostBudgetService costBudgetService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private ReviewerService reviewerService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="fg",pid="ff")
	public String index(){
		return "market/costBudget";
	}
	
	
	
	/**
	 * 查询所有的成本核算表
	 * @return
	 */
	@RequestMapping("findAllCostBudgetList")
	@ResponseBody
	@AnnotationLimit(mid="fg",pid="ff")
	public Map<String, Object> findAllCostBudgetList(MarCostBudgetVo costBudgetVo){
		return costBudgetService.findAllCostBudgetList(costBudgetVo);
	}
	
	
	/**
	 * 查询所有的物料
	 * @return
	 */
	@RequestMapping("findAllPurMaterialList")
	@ResponseBody
	@AnnotationLimit(mid="fg",pid="ff")
	public Map<String, Object> findAllPurMaterialList(PurMaterialQueryVo materialQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<PurMaterial> materials = materialService.findAllPurMaterialList(materialQueryVo);
		String total  = materialService.findAllPurMaterialTotal(materialQueryVo);
		map.put("total", total);
		map.put("rows", materials);
		return map;
	}
	
	
	
	/**
	 * 保存成本分析表
	 * @param map
	 * @return
	 */
	@RequestMapping(value="saveCostBudget",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="fga",pid="fg")
	public String saveCostBudget(@RequestBody Map<String, Object> map){
		try{
			costBudgetService.saveCostBudget(map);
			return "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
	/**
	 * 根据id查找CoistBudget，用于前台数据的编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("findCostBudgetByIdForEdit")
	@ResponseBody
	@AnnotationLimit(mid="fgb",pid="fg")
	public Map<String, Object> findCostBudgetByIdForEdit(String id){
		return costBudgetService.findCostBudgetById(id);
	}
	
	
	
	/**
	 * 更新成本分析表
	 * @param map
	 * @return
	 */
	@RequestMapping(value="updateCostBudget",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="fgb",pid="fg")
	public String updateCostBudget(@RequestBody Map<String, Object> map){
		try{
			costBudgetService.updateCostBudget(map);
			return "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
	
	/**
	 * 根据id删除成本分析表
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteCostBudgetById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="fgc",pid="fg")
	public String deleteCostBudgetById(String id){
		try{
			costBudgetService.deleteCostBudgetById(id);
			return "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"删除失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
	
	/**
	 * 根据id查找成本核算表，用于判断当前是否关联项目评审表
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findCostBudgetByIdForAssociated")
	@ResponseBody
	@AnnotationLimit(mid="fge",pid="fg")
	public MarCostBudget findCostBudgetByIdForAssociated(String id){
		return costBudgetService.findCostBudgetByIdForAssociated(id);
	}
	
	
	/**
	 * 查找已完全评审的项目评审表-成本核算
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findCompleteReviewerCostCollect")
	@ResponseBody
	@AnnotationLimit(mid="fge",pid="fg")
	public List<SalReviewerCustom> findCompleteReviewerCostCollect(SalReviewerQueryVo reviewerQueryVo){
		reviewerQueryVo.setIsCost(true);//查找成本核算
		return reviewerService.findCompleteReviewerCostCollect(reviewerQueryVo);
	}
	
	/**
	 * 关联
	 * @param id
	 * @return
	 */
	@RequestMapping(value="associatedCostBudgetById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="fge",pid="fg")
	public String associatedCostBudgetById(String id, String salReviewerId){
		try{
			costBudgetService.updateCostBudgetByIdForAssociated(id, salReviewerId);
			return "关联成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"关联失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 取消关联
	 * @param id
	 * @return
	 */
	@RequestMapping(value="cancelAssociatedCostBudgetById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="fgf",pid="fg")
	public String cancelAssociatedCostBudgetById(String id){
		try{
			costBudgetService.updateCostBudgetByIdForCancelAssociated(id);
			return "取消关联成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"取消关联失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
	/**
	 * 导出报表
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping(value="exportingReport")
	@ResponseBody
	@AnnotationLimit(mid="fgg",pid="fg")
	public String exportingReport(MarCostBudgetVo costBudgetVo, HttpServletResponse response){
		List<MarCostBudgetCustom> costBudgetCustoms = costBudgetService.findCxportingReportDatas(costBudgetVo);
		
		List<Map<String, List<Object>>> objData = new ArrayList<Map<String,List<Object>>>();
		int i = 1;
		for (MarCostBudgetCustom costBudgetCustom : costBudgetCustoms){
			List<Object> list = new ArrayList<Object>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			list.add(costBudgetCustom.getQuotationNo());
			list.add(dateFormat.format(costBudgetCustom.getEndTime()));
			list.add(costBudgetCustom.getProjectLeader());
			list.add("");
			list.add("");
			list.add(costBudgetCustom.getCustomerName());
			list.add(costBudgetCustom.getProductName());
			list.add(costBudgetCustom.getPeripheralSize());
			list.add(costBudgetCustom.getTotalNumber());
			list.add(costBudgetCustom.getUnitPrice());
			list.add(costBudgetCustom.getTotalPrice());
			list.add(dateFormat.format(costBudgetCustom.getSubmitTime()));
			list.add(costBudgetCustom.getPreparer());
			list.add(costBudgetCustom.getReviewer());
			list.add("");
			list.add("");
			Map<String, List<Object>> map = new HashMap<String, List<Object>>();
			map.put(i+"", list);
			objData.add(map);
			i++;
		}
		
		List<String> columns = new ArrayList<String>();
		columns.add("报价单号");
		columns.add("接到报价\r\n单日期");
		columns.add("项目\r\n负责人");
		columns.add("工咭号");
		columns.add("下单日期");
		columns.add("客户名称");
		columns.add("项目名称");
		columns.add("外围尺寸");
		columns.add("数量\r\n（套）");
		columns.add("单位估算值\r\n(￥)");
		columns.add("总估算值(￥)");
		columns.add("报出日期");
		columns.add("作\r\n成\r\n\r\n人");
		columns.add("审\r\n核");
		columns.add("备\r\n注");
		columns.add("销售反馈");
		
		List<Integer> columnsWidth = new ArrayList<Integer>();
		columnsWidth.add(15);
		columnsWidth.add(15);
		columnsWidth.add(15);
		columnsWidth.add(15);
		columnsWidth.add(15);
		columnsWidth.add(15);
		columnsWidth.add(30);
		columnsWidth.add(20);
		columnsWidth.add(8);
		columnsWidth.add(15);
		columnsWidth.add(15);
		columnsWidth.add(15);
		columnsWidth.add(10);
		columnsWidth.add(5);
		columnsWidth.add(5);
		columnsWidth.add(10);
		
		//提供下载
		String filename = "项目估算统计报表"+".xls";
		//response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
		//response.setContentType(this.getServletContext().getMimeType(filename));
		JxlExcelUtils.exportexcle(response, filename, objData, "Sheet1", columns, columnsWidth);
		return null;
	}
	
	
	
	
	/**
	 * 根据id查找CoistBudget，用于前台数据的复制
	 * @param id
	 * @return
	 */
	@RequestMapping("findCostBudgetByIdForCopyData")
	@ResponseBody
	@AnnotationLimit(mid="fgd",pid="fg")
	public Map<String, Object> findCostBudgetByIdForCopyData(String id,Boolean flag){
		return costBudgetService.findCostBudgetByIdForCopyData(id, flag);
	}
	
	
	//时间类型转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
