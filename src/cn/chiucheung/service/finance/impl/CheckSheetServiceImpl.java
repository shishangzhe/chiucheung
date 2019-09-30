package cn.chiucheung.service.finance.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.finance.checksheet.FinCheckSheetMapper;
import cn.chiucheung.dao.mapper.logistics.travelspendingrecords.LogTravelOtherSpendingMapper;
import cn.chiucheung.dao.mapper.logistics.travelspendingrecords.LogTravelSpendingRecordsMapper;
import cn.chiucheung.dao.mapper.logistics.travelspendingrecords.LogTravelTrafficSpendingMapper;
import cn.chiucheung.po.finance.checksheet.FinCheckSheet;
import cn.chiucheung.pojo.finance.checksheet.ExportExcelForLiveCustom;
import cn.chiucheung.pojo.finance.checksheet.FinCheckSheetCustom;
import cn.chiucheung.pojo.finance.checksheet.FinCheckSheetQueryVo;
import cn.chiucheung.pojo.finance.checksheet.FinExportExcelForCheckSheetCustom;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsSubsidiaryCustom;
import cn.chiucheung.service.finance.CheckSheetService;

@Service
public class CheckSheetServiceImpl implements CheckSheetService {

	@Autowired
	private FinCheckSheetMapper checkSheetMapper;
	
	@Autowired
	private LogTravelSpendingRecordsMapper travelSpendingRecordsMapper;
	
	@Autowired
	private LogTravelOtherSpendingMapper travelOtherSpendingMapper;
	
	@Autowired
	private LogTravelTrafficSpendingMapper travelTrafficSpendingMapper;
	
	@Override
	public List<FinCheckSheetCustom> findAllCheckSheetList(FinCheckSheetQueryVo checkSheetQueryVo) {
		return checkSheetMapper.findAllCheckSheetList(checkSheetQueryVo);
	}

	@Override
	public String findAllCheckSheetTotal(FinCheckSheetQueryVo checkSheetQueryVo) {
		return checkSheetMapper.findAllCheckSheetTotal(checkSheetQueryVo);
	}

	@Override
	public int deleteCheckSheetById(String id) {
		travelSpendingRecordsMapper.updateByDeleteGenerateCheckSheet(id);
		return checkSheetMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<FinCheckSheetCustom> findAllTravelSpendingRecordsByFinCheckSheetId(String finCheckSheetId) {
		return travelSpendingRecordsMapper.findAllTravelSpendingRecordsByFinCheckSheetId(finCheckSheetId);
	}

	@Override
	public List<LogTravelSpendingRecordsSubsidiaryCustom> findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(String logTravelSpendingRecordsId) {
		List<LogTravelSpendingRecordsSubsidiaryCustom> list1 = travelOtherSpendingMapper.findAllTravelOtherSpendingByLogTravelSpendingRecordsId(logTravelSpendingRecordsId);
		
		List<LogTravelSpendingRecordsSubsidiaryCustom> list2 = travelTrafficSpendingMapper.findAllTravelTrafficSpendingByLogTravelSpendingRecordsId(logTravelSpendingRecordsId);
		
		list1.addAll(list2);
		
		return list1;
	}

	@Override
	public FinExportExcelForCheckSheetCustom exportExcelForCheckSheetById(String id) throws Exception{
		FinExportExcelForCheckSheetCustom exportExcelForCheckSheetCustom = new FinExportExcelForCheckSheetCustom();
		
		FinCheckSheet checkSheet = checkSheetMapper.findFinCheckSheetById(id);
		if (checkSheet != null){
			BeanUtils.copyProperties(exportExcelForCheckSheetCustom, checkSheet);
		}else{
			throw new RuntimeException("数据不存在，请刷新数据！");
		}
		
		exportExcelForCheckSheetCustom.setList(travelSpendingRecordsMapper.findMultipleDataForExportExcelForCheckSheetByfinCheckSheetId(id));
		return exportExcelForCheckSheetCustom;
	}
	


	@Override
	public List<ExportExcelForLiveCustom> exportExcelForLiveById(String id) {
		FinCheckSheet checkSheet = checkSheetMapper.selectByPrimaryKey(id);
		if (checkSheet == null){
			throw new RuntimeException("数据不存在，请刷新数据！");
		}
		return travelSpendingRecordsMapper.exportExcelForLiveById(id);
	}
	

	@Override
	public String exportExcelForSumWorkHour(String id) {
		return travelSpendingRecordsMapper.exportExcelForSumWorkHour(id);
	}

	@Override
	public int updateCheckSheetByIdForSubmitToFinance(String id) {
		FinCheckSheet checkSheet = new FinCheckSheet();
		checkSheet.setId(id);
		checkSheet.setIsLock(true);
		int i = checkSheetMapper.updateByPrimaryKeySelective(checkSheet);
		if (i > 0){
			return i;
		}else{
			throw new RuntimeException("数据不存在，请刷新数据！");
		}
	}

	@Override
	public int updateCheckSheetByIdForTackBackToLogistics(String id) {
		FinCheckSheet checkSheet = new FinCheckSheet();
		checkSheet.setId(id);
		checkSheet.setIsLock(false);
		int i = checkSheetMapper.updateByPrimaryKeySelective(checkSheet);
		if (i > 0){
			return i;
		}else{
			throw new RuntimeException("数据不存在，请刷新数据！");
		}
	}

}
