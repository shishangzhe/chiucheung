package cn.chiucheung.controller.finance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.finance.planetrainticket.FinPlaneTrainTicket;
import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.pojo.finance.checksheet.FinExportExcelForCheckSheetCustom;
import cn.chiucheung.pojo.finance.checksheet.LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet;
import cn.chiucheung.pojo.finance.planetrainticket.FinPlaneTrainTicketQueryVo;
import cn.chiucheung.pojo.logistics.travelUser.LogTravelUserQueryVo;
import cn.chiucheung.service.finance.PlaneTrainTicketService;
import cn.chiucheung.service.logistics.TravelUserService;
import cn.chiucheung.utils.JxlExcelUtils;
import cn.chiucheung.utils.UUIDBuild;

@Controller
@RequestMapping("/finance/planeTrainTicket")
public class FinPlaneTrainTicketAction {
	
	@Autowired
	private PlaneTrainTicketService planeTrainTicketService;
	
	@Autowired
	private TravelUserService travelUserService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="gh",pid="gg")
	public String index(){
		return "finance/planeTrainTicket";
	}
	
	/**
	 * 查找所有的厂购火车票
	 * @param trainTicketQueryVo
	 * @return
	 */
	@RequestMapping("findAllPlaneTrainTicketList")
	@ResponseBody
	@AnnotationLimit(mid="gh",pid="gg")
	public Map<String, Object> findAllPlaneTrainTicketList(FinPlaneTrainTicketQueryVo planeTrainTicketQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<FinPlaneTrainTicket> list =  planeTrainTicketService.findAllPlaneTrainTicketList(planeTrainTicketQueryVo);
		String total = planeTrainTicketService.findAllPlaneTrainTicketTotal(planeTrainTicketQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 新增页面的查找差旅(APP)用户
	 * @param travelUser
	 * @return
	 */
	@RequestMapping("findAllTravelUserList")
	@ResponseBody
	@AnnotationLimit(mid="gh",pid="gg")
	public Map<String, Object> findAllTravelUserList(LogTravelUserQueryVo travelUserQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<LogTravelUser> list = travelUserService.findAllTravelUserList(travelUserQueryVo);
		String total = travelUserService.findAllTravelUserTotal(travelUserQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 新增厂购飞机/火车票
	 * @param travelSpendingRecordsCustom
	 * @return
	 */
	@RequestMapping("savePlaneTrainTicket")
	@ResponseBody
	@AnnotationLimit(mid="gha",pid="gh")
	public JSONObject savePlaneTrainTicket(FinPlaneTrainTicket planeTrainTicket){
		JSONObject jsonObject = new JSONObject();
		try{
			planeTrainTicketService.savePlaneTrainTicket(planeTrainTicket);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id查找厂购火车票，用于页面的编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("findPlaneTrainTicketById")
	@ResponseBody
	@AnnotationLimit(mid="ghb",pid="gh")
	public Map<String, Object> findPlaneTrainTicketById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			FinPlaneTrainTicket planeTrainTicket = planeTrainTicketService.findPlaneTrainTicketById(id);
			map.put("success", true);
			map.put("planeTrainTicket", planeTrainTicket);
		}catch(Exception e){
			map.put("success", false);
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 更新厂购火车票
	 * @param trainTicket
	 * @return
	 */
	@RequestMapping("updatePlaneTrainTicket")
	@ResponseBody
	@AnnotationLimit(mid="ghb",pid="gh")
	public JSONObject updatePlaneTrainTicket(FinPlaneTrainTicket planeTrainTicket){
		JSONObject jsonObject = new JSONObject();
		try{
			planeTrainTicketService.updatePlaneTrainTicket(planeTrainTicket);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id删除厂购火车票
	 * @param id
	 * @return
	 */
	@RequestMapping("deletePlaneTrainTicketById")
	@ResponseBody
	@AnnotationLimit(mid="ghc",pid="gh")
	public JSONObject deletePlaneTrainTicketById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			planeTrainTicketService.deletePlaneTrainTicketById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 复制厂购飞机/火车票
	 * @param travelSpendingRecordsCustom
	 * @return
	 */
	@RequestMapping("copyPlaneTrainTicketById")
	@ResponseBody
	@AnnotationLimit(mid="gha",pid="gh")
	public FinPlaneTrainTicket copyPlaneTrainTicketById(String id){
		return planeTrainTicketService.copyPlaneTrainTicketById(id);
	}
	
	/**
	 * 设为是否已报账
	 * @param planeTrainTicket
	 * @return
	 */
	@RequestMapping("updatePlaneTrainTicketByIdForLock")
	@ResponseBody
	@AnnotationLimit(mid="ghd",pid="gh")
	public JSONObject updatePlaneTrainTicketByIdForLock(FinPlaneTrainTicket planeTrainTicket){
		JSONObject jsonObject = new JSONObject();
		try{
			planeTrainTicketService.updatePlaneTrainTicketByIdForLock(planeTrainTicket);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 设为是否已收票据
	 * @param planeTrainTicket
	 * @return
	 */
	@RequestMapping("updatePlaneTrainTicketByIdForReceiveReceipt")
	@ResponseBody
	@AnnotationLimit(mid="ghe",pid="gh")
	public JSONObject updatePlaneTrainTicketByIdForReceiveReceipt(FinPlaneTrainTicket planeTrainTicket){
		JSONObject jsonObject = new JSONObject();
		try{
			planeTrainTicketService.updatePlaneTrainTicketByIdForReceiveReceipt(planeTrainTicket);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 导入Excel
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping("importExcel")
	@ResponseBody
	@AnnotationLimit(mid="ghf",pid="gh")
	public JSONObject importExcel(MultipartFile uploadFile){
		JSONObject jsonObject = new JSONObject();
		try{
			int i = planeTrainTicketService.insertListForImportExcel(uploadFile);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("message", "成功导入" + i + "条记录");
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	/**
	 * 导出Excel
	 */
	@RequestMapping("exportExcel")
	@AnnotationLimit(mid="ghg",pid="gh")
	public String exportExcel(FinPlaneTrainTicketQueryVo planeTrainTicketQueryVo, HttpServletRequest request, HttpServletResponse response){
		
		try {
			File file = new File(request.getSession().getServletContext().getRealPath("WEB-INF"),"template/火车票订票明细表.xls");
			
			
			POIFSFileSystem pfs = new POIFSFileSystem(new FileInputStream(file));
			HSSFWorkbook wb = new HSSFWorkbook(pfs);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			planeTrainTicketQueryVo.setPage(0);
			planeTrainTicketQueryVo.setSort("orderTicketsDate");
			List<FinPlaneTrainTicket> list =  planeTrainTicketService.findAllPlaneTrainTicketList(planeTrainTicketQueryVo);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			HSSFRow sourceRow = sheet.getRow(2);
			
			if (list != null && list.size() > 0){
				for (int i = 0; i<list.size(); i++) {
					if (i == 0){
						sourceRow.getCell(0).setCellValue(list.get(i).getWorkCardNo());
						sourceRow.getCell(1).setCellValue(format.format(list.get(i).getOrderTicketsDate()));
						sourceRow.getCell(2).setCellValue(format2.format(list.get(i).getDepartureTime()));
						sourceRow.getCell(3).setCellValue(list.get(i).getTravelPersonnel());
						sourceRow.getCell(4).setCellValue(list.get(i).getStartPoint());
						sourceRow.getCell(5).setCellValue(list.get(i).getEndPoint());
						sourceRow.getCell(6).setCellValue(list.get(i).getPlaneTrainNumber());
						sourceRow.getCell(7).setCellValue(list.get(i).getSeat());
						sourceRow.getCell(8).setCellValue(list.get(i).getBerth());
						sourceRow.getCell(9).setCellValue(list.get(i).getPrice());
						sourceRow.getCell(10).setCellValue(list.get(i).getOrderNumber());
						sourceRow.getCell(11).setCellValue(list.get(i).getRemark());
					}else{
						sheet.shiftRows(2+i, sheet.getLastRowNum(), 1,true,false);
						HSSFRow targetRow = sheet.createRow(2+i);
						for (int j=0;j<sourceRow.getPhysicalNumberOfCells();j++){
							HSSFCell sourceCell = sourceRow.getCell(j);
							HSSFCell cell = targetRow.createCell(j);
							cell.setCellStyle(sourceCell.getCellStyle());
						}
						targetRow.getCell(0).setCellValue(list.get(i).getWorkCardNo());
						targetRow.getCell(1).setCellValue(format.format(list.get(i).getOrderTicketsDate()));
						targetRow.getCell(2).setCellValue(format2.format(list.get(i).getDepartureTime()));
						targetRow.getCell(3).setCellValue(list.get(i).getTravelPersonnel());
						targetRow.getCell(4).setCellValue(list.get(i).getStartPoint());
						targetRow.getCell(5).setCellValue(list.get(i).getEndPoint());
						targetRow.getCell(6).setCellValue(list.get(i).getPlaneTrainNumber());
						targetRow.getCell(7).setCellValue(list.get(i).getSeat());
						targetRow.getCell(8).setCellValue(list.get(i).getBerth());
						targetRow.getCell(9).setCellValue(list.get(i).getPrice());
						targetRow.getCell(10).setCellValue(list.get(i).getOrderNumber());
						targetRow.getCell(11).setCellValue(list.get(i).getRemark());
					}
				}
			}
			
			sheet.setForceFormulaRecalculation(true);//强制计算公式
			/*sheet.protectSheet(UUIDBuild.getUUID());*/
			//sheet.getRow(10+list.size()-1).getCell(8).getCellStyle().setLocked(false);
			//sheet.getRow(10+list.size()+1).getCell(8).getCellStyle().setLocked(false);
			//sheet.getRow(2).getCell(6).getCellStyle().setLocked(false);
			
			String filename = "火车票订票明细表" + new Date().toLocaleString()+".xls";
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			
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
	
}
