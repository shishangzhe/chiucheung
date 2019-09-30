package cn.chiucheung.dao.mapper.purchase.material;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.purchase.material.PurMaterialBaseData;
import cn.chiucheung.po.purchase.material.PurMaterialBaseDataExample;

public interface PurMaterialBaseDataMapper {
    int countByExample(PurMaterialBaseDataExample example);

    int deleteByExample(PurMaterialBaseDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurMaterialBaseData record);

    int insertSelective(PurMaterialBaseData record);

    List<PurMaterialBaseData> selectByExample(PurMaterialBaseDataExample example);

    PurMaterialBaseData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurMaterialBaseData record, @Param("example") PurMaterialBaseDataExample example);

    int updateByExample(@Param("record") PurMaterialBaseData record, @Param("example") PurMaterialBaseDataExample example);

    int updateByPrimaryKeySelective(PurMaterialBaseData record);

    int updateByPrimaryKey(PurMaterialBaseData record);

	List<PurMaterialBaseData> findAllKeywordByDistinct();

}