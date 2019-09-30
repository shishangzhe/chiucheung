package cn.chiucheung.dao.mapper.warehouse.standardaccessoriesinventory;

import cn.chiucheung.po.warehouse.standardaccessoriesinventory.WarStandardAccessoriesInventory;
import cn.chiucheung.po.warehouse.standardaccessoriesinventory.WarStandardAccessoriesInventoryExample;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesInventoryCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WarStandardAccessoriesInventoryMapper {
    int countByExample(WarStandardAccessoriesInventoryExample example);

    int deleteByExample(WarStandardAccessoriesInventoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarStandardAccessoriesInventory record);

    int insertSelective(WarStandardAccessoriesInventory record);

    List<WarStandardAccessoriesInventory> selectByExample(WarStandardAccessoriesInventoryExample example);

    WarStandardAccessoriesInventory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarStandardAccessoriesInventory record, @Param("example") WarStandardAccessoriesInventoryExample example);

    int updateByExample(@Param("record") WarStandardAccessoriesInventory record, @Param("example") WarStandardAccessoriesInventoryExample example);

    int updateByPrimaryKeySelective(WarStandardAccessoriesInventory record);

    int updateByPrimaryKey(WarStandardAccessoriesInventory record);

	List<WarStandardAccessoriesInventoryCustom> findAllWarStandardAccessoriesInventoryList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);

	String findAllWarStandardAccessoriesInventoryTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);
}