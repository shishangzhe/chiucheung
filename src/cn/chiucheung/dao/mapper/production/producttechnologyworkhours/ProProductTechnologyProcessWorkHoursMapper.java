package cn.chiucheung.dao.mapper.production.producttechnologyworkhours;

import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyProcessWorkHours;
import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyProcessWorkHoursExample;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyProcessWorkHoursCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProProductTechnologyProcessWorkHoursMapper {
    int countByExample(ProProductTechnologyProcessWorkHoursExample example);

    int deleteByExample(ProProductTechnologyProcessWorkHoursExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProProductTechnologyProcessWorkHours record);

    int insertSelective(ProProductTechnologyProcessWorkHours record);

    List<ProProductTechnologyProcessWorkHours> selectByExample(ProProductTechnologyProcessWorkHoursExample example);

    ProProductTechnologyProcessWorkHours selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProProductTechnologyProcessWorkHours record, @Param("example") ProProductTechnologyProcessWorkHoursExample example);

    int updateByExample(@Param("record") ProProductTechnologyProcessWorkHours record, @Param("example") ProProductTechnologyProcessWorkHoursExample example);

    int updateByPrimaryKeySelective(ProProductTechnologyProcessWorkHours record);

    int updateByPrimaryKey(ProProductTechnologyProcessWorkHours record);
    
    int insertList(List<ProProductTechnologyProcessWorkHours> processDatas);

	List<ProProductTechnologyProcessWorkHoursCustom> findAllProProductTechnologyProcessWorkHoursListByProProductTechnologyWorkHoursId(String id);
}