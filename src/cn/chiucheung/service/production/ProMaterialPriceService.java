package cn.chiucheung.service.production;

import cn.chiucheung.po.production.material.ProMaterialGuidingPrice;
import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;

import java.util.List;
import java.util.Map;

public interface ProMaterialPriceService {

    /**
     * 新增物料价格
     * @param price 价格
     */
    Map<String, Object> insertPrice(ProMaterialGuidingPrice price);

    /**
     * 根据物料id获取价格
     * @param materialId 物料id
     */
    Map<String, Object> selectPriceByMaterialId(String materialId);

    /**
     * 根据物料id修改物料价格
     * @param price 物料价格信息(包括物料id)
     */
    Map<String, Object> updatePriceByMaterialId(ProMaterialGuidingPrice price);

    /**
     * 多条更新关联物料的价格
     * @param materialIdList 关于物料id的集合
     */
    Map<String, Object> updateStatue(String materialIdList);


    /**
     * 根据条件查找所有的物料
     * @param materialQueryVo 查询条件
     * @return
     */
    List<WarMaterial> findAllWarMaterialList(WarMaterialQueryVo materialQueryVo);

    /**
     * 根据条件查找所有的物料的记录总数
     * @param materialQueryVo 查询条件
     * @return
     */
    String findAllWarMaterialTotal(WarMaterialQueryVo materialQueryVo);
}
