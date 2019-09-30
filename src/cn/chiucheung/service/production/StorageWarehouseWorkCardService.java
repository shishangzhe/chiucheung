package cn.chiucheung.service.production;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardCustom;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardQueryVo;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardShowDataCustom;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiaryShowDataCustom;

public interface StorageWarehouseWorkCardService {
	
	
	/**
	 * 新增存仓工咭
	 * @param storageWarehouseWorkCardCustom
	 * @return
	 */
	int saveProStorageWarehouseWorkCard(ProStorageWarehouseWorkCardCustom storageWarehouseWorkCardCustom, HttpSession session) throws Exception;
	
	/**
	 * 根据查询条件查找所有的存仓工咭
	 * @param storageWarehouseWorkCardQueryVo
	 * @return
	 */
	List<ProStorageWarehouseWorkCardShowDataCustom> findAllProStorageWarehouseWorkCardList(ProStorageWarehouseWorkCardQueryVo storageWarehouseWorkCardQueryVo);
	
	/**
	 * 根据查询条件查询出所有的存仓工咭数量
	 * @param storageWarehouseWorkCardQueryVo
	 * @return
	 */
	String findAllProStorageWarehouseWorkCardTotal(ProStorageWarehouseWorkCardQueryVo storageWarehouseWorkCardQueryVo);
	
	/**
	 * 根据存仓工咭的id查找存仓工咭做的标准配件，用于jtreegrid的下拉展示
	 * @param proStorageWarehouseWorkCardQueryId
	 * @return
	 */
	List<ProStorageWarehouseWorkCardSubsidiaryShowDataCustom> findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId(String proStorageWarehouseWorkCardQueryId);
	
	/**
	 * 根据id查找仓存工咭，用于页面的数据查看
	 * @param id
	 * @return
	 */
	Map<String, Object> findProStorageWarehouseWorkCardByIdForView(String id) throws Exception;
	
	/**
	 * 根据id查找仓存工咭，用于页面的数据编辑
	 * @param id
	 * @return
	 */
	Map<String, Object> findProStorageWarehouseWorkCardByIdForEdit(String id, HttpSession session) throws Exception;
	
	/**
	 * 更新存仓工咭
	 * @param storageWarehouseWorkCardCustom
	 * @return
	 */
	int updateProStorageWarehouseWorkCard(ProStorageWarehouseWorkCardCustom storageWarehouseWorkCardCustom, HttpSession session) throws Exception;
	
	/**
	 * 根据id删除存仓工咭
	 * @param id
	 * @return
	 */
	int deleteProStorageWarehouseWorkCardById(String id);

	/**
	 * 根据processinstanceId查询下一节点接收任务的人
	 * @param id
	 * @return
	 */
	List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session);
	
	/**
	 * 将processInstanceId的查询到的task完成当前审核，并开启下一节点的审核，将下一节点的审核人设置为assignee
	 * @param id
	 * @param assigneeId 制定的任务人
	 * @return
	 */
	void auditProStorageWarehouseWorkCard(String id, String assigneeId, HttpSession session);
	
	/**
	 * 撤销流程
	 * @param id
	 * @param session
	 * @return
	 */
	void revokeProcess(String id, HttpSession session);
	
	/**
	 * 退回到上一节点
	 * @param id
	 * @param cause 原因
	 * @param session 用于取用户
	 * 抛出异常:如果当前用户和当前审核人不相同
	 * 		  当前是第一节点
	 * 		 流程已经结束
	 */
	void rollBackProStorageWarehouseWorkCard(String id, String cause, HttpSession session);
	
	/**
	 * 收回评审
	 * @param id
	 * @param cause 原因
	 * @param session 用于取用户信息
	 */
	void takeBackProStorageWarehouseWorkCard(String id, String cause, HttpSession session);
	
	/**
	 * 反审
	 * @param id
	 * @param cause 原因
	 * @param session
	 */
	void antiAuditProStorageWarehouseWorkCard(String id, String cause,HttpSession session);

}
