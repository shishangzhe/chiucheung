package cn.chiucheung.dao.mapper.production.standard;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.production.standard.ProTechnologyBasicData;
import cn.chiucheung.po.production.standard.ProTechnologyBasicDataExample;
import cn.chiucheung.pojo.production.standard.ProProcessTechnologyCustom;
import cn.chiucheung.pojo.production.standard.ProTechnologyBasicDataCustom;

public interface ProTechnologyBasicDataMapper {
    int countByExample(ProTechnologyBasicDataExample example);

    int deleteByExample(ProTechnologyBasicDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProTechnologyBasicData record);

    int insertSelective(ProTechnologyBasicData record);

    List<ProTechnologyBasicData> selectByExample(ProTechnologyBasicDataExample example);

    ProTechnologyBasicData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProTechnologyBasicData record, @Param("example") ProTechnologyBasicDataExample example);

    int updateByExample(@Param("record") ProTechnologyBasicData record, @Param("example") ProTechnologyBasicDataExample example);

    int updateByPrimaryKeySelective(ProTechnologyBasicData record);

    int updateByPrimaryKey(ProTechnologyBasicData record);
    
	List<ProProcessTechnologyCustom> findAllProProcessTechnologyCustomList(@Param("proProcessId") String proProcessId);

	ProProcessTechnologyCustom findTechnologyById(String id);

	List<ProTechnologyBasicDataCustom> findProTechnologyBasicDataByProProcessId(String processId);
}