package cn.chiucheung.pojo.warehouse.material;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;


public class WarMaterialQueryVo implements Serializable{
	private String materialCodeForExpand;
	
	private int level;
	
	private String state;

	private String switchState;//开关按钮状态
	
	private String id;//主要使用产品工艺工时修改的时候，由于combogrid下拉的表格是分页的，所以，有可能修改的这个产品工艺工时在后面几页，所以需要用id搜索，只有一条数据
	
	private String materialCode;
	
	private String materialName;
	
	private String materialType;
	
	private String applicableProduct;
	
	private String classification;
	
	private String materialProperties;
	
	private String specifications;
	
	private String length;
	
	private String height;
	
	private String width;
	
	private String depth;
	
	private String color;
	
	private String warehouse;
	
	private String warehousePositions;
	
	private boolean isQuery;//是否有查询条件进来
	
	private String workCardNo;
	
	private String calculationFormulaIsChange;//用于检测产品工艺下面的工序，是否有修改工时，值只有on/null或''
	
	private boolean IsAssociated;//是否关联，主要是用于产品工艺工时的新增修改页面，combogrid选择要给哪个配件设置工艺工时的时候，只能选择未关联的，combogrid选择产品下面的配件的时候，只能选择关联的
	
	private String orWarStandardAccessoriesId;//修改产品工艺工时的时候，由于combogrid选择要给哪个配件设置工艺工时的时候，只能选择未关联的，修改的这个数据是已经关联了的，所有需要用or war_standard_accessories_id = orWarStandardAccessoriesId；
	
	private List<String> notInId;//用于存仓工咭、入库单里的combogird的查询，选了的，需要过滤掉
	
	private String lowestWarehousingQuantity;//ture:低于或等于最低库存量的
	
	private String warStorageWarehouseWorkCardStockInId;//用于入库单修改时，计算所有入库单子项的数量时，需要不计算当前修改的入库单的所有子项
	
	private boolean relationStartandBomQuery;

	private String supplierId;//供应商id

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTimeBefore;//创建时间之前

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTimeAfter;//创建时间之后
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;
	
	public String getMaterialCodeForExpand() {
		return materialCodeForExpand;
	}

	public void setMaterialCodeForExpand(String materialCodeForExpand) {
		this.materialCodeForExpand = materialCodeForExpand;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

    public String getSwitchState() {
        return switchState;
    }

    public void setSwitchState(String switchState) {
        this.switchState = switchState;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getApplicableProduct() {
		return applicableProduct;
	}

	public void setApplicableProduct(String applicableProduct) {
		this.applicableProduct = applicableProduct;
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

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
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

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getWarehousePositions() {
		return warehousePositions;
	}

	public void setWarehousePositions(String warehousePositions) {
		this.warehousePositions = warehousePositions;
	}

	public boolean getIsQuery() {
		return StringUtils.isNotBlank(materialCode)
				|| StringUtils.isNotBlank(materialName)
				|| StringUtils.isNotBlank(materialType)
				|| StringUtils.isNotBlank(applicableProduct)
				|| StringUtils.isNotBlank(classification)
				|| StringUtils.isNotBlank(materialProperties)
				|| StringUtils.isNotBlank(specifications)
				|| StringUtils.isNotBlank(length)
				|| StringUtils.isNotBlank(height)
				|| StringUtils.isNotBlank(width)
				|| StringUtils.isNotBlank(depth)
				|| StringUtils.isNotBlank(color)
				|| StringUtils.isNotBlank(warehouse)
				|| StringUtils.isNotBlank(warehousePositions)
				|| relationStartandBomQuery
				|| "isNull".equals(state)
                || StringUtils.isNotBlank(switchState);
	}

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
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

	public String getWarStorageWarehouseWorkCardStockInId() {
		return warStorageWarehouseWorkCardStockInId;
	}

	public void setWarStorageWarehouseWorkCardStockInId(
			String warStorageWarehouseWorkCardStockInId) {
		this.warStorageWarehouseWorkCardStockInId = warStorageWarehouseWorkCardStockInId;
	}

	public boolean isRelationStartandBomQuery() {
		return relationStartandBomQuery;
	}

	public void setRelationStartandBomQuery(boolean relationStartandBomQuery) {
		this.relationStartandBomQuery = relationStartandBomQuery;
	}

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Date getCreateTimeBefore() {
        return createTimeBefore;
    }

    public void setCreateTimeBefore(Date createTimeBefore) {
        this.createTimeBefore = createTimeBefore;
    }

    public Date getCreateTimeAfter() {
        return createTimeAfter;
    }

    public void setCreateTimeAfter(Date createTimeAfter) {
        this.createTimeAfter = createTimeAfter;
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
