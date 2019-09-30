package cn.chiucheung.dao.mapper.system.dictionarie;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.system.dictionarie.SysDictionarie;
import cn.chiucheung.po.system.dictionarie.SysDictionarieExample;

public interface SysDictionarieMapper {
    int countByExample(SysDictionarieExample example);

    int deleteByExample(SysDictionarieExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysDictionarie record);

    int insertSelective(SysDictionarie record);

    List<SysDictionarie> selectByExample(SysDictionarieExample example);

    SysDictionarie selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysDictionarie record, @Param("example") SysDictionarieExample example);

    int updateByExample(@Param("record") SysDictionarie record, @Param("example") SysDictionarieExample example);

    int updateByPrimaryKeySelective(SysDictionarie record);

    int updateByPrimaryKey(SysDictionarie record);

	List<SysDictionarie> findAllKeywordByDistinct();
}