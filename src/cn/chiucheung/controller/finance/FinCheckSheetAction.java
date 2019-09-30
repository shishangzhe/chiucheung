package cn.chiucheung.controller.finance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.pojo.finance.checksheet.FinCheckSheetCustom;
import cn.chiucheung.pojo.finance.checksheet.FinCheckSheetQueryVo;
import cn.chiucheung.pojo.finance.checksheet.FinExportExcelForCheckSheetCustom;
import cn.chiucheung.pojo.finance.checksheet.LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsQueryVo;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsSubsidiaryCustom;
import cn.chiucheung.service.finance.CheckSheetService;
import cn.chiucheung.utils.UUIDBuild;

@Controller
@RequestMapping("/finance/checkSheet")
public class FinCheckSheetAction {
	
	@Autowired
	private CheckSheetService checkSheetService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="gi",pid="gg")
	public String index(){
		return "finance/checkSheet";
	}
	
	/**
	 * 查询所有的报账单
	 * @param checkSheetQueryVo
	 * @return
	 */
	@RequestMapping("findAllCheckSheetList")
	@ResponseBody
	@AnnotationLimit(mid="gi",pid="gg")
	public Map<String, Object> findAllCheckSheetList(FinCheckSheetQueryVo checkSheetQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		checkSheetQueryVo.setIsLock(true);
		List<FinCheckSheetCustom> list = checkSheetService.findAllCheckSheetList(checkSheetQueryVo);
		String total = checkSheetService.findAllCheckSheetTotal(checkSheetQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 页面的数据的一级展开
	 * @param id
	 * @return
	 */
	@RequestMapping("findAllTravelSpendingRecordsByFinCheckSheetId")
	@ResponseBody
	@AnnotationLimit(mid="gi",pid="gg")
	public List<FinCheckSheetCustom> findAllTravelSpendingRecordsByFinCheckSheetId(String id){
		return checkSheetService.findAllTravelSpendingRecordsByFinCheckSheetId(id);
	}
	
	/**
	 * 页面数据的二级展开
	 * @param id
	 * @return
	 */
	@RequestMapping("findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId")
	@ResponseBody
	@AnnotationLimit(mid="gi",pid="gg")
	public List<LogTravelSpendingRecordsSubsidiaryCustom> findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(String id){
		return checkSheetService.findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(id);
	}
	
	
	/**
	 * 根据id导出报账单到Excel
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("exportExcelForCheckSheetById")
	@ResponseBody
	@AnnotationLimit(mid="gia",pid="gi")
	public String exportExcelForCheckSheetById(String id, HttpServletRequest request, HttpServletResponse response){
		try {
			File file = new File(request.getSession().getServletContext().getRealPath("WEB-INF"),"template/出差人员报销表.xls");
			FinExportExcelForCheckSheetCustom exportExcelForCheckSheetCustom = checkSheetService.exportExcelForCheckSheetById(id);
			
			String sumWorkHour = checkSheetService.exportExcelForSumWorkHour(id);
			
			String filename = "差旅支出记录表" + new Date().toLocaleString()+".xls";
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			
			POIFSFileSystem pfs = new POIFSFileSystem(new FileInputStream(file));
			HSSFWorkbook wb = new HSSFWorkbook(pfs);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			sheet.getRow(0).getCell(5).setCellValue(exportExcelForCheckSheetCustom.getCheckSheetNo());
			sheet.getRow(1).getCell(1).setCellValue(exportExcelForCheckSheetCustom.getApplicant());
			sheet.getRow(1).getCell(6).setCellValue(exportExcelForCheckSheetCustom.getInstallWorkCardNo());
			sheet.getRow(1).getCell(11).setCellValue(exportExcelForCheckSheetCustom.getBusinessTripDate());
			sheet.getRow(3).getCell(1).setCellValue(exportExcelForCheckSheetCustom.getProjectManager());
			sheet.getRow(3).getCell(11).setCellValue(exportExcelForCheckSheetCustom.getDepartureDate());
			sheet.getRow(2).getCell(1).setCellValue(exportExcelForCheckSheetCustom.getTravelPlace());
			sheet.getRow(4).getCell(11).setCellValue(exportExcelForCheckSheetCustom.getAccompanyingPersonnel());
			
			List<LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet> list = exportExcelForCheckSheetCustom.getList();
			HSSFRow sourceRow = sheet.getRow(7);
			if (list != null && list.size() > 0){
				for (int i = 0; i<list.size(); i++) {
					if (i == 0){
						sourceRow.getCell(0).setCellValue(list.get(i).getTravelDate());
						sourceRow.getCell(1).setCellValue(list.get(i).getLunch());
						sourceRow.getCell(2).setCellValue(list.get(i).getDinner());
						sourceRow.getCell(3).setCellValue(list.get(i).getMidnightSnack());
						sourceRow.getCell(4).setCellValue(list.get(i).getLivePrice());
						sourceRow.getCell(5).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getTrafficPrice())));
						sourceRow.getCell(6).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getTrainAndAirTicket())));
						sourceRow.getCell(7).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther1())));
						sourceRow.getCell(8).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther2())));
						sourceRow.getCell(9).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther3())));
						sourceRow.getCell(10).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther4())));
						sourceRow.getCell(11).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther5())));
						sourceRow.getCell(12).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther6())));
						sourceRow.getCell(13).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther7())));
						sourceRow.getCell(14).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther8())));
						sourceRow.getCell(15).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther9())));
						sourceRow.getCell(16).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther10())));
						sourceRow.getCell(17).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther11())));
						sourceRow.getCell(18).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getCount())));
					}else{
						//HSSFRow targetRow = sheet.createRow(7+i+1);
						sheet.shiftRows(7+i, sheet.getLastRowNum(), 1,true,false);
						HSSFRow targetRow = sheet.getRow(7+i);
						for (int j=0;j<sourceRow.getPhysicalNumberOfCells();j++){
							HSSFCell sourceCell = sourceRow.getCell(j);
							HSSFCell cell = targetRow.createCell(j);
							cell.setCellStyle(sourceCell.getCellStyle());
						}
						targetRow.getCell(0).setCellValue(list.get(i).getTravelDate());
						targetRow.getCell(1).setCellValue(list.get(i).getLunch());
						targetRow.getCell(2).setCellValue(list.get(i).getDinner());
						targetRow.getCell(3).setCellValue(list.get(i).getMidnightSnack());
						targetRow.getCell(4).setCellValue(list.get(i).getLivePrice());
						targetRow.getCell(5).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getTrafficPrice())));
						targetRow.getCell(6).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getTrainAndAirTicket())));
						targetRow.getCell(7).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther1())));
						targetRow.getCell(8).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther2())));
						targetRow.getCell(9).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther3())));
						targetRow.getCell(10).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther4())));
						targetRow.getCell(11).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther5())));
						targetRow.getCell(12).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther6())));
						targetRow.getCell(13).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther7())));
						targetRow.getCell(14).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther8())));
						targetRow.getCell(15).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther9())));
						targetRow.getCell(16).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther10())));
						targetRow.getCell(17).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getOther11())));
						targetRow.getCell(18).setCellValue(Double.parseDouble(String.valueOf(list.get(i).getCount())));
					}
				}
			}
			
			sheet.getRow(12+list.size()-1).getCell(18).setCellValue(Float.parseFloat(sumWorkHour));
			
			sheet.setForceFormulaRecalculation(true);//强制计算公式
			sheet.protectSheet(UUIDBuild.getUUID());
			//sheet.getRow(10+list.size()-1).getCell(8).getCellStyle().setLocked(false);
			//sheet.getRow(10+list.size()+1).getCell(8).getCellStyle().setLocked(false);
			//sheet.getRow(2).getCell(6).getCellStyle().setLocked(false);
			
		
			wb.write(response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//response.setContentType("text/xml; charset=UTF-8");
				//response.setCharacterEncoding("UTF-8");
				StringBuffer sb = new StringBuffer();
		        sb.append("<script language='javascript'>alert('");
		        sb.append(e.getMessage());
		        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
				response.getOutputStream().write(sb.toString().getBytes());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	
	/**
	 * 图形报表
	 * @param binder
	 */
	@RequestMapping("graphicalReportsForFCFById")
	@ResponseBody
	@AnnotationLimit(mid="gib",pid="gi")
	public JSONObject graphicalReportsForFCFById(String id){
		/*try {
			FinExportExcelForCheckSheetCustom exportExcelForCheckSheetCustom = checkSheetService.exportExcelForCheckSheetById(id);
			List<LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet>  list = exportExcelForCheckSheetCustom.getList();
			//组织XML的数据
			StringBuilder builder = new StringBuilder();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			
			if (list != null && list.size() > 0){
				String x = "日期";
				String y = "money";//存在FusionChart中的一个问题，Y轴的显示不支持中文，所以我们用英文代替
				builder.append("<chart caption='报账表统计("+"按日期"+")' xAxisName='"+x+"' bgColor='FFFFDD' yAxisName='"+y+"' showValues='1'  decimals='0' formatNumberScale='0' animation='0'  baseFontSize='18'  maxColWidth='60' showNames='1' decimalPrecision='0'> ");
				for (int i = 0; i < list.size(); i++) {
					builder.append("<set name='"+format.format(list.get(i).getTravelDate())+"' value='"+list.get(i).getCount()+"' color='"+getColorString()+"'/>");
				}
				
				builder.append("</chart>");
			}
			model.addAttribute("chart", builder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "graphicalReportsForFCF";*/
		/*JSONObject jsonObject = new JSONObject();
		try {
			FinExportExcelForCheckSheetCustom exportExcelForCheckSheetCustom = checkSheetService.exportExcelForCheckSheetById(id);
			List<LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet>  list = exportExcelForCheckSheetCustom.getList();
			//组织XML的数据
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			JSONObject chartData = new JSONObject();
			if (list != null && list.size() > 0){
				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.accumulate("yaxisname", "Money");
				jsonObject2.accumulate("caption", "报账表统计(按日期)");
				jsonObject2.accumulate("useroundedges", "1");
				jsonObject2.accumulate("bgcolor", "FFFFFF,FFFFFF");
				jsonObject2.accumulate("showborder", "0");
				jsonObject2.accumulate("formatNumberScale", "0");
				chartData.accumulate("chart", jsonObject2);
				JSONArray jsonArray = new JSONArray();
				for (int i = 0; i < list.size(); i++) {
					JSONObject object = new JSONObject();
					object.accumulate("label", format.format(list.get(i).getTravelDate()));
					object.accumulate("value", list.get(i).getCount());
					object.accumulate("color", getColorString());
					jsonArray.add(object);
				}
				chartData.accumulate("data", jsonArray);
			}
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("chartData", chartData);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;*/
		JSONObject jsonObject = new JSONObject();
		try {
			FinExportExcelForCheckSheetCustom exportExcelForCheckSheetCustom = checkSheetService.exportExcelForCheckSheetById(id);
			List<LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet>  list = exportExcelForCheckSheetCustom.getList();
			//组织XML的数据
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			StringBuffer buffer = new StringBuffer();
			if (list != null && list.size() > 0){
				buffer.append("<chart yaxisname='Money' caption='报账表统计(按日期)' useroundedges='1' bgcolor='FFFFFF,FFFFFF' showborder='0' formatNumberScale='0'>");
				for (int i = 0; i < list.size(); i++) {
					buffer.append("<set name='"+format.format(list.get(i).getTravelDate())+"' value='"+list.get(i).getCount()+"' color='"+getColorString()+"'/>");
				}
				buffer.append("</chart>");
			}
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("chartData", buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	@RequestMapping("updateCheckSheetByIdForTackBackToLogistics")
	@ResponseBody
	@AnnotationLimit(mid="gic",pid="gi")
	public JSONObject updateCheckSheetByIdForTackBackToLogistics(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			checkSheetService.updateCheckSheetByIdForTackBackToLogistics(id);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	
	//生成随机的颜色（十六禁止）
	public String getColorString(){
		StringBuffer buffer = new StringBuffer();
		String[] colors = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			buffer.append(colors[random.nextInt(colors.length)]);
		}
		return buffer.toString();
	}
}
