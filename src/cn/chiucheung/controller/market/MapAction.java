package cn.chiucheung.controller.market;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfoPic;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.market.map.ProjectInfoIndustryCount;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoCustom;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoQueryVo;
import cn.chiucheung.service.market.MapService;
import cn.chiucheung.service.sales.ProjectInfoService;
import cn.chiucheung.service.system.UserService;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UserUtils;

@Controller
@RequestMapping("/market/map")
public class MapAction {
	
	@Autowired
	MapService mapService;
	
	@Autowired
	ProjectInfoService projectInfoService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("index")
	public String index(){
		return "market/map";
	}
	
	@RequestMapping("index1")
	public String index1(){
		return "market/map1";
	}
	
	@RequestMapping("loginIndex")
	public String loginIndex(){
		return "market/mapLogin";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public JSONObject login(String loginName, String loginPassword, HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try{
			if (StringUtils.isNotBlank(loginName) && StringUtils.isNotEmpty(loginPassword)){
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
						jsonObject.accumulate("success", true);
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
								jsonObject.accumulate("success", true);
							}else{
								jsonObject.accumulate("success", false);
								jsonObject.accumulate("message", "该用户没有分配任何角色，请联系管理员");
							}
						}else{
							jsonObject.accumulate("success", false);
							jsonObject.accumulate("errorMessage", "该用户不允许登陆，请联系管理员");
						}
					}
				}else{
					jsonObject.accumulate("success", false);
					jsonObject.accumulate("message", "用户或密码错误");
				}
			}else{
				jsonObject.accumulate("success", false);
				jsonObject.accumulate("message", "用户和密码不能为空");
			}
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	@RequestMapping("getMapData")
	@ResponseBody
	@AnnotationLimit(mid="fk",pid="ff")
	public Map<String, Object> getMapDataForWorld(String parent, BigDecimal[] chiaLli, String linesCoreName){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map = mapService.getMapData(parent, chiaLli, linesCoreName);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	@RequestMapping("getProjectInfo")
	@AnnotationLimit(mid="fk",pid="ff")
	public String getProjectInfo(SalProjectInfoQueryVo projectInfoQueryVo,HttpServletRequest request){
		//首先获取总记录数
		String total = projectInfoService.findAllProjectInfoTotal(projectInfoQueryVo);
		int totalResult = Integer.parseInt(total);
		if (totalResult >50 || StringUtils.isNotBlank(projectInfoQueryVo.getIndustry())){//分行业
			//按行业分类获取记录总数，给页面的数据，应该还要重排
			List<ProjectInfoIndustryCount> industryCounts = mapService.findProjectInfoIndustryCount(projectInfoQueryVo);
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (ProjectInfoIndustryCount industryCount : industryCounts) {
				map.put(industryCount.getIndustry(), industryCount.getCount());
			}
			request.setAttribute("industryCounts", map);
			
			if (StringUtils.isBlank(projectInfoQueryVo.getIndustry())){
				projectInfoQueryVo.setIndustry("广电");//默认先放出广电（任何记录数大于50的地方，都有广电的项目）的，后期判读，如果广电没有，则按顺序，广电、机场空管、安防、交通、能源、部队、金融、其他
			}
			List<SalProjectInfoCustom> list =  projectInfoService.findAllProjectInfoList(projectInfoQueryVo);
			total = projectInfoService.findAllProjectInfoTotal(projectInfoQueryVo);
			
			//当前页
			int pageNo = projectInfoQueryVo.getPage();
			//是否是首页
		    boolean firstPage = pageNo<=1;
		    
		    //每页多少数据
		    int pageSize = projectInfoQueryVo.getRows();
		    //总记录数
		    totalResult = Integer.parseInt(total);
		    
		    //总页数
		    int sumPage = 0;
		    
		    if(totalResult==0) {
		    	sumPage=1;
	        }
	        else {
	        	sumPage = (totalResult / pageSize); //总共几页
	            if ((totalResult % pageSize) != 0) sumPage = sumPage + 1;
	        }
		    
		    //是否是最后页
		    boolean lastPage = pageNo>=sumPage;
		    
		    JSONObject page = new JSONObject();
		    
		    page.accumulate("pageNo", pageNo);
		    page.accumulate("pageSize", pageSize);
		    page.accumulate("totalResult", totalResult);
		    page.accumulate("sumPage", sumPage);
		    page.accumulate("firstPage", firstPage);
		    page.accumulate("lastPage", lastPage);
			
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.setAttribute("projectInfoQueryVo", projectInfoQueryVo);
			request.setAttribute("title", projectInfoQueryVo.getCountry()+projectInfoQueryVo.getProvince()+projectInfoQueryVo.getCity());
		}else{//不分行业
			List<SalProjectInfoCustom> list =  projectInfoService.findAllProjectInfoList(projectInfoQueryVo);
			
			request.setAttribute("list", list);
			request.setAttribute("projectInfoQueryVo", projectInfoQueryVo);
			request.setAttribute("title", projectInfoQueryVo.getCountry()+projectInfoQueryVo.getProvince()+projectInfoQueryVo.getCity());
		}
		
		
		
		
		
		return "market/mapInfo";
	}
	
	
	@RequestMapping("getPicIoById")
	@AnnotationLimit(mid="fk",pid="ff")
	public String getPicIoById(HttpServletRequest request, HttpServletResponse response, String id, boolean thumbnails){
		InputStream inputStream = null;
		SalProjectInfoPic projectInfoPic = projectInfoService.findSalProjectInfoPicById(id);
		if (projectInfoPic != null){
			try {
				String path;
				if (thumbnails){//缩略图
					path = ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo/thumbnails";
					
				}else{
					path = ResourcesUtil.getValue("fileRootPath", "path")+"/salProjectInfo";
				}
				
				
				File fileDir = new File(path);
				File file = new File(fileDir, id + projectInfoPic.getSuffix());
				
				inputStream = new FileInputStream(file);
				
				byte[] b = new byte[1024];
				int i = 0;
				while ((i = inputStream.read(b)) != -1) {
					response.getOutputStream().write(b, 0, i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try{
					if (inputStream != null){
						inputStream.close();
					}
				}catch (IOException e){
					e.printStackTrace();
				}finally{
					inputStream = null;
				}
			}
		}
		return null;
	}
	
	/**
	 * 用于map的iframe里的直接页面跳转，跳转前，经过这里，可以利用登陆过滤器的ajax处理，弹出登陆框，页面并没有进行任何跳转
	 * @return
	 */
	@RequestMapping(value="testLoginTimeout")
	@ResponseBody
	@AnnotationLimit(mid="fk",pid="ff")
	public JSONObject testLoginTimeout(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("success", true);
		return jsonObject;
	}
	
	//局部异常处理，优先级比全局异常处理高
	@ExceptionHandler  
	public String handleException(Exception exception, HttpServletRequest request){
		request.setAttribute("exception", exception);
		return "market/mapInfo";  
	}  

}
