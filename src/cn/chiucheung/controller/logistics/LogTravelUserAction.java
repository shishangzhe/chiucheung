package cn.chiucheung.controller.logistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.pojo.logistics.travelUser.LogTravelUserQueryVo;
import cn.chiucheung.service.logistics.TravelUserService;


@Controller
@RequestMapping("/logistics/travelUser")
public class LogTravelUserAction {
	
	@Autowired
	private TravelUserService travelUserService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="hi",pid="hh")
	public String index(){
		return "logistics/travelUser";
	}
	
	/**
	 * 查询所有的差旅(APP)用户
	 * @param travelUser 查询条件
	 * @return
	 */
	@RequestMapping("findAllTravelUserList")
	@ResponseBody
	@AnnotationLimit(mid="hi",pid="hh")
	public Map<String, Object> findAllTravelUserList(LogTravelUserQueryVo travelUserQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<LogTravelUser> list = travelUserService.findAllTravelUserList(travelUserQueryVo);
		String total = travelUserService.findAllTravelUserTotal(travelUserQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 新增差旅(APP)用户
	 * @param travelUser
	 * @return
	 */
	@RequestMapping("saveTravelUser")
	@ResponseBody
	@AnnotationLimit(mid="hia",pid="hi")
	public JSONObject saveTravelUser(LogTravelUser travelUser){
		JSONObject jsonObject = new JSONObject();
		try{
			travelUserService.saveTravelUser(travelUser);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id查询差旅(APP)用户,用于页面的编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("findTravelUserById")
	@ResponseBody
	@AnnotationLimit(mid="hib",pid="hi")
	public LogTravelUser findTravelUserById(String id){
		return travelUserService.findTravelUserById(id);
	}
	
	/**
	 * 更新差旅(APP)用户
	 * @param travelUser
	 * @return
	 */
	@RequestMapping("updateTravelUser")
	@ResponseBody
	@AnnotationLimit(mid="hib",pid="hi")
	public JSONObject updateTravelUser(LogTravelUser travelUser){
		JSONObject jsonObject = new JSONObject();
		try{
			travelUserService.updateTravelUser(travelUser);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id删除差旅(APP)用户
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteTravelUserById")
	@ResponseBody
	@AnnotationLimit(mid="hic",pid="hi")
	public JSONObject deleteTravelUserById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			travelUserService.deleteTravelUserById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	/**
	 * 根据id解除设备绑定
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteDeviceSerialNumberById")
	@ResponseBody
	@AnnotationLimit(mid="hid",pid="hi")
	public JSONObject deleteDeviceSerialNumberById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			travelUserService.deleteDeviceSerialNumberById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 对用户名进行查找，是否存在，用于前台校验
	 * @param username 用户名
	 * @return
	 */
	@RequestMapping(value="checkUsernameIsRepeat")
	@ResponseBody
	@AnnotationLimit(mid="hia",pid="hi")
	public String checkUsernameIsRepeat(String username){
		List<LogTravelUser> list = travelUserService.findAllTravelUserByUsername(username);
		String message = "";
		if (list != null && list.size()>0){
			message = "no";
		}else{
			message = "ok";
		}
		return message;
	}
	
	/**
	 * 对用户名进行查找，是否存在，用于前台校验
	 * @param username 用户名
	 * @return
	 */
	@RequestMapping(value="checkWorkNoIsRepeat")
	@ResponseBody
	@AnnotationLimit(mid="hia",pid="hi")
	public String checkWorkNoIsRepeat(String workNo){
		List<LogTravelUser> list = travelUserService.findAllTravelUserByWorkNo(workNo);
		String message = "";
		if (list != null && list.size()>0){
			message = "no";
		}else{
			message = "ok";
		}
		return message;
	}
}
