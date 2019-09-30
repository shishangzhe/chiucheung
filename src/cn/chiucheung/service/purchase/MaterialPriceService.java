package cn.chiucheung.service.purchase;

import cn.chiucheung.po.purchase.material.WarMaterialPrice;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;

import java.util.List;
import java.util.Map;

public interface MaterialPriceService {

    /**
     * 新增物料价格
     * @param price 价格
     */
    Map<String, Object> insertPrice(WarMaterialPrice price);

    /**
     * 根据物料id获取价格
     * @param materialId 物料id
     */
    Map<String, Object> selectPriceByMaterialId(String materialId);

    /**
     * 根据物料id修改物料价格
     * @param price 物料价格信息(包括物料id)
     */
    Map<String, Object> updatePriceByMaterialId(WarMaterialPrice price);

    /**
     * 查询关联价格的物料
     * @param warMaterialQueryVo 查询条件
     */
    Object selectPriceByStatue(WarMaterialQueryVo warMaterialQueryVo);

    /**
     * 多条更新关联物料的价格
     * @param materialIdList 关于物料id的集合
     */
    Map<String, Object> updateStatue(String materialIdList);

}
