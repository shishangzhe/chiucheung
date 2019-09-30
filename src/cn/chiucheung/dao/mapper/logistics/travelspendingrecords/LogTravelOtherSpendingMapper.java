package cn.chiucheung.dao.mapper.logistics.travelspendingrecords;

import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelOtherSpending;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelOtherSpendingExample;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsSubsidiaryCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LogTravelOtherSpendingMapper {
    int countByExample(LogTravelOtherSpendingExample example);

    int deleteByExample(LogTravelOtherSpendingExample example);

    int deleteByPrimaryKey(String id);

    int insert(LogTravelOtherSpending record);

    int insertSelective(LogTravelOtherSpending record);

    List<LogTravelOtherSpending> selectByExample(LogTravelOtherSpendingExample example);

    LogTravelOtherSpending selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LogTravelOtherSpending record, @Param("example") LogTravelOtherSpendingExample example);

    int updateByExample(@Param("record") LogTravelOtherSpending record, @Param("example") LogTravelOtherSpendingExample example);

    int updateByPrimaryKeySelective(LogTravelOtherSpending record);

    int updateByPrimaryKey(LogTravelOtherSpending record);

	int insertList(List<LogTravelOtherSpending> others);

	List<LogTravelSpendingRecordsSubsidiaryCustom> findAllTravelOtherSpendingByLogTravelSpendingRecordsId(String id);
}