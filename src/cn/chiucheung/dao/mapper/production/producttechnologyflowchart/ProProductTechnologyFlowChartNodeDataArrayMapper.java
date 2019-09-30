package cn.chiucheung.dao.mapper.production.producttechnologyflowchart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartNodeDataArray;
import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartNodeDataArrayExample;
import cn.chiucheung.pojo.production.producttechnologyflowchart.ProProductTechnologyFlowChartNodeDataArrayCustom;

public interface ProProductTechnologyFlowChartNodeDataArrayMapper {
    int countByExample(ProProductTechnologyFlowChartNodeDataArrayExample example);

    int deleteByExample(ProProductTechnologyFlowChartNodeDataArrayExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProProductTechnologyFlowChartNodeDataArray record);

    int insertSelective(ProProductTechnologyFlowChartNodeDataArray record);

    List<ProProductTechnologyFlowChartNodeDataArray> selectByExample(ProProductTechnologyFlowChartNodeDataArrayExample example);

    ProProductTechnologyFlowChartNodeDataArray selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProProductTechnologyFlowChartNodeDataArray record, @Param("example") ProProductTechnologyFlowChartNodeDataArrayExample example);

    int updateByExample(@Param("record") ProProductTechnologyFlowChartNodeDataArray record, @Param("example") ProProductTechnologyFlowChartNodeDataArrayExample example);

    int updateByPrimaryKeySelective(ProProductTechnologyFlowChartNodeDataArray record);

    int updateByPrimaryKey(ProProductTechnologyFlowChartNodeDataArray record);
    
    int insertList(List<ProProductTechnologyFlowChartNodeDataArray> nodeDataArray);

	List<ProProductTechnologyFlowChartNodeDataArrayCustom> findProProductTechnologyFlowChartNodeDataArrayCustomByProProductTechlogyWorkHoursId(String id);
}