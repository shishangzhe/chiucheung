package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardJg5;
import cn.chiucheung.po.sales.workcard.SalWorkCardJg5Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalWorkCardJg5Mapper {
    int countByExample(SalWorkCardJg5Example example);

    int deleteByExample(SalWorkCardJg5Example example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardJg5 record);

    int insertSelective(SalWorkCardJg5 record);

    List<SalWorkCardJg5> selectByExample(SalWorkCardJg5Example example);

    SalWorkCardJg5 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardJg5 record, @Param("example") SalWorkCardJg5Example example);

    int updateByExample(@Param("record") SalWorkCardJg5 record, @Param("example") SalWorkCardJg5Example example);

    int updateByPrimaryKeySelective(SalWorkCardJg5 record);

    int updateByPrimaryKey(SalWorkCardJg5 record);
}