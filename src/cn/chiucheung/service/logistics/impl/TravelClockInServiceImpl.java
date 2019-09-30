package cn.chiucheung.service.logistics.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.logistics.travelclockin.LogTravelClockInMapper;
import cn.chiucheung.po.logistics.travelclockin.LogTravelClockIn;
import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInCustom;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInQueryVo;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInQueryVoForApp;
import cn.chiucheung.service.logistics.TravelClockInService;

@Service
public class TravelClockInServiceImpl implements TravelClockInService{
	
	@Autowired
	LogTravelClockInMapper travelClockInMapper;

	@Override
	public int saveTravelClockIn(LogTravelClockIn travelClockIn) {
		return travelClockInMapper.insert(travelClockIn);
	}

	@Override
	public List<LogTravelClockInCustom> findAllTravelClockInListForApp(String logTravelUserid, String lastClockOn, int pageSize) throws Exception{
		LogTravelClockInQueryVoForApp travelClockInQueryVoForApp = new LogTravelClockInQueryVoForApp();
		travelClockInQueryVoForApp.setLogTravelUserid(logTravelUserid);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		travelClockInQueryVoForApp.setLastClockOn(StringUtils.isNotBlank(lastClockOn) ? format.parse(lastClockOn) : null);
		travelClockInQueryVoForApp.setPageSize(pageSize);
		return travelClockInMapper.findAllTravelClockInListForApp(travelClockInQueryVoForApp);
	}

	@Override
	public List<LogTravelUser> findAllTravelClockInList(LogTravelClockInQueryVo travelClockInQueryVo) {
		return travelClockInMapper.findAllTravelClockInList(travelClockInQueryVo);
	}

	@Override
	public String findAllTravelClockInTotal(LogTravelClockInQueryVo travelClockInQueryVo) {
		return travelClockInMapper.findAllTravelClockInTotal(travelClockInQueryVo);
	}

}
