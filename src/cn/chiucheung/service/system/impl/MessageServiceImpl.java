package cn.chiucheung.service.system.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import cn.chiucheung.dao.mapper.system.message.SysMessageMapper;
import cn.chiucheung.po.system.message.SysMessage;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.system.message.AuditCustom;
import cn.chiucheung.pojo.system.message.AuditQueryVo;
import cn.chiucheung.pojo.system.message.MessageQueryVo;
import cn.chiucheung.pojo.system.message.SysMessageVo;
import cn.chiucheung.service.system.MessageService;
import cn.chiucheung.utils.UserUtils;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private SysMessageMapper messageMapper;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private HistoryService historyService;
	
	@Override
	public Map<String, Object> getMessageAndOnlineUserTotalAndSubjectAuditCount(String ids, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		//获取新消息
		SysMessageVo messageVo = new SysMessageVo();
		if (ids != null){
			messageVo.setIds(Arrays.asList(ids.split(",")));
		}
		messageVo.setLoginName(UserUtils.getUserFromSession(session).getLoginName());
		List<SysMessage> list = messageMapper.findMessageByNotInIdWithLoginName(messageVo);
		
		JSONArray messageArray = new JSONArray();
		for (SysMessage message : list){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			JSONObject object = new JSONObject();
			object.accumulate("id", message.getId());
			StringBuffer messageBuffer = new StringBuffer();
			messageBuffer.append("<font color='#3090C7'>")
						.append(message.getSender())
						.append("&nbsp;&nbsp;&nbsp;&nbsp;")
						.append(dateFormat.format(message.getSendTime()))
						.append("</font><br/>")
						.append(message.getMessage() == null ? "": message.getMessage());
			
			object.accumulate("message", messageBuffer.toString());
			messageArray.add(object);
		}
		map.put("newMessage", messageArray);
		
		
		//获取在线用户数
		ServletContext application = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		Map<SysUser, HttpSession> userMap = (Map<SysUser, HttpSession>) application.getAttribute("userMap");
		map.put("onlineUserTotal", userMap.size());
		
		
		//获取所有待评审条数
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.taskAssignee(UserUtils.getUserFromSession(session).getAssignee());
		List<Task> tasks = taskQuery.list();
		map.put("auditCount", tasks.size() > 0 ? tasks.size() : "");
		return map;
	}

	@Override
	public void updateMessageIsReadById(String id) {
		SysMessage message = new SysMessage();
		message.setId(id);
		message.setIsRead(true);
		messageMapper.updateByPrimaryKeySelective(message);
	}

	@Override
	public List<SysMessage> showAllMessage(MessageQueryVo messageQueryVo) {
		List<SysMessage> list = messageMapper.showAllMessage(messageQueryVo);
		/*SysMessageExample example = new SysMessageExample();
		example.setOrderByClause("send_time desc");
		List<SysMessage> list = messageMapper.selectByExample(example);*/
		return list;
	}
	

	@Override
	public int findAllMessageTotal(MessageQueryVo messageQueryVo) {
		return messageMapper.findAllMessageTotal(messageQueryVo);
	}

	@Override
	public List<AuditCustom> showAllAuditByState(AuditQueryVo auditQueryVo, HttpServletRequest request) {
		List<AuditCustom> list = messageMapper.findAllAuditByAuditQueryVo(auditQueryVo);
		for (AuditCustom auditCustom : list) {
			switch (auditQueryVo.getModularState()) {
			case 0://项目评审表
				switch (auditQueryVo.getAuditState()) {
				case 0://待审批
					String taskDefinitionKey = auditCustom.getTaskDefinitionKey();
					StringBuffer buffer = new StringBuffer();
					
					if (("reviewer").equals(auditCustom.getProcessDefinitionKey())){//交期评审
						if (taskDefinitionKey.equals("createReviewer") || taskDefinitionKey.equals("saleReviewer")){//销售的
							buffer.append("<a href='#' onclick='window.top.Open(\"项目信息评审-交期评审\", \"/sales/reviewer/index.action\");'>");
						}else if (taskDefinitionKey.equals("engDistribution") || taskDefinitionKey.equals("engWrite") || taskDefinitionKey.equals("engReviewer")){//工程的
							buffer.append("<a href='#' onclick='window.top.Open(\"工程项目信息评审\", \"/engineering/reviewer/index.action\");'>");
						}else if (taskDefinitionKey.equals("purReviewer")){//采购
							buffer.append("<a href='#' onclick='window.top.Open(\"采购项目评审表\", \"/purchase/reviewer/index.action\");'>");
						}else if (taskDefinitionKey.equals("proReviewer")){//生产
							buffer.append("<a href='#' onclick='window.top.Open(\"生产项目信息评审\", \"/production/reviewer/index.action\");'>");
						}
					}else if (("reviewerCost").equals(auditCustom.getProcessDefinitionKey())){//成本核算
						buffer.append("<a href='#' onclick='window.top.Open(\"项目信息评审-成本核算\", \"/sales/reviewerCost/index.action\");'>");
					}
					
					buffer.append(auditCustom.getName());
					buffer.append("</a>");
					auditCustom.setName(buffer.toString());
					break;
				case 1://已审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				case 2://已发送审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				}
				break;
			case 1://工咭
				switch (auditQueryVo.getAuditState()) {
				case 0://待审批
					StringBuffer buffer = new StringBuffer();
					
					buffer.append("<a href='#' onclick='window.top.Open(\"工咭\", \"/sales/workCard/index.action\");'>");
					
					buffer.append(auditCustom.getName());
					buffer.append("</a>");
					auditCustom.setName(buffer.toString());
					break;
				case 1://已审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				case 2://已发送审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				}
				break;
			case 2://工咭相关资料
				switch (auditQueryVo.getAuditState()) {
				case 0://待审批
					auditCustom.setName("<a href='" + request.getContextPath() + "/sales/workCardCollect/readFileById.action?id="+auditCustom.getId()+"' target='_blank'>"+auditCustom.getName()+"</a>");
					break;
				case 1://已审批
					auditCustom.setName("<a href='" + request.getContextPath() + "/sales/workCardCollect/readFileById.action?id="+auditCustom.getId()+"' target='_blank'>"+auditCustom.getName()+"</a>");
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				case 2://已发送审批
					auditCustom.setName("<a href='" + request.getContextPath() + "/sales/workCardCollect/readFileById.action?id="+auditCustom.getId()+"' target='_blank'>"+auditCustom.getName()+"</a>");
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				}
				break;
			case 3://存仓工咭
				switch (auditQueryVo.getAuditState()) {
				case 0://待审批
					StringBuffer buffer = new StringBuffer();
					
					buffer.append("<a href='#' onclick='window.top.Open(\"存仓工咭\", \"/production/storageWarehouseWorkCard/index.action\");'>");
					
					buffer.append(auditCustom.getName());
					buffer.append("</a>");
					auditCustom.setName(buffer.toString());
					break;
				case 1://已审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				case 2://已发送审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				}
				break;
			case 4://标准配件入库
				switch (auditQueryVo.getAuditState()) {
				case 0://待审批
					StringBuffer buffer = new StringBuffer();
					
					buffer.append("<a href='#' onclick='window.top.Open(\"标准配件入库单\", \"/warehouse/standardAccessoriesStockIn/index.action\");'>");
					
					buffer.append(auditCustom.getName());
					buffer.append("</a>");
					auditCustom.setName(buffer.toString());
					break;
				case 1://已审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				case 2://已发送审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				}
				break;
			case 5://标准配件出库
				switch (auditQueryVo.getAuditState()) {
				case 0://待审批
					StringBuffer buffer = new StringBuffer();
					
					buffer.append("<a href='#' onclick='window.top.Open(\"标准配件出库单\", \"/warehouse/standardAccessoriesStockOut/index.action\");'>");
					
					buffer.append(auditCustom.getName());
					buffer.append("</a>");
					auditCustom.setName(buffer.toString());
					break;
				case 1://已审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				case 2://已发送审批
					if (auditCustom.getEndTime() != null){//审批已完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryTaskByProcessInstanceId.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核完成</a>");
					}else{//审批未完成
						auditCustom.setAuditStateUrl("<a href='"+request.getContextPath()+"/system/flow/queryActivityMap.action?processInstanceId="+auditCustom.getProcessInstanceId()+"' target='_blank'>审核中</a>");
					}
					break;
				}
				break;
			}
		}
		return list;
	}

	@Override
	public String showAllAuditTotalByState(AuditQueryVo auditQueryVo) {
		return messageMapper.findAllAuditTotalByAuditQueryVo(auditQueryVo);
	}


}
