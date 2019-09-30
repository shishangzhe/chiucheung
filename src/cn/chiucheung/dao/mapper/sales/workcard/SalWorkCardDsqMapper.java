package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardDsq;
import cn.chiucheung.po.sales.workcard.SalWorkCardDsqExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardDsqWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalWorkCardDsqMapper {
    int countByExample(SalWorkCardDsqExample example);

    int deleteByExample(SalWorkCardDsqExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardDsqWithBLOBs record);

    int insertSelective(SalWorkCardDsqWithBLOBs record);

    List<SalWorkCardDsqWithBLOBs> selectByExampleWithBLOBs(SalWorkCardDsqExample example);

    List<SalWorkCardDsq> selectByExample(SalWorkCardDsqExample example);

    SalWorkCardDsqWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardDsqWithBLOBs record, @Param("example") SalWorkCardDsqExample example);

    int updateByExampleWithBLOBs(@Param("record") SalWorkCardDsqWithBLOBs record, @Param("example") SalWorkCardDsqExample example);

    int updateByExample(@Param("record") SalWorkCardDsq record, @Param("example") SalWorkCardDsqExample example);

    int updateByPrimaryKeySelective(SalWorkCardDsqWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SalWorkCardDsqWithBLOBs record);

    int updateByPrimaryKey(SalWorkCardDsq record);
}