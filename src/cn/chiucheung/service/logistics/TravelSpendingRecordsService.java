package cn.chiucheung.service.logistics;

import java.util.List;

import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustom;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForApp;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForExportExcelForMealsNumber;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForExportExcelForWorkHour;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsQueryVo;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsSubsidiaryCustom;

public interface TravelSpendingRecordsService {
	
	/**
	 * 新增差旅支出记录表
	 * @param travelSpendingRecordsCustom
	 * @return
	 */
	int saveTravelSpendingRecords(LogTravelSpendingRecordsCustom travelSpendingRecordsCustom) throws Exception;
	
	/**
	 * 根据username查询所有的差旅记录表
	 * @param string 
	 * @return
	 */
	List<LogTravelSpendingRecordsCustomForApp> findAllTravelSpendingRecordsByLogTravelUserIdForApp(String id, String lastCreateTime, int pageSize) throws Exception;
	
	/**
	 * 根据id查询差旅记录表
	 * @param id
	 * @return
	 */
	LogTravelSpendingRecordsCustom findTravelSpendingRecordsByIdForEdit(String id) throws Exception;
	
	/**
	 * 更新差旅支出记录表
	 * @param travelSpendingRecordsCustom
	 * @return
	 */
	int updateTravelSpendingRecords(LogTravelSpendingRecordsCustom travelSpendingRecordsCustom) throws Exception;
	
	/**
	 * 根据id删除差旅支出表
	 * @param id
	 * @return
	 */
	int deleteTravelSpendingRecordsById(String id);
	
	/**
	 * 根据id查询差旅记录表
	 * @param id
	 * @return
	 */
	LogTravelSpendingRecordsCustom findTravelSpendingRecordsByIdForCopyData(String id) throws Exception;

	
	
	
	
	
	
	
	/**
	 * pc端查找所有的差旅支出表
	 * @param travelSpendingRecordsQueryVo
	 * @return
	 */
	List<LogTravelSpendingRecordsCustom> findAllTravelSpendingRecordsList(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);
	
	/**
	 * pc端查找所有的差旅支出表的总数
	 * @param travelSpendingRecordsQueryVo
	 * @return
	 */
	String findAllTravelSpendingRecordsTotal(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);
	
	/**
	 * 用于页面的treegrid的数据展开
	 * @param id
	 * @return
	 */
	List<LogTravelSpendingRecordsSubsidiaryCustom> findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(String id);
	
	/**
	 * 查找数据用于导出Excel（工时）
	 * @return
	 */
	List<LogTravelSpendingRecordsCustomForExportExcelForWorkHour> findDataForExportExcelForWorkHour(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);
	
	/**
	 * 查找数据用于导出Excel（餐次）
	 * @param travelSpendingRecordsQueryVo
	 * @return
	 */
	List<LogTravelSpendingRecordsCustomForExportExcelForMealsNumber> findDataForExportExcelForMealsNumber(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo);
	
	/**
	 * 生成报账单
	 * @param travelSpendingRecordsQueryVo
	 * @param applicant
	 * @return 返回
	 */
	String generateCheckSheet(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo,String applicant);
	
	/**
	 * 根据workCardNo计算差旅和厂购火车票的费用总和
	 * @param workCardNo
	 * @return
	 */
	String calculateCostByWorkCardNo(String workCardNo);
}
