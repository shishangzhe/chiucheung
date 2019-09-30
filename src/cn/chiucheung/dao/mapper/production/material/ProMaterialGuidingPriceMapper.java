package cn.chiucheung.dao.mapper.production.material;

import cn.chiucheung.po.production.material.ProMaterialGuidingPrice;
import cn.chiucheung.po.production.material.ProMaterialGuidingPriceExample;
import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.pojo.purchase.supplier.SupplierMaterialCustomer;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProMaterialGuidingPriceMapper {
    int countByExample(ProMaterialGuidingPriceExample example);

    int deleteByExample(ProMaterialGuidingPriceExample example);

    int insert(ProMaterialGuidingPrice record);

    int insertSelective(ProMaterialGuidingPrice record);

    List<ProMaterialGuidingPrice> selectByExample(ProMaterialGuidingPriceExample example);

    int updateByExampleSelective(@Param("record") ProMaterialGuidingPrice record, @Param("example") ProMaterialGuidingPriceExample example);

    int updateByExample(@Param("record") ProMaterialGuidingPrice record, @Param("example") ProMaterialGuidingPriceExample example);

    int updateStatue(List<ProMaterialGuidingPrice> list);

    List<WarMaterial> findAllWarMaterialList(WarMaterialQueryVo materialQueryVo);

    String findAllWarMaterialTotal(WarMaterialQueryVo materialQueryVo);
}