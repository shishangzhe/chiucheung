package cn.chiucheung.service.engineering;

import java.util.List;

import cn.chiucheung.pojo.engineering.datadistribution.WorkCardNoCustom;
import cn.chiucheung.pojo.engineering.datadistribution.WorkCardSubsidiaryCustom;

public interface DataDistributionService {

	/**
	 * 查找所有的工咭
	 * @param workCardNo 查询条件
	 * @return
	 */
	List<WorkCardNoCustom> findAllWorkCardNo(WorkCardNoCustom workCardNoCustom);
	
	/**
	 * 查找所有的工咭项次
	 * @param workCardNo 查找条件
	 * @return
	 */
	List<WorkCardSubsidiaryCustom> findAllWorkCardSubsidiary(String workCardNo);

}
