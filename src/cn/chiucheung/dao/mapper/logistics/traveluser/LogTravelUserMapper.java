package cn.chiucheung.dao.mapper.logistics.traveluser;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.logistics.traveluser.LogTravelUser;
import cn.chiucheung.po.logistics.traveluser.LogTravelUserExample;
import cn.chiucheung.pojo.logistics.travelUser.LogTravelUserQueryVo;

public interface LogTravelUserMapper {
    int countByExample(LogTravelUserExample example);

    int deleteByExample(LogTravelUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(LogTravelUser record);

    int insertSelective(LogTravelUser record);

    List<LogTravelUser> selectByExample(LogTravelUserExample example);

    LogTravelUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LogTravelUser record, @Param("example") LogTravelUserExample example);

    int updateByExample(@Param("record") LogTravelUser record, @Param("example") LogTravelUserExample example);

    int updateByPrimaryKeySelective(LogTravelUser record);

    int updateByPrimaryKey(LogTravelUser record);
    
    List<LogTravelUser> findTravelUserByWorkNoAndPassword(LogTravelUser travelUser);

	List<LogTravelUser> findAllTravelUserList(LogTravelUserQueryVo travelUserQueryVo);
	
	String findAllTravelUserTotal(LogTravelUserQueryVo travelUserQueryVo);
}