package cn.chiucheung.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.system.role.SysRole;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysMenujztree;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.system.user.SysUserCustom;
import cn.chiucheung.pojo.system.user.SysUserQueryVo;
import cn.chiucheung.pojo.system.user.SysUserRoleCustom;
import cn.chiucheung.service.system.RoleService;
import cn.chiucheung.service.system.UserService;
import cn.chiucheung.utils.MD5keyBean;
import cn.chiucheung.utils.UserUtils;

@Controller
@RequestMapping("/system/user")
public class SysUserAction {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	
	private RoleService roleService;
	
	
	/**
	 * 加载ztree菜单所需的json
	 * @return 加载树形菜单所需要的json
	 */
	@RequestMapping("showMenu")
	@ResponseBody
	public List<SysMenujztree> showMenu(HttpSession session){
		SysUser user = UserUtils.getUserFromSession(session);
		if (user.getLoginName().equals("admin")){//如果是admin用户，则不需要进行权限校验，取出所有的菜单
			return userService.findALLSysMenujztreeList();
		}else{
			return userService.findAllSysMenujztreeListByPrivileges((List<Privilege>) session.getAttribute("privileges"));
		}
	}
	
	
	/**
	 * 主页的跳转
	 * @return 跳转的页面
	 */
	@RequestMapping("index")
	public String index(){
		return "index";
		
	}
	
	/**
	 * 用户管理的页面跳转
	 * @return
	 */
	@RequestMapping("userIndex")
	@AnnotationLimit(mid="bc",pid="bb")
	public String userIndex(){
		return "system/user";
		
	}
	
	/**
	 * 用户登录
	 * @param loginName
	 * @param loginPassword
	 * @param model
	 * @return 跳转的页面
	 */
	@RequestMapping("login")
	public String login(String loginName, String loginPassword, Model model, HttpSession session){
		if (StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(loginPassword)){
			List<SysUser> list = userService.findSysUserByLoginNameAndPassword(loginName, loginPassword);
			if (list != null && list.size() > 0){
				SysUser user = list.get(0);
				ServletContext context = session.getServletContext();
				LinkedHashMap<SysUser, HttpSession> map = (LinkedHashMap<SysUser, HttpSession>) context.getAttribute("userMap");//获取用户列表和对应的session的map
				HttpSession session2 = map.get(user);
				if (user.getLoginName().equals("admin")){//如果是admin用户，则不需要进行是否允许登陆，是否分配福角色等的校验
					if(session2 == null){//如果session2等于空，说明该用户没有登陆，则直接登陆
						UserUtils.saveUserToSession(session, user);
					}else if (session2 != null){//如果session2不等于空，说明该用户已经登陆，则踢出该用户，在登陆
						session2.invalidate();//将之前登陆的用户踢出
						UserUtils.saveUserToSession(session, user);
					}
					return "redirect:/";
				}else{
					if ("1".equals(user.getIsAllowedLogin())){//如果允许登陆
						List<String> roleIds = userService.findAllRoleIdByUserId(user.getId());//根据用户id查找角色
						if (roleIds != null && roleIds.size()>0){//如何分配了角色
							List<Privilege> privileges = userService.findAllPrivilegeList(roleIds);
							if(session2 == null){//如果session2等于空，说明该用户没有登陆，则直接登陆
								UserUtils.saveUserToSession(session, user);
							}else if (session2 != null){//如果session2不等于空，说明该用户已经登陆，则踢出该用户，在登陆
								if (session != session2){//当前页面登陆后，点返回，如果不判断，则session会被invalidate
									session2.invalidate();//将之前登陆的用户踢出
									UserUtils.saveUserToSession(session, user);
								}
							}
							session.setAttribute("privileges", privileges);//将privilege（mid，pid）放到session中
							return "redirect:/";
						}else{
							model.addAttribute("errorMessage", "该用户没有分配任何角色，请联系管理员");
							model.addAttribute("loginName", loginName);
							return "system/login";
						}
					}else{
						model.addAttribute("errorMessage", "该用户不允许登陆，请联系管理员");
						model.addAttribute("loginName", loginName);
						return "system/login";
					}
				}
			}else{
				model.addAttribute("errorMessage", "用户或密码错误");
				model.addAttribute("loginName", loginName);
				return "system/login";
			}
		}else{
			return "system/login";
		}
	}
	
