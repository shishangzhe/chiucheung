package cn.chiucheung.po.system.dictionarie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysDictionarieExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDictionarieExample() {
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

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeIsNull() {
            addCriterion("dictionarie_code is null");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeIsNotNull() {
            addCriterion("dictionarie_code is not null");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeEqualTo(Integer value) {
            addCriterion("dictionarie_code =", value, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeNotEqualTo(Integer value) {
            addCriterion("dictionarie_code <>", value, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeGreaterThan(Integer value) {
            addCriterion("dictionarie_code >", value, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dictionarie_code >=", value, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeLessThan(Integer value) {
            addCriterion("dictionarie_code <", value, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeLessThanOrEqualTo(Integer value) {
            addCriterion("dictionarie_code <=", value, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeIn(List<Integer> values) {
            addCriterion("dictionarie_code in", values, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeNotIn(List<Integer> values) {
            addCriterion("dictionarie_code not in", values, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeBetween(Integer value1, Integer value2) {
            addCriterion("dictionarie_code between", value1, value2, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("dictionarie_code not between", value1, value2, "dictionarieCode");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameIsNull() {
            addCriterion("dictionarie_name is null");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameIsNotNull() {
            addCriterion("dictionarie_name is not null");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameEqualTo(String value) {
            addCriterion("dictionarie_name =", value, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameNotEqualTo(String value) {
            addCriterion("dictionarie_name <>", value, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameGreaterThan(String value) {
            addCriterion("dictionarie_name >", value, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameGreaterThanOrEqualTo(String value) {
            addCriterion("dictionarie_name >=", value, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameLessThan(String value) {
            addCriterion("dictionarie_name <", value, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameLessThanOrEqualTo(String value) {
            addCriterion("dictionarie_name <=", value, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameLike(String value) {
            addCriterion("dictionarie_name like", value, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameNotLike(String value) {
            addCriterion("dictionarie_name not like", value, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameIn(List<String> values) {
            addCriterion("dictionarie_name in", values, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameNotIn(List<String> values) {
            addCriterion("dictionarie_name not in", values, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameBetween(String value1, String value2) {
            addCriterion("dictionarie_name between", value1, value2, "dictionarieName");
            return (Criteria) this;
        }

        public Criteria andDictionarieNameNotBetween(String value1, String value2) {
            addCriterion("dictionarie_name not between", value1, value2, "dictionarieName");
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