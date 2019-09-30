package cn.chiucheung.service.warehouse;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockIn;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.ProStorageWarehouseWorkCardSubsidiaryCustom;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInCustom;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInQueryVo;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInSubsidiaryCustom;

public interface StorageWarehouseWorkCardStockInService {
	

	/**
	 * 查找所有的入库单
	 * @param standardAccessoriesStockInQueryVo 查询条件
	 * @return
	 */
	List<WarStorageWarehouseWorkCardStockIn> findAllWarStorageWarehouseWorkCardStockInList(WarStorageWarehouseWorkCardStockInQueryVo storageWarehouseWorkCardStockInQueryVo);
	
	/**
	 * 查找所有入库单的数量
	 * @param standardAccessoriesStockInQueryVo 查询条件
	 * @return
	 */
	String findAllWarStorageWarehouseWorkCardStockInTotal(WarStorageWarehouseWorkCardStockInQueryVo storageWarehouseWorkCardStockInQueryVo);
	
	/**
	 * 页面tree的数据展开
	 * @param warStandardAccessoriesStockInId
	 * @return
	 */
	List<WarStorageWarehouseWorkCardStockInSubsidiaryCustom> findAllWarStorageWarehouseWorkCardStockInSubsidiaryListByWarStorageWarehouseWorkCardStockInId(String warStorageWarehouseWorkCardStockInId);

	
	/**
	 * 查找所有已完成的存仓工咭，并且未全部入库的标准配件的集合
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	List<ProStorageWarehouseWorkCardSubsidiaryCustom> findAllCompleteStorageWarehouseWorkCardSubsidiaryList(WarMaterialQueryVo materialQueryVo);
	
	/**
	 * 查找所有已完成的存仓工咭，并且未全部入库的标准配件的总数
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	String findAllCompleteStorageWarehouseWorkCardSubsidiaryTotal(WarMaterialQueryVo materialQueryVo);
	
	/**
	 * 新增入库单
	 * @param standardAccessoriesStockInCustom
	 * @return
	 */
	int saveWarStorageWarehouseWorkCardStockIn(WarStorageWarehouseWorkCardStockInCustom storageWarehouseWorkCardStockInCustom) throws Exception;
	
	/**
	 * 根据id查找入库单，用于页面查看
	 * @param id
	 * @return
	 */
	Map<String, Object> findWarStorageWarehouseWorkCardStockInByIdForView(String id) throws Exception;
	
	/**
	 * 根据id查找入库单，用于页面编辑
	 * @param id
	 * @return
	 */
	Map<String, Object> findWarStorageWarehouseWorkCardStockInByIdForEdit(String id, HttpSession session) throws Exception;
	
	/**
	 * 更新入库单
	 * @param standardAccessoriesStockInCustom
	 */
	int updateWarStorageWarehouseWorkCardStockIn(WarStorageWarehouseWorkCardStockInCustom storageWarehouseWorkCardStockInCustom, HttpSession session) throws Exception;
	
	/**
	 * 根据id删除入库单
	 * @param id
	 * @return
	 */
	int deleteWarStorageWarehouseWorkCardStockInById(String id);

	/**
	 * 根据processinstanceId查询下一节点接收任务的人
	 * @param id
	 * @return
	 */
	List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session);
	
	/**
	 * 将processInstanceId的查询到的task完成当前审核，并开启下一节点的审核，将下一节点的审核人设置为assignee
	 * @param id 工咭的id
	 * @param assignee 制定的任务人
	 * @return
	 */
	void auditWarStorageWarehouseWorkCardStockIn(String id, String assigneeId, HttpSession session);
	
	/**
	 * 撤销流程
	 * @param id
	 * @param session
	 */
	void revokeProcess(String id, HttpSession session);
	
	/**
	 * 收回评审
	 * @param id
	 * @param cause 原因
	 * @param session 用于取用户信息
	 */
	void takeBackWarStorageWarehouseWorkCardStockIn(String id, String cause, HttpSession session);
	
	/**
	 * 退回到上一节点
	 * @param id
	 * @param cause 原因
	 * @param session 用于取用户
	 * 抛出异常:如果当前用户和当前审核人不相同
	 * 		  当前是第一节点
	 * 		 流程已经结束
	 */
	void rollBackWarStorageWarehouseWorkCardStockIn(String id, String cause, HttpSession session);

	/**
	 * 反审核
	 * @param id
	 * @param cause
	 * @param session
	 */
	void antiAuditWarStorageWarehouseWorkCardStockIn(String id, String cause, HttpSession session);
	

}
