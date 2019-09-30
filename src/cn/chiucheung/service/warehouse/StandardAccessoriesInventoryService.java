package cn.chiucheung.service.warehouse;

import java.util.List;

import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesInventoryCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;

public interface StandardAccessoriesInventoryService {
	
	/**
	 * 查找所有的标准配件库存
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	List<WarStandardAccessoriesInventoryCustom> findAllWarStandardAccessoriesInventoryList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);

	String findAllWarStandardAccessoriesInventoryTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);

}
