package cn.chiucheung.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.system.role.SysRoleMapper;
import cn.chiucheung.dao.mapper.system.role.SysRoleMenujztreeMapper;
import cn.chiucheung.dao.mapper.system.user.SysMenujztreeMapper;
import cn.chiucheung.po.system.role.SysRole;
import cn.chiucheung.po.system.role.SysRoleExample;
import cn.chiucheung.po.system.role.SysRoleMenujztreeExample;
import cn.chiucheung.po.system.role.SysRoleMenujztreeKey;
import cn.chiucheung.pojo.system.role.MenujztreeCustom;
import cn.chiucheung.pojo.system.role.SysRoleMenujztreeCustom;
import cn.chiucheung.service.system.RoleService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private SysMenujztreeMapper menujztreeMapper;
	
	@Autowired
	private SysRoleMenujztreeMapper roleMenujztreeMapper;
	
	@Override
	public List<SysRole> findAllRole() {
		return roleMapper.selectByExample(null);
	}

	@Override
	public List<SysRole> findAllSysRoleByRoleName(String roleName) {
		SysRoleExample roleExample = new SysRoleExample();
		roleExample.createCriteria().andRoleNameEqualTo(roleName);
		return roleMapper.selectByExample(roleExample);
	}

	@Override
	public int saveSysRole(SysRole role) {
		role.setId(UUIDBuild.getUUID());
		return roleMapper.insert(role);
	}

	@Override
	public List<MenujztreeCustom> findAllMenujtreeByPid(String pid) {
		return menujztreeMapper.findAllMenujtreeByPid(pid);
	}

	@Override
	public void saveSysRoleMenujztree(String roleId, String[] selectoper) {
		//先删除roleId的所有权限
		SysRoleMenujztreeExample roleMenujztreeExample = new SysRoleMenujztreeExample();
		roleMenujztreeExample.createCriteria().andRoleIdEqualTo(roleId);
		roleMenujztreeMapper.deleteByExample(roleMenujztreeExample);
		
		if (selectoper != null && selectoper.length>0){
			//在新增
			List<SysRoleMenujztreeKey> roleMenujztreeKeys = new ArrayList<SysRoleMenujztreeKey>();
			for (String string : selectoper) {
				SysRoleMenujztreeKey roleMenujztreeKey = new SysRoleMenujztreeKey();
				roleMenujztreeKey.setRoleId(roleId);
				roleMenujztreeKey.setPid(string.split("_")[0]);
				roleMenujztreeKey.setMid(string.split("_")[1]);
				roleMenujztreeKeys.add(roleMenujztreeKey);
			}
			roleMenujztreeMapper.insertList(roleMenujztreeKeys);
		}
	}

	@Override
	public List<SysRoleMenujztreeCustom> findSysRoleMenujztreeCustomByRoleId(String roleId) {
		return roleMenujztreeMapper.findSysRoleMenujztreeCustomByRoleId(roleId);
	}

}
