package cn.chiucheung.po.sales.workcard;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SalWorkCardSubsidiaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalWorkCardSubsidiaryExample() {
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

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
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

        public Criteria andProPeriodIsNull() {
            addCriterion("pro_period is null");
            return (Criteria) this;
        }

        public Criteria andProPeriodIsNotNull() {
            addCriterion("pro_period is not null");
            return (Criteria) this;
        }

        public Criteria andProPeriodEqualTo(String value) {
            addCriterion("pro_period =", value, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodNotEqualTo(String value) {
            addCriterion("pro_period <>", value, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodGreaterThan(String value) {
            addCriterion("pro_period >", value, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("pro_period >=", value, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodLessThan(String value) {
            addCriterion("pro_period <", value, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodLessThanOrEqualTo(String value) {
            addCriterion("pro_period <=", value, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodLike(String value) {
            addCriterion("pro_period like", value, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodNotLike(String value) {
            addCriterion("pro_period not like", value, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodIn(List<String> values) {
            addCriterion("pro_period in", values, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodNotIn(List<String> values) {
            addCriterion("pro_period not in", values, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodBetween(String value1, String value2) {
            addCriterion("pro_period between", value1, value2, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andProPeriodNotBetween(String value1, String value2) {
            addCriterion("pro_period not between", value1, value2, "proPeriod");
            return (Criteria) this;
        }

        public Criteria andConfirmationIsNull() {
            addCriterion("confirmation is null");
            return (Criteria) this;
        }

        public Criteria andConfirmationIsNotNull() {
            addCriterion("confirmation is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmationEqualTo(String value) {
            addCriterion("confirmation =", value, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationNotEqualTo(String value) {
            addCriterion("confirmation <>", value, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationGreaterThan(String value) {
            addCriterion("confirmation >", value, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationGreaterThanOrEqualTo(String value) {
            addCriterion("confirmation >=", value, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationLessThan(String value) {
            addCriterion("confirmation <", value, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationLessThanOrEqualTo(String value) {
            addCriterion("confirmation <=", value, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationLike(String value) {
            addCriterion("confirmation like", value, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationNotLike(String value) {
            addCriterion("confirmation not like", value, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationIn(List<String> values) {
            addCriterion("confirmation in", values, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationNotIn(List<String> values) {
            addCriterion("confirmation not in", values, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationBetween(String value1, String value2) {
            addCriterion("confirmation between", value1, value2, "confirmation");
            return (Criteria) this;
        }

        public Criteria andConfirmationNotBetween(String value1, String value2) {
            addCriterion("confirmation not between", value1, value2, "confirmation");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdIsNull() {
            addCriterion("sal_reviewer_subsidiary_id is null");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdIsNotNull() {
            addCriterion("sal_reviewer_subsidiary_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdEqualTo(String value) {
            addCriterion("sal_reviewer_subsidiary_id =", value, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdNotEqualTo(String value) {
            addCriterion("sal_reviewer_subsidiary_id <>", value, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdGreaterThan(String value) {
            addCriterion("sal_reviewer_subsidiary_id >", value, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("sal_reviewer_subsidiary_id >=", value, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdLessThan(String value) {
            addCriterion("sal_reviewer_subsidiary_id <", value, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdLessThanOrEqualTo(String value) {
            addCriterion("sal_reviewer_subsidiary_id <=", value, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdLike(String value) {
            addCriterion("sal_reviewer_subsidiary_id like", value, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdNotLike(String value) {
            addCriterion("sal_reviewer_subsidiary_id not like", value, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdIn(List<String> values) {
            addCriterion("sal_reviewer_subsidiary_id in", values, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdNotIn(List<String> values) {
            addCriterion("sal_reviewer_subsidiary_id not in", values, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdBetween(String value1, String value2) {
            addCriterion("sal_reviewer_subsidiary_id between", value1, value2, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerSubsidiaryIdNotBetween(String value1, String value2) {
            addCriterion("sal_reviewer_subsidiary_id not between", value1, value2, "salReviewerSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdIsNull() {
            addCriterion("sal_work_card_id is null");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdIsNotNull() {
            addCriterion("sal_work_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdEqualTo(String value) {
            addCriterion("sal_work_card_id =", value, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdNotEqualTo(String value) {
            addCriterion("sal_work_card_id <>", value, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdGreaterThan(String value) {
            addCriterion("sal_work_card_id >", value, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("sal_work_card_id >=", value, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdLessThan(String value) {
            addCriterion("sal_work_card_id <", value, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdLessThanOrEqualTo(String value) {
            addCriterion("sal_work_card_id <=", value, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdLike(String value) {
            addCriterion("sal_work_card_id like", value, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdNotLike(String value) {
            addCriterion("sal_work_card_id not like", value, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdIn(List<String> values) {
            addCriterion("sal_work_card_id in", values, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdNotIn(List<String> values) {
            addCriterion("sal_work_card_id not in", values, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdBetween(String value1, String value2) {
            addCriterion("sal_work_card_id between", value1, value2, "salWorkCardId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardIdNotBetween(String value1, String value2) {
            addCriterion("sal_work_card_id not between", value1, value2, "salWorkCardId");
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