package cn.chiucheung.dao.mapper.sales.workcard;

import cn.chiucheung.po.sales.workcard.SalWorkCardDsqOther;
import cn.chiucheung.po.sales.workcard.SalWorkCardDsqOtherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalWorkCardDsqOtherMapper {
    int countByExample(SalWorkCardDsqOtherExample example);

    int deleteByExample(SalWorkCardDsqOtherExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalWorkCardDsqOther record);

    int insertSelective(SalWorkCardDsqOther record);

    List<SalWorkCardDsqOther> selectByExample(SalWorkCardDsqOtherExample example);

    SalWorkCardDsqOther selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalWorkCardDsqOther record, @Param("example") SalWorkCardDsqOtherExample example);

    int updateByExample(@Param("record") SalWorkCardDsqOther record, @Param("example") SalWorkCardDsqOtherExample example);

    int updateByPrimaryKeySelective(SalWorkCardDsqOther record);

    int updateByPrimaryKey(SalWorkCardDsqOther record);

	int insertList(List<SalWorkCardDsqOther> workCardDsqOthers);
}