	/**
	 * 用户注销
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	/**
	 * 用户更改密码
	 * @param password 原密码
	 * @param newPassword 新密码
	 * @param newPassword2 确认新密码
	 * @param session 
	 * @return 返回提示信息
	 */
	@RequestMapping(value="changePassword",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String changePassword(String password, String newPassword, String newPassword2, HttpSession session){
		MD5keyBean md5keyBean = new MD5keyBean();
		password = md5keyBean.getkeyBeanofStr(password);
		SysUser user = (SysUser) session.getAttribute("user");
		if (newPassword.equals(newPassword2)){
			if (user.getLoginPassword().equals(password)){
				try{
					userService.updateSysUser(user, newPassword);
					return "修改成功";
				}catch (Exception e){
					e.printStackTrace();
					return "<div style='text-align:center;'>"+"修改失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
				}
			}else{
				return "<font color='red'>" + "原密码错误" + "</font>";
			}
		}else{
			return "<font color='red'>" + "两次密码不正确" + "</font>";
		}
	}
	
	/**
	 * 查找所有的用户，用于页面显示所有用户的数据
	 * @return
	 */
	@RequestMapping(value="findAllSysUserCustomList")
	@ResponseBody
	@AnnotationLimit(mid="bc",pid="bb")
	public Map<String, Object> findAllSysUserCustomList(SysUserQueryVo userQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<SysUserCustom> list =  userService.findAllSysUserCustomList(userQueryVo);
			String total = userService.findAllSysUserTotal(userQueryVo);
			
			map.put("rows", list);
			map.put("total", total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 用于页面显示所有的角色
	 * @return
	 */
	@RequestMapping("findAllRole")
	@ResponseBody
	@AnnotationLimit(mid="bcd",pid="bc")
	public List<SysRole> findAllRole(){
		return roleService.findAllRole();
	}
	
	/**
	 * 对登录名进行查找，是否存在，用于前台校验
	 * @param loginName 登录名
	 * @return
	 */
	@RequestMapping(value="checkLoginNameIsRepeat")
	@ResponseBody
	@AnnotationLimit(mid="bca",pid="bc")//有新增权限才可以进行校验
	public String checkLoginNameIsRepeat(String loginName){
		List<SysUser> list = userService.findAllSysUserByLoginName(loginName);
		String message = "";
		if (list != null && list.size()>0){
			message = "no";
		}else{
			message = "ok";
		}
		return message;
	}
	
	/**
	 * 新增用户
	 * @param user 要新增的用户
	 * @return
	 */
	@RequestMapping(value="saveSysUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bca",pid="bc")
	public String saveSysUser(SysUser user){
		try{
			userService.saveSysUser(user);
			return "保存成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 根据id查找 用户，用于修改用户的
	 * @param id
	 * @return
	 */
	@RequestMapping("findSysUserById")
	@ResponseBody
	@AnnotationLimit(mid="bc",pid="bb")
	public SysUser findSysUserById(String id){
		return userService.findSysUserById(id);
	}
	
	/**
	 * 修改用户
	 * @param user 要修改的用户
	 * @return
	 */
	@RequestMapping(value="updateSysUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bcb",pid="bc")
	public String updateSysUser(SysUser user){
		try{
			userService.updateSysUser(user);
			return "保存成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 删除用户
	 * @param user 要删除的用户
	 * @return
	 */
	@RequestMapping(value="deleteSysUserById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bcc",pid="bc")
	public String deleteSysUserById(String id){
		try{
			userService.deleteSysUserById(id);
			return "删除成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"删除失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 根据用户id查找用户的角色，用于页面设置用户角色时，显示该用户当前的角色信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("findSysUserRoleCustomByUserId")
	@ResponseBody
	@AnnotationLimit(mid="bcd",pid="bc")
	public SysUserRoleCustom findSysUserRoleCustomByUserId(String userId){
		return userService.findSysUserRoleCustomByUserId(userId);
	}
	
	/**
	 * 保存用户角色
	 * @param user 保存用户角色
	 * @return
	 */
	@RequestMapping(value="saveSysUserRoleCustom",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bcd",pid="bc")	
	public String saveSysUserRoleCustom(SysUserRoleCustom userRoleCustom){
		try{
			userService.saveSysUserRoleCustom(userRoleCustom);
			return "设置成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"设置失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 用于js的add方法，由于打开窗口，并没有访问服务器，所以用这个空的方法来测试是否登陆超时或者访问服务器是否有问题
	 * @param user 保存用户角色
	 * @return
	 */
	@RequestMapping(value="testLoginTimeout",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String testLoginTimeout(){
		return null;
	}
	
	
	/**
	 * 获取所有的在线用户
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getOnlineUserList")
	@ResponseBody
	public List<SysUser> getOnlineUserList(){
		ServletContext application = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		Map<SysUser, HttpSession> userMap = (Map<SysUser, HttpSession>) application.getAttribute("userMap");
		List<SysUser> list = new ArrayList<SysUser>();
		for (Map.Entry<SysUser, HttpSession> entry : userMap.entrySet()){
			list.add(entry.getKey());
		}
		return list;
	}
	
	
	/**
	 * 根据id提出用户
	 * @param request
	 * @return
	 */
	@RequestMapping(value="kickOutUserById",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bce",pid="bc")
	public String kickOutUserById(String id){
		try{
			SysUser user = userService.findSysUserById(id);
			ServletContext application = ContextLoader.getCurrentWebApplicationContext().getServletContext();
			Map<SysUser, HttpSession> userMap = (Map<SysUser, HttpSession>) application.getAttribute("userMap");
			HttpSession session = userMap.get(user);
			if (session != null){
				session.invalidate();
			}
			userMap.remove(user);
			return "踢出成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"踢出失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
}
