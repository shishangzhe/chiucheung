package cn.chiucheung.service.production;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.chiucheung.pojo.production.producttechnologyflowchart.ProProductTechnologyFlowChartCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProCalculateProcessTimesCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyProcessWorkHoursCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyWorkHoursCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;

public interface ProductTechnologyWorkHoursService {
	
	/**
	 * 查询所有的产品工艺工时
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyWorkHoursList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);
	
	/**
	 * 查询所有的产品工艺工时的总记录数
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	String findAllProductTechnologyWorkHoursTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);
	
	/**
	 * 根据产品工艺工时的id查询子节点加载的数据
	 * @param id
	 * @return
	 */
	List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyWorkHoursSubsidiaryListById(String id);
	
	/**
	 * 根据产品工艺工时的关联的配件工艺工时查询子节点下加载的数据
	 * @param id
	 * @return
	 */
	List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyWorkHoursSubsidiaryListByProProductTechnologyAccessoriesWorkHoursId(String id);
	
	/**
	 * 查询所有未关联的标准配件
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	List<ProProductTechnologyWorkHoursCustom> findAllWarStandardAccessoriesForIsAssociatedList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);
	
	/**
	 * 查询所有未关联的标准配件的总数
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	String findAllWarStandardAccessoriesForIsAssociatedTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);
	
	/**
	 * 保存产品工艺工时
	 * @param productTechnologyWorkHoursCustom
	 * @return
	 */
	int saveProductTechnologyWorkHours(HashMap<String, Object> map) throws Exception;
	
	/**
	 * 根据id查找产品工艺工时，用于页面修改
	 * @param id
	 * @return
	 */
	Map<String, Object> findProductTechnologyWorkHoursById(String id);
	
	/**
	 * 更新产品工艺工时
	 * @param updateProductTechnologyWorkHours
	 * @return
	 */
	int updateProductTechnologyWorkHours(HashMap<String, Object> map);
	
	/**
	 * 根据id删除产品工艺工时
	 * @param id
	 * @return
	 */
	int deleteProductTechnologyWorkHoursById(String id);
	
	/**
	 * 根据id获取所有的工序工时
	 * @param id
	 * @return
	 */
	List<ProCalculateProcessTimesCustom> getAllProcessToalTimes(String id);
	
	/**
	 * 根据ProProductTechlogyWorkHoursId查找工艺流程图
	 * @param id
	 * @return
	 */
	ProProductTechnologyFlowChartCustom findProductTechnologyProcessFlowChartCustomByProProductTechlogyWorkHoursId(String id);
	
	/**
	 * 保存工艺流程图形
	 * @param map
	 * @return
	 */
	int saveTechnologyProcessFlowChart(HashMap<String, Object> map);
	
	/**
	 * 更新所有的产品工艺工时
	 * @return
	 */
	int updateAllProductTechnologyWorkHours();
	
	/**
	 * 按工序计算该产品的所有工时
	 * @param id
	 */
	List<ProCalculateProcessTimesCustom> calculateProcessTimes(String id);
	
	/**
	 * 导出Excel
	 * @param id
	 * @return
	 */
	List<List<String>> exportExcelById(String id, BigDecimal divisor);


}
