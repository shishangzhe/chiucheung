package cn.chiucheung.service.logistics;

import java.util.List;

import cn.chiucheung.po.logistics.travelclockin.LogTravelClockIn;
import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInCustom;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInQueryVo;

public interface TravelClockInService {

	/**
	 * 保存打卡
	 * @param travelClockInCustom
	 * @return
	 */
	int saveTravelClockIn(LogTravelClockIn travelClockIn);
	
	/**
	 * 查询打卡，用于APP
	 * @param logTravelUserid
	 * @param lastCreateTime
	 * @param pageSize
	 * @return
	 */
	List<LogTravelClockInCustom> findAllTravelClockInListForApp(String logTravelUserid,String lastClockOn, int pageSize) throws Exception;
	
	/**
	 * 查询打卡
	 * @param travelClockInQueryVo
	 * @return
	 */
	List<LogTravelUser> findAllTravelClockInList(LogTravelClockInQueryVo travelClockInQueryVo);
	
	/**
	 * 查询打卡的总数
	 * @param travelClockInQueryVo
	 * @return
	 */
	String findAllTravelClockInTotal(LogTravelClockInQueryVo travelClockInQueryVo);
}
