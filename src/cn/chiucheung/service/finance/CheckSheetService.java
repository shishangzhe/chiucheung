package cn.chiucheung.service.finance;

import java.util.List;

import cn.chiucheung.pojo.finance.checksheet.ExportExcelForLiveCustom;
import cn.chiucheung.pojo.finance.checksheet.FinCheckSheetCustom;
import cn.chiucheung.pojo.finance.checksheet.FinCheckSheetQueryVo;
import cn.chiucheung.pojo.finance.checksheet.FinExportExcelForCheckSheetCustom;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsSubsidiaryCustom;

public interface CheckSheetService {
	
	/**
	 * 查询所有的报账单
	 * @param checkSheetQueryVo 查询条件
	 * @return
	 */
	List<FinCheckSheetCustom> findAllCheckSheetList(FinCheckSheetQueryVo checkSheetQueryVo);
	
	/**
	 * 查询所有报账单的记录总数
	 * @param checkSheetQueryVo 查询条件
	 * @return
	 */
	String findAllCheckSheetTotal(FinCheckSheetQueryVo checkSheetQueryVo);
	
	/**
	 * 根据id删除报账单
	 * @param id
	 * @return
	 */
	int deleteCheckSheetById(String id);
	
	/**
	 * 根据finCheckSheetId查询所有的logTravelSpendingRecords,用于页面数据的一级展开
	 * @param finCheckSheetId
	 * @return
	 */
	List<FinCheckSheetCustom> findAllTravelSpendingRecordsByFinCheckSheetId(String finCheckSheetId);
	
	/**
	 * 根据logTravelSpendingRecordsId查询所有的log_travel_other_spending和log_travel_traffic_spending，用于页面数据的二级展开
	 * @param logTravelSpendingRecordsId
	 * @return
	 */
	List<LogTravelSpendingRecordsSubsidiaryCustom> findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(String logTravelSpendingRecordsId);
	
	/**
	 * 根据报账单的id查询数据，用于导出报账单
	 * @param id
	 * @return
	 */
	FinExportExcelForCheckSheetCustom exportExcelForCheckSheetById(String id) throws Exception;
	
	
	/**
	 * 根据报账单的id查询数据，用于导出住宿单
	 * @param id
	 * @return
	 */
	List<ExportExcelForLiveCustom> exportExcelForLiveById(String id);
	
	/**
	 * 根据报账单的id,统计该报账单的总工时
	 * @param id
	 * @return
	 */
	String exportExcelForSumWorkHour(String id);
	
	/**
	 * 将报账单提交给财务
	 * @param id
	 * @return
	 */
	int updateCheckSheetByIdForSubmitToFinance(String id);
	
	/**
	 * 将报账单退回给物流
	 * @param id
	 * @return
	 */
	int updateCheckSheetByIdForTackBackToLogistics(String id);

}
