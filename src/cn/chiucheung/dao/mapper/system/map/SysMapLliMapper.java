package cn.chiucheung.dao.mapper.system.map;

import cn.chiucheung.po.system.map.SysMapLli;
import cn.chiucheung.po.system.map.SysMapLliExample;
import cn.chiucheung.pojo.system.map.SysMapLliQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysMapLliMapper {
    int countByExample(SysMapLliExample example);

    int deleteByExample(SysMapLliExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysMapLli record);

    int insertSelective(SysMapLli record);

    List<SysMapLli> selectByExample(SysMapLliExample example);

    SysMapLli selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysMapLli record, @Param("example") SysMapLliExample example);

    int updateByExample(@Param("record") SysMapLli record, @Param("example") SysMapLliExample example);

    int updateByPrimaryKeySelective(SysMapLli record);

    int updateByPrimaryKey(SysMapLli record);

	List<SysMapLli> findAllMapLliList(SysMapLliQueryVo mapLliQueryVo);

	String findAllMapLliTotal(SysMapLliQueryVo mapLliQueryVo);
}