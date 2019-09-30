package cn.chiucheung.dao.mapper.warehouse.standardaccessoriesstockout;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOut;
import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutExample;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutQueryVo;

public interface WarStandardAccessoriesStockOutMapper {
    int countByExample(WarStandardAccessoriesStockOutExample example);

    int deleteByExample(WarStandardAccessoriesStockOutExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarStandardAccessoriesStockOut record);

    int insertSelective(WarStandardAccessoriesStockOut record);

    List<WarStandardAccessoriesStockOut> selectByExample(WarStandardAccessoriesStockOutExample example);

    WarStandardAccessoriesStockOut selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarStandardAccessoriesStockOut record, @Param("example") WarStandardAccessoriesStockOutExample example);

    int updateByExample(@Param("record") WarStandardAccessoriesStockOut record, @Param("example") WarStandardAccessoriesStockOutExample example);

    int updateByPrimaryKeySelective(WarStandardAccessoriesStockOut record);

    int updateByPrimaryKey(WarStandardAccessoriesStockOut record);
    
	int findMaxStockOutNo(@Param("stockOutNo") String stockOutNo);

	List<WarStandardAccessoriesStockOut> findAllWarStandardAccessoriesStockOutList(WarStandardAccessoriesStockOutQueryVo standardAccessoriesStockOutQueryVo);

	String findAllWarStandardAccessoriesStockOutTotal(WarStandardAccessoriesStockOutQueryVo standardAccessoriesStockOutQueryVo);

	int updateWarStandardAccessoriesInventoryByWarStandardAccessoriesStockOutIdForSubtract(String id);

	int updateWarStandardAccessoriesInventoryByWarStandardAccessoriesStockOutIdForAdd(String id);
}