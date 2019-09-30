package cn.chiucheung.po.logistics.travelspendingrecords;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LogTravelSpendingRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogTravelSpendingRecordsExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andWorkCardNoIsNull() {
            addCriterion("work_card_no is null");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoIsNotNull() {
            addCriterion("work_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoEqualTo(String value) {
            addCriterion("work_card_no =", value, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoNotEqualTo(String value) {
            addCriterion("work_card_no <>", value, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoGreaterThan(String value) {
            addCriterion("work_card_no >", value, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("work_card_no >=", value, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoLessThan(String value) {
            addCriterion("work_card_no <", value, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoLessThanOrEqualTo(String value) {
            addCriterion("work_card_no <=", value, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoLike(String value) {
            addCriterion("work_card_no like", value, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoNotLike(String value) {
            addCriterion("work_card_no not like", value, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoIn(List<String> values) {
            addCriterion("work_card_no in", values, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoNotIn(List<String> values) {
            addCriterion("work_card_no not in", values, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoBetween(String value1, String value2) {
            addCriterion("work_card_no between", value1, value2, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andWorkCardNoNotBetween(String value1, String value2) {
            addCriterion("work_card_no not between", value1, value2, "workCardNo");
            return (Criteria) this;
        }

        public Criteria andIsAirpointIsNull() {
            addCriterion("is_airpoint is null");
            return (Criteria) this;
        }

        public Criteria andIsAirpointIsNotNull() {
            addCriterion("is_airpoint is not null");
            return (Criteria) this;
        }

        public Criteria andIsAirpointEqualTo(String value) {
            addCriterion("is_airpoint =", value, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointNotEqualTo(String value) {
            addCriterion("is_airpoint <>", value, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointGreaterThan(String value) {
            addCriterion("is_airpoint >", value, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointGreaterThanOrEqualTo(String value) {
            addCriterion("is_airpoint >=", value, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointLessThan(String value) {
            addCriterion("is_airpoint <", value, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointLessThanOrEqualTo(String value) {
            addCriterion("is_airpoint <=", value, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointLike(String value) {
            addCriterion("is_airpoint like", value, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointNotLike(String value) {
            addCriterion("is_airpoint not like", value, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointIn(List<String> values) {
            addCriterion("is_airpoint in", values, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointNotIn(List<String> values) {
            addCriterion("is_airpoint not in", values, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointBetween(String value1, String value2) {
            addCriterion("is_airpoint between", value1, value2, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andIsAirpointNotBetween(String value1, String value2) {
            addCriterion("is_airpoint not between", value1, value2, "isAirpoint");
            return (Criteria) this;
        }

        public Criteria andTravelDateIsNull() {
            addCriterion("travel_date is null");
            return (Criteria) this;
        }

        public Criteria andTravelDateIsNotNull() {
            addCriterion("travel_date is not null");
            return (Criteria) this;
        }

        public Criteria andTravelDateEqualTo(Date value) {
            addCriterionForJDBCDate("travel_date =", value, "travelDate");
            return (Criteria) this;
        }

        public Criteria andTravelDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("travel_date <>", value, "travelDate");
            return (Criteria) this;
        }

        public Criteria andTravelDateGreaterThan(Date value) {
            addCriterionForJDBCDate("travel_date >", value, "travelDate");
            return (Criteria) this;
        }

        public Criteria andTravelDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("travel_date >=", value, "travelDate");
            return (Criteria) this;
        }

        public Criteria andTravelDateLessThan(Date value) {
            addCriterionForJDBCDate("travel_date <", value, "travelDate");
            return (Criteria) this;
        }

        public Criteria andTravelDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("travel_date <=", value, "travelDate");
            return (Criteria) this;
        }

        public Criteria andTravelDateIn(List<Date> values) {
            addCriterionForJDBCDate("travel_date in", values, "travelDate");
            return (Criteria) this;
        }

        public Criteria andTravelDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("travel_date not in", values, "travelDate");
            return (Criteria) this;
        }

        public Criteria andTravelDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("travel_date between", value1, value2, "travelDate");
            return (Criteria) this;
        }

        public Criteria andTravelDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("travel_date not between", value1, value2, "travelDate");
            return (Criteria) this;
        }

        public Criteria andLiveNumberIsNull() {
            addCriterion("live_number is null");
            return (Criteria) this;
        }

        public Criteria andLiveNumberIsNotNull() {
            addCriterion("live_number is not null");
            return (Criteria) this;
        }

        public Criteria andLiveNumberEqualTo(Integer value) {
            addCriterion("live_number =", value, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLiveNumberNotEqualTo(Integer value) {
            addCriterion("live_number <>", value, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLiveNumberGreaterThan(Integer value) {
            addCriterion("live_number >", value, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLiveNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("live_number >=", value, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLiveNumberLessThan(Integer value) {
            addCriterion("live_number <", value, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLiveNumberLessThanOrEqualTo(Integer value) {
            addCriterion("live_number <=", value, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLiveNumberIn(List<Integer> values) {
            addCriterion("live_number in", values, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLiveNumberNotIn(List<Integer> values) {
            addCriterion("live_number not in", values, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLiveNumberBetween(Integer value1, Integer value2) {
            addCriterion("live_number between", value1, value2, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLiveNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("live_number not between", value1, value2, "liveNumber");
            return (Criteria) this;
        }

        public Criteria andLivePriceIsNull() {
            addCriterion("live_price is null");
            return (Criteria) this;
        }

        public Criteria andLivePriceIsNotNull() {
            addCriterion("live_price is not null");
            return (Criteria) this;
        }

        public Criteria andLivePriceEqualTo(Integer value) {
            addCriterion("live_price =", value, "livePrice");
            return (Criteria) this;
        }

        public Criteria andLivePriceNotEqualTo(Integer value) {
            addCriterion("live_price <>", value, "livePrice");
            return (Criteria) this;
        }

        public Criteria andLivePriceGreaterThan(Integer value) {
            addCriterion("live_price >", value, "livePrice");
            return (Criteria) this;
        }

        public Criteria andLivePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("live_price >=", value, "livePrice");
            return (Criteria) this;
        }

        public Criteria andLivePriceLessThan(Integer value) {
            addCriterion("live_price <", value, "livePrice");
            return (Criteria) this;
        }

        public Criteria andLivePriceLessThanOrEqualTo(Integer value) {
            addCriterion("live_price <=", value, "livePrice");
            return (Criteria) this;
        }

        public Criteria andLivePriceIn(List<Integer> values) {
            addCriterion("live_price in", values, "livePrice");
            return (Criteria) this;
        }

        public Criteria andLivePriceNotIn(List<Integer> values) {
            addCriterion("live_price not in", values, "livePrice");
            return (Criteria) this;
        }

        public Criteria andLivePriceBetween(Integer value1, Integer value2) {
            addCriterion("live_price between", value1, value2, "livePrice");
            return (Criteria) this;
        }

        public Criteria andLivePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("live_price not between", value1, value2, "livePrice");
            return (Criteria) this;
        }

        public Criteria andProvincesIsNull() {
            addCriterion("provinces is null");
            return (Criteria) this;
        }

        public Criteria andProvincesIsNotNull() {
            addCriterion("provinces is not null");
            return (Criteria) this;
        }

        public Criteria andProvincesEqualTo(String value) {
            addCriterion("provinces =", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesNotEqualTo(String value) {
            addCriterion("provinces <>", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesGreaterThan(String value) {
            addCriterion("provinces >", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesGreaterThanOrEqualTo(String value) {
            addCriterion("provinces >=", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesLessThan(String value) {
            addCriterion("provinces <", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesLessThanOrEqualTo(String value) {
            addCriterion("provinces <=", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesLike(String value) {
            addCriterion("provinces like", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesNotLike(String value) {
            addCriterion("provinces not like", value, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesIn(List<String> values) {
            addCriterion("provinces in", values, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesNotIn(List<String> values) {
            addCriterion("provinces not in", values, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesBetween(String value1, String value2) {
            addCriterion("provinces between", value1, value2, "provinces");
            return (Criteria) this;
        }

        public Criteria andProvincesNotBetween(String value1, String value2) {
            addCriterion("provinces not between", value1, value2, "provinces");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andStartTime1IsNull() {
            addCriterion("start_time1 is null");
            return (Criteria) this;
        }

        public Criteria andStartTime1IsNotNull() {
            addCriterion("start_time1 is not null");
            return (Criteria) this;
        }

        public Criteria andStartTime1EqualTo(Date value) {
            addCriterionForJDBCTime("start_time1 =", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1NotEqualTo(Date value) {
            addCriterionForJDBCTime("start_time1 <>", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1GreaterThan(Date value) {
            addCriterionForJDBCTime("start_time1 >", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("start_time1 >=", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1LessThan(Date value) {
            addCriterionForJDBCTime("start_time1 <", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1LessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("start_time1 <=", value, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1In(List<Date> values) {
            addCriterionForJDBCTime("start_time1 in", values, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1NotIn(List<Date> values) {
            addCriterionForJDBCTime("start_time1 not in", values, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1Between(Date value1, Date value2) {
            addCriterionForJDBCTime("start_time1 between", value1, value2, "startTime1");
            return (Criteria) this;
        }

        public Criteria andStartTime1NotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("start_time1 not between", value1, value2, "startTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1IsNull() {
            addCriterion("end_time1 is null");
            return (Criteria) this;
        }

        public Criteria andEndTime1IsNotNull() {
            addCriterion("end_time1 is not null");
            return (Criteria) this;
        }

        public Criteria andEndTime1EqualTo(Date value) {
            addCriterionForJDBCTime("end_time1 =", value, "endTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1NotEqualTo(Date value) {
            addCriterionForJDBCTime("end_time1 <>", value, "endTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1GreaterThan(Date value) {
            addCriterionForJDBCTime("end_time1 >", value, "endTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("end_time1 >=", value, "endTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1LessThan(Date value) {
            addCriterionForJDBCTime("end_time1 <", value, "endTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1LessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("end_time1 <=", value, "endTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1In(List<Date> values) {
            addCriterionForJDBCTime("end_time1 in", values, "endTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1NotIn(List<Date> values) {
            addCriterionForJDBCTime("end_time1 not in", values, "endTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1Between(Date value1, Date value2) {
            addCriterionForJDBCTime("end_time1 between", value1, value2, "endTime1");
            return (Criteria) this;
        }

        public Criteria andEndTime1NotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("end_time1 not between", value1, value2, "endTime1");
            return (Criteria) this;
        }

        public Criteria andLunchIsNull() {
            addCriterion("lunch is null");
            return (Criteria) this;
        }

        public Criteria andLunchIsNotNull() {
            addCriterion("lunch is not null");
            return (Criteria) this;
        }

        public Criteria andLunchEqualTo(Integer value) {
            addCriterion("lunch =", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotEqualTo(Integer value) {
            addCriterion("lunch <>", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchGreaterThan(Integer value) {
            addCriterion("lunch >", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchGreaterThanOrEqualTo(Integer value) {
            addCriterion("lunch >=", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchLessThan(Integer value) {
            addCriterion("lunch <", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchLessThanOrEqualTo(Integer value) {
            addCriterion("lunch <=", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchIn(List<Integer> values) {
            addCriterion("lunch in", values, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotIn(List<Integer> values) {
            addCriterion("lunch not in", values, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchBetween(Integer value1, Integer value2) {
            addCriterion("lunch between", value1, value2, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotBetween(Integer value1, Integer value2) {
            addCriterion("lunch not between", value1, value2, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchTypeIsNull() {
            addCriterion("lunch_type is null");
            return (Criteria) this;
        }

        public Criteria andLunchTypeIsNotNull() {
            addCriterion("lunch_type is not null");
            return (Criteria) this;
        }

        public Criteria andLunchTypeEqualTo(String value) {
            addCriterion("lunch_type =", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNotEqualTo(String value) {
            addCriterion("lunch_type <>", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeGreaterThan(String value) {
            addCriterion("lunch_type >", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lunch_type >=", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeLessThan(String value) {
            addCriterion("lunch_type <", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeLessThanOrEqualTo(String value) {
            addCriterion("lunch_type <=", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeLike(String value) {
            addCriterion("lunch_type like", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNotLike(String value) {
            addCriterion("lunch_type not like", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeIn(List<String> values) {
            addCriterion("lunch_type in", values, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNotIn(List<String> values) {
            addCriterion("lunch_type not in", values, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeBetween(String value1, String value2) {
            addCriterion("lunch_type between", value1, value2, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNotBetween(String value1, String value2) {
            addCriterion("lunch_type not between", value1, value2, "lunchType");
            return (Criteria) this;
        }

        public Criteria andStartTime2IsNull() {
            addCriterion("start_time2 is null");
            return (Criteria) this;
        }

        public Criteria andStartTime2IsNotNull() {
            addCriterion("start_time2 is not null");
            return (Criteria) this;
        }

        public Criteria andStartTime2EqualTo(Date value) {
            addCriterionForJDBCTime("start_time2 =", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2NotEqualTo(Date value) {
            addCriterionForJDBCTime("start_time2 <>", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2GreaterThan(Date value) {
            addCriterionForJDBCTime("start_time2 >", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("start_time2 >=", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2LessThan(Date value) {
            addCriterionForJDBCTime("start_time2 <", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2LessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("start_time2 <=", value, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2In(List<Date> values) {
            addCriterionForJDBCTime("start_time2 in", values, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2NotIn(List<Date> values) {
            addCriterionForJDBCTime("start_time2 not in", values, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2Between(Date value1, Date value2) {
            addCriterionForJDBCTime("start_time2 between", value1, value2, "startTime2");
            return (Criteria) this;
        }

        public Criteria andStartTime2NotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("start_time2 not between", value1, value2, "startTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2IsNull() {
            addCriterion("end_time2 is null");
            return (Criteria) this;
        }

        public Criteria andEndTime2IsNotNull() {
            addCriterion("end_time2 is not null");
            return (Criteria) this;
        }

        public Criteria andEndTime2EqualTo(Date value) {
            addCriterionForJDBCTime("end_time2 =", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2NotEqualTo(Date value) {
            addCriterionForJDBCTime("end_time2 <>", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2GreaterThan(Date value) {
            addCriterionForJDBCTime("end_time2 >", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("end_time2 >=", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2LessThan(Date value) {
            addCriterionForJDBCTime("end_time2 <", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2LessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("end_time2 <=", value, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2In(List<Date> values) {
            addCriterionForJDBCTime("end_time2 in", values, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2NotIn(List<Date> values) {
            addCriterionForJDBCTime("end_time2 not in", values, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2Between(Date value1, Date value2) {
            addCriterionForJDBCTime("end_time2 between", value1, value2, "endTime2");
            return (Criteria) this;
        }

        public Criteria andEndTime2NotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("end_time2 not between", value1, value2, "endTime2");
            return (Criteria) this;
        }

        public Criteria andDinnerIsNull() {
            addCriterion("dinner is null");
            return (Criteria) this;
        }

        public Criteria andDinnerIsNotNull() {
            addCriterion("dinner is not null");
            return (Criteria) this;
        }

        public Criteria andDinnerEqualTo(Integer value) {
            addCriterion("dinner =", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerNotEqualTo(Integer value) {
            addCriterion("dinner <>", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerGreaterThan(Integer value) {
            addCriterion("dinner >", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("dinner >=", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerLessThan(Integer value) {
            addCriterion("dinner <", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerLessThanOrEqualTo(Integer value) {
            addCriterion("dinner <=", value, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerIn(List<Integer> values) {
            addCriterion("dinner in", values, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerNotIn(List<Integer> values) {
            addCriterion("dinner not in", values, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerBetween(Integer value1, Integer value2) {
            addCriterion("dinner between", value1, value2, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerNotBetween(Integer value1, Integer value2) {
            addCriterion("dinner not between", value1, value2, "dinner");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeIsNull() {
            addCriterion("dinner_type is null");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeIsNotNull() {
            addCriterion("dinner_type is not null");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeEqualTo(String value) {
            addCriterion("dinner_type =", value, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeNotEqualTo(String value) {
            addCriterion("dinner_type <>", value, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeGreaterThan(String value) {
            addCriterion("dinner_type >", value, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dinner_type >=", value, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeLessThan(String value) {
            addCriterion("dinner_type <", value, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeLessThanOrEqualTo(String value) {
            addCriterion("dinner_type <=", value, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeLike(String value) {
            addCriterion("dinner_type like", value, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeNotLike(String value) {
            addCriterion("dinner_type not like", value, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeIn(List<String> values) {
            addCriterion("dinner_type in", values, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeNotIn(List<String> values) {
            addCriterion("dinner_type not in", values, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeBetween(String value1, String value2) {
            addCriterion("dinner_type between", value1, value2, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andDinnerTypeNotBetween(String value1, String value2) {
            addCriterion("dinner_type not between", value1, value2, "dinnerType");
            return (Criteria) this;
        }

        public Criteria andStartTime3IsNull() {
            addCriterion("start_time3 is null");
            return (Criteria) this;
        }

        public Criteria andStartTime3IsNotNull() {
            addCriterion("start_time3 is not null");
            return (Criteria) this;
        }

        public Criteria andStartTime3EqualTo(Date value) {
            addCriterionForJDBCTime("start_time3 =", value, "startTime3");
            return (Criteria) this;
        }

        public Criteria andStartTime3NotEqualTo(Date value) {
            addCriterionForJDBCTime("start_time3 <>", value, "startTime3");
            return (Criteria) this;
        }

        public Criteria andStartTime3GreaterThan(Date value) {
            addCriterionForJDBCTime("start_time3 >", value, "startTime3");
            return (Criteria) this;
        }

        public Criteria andStartTime3GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("start_time3 >=", value, "startTime3");
            return (Criteria) this;
        }

        public Criteria andStartTime3LessThan(Date value) {
            addCriterionForJDBCTime("start_time3 <", value, "startTime3");
            return (Criteria) this;
        }

        public Criteria andStartTime3LessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("start_time3 <=", value, "startTime3");
            return (Criteria) this;
        }

        public Criteria andStartTime3In(List<Date> values) {
            addCriterionForJDBCTime("start_time3 in", values, "startTime3");
            return (Criteria) this;
        }

        public Criteria andStartTime3NotIn(List<Date> values) {
            addCriterionForJDBCTime("start_time3 not in", values, "startTime3");
            return (Criteria) this;
        }

        public Criteria andStartTime3Between(Date value1, Date value2) {
            addCriterionForJDBCTime("start_time3 between", value1, value2, "startTime3");
            return (Criteria) this;
        }

        public Criteria andStartTime3NotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("start_time3 not between", value1, value2, "startTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3IsNull() {
            addCriterion("end_time3 is null");
            return (Criteria) this;
        }

        public Criteria andEndTime3IsNotNull() {
            addCriterion("end_time3 is not null");
            return (Criteria) this;
        }

        public Criteria andEndTime3EqualTo(Date value) {
            addCriterionForJDBCTime("end_time3 =", value, "endTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3NotEqualTo(Date value) {
            addCriterionForJDBCTime("end_time3 <>", value, "endTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3GreaterThan(Date value) {
            addCriterionForJDBCTime("end_time3 >", value, "endTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("end_time3 >=", value, "endTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3LessThan(Date value) {
            addCriterionForJDBCTime("end_time3 <", value, "endTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3LessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("end_time3 <=", value, "endTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3In(List<Date> values) {
            addCriterionForJDBCTime("end_time3 in", values, "endTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3NotIn(List<Date> values) {
            addCriterionForJDBCTime("end_time3 not in", values, "endTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3Between(Date value1, Date value2) {
            addCriterionForJDBCTime("end_time3 between", value1, value2, "endTime3");
            return (Criteria) this;
        }

        public Criteria andEndTime3NotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("end_time3 not between", value1, value2, "endTime3");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackIsNull() {
            addCriterion("midnight_snack is null");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackIsNotNull() {
            addCriterion("midnight_snack is not null");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackEqualTo(Integer value) {
            addCriterion("midnight_snack =", value, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackNotEqualTo(Integer value) {
            addCriterion("midnight_snack <>", value, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackGreaterThan(Integer value) {
            addCriterion("midnight_snack >", value, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackGreaterThanOrEqualTo(Integer value) {
            addCriterion("midnight_snack >=", value, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackLessThan(Integer value) {
            addCriterion("midnight_snack <", value, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackLessThanOrEqualTo(Integer value) {
            addCriterion("midnight_snack <=", value, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackIn(List<Integer> values) {
            addCriterion("midnight_snack in", values, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackNotIn(List<Integer> values) {
            addCriterion("midnight_snack not in", values, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackBetween(Integer value1, Integer value2) {
            addCriterion("midnight_snack between", value1, value2, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andMidnightSnackNotBetween(Integer value1, Integer value2) {
            addCriterion("midnight_snack not between", value1, value2, "midnightSnack");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andFinCheckSheetIdIsNull() {
            addCriterion("fin_check_sheet_id is null");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdIsNotNull() {
            addCriterion("fin_check_sheet_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdEqualTo(String value) {
            addCriterion("fin_check_sheet_id =", value, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdNotEqualTo(String value) {
            addCriterion("fin_check_sheet_id <>", value, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdGreaterThan(String value) {
            addCriterion("fin_check_sheet_id >", value, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdGreaterThanOrEqualTo(String value) {
            addCriterion("fin_check_sheet_id >=", value, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdLessThan(String value) {
            addCriterion("fin_check_sheet_id <", value, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdLessThanOrEqualTo(String value) {
            addCriterion("fin_check_sheet_id <=", value, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdLike(String value) {
            addCriterion("fin_check_sheet_id like", value, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdNotLike(String value) {
            addCriterion("fin_check_sheet_id not like", value, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdIn(List<String> values) {
            addCriterion("fin_check_sheet_id in", values, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdNotIn(List<String> values) {
            addCriterion("fin_check_sheet_id not in", values, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdBetween(String value1, String value2) {
            addCriterion("fin_check_sheet_id between", value1, value2, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andFinCheckSheetIdNotBetween(String value1, String value2) {
            addCriterion("fin_check_sheet_id not between", value1, value2, "finCheckSheetId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdIsNull() {
            addCriterion("log_travel_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdIsNotNull() {
            addCriterion("log_travel_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdEqualTo(String value) {
            addCriterion("log_travel_user_id =", value, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdNotEqualTo(String value) {
            addCriterion("log_travel_user_id <>", value, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdGreaterThan(String value) {
            addCriterion("log_travel_user_id >", value, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("log_travel_user_id >=", value, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdLessThan(String value) {
            addCriterion("log_travel_user_id <", value, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdLessThanOrEqualTo(String value) {
            addCriterion("log_travel_user_id <=", value, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdLike(String value) {
            addCriterion("log_travel_user_id like", value, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdNotLike(String value) {
            addCriterion("log_travel_user_id not like", value, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdIn(List<String> values) {
            addCriterion("log_travel_user_id in", values, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdNotIn(List<String> values) {
            addCriterion("log_travel_user_id not in", values, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdBetween(String value1, String value2) {
            addCriterion("log_travel_user_id between", value1, value2, "logTravelUserId");
            return (Criteria) this;
        }

        public Criteria andLogTravelUserIdNotBetween(String value1, String value2) {
            addCriterion("log_travel_user_id not between", value1, value2, "logTravelUserId");
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