package cn.chiucheung.service.production.impl;

import cn.chiucheung.dao.mapper.production.material.ProMaterialGuidingPriceMapper;
import cn.chiucheung.po.production.material.ProMaterialGuidingPrice;
import cn.chiucheung.po.production.material.ProMaterialGuidingPriceExample;
import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.service.production.ProMaterialPriceService;
import cn.chiucheung.utils.UUIDBuild;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProMaterialPriceServiceImpl implements ProMaterialPriceService {

    @Autowired
    ProMaterialGuidingPriceMapper materialGuidingPriceMapper;

    @Override
    public Map<String, Object> insertPrice(ProMaterialGuidingPrice price){
        HashMap<String, Object> map = new HashMap<>();
        price.setId(UUIDBuild.getUUID());
        price.setAuditStatus("未审核");
        int i = materialGuidingPriceMapper.insertSelective(price);
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
        ProMaterialGuidingPriceExample materialPriceExample = new ProMaterialGuidingPriceExample();
        materialPriceExample.createCriteria().andMaterialIdEqualTo(materialId);
        List<ProMaterialGuidingPrice> materialPrices = materialGuidingPriceMapper.selectByExample(materialPriceExample);
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
    public Map<String, Object> updatePriceByMaterialId(ProMaterialGuidingPrice price){
        HashMap<String, Object> map = new HashMap<>();
        price.setAuditStatus("未审核");
        ProMaterialGuidingPriceExample materialPriceExample = new ProMaterialGuidingPriceExample();
        materialPriceExample.createCriteria().andMaterialIdEqualTo(price.getMaterialId());
        int i = materialGuidingPriceMapper.updateByExampleSelective(price, materialPriceExample);
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
    public Map<String, Object> updateStatue(String materialIdList){
        HashMap<String, Object> map = new HashMap<>();
        List<ProMaterialGuidingPrice> materialPrices = new ArrayList<>();

        String[] materialIds = materialIdList.split(",");
        for (String materialId:materialIds) {
            ProMaterialGuidingPrice materialPrice = new ProMaterialGuidingPrice();
            materialPrice.setAuditStatus("审核");
            materialPrice.setMaterialId(materialId);
            materialPrices.add(materialPrice);
        }
        int i = materialGuidingPriceMapper.updateStatue(materialPrices);
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
    public List<WarMaterial> findAllWarMaterialList(WarMaterialQueryVo materialQueryVo) {
        if (materialQueryVo.getIsQuery()){//使用高级搜索的时候，则不以树形菜单展示
            return materialGuidingPriceMapper.findAllWarMaterialList(materialQueryVo);
        }else{
            if (StringUtils.isNotBlank(materialQueryVo.getMaterialCodeForExpand())){//用于展开的查询
                return materialGuidingPriceMapper.findAllWarMaterialList(materialQueryVo);
            }else{
                materialQueryVo.setState("closed");
                List<WarMaterial> materials = materialGuidingPriceMapper.findAllWarMaterialList(materialQueryVo);
                if (materials != null && materials.size() >0){
                    for (WarMaterial material : materials) {
                        material.setChildren(findAllMaterialSubsidiaryList(material, materialQueryVo));
                    }
                }
                return materials;
            }
        }
    }

    private List<WarMaterial> findAllMaterialSubsidiaryList(WarMaterial material2, WarMaterialQueryVo materialQueryVo){
        materialQueryVo.setMaterialCodeForExpand(material2.getMaterialCode());
        materialQueryVo.setLevel(material2.getMaterialCode().length() - material2.getMaterialCode().replace(".", "").length() + 1);
        List<WarMaterial> materials = materialGuidingPriceMapper.findAllWarMaterialList(materialQueryVo);
        if (materials != null && materials.size() >0){
            for (WarMaterial material : materials) {
                material.setChildren(findAllMaterialSubsidiaryList(material, materialQueryVo));
            }
        }
        return materials;
    }

    @Override
    public String findAllWarMaterialTotal(WarMaterialQueryVo materialQueryVo) {
        return materialGuidingPriceMapper.findAllWarMaterialTotal(materialQueryVo);
    }

}
