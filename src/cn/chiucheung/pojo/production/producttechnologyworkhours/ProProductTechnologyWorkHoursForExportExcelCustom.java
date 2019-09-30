package cn.chiucheung.pojo.production.producttechnologyworkhours;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProProductTechnologyWorkHoursForExportExcelCustom implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String accessoriesCode;
	
	private String accessoriesName;
	
	private String specifications;
	
	private String drawingNumber;
	
	private Integer eachNumber;//默认为1，因为你要导出的产品，就是1，下面的零部件也是用这个类，会set进去，没有set的就是1
	
	private String unit;
	
	private BigDecimal processCoefficient;

    private BigDecimal accessoriesCoefficient;
	
	private List<ProCalculateProcessTimesForExportExcelCustom> processTimes;//下面的工序工时，不包含零部件的工时
	
	private List<ProProductTechnologyWorkHoursForExportExcelCustom> productTechnologyWorkHoursForExportExcelCustoms;//下面的零部件，里面processTimes，就是零部件的工时
	
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

	public String getAccessoriesName() {
		return accessoriesName;
	}

	public void setAccessoriesName(String accessoriesName) {
		this.accessoriesName = accessoriesName;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getDrawingNumber() {
		return drawingNumber;
	}

	public void setDrawingNumber(String drawingNumber) {
		this.drawingNumber = drawingNumber;
	}

	public Integer getEachNumber() {
		return eachNumber == null ? 1 : eachNumber;
	}

	public void setEachNumber(Integer eachNumber) {
		this.eachNumber = eachNumber;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getProcessCoefficient() {
		return processCoefficient;
	}

	public void setProcessCoefficient(BigDecimal processCoefficient) {
		this.processCoefficient = processCoefficient;
	}

	public BigDecimal getAccessoriesCoefficient() {
		return accessoriesCoefficient;
	}

	public void setAccessoriesCoefficient(BigDecimal accessoriesCoefficient) {
		this.accessoriesCoefficient = accessoriesCoefficient;
	}

	public List<ProCalculateProcessTimesForExportExcelCustom> getProcessTimes() {
		return processTimes;
	}

	public void setProcessTimes(List<ProCalculateProcessTimesForExportExcelCustom> processTimes) {
		this.processTimes = processTimes;
	}

	public List<ProProductTechnologyWorkHoursForExportExcelCustom> getProductTechnologyWorkHoursForExportExcelCustoms() {
		return productTechnologyWorkHoursForExportExcelCustoms;
	}

	public void setProductTechnologyWorkHoursForExportExcelCustoms(
			List<ProProductTechnologyWorkHoursForExportExcelCustom> productTechnologyWorkHoursForExportExcelCustoms) {
		this.productTechnologyWorkHoursForExportExcelCustoms = productTechnologyWorkHoursForExportExcelCustoms;
	}
	@Override
	public String toString() {
		return getEachNumber()+"";
	}
	
	public Object deepClone() {
		try{
			// 将对象写到流里
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(this);
			// 从流里读出来
			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			return (oi.readObject());
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
