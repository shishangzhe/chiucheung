package cn.chiucheung.service.warehouse;

import java.util.List;

import cn.chiucheung.po.warehouse.basedata.WarBaseData;

public interface BaseDataService {

	/**
	 * 查找所有keyword，重复数据值显示一条，用于前面下拉列表框的数据显示
	 * @return
	 */
	List<WarBaseData> findAllKeywordByDistinct();

	
	/**
	 * 根据keyword查找SysDictionarie
	 * @param keyword
	 * @return
	 */
	List<WarBaseData> findAllWarBaseDataByKeyword(String keyword);
	
	/**
	 * 新增数据字典
	 * @param dictionarie
	 */
	int saveWarBaseData(WarBaseData baseData);
	
	/**
	 * 修改数据字典
	 * @param dictionarie
	 */
	int updateWarBaseData(WarBaseData baseData);
	
	/**
	 * 根据id删除数据字典
	 * @param id
	 */
	int deleteWarBaseDataById(String id);

}
