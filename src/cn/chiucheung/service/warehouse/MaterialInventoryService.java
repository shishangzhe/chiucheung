package cn.chiucheung.service.warehouse;

import java.util.List;

import cn.chiucheung.pojo.warehouse.material.WarMaterialInventoryCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;

public interface MaterialInventoryService {
	
	/**
	 * 查询所有物料的库存
	 * @param materialQueryVo
	 * @return
	 */
	List<WarMaterialInventoryCustom> findAllWarMaterialInventoryList(WarMaterialQueryVo materialQueryVo);

	/**
	 * 查询所有物料库存的记录总数
	 * @param materialQueryVo
	 * @return
	 */
	String findAllWarMaterialInventoryTotal(WarMaterialQueryVo materialQueryVo);

}
