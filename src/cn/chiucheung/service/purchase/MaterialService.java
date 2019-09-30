package cn.chiucheung.service.purchase;

import java.util.List;

import cn.chiucheung.po.purchase.material.PurMaterial;
import cn.chiucheung.pojo.purchase.material.PurMaterialQueryVo;

public interface MaterialService {

	/**
	 * 查找所有的物料
	 * @param materialQueryVo 查询条件
	 * @return
	 */
	List<PurMaterial> findAllPurMaterialList(PurMaterialQueryVo materialQueryVo);
	
	/**
	 * 查询记录条数
	 * @param materialQueryVo 查询条件
	 * @return
	 */
	String findAllPurMaterialTotal(PurMaterialQueryVo materialQueryVo);
	
	/**
	 * 新增物料
	 * @param material
	 * @return
	 */
	int savePurMaterial(PurMaterial material);
	
	/**
	 * 根据id查询 PurMaterial
	 * @param id
	 * @return
	 */
	PurMaterial findPurMaterialById(String id);
	
	/**
	 * 更新物料
	 * @param material
	 * @return
	 */
	int updatePurMaterial(PurMaterial material);
	
	/**
	 * 根据id删除物料
	 * @param id
	 * @return
	 */
	int deletePurMaterialById(String id);


}
