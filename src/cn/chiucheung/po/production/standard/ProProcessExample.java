package cn.chiucheung.po.production.standard;

import java.util.ArrayList;
import java.util.List;

public class ProProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProProcessExample() {
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

        public Criteria andProcessNumberIsNull() {
            addCriterion("process_number is null");
            return (Criteria) this;
        }

        public Criteria andProcessNumberIsNotNull() {
            addCriterion("process_number is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNumberEqualTo(Integer value) {
            addCriterion("process_number =", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberNotEqualTo(Integer value) {
            addCriterion("process_number <>", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberGreaterThan(Integer value) {
            addCriterion("process_number >", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_number >=", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberLessThan(Integer value) {
            addCriterion("process_number <", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberLessThanOrEqualTo(Integer value) {
            addCriterion("process_number <=", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberIn(List<Integer> values) {
            addCriterion("process_number in", values, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberNotIn(List<Integer> values) {
            addCriterion("process_number not in", values, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberBetween(Integer value1, Integer value2) {
            addCriterion("process_number between", value1, value2, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("process_number not between", value1, value2, "processNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberIsNull() {
            addCriterion("parent_process_number is null");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberIsNotNull() {
            addCriterion("parent_process_number is not null");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberEqualTo(Integer value) {
            addCriterion("parent_process_number =", value, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberNotEqualTo(Integer value) {
            addCriterion("parent_process_number <>", value, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberGreaterThan(Integer value) {
            addCriterion("parent_process_number >", value, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_process_number >=", value, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberLessThan(Integer value) {
            addCriterion("parent_process_number <", value, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberLessThanOrEqualTo(Integer value) {
            addCriterion("parent_process_number <=", value, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberIn(List<Integer> values) {
            addCriterion("parent_process_number in", values, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberNotIn(List<Integer> values) {
            addCriterion("parent_process_number not in", values, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberBetween(Integer value1, Integer value2) {
            addCriterion("parent_process_number between", value1, value2, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andParentProcessNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_process_number not between", value1, value2, "parentProcessNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNull() {
            addCriterion("process_name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("process_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("process_name =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("process_name <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("process_name >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("process_name >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("process_name <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("process_name <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("process_name like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("process_name not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("process_name in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("process_name not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("process_name between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("process_name not between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryIsNull() {
            addCriterion("process_category is null");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryIsNotNull() {
            addCriterion("process_category is not null");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryEqualTo(String value) {
            addCriterion("process_category =", value, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryNotEqualTo(String value) {
            addCriterion("process_category <>", value, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryGreaterThan(String value) {
            addCriterion("process_category >", value, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("process_category >=", value, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryLessThan(String value) {
            addCriterion("process_category <", value, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryLessThanOrEqualTo(String value) {
            addCriterion("process_category <=", value, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryLike(String value) {
            addCriterion("process_category like", value, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryNotLike(String value) {
            addCriterion("process_category not like", value, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryIn(List<String> values) {
            addCriterion("process_category in", values, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryNotIn(List<String> values) {
            addCriterion("process_category not in", values, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryBetween(String value1, String value2) {
            addCriterion("process_category between", value1, value2, "processCategory");
            return (Criteria) this;
        }

        public Criteria andProcessCategoryNotBetween(String value1, String value2) {
            addCriterion("process_category not between", value1, value2, "processCategory");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberIsNull() {
            addCriterion("machine_group_number is null");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberIsNotNull() {
            addCriterion("machine_group_number is not null");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberEqualTo(Integer value) {
            addCriterion("machine_group_number =", value, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberNotEqualTo(Integer value) {
            addCriterion("machine_group_number <>", value, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberGreaterThan(Integer value) {
            addCriterion("machine_group_number >", value, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("machine_group_number >=", value, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberLessThan(Integer value) {
            addCriterion("machine_group_number <", value, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberLessThanOrEqualTo(Integer value) {
            addCriterion("machine_group_number <=", value, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberIn(List<Integer> values) {
            addCriterion("machine_group_number in", values, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberNotIn(List<Integer> values) {
            addCriterion("machine_group_number not in", values, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberBetween(Integer value1, Integer value2) {
            addCriterion("machine_group_number between", value1, value2, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andMachineGroupNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("machine_group_number not between", value1, value2, "machineGroupNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberIsNull() {
            addCriterion("per_machine_group_people_number is null");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberIsNotNull() {
            addCriterion("per_machine_group_people_number is not null");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberEqualTo(Integer value) {
            addCriterion("per_machine_group_people_number =", value, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberNotEqualTo(Integer value) {
            addCriterion("per_machine_group_people_number <>", value, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberGreaterThan(Integer value) {
            addCriterion("per_machine_group_people_number >", value, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("per_machine_group_people_number >=", value, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberLessThan(Integer value) {
            addCriterion("per_machine_group_people_number <", value, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberLessThanOrEqualTo(Integer value) {
            addCriterion("per_machine_group_people_number <=", value, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberIn(List<Integer> values) {
            addCriterion("per_machine_group_people_number in", values, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberNotIn(List<Integer> values) {
            addCriterion("per_machine_group_people_number not in", values, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberBetween(Integer value1, Integer value2) {
            addCriterion("per_machine_group_people_number between", value1, value2, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andPerMachineGroupPeopleNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("per_machine_group_people_number not between", value1, value2, "perMachineGroupPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaIsNull() {
            addCriterion("calculation_formula is null");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaIsNotNull() {
            addCriterion("calculation_formula is not null");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaEqualTo(String value) {
            addCriterion("calculation_formula =", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaNotEqualTo(String value) {
            addCriterion("calculation_formula <>", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaGreaterThan(String value) {
            addCriterion("calculation_formula >", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("calculation_formula >=", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaLessThan(String value) {
            addCriterion("calculation_formula <", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaLessThanOrEqualTo(String value) {
            addCriterion("calculation_formula <=", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaLike(String value) {
            addCriterion("calculation_formula like", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaNotLike(String value) {
            addCriterion("calculation_formula not like", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaIn(List<String> values) {
            addCriterion("calculation_formula in", values, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaNotIn(List<String> values) {
            addCriterion("calculation_formula not in", values, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaBetween(String value1, String value2) {
            addCriterion("calculation_formula between", value1, value2, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaNotBetween(String value1, String value2) {
            addCriterion("calculation_formula not between", value1, value2, "calculationFormula");
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