package cn.chiucheung.dao.mapper.purchase.supplier;

import cn.chiucheung.po.purchase.supplier.PurSupplier;
import cn.chiucheung.po.purchase.supplier.PurSupplierExample;
import cn.chiucheung.pojo.purchase.supplier.PurSupplierCustomer;
import cn.chiucheung.pojo.purchase.supplier.PurSupplierQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurSupplierMapper {
    int countByExample(PurSupplierExample example);

    int deleteByExample(PurSupplierExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurSupplier record);

    int insertSelective(PurSupplier record);

    List<PurSupplier> selectByExample(PurSupplierExample example);

    PurSupplier selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurSupplier record, @Param("example") PurSupplierExample example);

    int updateByExample(@Param("record") PurSupplier record, @Param("example") PurSupplierExample example);

    int updateByPrimaryKeySelective(PurSupplier record);

    int updateByPrimaryKey(PurSupplier record);

    List<PurSupplierCustomer> selectSupplierList(PurSupplierQueryVo purSupplierQueryVo);

    String selectSupplierCount(PurSupplierQueryVo purSupplierQueryVo);
}