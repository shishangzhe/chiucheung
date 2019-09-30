package cn.chiucheung.dao.mapper.sales.workcard;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.sales.workcard.SalWorkCardSubsidiary;
import cn.chiucheung.po.sales.workcard.SalWorkCardSubsidiaryExample;
import cn.chiucheung.pojo.engineering.datadistribution.WorkCardNoCustom;
import cn.chiucheung.pojo.engineering.datadistribution.WorkCardSubsidiaryCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardConfirmation;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardSubsidiaryCustom;

public interface SalWorkCardSubsidiaryMapper {
    int countByExample(SalWorkCardSubsidiaryExample example);

    int deleteByExample(SalWorkCardSubsidiaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardSubsidiary record);

    int insertSelective(SalWorkCardSubsidiary record);

    List<SalWorkCardSubsidiary> selectByExample(SalWorkCardSubsidiaryExample example);

    SalWorkCardSubsidiary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardSubsidiary record, @Param("example") SalWorkCardSubsidiaryExample example);

    int updateByExample(@Param("record") SalWorkCardSubsidiary record, @Param("example") SalWorkCardSubsidiaryExample example);

    int updateByPrimaryKeySelective(SalWorkCardSubsidiary record);

    int updateByPrimaryKey(SalWorkCardSubsidiary record);
    
    int insertList(List<SalWorkCardSubsidiary> workCardSubsidiaries);

	List<SalWorkCardSubsidiaryCustom> findAllSalWorkCardSubsidiaryListBySalWorkCardId(String id);

	SalWorkCardConfirmation findSalWorkCardSubsidiaryById(String id);

	List<WorkCardNoCustom> findAllWorkCardNo(WorkCardNoCustom workCardNoCustom);

	List<WorkCardSubsidiaryCustom> findAllWorkCardSubsidiary(String workCardNo);

	List<SalWorkCardSubsidiary> findRelationBomBySalWorkCardId(String id);
}