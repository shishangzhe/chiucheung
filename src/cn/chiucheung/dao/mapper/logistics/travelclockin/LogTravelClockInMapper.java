package cn.chiucheung.dao.mapper.logistics.travelclockin;

import cn.chiucheung.po.logistics.travelclockin.LogTravelClockIn;
import cn.chiucheung.po.logistics.travelclockin.LogTravelClockInExample;
import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInCustom;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInQueryVo;
import cn.chiucheung.pojo.logistics.travelclockin.LogTravelClockInQueryVoForApp;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LogTravelClockInMapper {
    int countByExample(LogTravelClockInExample example);

    int deleteByExample(LogTravelClockInExample example);

    int insert(LogTravelClockIn record);

    int insertSelective(LogTravelClockIn record);

    List<LogTravelClockIn> selectByExample(LogTravelClockInExample example);

    int updateByExampleSelective(@Param("record") LogTravelClockIn record, @Param("example") LogTravelClockInExample example);

    int updateByExample(@Param("record") LogTravelClockIn record, @Param("example") LogTravelClockInExample example);

	List<LogTravelClockInCustom> findAllTravelClockInListForApp(LogTravelClockInQueryVoForApp travelClockInQueryVoForApp);

	List<LogTravelUser> findAllTravelClockInList(LogTravelClockInQueryVo travelClockInQueryVo);

	String findAllTravelClockInTotal(LogTravelClockInQueryVo travelClockInQueryVo);
}