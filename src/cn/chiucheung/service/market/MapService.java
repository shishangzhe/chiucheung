package cn.chiucheung.service.market;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.chiucheung.pojo.market.map.ProjectInfoIndustryCount;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoQueryVo;

public interface MapService {

	/**
	 * 获取世界每个国家的项目总和,该数据的name和engName对调
	 * @return
	 */
	Map<String, Object> getMapData(String parent, BigDecimal[] chiaLli, String linesCoreName);

	List<ProjectInfoIndustryCount> findProjectInfoIndustryCount(SalProjectInfoQueryVo projectInfoQueryVo);
}
