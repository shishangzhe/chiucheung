package cn.chiucheung.dao.mapper.warehouse.material;

import cn.chiucheung.po.warehouse.material.WarMaterialFile;
import cn.chiucheung.po.warehouse.material.WarMaterialFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarMaterialFileMapper {
    int countByExample(WarMaterialFileExample example);

    int deleteByExample(WarMaterialFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarMaterialFile record);

    int insertSelective(WarMaterialFile record);

    List<WarMaterialFile> selectByExample(WarMaterialFileExample example);

    WarMaterialFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarMaterialFile record, @Param("example") WarMaterialFileExample example);

    int updateByExample(@Param("record") WarMaterialFile record, @Param("example") WarMaterialFileExample example);

    int updateByPrimaryKeySelective(WarMaterialFile record);

    int updateByPrimaryKey(WarMaterialFile record);
}