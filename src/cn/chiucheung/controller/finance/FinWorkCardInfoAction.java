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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.finance.planetrainticket.FinPlaneTrainTicket;
import cn.chiucheung.po.finance.workcardinfo.FinWorkCardInfo;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoForUpdateCustom;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoForGenerateExcel;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoQueryVo;
import cn.chiucheung.service.finance.WorkCardInfoService;

@Controller
@RequestMapping("/finance/workCardInfo")
public class FinWorkCardInfoAction {
	
	@Autowired
	WorkCardInfoService workCardInfoService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="gk",pid="gg")
	public String index(){
		return "finance/workCardInfo";
	}
	
	/**
	 * 查找所有的工咭信息
	 * @param workCardInfoQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findAllWorkCardInfoList")
	@ResponseBody
	@AnnotationLimit(mid="gk",pid="gg")
	public Map<String, Object> findAllWorkCardInfoList(FinWorkCardInfoQueryVo workCardInfoQueryVo, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		workCardInfoQueryVo.setSession(session);
		List<FinWorkCardInfoForUpdateCustom> list =  workCardInfoService.findAllWorkCardInfoList(workCardInfoQueryVo);
		String total = workCardInfoService.findAllWorkCardInfoTotal(workCardInfoQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 新增工咭信息
	 * @param workCardInfo
	 * @return
	 */
	@RequestMapping("saveWorkCardInfo")
	@ResponseBody
	@AnnotationLimit(mid="gka",pid="gk")
	public JSONObject saveWorkCardInfo(FinWorkCardInfo workCardInfo){
		JSONObject jsonObject = new JSONObject();
		try{
			workCardInfoService.saveWorkCardInfo(workCardInfo);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id查找工咭信息，用于页面的编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("findWorkCardInfoById")
	@ResponseBody
	@AnnotationLimit(mid="gkb",pid="gk")
	public FinWorkCardInfo findWorkCardInfoById(FinWorkCardInfoQueryVo workCardInfoQueryVo, HttpSession session){
		workCardInfoQueryVo.setSession(session);
		return workCardInfoService.findWorkCardInfoById(workCardInfoQueryVo);
	}
	
	/**
	 * 更新工咭信息
	 * @param workCardInfoCustom
	 * @return
	 */
	@RequestMapping("updateWorkCardInfo")
	@ResponseBody
	@AnnotationLimit(mid="gkb",pid="gk")
	public JSONObject updateWorkCardInfo(FinWorkCardInfoForUpdateCustom workCardInfoForUpdateCustom, HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try{
			workCardInfoForUpdateCustom.setSession(session);
			workCardInfoService.updateWorkCardInfo(workCardInfoForUpdateCustom);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id删除工咭信息
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteWorkCardInfoById")
	@ResponseBody
	@AnnotationLimit(mid="gkc",pid="gk")
	public JSONObject deleteWorkCardInfoById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			workCardInfoService.deleteWorkCardInfoById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 导出Excel
	 * @param workCardInfoQueryVo
	 * @return
	 */
	@RequestMapping("exportExcel")
	@ResponseBody
	@AnnotationLimit(mid="gkd",pid="gk")
	public String exportExcel(FinWorkCardInfoQueryVo workCardInfoQueryVo, HttpServletRequest request, HttpServletResponse response){
		try {
			File file = new File(request.getSession().getServletContext().getRealPath("WEB-INF"),"template/安装完结工咭明细表.xls");
			
			
			POIFSFileSystem pfs = new POIFSFileSystem(new FileInputStream(file));
			HSSFWorkbook wb = new HSSFWorkbook(pfs);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			List<FinWorkCardInfoForGenerateExcel> list = workCardInfoService.FindAllCompletionWorkCardCostForGenerateExcel(workCardInfoQueryVo);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
			sheet.getRow(0).getCell(0).setCellValue(dateFormat.format(workCardInfoQueryVo.getStartTime()) + "年（"+ (workCardInfoQueryVo.getStartTime().getMonth()+1) + "）月安装完结工咭明细表");
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy年MM月dd日");
			sheet.getRow(1).getCell(12).setCellValue("制表日期：" + dateFormat1.format(new Date()));
			HSSFRow sourceRow = sheet.getRow(4);
			
			if (list != null && list.size() > 0){
				for (int i = 0; i<list.size(); i++) {
					FinWorkCardInfoForGenerateExcel data = list.get(i);
					if (i == 0){
						sourceRow.getCell(0).setCellValue(i+1);
						sourceRow.getCell(1).setCellValue(data.getWorkCardNo());
						sourceRow.getCell(2).setCellValue(data.getProjectLeader());
						sourceRow.getCell(3).setCellValue(data.getContractAmount().doubleValue());
						sourceRow.getCell(4).setCellValue(data.getOffice());
						sourceRow.getCell(5).setCellValue(data.getInstallationPlace());
						sourceRow.getCell(6).setCellValue(data.getInstallationNumber());
						sourceRow.getCell(7).setCellValue(data.getExpectedInstallationTime());
						sourceRow.getCell(8).setCellValue(data.getExpectedInstallationCost().doubleValue());
						sourceRow.getCell(9).setCellValue(data.getExpectedInstallationCostPercent().doubleValue());
						sourceRow.getCell(10).setCellValue(data.getActualInstallationTime());
						sourceRow.getCell(11).setCellValue(data.getActualAuxiliaryTime());
						sourceRow.getCell(12).setCellValue(data.getActualInstallationCost().doubleValue());
						sourceRow.getCell(13).setCellValue(data.getActualInstallationCostPercent().doubleValue());
						sourceRow.getCell(14).setCellValue(data.getDifferTotalTime());
						sourceRow.getCell(15).setCellValue(data.getDifferAmount().doubleValue());
						sourceRow.getCell(16).setCellValue(data.getDifferPercent().doubleValue());
					}else{
						/*sheet.shiftRows(4+i, sheet.getLastRowNum(), 1,true,false);*/
						HSSFRow targetRow = sheet.createRow(4+i);
						for (int j=0;j<sourceRow.getPhysicalNumberOfCells();j++){
							HSSFCell sourceCell = sourceRow.getCell(j);
							HSSFCell cell = targetRow.createCell(j);
							cell.setCellStyle(sourceCell.getCellStyle());
						}
						targetRow.getCell(0).setCellValue(i+1);
						targetRow.getCell(1).setCellValue(data.getWorkCardNo());
						targetRow.getCell(2).setCellValue(data.getProjectLeader());
						targetRow.getCell(3).setCellValue(data.getContractAmount().doubleValue());
						targetRow.getCell(4).setCellValue(data.getOffice());
						targetRow.getCell(5).setCellValue(data.getInstallationPlace());
						targetRow.getCell(6).setCellValue(data.getInstallationNumber());
						targetRow.getCell(7).setCellValue(data.getExpectedInstallationTime());
						targetRow.getCell(8).setCellValue(data.getExpectedInstallationCost().doubleValue());
						targetRow.getCell(9).setCellValue(data.getExpectedInstallationCostPercent().doubleValue());
						targetRow.getCell(10).setCellValue(data.getActualInstallationTime());
						targetRow.getCell(11).setCellValue(data.getActualAuxiliaryTime());
						targetRow.getCell(12).setCellValue(data.getActualInstallationCost().doubleValue());
						targetRow.getCell(13).setCellValue(data.getActualInstallationCostPercent().doubleValue());
						targetRow.getCell(14).setCellValue(data.getDifferTotalTime());
						targetRow.getCell(15).setCellValue(data.getDifferAmount().doubleValue());
						targetRow.getCell(16).setCellValue(data.getDifferPercent().doubleValue());
					}
				}
			}
			
			//sheet.setForceFormulaRecalculation(true);//强制计算公式
			/*sheet.protectSheet(UUIDBuild.getUUID());*/
			//sheet.getRow(10+list.size()-1).getCell(8).getCellStyle().setLocked(false);
			//sheet.getRow(10+list.size()+1).getCell(8).getCellStyle().setLocked(false);
			//sheet.getRow(2).getCell(6).getCellStyle().setLocked(false);
			
			String filename = "安装完结工咭明细表" + new Date().toLocaleString()+".xls";
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
	
	/**
	 * 导入Excel
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping("importExcel")
	@ResponseBody
	@AnnotationLimit(mid="gke",pid="gk")
	public JSONObject importExcel(MultipartFile uploadFile){
		JSONObject jsonObject = new JSONObject();
		try{
			int i = workCardInfoService.insertListForImportExcel(uploadFile);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("message", "成功导入" + i + "条记录");
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	
	//时间类型转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
