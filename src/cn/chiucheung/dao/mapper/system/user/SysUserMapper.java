package cn.chiucheung.dao.mapper.system.user;

import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.po.system.user.SysUserExample;
import cn.chiucheung.pojo.system.user.SysUserCustom;
import cn.chiucheung.pojo.system.user.SysUserQueryVo;
import cn.chiucheung.pojo.system.user.SysUserRoleCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

	List<SysUserCustom> findAllSysUserCustomList(SysUserQueryVo sysUserQueryVo);
	
	String findAllSysUserTotal(SysUserQueryVo userQueryVo);
	
	List<SysUser> findAllSysUserList(SysUserQueryVo userQueryVo);

	SysUserRoleCustom selectUserRoleCustomByUserId(String id);
}