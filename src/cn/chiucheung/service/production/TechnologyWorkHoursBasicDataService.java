package cn.chiucheung.service.production;

import java.util.HashMap;
import java.util.List;

import cn.chiucheung.po.production.standard.ProProcess;
import cn.chiucheung.po.production.standard.ProTechnologyBasicData;
import cn.chiucheung.po.production.standard.ProTechnologyWorkHoursBasicData;
import cn.chiucheung.pojo.production.standard.ProProcessQueryVo;
import cn.chiucheung.pojo.production.standard.ProProcessTechnologyCustom;
import cn.chiucheung.pojo.production.standard.ProTechnologyBasicDataCustom;

public interface TechnologyWorkHoursBasicDataService {
	
	/**
	 * 新增工序工艺
	 * @param technologyBasicData
	 * @return
	 */
	int saveTechnology(ProTechnologyBasicData technologyBasicData);
	
	/**
	 * 查找所有的工序工艺
	 * @param processQueryVo
	 * @return
	 */
	List<ProProcessTechnologyCustom> findAllProProcessTechnologyList(ProProcessQueryVo processQueryVo);

	/**
	 * 获取所有的生产工序表（用于treegrid的展开）
	 * @param proProcessId
	 * @return
	 */
	List<ProProcessTechnologyCustom> findAllProProcessTechnologySubsidiaryListByProcessIdOrTechnologyBasicDataId(String proProcessId);
	
	/**
	 * 根据id查找工艺
	 * @param id
	 * @return
	 */
	ProProcessTechnologyCustom findTechnologyById(String id);
	
	/**
	 * 修改工艺
	 * @param technologyBasicData
	 * @return
	 */
	int updateTechnology(ProTechnologyBasicData technologyBasicData);
	
	/**
	 * 根据id删除工艺
	 * @param id
	 * @return
	 */
	int deleteTechnologyById(String id);
	
	/**
	 * 根据工序id查找工艺
	 * @param id
	 * @return
	 */
	List<ProTechnologyBasicData> findTechnologyListByProProcessId(String id);
	
	/**
	 * 保存工艺工时
	 * @param technologyWorkHoursBasicData
	 * @return
	 */
	int saveTechnologyWorkHours(ProTechnologyWorkHoursBasicData technologyWorkHoursBasicData);
	
	/**
	 * 根据id查找工艺工时
	 * @param id
	 * @return
	 */
	ProProcessTechnologyCustom findTechnologyWorkHoursById(String id);
	
	/**
	 * 更新工艺工时
	 * @param technologyWorkHoursBasicData
	 * @return
	 */
	int updateTechnologyWorkHours(ProTechnologyWorkHoursBasicData technologyWorkHoursBasicData);
	
	/**
	 * 根据id删除工艺工时
	 * @param id
	 * @return
	 */
	int deleteTechnologyWorkHoursById(String id);
	
	/**
	 * 根据工序id查找该工序的工序工艺，用于页面的计算
	 * @return 
	 */
	List<ProTechnologyBasicDataCustom> findProcessTechnologyByProcessId(String processId, String calculationMethod);
}
