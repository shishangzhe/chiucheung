package cn.chiucheung.po.engineering.standardbom;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EngStandardBomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EngStandardBomExample() {
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andPreparerIsNull() {
            addCriterion("preparer is null");
            return (Criteria) this;
        }

        public Criteria andPreparerIsNotNull() {
            addCriterion("preparer is not null");
            return (Criteria) this;
        }

        public Criteria andPreparerEqualTo(String value) {
            addCriterion("preparer =", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotEqualTo(String value) {
            addCriterion("preparer <>", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerGreaterThan(String value) {
            addCriterion("preparer >", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerGreaterThanOrEqualTo(String value) {
            addCriterion("preparer >=", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerLessThan(String value) {
            addCriterion("preparer <", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerLessThanOrEqualTo(String value) {
            addCriterion("preparer <=", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerLike(String value) {
            addCriterion("preparer like", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotLike(String value) {
            addCriterion("preparer not like", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerIn(List<String> values) {
            addCriterion("preparer in", values, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotIn(List<String> values) {
            addCriterion("preparer not in", values, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerBetween(String value1, String value2) {
            addCriterion("preparer between", value1, value2, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotBetween(String value1, String value2) {
            addCriterion("preparer not between", value1, value2, "preparer");
            return (Criteria) this;
        }

        public Criteria andBomDateIsNull() {
            addCriterion("bom_date is null");
            return (Criteria) this;
        }

        public Criteria andBomDateIsNotNull() {
            addCriterion("bom_date is not null");
            return (Criteria) this;
        }

        public Criteria andBomDateEqualTo(Date value) {
            addCriterionForJDBCDate("bom_date =", value, "bomDate");
            return (Criteria) this;
        }

        public Criteria andBomDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("bom_date <>", value, "bomDate");
            return (Criteria) this;
        }

        public Criteria andBomDateGreaterThan(Date value) {
            addCriterionForJDBCDate("bom_date >", value, "bomDate");
            return (Criteria) this;
        }

        public Criteria andBomDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bom_date >=", value, "bomDate");
            return (Criteria) this;
        }

        public Criteria andBomDateLessThan(Date value) {
            addCriterionForJDBCDate("bom_date <", value, "bomDate");
            return (Criteria) this;
        }

        public Criteria andBomDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bom_date <=", value, "bomDate");
            return (Criteria) this;
        }

        public Criteria andBomDateIn(List<Date> values) {
            addCriterionForJDBCDate("bom_date in", values, "bomDate");
            return (Criteria) this;
        }

        public Criteria andBomDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("bom_date not in", values, "bomDate");
            return (Criteria) this;
        }

        public Criteria andBomDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bom_date between", value1, value2, "bomDate");
            return (Criteria) this;
        }

        public Criteria andBomDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bom_date not between", value1, value2, "bomDate");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNull() {
            addCriterion("process_instance_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNotNull() {
            addCriterion("process_instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdEqualTo(String value) {
            addCriterion("process_instance_id =", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotEqualTo(String value) {
            addCriterion("process_instance_id <>", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThan(String value) {
            addCriterion("process_instance_id >", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_instance_id >=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThan(String value) {
            addCriterion("process_instance_id <", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("process_instance_id <=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLike(String value) {
            addCriterion("process_instance_id like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotLike(String value) {
            addCriterion("process_instance_id not like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIn(List<String> values) {
            addCriterion("process_instance_id in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotIn(List<String> values) {
            addCriterion("process_instance_id not in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdBetween(String value1, String value2) {
            addCriterion("process_instance_id between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotBetween(String value1, String value2) {
            addCriterion("process_instance_id not between", value1, value2, "processInstanceId");
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