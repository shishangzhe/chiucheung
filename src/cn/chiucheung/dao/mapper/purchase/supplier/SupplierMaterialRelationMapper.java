package cn.chiucheung.dao.mapper.purchase.supplier;

import cn.chiucheung.po.purchase.supplier.SupplierMaterialRelation;
import cn.chiucheung.po.purchase.supplier.SupplierMaterialRelationExample;
import cn.chiucheung.pojo.purchase.supplier.SupplierMaterialCustomer;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMaterialRelationMapper {
    int countByExample(SupplierMaterialRelationExample example);

    int deleteByExample(SupplierMaterialRelationExample example);

    int insert(SupplierMaterialRelation record);

    int insertSelective(SupplierMaterialRelation record);

    List<SupplierMaterialRelation> selectByExample(SupplierMaterialRelationExample example);

    int updateByExampleSelective(@Param("record") SupplierMaterialRelation record, @Param("example") SupplierMaterialRelationExample example);

    int updateByExample(@Param("record") SupplierMaterialRelation record, @Param("example") SupplierMaterialRelationExample example);

    List<SupplierMaterialCustomer> selectInfoBySupplierId(WarMaterialQueryVo materialQueryVo);

    String selectCountBySupplierId(WarMaterialQueryVo materialQueryVo);

    int insertListInfo(List<SupplierMaterialRelation> supplierMaterialRelationList);
}