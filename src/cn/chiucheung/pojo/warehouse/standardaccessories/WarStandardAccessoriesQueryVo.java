package cn.chiucheung.pojo.warehouse.standardaccessories;

import java.io.Serializable;
import java.util.List;


public class WarStandardAccessoriesQueryVo implements Serializable{
	private String id;//主要使用产品工艺工时修改的时候，由于combogrid下拉的表格是分页的，所以，有可能修改的这个产品工艺工时在后面几页，所以需要用id搜索，只有一条数据
	
	private String accessoriesCode;
	
	private String accessoriesType;
	
	private String workCardNo;
	
	private String accessoriesName;
	
	private String product;
	
	private String classification;
	
	private String materialProperties;
	
	private String specifications;
	
	private String height;
	
	private String width;
	
	private String depth;
	
	private String color;
	
	private String warehouseInventory;
	
	private String warehousePositions;
	
	private String calculationFormulaIsChange;//用于检测产品工艺下面的工序，是否有修改工时，值只有on/null或''
	
	private boolean IsAssociated;//是否关联，主要是用于产品工艺工时的新增修改页面，combogrid选择要给哪个配件设置工艺工时的时候，只能选择未关联的，combogrid选择产品下面的配件的时候，只能选择关联的
	
	private String orWarStandardAccessoriesId;//修改产品工艺工时的时候，由于combogrid选择要给哪个配件设置工艺工时的时候，只能选择未关联的，修改的这个数据是已经关联了的，所有需要用or war_standard_accessories_id = orWarStandardAccessoriesId；
	
	private List<String> notInId;//用于存仓工咭、入库单里的combogird的查询，选了的，需要过滤掉
	
	private String lowestWarehousingQuantity;//ture:低于或等于最低库存量的
	
	private String warStandardAccessoriesStockInId;//用于入库单修改时，计算所有入库单子项的数量时，需要不计算当前修改的入库单的所有子项
	
	private String dictionarieCode;//用于新增产品工艺时选择第二个配件时判断显示哪种类型的配件
	
	private boolean relationStartandBomQuery;
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;		
	
	public String getDictionarieCode() {
		return dictionarieCode;
	}

	public void setDictionarieCode(String dictionarieCode) {
		this.dictionarieCode = dictionarieCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccessoriesCode() {
		return accessoriesCode;
	}

	public void setAccessoriesCode(String accessoriesCode) {
		this.accessoriesCode = accessoriesCode;
	}

	public String getAccessoriesType() {
		return accessoriesType;
	}

	public void setAccessoriesType(String accessoriesType) {
		this.accessoriesType = accessoriesType;
	}

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getAccessoriesName() {
		return accessoriesName;
	}

	public void setAccessoriesName(String accessoriesName) {
		this.accessoriesName = accessoriesName;
	}
	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getMaterialProperties() {
		return materialProperties;
	}

	public void setMaterialProperties(String materialProperties) {
		this.materialProperties = materialProperties;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWarehouseInventory() {
		return warehouseInventory;
	}

	public void setWarehouseInventory(String warehouseInventory) {
		this.warehouseInventory = warehouseInventory;
	}

	public String getWarehousePositions() {
		return warehousePositions;
	}

	public void setWarehousePositions(String warehousePositions) {
		this.warehousePositions = warehousePositions;
	}

	public String getCalculationFormulaIsChange() {
		return calculationFormulaIsChange;
	}

	public void setCalculationFormulaIsChange(String calculationFormulaIsChange) {
		this.calculationFormulaIsChange = calculationFormulaIsChange;
	}

	public boolean getIsAssociated() {
		return IsAssociated;
	}

	public void setIsAssociated(boolean isAssociated) {
		IsAssociated = isAssociated;
	}

	public String getOrWarStandardAccessoriesId() {
		return orWarStandardAccessoriesId;
	}

	public void setOrWarStandardAccessoriesId(String orWarStandardAccessoriesId) {
		this.orWarStandardAccessoriesId = orWarStandardAccessoriesId;
	}

	public List<String> getNotInId() {
		return notInId;
	}

	public void setNotInId(List<String> notInId) {
		this.notInId = notInId;
	}

	public String getLowestWarehousingQuantity() {
		return lowestWarehousingQuantity;
	}

	public void setLowestWarehousingQuantity(String lowestWarehousingQuantity) {
		this.lowestWarehousingQuantity = lowestWarehousingQuantity;
	}

	public String getWarStandardAccessoriesStockInId() {
		return warStandardAccessoriesStockInId;
	}

	public void setWarStandardAccessoriesStockInId(
			String warStandardAccessoriesStockInId) {
		this.warStandardAccessoriesStockInId = warStandardAccessoriesStockInId;
	}

	public boolean isRelationStartandBomQuery() {
		return relationStartandBomQuery;
	}

	public void setRelationStartandBomQuery(boolean relationStartandBomQuery) {
		this.relationStartandBomQuery = relationStartandBomQuery;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStartPage() {
		return (page-1)*rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
