package cn.chiucheung.po.engineering.bom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EngBomSubsidiaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EngBomSubsidiaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNull() {
            addCriterion("material_code is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNotNull() {
            addCriterion("material_code is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeEqualTo(String value) {
            addCriterion("material_code =", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotEqualTo(String value) {
            addCriterion("material_code <>", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThan(String value) {
            addCriterion("material_code >", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("material_code >=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThan(String value) {
            addCriterion("material_code <", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThanOrEqualTo(String value) {
            addCriterion("material_code <=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLike(String value) {
            addCriterion("material_code like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotLike(String value) {
            addCriterion("material_code not like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIn(List<String> values) {
            addCriterion("material_code in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotIn(List<String> values) {
            addCriterion("material_code not in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeBetween(String value1, String value2) {
            addCriterion("material_code between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotBetween(String value1, String value2) {
            addCriterion("material_code not between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNull() {
            addCriterion("material_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNotNull() {
            addCriterion("material_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameEqualTo(String value) {
            addCriterion("material_name =", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotEqualTo(String value) {
            addCriterion("material_name <>", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThan(String value) {
            addCriterion("material_name >", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_name >=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThan(String value) {
            addCriterion("material_name <", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("material_name <=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLike(String value) {
            addCriterion("material_name like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotLike(String value) {
            addCriterion("material_name not like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIn(List<String> values) {
            addCriterion("material_name in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotIn(List<String> values) {
            addCriterion("material_name not in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameBetween(String value1, String value2) {
            addCriterion("material_name between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotBetween(String value1, String value2) {
            addCriterion("material_name not between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(String value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(String value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(String value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(String value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLike(String value) {
            addCriterion("specifications like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotLike(String value) {
            addCriterion("specifications not like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<String> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<String> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(String value1, String value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(String value1, String value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberIsNull() {
            addCriterion("drawing_number is null");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberIsNotNull() {
            addCriterion("drawing_number is not null");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberEqualTo(String value) {
            addCriterion("drawing_number =", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberNotEqualTo(String value) {
            addCriterion("drawing_number <>", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberGreaterThan(String value) {
            addCriterion("drawing_number >", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberGreaterThanOrEqualTo(String value) {
            addCriterion("drawing_number >=", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberLessThan(String value) {
            addCriterion("drawing_number <", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberLessThanOrEqualTo(String value) {
            addCriterion("drawing_number <=", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberLike(String value) {
            addCriterion("drawing_number like", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberNotLike(String value) {
            addCriterion("drawing_number not like", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberIn(List<String> values) {
            addCriterion("drawing_number in", values, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberNotIn(List<String> values) {
            addCriterion("drawing_number not in", values, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberBetween(String value1, String value2) {
            addCriterion("drawing_number between", value1, value2, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberNotBetween(String value1, String value2) {
            addCriterion("drawing_number not between", value1, value2, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesIsNull() {
            addCriterion("material_properties is null");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesIsNotNull() {
            addCriterion("material_properties is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesEqualTo(String value) {
            addCriterion("material_properties =", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesNotEqualTo(String value) {
            addCriterion("material_properties <>", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesGreaterThan(String value) {
            addCriterion("material_properties >", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesGreaterThanOrEqualTo(String value) {
            addCriterion("material_properties >=", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesLessThan(String value) {
            addCriterion("material_properties <", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesLessThanOrEqualTo(String value) {
            addCriterion("material_properties <=", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesLike(String value) {
            addCriterion("material_properties like", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesNotLike(String value) {
            addCriterion("material_properties not like", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesIn(List<String> values) {
            addCriterion("material_properties in", values, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesNotIn(List<String> values) {
            addCriterion("material_properties not in", values, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesBetween(String value1, String value2) {
            addCriterion("material_properties between", value1, value2, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesNotBetween(String value1, String value2) {
            addCriterion("material_properties not between", value1, value2, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopIsNull() {
            addCriterion("production_workshop is null");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopIsNotNull() {
            addCriterion("production_workshop is not null");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopEqualTo(String value) {
            addCriterion("production_workshop =", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopNotEqualTo(String value) {
            addCriterion("production_workshop <>", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopGreaterThan(String value) {
            addCriterion("production_workshop >", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopGreaterThanOrEqualTo(String value) {
            addCriterion("production_workshop >=", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopLessThan(String value) {
            addCriterion("production_workshop <", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopLessThanOrEqualTo(String value) {
            addCriterion("production_workshop <=", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopLike(String value) {
            addCriterion("production_workshop like", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopNotLike(String value) {
            addCriterion("production_workshop not like", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopIn(List<String> values) {
            addCriterion("production_workshop in", values, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopNotIn(List<String> values) {
            addCriterion("production_workshop not in", values, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopBetween(String value1, String value2) {
            addCriterion("production_workshop between", value1, value2, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopNotBetween(String value1, String value2) {
            addCriterion("production_workshop not between", value1, value2, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentIsNull() {
            addCriterion("surface_treatment is null");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentIsNotNull() {
            addCriterion("surface_treatment is not null");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentEqualTo(String value) {
            addCriterion("surface_treatment =", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentNotEqualTo(String value) {
            addCriterion("surface_treatment <>", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentGreaterThan(String value) {
            addCriterion("surface_treatment >", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentGreaterThanOrEqualTo(String value) {
            addCriterion("surface_treatment >=", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentLessThan(String value) {
            addCriterion("surface_treatment <", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentLessThanOrEqualTo(String value) {
            addCriterion("surface_treatment <=", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentLike(String value) {
            addCriterion("surface_treatment like", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentNotLike(String value) {
            addCriterion("surface_treatment not like", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentIn(List<String> values) {
            addCriterion("surface_treatment in", values, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentNotIn(List<String> values) {
            addCriterion("surface_treatment not in", values, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentBetween(String value1, String value2) {
            addCriterion("surface_treatment between", value1, value2, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentNotBetween(String value1, String value2) {
            addCriterion("surface_treatment not between", value1, value2, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionIsNull() {
            addCriterion("singleton_consumption is null");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionIsNotNull() {
            addCriterion("singleton_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionEqualTo(BigDecimal value) {
            addCriterion("singleton_consumption =", value, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionNotEqualTo(BigDecimal value) {
            addCriterion("singleton_consumption <>", value, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionGreaterThan(BigDecimal value) {
            addCriterion("singleton_consumption >", value, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("singleton_consumption >=", value, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionLessThan(BigDecimal value) {
            addCriterion("singleton_consumption <", value, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("singleton_consumption <=", value, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionIn(List<BigDecimal> values) {
            addCriterion("singleton_consumption in", values, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionNotIn(List<BigDecimal> values) {
            addCriterion("singleton_consumption not in", values, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("singleton_consumption between", value1, value2, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andSingletonConsumptionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("singleton_consumption not between", value1, value2, "singletonConsumption");
            return (Criteria) this;
        }

        public Criteria andUseUnitIsNull() {
            addCriterion("use_unit is null");
            return (Criteria) this;
        }

        public Criteria andUseUnitIsNotNull() {
            addCriterion("use_unit is not null");
            return (Criteria) this;
        }

        public Criteria andUseUnitEqualTo(String value) {
            addCriterion("use_unit =", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitNotEqualTo(String value) {
            addCriterion("use_unit <>", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitGreaterThan(String value) {
            addCriterion("use_unit >", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitGreaterThanOrEqualTo(String value) {
            addCriterion("use_unit >=", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitLessThan(String value) {
            addCriterion("use_unit <", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitLessThanOrEqualTo(String value) {
            addCriterion("use_unit <=", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitLike(String value) {
            addCriterion("use_unit like", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitNotLike(String value) {
            addCriterion("use_unit not like", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitIn(List<String> values) {
            addCriterion("use_unit in", values, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitNotIn(List<String> values) {
            addCriterion("use_unit not in", values, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitBetween(String value1, String value2) {
            addCriterion("use_unit between", value1, value2, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitNotBetween(String value1, String value2) {
            addCriterion("use_unit not between", value1, value2, "useUnit");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andEngBomIdIsNull() {
            addCriterion("eng_bom_id is null");
            return (Criteria) this;
        }

        public Criteria andEngBomIdIsNotNull() {
            addCriterion("eng_bom_id is not null");
            return (Criteria) this;
        }

        public Criteria andEngBomIdEqualTo(String value) {
            addCriterion("eng_bom_id =", value, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdNotEqualTo(String value) {
            addCriterion("eng_bom_id <>", value, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdGreaterThan(String value) {
            addCriterion("eng_bom_id >", value, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdGreaterThanOrEqualTo(String value) {
            addCriterion("eng_bom_id >=", value, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdLessThan(String value) {
            addCriterion("eng_bom_id <", value, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdLessThanOrEqualTo(String value) {
            addCriterion("eng_bom_id <=", value, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdLike(String value) {
            addCriterion("eng_bom_id like", value, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdNotLike(String value) {
            addCriterion("eng_bom_id not like", value, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdIn(List<String> values) {
            addCriterion("eng_bom_id in", values, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdNotIn(List<String> values) {
            addCriterion("eng_bom_id not in", values, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdBetween(String value1, String value2) {
            addCriterion("eng_bom_id between", value1, value2, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomIdNotBetween(String value1, String value2) {
            addCriterion("eng_bom_id not between", value1, value2, "engBomId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdIsNull() {
            addCriterion("eng_bom_subsidiary_id is null");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdIsNotNull() {
            addCriterion("eng_bom_subsidiary_id is not null");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdEqualTo(String value) {
            addCriterion("eng_bom_subsidiary_id =", value, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdNotEqualTo(String value) {
            addCriterion("eng_bom_subsidiary_id <>", value, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdGreaterThan(String value) {
            addCriterion("eng_bom_subsidiary_id >", value, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("eng_bom_subsidiary_id >=", value, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdLessThan(String value) {
            addCriterion("eng_bom_subsidiary_id <", value, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdLessThanOrEqualTo(String value) {
            addCriterion("eng_bom_subsidiary_id <=", value, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdLike(String value) {
            addCriterion("eng_bom_subsidiary_id like", value, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdNotLike(String value) {
            addCriterion("eng_bom_subsidiary_id not like", value, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdIn(List<String> values) {
            addCriterion("eng_bom_subsidiary_id in", values, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdNotIn(List<String> values) {
            addCriterion("eng_bom_subsidiary_id not in", values, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdBetween(String value1, String value2) {
            addCriterion("eng_bom_subsidiary_id between", value1, value2, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andEngBomSubsidiaryIdNotBetween(String value1, String value2) {
            addCriterion("eng_bom_subsidiary_id not between", value1, value2, "engBomSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdIsNull() {
            addCriterion("war_material_id is null");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdIsNotNull() {
            addCriterion("war_material_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdEqualTo(String value) {
            addCriterion("war_material_id =", value, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdNotEqualTo(String value) {
            addCriterion("war_material_id <>", value, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdGreaterThan(String value) {
            addCriterion("war_material_id >", value, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("war_material_id >=", value, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdLessThan(String value) {
            addCriterion("war_material_id <", value, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("war_material_id <=", value, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdLike(String value) {
            addCriterion("war_material_id like", value, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdNotLike(String value) {
            addCriterion("war_material_id not like", value, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdIn(List<String> values) {
            addCriterion("war_material_id in", values, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdNotIn(List<String> values) {
            addCriterion("war_material_id not in", values, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdBetween(String value1, String value2) {
            addCriterion("war_material_id between", value1, value2, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andWarMaterialIdNotBetween(String value1, String value2) {
            addCriterion("war_material_id not between", value1, value2, "warMaterialId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}