package cn.chiucheung.po.sales.workcard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalWorkCardDsqOtherExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalWorkCardDsqOtherExample() {
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

        public Criteria andOtherContentIsNull() {
            addCriterion("other_content is null");
            return (Criteria) this;
        }

        public Criteria andOtherContentIsNotNull() {
            addCriterion("other_content is not null");
            return (Criteria) this;
        }

        public Criteria andOtherContentEqualTo(String value) {
            addCriterion("other_content =", value, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentNotEqualTo(String value) {
            addCriterion("other_content <>", value, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentGreaterThan(String value) {
            addCriterion("other_content >", value, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentGreaterThanOrEqualTo(String value) {
            addCriterion("other_content >=", value, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentLessThan(String value) {
            addCriterion("other_content <", value, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentLessThanOrEqualTo(String value) {
            addCriterion("other_content <=", value, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentLike(String value) {
            addCriterion("other_content like", value, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentNotLike(String value) {
            addCriterion("other_content not like", value, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentIn(List<String> values) {
            addCriterion("other_content in", values, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentNotIn(List<String> values) {
            addCriterion("other_content not in", values, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentBetween(String value1, String value2) {
            addCriterion("other_content between", value1, value2, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentNotBetween(String value1, String value2) {
            addCriterion("other_content not between", value1, value2, "otherContent");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityIsNull() {
            addCriterion("other_content_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityIsNotNull() {
            addCriterion("other_content_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityEqualTo(String value) {
            addCriterion("other_content_quantity =", value, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityNotEqualTo(String value) {
            addCriterion("other_content_quantity <>", value, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityGreaterThan(String value) {
            addCriterion("other_content_quantity >", value, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("other_content_quantity >=", value, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityLessThan(String value) {
            addCriterion("other_content_quantity <", value, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityLessThanOrEqualTo(String value) {
            addCriterion("other_content_quantity <=", value, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityLike(String value) {
            addCriterion("other_content_quantity like", value, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityNotLike(String value) {
            addCriterion("other_content_quantity not like", value, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityIn(List<String> values) {
            addCriterion("other_content_quantity in", values, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityNotIn(List<String> values) {
            addCriterion("other_content_quantity not in", values, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityBetween(String value1, String value2) {
            addCriterion("other_content_quantity between", value1, value2, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentQuantityNotBetween(String value1, String value2) {
            addCriterion("other_content_quantity not between", value1, value2, "otherContentQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkIsNull() {
            addCriterion("other_content_remark is null");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkIsNotNull() {
            addCriterion("other_content_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkEqualTo(String value) {
            addCriterion("other_content_remark =", value, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkNotEqualTo(String value) {
            addCriterion("other_content_remark <>", value, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkGreaterThan(String value) {
            addCriterion("other_content_remark >", value, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("other_content_remark >=", value, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkLessThan(String value) {
            addCriterion("other_content_remark <", value, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkLessThanOrEqualTo(String value) {
            addCriterion("other_content_remark <=", value, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkLike(String value) {
            addCriterion("other_content_remark like", value, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkNotLike(String value) {
            addCriterion("other_content_remark not like", value, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkIn(List<String> values) {
            addCriterion("other_content_remark in", values, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkNotIn(List<String> values) {
            addCriterion("other_content_remark not in", values, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkBetween(String value1, String value2) {
            addCriterion("other_content_remark between", value1, value2, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andOtherContentRemarkNotBetween(String value1, String value2) {
            addCriterion("other_content_remark not between", value1, value2, "otherContentRemark");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdIsNull() {
            addCriterion("sal_work_card_dsq_id is null");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdIsNotNull() {
            addCriterion("sal_work_card_dsq_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdEqualTo(String value) {
            addCriterion("sal_work_card_dsq_id =", value, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdNotEqualTo(String value) {
            addCriterion("sal_work_card_dsq_id <>", value, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdGreaterThan(String value) {
            addCriterion("sal_work_card_dsq_id >", value, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdGreaterThanOrEqualTo(String value) {
            addCriterion("sal_work_card_dsq_id >=", value, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdLessThan(String value) {
            addCriterion("sal_work_card_dsq_id <", value, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdLessThanOrEqualTo(String value) {
            addCriterion("sal_work_card_dsq_id <=", value, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdLike(String value) {
            addCriterion("sal_work_card_dsq_id like", value, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdNotLike(String value) {
            addCriterion("sal_work_card_dsq_id not like", value, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdIn(List<String> values) {
            addCriterion("sal_work_card_dsq_id in", values, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdNotIn(List<String> values) {
            addCriterion("sal_work_card_dsq_id not in", values, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdBetween(String value1, String value2) {
            addCriterion("sal_work_card_dsq_id between", value1, value2, "salWorkCardDsqId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardDsqIdNotBetween(String value1, String value2) {
            addCriterion("sal_work_card_dsq_id not between", value1, value2, "salWorkCardDsqId");
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