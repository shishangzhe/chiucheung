package cn.chiucheung.service.system;

import java.util.List;

import cn.chiucheung.po.system.role.SysRole;
import cn.chiucheung.pojo.system.role.MenujztreeCustom;
import cn.chiucheung.pojo.system.role.SysRoleMenujztreeCustom;

public interface RoleService {
	/**
	 * 查询所有的角色
	 * @return
	 */
	List<SysRole> findAllRole();
	
	/**
	 * 根据角色名查找角色
	 * @param roleName
	 * @return
	 */
	List<SysRole> findAllSysRoleByRoleName(String roleName);
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	int saveSysRole(SysRole role);
	
	/**
	 * 根据pid查找SysMenujtree
	 * @param pid 父节点id
	 * @return
	 */
	List<MenujztreeCustom> findAllMenujtreeByPid(String pid);
	
	/**
	 * 新增角色权限，先删除该角色下的所有权限，在重新添加权限
	 * @param roleId 角色id
	 * @param selectoper 所有的权限
	 */
	void saveSysRoleMenujztree(String roleId, String[] selectoper);
	
	/**
	 * 根据角色id查找权限
	 * @param roleId
	 * @return
	 */
	List<SysRoleMenujztreeCustom> findSysRoleMenujztreeCustomByRoleId(String roleId);


}
