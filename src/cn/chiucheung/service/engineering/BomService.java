package cn.chiucheung.service.engineering;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import cn.chiucheung.po.engineering.bom.EngBom;
import cn.chiucheung.po.engineering.bom.EngBomSubsidiary;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessories;
import cn.chiucheung.pojo.engineering.bom.EngBomQueryVo;
import cn.chiucheung.pojo.engineering.bom.SalWorkCardItemCustomForEngBom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesCustom;

public interface BomService {
	
	/**
	 * 查找所有的bom
	 * @param bomQueryVo 查询条件
	 * @return
	 */
	List<EngBom> findAllBomList(EngBomQueryVo bomQueryVo);
	
	/**
	 * 查找所有的bom的记录数
	 * @param bomQueryVo
	 * @return
	 */
	String findAllBomTotal(EngBomQueryVo bomQueryVo);
	
	/**
	 * 根据bom的id查找子节点加载的数据
	 * @param bomQueryVo
	 * @return
	 */
	List<EngBomSubsidiary> findAllBomSubsidiaryListByEngBomId(String id);
	
	/**
	 * 查询工咭项次，用于页面选择
	 * @return
	 */
	List<SalWorkCardItemCustomForEngBom> findAllWorkCardSubsidiaryList(EngBomQueryVo bomQueryVo);
	
	/**
	 * 查询工咭项次的总数
	 * @param bomQueryVo
	 * @return
	 */
	String findAllWorkCardSubsidiaryTotal(EngBomQueryVo bomQueryVo);
	
	/**
	 * 保存bom
	 * @param map
	 * @return
	 */
	int saveEngBom(Map<String, Object> map);
	
	/**
	 * 根据id查找bom，用于页面修改
	 * @param id
	 * @return
	 */
	Map<String, Object> findEngBomByIdForEdit(String id, HttpSession session);
	
	/**
	 * 根据id查找bom，用于页面修改
	 * @param id
	 * @return
	 */
	Map<String, Object> findEngBomByIdForView(String id);
	
	/**
	 * 根据id查找bom，用于页面复制
	 * @param id
	 * @return
	 */
	Map<String, Object> findEngBomByIdForCopy(String id);
	
	/**
	 * 更新bom
	 * @param map
	 * @return
	 */
	int updateEngBom(Map<String, Object> map, HttpSession session);

	/**
	 * 根据id删除bom
	 * @param id
	 * @return
	 */
	int deleteEngBomById(String id);
	
	/**
	 * 根据工咭号和项次查询最大的次数
	 * @param salWorkCardSubsidiaryId
	 * @return
	 */
	int getMaxNumberOfTimes(String salWorkCardSubsidiaryId);
	
	/**
	 * 查找所有的bom,为了合并
	 * @param bomQueryVo 查询条件，不是模糊查找了，是等于查找，只用workCardNo、workCardItem
	 * @return
	 */
	List<EngBom> findAllBomForMerge(EngBomQueryVo bomQueryVo);
	
	/**
	 * 合并bom
	 * @param bomQueryVo 查询条件，不是模糊查找了，是等于查找，只用workCardNo、workCardItem
	 * @return
	 */
	Map<String, Object> mergeCopyBom(EngBomQueryVo bomQueryVo);
	
	/**
	 * 计算物料总和
	 * @param id
	 * @return
	 */
	List<EngBomSubsidiary> calculationMaterialTotalSumById(String id);
	
	/**
	 * 根据bom的id查询下一节点接收任务的人,如何未开始，则查询第一节点的接收人
	 * @param id
	 * @return
	 */
	List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session);

	/**
	 * 审核bom
	 * @param id
	 * @param assigneeId 下一节点的接收人（为空代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	void auditEngBom(String id, String assigneeId, HttpSession session);
	
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
	void takeBackEngBom(String id, String cause, HttpSession session);

	/**
	 * 退回到上一节点
	 * @param id
	 * @param cause
	 * @return
	 */
	void rollBackEngBom(String id, String cause, HttpSession session);

	/**
	 * 反评审
	 * @param id
	 * @param cause
	 * @return
	 */
	void antiAuditEngBom(String id, String cause, HttpSession session);
	
}
