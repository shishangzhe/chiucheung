package cn.chiucheung.dao.mapper.engineering.standardbom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.engineering.standardbom.EngStandardBomSubsidiary;
import cn.chiucheung.po.engineering.standardbom.EngStandardBomSubsidiaryExample;
import cn.chiucheung.pojo.engineering.standardBom.EngStandardBomCustom;

public interface EngStandardBomSubsidiaryMapper {
    int countByExample(EngStandardBomSubsidiaryExample example);

    int deleteByExample(EngStandardBomSubsidiaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(EngStandardBomSubsidiary record);

    int insertSelective(EngStandardBomSubsidiary record);

    List<EngStandardBomSubsidiary> selectByExample(EngStandardBomSubsidiaryExample example);

    EngStandardBomSubsidiary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EngStandardBomSubsidiary record, @Param("example") EngStandardBomSubsidiaryExample example);

    int updateByExample(@Param("record") EngStandardBomSubsidiary record, @Param("example") EngStandardBomSubsidiaryExample example);

    int updateByPrimaryKeySelective(EngStandardBomSubsidiary record);

    int updateByPrimaryKey(EngStandardBomSubsidiary record);
    
	int insertList(List<EngStandardBomSubsidiary> standardBomSubsidiaries);
    
    List<EngStandardBomCustom> findAllStandardBomSubsidiaryList(@Param("engStandardBomId") String engStandardBomId, @Param("materialCode") String materialCode);
}