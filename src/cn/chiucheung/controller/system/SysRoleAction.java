package cn.chiucheung.controller.system;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.system.role.SysRole;
import cn.chiucheung.pojo.system.role.MenujztreeCustom;
import cn.chiucheung.pojo.system.role.SysRoleMenujztreeCustom;
import cn.chiucheung.service.system.RoleService;

@Controller
@RequestMapping("/system/role")
public class SysRoleAction {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="be",pid="bb")
	public String roleIndex(Model model){
		//查询菜单的根节点
		List<MenujztreeCustom> rootMenus = roleService.findAllMenujtreeByPid("0");
		List<MenujztreeCustom> childrenMenus = new ArrayList<MenujztreeCustom>();
		List<MenujztreeCustom> bottonMenus = new ArrayList<MenujztreeCustom>();
		if (rootMenus != null && rootMenus.size()>0){
			for (MenujztreeCustom menujztreeCustom : rootMenus) {
				//查询父节点下的子节点
				childrenMenus = roleService.findAllMenujtreeByPid(menujztreeCustom.getMid());
				bottonMenus.addAll(childrenMenus);
				menujztreeCustom.setMenujztreeCustoms(childrenMenus);
			}
		}
		//查询功能权限
		for (MenujztreeCustom menujztreeCustom : bottonMenus) {
			List<MenujztreeCustom> childrenMenusButton = roleService.findAllMenujtreeByPid(menujztreeCustom.getMid());
			menujztreeCustom.setMenujztreeCustoms(childrenMenusButton);
		}
		model.addAttribute("rootMenus", rootMenus);
		model.addAttribute("bottonMenus", bottonMenus);
		return "system/role";
		
	}
	
	/**
	 * 用于页面显示所有的角色
	 * @return
	 */
	@RequestMapping("findAllRole")
	@ResponseBody
	@AnnotationLimit(mid="be",pid="bb")
	public List<SysRole> findAllRole(){
		return roleService.findAllRole();
	}
	
	/**
	 * 对角色名进行查找，是否存在，用于前台校验
	 * @param loginName 登录名
	 * @return
	 */
	@RequestMapping(value="checkRoleIsRepeat")
	@ResponseBody
	@AnnotationLimit(mid="be",pid="bb")
	public String checkRoleIsRepeat(String roleName){
		List<SysRole> list = roleService.findAllSysRoleByRoleName(roleName);
		String message = "";
		if (list != null && list.size()>0){
			message = "no";
		}else{
			message = "ok";
		}
		return message;
	}
	
	/**
	 * 新增角色
	 * @param user 
	 * @return
	 */
	@RequestMapping(value="saveSysRole",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bea",pid="be")
	public String saveSysRole(SysRole role){
		try{
			roleService.saveSysRole(role);
			return "保存成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 新增角色权限，先删除该角色下的所有权限，在重新添加权限
	 * @param roleId 角色id
	 * @param selectoper 所有的权限 
	 * @return
	 */
	@RequestMapping(value="saveSysRoleMenujztree",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="beb",pid="be")
	public String saveSysRoleMenujztree(String roleId, String[] selectoper){
		try{
			roleService.saveSysRoleMenujztree(roleId,selectoper);
			return "保存成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 根据角色id查找所有的权限，用于页面勾选含有的权限，从数据库中取值就将pid和mid组拼成pid_mid
	 * @return
	 */
	@RequestMapping(value="findSysRoleMenujztreeCustomByRoleId")
	@ResponseBody
	@AnnotationLimit(mid="be",pid="bb")
	public List<SysRoleMenujztreeCustom> findSysRoleMenujztreeCustomByRoleId(String roleId){
		List<SysRoleMenujztreeCustom> list = roleService.findSysRoleMenujztreeCustomByRoleId(roleId);
		return list;
	}
}
