package cn.chiucheung.service.sales;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.po.sales.workcard.SalWorkCardFile;
import cn.chiucheung.po.system.user.SysUser;
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

public interface WorkCardService {
	
	/**
	 * 根据salWorkCardSubsidiary的id查找salWorkCardSubsidiary，用来新增修改做货确认单的数据填充
	 * @param id
	 * @return
	 */
	SalWorkCardConfirmation findSalWorkCardSubsidiaryById(String id);

	/**
	 * 新增工咭
	 * @param workCardCustom
	 * @param session 
	 * @return
	 * @throws Exception 
	 */
	int saveWorkCard(SalWorkCardCustom workCardCustom, MultipartFile drawings, HttpSession session) throws Exception;
	
	/**
	 * 根据SalWordCardFile的id读取文件
	 * @param id
	 * @return
	 */
	SalWorkCardFile findFileById(String id);
	
	/**
	 * 根据SalWordCardFile的id删除文件
	 * @param id
	 * @return
	 */
	int deleteFileById(String id, HttpServletRequest request);
	
	/**
	 * 查找所有的工咭
	 * @param workCardQueryVo 查找的条件
	 * @param session 
	 * @return
	 */
	List<SalWorkCardShowDataCustom> findAllWorkCardList(SalWorkCardQueryVo workCardQueryVo);

	/**
	 * 查找所有的工咭的总数
	 * @param workCardQueryVo 查找的条件
	 * @return
	 */
	String findAllWorkCardListCount(SalWorkCardQueryVo workCardQueryVo);
	
	/**
	 * 用于页面展开数据
	 * @param workCardId
	 * @return
	 */
	List<SalWorkCardSubsidiaryCustom> findAllSalWorkCardSubsidiaryListBySalWorkCardId(String id);
	

	/**
	 * 根据id查找工咭数据，给页面展示
	 * @param id
	 * @return
	 */
	Map<String, Object> findSalWorkCardByIdForEdit(String id, HttpSession session);
	
	/**
	 * 根据id查找工咭数据，给页面展示
	 * @param id
	 * @return
	 */
	Map<String, Object> findSalWorkCardByIdForView(String id);
	
	/**
	 * 修改工咭
	 * @param workCardCustom
	 * @param request 
	 * @return
	 * @throws Exception 
	 */
	int updateWorkCard(SalWorkCardCustom workCardCustom,MultipartFile drawings, HttpSession session) throws Exception;
	
	/**
	 * 删除工咭
	 * @param id
	 * @param request 
	 * @return 未删除成功的文件数
	 * @throws Exception 
	 */
	int deleteSalWorkCardById(String id) throws Exception;
	
	/**
	 * 新增做货确认单-控制台
	 * @param workCardKztCustom
	 * @return
	 */
	int saveWorkCardKzt(SalWorkCardKztCustom workCardKztCustom) throws Exception;
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardKzt和WorkCardKztOther
	 * @param workCardSubsidiaryId
	 * @return
	 */
	SalWorkCardKztCustom findWorkCardKztByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception;
	
	/**
	 * 更新做货确认单-控制台
	 * @param workCardKztCustom
	 * @return
	 */
	int updateWorkCardKzt(SalWorkCardKztCustom workCardKztCustom) throws Exception;
	
	/**
	 * 删除做货确认单-控制台
	 * @param workCardSubsidiaryId
	 * @return
	 */
	int deleteWorkCardKztByWorkCardSubsidiaryId(String workCardSubsidiaryId);
	
	/**
	 * 新增做货确认单-电视墙
	 * @param workCardDsqCustom
	 * @return
	 */
	int saveWorkCardDsq(SalWorkCardDsqCustom workCardDsqCustom) throws Exception;
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardDsq和WorkCardDsqOther
	 * @param workCardSubsidiaryId
	 * @return
	 */
	SalWorkCardDsqCustom findWorkCardDsqByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception;
	
	/**
	 * 更新做货确认单-电视墙
	 * @param workCardDsqCustom
	 * @return
	 */
	int updateWorkCardDsq(SalWorkCardDsqCustom workCardDsqCustom) throws Exception;
	
	/**
	 * 删除做货确认单-电视墙
	 * @param workCardSubsidiaryId
	 * @return
	 */
	int deleteWorkCardDsqByWorkCardSubsidiaryId(String workCardSubsidiaryId);
	
	/**
	 * 新增做货确认单-机柜RK III
	 * @param workCardJg3Custom
	 * @return
	 */
	int saveWorkCardJg3(SalWorkCardJg3Custom workCardJg3Custom) throws Exception;
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardJg3
	 * @param workCardSubsidiaryId
	 * @return
	 */
	SalWorkCardJg3Custom findWorkCardJg3ByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception;
	
	/**
	 * 更新做货确认单-机柜RK III
	 * @param workCardJg3Custom
	 * @return
	 */
	int updateWorkCardJg3(SalWorkCardJg3Custom workCardJg3Custom) throws Exception;

