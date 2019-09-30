package cn.chiucheung.po.sales.reviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SalReviewerSubsidiaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalReviewerSubsidiaryExample() {
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

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductModelIsNull() {
            addCriterion("product_model is null");
            return (Criteria) this;
        }

        public Criteria andProductModelIsNotNull() {
            addCriterion("product_model is not null");
            return (Criteria) this;
        }

        public Criteria andProductModelEqualTo(String value) {
            addCriterion("product_model =", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotEqualTo(String value) {
            addCriterion("product_model <>", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelGreaterThan(String value) {
            addCriterion("product_model >", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelGreaterThanOrEqualTo(String value) {
            addCriterion("product_model >=", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelLessThan(String value) {
            addCriterion("product_model <", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelLessThanOrEqualTo(String value) {
            addCriterion("product_model <=", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelLike(String value) {
            addCriterion("product_model like", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotLike(String value) {
            addCriterion("product_model not like", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelIn(List<String> values) {
            addCriterion("product_model in", values, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotIn(List<String> values) {
            addCriterion("product_model not in", values, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelBetween(String value1, String value2) {
            addCriterion("product_model between", value1, value2, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotBetween(String value1, String value2) {
            addCriterion("product_model not between", value1, value2, "productModel");
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

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
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

        public Criteria andEngLeaderIsNull() {
            addCriterion("eng_leader is null");
            return (Criteria) this;
        }

        public Criteria andEngLeaderIsNotNull() {
            addCriterion("eng_leader is not null");
            return (Criteria) this;
        }

        public Criteria andEngLeaderEqualTo(String value) {
            addCriterion("eng_leader =", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderNotEqualTo(String value) {
            addCriterion("eng_leader <>", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderGreaterThan(String value) {
            addCriterion("eng_leader >", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("eng_leader >=", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderLessThan(String value) {
            addCriterion("eng_leader <", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderLessThanOrEqualTo(String value) {
            addCriterion("eng_leader <=", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderLike(String value) {
            addCriterion("eng_leader like", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderNotLike(String value) {
            addCriterion("eng_leader not like", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderIn(List<String> values) {
            addCriterion("eng_leader in", values, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderNotIn(List<String> values) {
            addCriterion("eng_leader not in", values, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderBetween(String value1, String value2) {
            addCriterion("eng_leader between", value1, value2, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderNotBetween(String value1, String value2) {
            addCriterion("eng_leader not between", value1, value2, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeIsNull() {
            addCriterion("eng_actual_need_time is null");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeIsNotNull() {
            addCriterion("eng_actual_need_time is not null");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeEqualTo(String value) {
            addCriterion("eng_actual_need_time =", value, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeNotEqualTo(String value) {
            addCriterion("eng_actual_need_time <>", value, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeGreaterThan(String value) {
            addCriterion("eng_actual_need_time >", value, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("eng_actual_need_time >=", value, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeLessThan(String value) {
            addCriterion("eng_actual_need_time <", value, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeLessThanOrEqualTo(String value) {
            addCriterion("eng_actual_need_time <=", value, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeLike(String value) {
            addCriterion("eng_actual_need_time like", value, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeNotLike(String value) {
            addCriterion("eng_actual_need_time not like", value, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeIn(List<String> values) {
            addCriterion("eng_actual_need_time in", values, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeNotIn(List<String> values) {
            addCriterion("eng_actual_need_time not in", values, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeBetween(String value1, String value2) {
            addCriterion("eng_actual_need_time between", value1, value2, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngActualNeedTimeNotBetween(String value1, String value2) {
            addCriterion("eng_actual_need_time not between", value1, value2, "engActualNeedTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeIsNull() {
            addCriterion("eng_expected_start_time is null");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeIsNotNull() {
            addCriterion("eng_expected_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_start_time =", value, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_start_time <>", value, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("eng_expected_start_time >", value, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_start_time >=", value, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("eng_expected_start_time <", value, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_start_time <=", value, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("eng_expected_start_time in", values, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("eng_expected_start_time not in", values, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_expected_start_time between", value1, value2, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_expected_start_time not between", value1, value2, "engExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeIsNull() {
            addCriterion("eng_expected_shortest_completion_time is null");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeIsNotNull() {
            addCriterion("eng_expected_shortest_completion_time is not null");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time =", value, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time <>", value, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time >", value, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time >=", value, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeLessThan(Date value) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time <", value, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time <=", value, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeIn(List<Date> values) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time in", values, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time not in", values, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time between", value1, value2, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedShortestCompletionTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_expected_shortest_completion_time not between", value1, value2, "engExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeIsNull() {
            addCriterion("eng_expected_longest_completion_time is null");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeIsNotNull() {
            addCriterion("eng_expected_longest_completion_time is not null");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time =", value, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time <>", value, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time >", value, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time >=", value, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeLessThan(Date value) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time <", value, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time <=", value, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeIn(List<Date> values) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time in", values, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time not in", values, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time between", value1, value2, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andEngExpectedLongestCompletionTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_expected_longest_completion_time not between", value1, value2, "engExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdIsNull() {
            addCriterion("sal_reviewer_id is null");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdIsNotNull() {
            addCriterion("sal_reviewer_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdEqualTo(String value) {
            addCriterion("sal_reviewer_id =", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdNotEqualTo(String value) {
            addCriterion("sal_reviewer_id <>", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdGreaterThan(String value) {
            addCriterion("sal_reviewer_id >", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdGreaterThanOrEqualTo(String value) {
            addCriterion("sal_reviewer_id >=", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdLessThan(String value) {
            addCriterion("sal_reviewer_id <", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdLessThanOrEqualTo(String value) {
            addCriterion("sal_reviewer_id <=", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdLike(String value) {
            addCriterion("sal_reviewer_id like", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdNotLike(String value) {
            addCriterion("sal_reviewer_id not like", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdIn(List<String> values) {
            addCriterion("sal_reviewer_id in", values, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdNotIn(List<String> values) {
            addCriterion("sal_reviewer_id not in", values, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdBetween(String value1, String value2) {
            addCriterion("sal_reviewer_id between", value1, value2, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdNotBetween(String value1, String value2) {
            addCriterion("sal_reviewer_id not between", value1, value2, "salReviewerId");
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