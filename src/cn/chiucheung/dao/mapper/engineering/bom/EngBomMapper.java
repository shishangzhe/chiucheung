package cn.chiucheung.dao.mapper.engineering.bom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.engineering.bom.EngBom;
import cn.chiucheung.po.engineering.bom.EngBomExample;
import cn.chiucheung.pojo.engineering.bom.EngBomCustom;
import cn.chiucheung.pojo.engineering.bom.EngBomQueryVo;
import cn.chiucheung.pojo.engineering.bom.SalWorkCardItemCustomForEngBom;

public interface EngBomMapper {
    int countByExample(EngBomExample example);

    int deleteByExample(EngBomExample example);

    int deleteByPrimaryKey(String id);

    int insert(EngBom record);

    int insertSelective(EngBom record);

    List<EngBom> selectByExampleWithBLOBs(EngBomExample example);

    List<EngBom> selectByExample(EngBomExample example);

    EngBom selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EngBom record, @Param("example") EngBomExample example);

    int updateByExampleWithBLOBs(@Param("record") EngBom record, @Param("example") EngBomExample example);

    int updateByExample(@Param("record") EngBom record, @Param("example") EngBomExample example);

    int updateByPrimaryKeySelective(EngBom record);

    int updateByPrimaryKeyWithBLOBs(EngBom record);

    int updateByPrimaryKey(EngBom record);
    
	List<EngBom> findAllBomList(EngBomQueryVo bomQueryVo);

   	String findAllBomTotal(EngBomQueryVo bomQueryVo);

	List<SalWorkCardItemCustomForEngBom> findAllWorkCardSubsidiaryList(EngBomQueryVo bomQueryVo);

	String findAllWorkCardSubsidiaryTotal(EngBomQueryVo bomQueryVo);

	List<EngBom> findAllBomForMerge(EngBomQueryVo bomQueryVo);

	EngBomCustom findBomCustomById(String id);
}