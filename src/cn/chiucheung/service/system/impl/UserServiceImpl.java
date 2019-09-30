package cn.chiucheung.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.system.role.SysRoleMapper;
import cn.chiucheung.dao.mapper.system.role.SysRoleMenujztreeMapper;
import cn.chiucheung.dao.mapper.system.user.SysMenujztreeMapper;
import cn.chiucheung.dao.mapper.system.user.SysUserMapper;
import cn.chiucheung.dao.mapper.system.user.SysUserRoleMapper;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysMenujztree;
import cn.chiucheung.po.system.user.SysMenujztreeExample;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.po.system.user.SysUserExample;
import cn.chiucheung.po.system.user.SysUserExample.Criteria;
import cn.chiucheung.po.system.user.SysUserRoleExample;
import cn.chiucheung.po.system.user.SysUserRoleKey;
import cn.chiucheung.pojo.system.user.SysUserCustom;
import cn.chiucheung.pojo.system.user.SysUserQueryVo;
import cn.chiucheung.pojo.system.user.SysUserRoleCustom;
import cn.chiucheung.service.system.UserService;
import cn.chiucheung.utils.MD5keyBean;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SysMenujztreeMapper menujztreeMapper;
	
	@Autowired 
	private SysUserMapper userMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private SysRoleMenujztreeMapper roleMenujztreeMapper;
	
	@Override
	public List<SysMenujztree> findAllSysMenujztreeListByPrivileges(List<Privilege> list) {
		SysMenujztreeExample menujztreeExample = new SysMenujztreeExample();
		List<String> mids = new ArrayList<String>();
		List<String> pids = new ArrayList<String>();
		for (Privilege privilege : list) {
			mids.add(privilege.getMid());
			pids.add(privilege.getPid());
		}
		//menujztreeExample.setOrderByClause("name asc");
		menujztreeExample.createCriteria().andIsmenuEqualTo(true).andMidIn(mids).andPidIn(pids);
		return menujztreeMapper.selectByExample(menujztreeExample);
	}

	@Override
	public List<SysMenujztree> findALLSysMenujztreeList() {
		SysMenujztreeExample menujztreeExample = new SysMenujztreeExample();
		//menujztreeExample.setOrderByClause("name asc");
		menujztreeExample.createCriteria().andIsmenuEqualTo(true);
		return menujztreeMapper.selectByExample(menujztreeExample);
	}

	@Override
	public List<SysUser> findSysUserByLoginNameAndPassword(String loginName, String loginPassword) {
		MD5keyBean md5keyBean = new MD5keyBean();
		String md5 = md5keyBean.getkeyBeanofStr(loginPassword);
		SysUserExample userExample = new SysUserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andLoginNameEqualTo(loginName);
		criteria.andLoginPasswordEqualTo(md5);
		List<SysUser> list = userMapper.selectByExample(userExample);
		return list;
	}

	@Override
	public int updateSysUser(SysUser user, String newPassword) {
		SysUser user2 = new SysUser();
		MD5keyBean md5keyBean = new MD5keyBean();
		String md5 = md5keyBean.getkeyBeanofStr(newPassword);
		user2.setId(user.getId());
		user2.setLoginPassword(md5);
		return userMapper.updateByPrimaryKeySelective(user2);
		
	}

	@Override
	public List<SysUserCustom> findAllSysUserCustomList(SysUserQueryVo userQueryVo) throws Exception {
		return userMapper.findAllSysUserCustomList(userQueryVo);//查询所有的用户
	}

	@Override
	public String findAllSysUserTotal(SysUserQueryVo userQueryVo) {
		return userMapper.findAllSysUserTotal(userQueryVo);//查询所有的用户;
	}

	@Override
	public List<SysUser> findAllSysUserByLoginName(String loginName) {
		SysUserExample userExample = new SysUserExample();
		userExample.createCriteria().andLoginNameEqualTo(loginName);
		return userMapper.selectByExample(userExample);
	}

	@Override
	public int saveSysUser(SysUser user) {
		MD5keyBean md5keyBean = new MD5keyBean();
		String md5 = md5keyBean.getkeyBeanofStr(user.getLoginPassword());
		user.setLoginPassword(md5);
		user.setId(UUIDBuild.getUUID());
		return userMapper.insert(user);
	}

	@Override
	public SysUser findSysUserById(String id) {
		SysUser user = userMapper.selectByPrimaryKey(id);
		user.setLoginPassword("");
		return user;
	}

	@Override
	public int updateSysUser(SysUser user) {
		if (StringUtils.isBlank(user.getLoginPassword())){
			user.setLoginPassword(null);
		}else{
			MD5keyBean md5keyBean = new MD5keyBean();
			String md5 = md5keyBean.getkeyBeanofStr(user.getLoginPassword());
			user.setLoginPassword(md5);
		}
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int deleteSysUserById(String id) {
		SysUserRoleExample userRoleExample = new SysUserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(id);
		userRoleMapper.deleteByExample(userRoleExample);
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysUserRoleCustom findSysUserRoleCustomByUserId(String userId) {
		SysUserRoleCustom userRoleCustom = userMapper.selectUserRoleCustomByUserId(userId);
		return userRoleCustom;
	}

	@Override
	public int saveSysUserRoleCustom(SysUserRoleCustom userRoleCustom) {
		int i = 0;
		SysUserRoleExample userRoleExample = new SysUserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userRoleCustom.getUserID());
		i = i + userRoleMapper.deleteByExample(userRoleExample);
		if (userRoleCustom.getRoleId() != null){
		String[] roleIds = userRoleCustom.getRoleId().split(",");
			List<SysUserRoleKey> list = new ArrayList<SysUserRoleKey>();
			for (String roleId : roleIds) {
				if (StringUtils.isNotBlank(roleId)){
					SysUserRoleKey userRoleKey = new SysUserRoleKey();
					userRoleKey.setUserId(userRoleCustom.getUserID());
					userRoleKey.setRoleId(roleId);
					list.add(userRoleKey);
				}
			}
			i = i + userRoleMapper.insertList(list);
		}
		return i;
	}

	@Override
	public List<String> findAllRoleIdByUserId(String id) {
		return userRoleMapper.findAllRoleIdByUserId(id);
	}

	@Override
	public List<Privilege> findAllPrivilegeList(List<String> roleIds) {
		return roleMenujztreeMapper.findAllPrivilegeList(roleIds);
	}
	
	@Override
	public List<SysUser> findAllSysUserByUsername(String username) {
		SysUserExample userExample = new SysUserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		return userMapper.selectByExample(userExample);
	}
	
}
