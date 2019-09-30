package cn.chiucheung.po.production.standard;

import java.util.ArrayList;
import java.util.List;

public class ProTechnologyWorkHoursBasicDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProTechnologyWorkHoursBasicDataExample() {
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

        public Criteria andTechnologyDescriptionIsNull() {
            addCriterion("technology_description is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionIsNotNull() {
            addCriterion("technology_description is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionEqualTo(String value) {
            addCriterion("technology_description =", value, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionNotEqualTo(String value) {
            addCriterion("technology_description <>", value, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionGreaterThan(String value) {
            addCriterion("technology_description >", value, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("technology_description >=", value, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionLessThan(String value) {
            addCriterion("technology_description <", value, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionLessThanOrEqualTo(String value) {
            addCriterion("technology_description <=", value, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionLike(String value) {
            addCriterion("technology_description like", value, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionNotLike(String value) {
            addCriterion("technology_description not like", value, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionIn(List<String> values) {
            addCriterion("technology_description in", values, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionNotIn(List<String> values) {
            addCriterion("technology_description not in", values, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionBetween(String value1, String value2) {
            addCriterion("technology_description between", value1, value2, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyDescriptionNotBetween(String value1, String value2) {
            addCriterion("technology_description not between", value1, value2, "technologyDescription");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeIsNull() {
            addCriterion("technology_time is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeIsNotNull() {
            addCriterion("technology_time is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeEqualTo(Integer value) {
            addCriterion("technology_time =", value, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeNotEqualTo(Integer value) {
            addCriterion("technology_time <>", value, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeGreaterThan(Integer value) {
            addCriterion("technology_time >", value, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("technology_time >=", value, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeLessThan(Integer value) {
            addCriterion("technology_time <", value, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeLessThanOrEqualTo(Integer value) {
            addCriterion("technology_time <=", value, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeIn(List<Integer> values) {
            addCriterion("technology_time in", values, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeNotIn(List<Integer> values) {
            addCriterion("technology_time not in", values, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeBetween(Integer value1, Integer value2) {
            addCriterion("technology_time between", value1, value2, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andTechnologyTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("technology_time not between", value1, value2, "technologyTime");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdIsNull() {
            addCriterion("pro_technology_basic_data_id is null");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdIsNotNull() {
            addCriterion("pro_technology_basic_data_id is not null");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdEqualTo(String value) {
            addCriterion("pro_technology_basic_data_id =", value, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdNotEqualTo(String value) {
            addCriterion("pro_technology_basic_data_id <>", value, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdGreaterThan(String value) {
            addCriterion("pro_technology_basic_data_id >", value, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_technology_basic_data_id >=", value, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdLessThan(String value) {
            addCriterion("pro_technology_basic_data_id <", value, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdLessThanOrEqualTo(String value) {
            addCriterion("pro_technology_basic_data_id <=", value, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdLike(String value) {
            addCriterion("pro_technology_basic_data_id like", value, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdNotLike(String value) {
            addCriterion("pro_technology_basic_data_id not like", value, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdIn(List<String> values) {
            addCriterion("pro_technology_basic_data_id in", values, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdNotIn(List<String> values) {
            addCriterion("pro_technology_basic_data_id not in", values, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdBetween(String value1, String value2) {
            addCriterion("pro_technology_basic_data_id between", value1, value2, "proTechnologyBasicDataId");
            return (Criteria) this;
        }

        public Criteria andProTechnologyBasicDataIdNotBetween(String value1, String value2) {
            addCriterion("pro_technology_basic_data_id not between", value1, value2, "proTechnologyBasicDataId");
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