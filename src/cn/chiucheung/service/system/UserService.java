package cn.chiucheung.service.system;

import java.util.List;

import cn.chiucheung.po.system.role.SysRole;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysMenujztree;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.system.user.SysUserCustom;
import cn.chiucheung.pojo.system.user.SysUserQueryVo;
import cn.chiucheung.pojo.system.user.SysUserRoleCustom;

public interface UserService {
	/**
	 * 根据mid查找菜单
	 * @param list  mid的list
	 * @return
	 */
	public List<SysMenujztree> findAllSysMenujztreeListByPrivileges(List<Privilege> list);
	
	/**
	 * 该方法是admin用户才会使用到的
	 * @return
	 */
	public List<SysMenujztree> findALLSysMenujztreeList();

	/**
	 * 根据用户名和密码查找用户
	 * @param loginName 登录名
	 * @param loginPassword 密码
	 * @return 查找到的用户，如果没有找到则返回null
	 */
	public List<SysUser> findSysUserByLoginNameAndPassword(String loginName,String loginPassword);
	
	/**
	 * 更改密码
	 * @param user 当前登陆的用户
	 * @param newPassword 更改后的密码
	 * @return 返回更新的条数
	 */
	public int updateSysUser(SysUser user, String newPassword);
	
	/**
	 * 查找所有的用户信息
	 * @param sysUserQueryVo 查找用户的条件
	 * @return
	 */
	public List<SysUserCustom> findAllSysUserCustomList(SysUserQueryVo userQueryVo) throws Exception;
	
	/**
	 * 查找所有的用户信息的总数
	 * @param userQueryVo
	 * @return
	 */
	public String findAllSysUserTotal(SysUserQueryVo userQueryVo);
	
	/**
	 * 根据登录名查找用户
	 * @param loginName //登录名
	 * @return
	 */
	public List<SysUser> findAllSysUserByLoginName(String loginName);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public int saveSysUser(SysUser user);
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return 
	 */
	public SysUser findSysUserById(String id);
	
	/**
	 * 修改用户
	 * @param user
	 */
	public int updateSysUser(SysUser user);
	
	/**
	 * 根据id删除用户,需要先删除用户和角色的关联表，其他关联表就无法删除判断了，一般不 允许删除，除非是刚刚创建的用户
	 * @param id
	 * @return
	 */
	public int deleteSysUserById(String id);
	
	/**
	 * 根据用户查找用户角色，多个角色用，分隔
	 * @param userId
	 * @return
	 */
	public SysUserRoleCustom findSysUserRoleCustomByUserId(String userId);
	
	/**
	 * 保存用户角色，先将该用户的所有角色删除，在添加角色
	 * @param sysUserRoleCustom
	 * @return
	 */
	public int saveSysUserRoleCustom(SysUserRoleCustom userRoleCustom);
	
	/**
	 * 根据用户id查找角色id的集合
	 * @param id
	 * @return
	 */
	public List<String> findAllRoleIdByUserId(String id);
	
	/**
	 * 根据角色id查找privilege（mid,pid）权限
	 * @param roleIds
	 * @return
	 */
	public List<Privilege> findAllPrivilegeList(List<String> roleIds);
	
	/**
	 * 根据用户名查找用户
	 * @param username //用户名
	 * @return
	 */
	public List<SysUser> findAllSysUserByUsername(String username);

}
