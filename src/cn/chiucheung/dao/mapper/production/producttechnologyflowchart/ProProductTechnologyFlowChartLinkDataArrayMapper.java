package cn.chiucheung.dao.mapper.production.producttechnologyflowchart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartLinkDataArray;
import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartLinkDataArrayExample;

public interface ProProductTechnologyFlowChartLinkDataArrayMapper {
    int countByExample(ProProductTechnologyFlowChartLinkDataArrayExample example);

    int deleteByExample(ProProductTechnologyFlowChartLinkDataArrayExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProProductTechnologyFlowChartLinkDataArray record);

    int insertSelective(ProProductTechnologyFlowChartLinkDataArray record);

    List<ProProductTechnologyFlowChartLinkDataArray> selectByExample(ProProductTechnologyFlowChartLinkDataArrayExample example);

    ProProductTechnologyFlowChartLinkDataArray selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProProductTechnologyFlowChartLinkDataArray record, @Param("example") ProProductTechnologyFlowChartLinkDataArrayExample example);

    int updateByExample(@Param("record") ProProductTechnologyFlowChartLinkDataArray record, @Param("example") ProProductTechnologyFlowChartLinkDataArrayExample example);

    int updateByPrimaryKeySelective(ProProductTechnologyFlowChartLinkDataArray record);

    int updateByPrimaryKey(ProProductTechnologyFlowChartLinkDataArray record);
    
    int insertList(List<ProProductTechnologyFlowChartLinkDataArray> linkDataArray);

	List<ProProductTechnologyFlowChartLinkDataArray> findProProductTechnologyFlowChartLinkDataArrayCustomByProProductTechlogyWorkHoursId(String id);
}