package cn.chiucheung.service.engineering;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.chiucheung.po.engineering.bom.EngBomSubsidiary;
import cn.chiucheung.po.engineering.standardbom.EngStandardBom;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.engineering.standardBom.EngStandardBomCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;

public interface StandardBomService {

	/**
	 * 查找所有的StandardBom
	 * @param standardBomQueryVo 查询条件
	 * @return
	 */
	List<EngStandardBomCustom> findAllStandardBomList(WarMaterialQueryVo materialQueryVo);

	/**
	 * 查找所有的StandardBom的记录数
	 * @param standardBomQueryVo 查询条件
	 * @return
	 */
	String findAllStandardBomTotal(WarMaterialQueryVo materialQueryVo);
	
	/**
	 * 根据EngStandardBom的id查找子节点加载的数据
	 * @param engStandardBomId
	 * @return
	 */
	List<EngStandardBomCustom> findAllStandardBomSubsidiaryListByEngStandardBomId(String engStandardBomId);
	
	/**
	 * 保存标准bom
	 * @param map
	 * @param session
	 * @return
	 */
	int saveEngStandardBom(Map<String, Object> map, HttpSession session);
	
	/**
	 * 根据id查找bom，用于页面修改
	 * @param id
	 * @return
	 */
	Map<String, Object> findEngstandardBomByIdForEdit(String id, HttpSession session);
	
	/**
	 * 根据id查找bom，用于页面查看
	 * @param id
	 * @return
	 */
	Map<String, Object> findEngstandardBomByIdForView(String id);
	
	/**
	 * 更新标准bom
	 * @param map
	 * @return
	 */
	int updateEngStandardBom(Map<String, Object> map, HttpSession session);
	
	/**
	 * 删除标准bom
	 * @param map
	 * @return
	 */
	int deleteEngStandardBomById(String id);
	
	/**
	 * 根据条件查找所有的标准配件
	 * @param accessoriesCode 查询条件
	 * @return
	 */
	List<EngStandardBomCustom> findWarMaterialByMaterialCode(String accessoriesCode);
	
	/**
	 * 根据标准bom的id查询下一节点接收任务的人,如何未开始，则查询第一节点的接收人
	 * @param id
	 * @return
	 */
	List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session);

	/**
	 * 审核标准bom
	 * @param id
	 * @param assigneeId 下一节点的接收人（为空代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	void auditEngStandardBom(String id, String assigneeId, HttpSession session);
	
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
	void takeBackEngStandardBom(String id, String cause, HttpSession session);

	/**
	 * 退回到上一节点
	 * @param id
	 * @param cause
	 * @return
	 */
	void rollBackEngStandardBom(String id, String cause, HttpSession session);

	/**
	 * 反评审
	 * @param id
	 * @param cause
	 * @return
	 */
	void antiAuditEngStandardBom(String id, String cause, HttpSession session);

}
