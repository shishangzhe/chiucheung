package cn.chiucheung.service.logistics;

import java.util.List;

import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.pojo.logistics.travelUser.LogTravelUserQueryVo;

public interface TravelUserService {
	

	/**
	 * 根据条件查找所有的用户
	 * @param travelUserQueryVo 查询的条件
	 * @return
	 */
	List<LogTravelUser> findAllTravelUserList(LogTravelUserQueryVo travelUserQueryVo);
	
	/**
	 * 根据条件查找所有的用户的总数
	 * @param travelUserQueryVo 查询的条件
	 * @return
	 */
	String findAllTravelUserTotal(LogTravelUserQueryVo travelUserQueryVo);
	
	/**
	 * 新增差旅(APP)用户
	 * @param travelUser
	 * @return
	 */
	int saveTravelUser(LogTravelUser travelUser);
	
	/**
	 * 根据id查找TravelUser，用于页面的编辑
	 * @param id
	 * @return
	 */
	LogTravelUser findTravelUserById(String id);
	
	/**
	 * 更新差旅(APP)用户
	 * @param travelUser
	 * @return
	 */
	int updateTravelUser(LogTravelUser travelUser);
	
	/**
	 * 删除差旅(APP)用户
	 * @param id
	 * @return
	 */
	int deleteTravelUserById(String id);

	/**
	 * 根据id解除设备绑定
	 * @param id
	 * @return
	 */
	int deleteDeviceSerialNumberById(String id);
	
	/**
	 * 根据用户密码查找用户，用于APP用户登陆
	 * @param travelUser
	 * @return
	 */
	List<LogTravelUser> findTravelUserByWorkNoAndPassword(LogTravelUser travelUser);
	
	/**
	 * 根据用户名查找差旅用户
	 * @param username
	 * @return
	 */
	List<LogTravelUser> findAllTravelUserByUsername(String username);
	
	/**
	 * 根据工号查找差旅用户
	 * @param workNo
	 * @return
	 */
	List<LogTravelUser> findAllTravelUserByWorkNo(String workNo);
	
	/**
	 * 手机端更改密码
	 * @param travelUser
	 * @return
	 */
	int updateTravelUserByAppChangePassowrd(LogTravelUser travelUser);
}
