package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardJg6;
import cn.chiucheung.po.sales.workcard.SalWorkCardJg6Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalWorkCardJg6Mapper {
    int countByExample(SalWorkCardJg6Example example);

    int deleteByExample(SalWorkCardJg6Example example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardJg6 record);

    int insertSelective(SalWorkCardJg6 record);

    List<SalWorkCardJg6> selectByExampleWithBLOBs(SalWorkCardJg6Example example);

    List<SalWorkCardJg6> selectByExample(SalWorkCardJg6Example example);

    SalWorkCardJg6 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardJg6 record, @Param("example") SalWorkCardJg6Example example);

    int updateByExampleWithBLOBs(@Param("record") SalWorkCardJg6 record, @Param("example") SalWorkCardJg6Example example);

    int updateByExample(@Param("record") SalWorkCardJg6 record, @Param("example") SalWorkCardJg6Example example);

    int updateByPrimaryKeySelective(SalWorkCardJg6 record);

    int updateByPrimaryKeyWithBLOBs(SalWorkCardJg6 record);

    int updateByPrimaryKey(SalWorkCardJg6 record);
}