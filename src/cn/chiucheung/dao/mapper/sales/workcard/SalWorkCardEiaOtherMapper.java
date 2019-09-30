package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardEiaOther;
import cn.chiucheung.po.sales.workcard.SalWorkCardEiaOtherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalWorkCardEiaOtherMapper {
    int countByExample(SalWorkCardEiaOtherExample example);

    int deleteByExample(SalWorkCardEiaOtherExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardEiaOther record);

    int insertSelective(SalWorkCardEiaOther record);

    List<SalWorkCardEiaOther> selectByExample(SalWorkCardEiaOtherExample example);

    SalWorkCardEiaOther selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardEiaOther record, @Param("example") SalWorkCardEiaOtherExample example);

    int updateByExample(@Param("record") SalWorkCardEiaOther record, @Param("example") SalWorkCardEiaOtherExample example);

    int updateByPrimaryKeySelective(SalWorkCardEiaOther record);

    int updateByPrimaryKey(SalWorkCardEiaOther record);

	int insertList(List<SalWorkCardEiaOther> workCardEiaOthers);
}