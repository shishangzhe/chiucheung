package cn.chiucheung.dao.mapper.market.costbudget;

import cn.chiucheung.po.market.costbudget.MarCostBudgetMaterial;
import cn.chiucheung.po.market.costbudget.MarCostBudgetMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarCostBudgetMaterialMapper {
    int countByExample(MarCostBudgetMaterialExample example);

    int deleteByExample(MarCostBudgetMaterialExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarCostBudgetMaterial record);

    int insertSelective(MarCostBudgetMaterial record);

    List<MarCostBudgetMaterial> selectByExample(MarCostBudgetMaterialExample example);

    MarCostBudgetMaterial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarCostBudgetMaterial record, @Param("example") MarCostBudgetMaterialExample example);

    int updateByExample(@Param("record") MarCostBudgetMaterial record, @Param("example") MarCostBudgetMaterialExample example);

    int updateByPrimaryKeySelective(MarCostBudgetMaterial record);

    int updateByPrimaryKey(MarCostBudgetMaterial record);
    
    int insertList(List<MarCostBudgetMaterial> marCostBudgetMaterials);
}