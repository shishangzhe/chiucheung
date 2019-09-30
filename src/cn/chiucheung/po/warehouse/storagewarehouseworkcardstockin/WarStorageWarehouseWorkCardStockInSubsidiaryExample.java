package cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin;

import java.util.ArrayList;
import java.util.List;

public class WarStorageWarehouseWorkCardStockInSubsidiaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarStorageWarehouseWorkCardStockInSubsidiaryExample() {
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

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdIsNull() {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id is null");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdIsNotNull() {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id is not null");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdEqualTo(String value) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id =", value, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdNotEqualTo(String value) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id <>", value, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdGreaterThan(String value) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id >", value, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id >=", value, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdLessThan(String value) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id <", value, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdLessThanOrEqualTo(String value) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id <=", value, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdLike(String value) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id like", value, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdNotLike(String value) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id not like", value, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdIn(List<String> values) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id in", values, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdNotIn(List<String> values) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id not in", values, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdBetween(String value1, String value2) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id between", value1, value2, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andProStorageWarehouseWorkCardSubsidiaryIdNotBetween(String value1, String value2) {
            addCriterion("pro_storage_warehouse_work_card_subsidiary_id not between", value1, value2, "proStorageWarehouseWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdIsNull() {
            addCriterion("war_storage_warehouse_work_card_stock_in_id is null");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdIsNotNull() {
            addCriterion("war_storage_warehouse_work_card_stock_in_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdEqualTo(String value) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id =", value, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdNotEqualTo(String value) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id <>", value, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdGreaterThan(String value) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id >", value, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdGreaterThanOrEqualTo(String value) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id >=", value, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdLessThan(String value) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id <", value, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdLessThanOrEqualTo(String value) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id <=", value, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdLike(String value) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id like", value, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdNotLike(String value) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id not like", value, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdIn(List<String> values) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id in", values, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdNotIn(List<String> values) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id not in", values, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdBetween(String value1, String value2) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id between", value1, value2, "warStorageWarehouseWorkCardStockInId");
            return (Criteria) this;
        }

        public Criteria andWarStorageWarehouseWorkCardStockInIdNotBetween(String value1, String value2) {
            addCriterion("war_storage_warehouse_work_card_stock_in_id not between", value1, value2, "warStorageWarehouseWorkCardStockInId");
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