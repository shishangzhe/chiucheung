package cn.chiucheung.dao.mapper.engineering.bom;

import cn.chiucheung.po.engineering.bom.EngBomSubsidiary;
import cn.chiucheung.po.engineering.bom.EngBomSubsidiaryExample;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EngBomSubsidiaryMapper {
    int countByExample(EngBomSubsidiaryExample example);

    int deleteByExample(EngBomSubsidiaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(EngBomSubsidiary record);

    int insertSelective(EngBomSubsidiary record);

    List<EngBomSubsidiary> selectByExample(EngBomSubsidiaryExample example);

    EngBomSubsidiary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EngBomSubsidiary record, @Param("example") EngBomSubsidiaryExample example);

    int updateByExample(@Param("record") EngBomSubsidiary record, @Param("example") EngBomSubsidiaryExample example);

    int updateByPrimaryKeySelective(EngBomSubsidiary record);

    int updateByPrimaryKey(EngBomSubsidiary record);

	List<EngBomSubsidiary> findAllEngBomSubsidiaryList(EngBomSubsidiary bomSubsidiaryQueryVo);
}