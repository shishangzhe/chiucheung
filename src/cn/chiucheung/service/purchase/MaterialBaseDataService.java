package cn.chiucheung.service.purchase;

import java.util.List;

import cn.chiucheung.po.purchase.material.PurMaterialBaseData;
import cn.chiucheung.pojo.purchase.material.PurMaterialBaseDataCustom;

public interface MaterialBaseDataService {
	
	/**
	 * 查找所有keyword，重复数据值显示一条，用于前面下拉列表框的数据显示
	 * @return
	 */
	List<PurMaterialBaseData> findAllKeywordByDistinct();
	
	/**
	 * 根据keyword查找PurMaterialBaseData
	 * @param keyword
	 * @return
	 */
	List<PurMaterialBaseData> findAllPurMaterialBaseDataByKeyword(String keyword);
	
	/**
	 * 比重的查询
	 * @return
	 */
	List<PurMaterialBaseDataCustom> findAllPurMaterialBaseDataByKeywordForDensity();
	
	/**
	 * 新增数据字典
	 * @param dictionarie
	 */
	int savePurMaterialBaseData(PurMaterialBaseData materialBaseData);
	
	/**
	 * 修改数据字典
	 * @param dictionarie
	 */
	int updatePurMaterialBaseData(PurMaterialBaseData materialBaseData);
	
	/**
	 * 根据id删除数据字典
	 * @param id
	 */
	int deletePurMaterialBaseDataById(String id);

	
}
