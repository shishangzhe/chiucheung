package cn.chiucheung.dao.mapper.engineering.standardbom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.engineering.standardbom.EngStandardBom;
import cn.chiucheung.po.engineering.standardbom.EngStandardBomExample;
import cn.chiucheung.pojo.engineering.standardBom.EngStandardBomCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;

public interface EngStandardBomMapper {
    int countByExample(EngStandardBomExample example);

    int deleteByExample(EngStandardBomExample example);

    int deleteByPrimaryKey(String id);

    int insert(EngStandardBom record);

    int insertSelective(EngStandardBom record);

    List<EngStandardBom> selectByExample(EngStandardBomExample example);

    EngStandardBom selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EngStandardBom record, @Param("example") EngStandardBomExample example);

    int updateByExample(@Param("record") EngStandardBom record, @Param("example") EngStandardBomExample example);

    int updateByPrimaryKeySelective(EngStandardBom record);

    int updateByPrimaryKey(EngStandardBom record);
    
    List<EngStandardBomCustom> findAllStandardBomList(WarMaterialQueryVo materialQueryVo);

	String findAllStandardBomTotal(WarMaterialQueryVo materialQueryVo);

	EngStandardBomCustom findStandardBomCustomById(String id);
}