package cn.chiucheung.dao.mapper.warehouse.materialinventory;

import cn.chiucheung.po.warehouse.materialinventory.WarMaterialInventory;
import cn.chiucheung.po.warehouse.materialinventory.WarMaterialInventoryExample;
import cn.chiucheung.pojo.warehouse.material.WarMaterialInventoryCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WarMaterialInventoryMapper {
    int countByExample(WarMaterialInventoryExample example);

    int deleteByExample(WarMaterialInventoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarMaterialInventory record);

    int insertSelective(WarMaterialInventory record);

    List<WarMaterialInventory> selectByExample(WarMaterialInventoryExample example);

    WarMaterialInventory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarMaterialInventory record, @Param("example") WarMaterialInventoryExample example);

    int updateByExample(@Param("record") WarMaterialInventory record, @Param("example") WarMaterialInventoryExample example);

    int updateByPrimaryKeySelective(WarMaterialInventory record);

    int updateByPrimaryKey(WarMaterialInventory record);

	List<WarMaterialInventoryCustom> findAllWarMaterialInventoryList(WarMaterialQueryVo materialQueryVo);

	String findAllWarMaterialInventoryTotal(WarMaterialQueryVo materialQueryVo);
}