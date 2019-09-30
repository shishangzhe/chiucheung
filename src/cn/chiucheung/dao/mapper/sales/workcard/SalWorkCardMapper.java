package cn.chiucheung.dao.mapper.sales.workcard;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.sales.workcard.SalWorkCard;
import cn.chiucheung.po.sales.workcard.SalWorkCardExample;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardQueryVo;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardShowDataCustom;

public interface SalWorkCardMapper {
    int countByExample(SalWorkCardExample example);

    int deleteByExample(SalWorkCardExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCard record);

    int insertSelective(SalWorkCard record);

    List<SalWorkCard> selectByExampleWithBLOBs(SalWorkCardExample example);

    List<SalWorkCard> selectByExample(SalWorkCardExample example);

    SalWorkCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCard record, @Param("example") SalWorkCardExample example);

    int updateByExampleWithBLOBs(@Param("record") SalWorkCard record, @Param("example") SalWorkCardExample example);

    int updateByExample(@Param("record") SalWorkCard record, @Param("example") SalWorkCardExample example);

    int updateByPrimaryKeySelective(SalWorkCard record);

    int updateByPrimaryKeyWithBLOBs(SalWorkCard record);

    int updateByPrimaryKey(SalWorkCard record);
    
    List<SalWorkCardShowDataCustom> findAllWorkCardList(SalWorkCardQueryVo workCardQueryVo);

	String findAllWorkCardListTotal(SalWorkCardQueryVo workCardQueryVo);
}