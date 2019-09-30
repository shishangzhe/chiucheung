package cn.chiucheung.po.finance.workcardinfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FinWorkCardInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinWorkCardInfoExample() {
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

        public Criteria andProjectLeaderIsNull() {
            addCriterion("project_leader is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNotNull() {
            addCriterion("project_leader is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEqualTo(String value) {
            addCriterion("project_leader =", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotEqualTo(String value) {
            addCriterion("project_leader <>", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThan(String value) {
            addCriterion("project_leader >", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader >=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThan(String value) {
            addCriterion("project_leader <", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThanOrEqualTo(String value) {
            addCriterion("project_leader <=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLike(String value) {
            addCriterion("project_leader like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotLike(String value) {
            addCriterion("project_leader not like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIn(List<String> values) {
            addCriterion("project_leader in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotIn(List<String> values) {
            addCriterion("project_leader not in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderBetween(String value1, String value2) {
            addCriterion("project_leader between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotBetween(String value1, String value2) {
            addCriterion("project_leader not between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andContractAmountIsNull() {
            addCriterion("contract_amount is null");
            return (Criteria) this;
        }

        public Criteria andContractAmountIsNotNull() {
            addCriterion("contract_amount is not null");
            return (Criteria) this;
        }

        public Criteria andContractAmountEqualTo(BigDecimal value) {
            addCriterion("contract_amount =", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotEqualTo(BigDecimal value) {
            addCriterion("contract_amount <>", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThan(BigDecimal value) {
            addCriterion("contract_amount >", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount >=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThan(BigDecimal value) {
            addCriterion("contract_amount <", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_amount <=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountIn(List<BigDecimal> values) {
            addCriterion("contract_amount in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotIn(List<BigDecimal> values) {
            addCriterion("contract_amount not in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_amount not between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostIsNull() {
            addCriterion("expected_installation_cost is null");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostIsNotNull() {
            addCriterion("expected_installation_cost is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostEqualTo(BigDecimal value) {
            addCriterion("expected_installation_cost =", value, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostNotEqualTo(BigDecimal value) {
            addCriterion("expected_installation_cost <>", value, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostGreaterThan(BigDecimal value) {
            addCriterion("expected_installation_cost >", value, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("expected_installation_cost >=", value, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostLessThan(BigDecimal value) {
            addCriterion("expected_installation_cost <", value, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("expected_installation_cost <=", value, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostIn(List<BigDecimal> values) {
            addCriterion("expected_installation_cost in", values, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostNotIn(List<BigDecimal> values) {
            addCriterion("expected_installation_cost not in", values, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expected_installation_cost between", value1, value2, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expected_installation_cost not between", value1, value2, "expectedInstallationCost");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeIsNull() {
            addCriterion("expected_installation_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeIsNotNull() {
            addCriterion("expected_installation_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeEqualTo(Float value) {
            addCriterion("expected_installation_time =", value, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeNotEqualTo(Float value) {
            addCriterion("expected_installation_time <>", value, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeGreaterThan(Float value) {
            addCriterion("expected_installation_time >", value, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeGreaterThanOrEqualTo(Float value) {
            addCriterion("expected_installation_time >=", value, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeLessThan(Float value) {
            addCriterion("expected_installation_time <", value, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeLessThanOrEqualTo(Float value) {
            addCriterion("expected_installation_time <=", value, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeIn(List<Float> values) {
            addCriterion("expected_installation_time in", values, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeNotIn(List<Float> values) {
            addCriterion("expected_installation_time not in", values, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeBetween(Float value1, Float value2) {
            addCriterion("expected_installation_time between", value1, value2, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andExpectedInstallationTimeNotBetween(Float value1, Float value2) {
            addCriterion("expected_installation_time not between", value1, value2, "expectedInstallationTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeIsNull() {
            addCriterion("actual_auxiliary_time is null");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeIsNotNull() {
            addCriterion("actual_auxiliary_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeEqualTo(Float value) {
            addCriterion("actual_auxiliary_time =", value, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeNotEqualTo(Float value) {
            addCriterion("actual_auxiliary_time <>", value, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeGreaterThan(Float value) {
            addCriterion("actual_auxiliary_time >", value, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeGreaterThanOrEqualTo(Float value) {
            addCriterion("actual_auxiliary_time >=", value, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeLessThan(Float value) {
            addCriterion("actual_auxiliary_time <", value, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeLessThanOrEqualTo(Float value) {
            addCriterion("actual_auxiliary_time <=", value, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeIn(List<Float> values) {
            addCriterion("actual_auxiliary_time in", values, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeNotIn(List<Float> values) {
            addCriterion("actual_auxiliary_time not in", values, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeBetween(Float value1, Float value2) {
            addCriterion("actual_auxiliary_time between", value1, value2, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andActualAuxiliaryTimeNotBetween(Float value1, Float value2) {
            addCriterion("actual_auxiliary_time not between", value1, value2, "actualAuxiliaryTime");
            return (Criteria) this;
        }

        public Criteria andCompletionDateIsNull() {
            addCriterion("completion_date is null");
            return (Criteria) this;
        }

        public Criteria andCompletionDateIsNotNull() {
            addCriterion("completion_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionDateEqualTo(Date value) {
            addCriterionForJDBCDate("completion_date =", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("completion_date <>", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("completion_date >", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("completion_date >=", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateLessThan(Date value) {
            addCriterionForJDBCDate("completion_date <", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("completion_date <=", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateIn(List<Date> values) {
            addCriterionForJDBCDate("completion_date in", values, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("completion_date not in", values, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("completion_date between", value1, value2, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("completion_date not between", value1, value2, "completionDate");
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