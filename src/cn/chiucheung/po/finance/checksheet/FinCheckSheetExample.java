package cn.chiucheung.po.finance.checksheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FinCheckSheetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinCheckSheetExample() {
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

        public Criteria andCheckSheetNoIsNull() {
            addCriterion("check_sheet_no is null");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoIsNotNull() {
            addCriterion("check_sheet_no is not null");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoEqualTo(String value) {
            addCriterion("check_sheet_no =", value, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoNotEqualTo(String value) {
            addCriterion("check_sheet_no <>", value, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoGreaterThan(String value) {
            addCriterion("check_sheet_no >", value, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoGreaterThanOrEqualTo(String value) {
            addCriterion("check_sheet_no >=", value, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoLessThan(String value) {
            addCriterion("check_sheet_no <", value, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoLessThanOrEqualTo(String value) {
            addCriterion("check_sheet_no <=", value, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoLike(String value) {
            addCriterion("check_sheet_no like", value, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoNotLike(String value) {
            addCriterion("check_sheet_no not like", value, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoIn(List<String> values) {
            addCriterion("check_sheet_no in", values, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoNotIn(List<String> values) {
            addCriterion("check_sheet_no not in", values, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoBetween(String value1, String value2) {
            addCriterion("check_sheet_no between", value1, value2, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andCheckSheetNoNotBetween(String value1, String value2) {
            addCriterion("check_sheet_no not between", value1, value2, "checkSheetNo");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoIsNull() {
            addCriterion("install_work_card_no is null");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoIsNotNull() {
            addCriterion("install_work_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoEqualTo(String value) {
            addCriterion("install_work_card_no =", value, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoNotEqualTo(String value) {
            addCriterion("install_work_card_no <>", value, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoGreaterThan(String value) {
            addCriterion("install_work_card_no >", value, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("install_work_card_no >=", value, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoLessThan(String value) {
            addCriterion("install_work_card_no <", value, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoLessThanOrEqualTo(String value) {
            addCriterion("install_work_card_no <=", value, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoLike(String value) {
            addCriterion("install_work_card_no like", value, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoNotLike(String value) {
            addCriterion("install_work_card_no not like", value, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoIn(List<String> values) {
            addCriterion("install_work_card_no in", values, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoNotIn(List<String> values) {
            addCriterion("install_work_card_no not in", values, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoBetween(String value1, String value2) {
            addCriterion("install_work_card_no between", value1, value2, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andInstallWorkCardNoNotBetween(String value1, String value2) {
            addCriterion("install_work_card_no not between", value1, value2, "installWorkCardNo");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIsNull() {
            addCriterion("project_manager is null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIsNotNull() {
            addCriterion("project_manager is not null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerEqualTo(String value) {
            addCriterion("project_manager =", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotEqualTo(String value) {
            addCriterion("project_manager <>", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerGreaterThan(String value) {
            addCriterion("project_manager >", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerGreaterThanOrEqualTo(String value) {
            addCriterion("project_manager >=", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLessThan(String value) {
            addCriterion("project_manager <", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLessThanOrEqualTo(String value) {
            addCriterion("project_manager <=", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLike(String value) {
            addCriterion("project_manager like", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotLike(String value) {
            addCriterion("project_manager not like", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIn(List<String> values) {
            addCriterion("project_manager in", values, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotIn(List<String> values) {
            addCriterion("project_manager not in", values, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerBetween(String value1, String value2) {
            addCriterion("project_manager between", value1, value2, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotBetween(String value1, String value2) {
            addCriterion("project_manager not between", value1, value2, "projectManager");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateIsNull() {
            addCriterion("business_trip_date is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateIsNotNull() {
            addCriterion("business_trip_date is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateEqualTo(Date value) {
            addCriterionForJDBCDate("business_trip_date =", value, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("business_trip_date <>", value, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateGreaterThan(Date value) {
            addCriterionForJDBCDate("business_trip_date >", value, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("business_trip_date >=", value, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateLessThan(Date value) {
            addCriterionForJDBCDate("business_trip_date <", value, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("business_trip_date <=", value, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateIn(List<Date> values) {
            addCriterionForJDBCDate("business_trip_date in", values, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("business_trip_date not in", values, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("business_trip_date between", value1, value2, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andBusinessTripDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("business_trip_date not between", value1, value2, "businessTripDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateIsNull() {
            addCriterion("departure_date is null");
            return (Criteria) this;
        }

        public Criteria andDepartureDateIsNotNull() {
            addCriterion("departure_date is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureDateEqualTo(Date value) {
            addCriterionForJDBCDate("departure_date =", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("departure_date <>", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateGreaterThan(Date value) {
            addCriterionForJDBCDate("departure_date >", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("departure_date >=", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateLessThan(Date value) {
            addCriterionForJDBCDate("departure_date <", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("departure_date <=", value, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateIn(List<Date> values) {
            addCriterionForJDBCDate("departure_date in", values, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("departure_date not in", values, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("departure_date between", value1, value2, "departureDate");
            return (Criteria) this;
        }

        public Criteria andDepartureDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("departure_date not between", value1, value2, "departureDate");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceIsNull() {
            addCriterion("travel_place is null");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceIsNotNull() {
            addCriterion("travel_place is not null");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceEqualTo(String value) {
            addCriterion("travel_place =", value, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceNotEqualTo(String value) {
            addCriterion("travel_place <>", value, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceGreaterThan(String value) {
            addCriterion("travel_place >", value, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("travel_place >=", value, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceLessThan(String value) {
            addCriterion("travel_place <", value, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceLessThanOrEqualTo(String value) {
            addCriterion("travel_place <=", value, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceLike(String value) {
            addCriterion("travel_place like", value, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceNotLike(String value) {
            addCriterion("travel_place not like", value, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceIn(List<String> values) {
            addCriterion("travel_place in", values, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceNotIn(List<String> values) {
            addCriterion("travel_place not in", values, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceBetween(String value1, String value2) {
            addCriterion("travel_place between", value1, value2, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andTravelPlaceNotBetween(String value1, String value2) {
            addCriterion("travel_place not between", value1, value2, "travelPlace");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelIsNull() {
            addCriterion("accompanying_personnel is null");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelIsNotNull() {
            addCriterion("accompanying_personnel is not null");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelEqualTo(String value) {
            addCriterion("accompanying_personnel =", value, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelNotEqualTo(String value) {
            addCriterion("accompanying_personnel <>", value, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelGreaterThan(String value) {
            addCriterion("accompanying_personnel >", value, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelGreaterThanOrEqualTo(String value) {
            addCriterion("accompanying_personnel >=", value, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelLessThan(String value) {
            addCriterion("accompanying_personnel <", value, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelLessThanOrEqualTo(String value) {
            addCriterion("accompanying_personnel <=", value, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelLike(String value) {
            addCriterion("accompanying_personnel like", value, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelNotLike(String value) {
            addCriterion("accompanying_personnel not like", value, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelIn(List<String> values) {
            addCriterion("accompanying_personnel in", values, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelNotIn(List<String> values) {
            addCriterion("accompanying_personnel not in", values, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelBetween(String value1, String value2) {
            addCriterion("accompanying_personnel between", value1, value2, "accompanyingPersonnel");
            return (Criteria) this;
        }

        public Criteria andAccompanyingPersonnelNotBetween(String value1, String value2) {
            addCriterion("accompanying_personnel not between", value1, value2, "accompanyingPersonnel");
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