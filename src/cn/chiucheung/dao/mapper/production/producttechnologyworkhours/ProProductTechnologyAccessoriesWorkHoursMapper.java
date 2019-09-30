package cn.chiucheung.dao.mapper.production.producttechnologyworkhours;

import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyAccessoriesWorkHours;
import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyAccessoriesWorkHoursExample;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyAccessoriesWorkHoursCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProProductTechnologyAccessoriesWorkHoursMapper {
    int countByExample(ProProductTechnologyAccessoriesWorkHoursExample example);

    int deleteByExample(ProProductTechnologyAccessoriesWorkHoursExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProProductTechnologyAccessoriesWorkHours record);

    int insertSelective(ProProductTechnologyAccessoriesWorkHours record);

    List<ProProductTechnologyAccessoriesWorkHours> selectByExample(ProProductTechnologyAccessoriesWorkHoursExample example);

    ProProductTechnologyAccessoriesWorkHours selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProProductTechnologyAccessoriesWorkHours record, @Param("example") ProProductTechnologyAccessoriesWorkHoursExample example);

    int updateByExample(@Param("record") ProProductTechnologyAccessoriesWorkHours record, @Param("example") ProProductTechnologyAccessoriesWorkHoursExample example);

    int updateByPrimaryKeySelective(ProProductTechnologyAccessoriesWorkHours record);

    int updateByPrimaryKey(ProProductTechnologyAccessoriesWorkHours record);
    
    int insertList(List<ProProductTechnologyAccessoriesWorkHoursCustom> standardAccessoriesDatas);

	List<ProProductTechnologyAccessoriesWorkHoursCustom> findAllProProductTechnologyAccessoriesWorkHoursListByProProductTechnologyWorkHoursId(String id);
}