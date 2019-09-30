package cn.chiucheung.dao.mapper.market.costbudget;

import cn.chiucheung.po.market.costbudget.MarCostBudget;
import cn.chiucheung.po.market.costbudget.MarCostBudgetExample;
import cn.chiucheung.pojo.market.costbudget.MarCostBudgetCustom;
import cn.chiucheung.pojo.market.costbudget.MarCostBudgetVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MarCostBudgetMapper {
    int countByExample(MarCostBudgetExample example);

    int deleteByExample(MarCostBudgetExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarCostBudget record);

    int insertSelective(MarCostBudget record);

    List<MarCostBudget> selectByExampleWithBLOBs(MarCostBudgetExample example);

    List<MarCostBudget> selectByExample(MarCostBudgetExample example);

    MarCostBudget selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarCostBudget record, @Param("example") MarCostBudgetExample example);

    int updateByExampleWithBLOBs(@Param("record") MarCostBudget record, @Param("example") MarCostBudgetExample example);

    int updateByExample(@Param("record") MarCostBudget record, @Param("example") MarCostBudgetExample example);

    int updateByPrimaryKeySelective(MarCostBudget record);

    int updateByPrimaryKeyWithBLOBs(MarCostBudget record);

    int updateByPrimaryKey(MarCostBudget record);
    
    List<MarCostBudget> findAllCostBudgetList(MarCostBudgetVo costBudgetVo);

	String findAllCostBudgetTotal(MarCostBudgetVo costBudgetVo);

	List<MarCostBudgetCustom> findCxportingReportDatas(MarCostBudgetVo costBudgetVo);
	
	//取消关联，也就是将sal_reviewer_id设置为null
	int updateCostBudgetByIdForCancelAssociated(String id);
}