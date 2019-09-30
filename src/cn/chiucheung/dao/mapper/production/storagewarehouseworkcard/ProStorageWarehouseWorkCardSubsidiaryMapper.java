package cn.chiucheung.dao.mapper.production.storagewarehouseworkcard;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiary;
import cn.chiucheung.po.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiaryExample;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiaryShowDataCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.ProStorageWarehouseWorkCardSubsidiaryCustom;

public interface ProStorageWarehouseWorkCardSubsidiaryMapper {
    int countByExample(ProStorageWarehouseWorkCardSubsidiaryExample example);

    int deleteByExample(ProStorageWarehouseWorkCardSubsidiaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProStorageWarehouseWorkCardSubsidiary record);

    int insertSelective(ProStorageWarehouseWorkCardSubsidiary record);

    List<ProStorageWarehouseWorkCardSubsidiary> selectByExample(ProStorageWarehouseWorkCardSubsidiaryExample example);

    ProStorageWarehouseWorkCardSubsidiary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProStorageWarehouseWorkCardSubsidiary record, @Param("example") ProStorageWarehouseWorkCardSubsidiaryExample example);

    int updateByExample(@Param("record") ProStorageWarehouseWorkCardSubsidiary record, @Param("example") ProStorageWarehouseWorkCardSubsidiaryExample example);

    int updateByPrimaryKeySelective(ProStorageWarehouseWorkCardSubsidiary record);

    int updateByPrimaryKey(ProStorageWarehouseWorkCardSubsidiary record);

    int insertList(List<ProStorageWarehouseWorkCardSubsidiary> storageWarehouseWorkCardSubsidiaries);

	List<ProStorageWarehouseWorkCardSubsidiaryShowDataCustom> findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId(String proStorageWarehouseWorkCardQueryId);

	List<ProStorageWarehouseWorkCardSubsidiaryCustom> findAllCompleteStorageWarehouseWorkCardSubsidiaryList(WarMaterialQueryVo materialQueryVo);

	String findAllCompleteStorageWarehouseWorkCardSubsidiaryTotal(WarMaterialQueryVo materialQueryVo);
}