package cn.chiucheung.dao.mapper.warehouse.basedata;

import cn.chiucheung.po.warehouse.basedata.WarBaseData;
import cn.chiucheung.po.warehouse.basedata.WarBaseDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarBaseDataMapper {
    int countByExample(WarBaseDataExample example);

    int deleteByExample(WarBaseDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(WarBaseData record);

    int insertSelective(WarBaseData record);

    List<WarBaseData> selectByExample(WarBaseDataExample example);

    WarBaseData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WarBaseData record, @Param("example") WarBaseDataExample example);

    int updateByExample(@Param("record") WarBaseData record, @Param("example") WarBaseDataExample example);

    int updateByPrimaryKeySelective(WarBaseData record);

    int updateByPrimaryKey(WarBaseData record);

	List<WarBaseData> findAllKeywordByDistinct();
}