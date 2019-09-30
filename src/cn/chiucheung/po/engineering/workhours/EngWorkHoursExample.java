package cn.chiucheung.po.engineering.workhours;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EngWorkHoursExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EngWorkHoursExample() {
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

        public Criteria andWorkHoursDateIsNull() {
            addCriterion("work_hours_date is null");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateIsNotNull() {
            addCriterion("work_hours_date is not null");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateEqualTo(Date value) {
            addCriterionForJDBCDate("work_hours_date =", value, "workHoursDate");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("work_hours_date <>", value, "workHoursDate");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateGreaterThan(Date value) {
            addCriterionForJDBCDate("work_hours_date >", value, "workHoursDate");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("work_hours_date >=", value, "workHoursDate");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateLessThan(Date value) {
            addCriterionForJDBCDate("work_hours_date <", value, "workHoursDate");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("work_hours_date <=", value, "workHoursDate");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateIn(List<Date> values) {
            addCriterionForJDBCDate("work_hours_date in", values, "workHoursDate");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("work_hours_date not in", values, "workHoursDate");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("work_hours_date between", value1, value2, "workHoursDate");
            return (Criteria) this;
        }

        public Criteria andWorkHoursDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("work_hours_date not between", value1, value2, "workHoursDate");
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

        public Criteria andWorkCardItemIsNull() {
            addCriterion("work_card_item is null");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemIsNotNull() {
            addCriterion("work_card_item is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemEqualTo(String value) {
            addCriterion("work_card_item =", value, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemNotEqualTo(String value) {
            addCriterion("work_card_item <>", value, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemGreaterThan(String value) {
            addCriterion("work_card_item >", value, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemGreaterThanOrEqualTo(String value) {
            addCriterion("work_card_item >=", value, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemLessThan(String value) {
            addCriterion("work_card_item <", value, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemLessThanOrEqualTo(String value) {
            addCriterion("work_card_item <=", value, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemLike(String value) {
            addCriterion("work_card_item like", value, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemNotLike(String value) {
            addCriterion("work_card_item not like", value, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemIn(List<String> values) {
            addCriterion("work_card_item in", values, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemNotIn(List<String> values) {
            addCriterion("work_card_item not in", values, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemBetween(String value1, String value2) {
            addCriterion("work_card_item between", value1, value2, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkCardItemNotBetween(String value1, String value2) {
            addCriterion("work_card_item not between", value1, value2, "workCardItem");
            return (Criteria) this;
        }

        public Criteria andWorkHoursIsNull() {
            addCriterion("work_hours is null");
            return (Criteria) this;
        }

        public Criteria andWorkHoursIsNotNull() {
            addCriterion("work_hours is not null");
            return (Criteria) this;
        }

        public Criteria andWorkHoursEqualTo(Float value) {
            addCriterion("work_hours =", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursNotEqualTo(Float value) {
            addCriterion("work_hours <>", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursGreaterThan(Float value) {
            addCriterion("work_hours >", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursGreaterThanOrEqualTo(Float value) {
            addCriterion("work_hours >=", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursLessThan(Float value) {
            addCriterion("work_hours <", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursLessThanOrEqualTo(Float value) {
            addCriterion("work_hours <=", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursIn(List<Float> values) {
            addCriterion("work_hours in", values, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursNotIn(List<Float> values) {
            addCriterion("work_hours not in", values, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursBetween(Float value1, Float value2) {
            addCriterion("work_hours between", value1, value2, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursNotBetween(Float value1, Float value2) {
            addCriterion("work_hours not between", value1, value2, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdIsNull() {
            addCriterion("work_shift_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdIsNotNull() {
            addCriterion("work_shift_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdEqualTo(String value) {
            addCriterion("work_shift_id =", value, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdNotEqualTo(String value) {
            addCriterion("work_shift_id <>", value, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdGreaterThan(String value) {
            addCriterion("work_shift_id >", value, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_shift_id >=", value, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdLessThan(String value) {
            addCriterion("work_shift_id <", value, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdLessThanOrEqualTo(String value) {
            addCriterion("work_shift_id <=", value, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdLike(String value) {
            addCriterion("work_shift_id like", value, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdNotLike(String value) {
            addCriterion("work_shift_id not like", value, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdIn(List<String> values) {
            addCriterion("work_shift_id in", values, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdNotIn(List<String> values) {
            addCriterion("work_shift_id not in", values, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdBetween(String value1, String value2) {
            addCriterion("work_shift_id between", value1, value2, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkShiftIdNotBetween(String value1, String value2) {
            addCriterion("work_shift_id not between", value1, value2, "workShiftId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNull() {
            addCriterion("work_content is null");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNotNull() {
            addCriterion("work_content is not null");
            return (Criteria) this;
        }

        public Criteria andWorkContentEqualTo(String value) {
            addCriterion("work_content =", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotEqualTo(String value) {
            addCriterion("work_content <>", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThan(String value) {
            addCriterion("work_content >", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThanOrEqualTo(String value) {
            addCriterion("work_content >=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThan(String value) {
            addCriterion("work_content <", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThanOrEqualTo(String value) {
            addCriterion("work_content <=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLike(String value) {
            addCriterion("work_content like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotLike(String value) {
            addCriterion("work_content not like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentIn(List<String> values) {
            addCriterion("work_content in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotIn(List<String> values) {
            addCriterion("work_content not in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentBetween(String value1, String value2) {
            addCriterion("work_content between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotBetween(String value1, String value2) {
            addCriterion("work_content not between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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