package cn.chiucheung.service.market;

import java.util.List;
import java.util.Map;

import cn.chiucheung.po.market.costbudget.MarCostBudget;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.pojo.market.costbudget.MarCostBudgetCustom;
import cn.chiucheung.pojo.market.costbudget.MarCostBudgetVo;

public interface CostBudgetService {
	/**
	 * 保存页面提交的json数据
	 * @param map
	 * @return 
	 */
	int saveCostBudget(Map<String, Object> map);
	
	/**
	 * 根据salReviewerId查找CostBudget,用于在成本核算汇总界面，点击成本核算汇总的每条记录，显示出对应的成本分析表，而且只显示提交日期不为空的
	 * @param salReviewerId
	 * @param privileges 权限列表，含有编辑权限，则可以查看到未提交的成本核算表,否则只能查看提交了的成本核算表
	 * @return
	 */
	List<MarCostBudget> findCostBudgetListBySalReviewerId(String salReviewerId, List<Privilege> privileges);
	

	/**
	 * 根据id查找CoistBudget，用于前台数据的查看
	 * @param id
	 * @return
	 */
	Map<String, Object> findCostBudgetByIdForView(String id);
	
	/**
	 * 根据id查找CoistBudget，用于前台数据的编辑
	 * @param id
	 * @return
	 */
	Map<String, Object> findCostBudgetById(String id);
	
	/**
	 * 更新页面提交的json数据
	 * @param map
	 * @return 
	 */
	int updateCostBudget(Map<String, Object> map);

	/**
	 * 根据id删除CostBudget
	 * @param id
	 * @return
	 */
	int deleteCostBudgetById(String id);

	/**
	 * 根据成本核算表的id关联项目评审表
	 * @param id成本核算表的id
	 * @param salReviewerId 项目评审表的id
	 * @return
	 */
	int updateCostBudgetByIdForAssociated(String id, String salReviewerId);
	
	/**
	 * 根据成本核算表的id取消成本核算表和项目评审表的关联
	 * @param id
	 * @return
	 */
	int updateCostBudgetByIdForCancelAssociated(String id);
	
	/**
	 * 查找所有的成本核算表
	 * @param costBudgetVo查询条件
	 * @return
	 */
	Map<String, Object> findAllCostBudgetList(MarCostBudgetVo costBudgetVo);
	
	/**
	 * 根据id查找成本核算表，用于判断当前是否关联项目评审表
	 * @param id
	 * @return
	 */
	MarCostBudget findCostBudgetByIdForAssociated(String id);
	
	/**
	 * 根据查询条件，查找需要导出报表的数据
	 * @param costBudgetVo
	 * @return
	 */
	List<MarCostBudgetCustom> findCxportingReportDatas(MarCostBudgetVo costBudgetVo);
	
	/**
	 * 根据id查找数据，用于页面复制数据
	 * @param id 
	 * @param flag 为true则更新数据，为false则不更新数据
	 * @return
	 */
	Map<String, Object> findCostBudgetByIdForCopyData(String id, Boolean flag);

}
