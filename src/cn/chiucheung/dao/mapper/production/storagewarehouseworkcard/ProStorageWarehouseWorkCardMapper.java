package cn.chiucheung.dao.mapper.production.storagewarehouseworkcard;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.production.storagewarehouseworkcard.ProStorageWarehouseWorkCard;
import cn.chiucheung.po.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardExample;
import cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInSubsidiary;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardQueryVo;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardShowDataCustom;

public interface ProStorageWarehouseWorkCardMapper {
    int countByExample(ProStorageWarehouseWorkCardExample example);

    int deleteByExample(ProStorageWarehouseWorkCardExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProStorageWarehouseWorkCard record);

    int insertSelective(ProStorageWarehouseWorkCard record);

    List<ProStorageWarehouseWorkCard> selectByExample(ProStorageWarehouseWorkCardExample example);

    ProStorageWarehouseWorkCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProStorageWarehouseWorkCard record, @Param("example") ProStorageWarehouseWorkCardExample example);

    int updateByExample(@Param("record") ProStorageWarehouseWorkCard record, @Param("example") ProStorageWarehouseWorkCardExample example);

    int updateByPrimaryKeySelective(ProStorageWarehouseWorkCard record);

    int updateByPrimaryKey(ProStorageWarehouseWorkCard record);

    List<ProStorageWarehouseWorkCardShowDataCustom> findAllProStorageWarehouseWorkCardList(ProStorageWarehouseWorkCardQueryVo storageWarehouseWorkCardQueryVo);

	String findAllProStorageWarehouseWorkCardTotal(ProStorageWarehouseWorkCardQueryVo storageWarehouseWorkCardQueryVo);
	
	/**
	 * 根据存仓工咭的id查找关联的存仓工咭入库单，用于存仓工咭反审，如果关联了存仓工咭入库单，则不能反审
	 * @param id
	 * @return
	 */
	List<WarStorageWarehouseWorkCardStockInSubsidiary> findWarStorageWarehouseWorkCardStockInSubsidiariesByProStorageWarehouseWorkCardId(String id);
}