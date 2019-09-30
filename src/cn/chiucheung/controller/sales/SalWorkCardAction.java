package cn.chiucheung.controller.sales;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.sales.workcard.SalWorkCardFile;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.sales.reviewer.TaskCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardConfirmation;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardDsqCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardEiaCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardJg3Custom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardJg5Custom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardJg6Custom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardKztCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardQueryVo;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardShowDataCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardSubsidiaryCustom;
import cn.chiucheung.service.sales.WorkCardService;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UserUtils;

@Controller
@RequestMapping("/sales/workCard")
public class SalWorkCardAction {
	
	@Autowired
	private WorkCardService workCardService;
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	HistoryService historyService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="dg",pid="dd")
	public String index(){
		return "sales/workCard";
	}
	
	@RequestMapping("workCardKzt")
	@AnnotationLimit(mid="dga",pid="dg")
	public String workCardKzt(){
		return "sales/workCardKZT";
	}
	
	@RequestMapping("workCardKztView")
	@AnnotationLimit(mid="dg",pid="dd")
	public String workCardKztView(){
		return "sales/workCardKZTView";
	}
	
	@RequestMapping("workCardDsq")
	@AnnotationLimit(mid="dga",pid="dg")
	public String workCardDsq(){
		return "sales/workCardDSQ";
	}
	
	@RequestMapping("workCardDsqView")
	@AnnotationLimit(mid="dg",pid="dd")
	public String workCardDsqView(){
		return "sales/workCardDSQView";
	}
	
	@RequestMapping("workCardJg3")
	@AnnotationLimit(mid="dga",pid="dg")
	public String workCardJg3(){
		return "sales/workCardJG3";
	}
	
	@RequestMapping("workCardJg3View")
	@AnnotationLimit(mid="dg",pid="dd")
	public String workCardJg3View(){
		return "sales/workCardJG3View";
	}
	
	@RequestMapping("workCardJg5")
	@AnnotationLimit(mid="dga",pid="dg")
	public String workCardJg5(){
		return "sales/workCardJG5";
	}
	
	@RequestMapping("workCardJg5View")
	@AnnotationLimit(mid="dg",pid="dd")
	public String workCardJg5View(){
		return "sales/workCardJG5View";
	}
	
	@RequestMapping("workCardJg6")
	@AnnotationLimit(mid="dga",pid="dg")
	public String workCardJg6(){
		return "sales/workCardJG6";
	}
	
	@RequestMapping("workCardJg6View")
	@AnnotationLimit(mid="dg",pid="dd")
	public String workCardJg6View(){
		return "sales/workCardJG6View";
	}
	
	@RequestMapping("workCardEia")
	@AnnotationLimit(mid="dga",pid="dg")
	public String workCardEia(){
		return "sales/workCardEIA";
	}
	
	@RequestMapping("workCardEiaView")
	@AnnotationLimit(mid="dg",pid="dd")
	public String workCardEiaView(){
		return "sales/workCardEIAView";
	}
	
	/**
	 * 根据salWorkCardSubsidiary的id查找salWorkCardSubsidiary，用来新增修改做货确认单的数据填充
	 * @param id
	 * @return
	 */
	@RequestMapping("findSalWorkCardSubsidiaryById")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public SalWorkCardConfirmation findSalWorkCardSubsidiaryById(String id){
		return workCardService.findSalWorkCardSubsidiaryById(id);
	}
	
	/**
	 * 新增工咭
	 * @param workCardCustom
	 * @param drawings
	 * @param session
	 * @return
	 */
	@RequestMapping(value="saveWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> saveWorkCard(SalWorkCardCustom workCardCustom, MultipartFile drawings, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.saveWorkCard(workCardCustom, drawings, session);
			map.put("success", true);
			map.put("row",workCardCustom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 根据SalWordCardFile的id读取文件
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="readFileById")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public String readFileById(String id, HttpServletResponse response){
		SalWorkCardFile workCardFile = workCardService.findFileById(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/workCard/", workCardFile.getFilePath());
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if (inputStream != null){
					inputStream.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}finally{
				inputStream = null;
			}
		}
		return null;
	}
	
	/**
	 * 根据SalWordCardFile的id删除文件
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="deleteFileById")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> deleteFileById(String id, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.deleteFileById(id, request);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 根据查询条件查找所有的工咭
	 * @param workCardQueryVo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="findAllWorkCardList")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public Map<String, Object> findAllWorkCardList(SalWorkCardQueryVo workCardQueryVo, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(workCardQueryVo.getAssignee())){
			workCardQueryVo.setAssignee(UserUtils.getUserFromSession(session).getAssignee());
		}
		List<SalWorkCardShowDataCustom> list = workCardService.findAllWorkCardList(workCardQueryVo);
		String total = workCardService.findAllWorkCardListCount(workCardQueryVo);
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 用于页面展开数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findAllSalWorkCardSubsidiaryListBySalWorkCardId")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public List<SalWorkCardSubsidiaryCustom> findAllSalWorkCardSubsidiaryListBySalWorkCardId(String id){
		return workCardService.findAllSalWorkCardSubsidiaryListBySalWorkCardId(id);
	}
	
	/**
	 * 根据id查找工咭数据，给页面展示（修改和查看共用，所以用能打开这个页面的权限）
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findSalWorkCardByIdForEdit")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> findSalWorkCardByIdForEdit(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = workCardService.findSalWorkCardByIdForEdit(id, session);
			map.put("success", true);
			map.put("datas", datas);
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 根据id查找工咭数据，给页面展示（修改和查看共用，所以用能打开这个页面的权限）
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findSalWorkCardByIdForView")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public Map<String, Object> findSalWorkCardByIdForView(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = workCardService.findSalWorkCardByIdForView(id);
			map.put("success", true);
			map.put("datas", datas);
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 修改工咭
	 * @param workCardCustom
	 * @param drawings
	 * @param request
	 * @return
	 */
	@RequestMapping(value="updateWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> updateWorkCard(SalWorkCardCustom workCardCustom, MultipartFile drawings, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.updateWorkCard(workCardCustom, drawings, session);
			map.put("success", true);
			map.put("row",workCardCustom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 删除工咭
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="deleteSalWorkCardById")
	@ResponseBody
	@AnnotationLimit(mid="dgb",pid="dg")
	public Map<String, Object> deleteSalWorkCardById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.deleteSalWorkCardById(id);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 新增做货确认单-控制台
	 * @param workCardKztCustom
	 * @return
	 */
	@RequestMapping(value="saveWorkCardKzt")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> saveWorkCardKzt(SalWorkCardKztCustom workCardKztCustom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.saveWorkCardKzt(workCardKztCustom);
			map.put("success", true);
			map.put("row",workCardKztCustom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardKzt和WorkCardKztOther
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="findWorkCardKztByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public Map<String, Object> findWorkCardKztByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SalWorkCardKztCustom workCardKztCustom = workCardService.findWorkCardKztByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			map.put("row",workCardKztCustom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 更新做货确认单-控制台
	 * @param workCardKztCustom
	 * @return
	 */
	@RequestMapping(value="updateWorkCardKzt")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> updateWorkCardKzt(SalWorkCardKztCustom workCardKztCustom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.updateWorkCardKzt(workCardKztCustom);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 删除做货确认单-控制台
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="deleteWorkCardKztByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> deleteWorkCardKztByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.deleteWorkCardKztByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 新增做货确认单-电视墙
	 * @param workCardDsqCustom
	 * @return
	 */
	@RequestMapping(value="saveWorkCardDsq")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> saveWorkCardDsq(SalWorkCardDsqCustom workCardDsqCustom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.saveWorkCardDsq(workCardDsqCustom);
			map.put("success", true);
			map.put("row",workCardDsqCustom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardDsq和WorkCardDsqOther
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="findWorkCardDsqByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public Map<String, Object> findWorkCardDsqByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SalWorkCardDsqCustom workCardDsqCustom = workCardService.findWorkCardDsqByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			map.put("row",workCardDsqCustom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 更新做货确认单-电视墙
	 * @param workCardDsqCustom
	 * @return
	 */
	@RequestMapping(value="updateWorkCardDsq")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> updateWorkCardDsq(SalWorkCardDsqCustom workCardDsqCustom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.updateWorkCardDsq(workCardDsqCustom);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 删除做货确认单-电视墙
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="deleteWorkCardDsqByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> deleteWorkCardDsqByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.deleteWorkCardDsqByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 新增做货确认单-机柜RK III
	 * @param workCardJg3Custom
	 * @return
	 */
	@RequestMapping(value="saveWorkCardJg3")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> saveWorkCardJg3(SalWorkCardJg3Custom workCardJg3Custom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.saveWorkCardJg3(workCardJg3Custom);
			map.put("success", true);
			map.put("row",workCardJg3Custom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardJg3
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="findWorkCardJg3ByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public Map<String, Object> findWorkCardJg3ByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SalWorkCardJg3Custom workCardJg3Custom = workCardService.findWorkCardJg3ByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			map.put("row",workCardJg3Custom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 更新做货确认单-机柜RK III
	 * @param workCardJg3Custom
	 * @return
	 */
	@RequestMapping(value="updateWorkCardJg3")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> updateWorkCardJg3(SalWorkCardJg3Custom workCardJg3Custom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.updateWorkCardJg3(workCardJg3Custom);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 删除做货确认单-机柜RK III
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="deleteWorkCardJg3ByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> deleteWorkCardJg3ByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.deleteWorkCardJg3ByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 新增做货确认单-机柜RK V
	 * @param workCardJg5Custom
	 * @return
	 */
	@RequestMapping(value="saveWorkCardJg5")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> saveWorkCardJg5(SalWorkCardJg5Custom workCardJg5Custom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.saveWorkCardJg5(workCardJg5Custom);
			map.put("success", true);
			map.put("row",workCardJg5Custom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardJg5
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="findWorkCardJg5ByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public Map<String, Object> findWorkCardJg5ByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SalWorkCardJg5Custom workCardJg5Custom = workCardService.findWorkCardJg5ByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			map.put("row",workCardJg5Custom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 更新做货确认单-机柜RK V
	 * @param workCardJg5Custom
	 * @return
	 */
	@RequestMapping(value="updateWorkCardJg5")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> updateWorkCardJg5(SalWorkCardJg5Custom workCardJg5Custom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.updateWorkCardJg5(workCardJg5Custom);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 删除做货确认单-机柜RK V
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="deleteWorkCardJg5ByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> deleteWorkCardJg5ByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.deleteWorkCardJg5ByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 新增做货确认单-机柜RK VI
	 * @param workCardJg6Custom
	 * @return
	 */
	@RequestMapping(value="saveWorkCardJg6")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> saveWorkCardJg6(SalWorkCardJg6Custom workCardJg6Custom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.saveWorkCardJg6(workCardJg6Custom);
			map.put("success", true);
			map.put("row",workCardJg6Custom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardJg6
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="findWorkCardJg6ByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public Map<String, Object> findWorkCardJg6ByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SalWorkCardJg6Custom workCardJg6Custom = workCardService.findWorkCardJg6ByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			map.put("row",workCardJg6Custom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 更新做货确认单-机柜RK VI
	 * @param workCardJg6Custom
	 * @return
	 */
	@RequestMapping(value="updateWorkCardJg6")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> updateWorkCardJg6(SalWorkCardJg6Custom workCardJg6Custom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.updateWorkCardJg6(workCardJg6Custom);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 删除做货确认单-机柜RK VI
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="deleteWorkCardJg6ByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> deleteWorkCardJg6ByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.deleteWorkCardJg6ByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 新增做货确认单-机柜配件
	 * @param workCardEiaCustom
	 * @return
	 */
	@RequestMapping(value="saveWorkCardEia")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> saveWorkCardEia(SalWorkCardEiaCustom workCardEiaCustom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.saveWorkCardEia(workCardEiaCustom);
			map.put("success", true);
			map.put("row",workCardEiaCustom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardEia和WorkCardEiaOther
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="findWorkCardEiaByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public Map<String, Object> findWorkCardEiaByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SalWorkCardEiaCustom workCardEiaCustom = workCardService.findWorkCardEiaByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			map.put("row",workCardEiaCustom);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 更新做货确认单-机柜配件
	 * @param workCardEiaCustom
	 * @return
	 */
	@RequestMapping(value="updateWorkCardEia")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> updateWorkCardEia(SalWorkCardEiaCustom workCardEiaCustom){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.updateWorkCardEia(workCardEiaCustom);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.toString());
			return map;
		}
	}
	
	/**
	 * 删除做货确认单-机柜RK VI
	 * @param workCardSubsidiaryId
	 * @return
	 */
	@RequestMapping(value="deleteWorkCardEiaByWorkCardSubsidiaryId")
	@ResponseBody
	@AnnotationLimit(mid="dga",pid="dg")
	public Map<String, Object> deleteWorkCardEiaByWorkCardSubsidiaryId(String workCardSubsidiaryId){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.deleteWorkCardEiaByWorkCardSubsidiaryId(workCardSubsidiaryId);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
			return map;
		}
	}
	
	/**
	 * 根据工咭的id查询下一节点接收任务的人,如何未开始，则查询第一节点的接收人
	 * @param id
	 * @return
	 */
	@RequestMapping(value="queryAuditorById")
	@ResponseBody
	@AnnotationLimit(mid="dgc",pid="dg")
	public Map<String, Object> queryAuditorById(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<SysUser> list = workCardService.queryAuditorById(id, null, session);
			map.put("success", true);
			map.put("rows",list);
			return map;
		}catch(Exception e){
			map.put("success", false);
			map.put("message",e.getMessage());
			return map;
		}
	}
	
	/**
	 * 审核工咭
	 * @param id
	 * @param assigneeId 下一节点的接收人的id（为空代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	@RequestMapping(value="auditWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="dgc",pid="dg")
	public Map<String, Object> auditWorkCard(String id, String assigneeId, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			workCardService.auditWorkCard(id, assigneeId, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 撤销流程
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="revokeProcess")
	@ResponseBody
	@AnnotationLimit(mid="dgc",pid="dg")
	public Map<String, Object> revokeProcess(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			workCardService.revokeProcess(id, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 收回评审
	 * @param id
	 * @return
	 */
	@RequestMapping(value="takeBackWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="dgc",pid="dg")
	public Map<String, Object> takeBackWorkCard(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.takeBackWorkCard(id, cause, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 退回到上一节点
	 * @param id
	 * @param cause
	 * @return
	 */
	@RequestMapping(value="rollBackWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="dgc",pid="dg")
	public Map<String, Object> rollBackWorkCard(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.rollBackWorkCard(id, cause, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 反审核
	 * @param id
	 * @param cause
	 * @return
	 */
	@RequestMapping(value="antiAuditWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="dgd",pid="dg")
	public Map<String, Object> antiAuditWorkCard(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.antiAuditWorkCard(id, cause, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 查询当前任务进行到哪
	 * @param model
	 * @param processInstanceId
	 * @param response
	 * @return
	 */
	@RequestMapping("/queryActivityMap")
	@AnnotationLimit(mid="dg",pid="dd")
	public String queryActivityMap(Model model, String processInstanceId, HttpServletResponse response){
		if (StringUtils.isNotBlank(processInstanceId)){
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			List<Task> tasks = taskQuery.list();
			if (tasks != null && tasks.size() > 0){//表示有任务，一定在审核中
				
				String processDefinitionId = tasks.get(0).getProcessDefinitionId();
				model.addAttribute("processDefinitionId", processDefinitionId);
				
				// 根据 流程定义 id查询流程定义 实体对象
				ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
				
				JSONArray jsonArray = new JSONArray();
				for (Task task : tasks) {
					ActivityImpl activityImpl = processDefinitionEntity.findActivity(task.getTaskDefinitionKey());
					int activity_width = activityImpl.getWidth();
					int activity_height = activityImpl.getHeight();
					int activity_y = activityImpl.getY();
					int activity_x = activityImpl.getX();
					JSONObject jsonObject = new JSONObject();
					jsonObject.accumulate("activity_width", activity_width);
					jsonObject.accumulate("activity_height", activity_height);
					jsonObject.accumulate("activity_y", activity_y);
					jsonObject.accumulate("activity_x", activity_x);
					jsonObject.accumulate("assignee", task.getAssignee());
					jsonArray.add(jsonObject);
				}
				model.addAttribute("list", jsonArray);
				return "system/queryActivityMap";
			}else{
				HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();
				historicActivityInstanceQuery.processInstanceId(processInstanceId);
				List<HistoricActivityInstance> historicActivityInstances = historicActivityInstanceQuery.list();
				if (historicActivityInstances != null && historicActivityInstances.size() > 0){//说明是审核完成了
					StringBuffer sb = new StringBuffer();
			        sb.append("<script language='javascript'>alert('");
			        sb.append("已评审完成，并已为您刷新了数据，请重新点击查看");
			        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
			        try {
			            response.setContentType("text/html; charset=utf-8");  
			            response.getWriter().println(sb.toString());
			            response.getWriter().flush();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				}else{//没有查找到，说明根本没有这个流程实例
					StringBuffer sb = new StringBuffer();
			        sb.append("<script language='javascript'>alert('");
			        sb.append("没有找到流程实例，并已为您刷新了数据，请重新点击查看");
			        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
			        try {
			            response.setContentType("text/html; charset=utf-8");  
			            response.getWriter().println(sb.toString());
			            response.getWriter().flush();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				}
			}
		}else{
			StringBuffer sb = new StringBuffer();
	        sb.append("<script language='javascript'>alert('");
	        sb.append("没有传入流程实例id，并已为您刷新了数据，请重新点击查看");
	        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
	        try {
	            response.setContentType("text/html; charset=utf-8");  
	            response.getWriter().println(sb.toString());
	            response.getWriter().flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		
		return null;
	}
	
	/**
	 * 查询已完成的任务
	 * @param processInstanceId
	 * @return
	 */
	@RequestMapping("queryTaskByProcessInstanceId")
	@AnnotationLimit(mid="dg",pid="dd")
	public String queryTaskByProcessInstanceId(String processInstanceId, Model model, HttpServletResponse response){
		HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();
		historicTaskInstanceQuery.processInstanceId(processInstanceId);
		List<HistoricTaskInstance> historicTaskInstances = historicTaskInstanceQuery.list();
		
		
		if (historicTaskInstances != null && historicTaskInstances.size() > 0){
			
			List<TaskCustom> list = new ArrayList<TaskCustom>();
			for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {
				TaskCustom taskCustom = new TaskCustom();
				taskCustom.setTaskId(historicTaskInstance.getId());
				taskCustom.setTaskName(historicTaskInstance.getName());
				taskCustom.setAssignee(historicTaskInstance.getAssignee());
				taskCustom.setTaskDefinitionKey(historicTaskInstance.getTaskDefinitionKey());
				taskCustom.setTask_startTime(historicTaskInstance.getStartTime());
				taskCustom.setTask_endTime(historicTaskInstance.getEndTime());
				list.add(taskCustom);
			}
			if (list.size()>0){
				model.addAttribute("list", list);
				return "system/queryTaskByProcessInstanceId";
			}else{
				StringBuffer sb = new StringBuffer();
		        sb.append("<script language='javascript'>alert('");
		        sb.append("没有找到流程实例，已为您刷新了数据，请重新点击查看");
		        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
		        try {
		            System.out.println(sb.toString());
		            response.setContentType("text/html; charset=utf-8");  
		            response.getWriter().println(sb.toString());
		            response.getWriter().flush();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
		}else{
			StringBuffer sb = new StringBuffer();
	        sb.append("<script language='javascript'>alert('");
	        sb.append("没有找到流程实例，已为您刷新了数据，请重新点击查看");
	        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
	        try {
	            System.out.println(sb.toString());
	            response.setContentType("text/html; charset=utf-8");  
	            response.getWriter().println(sb.toString());
	            response.getWriter().flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//工咭相关资料
	
	
	/**
	 * 根据工咭id查找工咭相关资料
	 * @param workCardId
	 */
	@RequestMapping(value="findWorkCardFileListBySalWorkCardId")
	@ResponseBody
	@AnnotationLimit(mid="dg",pid="dd")
	public List<SalWorkCardFile> findWorkCardFileListBySalWorkCardId(String salReviewerId, HttpServletRequest request){
		return workCardService.findWorkCardFileListBySalWorkCardId(salReviewerId, request);
	}
	
	/**
	 * 上传工咭相关资料
	 * @param id
	 * @param workCardNo
	 * @param workCardFile
	 */
	@RequestMapping(value="uploadWorkCardFile")
	@ResponseBody
	@AnnotationLimit(mid="dge",pid="dg")
	public Map<String, Object> uploadWorkCardFile(String id, String workCardNo, MultipartFile workCardFile,HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.saveWorkCardFile(id, workCardNo, workCardFile, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 删除工咭相关资料
	 * @param id workCardFile的id
	 * @return
	 */
	@RequestMapping(value="deleteWorkCardFileById")
	@ResponseBody
	@AnnotationLimit(mid="dgf",pid="dg")
	public Map<String, Object> deleteWorkCardFileById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.deleteWorkCardFile(id);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 根据工咭相关资料的id查询下一节点接收任务的人,如何未开始，则查询第一节点的接收人
	 * @param id
	 * @return
	 */
	@RequestMapping(value="queryAuditorForWorkCardFileById")
	@ResponseBody
	@AnnotationLimit(mid="dgg",pid="dg")
	public Map<String, Object> queryAuditorForWorkCardFileById(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<SysUser> list = workCardService.queryAuditorForWorkCardFileById(id, null, session);
			map.put("success", true);
			map.put("rows",list);
			return map;
		}catch(Exception e){
			map.put("success", false);
			map.put("message",e.getMessage());
			return map;
		}
	}
	
	/**
	 * 审核工咭相关资料
	 * @param id
	 * @param assigneeIds 下一节点的所有接收人的id（为空代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	@RequestMapping(value="auditWorkCardFile")
	@ResponseBody
	@AnnotationLimit(mid="dgg",pid="dg")
	public Map<String, Object> auditWorkCardFile(String id, String assigneeIds, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			workCardService.auditWorkCardFile(id, assigneeIds, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 撤销流程
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="revokeProcessWorkCardFile")
	@ResponseBody
	@AnnotationLimit(mid="dgg",pid="dg")
	public Map<String, Object> revokeProcessWorkCardFile(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			workCardService.revokeProcessWorkCardFile(id, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 反审核
	 * @param id
	 * @param cause
	 * @return
	 */
	@RequestMapping(value="antiAuditWorkCardFile")
	@ResponseBody
	@AnnotationLimit(mid="dgh",pid="dg")
	public Map<String, Object> antiAuditWorkCardFile(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			workCardService.antiAuditWorkCardFile(id, cause, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	
	
	
	
	
	//时间类型转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	/*@ExceptionHandler
	public void handleException(Exception ex,HttpServletRequest request,HttpServletResponse response){
		 StringBuffer sb = new StringBuffer();
	        sb.append("<script language='javascript'>history.go(-1);alert('");
	        if (ex instanceof org.springframework.web.multipart.MaxUploadSizeExceededException){
	            sb.append("文件大小不应大于"+((MaxUploadSizeExceededException)ex).getMaxUploadSize()/1000+"kb");
	         } else{
	             sb.append("上传异常！");
	        }
	        sb.append("！');</script>");
	        try {
	            System.out.println(sb.toString());
	            response.setContentType("text/html; charset=utf-8");  
	            response.getWriter().println(sb.toString());
	            response.getWriter().flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return;
	}*/
}
