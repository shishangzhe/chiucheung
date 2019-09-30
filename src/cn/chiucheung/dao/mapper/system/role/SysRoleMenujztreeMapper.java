package cn.chiucheung.dao.mapper.system.role;

import cn.chiucheung.po.system.role.SysRoleMenujztreeExample;
import cn.chiucheung.po.system.role.SysRoleMenujztreeKey;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.pojo.system.role.SysRoleMenujztreeCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMenujztreeMapper {
    int countByExample(SysRoleMenujztreeExample example);

    int deleteByExample(SysRoleMenujztreeExample example);

    int deleteByPrimaryKey(SysRoleMenujztreeKey key);

    int insert(SysRoleMenujztreeKey record);

    int insertSelective(SysRoleMenujztreeKey record);

    List<SysRoleMenujztreeKey> selectByExample(SysRoleMenujztreeExample example);

    int updateByExampleSelective(@Param("record") SysRoleMenujztreeKey record, @Param("example") SysRoleMenujztreeExample example);

    int updateByExample(@Param("record") SysRoleMenujztreeKey record, @Param("example") SysRoleMenujztreeExample example);

	int insertList(List<SysRoleMenujztreeKey> roleMenujztreeKeys);

	List<SysRoleMenujztreeCustom> findSysRoleMenujztreeCustomByRoleId(String roleId);
	
	List<Privilege> findAllPrivilegeList(List<String> roleIds);
}