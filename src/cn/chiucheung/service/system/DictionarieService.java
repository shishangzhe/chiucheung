package cn.chiucheung.service.system;

import java.util.List;

import cn.chiucheung.po.system.dictionarie.SysDictionarie;

public interface DictionarieService {

	/**
	 * 查找所有keyword，重复数据值显示一条，用于前面下拉列表框的数据显示
	 * @return
	 */
	List<SysDictionarie> findAllKeywordByDistinct();

	
	/**
	 * 根据keyword查找SysDictionarie
	 * @param keyword
	 * @return
	 */
	List<SysDictionarie> findAllDictionarieByKeyword(String keyword);
	
	/**
	 * 新增数据字典
	 * @param dictionarie
	 */
	int saveSysDictionarie(SysDictionarie dictionarie);
	
	/**
	 * 修改数据字典
	 * @param dictionarie
	 */
	int updateSysDictionarie(SysDictionarie dictionarie);
	
	/**
	 * 根据id删除数据字典
	 * @param id
	 */
	int deleteSysDictionarieById(String id);

}
