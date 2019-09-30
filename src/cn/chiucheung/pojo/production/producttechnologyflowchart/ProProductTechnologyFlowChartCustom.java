package cn.chiucheung.pojo.production.producttechnologyflowchart;

import java.util.List;

import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartLinkDataArray;

public class ProProductTechnologyFlowChartCustom{
	private List<ProProductTechnologyFlowChartNodeDataArrayCustom> nodeDataArray;
	
	private List<ProProductTechnologyFlowChartLinkDataArray> linkDataArray;

	public List<ProProductTechnologyFlowChartNodeDataArrayCustom> getNodeDataArray() {
		return nodeDataArray;
	}

	public void setNodeDataArray(
			List<ProProductTechnologyFlowChartNodeDataArrayCustom> nodeDataArray) {
		this.nodeDataArray = nodeDataArray;
	}

	public List<ProProductTechnologyFlowChartLinkDataArray> getLinkDataArray() {
		return linkDataArray;
	}

	public void setLinkDataArray(
			List<ProProductTechnologyFlowChartLinkDataArray> linkDataArray) {
		this.linkDataArray = linkDataArray;
	}

}
