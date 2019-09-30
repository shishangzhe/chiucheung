package cn.chiucheung.po.engineering.standardbom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EngStandardBomSubsidiaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EngStandardBomSubsidiaryExample() {
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

        public Criteria andSerialNumberEqualTo(Integer value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(Integer value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(Integer value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(Integer value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(Integer value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<Integer> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<Integer> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(Integer value1, Integer value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
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

        public Criteria andEngStandardBomIdIsNull() {
            addCriterion("eng_standard_bom_id is null");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdIsNotNull() {
            addCriterion("eng_standard_bom_id is not null");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdEqualTo(String value) {
            addCriterion("eng_standard_bom_id =", value, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdNotEqualTo(String value) {
            addCriterion("eng_standard_bom_id <>", value, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdGreaterThan(String value) {
            addCriterion("eng_standard_bom_id >", value, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdGreaterThanOrEqualTo(String value) {
            addCriterion("eng_standard_bom_id >=", value, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdLessThan(String value) {
            addCriterion("eng_standard_bom_id <", value, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdLessThanOrEqualTo(String value) {
            addCriterion("eng_standard_bom_id <=", value, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdLike(String value) {
            addCriterion("eng_standard_bom_id like", value, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdNotLike(String value) {
            addCriterion("eng_standard_bom_id not like", value, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdIn(List<String> values) {
            addCriterion("eng_standard_bom_id in", values, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdNotIn(List<String> values) {
            addCriterion("eng_standard_bom_id not in", values, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdBetween(String value1, String value2) {
            addCriterion("eng_standard_bom_id between", value1, value2, "engStandardBomId");
            return (Criteria) this;
        }

        public Criteria andEngStandardBomIdNotBetween(String value1, String value2) {
            addCriterion("eng_standard_bom_id not between", value1, value2, "engStandardBomId");
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