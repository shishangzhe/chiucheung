package cn.chiucheung.dao.mapper.logistics.travelspendingrecords;

import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelTrafficSpending;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelTrafficSpendingExample;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsSubsidiaryCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LogTravelTrafficSpendingMapper {
    int countByExample(LogTravelTrafficSpendingExample example);

    int deleteByExample(LogTravelTrafficSpendingExample example);

    int deleteByPrimaryKey(String id);

    int insert(LogTravelTrafficSpending record);

    int insertSelective(LogTravelTrafficSpending record);

    List<LogTravelTrafficSpending> selectByExample(LogTravelTrafficSpendingExample example);

    LogTravelTrafficSpending selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LogTravelTrafficSpending record, @Param("example") LogTravelTrafficSpendingExample example);

    int updateByExample(@Param("record") LogTravelTrafficSpending record, @Param("example") LogTravelTrafficSpendingExample example);

    int updateByPrimaryKeySelective(LogTravelTrafficSpending record);

    int updateByPrimaryKey(LogTravelTrafficSpending record);

	int insertList(List<LogTravelTrafficSpending> traffics);

	List<LogTravelSpendingRecordsSubsidiaryCustom> findAllTravelTrafficSpendingByLogTravelSpendingRecordsId(String id);
}