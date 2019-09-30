package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardKzt;
import cn.chiucheung.po.sales.workcard.SalWorkCardKztExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardKztWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalWorkCardKztMapper {
    int countByExample(SalWorkCardKztExample example);

    int deleteByExample(SalWorkCardKztExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardKztWithBLOBs record);

    int insertSelective(SalWorkCardKztWithBLOBs record);

    List<SalWorkCardKztWithBLOBs> selectByExampleWithBLOBs(SalWorkCardKztExample example);

    List<SalWorkCardKzt> selectByExample(SalWorkCardKztExample example);

    SalWorkCardKztWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardKztWithBLOBs record, @Param("example") SalWorkCardKztExample example);

    int updateByExampleWithBLOBs(@Param("record") SalWorkCardKztWithBLOBs record, @Param("example") SalWorkCardKztExample example);

    int updateByExample(@Param("record") SalWorkCardKzt record, @Param("example") SalWorkCardKztExample example);

    int updateByPrimaryKeySelective(SalWorkCardKztWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SalWorkCardKztWithBLOBs record);

    int updateByPrimaryKey(SalWorkCardKzt record);
}