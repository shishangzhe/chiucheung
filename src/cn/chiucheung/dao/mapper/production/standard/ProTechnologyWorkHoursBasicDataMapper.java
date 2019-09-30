package cn.chiucheung.dao.mapper.production.standard;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.production.standard.ProTechnologyWorkHoursBasicData;
import cn.chiucheung.po.production.standard.ProTechnologyWorkHoursBasicDataExample;
import cn.chiucheung.pojo.production.standard.ProProcessTechnologyCustom;
import cn.chiucheung.pojo.production.standard.ProTechnologyWorkHoursBasicDataCustom;

public interface ProTechnologyWorkHoursBasicDataMapper {
    int countByExample(ProTechnologyWorkHoursBasicDataExample example);

    int deleteByExample(ProTechnologyWorkHoursBasicDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProTechnologyWorkHoursBasicData record);

    int insertSelective(ProTechnologyWorkHoursBasicData record);

    List<ProTechnologyWorkHoursBasicData> selectByExample(ProTechnologyWorkHoursBasicDataExample example);

    ProTechnologyWorkHoursBasicData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProTechnologyWorkHoursBasicData record, @Param("example") ProTechnologyWorkHoursBasicDataExample example);

    int updateByExample(@Param("record") ProTechnologyWorkHoursBasicData record, @Param("example") ProTechnologyWorkHoursBasicDataExample example);

    int updateByPrimaryKeySelective(ProTechnologyWorkHoursBasicData record);

    int updateByPrimaryKey(ProTechnologyWorkHoursBasicData record);

	List<ProProcessTechnologyCustom> findAllProProcessTechnologyCustomList(@Param("proProcessId") String proProcessId);

	ProProcessTechnologyCustom findTechnologyWorkHoursById(String id);

	List<ProTechnologyWorkHoursBasicDataCustom> findProTechnologyWorkHoursBasicDataByProProcessId(String processId);
}