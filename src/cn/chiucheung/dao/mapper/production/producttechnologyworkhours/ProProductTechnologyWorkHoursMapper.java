package cn.chiucheung.dao.mapper.production.producttechnologyworkhours;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyWorkHours;
import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyWorkHoursExample;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProCalculateProcessTimesCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProCalculateProcessTimesForExportExcelCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyWorkHoursCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyWorkHoursForExportExcelCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;

public interface ProProductTechnologyWorkHoursMapper {
    int countByExample(ProProductTechnologyWorkHoursExample example);

    int deleteByExample(ProProductTechnologyWorkHoursExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProProductTechnologyWorkHours record);

    int insertSelective(ProProductTechnologyWorkHours record);

    List<ProProductTechnologyWorkHours> selectByExample(ProProductTechnologyWorkHoursExample example);

    ProProductTechnologyWorkHours selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProProductTechnologyWorkHours record, @Param("example") ProProductTechnologyWorkHoursExample example);

    int updateByExample(@Param("record") ProProductTechnologyWorkHours record, @Param("example") ProProductTechnologyWorkHoursExample example);

    int updateByPrimaryKeySelective(ProProductTechnologyWorkHours record);

    int updateByPrimaryKey(ProProductTechnologyWorkHours record);
    
    List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyWorkHoursList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);

	String findAllProductTechnologyWorkHoursTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);

	List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyProcessWorkHoursListByProProductTechnologyWorkHoursId(String id);
	
	List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyAccessoriesWorkHoursListByProProductTechnologyWorkHoursId(String id);

	List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyProcessWorkHoursListByProProductTechnologyAccessoriesWorkHoursId(String id);

	List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyAccessoriesWorkHoursListByProProductTechnologyAccessoriesWorkHoursId(String id);

	List<ProProductTechnologyWorkHoursCustom> findAllWarStandardAccessoriesForIsAssociatedList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);

	String findAllWarStandardAccessoriesForIsAssociatedTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo);

	int updateList(List<ProProductTechnologyWorkHoursCustom> productTechnologyWorkHoursCustoms);

	List<ProCalculateProcessTimesCustom> findAllProProcessListForCalculateProcessTimes();

	ProProductTechnologyWorkHoursForExportExcelCustom findProductTechnologyWorkHoursByIdForExportExcel(String id);
	
	List<ProCalculateProcessTimesForExportExcelCustom> findProcessTimesByProProductTechnologyWorkHoursIdForExportExcel(String id);
}