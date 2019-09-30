package cn.chiucheung.dao.mapper.purchase.material;

import cn.chiucheung.po.purchase.material.PurMaterial;
import cn.chiucheung.po.purchase.material.PurMaterialExample;
import cn.chiucheung.pojo.purchase.material.PurMaterialQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PurMaterialMapper {
    int countByExample(PurMaterialExample example);

    int deleteByExample(PurMaterialExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurMaterial record);

    int insertSelective(PurMaterial record);

    List<PurMaterial> selectByExample(PurMaterialExample example);

    PurMaterial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurMaterial record, @Param("example") PurMaterialExample example);

    int updateByExample(@Param("record") PurMaterial record, @Param("example") PurMaterialExample example);

    int updateByPrimaryKeySelective(PurMaterial record);

    int updateByPrimaryKey(PurMaterial record);
    
	List<PurMaterial> findAllPurMaterialList(PurMaterialQueryVo materialQueryVo);

	String findAllPurMaterialTotal(PurMaterialQueryVo materialQueryVo);
}