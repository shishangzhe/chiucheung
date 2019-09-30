package cn.chiucheung.dao.mapper.warehouse.storagewarehouseworkcardstockin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockIn;
import cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInExample;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.Quantity;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInQueryVo;

public interface WarStorageWarehouseWorkCardStockInMapper {
    int countByExample(WarStorageWarehouseWorkCardStockInExample example);

    int deleteByExample(WarStorageWarehouseWorkCardStockInExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarStorageWarehouseWorkCardStockIn record);

    int insertSelective(WarStorageWarehouseWorkCardStockIn record);

    List<WarStorageWarehouseWorkCardStockIn> selectByExample(WarStorageWarehouseWorkCardStockInExample example);

    WarStorageWarehouseWorkCardStockIn selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarStorageWarehouseWorkCardStockIn record, @Param("example") WarStorageWarehouseWorkCardStockInExample example);

    int updateByExample(@Param("record") WarStorageWarehouseWorkCardStockIn record, @Param("example") WarStorageWarehouseWorkCardStockInExample example);

    int updateByPrimaryKeySelective(WarStorageWarehouseWorkCardStockIn record);

    int updateByPrimaryKey(WarStorageWarehouseWorkCardStockIn record);
    
    int findMaxStockInNo(@Param("stockInNo") String stockInNo);

	List<WarStorageWarehouseWorkCardStockIn> findAllWarStorageWarehouseWorkCardStockInList(WarStorageWarehouseWorkCardStockInQueryVo storageWarehouseWorkCardStockInQueryVo);

	String findAllWarStandardAccessoriesStockInTotal(WarStorageWarehouseWorkCardStockInQueryVo storageWarehouseWorkCardStockInQueryVo);

	int updateWarMaterialInventoryByWarStorageWarehouseWorkCardStockInIdForAdd(String id);
	
	/**
   	 * 根据入库单的id查询入库单对应物料的入库数量、现存数量、占有量
   	 * @param id
   	 * @return
   	 */
	List<Quantity> queryStockInQuantityAndExistingQuantityAndOccupyQuantityByWarStorageWarehouseWorkCardStockInId(String id);
	
	int updateWarMaterialInventoryByWarStorageWarehouseWorkCardStockInIdForSubtract(String id);
}