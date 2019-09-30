package cn.chiucheung.service.sales;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.chiucheung.po.sales.reviewer.SalReviewer;
import cn.chiucheung.po.sales.reviewer.SalReviewerFile;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerCustom;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerQueryVo;

public interface ReviewerService {
	/**
	 * 新增项目信息评审表
	 * @param reviewerCustom 页面传过来的数据
	 */
	int saveReviewer(SalReviewerCustom reviewerCustom, HttpSession session) throws Exception;
	
	/**
	 * 查询所有的交期评审表
	 * @param reviewerQueryVo 查询条件
	 * @param session 
	 * @return
	 */
	List<SalReviewerCustom> findAllSalReviewerList(SalReviewerQueryVo reviewerQueryVo);
	
	/**
	 * 查询所有的交期评审表的总数
	 * @param reviewerQueryVo 查询条件
	 * @param session 
	 * @return
	 */
	String findAllSalReviewerListTotal(SalReviewerQueryVo reviewerQueryVo);
	
	/**
	 * 根据交期评审表的id查询SalReviewerSubsidiary
	 * @param id 交期评审表的id
	 * @return
	 */
	List<SalReviewerCustom> findAllSalReviewerSubsidiaryListBySalReviewerId(String id);
	
	/**
	 * 很据id查找SalReviewer的数据和关联的数据，用于页面编辑
	 * @param id
	 * @return
	 */
	Map<String, Object> findSalReviewerByIdForEdit(String id, HttpSession session);

	/**
	 * 很据id查找SalReviewer的数据和关联的数据，用于页面查看
	 * @param id
	 * @return
	 */
	Map<String, Object> findSalReviewerByIdForView(String id);
	
	/**
	 * 根据id查找SalReviewerFile
	 * @param id
	 * @return
	 */
	SalReviewerFile findSalReviewerFileById(String id);
	
	/**
	 * 修改项目信息评审表
	 * @param reviewerCustom
	 */
	int updateReviewer(SalReviewerCustom reviewerCustom, HttpSession session) throws Exception;
	
	/**
	 * 根据id删除项目信息评审表
	 * @param id
	 */
	int deleteSalReviewerById(String id);
	
	/**
	 * 生成工咭
	 * @param id
	 * @return
	 */
	Map<String, Object> findSalReviewerByIdForGenerateWorkCard(String id);
	
	/**
	 * 根据项目信息评审表的id查询下一节点接收任务的人,如何未开始，则查询第一节点的接收人
	 * @param id
	 * @return
	 */
	List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session);

	/**
	 * 审核项目信息评审表
	 * @param id
	 * @param assigneeId 下一节点的接收人（为空代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	void auditReviewer(String id, String assigneeId, HttpSession session);

	/**
	 * 撤销流程
	 * @param id
	 * @param session
	 * @return
	 */
	void revokeProcess(String id, HttpSession session);

	/**
	 * 收回评审
	 * @param id
	 * @return
	 */
	void takeBackReviewer(String id, String cause, HttpSession session);
	
	/**
	 * 退回到上一节点
	 * @param id
	 * @param cause
	 * @return
	 */
	void rollBackReviewer(String id, String cause, HttpSession session);

	/**
	 * 反评审
	 * @param id
	 * @param cause
	 * @return
	 */
	void antiAuditReviewer(String id, String cause, HttpSession session);
	
	/**
	 * 根据id查找成本核算，不需要子数据
	 * @param id
	 * @return
	 */
	SalReviewer findSalReviewerByIdForGenerateCostBudget(String id);
	
	/**
	 * 查找所有已经审核完成的评审
	 * @param reviewerQueryVo
	 * @return
	 */
	List<SalReviewerCustom> findCompleteReviewerCostCollect(SalReviewerQueryVo reviewerQueryVo);
}
