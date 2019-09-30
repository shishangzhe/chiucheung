package cn.chiucheung.dao.mapper.warehouse.standardaccessories;

import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessories;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesExample;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WarStandardAccessoriesMapper {
    int countByExample(WarStandardAccessoriesExample example);

    int deleteByExample(WarStandardAccessoriesExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarStandardAccessories record);

    int insertSelective(WarStandardAccessories record);

    List<WarStandardAccessories> selectByExample(WarStandardAccessoriesExample example);

    WarStandardAccessories selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarStandardAccessories record, @Param("example") WarStandardAccessoriesExample example);

    int updateByExample(@Param("record") WarStandardAccessories record, @Param("example") WarStandardAccessoriesExample example);

    int updateByPrimaryKeySelective(WarStandardAccessories record);

    int updateByPrimaryKey(WarStandardAccessories record);
    
    List<WarStandardAccessoriesCustom> findAllWarStandardAccessoriesList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);

	String findAllWarStandardAccessoriesTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);
}