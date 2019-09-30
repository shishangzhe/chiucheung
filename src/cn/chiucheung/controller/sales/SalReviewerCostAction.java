package cn.chiucheung.controller.sales;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.market.costbudget.MarCostBudget;
import cn.chiucheung.po.purchase.material.PurMaterial;
import cn.chiucheung.po.sales.reviewer.SalReviewer;
import cn.chiucheung.po.sales.reviewer.SalReviewerSubsidiary;
import cn.chiucheung.po.sales.reviewer.SalReviewerWithBLOBs;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.purchase.material.PurMaterialQueryVo;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerCustom;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerQueryVo;
import cn.chiucheung.pojo.sales.reviewer.TaskCustom;
import cn.chiucheung.service.market.CostBudgetService;
import cn.chiucheung.service.purchase.MaterialService;
import cn.chiucheung.service.sales.ReviewerService;
import cn.chiucheung.service.system.UserService;
import cn.chiucheung.utils.HttpUtil;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UserUtils;
import cn.chiucheung.utils.WordGenerator;

@Controller
@RequestMapping("/sales/reviewerCost")
public class SalReviewerCostAction {
	
	@Autowired
	ReviewerService reviewerService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	HistoryService historyService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired 
	private CostBudgetService costBudgetService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="df",pid="dd")
	public String index(){
		return "sales/reviewerCost";
	}
	
	/**
	 * 新增项目信息评审表
	 * @param reviewerCustom
	 * @return
	 */
	@RequestMapping(value="saveReviewer")
	@ResponseBody
	@AnnotationLimit(mid="dfa",pid="df")
	public JSONObject saveReviewer(SalReviewerCustom reviewerCustom, HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try {
			reviewerService.saveReviewer(reviewerCustom, session);
			jsonObject.accumulate("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 查询所有的交期评审，用于页面的展示
	 * @return
	 */
	@RequestMapping("findAllSalReviewerList")
	@ResponseBody
	@AnnotationLimit(mid="df",pid="dd")
	public Map<String, Object> findAllSalReviewerList(SalReviewerQueryVo reviewerQueryVo, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(reviewerQueryVo.getAssignee())){
			reviewerQueryVo.setAssignee(UserUtils.getUserFromSession(session).getAssignee());
		}
		reviewerQueryVo.setIsCost(true);
		List<SalReviewerCustom> list = reviewerService.findAllSalReviewerList(reviewerQueryVo);
		map.put("rows", list);
		String total = reviewerService.findAllSalReviewerListTotal(reviewerQueryVo);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 根据交期评审id查找SalReviewerSubsidiary，用于页面的数据展开
	 * @return
	 */
	@RequestMapping("findAllSalReviewerSubsidiaryListBySalReviewerId")
	@ResponseBody
	@AnnotationLimit(mid="df",pid="dd")
	public List<SalReviewerCustom> findAllSalReviewerSubsidiaryListBySalReviewerId(String id){
		return reviewerService.findAllSalReviewerSubsidiaryListBySalReviewerId(id);
	}
	
	/**
	 * 根据交期评审id查找SalReviewer和关联的数据，用于页面的数据编辑
	 * @return
	 */
	@RequestMapping("findSalReviewerByIdForEdit")
	@ResponseBody
	@AnnotationLimit(mid="dfb",pid="df")
	public Map<String, Object> findSalReviewerByIdForEdit(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = reviewerService.findSalReviewerByIdForEdit(id, session);
			map.put("datas", datas);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 根据交期评审id查找SalReviewer和关联的数据，用于页面的数据编辑
	 * @return
	 */
	@RequestMapping("findSalReviewerByIdForView")
	@ResponseBody
	@AnnotationLimit(mid="df",pid="dd")
	public Map<String, Object> findSalReviewerByIdForView(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = reviewerService.findSalReviewerByIdForView(id);
			map.put("datas", datas);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 对用户名进行查找，是否存在，用于前台校验
	 * @param loginName 登录名
	 * @return
	 */
	@RequestMapping(value="checkUsernameIsRepeat")
	@ResponseBody
	@AnnotationLimit(mid="df",pid="dd")
	public String checkUsernameIsRepeat(String username){
		List<SysUser> list = userService.findAllSysUserByUsername(username);
		String message = "";
		if (list != null && list.size()>0){
			message = "ok";//说明存在
		}else{
			message = "no";
		}
		return message;
	}
	
	
	/**
	 * 修改项目信息评审表
	 * @param reviewerCustom
	 * @return
	 */
	@RequestMapping(value="updateReviewer")
	@ResponseBody
	@AnnotationLimit(mid="dfb",pid="df")
	public JSONObject updateReviewer(SalReviewerCustom reviewerCustom, HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try {
			reviewerService.updateReviewer(reviewerCustom, session);
			jsonObject.accumulate("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据id删除项目信息评审表
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteSalReviewerById")
	@ResponseBody
	@AnnotationLimit(mid="dfc",pid="df")
	public JSONObject deleteSalReviewerById(String id){
		JSONObject jsonObject = new JSONObject();
		try {
			reviewerService.deleteSalReviewerById(id);
			jsonObject.accumulate("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	/**
	 * 根据E6文档编号查询文档信息
	 * @param sn E6文档编号
	 * @param username E6用户名
	 * @param password E6密码
	 * @return
	 */
	@RequestMapping(value="findDocInfo")
	@ResponseBody
	@AnnotationLimit(mid="dfd",pid="df")
	public JSONObject findDocInfo(String sn, String username, String password){
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject = HttpUtil.findDocInfoBySn(sn, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("reason", e.getMessage());
		}
		return jsonObject;
	}
	
	
	/**
	 * 根据E6文档的id阅读文件
	 * edrawings:需要使用到下载 downLoadE6File
	 * AutoVueX：直接输入流就行    getE6FileInputStream
	 * @return
	 */
	@RequestMapping(value="readE6File")
	@AnnotationLimit(mid="dfe",pid="df")
	public String readE6File(String docId, String username, String password, Model model){
		try{
			username = ResourcesUtil.getValue("E6", "username");
			password = ResourcesUtil.getValue("E6", "password");
			String ticket = HttpUtil.getTicket(username, password);
			JSONObject jsonObject = HttpUtil.findDocInfoByDocId(docId, ticket);
			if (jsonObject.getBoolean("success")){
				model.addAttribute("reviewerFile", jsonObject);
				if (jsonObject.get("extension").equals("dwg")){
					model.addAttribute("url", "getE6FileInputStreamForDwg.action?ticket="+ticket+"&docId="+docId+"&ext=.dwg");
					return "readE6File";
				}else{
					//model.addAttribute("url", "getE6FileInputStream.action?ticket="+ticket+"&docId="+docId);
					return "redirect:getE6FileInputStream.action?ticket="+ticket+"&docId="+docId;
				}
			}else{
				throw new RuntimeException(jsonObject.getString("reason"));
			}
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			return "error";
		}
	}
	
	/**
	 * 根据E6文档的id获取文件的流
	 * @param 
	 * @return
	 */
	@RequestMapping(value="getE6FileInputStream")
	@AnnotationLimit(mid="dfe",pid="df")
	public String getE6FileInputStream(String docId, String ticket, HttpServletResponse response, Model model){
		InputStream inputStream = null;
		try {
			String url = ResourcesUtil.getValue("E6", "readFileUrl");
			inputStream = HttpUtil.getInputStream(url+"?ticket="+ticket+"&docId="+docId);
			if (inputStream.available() > 0){
				byte[] b = new byte[1024];
				int i = 0;
				while ((i = inputStream.read(b)) != -1) {
					response.getOutputStream().write(b, 0, i);
				}
				return null;
			}else{
				throw new RuntimeException("没有权限");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			return "error";
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
	}
	
	/**
	 * 根据E6文档的id获取文件的流,主要用于dwg，用edrawings的时候需要这样写出，用AutoVueX则用上面这个方面即可
	 * @param 
	 * @return
	 */
	@RequestMapping(value="getE6FileInputStreamForDwg")
	@AnnotationLimit(mid="dfe",pid="df")
	public String getE6FileInputStreamForDwg(String docId, String ticket, HttpServletResponse response){
		InputStream inputStream = null;
		try {
			String url = ResourcesUtil.getValue("E6", "readFileUrl");
			inputStream = HttpUtil.getInputStream(url+"?ticket="+ticket+"&docId="+docId);
			JSONObject jsonObject = HttpUtil.findDocInfoByDocId(docId, ticket);
			String fileName = jsonObject.getString("filename");
			fileName = URLEncoder.encode(fileName, "utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+fileName);  
			response.setHeader("Content-Length", jsonObject.getString("size"));
			response.setContentType("application/octet-stream; charset=utf-8");
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
	 * 根据E6文档的id下载文件
	 * @return
	 */
	@RequestMapping(value="downLoadE6File")
	@AnnotationLimit(mid="dff",pid="df")
	public String downLoadE6File(String docId, String username, String password, HttpServletResponse response, Model model){
		InputStream inputStream = null;
		try {
			String url = ResourcesUtil.getValue("E6", "downloadFileUrl");
			String ticket = HttpUtil.getTicket(username, password);
			JSONObject jsonObject = HttpUtil.findDocInfoByDocId(docId, ticket);
			if (jsonObject.getBoolean("success")){
				inputStream = HttpUtil.getInputStream(url+"?ticket="+ticket+"&docId="+docId);
				if (inputStream.available() > 0){
					String fileName = jsonObject.getString("filename");
					fileName = URLEncoder.encode(fileName, "utf-8");
					response.setHeader("Content-Disposition", "attachment; filename="+fileName);  
					response.setHeader("Content-Length", jsonObject.getString("size"));
					response.setContentType("application/octet-stream; charset=utf-8");  
					byte[] b = new byte[1024];
					int i = 0;
					while ((i = inputStream.read(b)) != -1) {
						response.getOutputStream().write(b, 0, i);
					}
					return null;
				}else{
					throw new RuntimeException("没有权限");
				}
			}else{
				throw new RuntimeException(jsonObject.getString("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
			return "error";
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
	}
	
	
	/**
	 * 导出word
	 * @return
	 */
	@RequestMapping(value="exportWord")
	@ResponseBody
	@AnnotationLimit(mid="dfh",pid="df")
	public String exportWord(String id, HttpServletResponse response){
		try {
			Map<String, Object> map = new HashMap<String, Object>();  
			Map<String, Object> datas = reviewerService.findSalReviewerByIdForView(id);
			SalReviewerWithBLOBs reviewerWithBLOBs = (SalReviewerWithBLOBs) datas.get("reviewer");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			map.put("quotationNo", reviewerWithBLOBs.getQuotationNo());
			map.put("infoRecordNumber", reviewerWithBLOBs.getInfoRecordNumber());
			map.put("createTime", reviewerWithBLOBs.getCreateTime() == null ? "" : dateFormat.format(reviewerWithBLOBs.getCreateTime()));
			map.put("project", reviewerWithBLOBs.getProject());
			map.put("otherProject", reviewerWithBLOBs.getOtherProject());
			map.put("projectContent", reviewerWithBLOBs.getProjectContent());
			map.put("packaging", reviewerWithBLOBs.getPackaging());
			map.put("otherPackaging", reviewerWithBLOBs.getOtherPackaging());
			map.put("delivery", reviewerWithBLOBs.getDelivery());
			map.put("otherDelivery", reviewerWithBLOBs.getOtherDelivery());
			map.put("salPreparer", reviewerWithBLOBs.getSalPreparer());
			map.put("destination", reviewerWithBLOBs.getDestination());
			map.put("isInstall", reviewerWithBLOBs.getIsInstall()?"是":"否");
			map.put("expectedLayoutDate", reviewerWithBLOBs.getExpectedLayoutDate() == null ? "" : dateFormat.format(reviewerWithBLOBs.getExpectedLayoutDate()));
			map.put("projectLeader", reviewerWithBLOBs.getProjectLeader());
			map.put("importance", reviewerWithBLOBs.getImportance());
			map.put("contractDeliveryDate", reviewerWithBLOBs.getContractDeliveryDate());
			map.put("salReviewer", reviewerWithBLOBs.getSalReviewer());
			map.put("requiredCostOfProject", reviewerWithBLOBs.getRequiredCostOfProject());
			map.put("requiredCompletionDate", reviewerWithBLOBs.getRequiredCompletionDate() == null ? "" : dateFormat.format(reviewerWithBLOBs.getRequiredCompletionDate()));
			map.put("aboutDepartment", reviewerWithBLOBs.getAboutDepartment());
			
			List<SalReviewerSubsidiary> reviewerSubsidiaries = (List<SalReviewerSubsidiary>) datas.get("reviewerSubsidiaries");
			for (int i = 0; i < reviewerSubsidiaries.size(); i++) {
				int j = i+1;
				SalReviewerSubsidiary reviewerSubsidiary = reviewerSubsidiaries.get(i);
				map.put("sequence" + j, reviewerSubsidiary.getSequence());
				map.put("productName" + j, reviewerSubsidiary.getProductName());
				map.put("productModel" + j, reviewerSubsidiary.getProductModel());
				map.put("quantity" + j, reviewerSubsidiary.getQuantity());
				map.put("category" + j, reviewerSubsidiary.getCategory());
				map.put("engActualNeedTime" + j, reviewerSubsidiary.getEngActualNeedTime());
				map.put("engExpectedStartTime" + j, reviewerSubsidiary.getEngExpectedStartTime() == null ? "" : dateFormat.format(reviewerSubsidiary.getEngExpectedStartTime()));
				map.put("engExpectedShortestCompletionTime" + j, reviewerSubsidiary.getEngExpectedShortestCompletionTime());
				map.put("engExpectedLongestCompletionTime" + j, reviewerSubsidiary.getEngExpectedLongestCompletionTime());
			}
			
			map.put("develop", reviewerWithBLOBs.getDevelop());
			map.put("specialMaterial", reviewerWithBLOBs.getSpecialMaterial());
			map.put("engRemark", reviewerWithBLOBs.getEngRemark());
			map.put("arrange", reviewerWithBLOBs.getArrange());
			map.put("engReviewer", reviewerWithBLOBs.getEngReviewer());
			map.put("engReviewerDate", reviewerWithBLOBs.getEngReviewerDate() == null ? "" : dateFormat.format(reviewerWithBLOBs.getEngReviewerDate()));
			
			map.put("purPeriod", reviewerWithBLOBs.getPurPeriod());
			map.put("purRemark", reviewerWithBLOBs.getPurRemark());
			map.put("purReviewer", reviewerWithBLOBs.getPurReviewer());
			map.put("purReviewerDate", reviewerWithBLOBs.getPurReviewerDate() == null ? "" : dateFormat.format(reviewerWithBLOBs.getPurReviewerDate()));
			
			map.put("proExpectedShortestCompletionTime", reviewerWithBLOBs.getProExpectedShortestCompletionTime());
			map.put("proExpectedLongestCompletionTime", reviewerWithBLOBs.getProExpectedLongestCompletionTime());
			map.put("installPeopleNumber", reviewerWithBLOBs.getInstallPeopleNumber());
			map.put("installPeriod", reviewerWithBLOBs.getInstallPeriod());
			map.put("isSpecialProcessing", reviewerWithBLOBs.getIsSpecialProcessing()?"有":"无");
			map.put("specialProcessing", reviewerWithBLOBs.getSpecialProcessing());
			map.put("proExpectedStartTime", reviewerWithBLOBs.getProExpectedStartTime() == null ? "" : dateFormat.format(reviewerWithBLOBs.getProExpectedStartTime()));
			map.put("proRemark", reviewerWithBLOBs.getProRemark());
			map.put("proPreparer", reviewerWithBLOBs.getProPreparer());
			map.put("proReviewer", reviewerWithBLOBs.getProReviewer());
			map.put("proReviewerDate", reviewerWithBLOBs.getProReviewerDate() == null ? "" : dateFormat.format(reviewerWithBLOBs.getProReviewerDate()));
			
			
			File file = WordGenerator.createDoc(map, "resume");
			FileInputStream fis = new FileInputStream(file);
			String fileName = reviewerWithBLOBs.getQuotationNo()+"项目评审表.doc";
			fileName = URLEncoder.encode(fileName, "utf-8");
			response.setHeader("Content-Disposition", "attachment; filename="+fileName);
			response.setContentType("application/msword");
			response.setHeader("Content-Length", fis.available()+"");
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = fis.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 根据交期评审id查找SalReviewer和关联的数据，用于页面的数据复制
	 * @return
	 */
	@RequestMapping("findSalReviewerByIdForCopy")
	@ResponseBody
	@AnnotationLimit(mid="dfa",pid="df")
	public Map<String, Object> findSalReviewerByIdForCopy(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = reviewerService.findSalReviewerByIdForView(id);
			map.put("datas", datas);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	
	
	
	//下面是生成工咔
	
	
	
	/**
	 * 根据交期评审id查找SalReviewer和关联的数据，用于生成工咭
	 * @return
	 */
	@RequestMapping("findSalReviewerByIdForGenerateWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="dfk",pid="df")
	public Map<String, Object> findSalReviewerByIdForGenerateWorkCard(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = reviewerService.findSalReviewerByIdForGenerateWorkCard(id);
			map.put("datas", datas);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 根据成本核算的id查询下一节点接收任务的人,如何未开始，则查询第一节点的接收人
	 * @param id
	 * @return
	 */
	@RequestMapping(value="queryAuditorById")
	@ResponseBody
	@AnnotationLimit(mid="dfi",pid="df")
	public Map<String, Object> queryAuditorById(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<SysUser> list = reviewerService.queryAuditorById(id, null, session);
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
	 * 审核成本核算
	 * @param id
	 * @param assigneeId 下一节点的接收人的id（为空代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	@RequestMapping(value="auditReviewer")
	@ResponseBody
	@AnnotationLimit(mid="dfi",pid="df")
	public Map<String, Object> auditReviewer(String id, String assigneeId, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			reviewerService.auditReviewer(id, assigneeId, session);
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
	@AnnotationLimit(mid="dfi",pid="df")
	public Map<String, Object> revokeProcess(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			reviewerService.revokeProcess(id, session);
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
	@RequestMapping(value="takeBackReviewer")
	@ResponseBody
	@AnnotationLimit(mid="dfi",pid="df")
	public Map<String, Object> takeBackReviewer(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			reviewerService.takeBackReviewer(id, cause, session);
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
	@RequestMapping(value="rollBackReviewer")
	@ResponseBody
	@AnnotationLimit(mid="dfi",pid="df")
	public Map<String, Object> rollBackReviewer(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			reviewerService.rollBackReviewer(id, cause, session);
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
	@RequestMapping(value="antiAuditReviewer")
	@ResponseBody
	@AnnotationLimit(mid="dfj",pid="df")
	public Map<String, Object> antiAuditReviewer(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			reviewerService.antiAuditReviewer(id, cause, session);
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
	@AnnotationLimit(mid="df",pid="dd")
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
	@AnnotationLimit(mid="df",pid="dd")
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
	
	
	
	
	
	
	
	/**
	 * 查找所有的物料
	 * @param materialQueryVo
	 * @return
	 */
	@RequestMapping("findAllPurMaterialList")
	@ResponseBody
	@AnnotationLimit(mid="dfk",pid="df")
	public Map<String, Object> findAllPurMaterialList(PurMaterialQueryVo materialQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<PurMaterial> materials = materialService.findAllPurMaterialList(materialQueryVo);
		String total  = materialService.findAllPurMaterialTotal(materialQueryVo);
		map.put("total", total);
		map.put("rows", materials);
		return map;
	}
	
	/**
	 * 根据salReviewerId查找CostBudget,用于在成本核算汇总界面，点击成本核算汇总的每条记录，显示出对应的成本分析表，而且只显示提交日期不为空的
	 * @param salReviewerId
	 * @return
	 */
	@RequestMapping("findCostBudgetListBySalReviewerId")
	@ResponseBody
	@AnnotationLimit(mid="dfk",pid="df")
	public List<MarCostBudget> findCostBudgetListBySalReviewerId(String salReviewerId,HttpSession session){
		List<Privilege> privileges = (List<Privilege>) session.getAttribute("privileges");
		return costBudgetService.findCostBudgetListBySalReviewerId(salReviewerId, privileges);
	}
	
	/**
	 * 下面开始是生成成本分析的
	 */
	
	/**
	 * 根据id查找SalReviewer，如果未完成审核，将抛出评审未完成，无法生成成本核算表的异常，如何完成审核则返回查找到的信息
	 * @return
	 */
	@RequestMapping(value="findSalReviewerByIdForGenerateCostBudget")
	@ResponseBody
	@AnnotationLimit(mid="dfl",pid="df")
	public Map<String, Object> findSalReviewerByIdForGenerateCostBudget(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SalReviewer reviewer = reviewerService.findSalReviewerByIdForGenerateCostBudget(id);
			map.put("success", true);
			map.put("reviewer", reviewer);
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 保存成本分析表
	 * @param map
	 * @return
	 */
	@RequestMapping(value="saveCostBudget")
	@ResponseBody
	@AnnotationLimit(mid="dfl",pid="df")
	public JSONObject saveCostBudget(@RequestBody Map<String, Object> map){
		JSONObject jsonObject = new JSONObject();
		try {
			costBudgetService.saveCostBudget(map);
			jsonObject.accumulate("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据id查找CoistBudget，用于前台数据的编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("findCostBudgetByIdForEdit")
	@ResponseBody
	@AnnotationLimit(mid="dfm",pid="df")
	public Map<String, Object> findCostBudgetByIdForEdit(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = costBudgetService.findCostBudgetById(id);
			map.put("datas", datas);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 根据id查找CoistBudget，用于前台数据的查看
	 * @param id
	 * @return
	 */
	@RequestMapping("findCostBudgetByIdForView")
	@ResponseBody
	@AnnotationLimit(mid="dfm",pid="df")
	public Map<String, Object> findCostBudgetByIdForView(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = costBudgetService.findCostBudgetById(id);
			map.put("datas", datas);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 更新成本分析表
	 * @param map
	 * @return
	 */
	@RequestMapping(value="updateCostBudget")
	@ResponseBody
	@AnnotationLimit(mid="dfm",pid="df")
	public JSONObject updateCostBudget(@RequestBody Map<String, Object> map){
		JSONObject jsonObject = new JSONObject();
		try {
			costBudgetService.updateCostBudget(map);
			jsonObject.accumulate("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据删除成本分析表
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteCostBudgetById")
	@ResponseBody
	@AnnotationLimit(mid="dfn",pid="df")
	public JSONObject deleteCostBudgetById(String id){
		JSONObject jsonObject = new JSONObject();
		try {
			costBudgetService.deleteCostBudgetById(id);
			jsonObject.accumulate("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 取消关联
	 * @param id
	 * @return
	 */
	@RequestMapping(value="cancelAssociatedCostBudgetById")
	@ResponseBody
	@AnnotationLimit(mid="dfo",pid="df")
	public JSONObject cancelAssociatedCostBudgetById(String id){
		JSONObject jsonObject = new JSONObject();
		try {
			costBudgetService.updateCostBudgetByIdForCancelAssociated(id);
			jsonObject.accumulate("success", true);
		} catch (Exception e) {
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
