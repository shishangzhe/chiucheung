package cn.chiucheung.service.logistics.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.finance.checksheet.FinCheckSheetMapper;
import cn.chiucheung.dao.mapper.logistics.travelspendingrecords.LogTravelOtherSpendingMapper;
import cn.chiucheung.dao.mapper.logistics.travelspendingrecords.LogTravelSpendingRecordsMapper;
import cn.chiucheung.dao.mapper.logistics.travelspendingrecords.LogTravelTrafficSpendingMapper;
import cn.chiucheung.po.finance.checksheet.FinCheckSheet;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelOtherSpending;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelOtherSpendingExample;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelSpendingRecords;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelSpendingRecordsExample;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelTrafficSpending;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelTrafficSpendingExample;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustom;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForApp;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForExportExcelForMealsNumber;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustomForExportExcelForWorkHour;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsQueryVo;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsQueryVoForApp;
import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsSubsidiaryCustom;
import cn.chiucheung.service.logistics.TravelSpendingRecordsService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class TravelSpendingRecordsServiceImpl implements TravelSpendingRecordsService{
	
	@Autowired
	private LogTravelSpendingRecordsMapper travelSpendingRecordsMapper;
	
	@Autowired
	private LogTravelTrafficSpendingMapper travelTrafficSpendingMapper;
	
	@Autowired
	private LogTravelOtherSpendingMapper travelOtherSpendingMapper;
	
	@Autowired
	private FinCheckSheetMapper checkSheetMapper;
	
	@Override
	public int saveTravelSpendingRecords(LogTravelSpendingRecordsCustom travelSpendingRecordsCustom) throws Exception{
		
		String id = UUIDBuild.getUUID();
		LogTravelSpendingRecords travelSpendingRecords = new LogTravelSpendingRecords();
		travelSpendingRecordsCustom.setId(id);
		TravelSpendingRecordsCustomToLogTravelSpendingRecords(travelSpendingRecordsCustom, travelSpendingRecords);
		travelSpendingRecords.setCreateTime(new Date());
		travelSpendingRecords.setState("closed");
		
		//开始数据的校验
		LogTravelSpendingRecordsExample travelSpendingRecordsExample = new LogTravelSpendingRecordsExample();
		travelSpendingRecordsExample.createCriteria().andLogTravelUserIdEqualTo(travelSpendingRecords.getLogTravelUserId())
													.andTravelDateEqualTo(travelSpendingRecords.getTravelDate())
													.andWorkCardNoEqualTo(travelSpendingRecords.getWorkCardNo());
		List<LogTravelSpendingRecords> travelSpendingRecordses = travelSpendingRecordsMapper.selectByExample(travelSpendingRecordsExample);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (travelSpendingRecordses != null && travelSpendingRecordses.size() > 0){
			throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的"+travelSpendingRecords.getWorkCardNo()+"已经存在！");
		}
		
		LogTravelSpendingRecordsExample travelSpendingRecordsExample2 = new LogTravelSpendingRecordsExample();
		travelSpendingRecordsExample2.createCriteria().andLogTravelUserIdEqualTo(travelSpendingRecords.getLogTravelUserId())
													.andTravelDateEqualTo(travelSpendingRecords.getTravelDate());
		List<LogTravelSpendingRecords> travelSpendingRecordses2 = travelSpendingRecordsMapper.selectByExample(travelSpendingRecordsExample2);
		boolean livePriceB = false;
		boolean lunchB = false;
		boolean dinnerB = false;
		boolean midnightSnackB = false;
		if (travelSpendingRecordses2 != null && travelSpendingRecordses2.size() > 0){
			for (LogTravelSpendingRecords travelSpendingRecords2 : travelSpendingRecordses2) {
				if (travelSpendingRecords2.getLivePrice() != null){
					livePriceB = true;
				}
				if (travelSpendingRecords2.getLunch() != null){
					lunchB = true;
				}
				if (travelSpendingRecords2.getDinner() != null){
					dinnerB = true;
				}
				if (travelSpendingRecords2.getMidnightSnack() != null){
					midnightSnackB = true;
				}
			}
		}
		if (livePriceB && travelSpendingRecords.getLivePrice() != null){
			throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的住宿费已经存在！");
		}
		if (lunchB && travelSpendingRecords.getLunch() != null){
			throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的午餐费已经存在！");
		}
		if (dinnerB && travelSpendingRecords.getDinner() != null){
			throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的晚餐费已经存在！");
		}
		if (midnightSnackB && travelSpendingRecords.getMidnightSnack() != null){
			throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的夜宵费已经存在！");
		}
		//结束数据的校验
		
		int i = 0;
		i = i + travelSpendingRecordsMapper.insert(travelSpendingRecords);
		
		List<LogTravelTrafficSpending> traffics = travelSpendingRecordsCustom.getTraffics();
		if (traffics != null && traffics.size() > 0){
			for (LogTravelTrafficSpending travelTrafficSpending : traffics) {
				travelTrafficSpending.setId(UUIDBuild.getUUID());
				travelTrafficSpending.setLogTravelSpendingRecordsId(id);
			}
			i = i + travelTrafficSpendingMapper.insertList(traffics);
		}
		
		List<LogTravelOtherSpending> others = travelSpendingRecordsCustom.getOthers();
		List<LogTravelOtherSpending> subsidies = travelSpendingRecordsCustom.getSubsidies();
		if (others != null && others.size() > 0){
			if (subsidies != null && subsidies.size() > 0){
				others.addAll(subsidies);
			}
			for (LogTravelOtherSpending travelOtherSpending : others) {
				travelOtherSpending.setId(UUIDBuild.getUUID());
				travelOtherSpending.setLogTravelSpendingRecordsId(id);
			}
			i = i + travelOtherSpendingMapper.insertList(others);
		}else{
			if (subsidies != null && subsidies.size() > 0){
				for (LogTravelOtherSpending travelOtherSpending : subsidies) {
					travelOtherSpending.setId(UUIDBuild.getUUID());
					travelOtherSpending.setLogTravelSpendingRecordsId(id);
				}
				i = i + travelOtherSpendingMapper.insertList(subsidies);
			}
		}
		return i;
	}

	@Override
	public List<LogTravelSpendingRecordsCustomForApp> findAllTravelSpendingRecordsByLogTravelUserIdForApp(String id, String lastCreateTime, int pageSize) throws Exception{
		LogTravelSpendingRecordsQueryVoForApp travelSpendingRecordsQueryVoForApp = new LogTravelSpendingRecordsQueryVoForApp();
		travelSpendingRecordsQueryVoForApp.setId(id);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		travelSpendingRecordsQueryVoForApp.setLastCreateTime(StringUtils.isNotBlank(lastCreateTime) ? format.parse(lastCreateTime) : null);
		travelSpendingRecordsQueryVoForApp.setPageSize(pageSize);
		return travelSpendingRecordsMapper.findAllTravelSpendingRecordsByLogTravelUserIdForApp(travelSpendingRecordsQueryVoForApp);
	}

	@Override
	public LogTravelSpendingRecordsCustom findTravelSpendingRecordsByIdForEdit(String id) throws Exception{
		LogTravelSpendingRecordsCustom travelSpendingRecordsCustom = travelSpendingRecordsMapper.findTravelSpendingRecordsByIdForEdit(id);
		if (travelSpendingRecordsCustom != null){
			if (travelSpendingRecordsCustom.getFinCheckSheetId() == null){
		
				
				LogTravelTrafficSpendingExample travelTrafficSpendingExample = new LogTravelTrafficSpendingExample();
				travelTrafficSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(id);
				travelTrafficSpendingExample.setOrderByClause("sequence");
				List<LogTravelTrafficSpending> traffics = travelTrafficSpendingMapper.selectByExample(travelTrafficSpendingExample);
				travelSpendingRecordsCustom.setTraffics(traffics);
				
				LogTravelOtherSpendingExample travelOtherSpendingExample = new LogTravelOtherSpendingExample();
				travelOtherSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(id).andIsSubsidiesEqualTo(false);
				travelOtherSpendingExample.setOrderByClause("sequence");
				List<LogTravelOtherSpending> others = travelOtherSpendingMapper.selectByExample(travelOtherSpendingExample);
				travelSpendingRecordsCustom.setOthers(others);
				
				LogTravelOtherSpendingExample travelOtherSpendingExample2 = new LogTravelOtherSpendingExample();
				travelOtherSpendingExample2.createCriteria().andLogTravelSpendingRecordsIdEqualTo(id).andIsSubsidiesEqualTo(true);
				travelOtherSpendingExample2.setOrderByClause("sequence");
				List<LogTravelOtherSpending> subsidies = travelOtherSpendingMapper.selectByExample(travelOtherSpendingExample2);
				travelSpendingRecordsCustom.setSubsidies(subsidies);
				
				return travelSpendingRecordsCustom;
			}else{
				throw new RuntimeException("已经生成了报账单，无法修改，请刷新数据！");
			}
		}else{
			throw new RuntimeException("该记录已经不存在，请刷新数据！");
		}
				
	}

	@Override
	public int updateTravelSpendingRecords(LogTravelSpendingRecordsCustom travelSpendingRecordsCustom) throws Exception{
		LogTravelSpendingRecords originalTravelSpendingRecords = travelSpendingRecordsMapper.selectByPrimaryKey(travelSpendingRecordsCustom.getId());
		if (originalTravelSpendingRecords != null){
			if (originalTravelSpendingRecords.getFinCheckSheetId() == null){
		
				LogTravelSpendingRecords travelSpendingRecords = new LogTravelSpendingRecords();
				TravelSpendingRecordsCustomToLogTravelSpendingRecords(travelSpendingRecordsCustom, travelSpendingRecords);
				travelSpendingRecords.setCreateTime(new Date());
				travelSpendingRecords.setState("closed");
				
				
				LogTravelSpendingRecordsExample travelSpendingRecordsExample = new LogTravelSpendingRecordsExample();
				travelSpendingRecordsExample.createCriteria().andLogTravelUserIdEqualTo(travelSpendingRecords.getLogTravelUserId())
															.andTravelDateEqualTo(travelSpendingRecords.getTravelDate())
															.andWorkCardNoEqualTo(travelSpendingRecords.getWorkCardNo())
															.andIdNotEqualTo(travelSpendingRecords.getId());
				List<LogTravelSpendingRecords> travelSpendingRecordses = travelSpendingRecordsMapper.selectByExample(travelSpendingRecordsExample);
				
				//开始数据的校验
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				if (travelSpendingRecordses != null && travelSpendingRecordses.size() > 0){
					throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的"+travelSpendingRecords.getWorkCardNo()+"已经存在！");
				}
				
				LogTravelSpendingRecordsExample travelSpendingRecordsExample2 = new LogTravelSpendingRecordsExample();
				travelSpendingRecordsExample2.createCriteria().andLogTravelUserIdEqualTo(travelSpendingRecords.getLogTravelUserId())
															.andTravelDateEqualTo(travelSpendingRecords.getTravelDate())
															.andIdNotEqualTo(travelSpendingRecords.getId());
				List<LogTravelSpendingRecords> travelSpendingRecordses2 = travelSpendingRecordsMapper.selectByExample(travelSpendingRecordsExample2);
				boolean livePriceB = false;
				boolean lunchB = false;
				boolean dinnerB = false;
				boolean midnightSnackB = false;
				if (travelSpendingRecordses2 != null && travelSpendingRecordses2.size() > 0){
					for (LogTravelSpendingRecords travelSpendingRecords2 : travelSpendingRecordses2) {
						if (travelSpendingRecords2.getLivePrice() != null){
							livePriceB = true;
						}
						if (travelSpendingRecords2.getLunch() != null){
							lunchB = true;
						}
						if (travelSpendingRecords2.getDinner() != null){
							dinnerB = true;
						}
						if (travelSpendingRecords2.getMidnightSnack() != null){
							midnightSnackB = true;
						}
					}
				}
				if (livePriceB && travelSpendingRecords.getLivePrice() != null){
					throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的住宿费已经存在！");
				}
				if (lunchB && travelSpendingRecords.getLunch() != null){
					throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的午餐费已经存在！");
				}
				if (dinnerB && travelSpendingRecords.getDinner() != null){
					throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的晚餐费已经存在！");
				}
				if (midnightSnackB && travelSpendingRecords.getMidnightSnack() != null){
					throw new RuntimeException(format.format(travelSpendingRecords.getTravelDate())+"的夜宵费已经存在！");
				}
				//结束数据的校验
				
				int i = 0;
				i = i + travelSpendingRecordsMapper.updateByPrimaryKey(travelSpendingRecords);
				
				List<LogTravelTrafficSpending> traffics = travelSpendingRecordsCustom.getTraffics();
				if (traffics != null && traffics.size() > 0){
					List<LogTravelTrafficSpending> insertTraffics = new ArrayList<LogTravelTrafficSpending>();//新增的集合
					List<LogTravelTrafficSpending> updateTraffics = new ArrayList<LogTravelTrafficSpending>();//更新的集合
					List<LogTravelTrafficSpending> notDelTraffics = new ArrayList<LogTravelTrafficSpending>();//不删除的集合
					
					for (LogTravelTrafficSpending travelTrafficSpending : traffics) {
						if (StringUtils.isNotBlank(travelTrafficSpending.getId())){//更新的
							updateTraffics.add(travelTrafficSpending);
						}else{//新增的
							travelTrafficSpending.setId(UUIDBuild.getUUID());
							travelTrafficSpending.setLogTravelSpendingRecordsId(travelSpendingRecords.getId());
							insertTraffics.add(travelTrafficSpending);
						}
					}
					LogTravelTrafficSpendingExample travelTrafficSpendingExample = new LogTravelTrafficSpendingExample();
					travelTrafficSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(travelSpendingRecords.getId());
					List<LogTravelTrafficSpending> existingTraffics = travelTrafficSpendingMapper.selectByExample(travelTrafficSpendingExample);
					if (existingTraffics != null && existingTraffics.size() > 0 && updateTraffics != null && updateTraffics.size() > 0){
						for (LogTravelTrafficSpending existingTravelTrafficSpending : existingTraffics) {
							for (LogTravelTrafficSpending updateTravelTrafficSpending : updateTraffics) {
								if (existingTravelTrafficSpending.getId().equals(updateTravelTrafficSpending.getId())){
									notDelTraffics.add(existingTravelTrafficSpending);
								}
							}
						}
					}
					existingTraffics.removeAll(notDelTraffics);
					if (insertTraffics != null && insertTraffics.size() > 0){
						i = i + travelTrafficSpendingMapper.insertList(insertTraffics);
					}
					if (updateTraffics != null && updateTraffics.size() > 0){
						for (LogTravelTrafficSpending travelTrafficSpending : updateTraffics) {
							i = i + travelTrafficSpendingMapper.updateByPrimaryKeySelective(travelTrafficSpending);
						}
					}
					if (existingTraffics != null && existingTraffics.size() > 0){
						List<String> list = new ArrayList<String>();
						for (LogTravelTrafficSpending travelTrafficSpending : existingTraffics) {
							list.add(travelTrafficSpending.getId());
						}
						LogTravelTrafficSpendingExample travelTrafficSpendingExample2 = new LogTravelTrafficSpendingExample();
						travelTrafficSpendingExample2.createCriteria().andIdIn(list);
						i = i + travelTrafficSpendingMapper.deleteByExample(travelTrafficSpendingExample2);
					}
				}else{//传过来的为空，则要删除所有的
					LogTravelTrafficSpendingExample travelTrafficSpendingExample = new LogTravelTrafficSpendingExample();
					travelTrafficSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(travelSpendingRecords.getId());
					travelTrafficSpendingMapper.deleteByExample(travelTrafficSpendingExample);
				}
				
				
				
				
				
				List<LogTravelOtherSpending> others = travelSpendingRecordsCustom.getOthers();
				if (others != null && others.size() > 0){
					List<LogTravelOtherSpending> insertOthers = new ArrayList<LogTravelOtherSpending>();//新增的集合
					List<LogTravelOtherSpending> updateOthers = new ArrayList<LogTravelOtherSpending>();//更新的集合
					List<LogTravelOtherSpending> notDelOthers = new ArrayList<LogTravelOtherSpending>();//删除的集合
					
					for (LogTravelOtherSpending travelOtherSpending : others) {
						if (StringUtils.isNotBlank(travelOtherSpending.getId())){
							updateOthers.add(travelOtherSpending);
						}else{
							travelOtherSpending.setId(UUIDBuild.getUUID());
							travelOtherSpending.setLogTravelSpendingRecordsId(travelSpendingRecords.getId());
							insertOthers.add(travelOtherSpending);
						}
					}
					LogTravelOtherSpendingExample travelOtherSpendingExample = new LogTravelOtherSpendingExample();
					travelOtherSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(travelSpendingRecords.getId()).andIsSubsidiesEqualTo(false);
					List<LogTravelOtherSpending> existingOthers = travelOtherSpendingMapper.selectByExample(travelOtherSpendingExample);
					if (existingOthers != null && existingOthers.size() > 0 && updateOthers != null && updateOthers.size() > 0){
						for (LogTravelOtherSpending existingTravelOtherSpending : existingOthers) {
							for (LogTravelOtherSpending updateTravelOtherSpending : updateOthers) {
								if (existingTravelOtherSpending.getId().equals(updateTravelOtherSpending.getId())){
									notDelOthers.add(existingTravelOtherSpending);
								}
							}
						}
					}
					existingOthers.removeAll(notDelOthers);
					if (insertOthers != null && insertOthers.size() > 0){
						i = i + travelOtherSpendingMapper.insertList(insertOthers);
					}
					if (updateOthers != null && updateOthers.size() > 0){
						for (LogTravelOtherSpending travelOtherSpending : updateOthers) {
							i = i + travelOtherSpendingMapper.updateByPrimaryKeySelective(travelOtherSpending);
						}
					}
					if (existingOthers != null && existingOthers.size() > 0){
						List<String> list = new ArrayList<String>();
						for (LogTravelOtherSpending travelOtherSpending : existingOthers) {
							list.add(travelOtherSpending.getId());
						}
						LogTravelOtherSpendingExample travelOtherSpendingExample2 = new LogTravelOtherSpendingExample();
						travelOtherSpendingExample2.createCriteria().andIdIn(list);
						i = i + travelOtherSpendingMapper.deleteByExample(travelOtherSpendingExample2);
					}
				}else{//传过来的为空，则要删除所有的
					LogTravelOtherSpendingExample travelOtherSpendingExample = new LogTravelOtherSpendingExample();
					travelOtherSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(travelSpendingRecords.getId()).andIsSubsidiesEqualTo(false);
					travelOtherSpendingMapper.deleteByExample(travelOtherSpendingExample);
				}
				
				
				
				List<LogTravelOtherSpending> subsidies = travelSpendingRecordsCustom.getSubsidies();
				if (subsidies != null && subsidies.size() > 0){
					List<LogTravelOtherSpending> insertSubsidies = new ArrayList<LogTravelOtherSpending>();//新增的集合
					List<LogTravelOtherSpending> updateSubsidies = new ArrayList<LogTravelOtherSpending>();//更新的集合
					List<LogTravelOtherSpending> notDelSubsidies = new ArrayList<LogTravelOtherSpending>();//删除的集合
					for (LogTravelOtherSpending travelOtherSpending : subsidies) {
						if (StringUtils.isNotBlank(travelOtherSpending.getId())){
							updateSubsidies.add(travelOtherSpending);
						}else{
							travelOtherSpending.setId(UUIDBuild.getUUID());
							travelOtherSpending.setLogTravelSpendingRecordsId(travelSpendingRecords.getId());
							insertSubsidies.add(travelOtherSpending);
						}
					}
					LogTravelOtherSpendingExample travelOtherSpendingExample = new LogTravelOtherSpendingExample();
					travelOtherSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(travelSpendingRecords.getId()).andIsSubsidiesEqualTo(true);
					List<LogTravelOtherSpending> existingSubsidies = travelOtherSpendingMapper.selectByExample(travelOtherSpendingExample);
					if (existingSubsidies != null && existingSubsidies.size() > 0 && updateSubsidies != null && updateSubsidies.size() > 0){
						for (LogTravelOtherSpending existingTravelOtherSpending : existingSubsidies) {
							for (LogTravelOtherSpending updateTravelOtherSpending : updateSubsidies) {
								if (existingTravelOtherSpending.getId().equals(updateTravelOtherSpending.getId())){
									notDelSubsidies.add(existingTravelOtherSpending);
								}
							}
						}
					}
					existingSubsidies.removeAll(notDelSubsidies);
					if (insertSubsidies != null && insertSubsidies.size() > 0){
						i = i + travelOtherSpendingMapper.insertList(insertSubsidies);
					}
					if (updateSubsidies != null && updateSubsidies.size() > 0){
						for (LogTravelOtherSpending travelOtherSpending : updateSubsidies) {
							i = i + travelOtherSpendingMapper.updateByPrimaryKeySelective(travelOtherSpending);
						}
					}
					if (existingSubsidies != null && existingSubsidies.size() > 0){
						List<String> list = new ArrayList<String>();
						for (LogTravelOtherSpending travelOtherSpending : existingSubsidies) {
							list.add(travelOtherSpending.getId());
						}
						LogTravelOtherSpendingExample travelOtherSpendingExample2 = new LogTravelOtherSpendingExample();
						travelOtherSpendingExample2.createCriteria().andIdIn(list);
						i = i + travelOtherSpendingMapper.deleteByExample(travelOtherSpendingExample2);
					}
				}else{//传过来的为空，则要删除所有的
					LogTravelOtherSpendingExample travelOtherSpendingExample = new LogTravelOtherSpendingExample();
					travelOtherSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(travelSpendingRecords.getId()).andIsSubsidiesEqualTo(true);
					travelOtherSpendingMapper.deleteByExample(travelOtherSpendingExample);
				}
				
				return i;
			}else{
				throw new RuntimeException("已经生成了报账单，无法修改，请刷新数据！");
			}
		}else{
			throw new RuntimeException("该记录已经不存在，请刷新数据！");
		}
	}

	@Override
	public int deleteTravelSpendingRecordsById(String id) {
		LogTravelSpendingRecords travelSpendingRecords = travelSpendingRecordsMapper.selectByPrimaryKey(id);
		if (travelSpendingRecords != null){
			if (travelSpendingRecords.getFinCheckSheetId() == null){
				int i = 0;
				LogTravelTrafficSpendingExample travelTrafficSpendingExample = new LogTravelTrafficSpendingExample();
				travelTrafficSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(id);
				i = i + travelTrafficSpendingMapper.deleteByExample(travelTrafficSpendingExample);
				
				LogTravelOtherSpendingExample travelOtherSpendingExample = new LogTravelOtherSpendingExample();
				travelOtherSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(id);
				i = i + travelOtherSpendingMapper.deleteByExample(travelOtherSpendingExample);
				
				i = i + travelSpendingRecordsMapper.deleteByPrimaryKey(id);
				return i;
			}else{
				throw new RuntimeException("已经生成了报账单，无法修改，请刷新数据！");
			}
		}else{
			throw new RuntimeException("该记录已经不存在，请刷新数据！");
		}
		
	}
	
	@Override
	public LogTravelSpendingRecordsCustom findTravelSpendingRecordsByIdForCopyData(String id) throws Exception{
		LogTravelSpendingRecordsCustom travelSpendingRecordsCustom = travelSpendingRecordsMapper.findTravelSpendingRecordsByIdForEdit(id);
		if (travelSpendingRecordsCustom != null){
			
			LogTravelTrafficSpendingExample travelTrafficSpendingExample = new LogTravelTrafficSpendingExample();
			travelTrafficSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(id);
			travelTrafficSpendingExample.setOrderByClause("sequence");
			List<LogTravelTrafficSpending> traffics = travelTrafficSpendingMapper.selectByExample(travelTrafficSpendingExample);
			travelSpendingRecordsCustom.setTraffics(traffics);
			
			LogTravelOtherSpendingExample travelOtherSpendingExample = new LogTravelOtherSpendingExample();
			travelOtherSpendingExample.createCriteria().andLogTravelSpendingRecordsIdEqualTo(id).andIsSubsidiesEqualTo(false);
			travelOtherSpendingExample.setOrderByClause("sequence");
			List<LogTravelOtherSpending> others = travelOtherSpendingMapper.selectByExample(travelOtherSpendingExample);
			travelSpendingRecordsCustom.setOthers(others);
			
			LogTravelOtherSpendingExample travelOtherSpendingExample2 = new LogTravelOtherSpendingExample();
			travelOtherSpendingExample2.createCriteria().andLogTravelSpendingRecordsIdEqualTo(id).andIsSubsidiesEqualTo(true);
			travelOtherSpendingExample2.setOrderByClause("sequence");
			List<LogTravelOtherSpending> subsidies = travelOtherSpendingMapper.selectByExample(travelOtherSpendingExample2);
			travelSpendingRecordsCustom.setSubsidies(subsidies);
			
			return travelSpendingRecordsCustom;
		}else{
			throw new RuntimeException("该记录已经不存在，请刷新数据！");
		}
	}
	
	@Override
	public List<LogTravelSpendingRecordsCustom> findAllTravelSpendingRecordsList(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo) {
		return travelSpendingRecordsMapper.findAllTravelSpendingRecordsList(travelSpendingRecordsQueryVo);
	}

	@Override
	public String findAllTravelSpendingRecordsTotal(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo) {
		return travelSpendingRecordsMapper.findAllTravelSpendingRecordsTotal(travelSpendingRecordsQueryVo);
	}

	@Override
	public List<LogTravelSpendingRecordsSubsidiaryCustom> findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId(String id) {
		List<LogTravelSpendingRecordsSubsidiaryCustom> list1 = travelOtherSpendingMapper.findAllTravelOtherSpendingByLogTravelSpendingRecordsId(id);
		
		List<LogTravelSpendingRecordsSubsidiaryCustom> list2 = travelTrafficSpendingMapper.findAllTravelTrafficSpendingByLogTravelSpendingRecordsId(id);
		
		list1.addAll(list2);
		
		return list1;
	}

	@Override
	public List<LogTravelSpendingRecordsCustomForExportExcelForWorkHour> findDataForExportExcelForWorkHour(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo) {
		return travelSpendingRecordsMapper.findDataForExportExcelForWorkHour(travelSpendingRecordsQueryVo);
	}
	

	@Override
	public List<LogTravelSpendingRecordsCustomForExportExcelForMealsNumber> findDataForExportExcelForMealsNumber(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo) {
		return travelSpendingRecordsMapper.findDataForExportExcelForMealsNumber(travelSpendingRecordsQueryVo);
	}

	@Override
	public String generateCheckSheet(LogTravelSpendingRecordsQueryVo travelSpendingRecordsQueryVo,String applicant) {
		FinCheckSheet checkSheet = travelSpendingRecordsMapper.findDataForGenerateCheckSheet(travelSpendingRecordsQueryVo);
		if (checkSheet != null){
			if (checkSheet.getInstallWorkCardNo().indexOf(",") != -1){
				throw new RuntimeException("不能多个工咭生成一个报账单");
			}
			String id = UUIDBuild.getUUID();
			checkSheet.setId(id);
			checkSheet.setApplicant(applicant);
			checkSheet.setIsLock(false);
			String accompanyingPersonnel = checkSheet.getAccompanyingPersonnel();
			String[] strings = accompanyingPersonnel.split(",");
			List<String> list = Arrays.asList(strings);
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.addAll(list);
			arrayList.remove(applicant);
			checkSheet.setAccompanyingPersonnel(StringUtils.join(arrayList, ","));
			
			SimpleDateFormat format = new SimpleDateFormat("yyMM");
			String checkSheetNo = format.format(new Date());
			
			int maxCheckSheetNo = checkSheetMapper.findMaxCheckSheetNo(checkSheetNo);
			checkSheet.setCheckSheetNo("CS" + (Integer.parseInt(checkSheetNo)*1000 + maxCheckSheetNo + 1));
			
			checkSheet.setState("closed");
			
			checkSheetMapper.insert(checkSheet);
			
			travelSpendingRecordsQueryVo.setFinCheckSheetid(id);
			
			travelSpendingRecordsMapper.updateByGenerateCheckSheet(travelSpendingRecordsQueryVo);
			return checkSheet.getCheckSheetNo();
		}else{
			throw new RuntimeException("没有找到生成报账单的数据");
		}
		
	}
	
	public void TravelSpendingRecordsCustomToLogTravelSpendingRecords(LogTravelSpendingRecordsCustom travelSpendingRecordsCustom, LogTravelSpendingRecords travelSpendingRecords) throws Exception{
		travelSpendingRecords.setId(travelSpendingRecordsCustom.getId());
		travelSpendingRecords.setLogTravelUserId(travelSpendingRecordsCustom.getLogTravelUserId());
		travelSpendingRecords.setWorkCardNo(travelSpendingRecordsCustom.getWorkCardNo());
		travelSpendingRecords.setIsAirpoint(travelSpendingRecordsCustom.getIsAirpoint());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		travelSpendingRecords.setTravelDate(StringUtils.isNotBlank(travelSpendingRecordsCustom.getTravelDate()) ? format.parse(travelSpendingRecordsCustom.getTravelDate()) : null);
		travelSpendingRecords.setLiveNumber(travelSpendingRecordsCustom.getLiveNumber());
		travelSpendingRecords.setLivePrice(travelSpendingRecordsCustom.getLivePrice());
		travelSpendingRecords.setProvinces(travelSpendingRecordsCustom.getProvinces());
		travelSpendingRecords.setCity(travelSpendingRecordsCustom.getCity());
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		travelSpendingRecords.setStartTime1(StringUtils.isNotBlank(travelSpendingRecordsCustom.getStartTime1()) ? format2.parse(travelSpendingRecordsCustom.getStartTime1()) : null);
		travelSpendingRecords.setEndTime1(StringUtils.isNotBlank(travelSpendingRecordsCustom.getEndTime1()) ? format2.parse(travelSpendingRecordsCustom.getEndTime1()) : null);
		travelSpendingRecords.setLunch(travelSpendingRecordsCustom.getLunch());
		travelSpendingRecords.setLunchType(travelSpendingRecordsCustom.getLunchType());
		travelSpendingRecords.setStartTime2(StringUtils.isNotBlank(travelSpendingRecordsCustom.getStartTime2()) ? format2.parse(travelSpendingRecordsCustom.getStartTime2()) : null);
		travelSpendingRecords.setEndTime2(StringUtils.isNotBlank(travelSpendingRecordsCustom.getEndTime2()) ? format2.parse(travelSpendingRecordsCustom.getEndTime2()) : null);
		travelSpendingRecords.setDinner(travelSpendingRecordsCustom.getDinner());
		travelSpendingRecords.setDinnerType(travelSpendingRecordsCustom.getDinnerType());
		travelSpendingRecords.setStartTime3(StringUtils.isNotBlank(travelSpendingRecordsCustom.getStartTime3()) ? format2.parse(travelSpendingRecordsCustom.getStartTime3()) : null);
		travelSpendingRecords.setEndTime3(StringUtils.isNotBlank(travelSpendingRecordsCustom.getEndTime3()) ? format2.parse(travelSpendingRecordsCustom.getEndTime3()) : null);
		travelSpendingRecords.setMidnightSnack(travelSpendingRecordsCustom.getMidnightSnack());
		travelSpendingRecords.setFinCheckSheetId(travelSpendingRecordsCustom.getFinCheckSheetId());
	}
	
	public void LogTravelSpendingRecordsToTravelSpendingRecordsCustom(LogTravelSpendingRecords travelSpendingRecords, LogTravelSpendingRecordsCustom travelSpendingRecordsCustom) throws Exception{
		travelSpendingRecordsCustom.setId(travelSpendingRecords.getId());
		travelSpendingRecordsCustom.setLogTravelUserId(travelSpendingRecords.getLogTravelUserId());
		travelSpendingRecordsCustom.setWorkCardNo(travelSpendingRecords.getWorkCardNo());
		travelSpendingRecordsCustom.setIsAirpoint(travelSpendingRecords.getIsAirpoint());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		travelSpendingRecordsCustom.setTravelDate(travelSpendingRecords.getTravelDate() != null ? format.format(travelSpendingRecords.getTravelDate()) : null);
		travelSpendingRecordsCustom.setLiveNumber(travelSpendingRecords.getLiveNumber());
		travelSpendingRecordsCustom.setLivePrice(travelSpendingRecords.getLivePrice());
		travelSpendingRecordsCustom.setProvinces(travelSpendingRecords.getProvinces());
		travelSpendingRecordsCustom.setCity(travelSpendingRecords.getCity());
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		travelSpendingRecordsCustom.setStartTime1(travelSpendingRecords.getStartTime1() != null ? format2.format(travelSpendingRecords.getStartTime1()) : null);
		travelSpendingRecordsCustom.setEndTime1(travelSpendingRecords.getEndTime1() != null ? format2.format(travelSpendingRecords.getEndTime1()) : null);
		travelSpendingRecordsCustom.setLunch(travelSpendingRecords.getLunch());
		travelSpendingRecordsCustom.setLunchType(travelSpendingRecords.getLunchType());
		travelSpendingRecordsCustom.setStartTime2(travelSpendingRecords.getStartTime2() != null ? format2.format(travelSpendingRecords.getStartTime2()) : null);
		travelSpendingRecordsCustom.setEndTime2(travelSpendingRecords.getEndTime2() != null ? format2.format(travelSpendingRecords.getEndTime2()) : null);
		travelSpendingRecordsCustom.setDinner(travelSpendingRecords.getDinner());
		travelSpendingRecordsCustom.setDinnerType(travelSpendingRecords.getDinnerType());
		travelSpendingRecordsCustom.setStartTime3(travelSpendingRecords.getStartTime3() != null ? format2.format(travelSpendingRecords.getStartTime3()) : null);
		travelSpendingRecordsCustom.setEndTime3(travelSpendingRecords.getEndTime3() != null ? format2.format(travelSpendingRecords.getEndTime3()) : null);
		travelSpendingRecordsCustom.setMidnightSnack(travelSpendingRecords.getMidnightSnack());
		travelSpendingRecordsCustom.setFinCheckSheetId(travelSpendingRecords.getFinCheckSheetId());
	}

	@Override
	public String calculateCostByWorkCardNo(String workCardNo) {
		return travelSpendingRecordsMapper.calculateCostByWorkCardNo(workCardNo);
	}
	
	
	
	
	
	
}
