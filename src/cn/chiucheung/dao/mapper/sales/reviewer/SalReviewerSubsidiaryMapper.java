package cn.chiucheung.dao.mapper.sales.reviewer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.sales.reviewer.SalReviewerSubsidiary;
import cn.chiucheung.po.sales.reviewer.SalReviewerSubsidiaryExample;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerCustom;

public interface SalReviewerSubsidiaryMapper {
    int countByExample(SalReviewerSubsidiaryExample example);

    int deleteByExample(SalReviewerSubsidiaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalReviewerSubsidiary record);

    int insertSelective(SalReviewerSubsidiary record);

    List<SalReviewerSubsidiary> selectByExample(SalReviewerSubsidiaryExample example);

    SalReviewerSubsidiary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalReviewerSubsidiary record, @Param("example") SalReviewerSubsidiaryExample example);

    int updateByExample(@Param("record") SalReviewerSubsidiary record, @Param("example") SalReviewerSubsidiaryExample example);

    int updateByPrimaryKeySelective(SalReviewerSubsidiary record);

    int updateByPrimaryKey(SalReviewerSubsidiary record);

	List<SalReviewerCustom> findAllSalReviewerSubsidiaryListBySalReviewerId(String id);
}