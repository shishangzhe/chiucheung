package cn.chiucheung.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.po.system.message.SysMessage;
import cn.chiucheung.pojo.system.message.AuditCustom;
import cn.chiucheung.pojo.system.message.AuditQueryVo;
import cn.chiucheung.pojo.system.message.MessageQueryVo;
import cn.chiucheung.service.production.StorageWarehouseWorkCardService;
import cn.chiucheung.service.sales.ReviewerService;
import cn.chiucheung.service.sales.WorkCardService;
import cn.chiucheung.service.system.MessageService;
import cn.chiucheung.service.warehouse.StorageWarehouseWorkCardStockInService;
import cn.chiucheung.service.warehouse.StandardAccessoriesStockOutService;
import cn.chiucheung.utils.UserUtils;

@Controller
@RequestMapping("/system/message")
public class SysMessageAction {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ReviewerService reviewerService;
	
	@Autowired
	private WorkCardService workCardService;
	
	@Autowired
	private StorageWarehouseWorkCardService storageWarehouseWorkCardService;
	
	@Autowired
	private StorageWarehouseWorkCardStockInService storageWarehouseWorkCardStockInService;
	
	@Autowired
	private StandardAccessoriesStockOutService standardAccessoriesStockOutService;
	
	/**
	 * 获取所有的消息，除去已显示的消息
	 * @return
	 */
	@RequestMapping(value="findMessageAndOnlineUserInfo")
	@ResponseBody
	public Map<String, Object> getMessageAndOnlineUserTotalAndSubjectAuditCount(String ids, HttpSession session){
		return messageService.getMessageAndOnlineUserTotalAndSubjectAuditCount(ids, session);
	}
	
	
	/**
	 * 获取所有的消息，除去已显示的消息
	 * @return
	 */
	@RequestMapping(value="updateMessageIsReadById")
	@ResponseBody
	public String updateMessageIsReadById(String id){
		messageService.updateMessageIsReadById(id);
		return null;
	}
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping(value="index")
	public String index(){
		return "system/message";
	}
	
	/**
	 * 查找所有的消息，放到request域中
	 * @return
	 */
	@RequestMapping(value="showAllMessage")
	public String showAllMessage(MessageQueryVo messageQueryVo, HttpSession session, Model model){
		messageQueryVo.setLoginName(UserUtils.getUserFromSession(session).getLoginName());
		int i = messageQueryVo.getBeginResult();
		List<SysMessage> list = messageService.showAllMessage(messageQueryVo);
		int totalResult = messageService.findAllMessageTotal(messageQueryVo);
		messageQueryVo.setTotalResult(totalResult);
		model.addAttribute("list", list);
		model.addAttribute("page", messageQueryVo.getPageBean());
		model.addAttribute("keyword", messageQueryVo.getKeyword());
		return "system/message";
	}
	
	
	/**
	 * 审批的跳转
	 * @return
	 */
	@RequestMapping(value="auditIndex")
	public String auditIndex(){
		return "system/audit";
	}
	
	/**
	 * 根据条件查询审批
	 * @param state 0:待审批；1:已审批；2:已发送审批（发起的审批）
	 * @param session 用于取当前用户
	 * @return
	 */
	@RequestMapping(value="showAllAuditByState")
	@ResponseBody
	public Map<String, Object> showAllAuditByState(AuditQueryVo auditQueryVo, HttpSession session, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		
		auditQueryVo.setAssignee(UserUtils.getUserFromSession(session).getAssignee());
		List<AuditCustom> list = messageService.showAllAuditByState(auditQueryVo, request);
		map.put("rows", list);
		
		String total = messageService.showAllAuditTotalByState(auditQueryVo);
		map.put("total", total);
		return map;
	}
	
	
	/**
	 * 退回到上一节点
	 * @param processInstanceId 流程实例的id
	 * @param 项目评审表的id
	 */
	@RequestMapping(value="rollBack",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String rollBack(String id, String cause, String modularState, HttpSession session){
		try {
			if ("0".equals(modularState)){
				reviewerService.rollBackReviewer(id, cause, session);
			}else if ("1".equals(modularState)){
				workCardService.rollBackWorkCard(id, cause, session);
			}else if ("2".equals(modularState)){
				throw new RuntimeException("该模块不支持退回操作！");
			}else if ("3".equals(modularState)){
				storageWarehouseWorkCardService.rollBackProStorageWarehouseWorkCard(id, cause, session);
			}else if ("4".equals(modularState)){
				storageWarehouseWorkCardStockInService.rollBackWarStorageWarehouseWorkCardStockIn(id, cause, session);
			}else if ("5".equals(modularState)){
				standardAccessoriesStockOutService.rollBackWarStandardAccessoriesStockOut(id, cause, session);
			}else{
				throw new RuntimeException("modularState Exception");
			}
			return "退回成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"退回失败</br>" + "<font color='red'>" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 重新开始评审
	 * @param processInstanceId 已评审完的processInstanceId，要删除processInstanceId先关的信息
	 * @param id
	 */
	@RequestMapping(value="reAudit",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String reAudit(String id, String cause, String modularState, HttpSession session){
		try {
			if ("0".equals(modularState)){
				reviewerService.antiAuditReviewer(id, cause, session);
			}else if ("1".equals(modularState)){
				workCardService.antiAuditWorkCard(id, cause, session);
			}else if ("2".equals(modularState)){
				workCardService.antiAuditWorkCardFile(id, cause, session);
			}else if ("3".equals(modularState)){
				storageWarehouseWorkCardService.antiAuditProStorageWarehouseWorkCard(id, cause, session);
			}else if ("4".equals(modularState)){
				storageWarehouseWorkCardStockInService.antiAuditWarStorageWarehouseWorkCardStockIn(id, cause, session);
			}else if ("5".equals(modularState)){
				standardAccessoriesStockOutService.reAuditWarStandardAccessoriesStockOut(id, cause, session);
			}else{
				throw new RuntimeException("modularState Exception");
			}
			return "重新审核成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"重新审核失败</br>" + "<font color='red'>" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 收回评审
	 * @param processInstanceId 流程实例的id
	 * @param id
	 */
	@RequestMapping(value="takeBack",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String takeBack(String id, String cause, String modularState, HttpSession session){
		try {
			if ("0".equals(modularState)){
				reviewerService.takeBackReviewer(id, cause, session);
			}else if ("1".equals(modularState)){
				workCardService.takeBackWorkCard(id, cause, session);
			}else if ("2".equals(modularState)){
				throw new RuntimeException("该模块不支持收回操作！");
			}else if ("3".equals(modularState)){
				storageWarehouseWorkCardService.takeBackProStorageWarehouseWorkCard(id, cause, session);
			}else if ("4".equals(modularState)){
				storageWarehouseWorkCardStockInService.takeBackWarStorageWarehouseWorkCardStockIn(id, cause, session);
			}else if ("5".equals(modularState)){
				standardAccessoriesStockOutService.takeBackWarStandardAccessoriesStockOut(id, cause, session);
			}else{
				throw new RuntimeException("modularState Exception");
			}
			return "收回审核成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"收回审核失败</br>" + "<font color='red'>" +e.getMessage() + "<font/><div/>";
		}
	}
}
