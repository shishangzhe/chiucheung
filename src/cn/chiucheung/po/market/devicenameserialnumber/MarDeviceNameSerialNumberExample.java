package cn.chiucheung.po.market.devicenameserialnumber;

import java.util.ArrayList;
import java.util.List;

public class MarDeviceNameSerialNumberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarDeviceNameSerialNumberExample() {
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

        public Criteria andDeviceModelIsNull() {
            addCriterion("device_model is null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIsNotNull() {
            addCriterion("device_model is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceModelEqualTo(String value) {
            addCriterion("device_model =", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotEqualTo(String value) {
            addCriterion("device_model <>", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelGreaterThan(String value) {
            addCriterion("device_model >", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelGreaterThanOrEqualTo(String value) {
            addCriterion("device_model >=", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelLessThan(String value) {
            addCriterion("device_model <", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelLessThanOrEqualTo(String value) {
            addCriterion("device_model <=", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelLike(String value) {
            addCriterion("device_model like", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotLike(String value) {
            addCriterion("device_model not like", value, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelIn(List<String> values) {
            addCriterion("device_model in", values, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotIn(List<String> values) {
            addCriterion("device_model not in", values, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelBetween(String value1, String value2) {
            addCriterion("device_model between", value1, value2, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andDeviceModelNotBetween(String value1, String value2) {
            addCriterion("device_model not between", value1, value2, "deviceModel");
            return (Criteria) this;
        }

        public Criteria andUseNameIsNull() {
            addCriterion("use_name is null");
            return (Criteria) this;
        }

        public Criteria andUseNameIsNotNull() {
            addCriterion("use_name is not null");
            return (Criteria) this;
        }

        public Criteria andUseNameEqualTo(String value) {
            addCriterion("use_name =", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotEqualTo(String value) {
            addCriterion("use_name <>", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameGreaterThan(String value) {
            addCriterion("use_name >", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameGreaterThanOrEqualTo(String value) {
            addCriterion("use_name >=", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameLessThan(String value) {
            addCriterion("use_name <", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameLessThanOrEqualTo(String value) {
            addCriterion("use_name <=", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameLike(String value) {
            addCriterion("use_name like", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotLike(String value) {
            addCriterion("use_name not like", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameIn(List<String> values) {
            addCriterion("use_name in", values, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotIn(List<String> values) {
            addCriterion("use_name not in", values, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameBetween(String value1, String value2) {
            addCriterion("use_name between", value1, value2, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotBetween(String value1, String value2) {
            addCriterion("use_name not between", value1, value2, "useName");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadIsNull() {
            addCriterion("is_allowed_download is null");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadIsNotNull() {
            addCriterion("is_allowed_download is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadEqualTo(Boolean value) {
            addCriterion("is_allowed_download =", value, "isAllowedDownload");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadNotEqualTo(Boolean value) {
            addCriterion("is_allowed_download <>", value, "isAllowedDownload");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadGreaterThan(Boolean value) {
            addCriterion("is_allowed_download >", value, "isAllowedDownload");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_allowed_download >=", value, "isAllowedDownload");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadLessThan(Boolean value) {
            addCriterion("is_allowed_download <", value, "isAllowedDownload");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadLessThanOrEqualTo(Boolean value) {
            addCriterion("is_allowed_download <=", value, "isAllowedDownload");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadIn(List<Boolean> values) {
            addCriterion("is_allowed_download in", values, "isAllowedDownload");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadNotIn(List<Boolean> values) {
            addCriterion("is_allowed_download not in", values, "isAllowedDownload");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allowed_download between", value1, value2, "isAllowedDownload");
            return (Criteria) this;
        }

        public Criteria andIsAllowedDownloadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allowed_download not between", value1, value2, "isAllowedDownload");
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