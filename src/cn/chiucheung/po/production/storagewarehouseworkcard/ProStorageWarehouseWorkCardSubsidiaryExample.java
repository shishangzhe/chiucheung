package cn.chiucheung.po.production.storagewarehouseworkcard;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProStorageWarehouseWorkCardSubsidiaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProStorageWarehouseWorkCardSubsidiaryExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysIsNull() {
            addCriterion("previous_days is null");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysIsNotNull() {
            addCriterion("previous_days is not null");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysEqualTo(Integer value) {
            addCriterion("previous_days =", value, "previousDays");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysNotEqualTo(Integer value) {
            addCriterion("previous_days <>", value, "previousDays");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysGreaterThan(Integer value) {
            addCriterion("previous_days >", value, "previousDays");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("previous_days >=", value, "previousDays");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysLessThan(Integer value) {
            addCriterion("previous_days <", value, "previousDays");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysLessThanOrEqualTo(Integer value) {
            addCriterion("previous_days <=", value, "previousDays");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysIn(List<Integer> values) {
            addCriterion("previous_days in", values, "previousDays");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysNotIn(List<Integer> values) {
            addCriterion("previous_days not in", values, "previousDays");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysBetween(Integer value1, Integer value2) {
            addCriterion("previous_days between", value1, value2, "previousDays");
            return (Criteria) this;
        }

        public Criteria andPreviousDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("previous_days not between", value1, value2, "previousDays");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateIsNull() {
            addCriterion("expected_delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateIsNotNull() {
            addCriterion("expected_delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateEqualTo(Date value) {
            addCriterionForJDBCDate("expected_delivery_date =", value, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expected_delivery_date <>", value, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateGreaterThan(Date value) {
            addCriterionForJDBCDate("expected_delivery_date >", value, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expected_delivery_date >=", value, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateLessThan(Date value) {
            addCriterionForJDBCDate("expected_delivery_date <", value, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expected_delivery_date <=", value, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateIn(List<Date> values) {
            addCriterionForJDBCDate("expected_delivery_date in", values, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expected_delivery_date not in", values, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expected_delivery_date between", value1, value2, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expected_delivery_date not between", value1, value2, "expectedDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateIsNull() {
            addCriterion("eng_release_data_date is null");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateIsNotNull() {
            addCriterion("eng_release_data_date is not null");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateEqualTo(Date value) {
            addCriterionForJDBCDate("eng_release_data_date =", value, "engReleaseDataDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("eng_release_data_date <>", value, "engReleaseDataDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateGreaterThan(Date value) {
            addCriterionForJDBCDate("eng_release_data_date >", value, "engReleaseDataDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_release_data_date >=", value, "engReleaseDataDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateLessThan(Date value) {
            addCriterionForJDBCDate("eng_release_data_date <", value, "engReleaseDataDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_release_data_date <=", value, "engReleaseDataDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateIn(List<Date> values) {
            addCriterionForJDBCDate("eng_release_data_date in", values, "engReleaseDataDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("eng_release_data_date not in", values, "engReleaseDataDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_release_data_date between", value1, value2, "engReleaseDataDate");
            return (Criteria) this;
        }

        public Criteria andEngReleaseDataDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_release_data_date not between", value1, value2, "engReleaseDataDate");
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

        public Criteria andProStorageWarehouseWorkCardIdIsNull() {
            addCriterion("pro_storage_warehouse_work_card_id is null");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdIsNotNull() {
            addCriterion("pro_storage_warehouse_work_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdEqualTo(String value) {
            addCriterion("pro_storage_warehouse_work_card_id =", value, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdNotEqualTo(String value) {
            addCriterion("pro_storage_warehouse_work_card_id <>", value, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdGreaterThan(String value) {
            addCriterion("pro_storage_warehouse_work_card_id >", value, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_storage_warehouse_work_card_id >=", value, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdLessThan(String value) {
            addCriterion("pro_storage_warehouse_work_card_id <", value, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdLessThanOrEqualTo(String value) {
            addCriterion("pro_storage_warehouse_work_card_id <=", value, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdLike(String value) {
            addCriterion("pro_storage_warehouse_work_card_id like", value, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdNotLike(String value) {
            addCriterion("pro_storage_warehouse_work_card_id not like", value, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdIn(List<String> values) {
            addCriterion("pro_storage_warehouse_work_card_id in", values, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdNotIn(List<String> values) {
            addCriterion("pro_storage_warehouse_work_card_id not in", values, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdBetween(String value1, String value2) {
            addCriterion("pro_storage_warehouse_work_card_id between", value1, value2, "proStorageWarehouseWorkCardId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardIdNotBetween(String value1, String value2) {
            addCriterion("pro_storage_warehouse_work_card_id not between", value1, value2, "proStorageWarehouseWorkCardId");
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