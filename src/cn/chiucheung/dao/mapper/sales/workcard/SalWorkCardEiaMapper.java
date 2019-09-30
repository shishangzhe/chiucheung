package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardEia;
import cn.chiucheung.po.sales.workcard.SalWorkCardEiaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalWorkCardEiaMapper {
    int countByExample(SalWorkCardEiaExample example);

    int deleteByExample(SalWorkCardEiaExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardEia record);

    int insertSelective(SalWorkCardEia record);

    List<SalWorkCardEia> selectByExampleWithBLOBs(SalWorkCardEiaExample example);

    List<SalWorkCardEia> selectByExample(SalWorkCardEiaExample example);

    SalWorkCardEia selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardEia record, @Param("example") SalWorkCardEiaExample example);

    int updateByExampleWithBLOBs(@Param("record") SalWorkCardEia record, @Param("example") SalWorkCardEiaExample example);

    int updateByExample(@Param("record") SalWorkCardEia record, @Param("example") SalWorkCardEiaExample example);

    int updateByPrimaryKeySelective(SalWorkCardEia record);

    int updateByPrimaryKeyWithBLOBs(SalWorkCardEia record);

    int updateByPrimaryKey(SalWorkCardEia record);
}