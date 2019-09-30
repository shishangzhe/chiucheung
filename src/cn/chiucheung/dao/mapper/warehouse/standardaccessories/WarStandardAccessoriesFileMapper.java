package cn.chiucheung.dao.mapper.warehouse.standardaccessories;

import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesFile;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarStandardAccessoriesFileMapper {
    int countByExample(WarStandardAccessoriesFileExample example);

    int deleteByExample(WarStandardAccessoriesFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarStandardAccessoriesFile record);

    int insertSelective(WarStandardAccessoriesFile record);

    List<WarStandardAccessoriesFile> selectByExample(WarStandardAccessoriesFileExample example);

    WarStandardAccessoriesFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarStandardAccessoriesFile record, @Param("example") WarStandardAccessoriesFileExample example);

    int updateByExample(@Param("record") WarStandardAccessoriesFile record, @Param("example") WarStandardAccessoriesFileExample example);

    int updateByPrimaryKeySelective(WarStandardAccessoriesFile record);

    int updateByPrimaryKey(WarStandardAccessoriesFile record);
}