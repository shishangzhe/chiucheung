package cn.chiucheung.dao.mapper.logistics.travelspendingrecords;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.finance.checksheet.FinCheckSheet;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelSpendingRecords;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelSpendingRecordsExample;
import cn.chiucheung.pojo.finance.checksheet.ExportExcelForLiveCustom;
import cn.chiucheung.pojo.finance.checksheet.FinCheckSheetCustom;
import cn.chiucheung.pojo.finance.checksheet.LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustom;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForApp;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForExportExcelForMealsNumber;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForExportExcelForWorkHour;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsQueryVo;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsQueryVoForApp;

public interface LogTravelSpendingRecordsMapper {
    int countByExample(LogTravelSpendingRecordsExample example);

    int deleteByExample(LogTravelSpendingRecordsExample example);

    int deleteByPrimaryKey(String id);

    int insert(LogTravelSpendingRecords record);

    int insertSelective(LogTravelSpendingRecords record);

    List<LogTravelSpendingRecords> selectByExample(LogTravelSpendingRecordsExample example);

    LogTravelSpendingRecords selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LogTravelSpendingRecords record, @Param("example") LogTravelSpendingRecordsExample example);

    int updateByExample(@Param("record") LogTravelSpendingRecords record, @Param("example") LogTravelSpendingRecordsExample example);

    int updateByPrimaryKeySelective(LogTravelSpendingRecords record);

    int updateByPrimaryKey(LogTravelSpendingRecords record);
    
	List<LogTravelSpendingRecordsCustomForApp> findAllTravelSpendingRecordsByLogTravelUserIdForApp(LogTravelSpendingRecordsQueryVoForApp travelSpendingRecordsQueryVoForApp);

	List<LogTravelSpendingRecordsCustom> findAllTravelSpendingRecordsList(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);

	String findAllTravelSpendingRecordsTotal(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);
	
	LogTravelSpendingRecordsCustom findTravelSpendingRecordsByIdForEdit(String id);

	FinCheckSheet findDataForGenerateCheckSheet(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);

	List<LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet> findMultipleDataForExportExcelForCheckSheet(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);

	List<LogTravelSpendingRecordsCustomForExportExcelForWorkHour> findDataForExportExcelForWorkHour(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);

	List<LogTravelSpendingRecordsCustomForExportExcelForMealsNumber> findDataForExportExcelForMealsNumber(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);
	
	String exportExcelForSumWorkHour(String id);

	int updateByGenerateCheckSheet(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);
	
	int updateByDeleteGenerateCheckSheet(String id);

	List<FinCheckSheetCustom> findAllTravelSpendingRecordsByFinCheckSheetId(String finCheckSheetId);

	List<LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet> findMultipleDataForExportExcelForCheckSheetByfinCheckSheetId(String finCheckSheetId);

	String calculateCostByWorkCardNo(String workCardNo);

	List<ExportExcelForLiveCustom> exportExcelForLiveById(String id);

}