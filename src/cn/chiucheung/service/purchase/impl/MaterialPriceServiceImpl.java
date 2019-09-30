package cn.chiucheung.service.purchase.impl;

import cn.chiucheung.dao.mapper.purchase.material.WarMaterialPriceMapper;
import cn.chiucheung.po.purchase.material.WarMaterialPrice;
import cn.chiucheung.po.purchase.material.WarMaterialPriceExample;
import cn.chiucheung.pojo.purchase.supplier.SupplierMaterialCustomer;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.service.purchase.MaterialPriceService;
import cn.chiucheung.utils.UUIDBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialPriceServiceImpl implements MaterialPriceService {

    @Autowired
    WarMaterialPriceMapper materialPriceMapper;

    @Override
    public Map<String, Object> insertPrice(WarMaterialPrice price){
        HashMap<String, Object> map = new HashMap<>();
        price.setId(UUIDBuild.getUUID());
        price.setAuditStatus("未审核");
        int i = materialPriceMapper.insertSelective(price);
        if (i > 0){
            map.put("success",true);
            map.put("message","操作成功");
        }else {
            map.put("success",false);
            map.put("message","操作失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> selectPriceByMaterialId(String materialId){
        HashMap<String, Object> map = new HashMap<>();
        WarMaterialPriceExample materialPriceExample = new WarMaterialPriceExample();
        materialPriceExample.createCriteria().andMaterialIdEqualTo(materialId);
        List<WarMaterialPrice> materialPrices = materialPriceMapper.selectByExample(materialPriceExample);
        if (materialPrices.size() > 0){
            map.put("success",true);
            map.put("materialPrices",materialPrices.get(0));
        }else {
            map.put("success",false);
            map.put("message","操作失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> updatePriceByMaterialId(WarMaterialPrice price){
        HashMap<String, Object> map = new HashMap<>();
        price.setAuditStatus("未审核");
        WarMaterialPriceExample materialPriceExample = new WarMaterialPriceExample();
        materialPriceExample.createCriteria().andMaterialIdEqualTo(price.getMaterialId());
        int i = materialPriceMapper.updateByExampleSelective(price, materialPriceExample);
        if (i > 0){
            map.put("success",true);
            map.put("message","操作成功");
        }else {
            map.put("success",false);
            map.put("message","操作失败");
        }
        return map;
    }


    @Override
    public Object selectPriceByStatue(WarMaterialQueryVo warMaterialQueryVo){
        List<SupplierMaterialCustomer> supplierMaterialCustomerList = materialPriceMapper.selectPriceByStatue(warMaterialQueryVo);
        return supplierMaterialCustomerList;
    }

    @Override
    public Map<String, Object> updateStatue(String materialIdList){
        HashMap<String, Object> map = new HashMap<>();
        List<WarMaterialPrice> materialPrices = new ArrayList<>();

        String[] materialIds = materialIdList.split(",");
        for (String materialId:materialIds) {
            WarMaterialPrice materialPrice = new WarMaterialPrice();
            materialPrice.setAuditStatus("审核");
            materialPrice.setMaterialId(materialId);
            materialPrices.add(materialPrice);
        }
        int i = materialPriceMapper.updateStatue(materialPrices);
        if (i > 0){
            map.put("success",true);
            map.put("message","操作成功");
        }else {
            map.put("success",false);
            map.put("message","操作失败");
        }
        return map;
    }



}
