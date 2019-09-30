package cn.chiucheung.dao.mapper.purchase.supplier;

import cn.chiucheung.po.purchase.supplier.PurSupplierFile;
import cn.chiucheung.po.purchase.supplier.PurSupplierFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurSupplierFileMapper {
    int countByExample(PurSupplierFileExample example);

    int deleteByExample(PurSupplierFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurSupplierFile record);

    int insertSelective(PurSupplierFile record);

    List<PurSupplierFile> selectByExample(PurSupplierFileExample example);

    PurSupplierFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurSupplierFile record, @Param("example") PurSupplierFileExample example);

    int updateByExample(@Param("record") PurSupplierFile record, @Param("example") PurSupplierFileExample example);

    int updateByPrimaryKeySelective(PurSupplierFile record);

    int updateByPrimaryKey(PurSupplierFile record);

    int insertSupplierFileList(List<PurSupplierFile> purSupplierFiles);
}