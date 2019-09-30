package cn.chiucheung.po.logistics.traveluser;

import java.util.ArrayList;
import java.util.List;

public class LogTravelUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogTravelUserExample() {
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

        public Criteria andWorkNoIsNull() {
            addCriterion("work_no is null");
            return (Criteria) this;
        }

        public Criteria andWorkNoIsNotNull() {
            addCriterion("work_no is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNoEqualTo(String value) {
            addCriterion("work_no =", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotEqualTo(String value) {
            addCriterion("work_no <>", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThan(String value) {
            addCriterion("work_no >", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThanOrEqualTo(String value) {
            addCriterion("work_no >=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThan(String value) {
            addCriterion("work_no <", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThanOrEqualTo(String value) {
            addCriterion("work_no <=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLike(String value) {
            addCriterion("work_no like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotLike(String value) {
            addCriterion("work_no not like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoIn(List<String> values) {
            addCriterion("work_no in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotIn(List<String> values) {
            addCriterion("work_no not in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoBetween(String value1, String value2) {
            addCriterion("work_no between", value1, value2, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotBetween(String value1, String value2) {
            addCriterion("work_no not between", value1, value2, "workNo");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andGroupsIdIsNull() {
            addCriterion("groups_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupsIdIsNotNull() {
            addCriterion("groups_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupsIdEqualTo(String value) {
            addCriterion("groups_id =", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdNotEqualTo(String value) {
            addCriterion("groups_id <>", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdGreaterThan(String value) {
            addCriterion("groups_id >", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdGreaterThanOrEqualTo(String value) {
            addCriterion("groups_id >=", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdLessThan(String value) {
            addCriterion("groups_id <", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdLessThanOrEqualTo(String value) {
            addCriterion("groups_id <=", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdLike(String value) {
            addCriterion("groups_id like", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdNotLike(String value) {
            addCriterion("groups_id not like", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdIn(List<String> values) {
            addCriterion("groups_id in", values, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdNotIn(List<String> values) {
            addCriterion("groups_id not in", values, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdBetween(String value1, String value2) {
            addCriterion("groups_id between", value1, value2, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdNotBetween(String value1, String value2) {
            addCriterion("groups_id not between", value1, value2, "groupsId");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginIsNull() {
            addCriterion("is_allowed_login is null");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginIsNotNull() {
            addCriterion("is_allowed_login is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginEqualTo(String value) {
            addCriterion("is_allowed_login =", value, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginNotEqualTo(String value) {
            addCriterion("is_allowed_login <>", value, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginGreaterThan(String value) {
            addCriterion("is_allowed_login >", value, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginGreaterThanOrEqualTo(String value) {
            addCriterion("is_allowed_login >=", value, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginLessThan(String value) {
            addCriterion("is_allowed_login <", value, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginLessThanOrEqualTo(String value) {
            addCriterion("is_allowed_login <=", value, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginLike(String value) {
            addCriterion("is_allowed_login like", value, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginNotLike(String value) {
            addCriterion("is_allowed_login not like", value, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginIn(List<String> values) {
            addCriterion("is_allowed_login in", values, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginNotIn(List<String> values) {
            addCriterion("is_allowed_login not in", values, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginBetween(String value1, String value2) {
            addCriterion("is_allowed_login between", value1, value2, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andIsAllowedLoginNotBetween(String value1, String value2) {
            addCriterion("is_allowed_login not between", value1, value2, "isAllowedLogin");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberIsNull() {
            addCriterion("device_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberIsNotNull() {
            addCriterion("device_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberEqualTo(String value) {
            addCriterion("device_serial_number =", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotEqualTo(String value) {
            addCriterion("device_serial_number <>", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberGreaterThan(String value) {
            addCriterion("device_serial_number >", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("device_serial_number >=", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLessThan(String value) {
            addCriterion("device_serial_number <", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("device_serial_number <=", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLike(String value) {
            addCriterion("device_serial_number like", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotLike(String value) {
            addCriterion("device_serial_number not like", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberIn(List<String> values) {
            addCriterion("device_serial_number in", values, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotIn(List<String> values) {
            addCriterion("device_serial_number not in", values, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberBetween(String value1, String value2) {
            addCriterion("device_serial_number between", value1, value2, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotBetween(String value1, String value2) {
            addCriterion("device_serial_number not between", value1, value2, "deviceSerialNumber");
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