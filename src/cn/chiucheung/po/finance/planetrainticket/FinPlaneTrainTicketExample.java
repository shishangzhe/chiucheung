package cn.chiucheung.po.finance.planetrainticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FinPlaneTrainTicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinPlaneTrainTicketExample() {
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

        public Criteria andOrderTicketsDateIsNull() {
            addCriterion("order_tickets_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateIsNotNull() {
            addCriterion("order_tickets_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateEqualTo(Date value) {
            addCriterionForJDBCDate("order_tickets_date =", value, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_tickets_date <>", value, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateGreaterThan(Date value) {
            addCriterionForJDBCDate("order_tickets_date >", value, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_tickets_date >=", value, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateLessThan(Date value) {
            addCriterionForJDBCDate("order_tickets_date <", value, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_tickets_date <=", value, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateIn(List<Date> values) {
            addCriterionForJDBCDate("order_tickets_date in", values, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_tickets_date not in", values, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_tickets_date between", value1, value2, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andOrderTicketsDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_tickets_date not between", value1, value2, "orderTicketsDate");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNull() {
            addCriterion("departure_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNotNull() {
            addCriterion("departure_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeEqualTo(Date value) {
            addCriterion("departure_time =", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotEqualTo(Date value) {
            addCriterion("departure_time <>", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThan(Date value) {
            addCriterion("departure_time >", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("departure_time >=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThan(Date value) {
            addCriterion("departure_time <", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThanOrEqualTo(Date value) {
            addCriterion("departure_time <=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIn(List<Date> values) {
            addCriterion("departure_time in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotIn(List<Date> values) {
            addCriterion("departure_time not in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeBetween(Date value1, Date value2) {
            addCriterion("departure_time between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotBetween(Date value1, Date value2) {
            addCriterion("departure_time not between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelIsNull() {
            addCriterion("travel_personnel is null");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelIsNotNull() {
            addCriterion("travel_personnel is not null");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelEqualTo(String value) {
            addCriterion("travel_personnel =", value, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelNotEqualTo(String value) {
            addCriterion("travel_personnel <>", value, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelGreaterThan(String value) {
            addCriterion("travel_personnel >", value, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelGreaterThanOrEqualTo(String value) {
            addCriterion("travel_personnel >=", value, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelLessThan(String value) {
            addCriterion("travel_personnel <", value, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelLessThanOrEqualTo(String value) {
            addCriterion("travel_personnel <=", value, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelLike(String value) {
            addCriterion("travel_personnel like", value, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelNotLike(String value) {
            addCriterion("travel_personnel not like", value, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelIn(List<String> values) {
            addCriterion("travel_personnel in", values, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelNotIn(List<String> values) {
            addCriterion("travel_personnel not in", values, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelBetween(String value1, String value2) {
            addCriterion("travel_personnel between", value1, value2, "travelPersonnel");
            return (Criteria) this;
        }

        public Criteria andTravelPersonnelNotBetween(String value1, String value2) {
            addCriterion("travel_personnel not between", value1, value2, "travelPersonnel");
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

        public Criteria andPlaneTrainNumberIsNull() {
            addCriterion("plane_train_number is null");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberIsNotNull() {
            addCriterion("plane_train_number is not null");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberEqualTo(String value) {
            addCriterion("plane_train_number =", value, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberNotEqualTo(String value) {
            addCriterion("plane_train_number <>", value, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberGreaterThan(String value) {
            addCriterion("plane_train_number >", value, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberGreaterThanOrEqualTo(String value) {
            addCriterion("plane_train_number >=", value, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberLessThan(String value) {
            addCriterion("plane_train_number <", value, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberLessThanOrEqualTo(String value) {
            addCriterion("plane_train_number <=", value, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberLike(String value) {
            addCriterion("plane_train_number like", value, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberNotLike(String value) {
            addCriterion("plane_train_number not like", value, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberIn(List<String> values) {
            addCriterion("plane_train_number in", values, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberNotIn(List<String> values) {
            addCriterion("plane_train_number not in", values, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberBetween(String value1, String value2) {
            addCriterion("plane_train_number between", value1, value2, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andPlaneTrainNumberNotBetween(String value1, String value2) {
            addCriterion("plane_train_number not between", value1, value2, "planeTrainNumber");
            return (Criteria) this;
        }

        public Criteria andSeatIsNull() {
            addCriterion("seat is null");
            return (Criteria) this;
        }

        public Criteria andSeatIsNotNull() {
            addCriterion("seat is not null");
            return (Criteria) this;
        }

        public Criteria andSeatEqualTo(String value) {
            addCriterion("seat =", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotEqualTo(String value) {
            addCriterion("seat <>", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatGreaterThan(String value) {
            addCriterion("seat >", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatGreaterThanOrEqualTo(String value) {
            addCriterion("seat >=", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatLessThan(String value) {
            addCriterion("seat <", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatLessThanOrEqualTo(String value) {
            addCriterion("seat <=", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatLike(String value) {
            addCriterion("seat like", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotLike(String value) {
            addCriterion("seat not like", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatIn(List<String> values) {
            addCriterion("seat in", values, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotIn(List<String> values) {
            addCriterion("seat not in", values, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatBetween(String value1, String value2) {
            addCriterion("seat between", value1, value2, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotBetween(String value1, String value2) {
            addCriterion("seat not between", value1, value2, "seat");
            return (Criteria) this;
        }

        public Criteria andBerthIsNull() {
            addCriterion("berth is null");
            return (Criteria) this;
        }

        public Criteria andBerthIsNotNull() {
            addCriterion("berth is not null");
            return (Criteria) this;
        }

        public Criteria andBerthEqualTo(String value) {
            addCriterion("berth =", value, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthNotEqualTo(String value) {
            addCriterion("berth <>", value, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthGreaterThan(String value) {
            addCriterion("berth >", value, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthGreaterThanOrEqualTo(String value) {
            addCriterion("berth >=", value, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthLessThan(String value) {
            addCriterion("berth <", value, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthLessThanOrEqualTo(String value) {
            addCriterion("berth <=", value, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthLike(String value) {
            addCriterion("berth like", value, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthNotLike(String value) {
            addCriterion("berth not like", value, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthIn(List<String> values) {
            addCriterion("berth in", values, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthNotIn(List<String> values) {
            addCriterion("berth not in", values, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthBetween(String value1, String value2) {
            addCriterion("berth between", value1, value2, "berth");
            return (Criteria) this;
        }

        public Criteria andBerthNotBetween(String value1, String value2) {
            addCriterion("berth not between", value1, value2, "berth");
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
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

        public Criteria andIsLockIsNull() {
            addCriterion("is_lock is null");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNotNull() {
            addCriterion("is_lock is not null");
            return (Criteria) this;
        }

        public Criteria andIsLockEqualTo(Boolean value) {
            addCriterion("is_lock =", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotEqualTo(Boolean value) {
            addCriterion("is_lock <>", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThan(Boolean value) {
            addCriterion("is_lock >", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_lock >=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThan(Boolean value) {
            addCriterion("is_lock <", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThanOrEqualTo(Boolean value) {
            addCriterion("is_lock <=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockIn(List<Boolean> values) {
            addCriterion("is_lock in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotIn(List<Boolean> values) {
            addCriterion("is_lock not in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockBetween(Boolean value1, Boolean value2) {
            addCriterion("is_lock between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_lock not between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptIsNull() {
            addCriterion("is_receive_receipt is null");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptIsNotNull() {
            addCriterion("is_receive_receipt is not null");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptEqualTo(Boolean value) {
            addCriterion("is_receive_receipt =", value, "isReceiveReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptNotEqualTo(Boolean value) {
            addCriterion("is_receive_receipt <>", value, "isReceiveReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptGreaterThan(Boolean value) {
            addCriterion("is_receive_receipt >", value, "isReceiveReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_receive_receipt >=", value, "isReceiveReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptLessThan(Boolean value) {
            addCriterion("is_receive_receipt <", value, "isReceiveReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptLessThanOrEqualTo(Boolean value) {
            addCriterion("is_receive_receipt <=", value, "isReceiveReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptIn(List<Boolean> values) {
            addCriterion("is_receive_receipt in", values, "isReceiveReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptNotIn(List<Boolean> values) {
            addCriterion("is_receive_receipt not in", values, "isReceiveReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptBetween(Boolean value1, Boolean value2) {
            addCriterion("is_receive_receipt between", value1, value2, "isReceiveReceipt");
            return (Criteria) this;
        }

        public Criteria andIsReceiveReceiptNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_receive_receipt not between", value1, value2, "isReceiveReceipt");
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