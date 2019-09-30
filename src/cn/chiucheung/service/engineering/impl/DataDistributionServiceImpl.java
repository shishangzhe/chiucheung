package cn.chiucheung.service.engineering.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardSubsidiaryMapper;
import cn.chiucheung.pojo.engineering.datadistribution.WorkCardNoCustom;
import cn.chiucheung.pojo.engineering.datadistribution.WorkCardSubsidiaryCustom;
import cn.chiucheung.service.engineering.DataDistributionService;

@Service
public class DataDistributionServiceImpl implements DataDistributionService{
	
	@Autowired
	private SalWorkCardSubsidiaryMapper workCardSubsidiaryMapper;
	
	@Override
	public List<WorkCardNoCustom> findAllWorkCardNo(WorkCardNoCustom workCardNoCustom) {
		return workCardSubsidiaryMapper.findAllWorkCardNo(workCardNoCustom);
	}
	
	@Override
	public List<WorkCardSubsidiaryCustom> findAllWorkCardSubsidiary(String workCardNo) {
		return workCardSubsidiaryMapper.findAllWorkCardSubsidiary(workCardNo);
	}

}
