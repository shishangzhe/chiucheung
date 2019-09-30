package cn.chiucheung.dao.mapper.warehouse.standardaccessoriesstockout;

import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiary;
import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiaryExample;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiaryCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WarStandardAccessoriesStockOutSubsidiaryMapper {
    int countByExample(WarStandardAccessoriesStockOutSubsidiaryExample example);

    int deleteByExample(WarStandardAccessoriesStockOutSubsidiaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarStandardAccessoriesStockOutSubsidiary record);

    int insertSelective(WarStandardAccessoriesStockOutSubsidiary record);

    List<WarStandardAccessoriesStockOutSubsidiary> selectByExample(WarStandardAccessoriesStockOutSubsidiaryExample example);

    WarStandardAccessoriesStockOutSubsidiary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarStandardAccessoriesStockOutSubsidiary record, @Param("example") WarStandardAccessoriesStockOutSubsidiaryExample example);

    int updateByExample(@Param("record") WarStandardAccessoriesStockOutSubsidiary record, @Param("example") WarStandardAccessoriesStockOutSubsidiaryExample example);

    int updateByPrimaryKeySelective(WarStandardAccessoriesStockOutSubsidiary record);

    int updateByPrimaryKey(WarStandardAccessoriesStockOutSubsidiary record);

	int insertList(List<WarStandardAccessoriesStockOutSubsidiary> standardAccessoriesStockOutSubsidiaries);

	List<WarStandardAccessoriesStockOutSubsidiaryCustom> findAllWarStandardAccessoriesStockOutSubsidiaryListByWarStandardAccessoriesStockOutId(@Param("warStandardAccessoriesStockOutId") String id);
	
	/**
	 * //根据物料Id查询库存与未审核完成的出库单的差值（也就是：库存量-占有量（未审核完成的出库单））
	 * @param warStandardAccessoriesId 物料id
	 * @param warStandardAccessoriesStockOutId 不查询的入库单，用于修改
	 * @return
	 */
	int calculateDifferencesQuantityForInventoryAndAllNotAuditCompletedByWarStandardAccessoriesId(@Param("warStandardAccessoriesId") String warStandardAccessoriesId, @Param("warStandardAccessoriesStockOutId") String warStandardAccessoriesStockOutId);
}