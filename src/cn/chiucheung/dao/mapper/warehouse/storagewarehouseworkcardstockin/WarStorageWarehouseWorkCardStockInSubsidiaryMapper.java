package cn.chiucheung.dao.mapper.warehouse.storagewarehouseworkcardstockin;

import cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInSubsidiary;
import cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInSubsidiaryExample;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInSubsidiaryCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WarStorageWarehouseWorkCardStockInSubsidiaryMapper {
    int countByExample(WarStorageWarehouseWorkCardStockInSubsidiaryExample example);

    int deleteByExample(WarStorageWarehouseWorkCardStockInSubsidiaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarStorageWarehouseWorkCardStockInSubsidiary record);

    int insertSelective(WarStorageWarehouseWorkCardStockInSubsidiary record);

    List<WarStorageWarehouseWorkCardStockInSubsidiary> selectByExample(WarStorageWarehouseWorkCardStockInSubsidiaryExample example);

    WarStorageWarehouseWorkCardStockInSubsidiary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarStorageWarehouseWorkCardStockInSubsidiary record, @Param("example") WarStorageWarehouseWorkCardStockInSubsidiaryExample example);

    int updateByExample(@Param("record") WarStorageWarehouseWorkCardStockInSubsidiary record, @Param("example") WarStorageWarehouseWorkCardStockInSubsidiaryExample example);

    int updateByPrimaryKeySelective(WarStorageWarehouseWorkCardStockInSubsidiary record);

    int updateByPrimaryKey(WarStorageWarehouseWorkCardStockInSubsidiary record);
    
    int insertList(List<WarStorageWarehouseWorkCardStockInSubsidiary> storageWarehouseWorkCardStockInSubsidiaries);


	List<WarStorageWarehouseWorkCardStockInSubsidiaryCustom> findAllWarStorageWarehouseWorkCardStockInSubsidiaryListByWarStorageWarehouseWorkCardStockInId(String warStorageWarehouseWorkCardStockInId);
	
	/**
	 * 根据存仓工咭的子项id计算存仓工咭和入库单的差异（用于新增、修改入库单时，入库的数量不能大于存仓工咭的子项）
	 * @param proStorageWarehouseWorkCardSubsidiaryId
	 * @return
	 */
	int calculateWarStorageWarehouseWorkCardStockInSubsidiaryDifferencesByProStorageWarehouseWorkCardSubsidiaryId(@Param("proStorageWarehouseWorkCardSubsidiaryId") String proStorageWarehouseWorkCardSubsidiaryId, @Param("warStorageWarehouseWorkCardStockInId") String warStorageWarehouseWorkCardStockInId);
}