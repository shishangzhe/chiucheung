package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardKztOther;
import cn.chiucheung.po.sales.workcard.SalWorkCardKztOtherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalWorkCardKztOtherMapper {
    int countByExample(SalWorkCardKztOtherExample example);

    int deleteByExample(SalWorkCardKztOtherExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardKztOther record);

    int insertSelective(SalWorkCardKztOther record);

    List<SalWorkCardKztOther> selectByExample(SalWorkCardKztOtherExample example);

    SalWorkCardKztOther selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardKztOther record, @Param("example") SalWorkCardKztOtherExample example);

    int updateByExample(@Param("record") SalWorkCardKztOther record, @Param("example") SalWorkCardKztOtherExample example);

    int updateByPrimaryKeySelective(SalWorkCardKztOther record);

    int updateByPrimaryKey(SalWorkCardKztOther record);

	int insertList(List<SalWorkCardKztOther> workCardKztOthers);
}