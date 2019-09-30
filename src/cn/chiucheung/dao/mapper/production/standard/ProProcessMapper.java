package cn.chiucheung.dao.mapper.production.standard;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.production.standard.ProProcess;
import cn.chiucheung.po.production.standard.ProProcessExample;
import cn.chiucheung.pojo.production.standard.ProProcessTreegridCustom;
import cn.chiucheung.pojo.production.standard.ProProcessQueryVo;
import cn.chiucheung.pojo.production.standard.ProProcessTechnologyCustom;

public interface ProProcessMapper {
    int countByExample(ProProcessExample example);

    int deleteByExample(ProProcessExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProProcess record);

    int insertSelective(ProProcess record);

    List<ProProcess> selectByExample(ProProcessExample example);

    ProProcess selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProProcess record, @Param("example") ProProcessExample example);

    int updateByExample(@Param("record") ProProcess record, @Param("example") ProProcessExample example);

    int updateByPrimaryKeySelective(ProProcess record);

    int updateByPrimaryKey(ProProcess record);
    
    List<ProProcess> findAllProProcessList(ProProcessQueryVo processQueryVo);

	List<ProProcess> findAllProcessByDistinct();

	List<ProProcessTechnologyCustom> findAllProProcessTechnologyCustomList(ProProcessQueryVo processQueryVo);

	List<ProProcessTreegridCustom> findAllProProcessListForCombotreegrid(ProProcessQueryVo processQueryVo);
}