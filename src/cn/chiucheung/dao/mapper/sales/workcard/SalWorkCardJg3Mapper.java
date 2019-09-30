package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardJg3;
import cn.chiucheung.po.sales.workcard.SalWorkCardJg3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalWorkCardJg3Mapper {
    int countByExample(SalWorkCardJg3Example example);

    int deleteByExample(SalWorkCardJg3Example example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardJg3 record);

    int insertSelective(SalWorkCardJg3 record);

    List<SalWorkCardJg3> selectByExample(SalWorkCardJg3Example example);

    SalWorkCardJg3 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardJg3 record, @Param("example") SalWorkCardJg3Example example);

    int updateByExample(@Param("record") SalWorkCardJg3 record, @Param("example") SalWorkCardJg3Example example);

    int updateByPrimaryKeySelective(SalWorkCardJg3 record);

    int updateByPrimaryKey(SalWorkCardJg3 record);
}