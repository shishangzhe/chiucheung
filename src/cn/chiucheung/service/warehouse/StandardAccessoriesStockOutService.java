package cn.chiucheung.service.warehouse;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOut;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutCustom;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutQueryVo;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiaryCustom;

public interface StandardAccessoriesStockOutService {

	/**
	 * 查找所有的出库单
	 * @param standardAccessoriesStockOutQueryVo 查询条件
	 * @return
	 */
	List<WarStandardAccessoriesStockOut> findAllWarStandardAccessoriesStockOutList(WarStandardAccessoriesStockOutQueryVo standardAccessoriesStockOutQueryVo);
	
	/**
	 * 查询所有的出库单的总数
	 * @param standardAccessoriesStockOutQueryVo 查询条件
	 * @return
	 */
	String findAllWarStandardAccessoriesStockOutTotal(WarStandardAccessoriesStockOutQueryVo standardAccessoriesStockOutQueryVo);
	
	/**
	 * 页面tree的数据展开
	 * @param warStandardAccessoriesStockOutId
	 * @return
	 */
	List<WarStandardAccessoriesStockOutSubsidiaryCustom> findAllWarStandardAccessoriesStockOutSubsidiaryListByWarStandardAccessoriesStockOutId(String warStandardAccessoriesStockOutId);

	/**
	 * 新增出库单
	 * @param standardAccessoriesStockOutCustom
	 * @param session
	 * @return
	 */
	int saveWarStandardAccessoriesStockOut(WarStandardAccessoriesStockOutCustom standardAccessoriesStockOutCustom,HttpSession session) throws Exception;
	
	/**
	 * 根据id查找出库单
	 * @param id
	 * @return
	 */
	WarStandardAccessoriesStockOutCustom findWarStandardAccessoriesStockOutByIdForEdit(String id) throws Exception;
	
	/**
	 * 更新出库单
	 * @param standardAccessoriesStockOutCustom
	 * @return
	 */
	int updateWarStandardAccessoriesStockOut(WarStandardAccessoriesStockOutCustom standardAccessoriesStockOutCustom) throws Exception;

	/**
	 * 根据id删除出库单
	 * @param id
	 * @return
	 */
	int deleteWarStandardAccessoriesStockOutById(String id);

	/**
	 * 根据processinstanceId查询下一节点接收任务的人
	 * @param id
	 * @return
	 */
	List<SysUser> queryAuditorByProcessInstanceId(String id, HttpSession session);
	
	/**
	 * 将processInstanceId的查询到的task完成当前审核，并开启下一节点的审核，将下一节点的审核人设置为assignee
	 * @param id 工咭的id
	 * @param assignee 制定的任务人
	 * @return
	 */
	void auditWarStandardAccessoriesStockOut(String id, String assignee, HttpSession session);
	
	/**
	 * 退回到上一节点
	 * @param id
	 * @param cause 原因
	 * @param session 用于取用户
	 * 抛出异常:如果当前用户和当前审核人不相同
	 * 		  当前是第一节点
	 * 		 流程已经结束
	 */
	void rollBackWarStandardAccessoriesStockOut(String id, String cause, HttpSession session);
	
	/**
	 * 收回评审
	 * @param id
	 * @param cause 原因
	 * @param session 用于取用户信息
	 */
	void takeBackWarStandardAccessoriesStockOut(String id, String cause, HttpSession session);
	
	/**
	 * 重新开始评审
	 * @param id
	 * @param cause 原因
	 * @param session
	 */
	void reAuditWarStandardAccessoriesStockOut(String id, String cause, HttpSession session);
}
