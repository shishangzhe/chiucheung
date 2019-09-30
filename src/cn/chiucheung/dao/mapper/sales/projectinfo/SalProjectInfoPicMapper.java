package cn.chiucheung.dao.mapper.sales.projectinfo;

import cn.chiucheung.po.sales.projectinfo.SalProjectInfoPic;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfoPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalProjectInfoPicMapper {
    int countByExample(SalProjectInfoPicExample example);

    int deleteByExample(SalProjectInfoPicExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalProjectInfoPic record);

    int insertSelective(SalProjectInfoPic record);

    List<SalProjectInfoPic> selectByExample(SalProjectInfoPicExample example);

    SalProjectInfoPic selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalProjectInfoPic record, @Param("example") SalProjectInfoPicExample example);

    int updateByExample(@Param("record") SalProjectInfoPic record, @Param("example") SalProjectInfoPicExample example);

    int updateByPrimaryKeySelective(SalProjectInfoPic record);

    int updateByPrimaryKey(SalProjectInfoPic record);

	int insertList(List<SalProjectInfoPic> list);
}