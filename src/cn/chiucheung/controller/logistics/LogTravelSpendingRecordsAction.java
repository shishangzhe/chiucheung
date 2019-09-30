package cn.chiucheung.controller.logistics;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.pojo.finance.checksheet.FinExportExcelForCheckSheetCustom;
import cn.chiucheung.pojo.finance.checksheet.LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet;
import cn.chiucheung.pojo.logistics.travelUser.LogTravelUserQueryVo;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustom;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForExportExcelForMealsNumber;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForExportExcelForWorkHour;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsQueryVo;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsSubsidiaryCustom;
import cn.chiucheung.service.logistics.TravelSpendingRecordsService;
import cn.chiucheung.service.logistics.TravelUserService;
import cn.chiucheung.utils.UUIDBuild;



@Controller
@RequestMapping("/logistics/travelSpendingRecords")
public class LogTravelSpendingRecordsAction {
	
	@Autowired
	private TravelSpendingRecordsService travelSpendingRecordsService;
	
	@Autowired
	private TravelUserService travelUserService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="hj",pid="hh")
	public String index(){
		return "logistics/travelSpendingRecords";
	}
	
	/**
	 * 根据查询条件查询所有的差旅记录表
	 * @param travelSpendingRecordsQueryVo
	 * @return
	 */
	@RequestMapping("findAllTravelSpendingRecords")
	@ResponseBody
	@AnnotationLimit(mid="hj",pid="hh")
	public Map<String, Object> findAllTravelSpendingRecords(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		travelSpendingRecordsQueryVo.setIsNull(true);
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
	@AnnotationLimit(mid="hj",pid="hh")
	public List<LogTravelSpendingRecordsSubsidiaryCustom> findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(String id){
		return travelSpendingRecordsService.findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(id);
	}
	
	/**
	 * 新增页面的查找差旅(APP)用户
	 * @param travelUser
	 * @return
	 */
	@RequestMapping("findAllTravelUserList")
	@ResponseBody
	@AnnotationLimit(mid="hj",pid="hh")
	public Map<String, Object> findAllTravelUserList(LogTravelUserQueryVo travelUserQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<LogTravelUser> list = travelUserService.findAllTravelUserList(travelUserQueryVo);
		String total = travelUserService.findAllTravelUserTotal(travelUserQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 新增差旅记录表
	 * @param travelSpendingRecordsCustom
	 * @return
	 */
	@RequestMapping("saveTravelSpendingRecords")
	@ResponseBody
	@AnnotationLimit(mid="hja",pid="hj")
	public JSONObject saveTravelSpendingRecords(LogTravelSpendingRecordsCustom travelSpendingRecordsCustom){
		JSONObject jsonObject = new JSONObject();
		try{
			travelSpendingRecordsService.saveTravelSpendingRecords(travelSpendingRecordsCustom);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id查找差旅记录表，用于页面的数据修改
	 * @param id
	 * @return
	 */
	@RequestMapping("findTravelSpendingRecordsById")
	@ResponseBody
	@AnnotationLimit(mid="hjb",pid="hj")
	public Map<String, Object> findTravelSpendingRecordsById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
				LogTravelSpendingRecordsCustom travelSpendingRecordsCustom = travelSpendingRecordsService.findTravelSpendingRecordsByIdForEdit(id);
				map.put("success", true);
				map.put("travelSpendingRecordsCustom", travelSpendingRecordsCustom);
		}catch(Exception e){
			map.put("success", false);
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 更新差旅记录表
	 * @param travelSpendingRecordsCustom
	 * @return
	 */
	@RequestMapping("updateTravelSpendingRecords")
	@ResponseBody
	@AnnotationLimit(mid="hjb",pid="hj")
	public JSONObject updateTravelSpendingRecords(LogTravelSpendingRecordsCustom travelSpendingRecordsCustom){
		JSONObject jsonObject = new JSONObject();
		try{
			travelSpendingRecordsService.updateTravelSpendingRecords(travelSpendingRecordsCustom);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id删除差旅记录表
	 * @param travelUser
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteTravelSpendingRecordsById")
	@ResponseBody
	@AnnotationLimit(mid="hjc",pid="hj")
	public JSONObject deleteTravelSpendingRecordsById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			travelSpendingRecordsService.deleteTravelSpendingRecordsById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id查找差旅记录表，用于页面的数据复制
	 * @param id
	 * @return
	 */
	@RequestMapping("findTravelSpendingRecordsByIdForCopyData")
	@ResponseBody
	@AnnotationLimit(mid="hja",pid="hj")
	public Map<String, Object> findTravelSpendingRecordsByIdForCopyData(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
				LogTravelSpendingRecordsCustom travelSpendingRecordsCustom = travelSpendingRecordsService.findTravelSpendingRecordsByIdForCopyData(id);
				map.put("success", true);
				map.put("travelSpendingRecordsCustom", travelSpendingRecordsCustom);
		}catch(Exception e){
			map.put("success", false);
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	

	
	/**
	 * 生成报账单
	 * @param travelSpendingRecordsQueryVo
	 * @param applicant
	 * @return
	 */
	@RequestMapping("generateCheckSheet")
	@ResponseBody
	@AnnotationLimit(mid="hjd",pid="hj")
	public JSONObject generateCheckSheet(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo, String applicant){
		JSONObject jsonObject = new JSONObject();
		try{
			String checkSheetNo = travelSpendingRecordsService.generateCheckSheet(travelSpendingRecordsQueryVo,applicant);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("checkSheetNo", checkSheetNo);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 导出工时
	 * @param request
	 * @param response
	 * @param travelSpendingRecordsQueryVo
	 * @return
	 */
	@RequestMapping("exportExcelForWorkHour")
	@ResponseBody
	@AnnotationLimit(mid="hje",pid="hj")
	public String exportExcelForWorkHour(HttpServletRequest request, HttpServletResponse response, LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo){
		try {
			File file = new File(request.getSession().getServletContext().getRealPath("WEB-INF"),"template/出差考勤表.xls");
			List<LogTravelSpendingRecordsCustomForExportExcelForWorkHour> list = travelSpendingRecordsService.findDataForExportExcelForWorkHour(travelSpendingRecordsQueryVo);
			
			String filename = "出差考勤表" + new Date().toLocaleString()+".xls";
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			
			POIFSFileSystem pfs = new POIFSFileSystem(new FileInputStream(file));
			HSSFWorkbook wb = new HSSFWorkbook(pfs);
			HSSFSheet sheet = wb.getSheetAt(0);
			if (list != null && list.size() > 0){
				HSSFRow sourceRow = sheet.getRow(5);
				for (int i=0; i<list.size(); i++){
					if (i == 0){
						sourceRow.getCell(0).setCellValue(list.get(i).getTravelDate());
						sourceRow.getCell(1).setCellValue(list.get(i).getWorkNo());
						sourceRow.getCell(2).setCellValue(list.get(i).getUsername());
						sourceRow.getCell(3).setCellValue(list.get(i).getWorkCardNo());
						sourceRow.getCell(4).setCellValue(list.get(i).getStartTime1());
						sourceRow.getCell(5).setCellValue(list.get(i).getEndTime1());
						sourceRow.getCell(6).setCellValue(list.get(i).getStartTime2());
						sourceRow.getCell(7).setCellValue(list.get(i).getEndTime2());
						sourceRow.getCell(8).setCellValue(list.get(i).getStartTime3());
						sourceRow.getCell(9).setCellValue(list.get(i).getEndTime3());
						sourceRow.getCell(11).setCellValue(list.get(i).getMorning());
						sourceRow.getCell(12).setCellValue(list.get(i).getAfternoon());
						sourceRow.getCell(13).setCellValue(list.get(i).getEvening());
						sourceRow.getCell(14).setCellValue(list.get(i).getCount());
					}else{
						sheet.shiftRows(5+i, sheet.getLastRowNum(), 1,true,false);
						HSSFRow targetRow = sheet.getRow(5+i);
						targetRow.setHeightInPoints(20);
						for (int j=0;j<sourceRow.getPhysicalNumberOfCells();j++){
							HSSFCell sourceCell = sourceRow.getCell(j);
							HSSFCell cell = targetRow.createCell(j);
							cell.setCellStyle(sourceCell.getCellStyle());
						}
						targetRow.getCell(0).setCellValue(list.get(i).getTravelDate());
						targetRow.getCell(1).setCellValue(list.get(i).getWorkNo());
						targetRow.getCell(2).setCellValue(list.get(i).getUsername());
						targetRow.getCell(3).setCellValue(list.get(i).getWorkCardNo());
						targetRow.getCell(4).setCellValue(list.get(i).getStartTime1());
						targetRow.getCell(5).setCellValue(list.get(i).getEndTime1());
						targetRow.getCell(6).setCellValue(list.get(i).getStartTime2());
						targetRow.getCell(7).setCellValue(list.get(i).getEndTime2());
						targetRow.getCell(8).setCellValue(list.get(i).getStartTime3());
						targetRow.getCell(9).setCellValue(list.get(i).getEndTime3());
						targetRow.getCell(11).setCellValue(list.get(i).getMorning());
						targetRow.getCell(12).setCellValue(list.get(i).getAfternoon());
						targetRow.getCell(13).setCellValue(list.get(i).getEvening());
						targetRow.getCell(14).setCellValue(list.get(i).getCount());
					}
				}
			}
			//锁定
			sheet.protectSheet(UUIDBuild.getUUID());
			
			wb.write(response.getOutputStream());
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 导出餐次
	 * @param request
	 * @param response
	 * @param travelSpendingRecordsQueryVo
	 * @return
	 */
	@RequestMapping("exportExcelForMealsNumber")
	@ResponseBody
	@AnnotationLimit(mid="hje",pid="hj")
	public String exportExcelForMealsNumber(HttpServletRequest request, HttpServletResponse response, LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo){
		try {
			List<LogTravelSpendingRecordsCustomForExportExcelForMealsNumber> list = travelSpendingRecordsService.findDataForExportExcelForMealsNumber(travelSpendingRecordsQueryVo);
			
			String filename = "餐次" + new Date().toLocaleString()+".xls";
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow rowTitle = sheet.createRow(0);
			rowTitle.createCell(0).setCellValue("姓名");
			rowTitle.createCell(1).setCellValue("午餐");
			rowTitle.createCell(2).setCellValue("晚餐");
			
			if (list != null && list.size() > 0){
				for (int i=0; i<list.size(); i++){
					HSSFRow row = sheet.createRow(i+1);
					row.createCell(0).setCellValue(list.get(i).getUsername());
					row.createCell(1).setCellValue(list.get(i).getLunchNumber());
					row.createCell(2).setCellValue(list.get(i).getDinnerNumber());
				}
			}
			wb.write(response.getOutputStream());
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 根据工咭、分组统计工时和人数（作废）
	 * @param request
	 * @param response
	 * @param travelSpendingRecordsQueryVo
	 * @return
	 */
	@RequestMapping("exportExcelForStatisticsWorkHours")
	@ResponseBody
	@AnnotationLimit(mid="hje",pid="hj")
	public String exportExcelForStatisticsWorkHours(HttpServletRequest request, HttpServletResponse response, LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo){
		try {
			File file = new File(request.getSession().getServletContext().getRealPath("WEB-INF"),"template/出差考勤表.xls");
			List<LogTravelSpendingRecordsCustomForExportExcelForWorkHour> list = travelSpendingRecordsService.findDataForExportExcelForWorkHour(travelSpendingRecordsQueryVo);
			
			String filename = "出差考勤表" + new Date().toLocaleString()+".xls";
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			
			POIFSFileSystem pfs = new POIFSFileSystem(new FileInputStream(file));
			HSSFWorkbook wb = new HSSFWorkbook(pfs);
			HSSFSheet sheet = wb.getSheetAt(0);
			if (list != null && list.size() > 0){
				HSSFRow sourceRow = sheet.getRow(5);
				for (int i=0; i<list.size(); i++){
					if (i == 0){
						sourceRow.getCell(0).setCellValue(list.get(i).getTravelDate());
						sourceRow.getCell(1).setCellValue(list.get(i).getWorkNo());
						sourceRow.getCell(2).setCellValue(list.get(i).getUsername());
						sourceRow.getCell(3).setCellValue(list.get(i).getWorkCardNo());
						sourceRow.getCell(4).setCellValue(list.get(i).getStartTime1());
						sourceRow.getCell(5).setCellValue(list.get(i).getEndTime1());
						sourceRow.getCell(6).setCellValue(list.get(i).getStartTime2());
						sourceRow.getCell(7).setCellValue(list.get(i).getEndTime2());
						sourceRow.getCell(8).setCellValue(list.get(i).getStartTime3());
						sourceRow.getCell(9).setCellValue(list.get(i).getEndTime3());
						sourceRow.getCell(11).setCellValue(list.get(i).getMorning());
						sourceRow.getCell(12).setCellValue(list.get(i).getAfternoon());
						sourceRow.getCell(13).setCellValue(list.get(i).getEvening());
						sourceRow.getCell(14).setCellValue(list.get(i).getCount());
					}else{
						sheet.shiftRows(5+i, sheet.getLastRowNum(), 1,true,false);
						HSSFRow targetRow = sheet.getRow(5+i);
						targetRow.setHeightInPoints(20);
						for (int j=0;j<sourceRow.getPhysicalNumberOfCells();j++){
							HSSFCell sourceCell = sourceRow.getCell(j);
							HSSFCell cell = targetRow.createCell(j);
							cell.setCellStyle(sourceCell.getCellStyle());
						}
						targetRow.getCell(0).setCellValue(list.get(i).getTravelDate());
						targetRow.getCell(1).setCellValue(list.get(i).getWorkNo());
						targetRow.getCell(2).setCellValue(list.get(i).getUsername());
						targetRow.getCell(3).setCellValue(list.get(i).getWorkCardNo());
						targetRow.getCell(4).setCellValue(list.get(i).getStartTime1());
						targetRow.getCell(5).setCellValue(list.get(i).getEndTime1());
						targetRow.getCell(6).setCellValue(list.get(i).getStartTime2());
						targetRow.getCell(7).setCellValue(list.get(i).getEndTime2());
						targetRow.getCell(8).setCellValue(list.get(i).getStartTime3());
						targetRow.getCell(9).setCellValue(list.get(i).getEndTime3());
						targetRow.getCell(11).setCellValue(list.get(i).getMorning());
						targetRow.getCell(12).setCellValue(list.get(i).getAfternoon());
						targetRow.getCell(13).setCellValue(list.get(i).getEvening());
						targetRow.getCell(14).setCellValue(list.get(i).getCount());
					}
				}
			}
			//锁定
			sheet.protectSheet(UUIDBuild.getUUID());
			
			wb.write(response.getOutputStream());
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	//时间类型转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
