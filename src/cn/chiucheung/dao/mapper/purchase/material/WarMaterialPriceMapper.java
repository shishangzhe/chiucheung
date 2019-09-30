package cn.chiucheung.dao.mapper.purchase.material;

import cn.chiucheung.po.purchase.material.WarMaterialPrice;
import cn.chiucheung.po.purchase.material.WarMaterialPriceExample;
import cn.chiucheung.pojo.purchase.supplier.SupplierMaterialCustomer;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarMaterialPriceMapper {
    int countByExample(WarMaterialPriceExample example);

    int deleteByExample(WarMaterialPriceExample example);

    int insert(WarMaterialPrice record);

    int insertSelective(WarMaterialPrice record);

    List<WarMaterialPrice> selectByExample(WarMaterialPriceExample example);

    int updateByExampleSelective(@Param("record") WarMaterialPrice record, @Param("example") WarMaterialPriceExample example);

    int updateByExample(@Param("record") WarMaterialPrice record, @Param("example") WarMaterialPriceExample example);

    List<SupplierMaterialCustomer> selectPriceByStatue(WarMaterialQueryVo warMaterialQueryVo);

    int updateStatue(List<WarMaterialPrice> list);
}