package cn.chiucheung.dao.mapper.system.message;

import cn.chiucheung.po.system.message.SysMessage;
import cn.chiucheung.po.system.message.SysMessageExample;
import cn.chiucheung.pojo.system.message.AuditCustom;
import cn.chiucheung.pojo.system.message.AuditQueryVo;
import cn.chiucheung.pojo.system.message.MessageQueryVo;
import cn.chiucheung.pojo.system.message.SysMessageVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysMessageMapper {
    int countByExample(SysMessageExample example);

    int deleteByExample(SysMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysMessage record);

    int insertSelective(SysMessage record);

    List<SysMessage> selectByExample(SysMessageExample example);

    SysMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

    int updateByExample(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

    int updateByPrimaryKeySelective(SysMessage record);

    int updateByPrimaryKey(SysMessage record);
    
	/**
	 * 批量插入
	 * @param messages
	 * @return
	 */
	int insertList(List<SysMessage> messages);

	List<SysMessage> findMessageByNotInIdWithLoginName(SysMessageVo messageVo);

	List<SysMessage> showAllMessage(MessageQueryVo messageQueryVo);

	int findAllMessageTotal(MessageQueryVo messageQueryVo);
	
	/**
	 * <!-- 根据登录名查找当前登录用户的审核的所有数据,根据参数的state来区分查询0：待审核、1：已审核:2：已发送审核 -->
	 * @param auditQueryVo
	 * @return
	 */
	List<AuditCustom> findAllAuditByAuditQueryVo(AuditQueryVo auditQueryVo);
	
	/**
	 * <!-- 根据登录名查找当前登录用户的审核的记录条数,根据参数的state来区分查询0：待审核、1：已审核:2：已发送审核 -->
	 * @param auditQueryVo
	 * @return
	 */
	String findAllAuditTotalByAuditQueryVo(AuditQueryVo auditQueryVo);

}