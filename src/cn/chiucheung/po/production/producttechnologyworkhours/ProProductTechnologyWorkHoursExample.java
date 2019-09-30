package cn.chiucheung.po.production.producttechnologyworkhours;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProProductTechnologyWorkHoursExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProProductTechnologyWorkHoursExample() {
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

        public Criteria andProcessCoefficientIsNull() {
            addCriterion("process_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientIsNotNull() {
            addCriterion("process_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientEqualTo(BigDecimal value) {
            addCriterion("process_coefficient =", value, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("process_coefficient <>", value, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientGreaterThan(BigDecimal value) {
            addCriterion("process_coefficient >", value, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("process_coefficient >=", value, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientLessThan(BigDecimal value) {
            addCriterion("process_coefficient <", value, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("process_coefficient <=", value, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientIn(List<BigDecimal> values) {
            addCriterion("process_coefficient in", values, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("process_coefficient not in", values, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("process_coefficient between", value1, value2, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andProcessCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("process_coefficient not between", value1, value2, "processCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientIsNull() {
            addCriterion("accessories_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientIsNotNull() {
            addCriterion("accessories_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientEqualTo(BigDecimal value) {
            addCriterion("accessories_coefficient =", value, "accessoriesCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("accessories_coefficient <>", value, "accessoriesCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientGreaterThan(BigDecimal value) {
            addCriterion("accessories_coefficient >", value, "accessoriesCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accessories_coefficient >=", value, "accessoriesCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientLessThan(BigDecimal value) {
            addCriterion("accessories_coefficient <", value, "accessoriesCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accessories_coefficient <=", value, "accessoriesCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientIn(List<BigDecimal> values) {
            addCriterion("accessories_coefficient in", values, "accessoriesCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("accessories_coefficient not in", values, "accessoriesCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accessories_coefficient between", value1, value2, "accessoriesCoefficient");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accessories_coefficient not between", value1, value2, "accessoriesCoefficient");
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

        public Criteria andTotalArtificialTimeIsNull() {
            addCriterion("total_artificial_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeIsNotNull() {
            addCriterion("total_artificial_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeEqualTo(BigDecimal value) {
            addCriterion("total_artificial_time =", value, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeNotEqualTo(BigDecimal value) {
            addCriterion("total_artificial_time <>", value, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeGreaterThan(BigDecimal value) {
            addCriterion("total_artificial_time >", value, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_artificial_time >=", value, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeLessThan(BigDecimal value) {
            addCriterion("total_artificial_time <", value, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_artificial_time <=", value, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeIn(List<BigDecimal> values) {
            addCriterion("total_artificial_time in", values, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeNotIn(List<BigDecimal> values) {
            addCriterion("total_artificial_time not in", values, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_artificial_time between", value1, value2, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andTotalArtificialTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_artificial_time not between", value1, value2, "totalArtificialTime");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdIsNull() {
            addCriterion("war_standard_accessories_id is null");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdIsNotNull() {
            addCriterion("war_standard_accessories_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdEqualTo(String value) {
            addCriterion("war_standard_accessories_id =", value, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdNotEqualTo(String value) {
            addCriterion("war_standard_accessories_id <>", value, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdGreaterThan(String value) {
            addCriterion("war_standard_accessories_id >", value, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdGreaterThanOrEqualTo(String value) {
            addCriterion("war_standard_accessories_id >=", value, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdLessThan(String value) {
            addCriterion("war_standard_accessories_id <", value, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdLessThanOrEqualTo(String value) {
            addCriterion("war_standard_accessories_id <=", value, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdLike(String value) {
            addCriterion("war_standard_accessories_id like", value, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdNotLike(String value) {
            addCriterion("war_standard_accessories_id not like", value, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdIn(List<String> values) {
            addCriterion("war_standard_accessories_id in", values, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdNotIn(List<String> values) {
            addCriterion("war_standard_accessories_id not in", values, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdBetween(String value1, String value2) {
            addCriterion("war_standard_accessories_id between", value1, value2, "warStandardAccessoriesId");
            return (Criteria) this;
        }

        public Criteria andWarStandardAccessoriesIdNotBetween(String value1, String value2) {
            addCriterion("war_standard_accessories_id not between", value1, value2, "warStandardAccessoriesId");
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