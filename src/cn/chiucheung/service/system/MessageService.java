package cn.chiucheung.service.system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.chiucheung.po.system.message.SysMessage;
import cn.chiucheung.pojo.system.message.AuditCustom;
import cn.chiucheung.pojo.system.message.AuditQueryVo;
import cn.chiucheung.pojo.system.message.MessageQueryVo;

public interface MessageService {
	
	/**
	 * 除去的id查找SysMessage
	 * @param ids 被出去的id
	 * @param loginName 当前用户的登录名
	 * @return
	 */
	Map<String, Object> getMessageAndOnlineUserTotalAndSubjectAuditCount(String ids, HttpSession session);
	
	/**
	 * 将消息设为已读
	 * @param id
	 */
	void updateMessageIsReadById(String id);
	
	/**
	 * 根据当前的登录名查找所有的发送和接收到的消息
	 * @param messageQueryVo 查询条件及分页信息
	 * @return
	 */
	List<SysMessage> showAllMessage(MessageQueryVo messageQueryVo);
	
	/**
	 * 根据当前的登录名查找所有的发送和接收到的消息的总记录数
	 * @param messageQueryVo 查询条件
	 * @return
	 */
	int findAllMessageTotal(MessageQueryVo messageQueryVo);
	
	/**
	 * 根据条件查询审批
	 * @param auditQueryVo state(0:待审批；1:已审批；2:已发送审批（发起的审批）) 分页排序的查询条件,
	 * @return
	 */
	List<AuditCustom> showAllAuditByState(AuditQueryVo auditQueryVo, HttpServletRequest request);
	
	/**
	 * 根据条件查询审批的总记录数
	 * @param auditQueryVo state(0:待审批；1:已审批；2:已发送审批（发起的审批）) 分页排序的查询条件,
	 * @return
	 */
	String showAllAuditTotalByState(AuditQueryVo auditQueryVo);


}
