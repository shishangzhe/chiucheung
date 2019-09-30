package cn.chiucheung.dao.mapper.sales.projectinfo;

import cn.chiucheung.po.sales.projectinfo.SalProjectInfo;
import cn.chiucheung.po.sales.projectinfo.SalProjectInfoExample;
import cn.chiucheung.pojo.market.map.MapDataCustom;
import cn.chiucheung.pojo.market.map.ProjectInfoIndustryCount;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoCustom;
import cn.chiucheung.pojo.sales.projectinfo.SalProjectInfoQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalProjectInfoMapper {
    int countByExample(SalProjectInfoExample example);

    int deleteByExample(SalProjectInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(SalProjectInfo record);

    int insertSelective(SalProjectInfo record);

    List<SalProjectInfo> selectByExample(SalProjectInfoExample example);

    SalProjectInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SalProjectInfo record, @Param("example") SalProjectInfoExample example);

    int updateByExample(@Param("record") SalProjectInfo record, @Param("example") SalProjectInfoExample example);

    int updateByPrimaryKeySelective(SalProjectInfo record);

    int updateByPrimaryKey(SalProjectInfo record);

	List<SalProjectInfoCustom> findAllProjectInfoList(SalProjectInfoQueryVo projectInfoQueryVo);

	String findAllProjectInfoTotal(SalProjectInfoQueryVo projectInfoQueryVo);

	int insertList(List<SalProjectInfo> projectInfos);

	List<MapDataCustom> getMapDataForWorld();

	List<MapDataCustom> getMapDataForChina();

	List<MapDataCustom> getMapDataForProvince(@Param("province") String province);

	List<ProjectInfoIndustryCount> findProjectInfoIndustryCount(SalProjectInfoQueryVo projectInfoQueryVo);
}