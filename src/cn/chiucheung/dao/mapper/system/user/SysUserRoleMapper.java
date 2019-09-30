package cn.chiucheung.dao.mapper.system.user;

import cn.chiucheung.po.system.user.SysUserRoleExample;
import cn.chiucheung.po.system.user.SysUserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    int countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRoleKey record);

    int insertSelective(SysUserRoleKey record);

    List<SysUserRoleKey> selectByExample(SysUserRoleExample example);

    int updateByExampleSelective(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleExample example);
    
    List<String> findAllRoleNameByUserId(String id);
    
    List<String> findAllRoleIdByUserId(String id);

	int insertList(List<SysUserRoleKey> list);
}