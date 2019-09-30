package cn.chiucheung.po.logistics.travelspendingrecords;

import java.util.ArrayList;
import java.util.List;

public class LogTravelTrafficSpendingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogTravelTrafficSpendingExample() {
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

        public Criteria andStartPointIsNull() {
            addCriterion("start_point is null");
            return (Criteria) this;
        }

        public Criteria andStartPointIsNotNull() {
            addCriterion("start_point is not null");
            return (Criteria) this;
        }

        public Criteria andStartPointEqualTo(String value) {
            addCriterion("start_point =", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointNotEqualTo(String value) {
            addCriterion("start_point <>", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointGreaterThan(String value) {
            addCriterion("start_point >", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointGreaterThanOrEqualTo(String value) {
            addCriterion("start_point >=", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointLessThan(String value) {
            addCriterion("start_point <", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointLessThanOrEqualTo(String value) {
            addCriterion("start_point <=", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointLike(String value) {
            addCriterion("start_point like", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointNotLike(String value) {
            addCriterion("start_point not like", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointIn(List<String> values) {
            addCriterion("start_point in", values, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointNotIn(List<String> values) {
            addCriterion("start_point not in", values, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointBetween(String value1, String value2) {
            addCriterion("start_point between", value1, value2, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointNotBetween(String value1, String value2) {
            addCriterion("start_point not between", value1, value2, "startPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointIsNull() {
            addCriterion("end_point is null");
            return (Criteria) this;
        }

        public Criteria andEndPointIsNotNull() {
            addCriterion("end_point is not null");
            return (Criteria) this;
        }

        public Criteria andEndPointEqualTo(String value) {
            addCriterion("end_point =", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointNotEqualTo(String value) {
            addCriterion("end_point <>", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointGreaterThan(String value) {
            addCriterion("end_point >", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointGreaterThanOrEqualTo(String value) {
            addCriterion("end_point >=", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointLessThan(String value) {
            addCriterion("end_point <", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointLessThanOrEqualTo(String value) {
            addCriterion("end_point <=", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointLike(String value) {
            addCriterion("end_point like", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointNotLike(String value) {
            addCriterion("end_point not like", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointIn(List<String> values) {
            addCriterion("end_point in", values, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointNotIn(List<String> values) {
            addCriterion("end_point not in", values, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointBetween(String value1, String value2) {
            addCriterion("end_point between", value1, value2, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointNotBetween(String value1, String value2) {
            addCriterion("end_point not between", value1, value2, "endPoint");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeIsNull() {
            addCriterion("traffic_type is null");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeIsNotNull() {
            addCriterion("traffic_type is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeEqualTo(String value) {
            addCriterion("traffic_type =", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotEqualTo(String value) {
            addCriterion("traffic_type <>", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeGreaterThan(String value) {
            addCriterion("traffic_type >", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeGreaterThanOrEqualTo(String value) {
            addCriterion("traffic_type >=", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeLessThan(String value) {
            addCriterion("traffic_type <", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeLessThanOrEqualTo(String value) {
            addCriterion("traffic_type <=", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeLike(String value) {
            addCriterion("traffic_type like", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotLike(String value) {
            addCriterion("traffic_type not like", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeIn(List<String> values) {
            addCriterion("traffic_type in", values, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotIn(List<String> values) {
            addCriterion("traffic_type not in", values, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeBetween(String value1, String value2) {
            addCriterion("traffic_type between", value1, value2, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotBetween(String value1, String value2) {
            addCriterion("traffic_type not between", value1, value2, "trafficType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(String value) {
            addCriterion("invoice_type =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(String value) {
            addCriterion("invoice_type <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(String value) {
            addCriterion("invoice_type >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_type >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(String value) {
            addCriterion("invoice_type <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(String value) {
            addCriterion("invoice_type <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLike(String value) {
            addCriterion("invoice_type like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotLike(String value) {
            addCriterion("invoice_type not like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<String> values) {
            addCriterion("invoice_type in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<String> values) {
            addCriterion("invoice_type not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(String value1, String value2) {
            addCriterion("invoice_type between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(String value1, String value2) {
            addCriterion("invoice_type not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdIsNull() {
            addCriterion("log_travel_spending_records_id is null");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdIsNotNull() {
            addCriterion("log_travel_spending_records_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdEqualTo(String value) {
            addCriterion("log_travel_spending_records_id =", value, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdNotEqualTo(String value) {
            addCriterion("log_travel_spending_records_id <>", value, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdGreaterThan(String value) {
            addCriterion("log_travel_spending_records_id >", value, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdGreaterThanOrEqualTo(String value) {
            addCriterion("log_travel_spending_records_id >=", value, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdLessThan(String value) {
            addCriterion("log_travel_spending_records_id <", value, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdLessThanOrEqualTo(String value) {
            addCriterion("log_travel_spending_records_id <=", value, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdLike(String value) {
            addCriterion("log_travel_spending_records_id like", value, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdNotLike(String value) {
            addCriterion("log_travel_spending_records_id not like", value, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdIn(List<String> values) {
            addCriterion("log_travel_spending_records_id in", values, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdNotIn(List<String> values) {
            addCriterion("log_travel_spending_records_id not in", values, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdBetween(String value1, String value2) {
            addCriterion("log_travel_spending_records_id between", value1, value2, "logTravelSpendingRecordsId");
            return (Criteria) this;
        }

        public Criteria andLogTravelSpendingRecordsIdNotBetween(String value1, String value2) {
            addCriterion("log_travel_spending_records_id not between", value1, value2, "logTravelSpendingRecordsId");
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