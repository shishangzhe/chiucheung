package cn.chiucheung.dao.mapper.warehouse.material;

import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.po.warehouse.material.WarMaterialExample;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WarMaterialMapper {
    int countByExample(WarMaterialExample example);

    int deleteByExample(WarMaterialExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarMaterial record);

    int insertSelective(WarMaterial record);

    List<WarMaterial> selectByExample(WarMaterialExample example);

    WarMaterial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarMaterial record, @Param("example") WarMaterialExample example);

    int updateByExample(@Param("record") WarMaterial record, @Param("example") WarMaterialExample example);

    int updateByPrimaryKeySelective(WarMaterial record);

    int updateByPrimaryKey(WarMaterial record);

	List<WarMaterial> findAllWarMaterialList(WarMaterialQueryVo materialQueryVo);

	String findAllWarMaterialTotal(WarMaterialQueryVo materialQueryVo);
}