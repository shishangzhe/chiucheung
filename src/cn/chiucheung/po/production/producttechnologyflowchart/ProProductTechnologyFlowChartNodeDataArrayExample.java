package cn.chiucheung.po.production.producttechnologyflowchart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProProductTechnologyFlowChartNodeDataArrayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProProductTechnologyFlowChartNodeDataArrayExample() {
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

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("key is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("key is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("key =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("key <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("key >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("key >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("key <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("key <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("key like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("key not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("key in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("key not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("key between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("key not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andLocIsNull() {
            addCriterion("loc is null");
            return (Criteria) this;
        }

        public Criteria andLocIsNotNull() {
            addCriterion("loc is not null");
            return (Criteria) this;
        }

        public Criteria andLocEqualTo(String value) {
            addCriterion("loc =", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotEqualTo(String value) {
            addCriterion("loc <>", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThan(String value) {
            addCriterion("loc >", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThanOrEqualTo(String value) {
            addCriterion("loc >=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThan(String value) {
            addCriterion("loc <", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThanOrEqualTo(String value) {
            addCriterion("loc <=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLike(String value) {
            addCriterion("loc like", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotLike(String value) {
            addCriterion("loc not like", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocIn(List<String> values) {
            addCriterion("loc in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotIn(List<String> values) {
            addCriterion("loc not in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocBetween(String value1, String value2) {
            addCriterion("loc between", value1, value2, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotBetween(String value1, String value2) {
            addCriterion("loc not between", value1, value2, "loc");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNull() {
            addCriterion("total_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNotNull() {
            addCriterion("total_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeEqualTo(BigDecimal value) {
            addCriterion("total_time =", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotEqualTo(BigDecimal value) {
            addCriterion("total_time <>", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThan(BigDecimal value) {
            addCriterion("total_time >", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_time >=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThan(BigDecimal value) {
            addCriterion("total_time <", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_time <=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIn(List<BigDecimal> values) {
            addCriterion("total_time in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotIn(List<BigDecimal> values) {
            addCriterion("total_time not in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_time between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_time not between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andProProcessIdIsNull() {
            addCriterion("pro_process_id is null");
            return (Criteria) this;
        }

        public Criteria andProProcessIdIsNotNull() {
            addCriterion("pro_process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProProcessIdEqualTo(String value) {
            addCriterion("pro_process_id =", value, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdNotEqualTo(String value) {
            addCriterion("pro_process_id <>", value, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdGreaterThan(String value) {
            addCriterion("pro_process_id >", value, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_process_id >=", value, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdLessThan(String value) {
            addCriterion("pro_process_id <", value, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdLessThanOrEqualTo(String value) {
            addCriterion("pro_process_id <=", value, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdLike(String value) {
            addCriterion("pro_process_id like", value, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdNotLike(String value) {
            addCriterion("pro_process_id not like", value, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdIn(List<String> values) {
            addCriterion("pro_process_id in", values, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdNotIn(List<String> values) {
            addCriterion("pro_process_id not in", values, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdBetween(String value1, String value2) {
            addCriterion("pro_process_id between", value1, value2, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProcessIdNotBetween(String value1, String value2) {
            addCriterion("pro_process_id not between", value1, value2, "proProcessId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdIsNull() {
            addCriterion("pro_product_technology_work_hours_id is null");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdIsNotNull() {
            addCriterion("pro_product_technology_work_hours_id is not null");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdEqualTo(String value) {
            addCriterion("pro_product_technology_work_hours_id =", value, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdNotEqualTo(String value) {
            addCriterion("pro_product_technology_work_hours_id <>", value, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdGreaterThan(String value) {
            addCriterion("pro_product_technology_work_hours_id >", value, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_product_technology_work_hours_id >=", value, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdLessThan(String value) {
            addCriterion("pro_product_technology_work_hours_id <", value, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdLessThanOrEqualTo(String value) {
            addCriterion("pro_product_technology_work_hours_id <=", value, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdLike(String value) {
            addCriterion("pro_product_technology_work_hours_id like", value, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdNotLike(String value) {
            addCriterion("pro_product_technology_work_hours_id not like", value, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdIn(List<String> values) {
            addCriterion("pro_product_technology_work_hours_id in", values, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdNotIn(List<String> values) {
            addCriterion("pro_product_technology_work_hours_id not in", values, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdBetween(String value1, String value2) {
            addCriterion("pro_product_technology_work_hours_id between", value1, value2, "proProductTechnologyWorkHoursId");
            return (Criteria) this;
        }

        public Criteria andProProductTechnologyWorkHoursIdNotBetween(String value1, String value2) {
            addCriterion("pro_product_technology_work_hours_id not between", value1, value2, "proProductTechnologyWorkHoursId");
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