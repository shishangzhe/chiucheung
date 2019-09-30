package cn.chiucheung.controller.engineering;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.engineering.workhours.EngWorkHours;
import cn.chiucheung.po.system.role.SysRole;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.engineering.workhours.EngExportResultsExcelCustom;
import cn.chiucheung.pojo.engineering.workhours.EngWorkHoursCustom;
import cn.chiucheung.pojo.engineering.workhours.EngWorkHoursVo;
import cn.chiucheung.pojo.finance.checksheet.FinExportExcelForCheckSheetCustom;
import cn.chiucheung.pojo.finance.checksheet.LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet;
import cn.chiucheung.service.engineering.WorkHoursService;
import cn.chiucheung.utils.JxlExcelUtils;
import cn.chiucheung.utils.UUIDBuild;
import cn.chiucheung.utils.UserUtils;

@Controller
@RequestMapping("/engineering/workhours")
public class EngWorkHoursAction {
	
	@Autowired
	private WorkHoursService workHoursService;
	
	@RequestMapping("index")
	@AnnotationLimit(pid="cc",mid="cd")
	public String index(){
		return "engineering/workhours";
	}
	
	
	/**
	 * 新增工程工时
	 * @param engWorkHours 新增的数据
	 * @return 返回提示信息
	 */
	@RequestMapping(value="saveEngWorkHours",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(pid="cd",mid="cda")
	public String saveEngWorkHours(EngWorkHoursCustom workHoursCustom, HttpSession session){
		try{
			SysUser user = UserUtils.getUserFromSession(session);
			workHoursCustom.setUserId(user.getId());
			workHoursService.saveEngWorkHours(workHoursCustom);
			return "保存成功";
		}catch(Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
	/**
	 * 查询所有的工时
	 * @param workHoursVo 查询的条件
	 * @return 返回提示信息
	 */
	@RequestMapping(value="findAllWorkHoursList")
	@ResponseBody
	@AnnotationLimit(pid="cc",mid="cd")
	public Map<String, Object> findAllWorkHoursList(EngWorkHoursVo workHoursVo,HttpSession session){
		boolean b = isPrivilege(workHoursVo, session);
		if (b){
			Map<String, Object> map = new HashMap<String, Object>();
			String total = workHoursService.findAllWorkHoursTotal(workHoursVo);
			List<EngWorkHours> list = workHoursService.findAllWorkHoursList(workHoursVo);
			map.put("total", total);
			map.put("rows", list);
			return map;
		}else{
			return null;
		}
	}
	
	/**
	 * 计算工时总和
	 * @param workHoursVo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="sumEngWorkHours")
	@ResponseBody
	public Map<String, Object> sumEngWorkHours(EngWorkHoursVo workHoursVo,HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			boolean b = isPrivilege(workHoursVo, session);
			String sum = "0";
			if (b){
				sum = workHoursService.findAllWorkHoursSum(workHoursVo);
			}
			map.put("success", true);
			map.put("sum", sum);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "<font color='red'>" +e.getMessage() + "<font/>");
		}
		return map;
	}


	/**
	 * 根据id查询工时，用于修改的数据展示
	 * @param id 查询的条件
	 * @return 
	 */
	@RequestMapping(value="findEngWorkHoursById")
	@ResponseBody
	@AnnotationLimit(pid="cd",mid="cdb")
	public Map<String, Object> findEngWorkHoursById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			EngWorkHoursCustom workHoursCustom = workHoursService.findEngWorkHoursById(id);
			map.put("success", true);
			map.put("row", workHoursCustom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "<font color='red'>" +e.getMessage() + "<font/>");
			return map;
		}
	}
	
	/**
	 * 更新工程工时
	 * @param engWorkHours 新增的数据
	 * @return 返回提示信息
	 */
	@RequestMapping(value="updateEngWorkHours",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(pid="cd",mid="cdb")
	public String updateEngWorkHours(EngWorkHoursCustom workHoursCustom){
		try{
			workHoursService.updateEngWorkHours(workHoursCustom);
			return "保存成功";
		}catch(Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
	/**
	 * 删除工程工时
	 * @param engWorkHours 新增的数据
	 * @return 返回提示信息
	 */
	@RequestMapping(value="deleteEngWorkHoursById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(pid="cd",mid="cdc")
	public String deleteEngWorkHoursById(String id){
		try{
			workHoursService.deleteEngWorkHoursById(id);
			return "删除成功";
		}catch(Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"删除失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 根据日期、班次和用户检查剩余时间
	 * @param engWorkHours 条件
	 * @return 返回提示信息
	 */
	@RequestMapping(value="checkRemainingTime")
	@ResponseBody
	public String checkRemainingTime(EngWorkHours workHours, HttpSession session){
		String remainingTime = workHoursService.checkRemainingTime(workHours, session);
		if (StringUtils.isBlank(remainingTime)){
			remainingTime = "0";
		}
		return remainingTime;
	}

	/**
	 * 查询所有的工时
	 * @param workHoursVo 查询的条件
	 * @return 返回提示信息
	 */
	@RequestMapping(value="exportExcel")
	@ResponseBody
	@AnnotationLimit(pid="cd",mid="cdd")
	public String exportExcel(EngWorkHoursVo workHoursVo, HttpSession session, HttpServletResponse response){
		boolean b = isPrivilege(workHoursVo, session);
		if (b){
			List<EngWorkHours> list = workHoursService.findAllWorkHoursList(workHoursVo);
			List<Map<String, List<Object>>> objData = new ArrayList<Map<String,List<Object>>>();
			int i = 1;
			for (EngWorkHours workHours : list){
				List<Object> list2 = new ArrayList<Object>();
				Date date = workHours.getWorkHoursDate();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				list2.add(dateFormat.format(date));
				list2.add(workHours.getUserId());
				list2.add(workHours.getWorkCardNo());
				list2.add(workHours.getWorkCardItem());
				if ("自定义......".equals(workHours.getWorkContent())){
					list2.add(workHours.getWorkContentCustom());
				}else{
					list2.add(workHours.getWorkContent());
				}
				list2.add(workHours.getWorkHours());
				list2.add(workHours.getWorkShiftId());
				Map<String, List<Object>> map = new HashMap<String, List<Object>>();
				map.put(i+"", list2);
				objData.add(map);
				i++;
			}
			
			List<String> columns = new ArrayList<String>();
			columns.add("日期");
			columns.add("姓名");
			columns.add("工咭号");
			columns.add("工咭项次");
			columns.add("工作内容");
			columns.add("工时");
			columns.add("班次");
			
			List<Integer> columnsWidth = new ArrayList<Integer>();
			columnsWidth.add(10);
			columnsWidth.add(10);
			columnsWidth.add(10);
			columnsWidth.add(15);
			columnsWidth.add(15);
			columnsWidth.add(20);
			columnsWidth.add(8);
			columnsWidth.add(8);
			
			//提供下载
			String filename = "工程工时_" + new Date().toLocaleString()+".xls";
			//response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			//response.setContentType(this.getServletContext().getMimeType(filename));
			JxlExcelUtils.exportexcle(response, filename, objData, "Sheet1", columns, columnsWidth);
		}
		return null;
	}
	
	
	/**
	 * 查询所有的工时
	 * @param workHoursVo 查询的条件
	 * @return 返回提示信息
	 */
	@RequestMapping(value="exportResultsExcel")
	@ResponseBody
	@AnnotationLimit(pid="cd",mid="cdh")
	public String exportResultsExcel(EngWorkHoursVo workHoursVo, int flag, HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/vnd.ms-excel");  
		try{
			if (flag == 5){
				List<EngExportResultsExcelCustom> list = workHoursService.exportResultsExcel5(workHoursVo);
				
				List<SysUser> users = workHoursService.selectEngReviewer();
				Map<String, String> reviewers = new HashMap<String, String>();
				for (SysUser user : users) {
					reviewers.put(user.getGroupsId(), user.getUsername());
				}
				
				File file = new File(request.getSession().getServletContext().getRealPath("WEB-INF"),"template/工咭结算表.xls");
				
				POIFSFileSystem pfs = new POIFSFileSystem(new FileInputStream(file));
				HSSFWorkbook wb = new HSSFWorkbook(pfs);
				HSSFSheet sheet = wb.getSheetAt(0);
				
				if (list != null && list.size() > 0){
					for (int i = 0; i<list.size(); i++) {
						if (i < (list.size() - 1)){
							sheet.shiftRows(i+3, sheet.getLastRowNum(), 1,true,false);
							HSSFRow targetRow = sheet.getRow(i+3);
							HSSFRow sourceRow = sheet.getRow(i+4);
							for (int j=0;j<sourceRow.getPhysicalNumberOfCells();j++){
								HSSFCell sourceCell = sourceRow.getCell(j);
								HSSFCell cell = targetRow.createCell(j);
								cell.setCellStyle(sourceCell.getCellStyle());
							}
						}
						sheet.getRow(i+3).getCell(0).setCellValue(i+1);
						sheet.getRow(i+3).getCell(1).setCellValue(list.get(i).getWorkCardNo());
						
						sheet.getRow(i+3).getCell(3).setCellValue(list.get(i).getUsername());
						sheet.getRow(i+3).getCell(4).setCellValue(list.get(i).getStartTime().getDate());
						sheet.getRow(i+3).getCell(5).setCellValue(list.get(i).getEndTime().getDate());
						sheet.getRow(i+3).getCell(6).setCellValue(list.get(i).getSumTimes());
						sheet.getRow(i+3).getCell(7).setCellValue(reviewers.containsKey(list.get(i).getGroupsId()) ? reviewers.get(list.get(i).getGroupsId()) : "");
					}
				}
				
				String filename = "工咭结算表" + new Date().toLocaleString()+".xls";
				response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
				wb.write(response.getOutputStream());
			}else{
				String filename = "";
				List<Map<String, List<Object>>> objData = new ArrayList<Map<String,List<Object>>>();
				List<String> columns = new ArrayList<String>();
				List<Integer> columnsWidth = new ArrayList<Integer>();
				if (flag == 1){
					List<EngExportResultsExcelCustom> list = workHoursService.exportResultsExcel1(workHoursVo);
					int i = 1;
					for (EngExportResultsExcelCustom exportResultsExcelCustom : list){
						List<Object> list2 = new ArrayList<Object>();
						list2.add(exportResultsExcelCustom.getUsername());
						list2.add(exportResultsExcelCustom.getWorkHours1());
						list2.add(exportResultsExcelCustom.getWorkHours2());
						list2.add(exportResultsExcelCustom.getWorkHours3());
						list2.add(exportResultsExcelCustom.getWorkHours4());
						list2.add(exportResultsExcelCustom.getWorkHours5());
						list2.add(exportResultsExcelCustom.getWorkHours6());
						list2.add(exportResultsExcelCustom.getWorkHours7());
						list2.add(exportResultsExcelCustom.getWorkHours8());
						list2.add(exportResultsExcelCustom.getWorkHours9());
						Map<String, List<Object>> map = new HashMap<String, List<Object>>();
						map.put(i+"", list2);
						objData.add(map);
						i++;
					}
					
					
					columns.add("姓名");
					columns.add("当月实用工时");
					columns.add("验证、跟单");
					columns.add("出差");
					columns.add("工作沟通、资料整理及移交");
					columns.add("完成工时合计");
					columns.add("其他");
					columns.add("待工");
					columns.add("请假");
					columns.add("其他合计");
					
					
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					
					//提供下载
					filename = "施工成绩表_" + new Date().toLocaleString()+".xls";
					//response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
					//response.setContentType(this.getServletContext().getMimeType(filename));
				}else if (flag == 2){
					List<EngExportResultsExcelCustom> list = workHoursService.exportResultsExcel2(workHoursVo);
					int i = 1;
					for (EngExportResultsExcelCustom exportResultsExcelCustom : list){
						List<Object> list2 = new ArrayList<Object>();
						list2.add(exportResultsExcelCustom.getUsername());
						list2.add(exportResultsExcelCustom.getWorkHours1() == 0 ? "" : exportResultsExcelCustom.getWorkHours1());
						list2.add(exportResultsExcelCustom.getWorkHours2() == 0 ? "" : exportResultsExcelCustom.getWorkHours2());
						list2.add(exportResultsExcelCustom.getWorkHours3() == 0 ? "" : exportResultsExcelCustom.getWorkHours3());
						list2.add(exportResultsExcelCustom.getWorkHours4() == 0 ? "" : exportResultsExcelCustom.getWorkHours4());
						list2.add(exportResultsExcelCustom.getWorkHours5() == 0 ? "" : exportResultsExcelCustom.getWorkHours5());
						list2.add(exportResultsExcelCustom.getWorkHours6() == 0 ? "" : exportResultsExcelCustom.getWorkHours6());
						list2.add(exportResultsExcelCustom.getWorkHours7() == 0 ? "" : exportResultsExcelCustom.getWorkHours7());
						list2.add(exportResultsExcelCustom.getWorkHours8() == 0 ? "" : exportResultsExcelCustom.getWorkHours8());
						list2.add(exportResultsExcelCustom.getWorkHours9() == 0 ? "" : exportResultsExcelCustom.getWorkHours9());
						list2.add(exportResultsExcelCustom.getWorkHours10() == 0 ? "" : exportResultsExcelCustom.getWorkHours10());
						list2.add(exportResultsExcelCustom.getWorkHours11() == 0 ? "" : exportResultsExcelCustom.getWorkHours11());
						list2.add(exportResultsExcelCustom.getWorkHours12() == 0 ? "" : exportResultsExcelCustom.getWorkHours12());
						list2.add(exportResultsExcelCustom.getWorkHours13() == 0 ? "" : exportResultsExcelCustom.getWorkHours13());
						Map<String, List<Object>> map = new HashMap<String, List<Object>>();
						map.put(i+"", list2);
						objData.add(map);
						i++;
					}
					
					
					columns.add("姓名");
					columns.add("BJ,CJ工咭");
					columns.add("HJ工咭");
					columns.add("Q/HK工咭");
					columns.add("RD工咭");
					columns.add("FG/SG/I咭");
					columns.add("标准类");
					columns.add("出差");
					columns.add("工作沟通、资料整理、资料移交");
					columns.add("待工");
					columns.add("验货、跟单");
					columns.add("其他");
					columns.add("个人合计");
					columns.add("请假");
					
					
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					
					//提供下载
					filename = "工时分布表_" + new Date().toLocaleString()+".xls";
				}else if (flag == 3){
					List<EngExportResultsExcelCustom> list = workHoursService.exportResultsExcel3(workHoursVo);
					int i = 1;
					for (EngExportResultsExcelCustom exportResultsExcelCustom : list){
						List<Object> list2 = new ArrayList<Object>();
						list2.add(exportResultsExcelCustom.getUsername());
						list2.add(exportResultsExcelCustom.getWorkHours1());
						Map<String, List<Object>> map = new HashMap<String, List<Object>>();
						map.put(i+"", list2);
						objData.add(map);
						i++;
					}
					
					
					columns.add("工咭号码");
					columns.add("总工时");
					
					
					columnsWidth.add(15);
					columnsWidth.add(15);
					
					//提供下载
					filename = "工咭工时统计表_" + new Date().toLocaleString()+".xls";
				}else if (flag == 4){
					List<EngExportResultsExcelCustom> list = workHoursService.exportResultsExcel4(workHoursVo);
					int i = 1;
					for (EngExportResultsExcelCustom exportResultsExcelCustom : list){
						List<Object> list2 = new ArrayList<Object>();
						list2.add(exportResultsExcelCustom.getUsername());
						list2.add(exportResultsExcelCustom.getWorkHours1());
						list2.add(exportResultsExcelCustom.getWorkHours2());
						list2.add(exportResultsExcelCustom.getWorkHours3());
						Map<String, List<Object>> map = new HashMap<String, List<Object>>();
						map.put(i+"", list2);
						objData.add(map);
						i++;
					}
					
					
					columns.add("工咭类型");
					columns.add("工咭数量（个）");
					columns.add("总工时（H）");
					columns.add("参与人数（人）");
					
					
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					columnsWidth.add(15);
					
					//提供下载
					filename = "实做工咭工时分析表_" + new Date().toLocaleString()+".xls";
				}
				JxlExcelUtils.exportexcle(response, filename, objData, "Sheet1", columns, columnsWidth);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//查询权限判断的封装
	private boolean isPrivilege(EngWorkHoursVo workHoursVo, HttpSession session) {
		SysUser user = UserUtils.getUserFromSession(session);
		List<Privilege> privileges = (List<Privilege>) session.getAttribute("privileges");
		Privilege privilege1 = new Privilege();//个人查询权限
		privilege1.setPid("cd");
		privilege1.setMid("cde");
		Privilege privilege2 = new Privilege();//分组查询权限
		privilege2.setPid("cd");
		privilege2.setMid("cdf");
		Privilege privilege3 = new Privilege();//全部查询权限
		privilege3.setPid("cd");
		privilege3.setMid("cdg");
		boolean b = false;
		if (!user.getLoginName().equals("admin")){//如果不是管理员
			if (privileges.contains(privilege3)){//如果有全部查询权限，则查询所有的工时
				return true;
			}
			if (privileges.contains(privilege2)){//如果有分组查询权限，则查询分组所有的工时
				workHoursVo.setDepartmentId(user.getDepartmentId());//也有可能其他部门有权限进来查看，不允许查看
				workHoursVo.setGroupsId(user.getGroupsId());
				return true;
			}
			if (privileges.contains(privilege1)){//如果有个人查询权限，则查询个人所有的工时
				workHoursVo.setUserId(user.getId());
				return true;
			}
		}else{//如果是管理员，则可以查询所有
			return true;
		}
		return b;
	}
	
	//时间类型转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