	/**
	 * 删除做货确认单-机柜RK III
	 * @param workCardSubsidiaryId
	 * @return
	 */
	int deleteWorkCardJg3ByWorkCardSubsidiaryId(String workCardSubsidiaryId);
	
	/**
	 * 新增做货确认单-机柜RK V
	 * @param workCardJg5Custom
	 * @return
	 */
	int saveWorkCardJg5(SalWorkCardJg5Custom workCardJg5Custom) throws Exception;
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardJg5
	 * @param workCardSubsidiaryId
	 * @return
	 */
	SalWorkCardJg5Custom findWorkCardJg5ByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception;
	
	/**
	 * 更新做货确认单-机柜RK V
	 * @param workCardJg5Custom
	 * @return
	 */
	int updateWorkCardJg5(SalWorkCardJg5Custom workCardJg5Custom) throws Exception;
	
	/**
	 * 删除做货确认单-机柜RK V
	 * @param workCardSubsidiaryId
	 * @return
	 */
	int deleteWorkCardJg5ByWorkCardSubsidiaryId(String workCardSubsidiaryId);
	
	/**
	 * 新增做货确认单-机柜RK VI
	 * @param workCardJg6Custom
	 * @return
	 */
	int saveWorkCardJg6(SalWorkCardJg6Custom workCardJg6Custom) throws Exception;
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardJg6
	 * @param workCardSubsidiaryId
	 * @return
	 */
	SalWorkCardJg6Custom findWorkCardJg6ByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception;
	
	/**
	 * 更新做货确认单-机柜RK VI
	 * @param workCardJg6Custom
	 * @return
	 */
	int updateWorkCardJg6(SalWorkCardJg6Custom workCardJg6Custom) throws Exception;
	
	/**
	 * 删除做货确认单-机柜RK VI
	 * @param workCardSubsidiaryId
	 * @return
	 */
	int deleteWorkCardJg6ByWorkCardSubsidiaryId(String workCardSubsidiaryId);
	
	/**
	 * 新增做货确认单-机柜配件
	 * @param workCardEiaCustom
	 * @return
	 */
	int saveWorkCardEia(SalWorkCardEiaCustom workCardEiaCustom) throws Exception;
	
	/**
	 * 根据workCardSubsidiaryId查找WorkCardEia和WorkCardEiaOther
	 * @param workCardSubsidiaryId
	 * @return
	 */
	SalWorkCardEiaCustom findWorkCardEiaByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception;
	
	/**
	 * 更新做货确认单-机柜配件
	 * @param workCardEiaCustom
	 * @return
	 */
	int updateWorkCardEia(SalWorkCardEiaCustom workCardEiaCustom) throws Exception;

	/**
	 * 删除做货确认单-机柜配件
	 * @param workCardEiaCustom
	 * @return
	 */
	int deleteWorkCardEiaByWorkCardSubsidiaryId(String workCardSubsidiaryId);
	
	/**
	 * 根据工咭的id查询下一节点接收任务的人,如何未开始，则查询第一节点的接收人
	 * @param id
	 * @return
	 */
	List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session);

	/**
	 * 审核工咭
	 * @param id
	 * @param assigneeId 下一节点的接收人（为空代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	void auditWorkCard(String id, String assigneeId, HttpSession session);

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
	void takeBackWorkCard(String id, String cause, HttpSession session);
	
	/**
	 * 退回到上一节点
	 * @param id
	 * @param cause
	 * @return
	 */
	void rollBackWorkCard(String id, String cause, HttpSession session);

	/**
	 * 反评审
	 * @param id
	 * @param cause
	 * @return
	 */
	void antiAuditWorkCard(String id, String cause, HttpSession session);
	
	/**
	 * 根据工咭id查找工咭相关资料
	 * @param workCardId
	 */
	List<SalWorkCardFile> findWorkCardFileListBySalWorkCardId(String salReviewerId, HttpServletRequest request);
	
	/**
	 * 上传工咭相关资料
	 * @param id
	 * @param workCardNo
	 * @param workCardFile
	 */
	int saveWorkCardFile(String id, String workCardNo,MultipartFile workCardFile, HttpSession session) throws Exception;

	/**
	 * 删除工咭相关资料
	 * @param id workCardFile的id
	 * @return
	 */
	int deleteWorkCardFile(String id);

	/**
	 * 根据工咭相关资料的id查询下一节点接收任务的人,如何未开始，则查询第一节点的接收人
	 * @param id
	 * @return
	 */
	List<SysUser> queryAuditorForWorkCardFileById(String id, String processInstanceId, HttpSession session);

	/**
	 * 审核工咭相关资料
	 * @param id
	 * @param assigneeIds 下一节点的所有接收人的id（为空代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	void auditWorkCardFile(String id, String assigneeIds, HttpSession session);

	/**
	 * 撤销流程
	 * @param id
	 * @param session
	 * @return
	 */
	void revokeProcessWorkCardFile(String id, HttpSession session);

	/**
	 * 反审核
	 * @param id
	 * @param cause
	 * @return
	 */
	void antiAuditWorkCardFile(String id, String cause, HttpSession session);

}
