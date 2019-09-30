package cn.chiucheung.po.sales.workcard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalWorkCardEiaExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalWorkCardEiaExample() {
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

        public Criteria andSequenceEqualTo(String value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(String value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(String value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(String value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(String value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(String value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLike(String value) {
            addCriterion("sequence like", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotLike(String value) {
            addCriterion("sequence not like", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<String> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<String> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(String value1, String value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(String value1, String value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andMainColorIsNull() {
            addCriterion("main_color is null");
            return (Criteria) this;
        }

        public Criteria andMainColorIsNotNull() {
            addCriterion("main_color is not null");
            return (Criteria) this;
        }

        public Criteria andMainColorEqualTo(String value) {
            addCriterion("main_color =", value, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorNotEqualTo(String value) {
            addCriterion("main_color <>", value, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorGreaterThan(String value) {
            addCriterion("main_color >", value, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorGreaterThanOrEqualTo(String value) {
            addCriterion("main_color >=", value, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorLessThan(String value) {
            addCriterion("main_color <", value, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorLessThanOrEqualTo(String value) {
            addCriterion("main_color <=", value, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorLike(String value) {
            addCriterion("main_color like", value, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorNotLike(String value) {
            addCriterion("main_color not like", value, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorIn(List<String> values) {
            addCriterion("main_color in", values, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorNotIn(List<String> values) {
            addCriterion("main_color not in", values, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorBetween(String value1, String value2) {
            addCriterion("main_color between", value1, value2, "mainColor");
            return (Criteria) this;
        }

        public Criteria andMainColorNotBetween(String value1, String value2) {
            addCriterion("main_color not between", value1, value2, "mainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorIsNull() {
            addCriterion("other_main_color is null");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorIsNotNull() {
            addCriterion("other_main_color is not null");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorEqualTo(String value) {
            addCriterion("other_main_color =", value, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorNotEqualTo(String value) {
            addCriterion("other_main_color <>", value, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorGreaterThan(String value) {
            addCriterion("other_main_color >", value, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorGreaterThanOrEqualTo(String value) {
            addCriterion("other_main_color >=", value, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorLessThan(String value) {
            addCriterion("other_main_color <", value, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorLessThanOrEqualTo(String value) {
            addCriterion("other_main_color <=", value, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorLike(String value) {
            addCriterion("other_main_color like", value, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorNotLike(String value) {
            addCriterion("other_main_color not like", value, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorIn(List<String> values) {
            addCriterion("other_main_color in", values, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorNotIn(List<String> values) {
            addCriterion("other_main_color not in", values, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorBetween(String value1, String value2) {
            addCriterion("other_main_color between", value1, value2, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andOtherMainColorNotBetween(String value1, String value2) {
            addCriterion("other_main_color not between", value1, value2, "otherMainColor");
            return (Criteria) this;
        }

        public Criteria andSealPlate1IsNull() {
            addCriterion("seal_plate1 is null");
            return (Criteria) this;
        }

        public Criteria andSealPlate1IsNotNull() {
            addCriterion("seal_plate1 is not null");
            return (Criteria) this;
        }

        public Criteria andSealPlate1EqualTo(String value) {
            addCriterion("seal_plate1 =", value, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1NotEqualTo(String value) {
            addCriterion("seal_plate1 <>", value, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1GreaterThan(String value) {
            addCriterion("seal_plate1 >", value, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1GreaterThanOrEqualTo(String value) {
            addCriterion("seal_plate1 >=", value, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1LessThan(String value) {
            addCriterion("seal_plate1 <", value, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1LessThanOrEqualTo(String value) {
            addCriterion("seal_plate1 <=", value, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1Like(String value) {
            addCriterion("seal_plate1 like", value, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1NotLike(String value) {
            addCriterion("seal_plate1 not like", value, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1In(List<String> values) {
            addCriterion("seal_plate1 in", values, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1NotIn(List<String> values) {
            addCriterion("seal_plate1 not in", values, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1Between(String value1, String value2) {
            addCriterion("seal_plate1 between", value1, value2, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1NotBetween(String value1, String value2) {
            addCriterion("seal_plate1 not between", value1, value2, "sealPlate1");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentIsNull() {
            addCriterion("seal_plate1_content is null");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentIsNotNull() {
            addCriterion("seal_plate1_content is not null");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentEqualTo(String value) {
            addCriterion("seal_plate1_content =", value, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentNotEqualTo(String value) {
            addCriterion("seal_plate1_content <>", value, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentGreaterThan(String value) {
            addCriterion("seal_plate1_content >", value, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentGreaterThanOrEqualTo(String value) {
            addCriterion("seal_plate1_content >=", value, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentLessThan(String value) {
            addCriterion("seal_plate1_content <", value, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentLessThanOrEqualTo(String value) {
            addCriterion("seal_plate1_content <=", value, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentLike(String value) {
            addCriterion("seal_plate1_content like", value, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentNotLike(String value) {
            addCriterion("seal_plate1_content not like", value, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentIn(List<String> values) {
            addCriterion("seal_plate1_content in", values, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentNotIn(List<String> values) {
            addCriterion("seal_plate1_content not in", values, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentBetween(String value1, String value2) {
            addCriterion("seal_plate1_content between", value1, value2, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate1ContentNotBetween(String value1, String value2) {
            addCriterion("seal_plate1_content not between", value1, value2, "sealPlate1Content");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityIsNull() {
            addCriterion("sp1_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityIsNotNull() {
            addCriterion("sp1_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityEqualTo(String value) {
            addCriterion("sp1_quantity =", value, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityNotEqualTo(String value) {
            addCriterion("sp1_quantity <>", value, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityGreaterThan(String value) {
            addCriterion("sp1_quantity >", value, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityGreaterThanOrEqualTo(String value) {
            addCriterion("sp1_quantity >=", value, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityLessThan(String value) {
            addCriterion("sp1_quantity <", value, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityLessThanOrEqualTo(String value) {
            addCriterion("sp1_quantity <=", value, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityLike(String value) {
            addCriterion("sp1_quantity like", value, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityNotLike(String value) {
            addCriterion("sp1_quantity not like", value, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityIn(List<String> values) {
            addCriterion("sp1_quantity in", values, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityNotIn(List<String> values) {
            addCriterion("sp1_quantity not in", values, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityBetween(String value1, String value2) {
            addCriterion("sp1_quantity between", value1, value2, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1QuantityNotBetween(String value1, String value2) {
            addCriterion("sp1_quantity not between", value1, value2, "sp1Quantity");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkIsNull() {
            addCriterion("sp1_remark is null");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkIsNotNull() {
            addCriterion("sp1_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkEqualTo(String value) {
            addCriterion("sp1_remark =", value, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkNotEqualTo(String value) {
            addCriterion("sp1_remark <>", value, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkGreaterThan(String value) {
            addCriterion("sp1_remark >", value, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sp1_remark >=", value, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkLessThan(String value) {
            addCriterion("sp1_remark <", value, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkLessThanOrEqualTo(String value) {
            addCriterion("sp1_remark <=", value, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkLike(String value) {
            addCriterion("sp1_remark like", value, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkNotLike(String value) {
            addCriterion("sp1_remark not like", value, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkIn(List<String> values) {
            addCriterion("sp1_remark in", values, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkNotIn(List<String> values) {
            addCriterion("sp1_remark not in", values, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkBetween(String value1, String value2) {
            addCriterion("sp1_remark between", value1, value2, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSp1RemarkNotBetween(String value1, String value2) {
            addCriterion("sp1_remark not between", value1, value2, "sp1Remark");
            return (Criteria) this;
        }

        public Criteria andSealPlate2IsNull() {
            addCriterion("seal_plate2 is null");
            return (Criteria) this;
        }

        public Criteria andSealPlate2IsNotNull() {
            addCriterion("seal_plate2 is not null");
            return (Criteria) this;
        }

        public Criteria andSealPlate2EqualTo(String value) {
            addCriterion("seal_plate2 =", value, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2NotEqualTo(String value) {
            addCriterion("seal_plate2 <>", value, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2GreaterThan(String value) {
            addCriterion("seal_plate2 >", value, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2GreaterThanOrEqualTo(String value) {
            addCriterion("seal_plate2 >=", value, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2LessThan(String value) {
            addCriterion("seal_plate2 <", value, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2LessThanOrEqualTo(String value) {
            addCriterion("seal_plate2 <=", value, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2Like(String value) {
            addCriterion("seal_plate2 like", value, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2NotLike(String value) {
            addCriterion("seal_plate2 not like", value, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2In(List<String> values) {
            addCriterion("seal_plate2 in", values, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2NotIn(List<String> values) {
            addCriterion("seal_plate2 not in", values, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2Between(String value1, String value2) {
            addCriterion("seal_plate2 between", value1, value2, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2NotBetween(String value1, String value2) {
            addCriterion("seal_plate2 not between", value1, value2, "sealPlate2");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentIsNull() {
            addCriterion("seal_plate2_content is null");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentIsNotNull() {
            addCriterion("seal_plate2_content is not null");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentEqualTo(String value) {
            addCriterion("seal_plate2_content =", value, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentNotEqualTo(String value) {
            addCriterion("seal_plate2_content <>", value, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentGreaterThan(String value) {
            addCriterion("seal_plate2_content >", value, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentGreaterThanOrEqualTo(String value) {
            addCriterion("seal_plate2_content >=", value, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentLessThan(String value) {
            addCriterion("seal_plate2_content <", value, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentLessThanOrEqualTo(String value) {
            addCriterion("seal_plate2_content <=", value, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentLike(String value) {
            addCriterion("seal_plate2_content like", value, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentNotLike(String value) {
            addCriterion("seal_plate2_content not like", value, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentIn(List<String> values) {
            addCriterion("seal_plate2_content in", values, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentNotIn(List<String> values) {
            addCriterion("seal_plate2_content not in", values, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentBetween(String value1, String value2) {
            addCriterion("seal_plate2_content between", value1, value2, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate2ContentNotBetween(String value1, String value2) {
            addCriterion("seal_plate2_content not between", value1, value2, "sealPlate2Content");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityIsNull() {
            addCriterion("sp2_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityIsNotNull() {
            addCriterion("sp2_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityEqualTo(String value) {
            addCriterion("sp2_quantity =", value, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityNotEqualTo(String value) {
            addCriterion("sp2_quantity <>", value, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityGreaterThan(String value) {
            addCriterion("sp2_quantity >", value, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityGreaterThanOrEqualTo(String value) {
            addCriterion("sp2_quantity >=", value, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityLessThan(String value) {
            addCriterion("sp2_quantity <", value, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityLessThanOrEqualTo(String value) {
            addCriterion("sp2_quantity <=", value, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityLike(String value) {
            addCriterion("sp2_quantity like", value, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityNotLike(String value) {
            addCriterion("sp2_quantity not like", value, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityIn(List<String> values) {
            addCriterion("sp2_quantity in", values, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityNotIn(List<String> values) {
            addCriterion("sp2_quantity not in", values, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityBetween(String value1, String value2) {
            addCriterion("sp2_quantity between", value1, value2, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2QuantityNotBetween(String value1, String value2) {
            addCriterion("sp2_quantity not between", value1, value2, "sp2Quantity");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkIsNull() {
            addCriterion("sp2_remark is null");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkIsNotNull() {
            addCriterion("sp2_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkEqualTo(String value) {
            addCriterion("sp2_remark =", value, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkNotEqualTo(String value) {
            addCriterion("sp2_remark <>", value, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkGreaterThan(String value) {
            addCriterion("sp2_remark >", value, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sp2_remark >=", value, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkLessThan(String value) {
            addCriterion("sp2_remark <", value, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkLessThanOrEqualTo(String value) {
            addCriterion("sp2_remark <=", value, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkLike(String value) {
            addCriterion("sp2_remark like", value, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkNotLike(String value) {
            addCriterion("sp2_remark not like", value, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkIn(List<String> values) {
            addCriterion("sp2_remark in", values, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkNotIn(List<String> values) {
            addCriterion("sp2_remark not in", values, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkBetween(String value1, String value2) {
            addCriterion("sp2_remark between", value1, value2, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSp2RemarkNotBetween(String value1, String value2) {
            addCriterion("sp2_remark not between", value1, value2, "sp2Remark");
            return (Criteria) this;
        }

        public Criteria andSealPlate3IsNull() {
            addCriterion("seal_plate3 is null");
            return (Criteria) this;
        }

        public Criteria andSealPlate3IsNotNull() {
            addCriterion("seal_plate3 is not null");
            return (Criteria) this;
        }

        public Criteria andSealPlate3EqualTo(String value) {
            addCriterion("seal_plate3 =", value, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3NotEqualTo(String value) {
            addCriterion("seal_plate3 <>", value, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3GreaterThan(String value) {
            addCriterion("seal_plate3 >", value, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3GreaterThanOrEqualTo(String value) {
            addCriterion("seal_plate3 >=", value, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3LessThan(String value) {
            addCriterion("seal_plate3 <", value, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3LessThanOrEqualTo(String value) {
            addCriterion("seal_plate3 <=", value, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3Like(String value) {
            addCriterion("seal_plate3 like", value, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3NotLike(String value) {
            addCriterion("seal_plate3 not like", value, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3In(List<String> values) {
            addCriterion("seal_plate3 in", values, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3NotIn(List<String> values) {
            addCriterion("seal_plate3 not in", values, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3Between(String value1, String value2) {
            addCriterion("seal_plate3 between", value1, value2, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3NotBetween(String value1, String value2) {
            addCriterion("seal_plate3 not between", value1, value2, "sealPlate3");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentIsNull() {
            addCriterion("seal_plate3_content is null");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentIsNotNull() {
            addCriterion("seal_plate3_content is not null");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentEqualTo(String value) {
            addCriterion("seal_plate3_content =", value, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentNotEqualTo(String value) {
            addCriterion("seal_plate3_content <>", value, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentGreaterThan(String value) {
            addCriterion("seal_plate3_content >", value, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentGreaterThanOrEqualTo(String value) {
            addCriterion("seal_plate3_content >=", value, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentLessThan(String value) {
            addCriterion("seal_plate3_content <", value, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentLessThanOrEqualTo(String value) {
            addCriterion("seal_plate3_content <=", value, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentLike(String value) {
            addCriterion("seal_plate3_content like", value, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentNotLike(String value) {
            addCriterion("seal_plate3_content not like", value, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentIn(List<String> values) {
            addCriterion("seal_plate3_content in", values, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentNotIn(List<String> values) {
            addCriterion("seal_plate3_content not in", values, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentBetween(String value1, String value2) {
            addCriterion("seal_plate3_content between", value1, value2, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSealPlate3ContentNotBetween(String value1, String value2) {
            addCriterion("seal_plate3_content not between", value1, value2, "sealPlate3Content");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityIsNull() {
            addCriterion("sp3_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityIsNotNull() {
            addCriterion("sp3_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityEqualTo(String value) {
            addCriterion("sp3_quantity =", value, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityNotEqualTo(String value) {
            addCriterion("sp3_quantity <>", value, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityGreaterThan(String value) {
            addCriterion("sp3_quantity >", value, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityGreaterThanOrEqualTo(String value) {
            addCriterion("sp3_quantity >=", value, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityLessThan(String value) {
            addCriterion("sp3_quantity <", value, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityLessThanOrEqualTo(String value) {
            addCriterion("sp3_quantity <=", value, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityLike(String value) {
            addCriterion("sp3_quantity like", value, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityNotLike(String value) {
            addCriterion("sp3_quantity not like", value, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityIn(List<String> values) {
            addCriterion("sp3_quantity in", values, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityNotIn(List<String> values) {
            addCriterion("sp3_quantity not in", values, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityBetween(String value1, String value2) {
            addCriterion("sp3_quantity between", value1, value2, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3QuantityNotBetween(String value1, String value2) {
            addCriterion("sp3_quantity not between", value1, value2, "sp3Quantity");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkIsNull() {
            addCriterion("sp3_remark is null");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkIsNotNull() {
            addCriterion("sp3_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkEqualTo(String value) {
            addCriterion("sp3_remark =", value, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkNotEqualTo(String value) {
            addCriterion("sp3_remark <>", value, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkGreaterThan(String value) {
            addCriterion("sp3_remark >", value, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sp3_remark >=", value, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkLessThan(String value) {
            addCriterion("sp3_remark <", value, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkLessThanOrEqualTo(String value) {
            addCriterion("sp3_remark <=", value, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkLike(String value) {
            addCriterion("sp3_remark like", value, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkNotLike(String value) {
            addCriterion("sp3_remark not like", value, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkIn(List<String> values) {
            addCriterion("sp3_remark in", values, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkNotIn(List<String> values) {
            addCriterion("sp3_remark not in", values, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkBetween(String value1, String value2) {
            addCriterion("sp3_remark between", value1, value2, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andSp3RemarkNotBetween(String value1, String value2) {
            addCriterion("sp3_remark not between", value1, value2, "sp3Remark");
            return (Criteria) this;
        }

        public Criteria andTubePlugIsNull() {
            addCriterion("tube_plug is null");
            return (Criteria) this;
        }

        public Criteria andTubePlugIsNotNull() {
            addCriterion("tube_plug is not null");
            return (Criteria) this;
        }

        public Criteria andTubePlugEqualTo(String value) {
            addCriterion("tube_plug =", value, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugNotEqualTo(String value) {
            addCriterion("tube_plug <>", value, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugGreaterThan(String value) {
            addCriterion("tube_plug >", value, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugGreaterThanOrEqualTo(String value) {
            addCriterion("tube_plug >=", value, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugLessThan(String value) {
            addCriterion("tube_plug <", value, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugLessThanOrEqualTo(String value) {
            addCriterion("tube_plug <=", value, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugLike(String value) {
            addCriterion("tube_plug like", value, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugNotLike(String value) {
            addCriterion("tube_plug not like", value, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugIn(List<String> values) {
            addCriterion("tube_plug in", values, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugNotIn(List<String> values) {
            addCriterion("tube_plug not in", values, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugBetween(String value1, String value2) {
            addCriterion("tube_plug between", value1, value2, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTubePlugNotBetween(String value1, String value2) {
            addCriterion("tube_plug not between", value1, value2, "tubePlug");
            return (Criteria) this;
        }

        public Criteria andTpQuantityIsNull() {
            addCriterion("tp_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTpQuantityIsNotNull() {
            addCriterion("tp_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTpQuantityEqualTo(String value) {
            addCriterion("tp_quantity =", value, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityNotEqualTo(String value) {
            addCriterion("tp_quantity <>", value, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityGreaterThan(String value) {
            addCriterion("tp_quantity >", value, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("tp_quantity >=", value, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityLessThan(String value) {
            addCriterion("tp_quantity <", value, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityLessThanOrEqualTo(String value) {
            addCriterion("tp_quantity <=", value, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityLike(String value) {
            addCriterion("tp_quantity like", value, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityNotLike(String value) {
            addCriterion("tp_quantity not like", value, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityIn(List<String> values) {
            addCriterion("tp_quantity in", values, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityNotIn(List<String> values) {
            addCriterion("tp_quantity not in", values, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityBetween(String value1, String value2) {
            addCriterion("tp_quantity between", value1, value2, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpQuantityNotBetween(String value1, String value2) {
            addCriterion("tp_quantity not between", value1, value2, "tpQuantity");
            return (Criteria) this;
        }

        public Criteria andTpRemarkIsNull() {
            addCriterion("tp_remark is null");
            return (Criteria) this;
        }

        public Criteria andTpRemarkIsNotNull() {
            addCriterion("tp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTpRemarkEqualTo(String value) {
            addCriterion("tp_remark =", value, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkNotEqualTo(String value) {
            addCriterion("tp_remark <>", value, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkGreaterThan(String value) {
            addCriterion("tp_remark >", value, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("tp_remark >=", value, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkLessThan(String value) {
            addCriterion("tp_remark <", value, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkLessThanOrEqualTo(String value) {
            addCriterion("tp_remark <=", value, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkLike(String value) {
            addCriterion("tp_remark like", value, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkNotLike(String value) {
            addCriterion("tp_remark not like", value, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkIn(List<String> values) {
            addCriterion("tp_remark in", values, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkNotIn(List<String> values) {
            addCriterion("tp_remark not in", values, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkBetween(String value1, String value2) {
            addCriterion("tp_remark between", value1, value2, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andTpRemarkNotBetween(String value1, String value2) {
            addCriterion("tp_remark not between", value1, value2, "tpRemark");
            return (Criteria) this;
        }

        public Criteria andCbQuantityIsNull() {
            addCriterion("cb_quantity is null");
            return (Criteria) this;
        }

        public Criteria andCbQuantityIsNotNull() {
            addCriterion("cb_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andCbQuantityEqualTo(String value) {
            addCriterion("cb_quantity =", value, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityNotEqualTo(String value) {
            addCriterion("cb_quantity <>", value, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityGreaterThan(String value) {
            addCriterion("cb_quantity >", value, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("cb_quantity >=", value, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityLessThan(String value) {
            addCriterion("cb_quantity <", value, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityLessThanOrEqualTo(String value) {
            addCriterion("cb_quantity <=", value, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityLike(String value) {
            addCriterion("cb_quantity like", value, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityNotLike(String value) {
            addCriterion("cb_quantity not like", value, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityIn(List<String> values) {
            addCriterion("cb_quantity in", values, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityNotIn(List<String> values) {
            addCriterion("cb_quantity not in", values, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityBetween(String value1, String value2) {
            addCriterion("cb_quantity between", value1, value2, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbQuantityNotBetween(String value1, String value2) {
            addCriterion("cb_quantity not between", value1, value2, "cbQuantity");
            return (Criteria) this;
        }

        public Criteria andCbRemarkIsNull() {
            addCriterion("cb_remark is null");
            return (Criteria) this;
        }

        public Criteria andCbRemarkIsNotNull() {
            addCriterion("cb_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCbRemarkEqualTo(String value) {
            addCriterion("cb_remark =", value, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkNotEqualTo(String value) {
            addCriterion("cb_remark <>", value, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkGreaterThan(String value) {
            addCriterion("cb_remark >", value, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("cb_remark >=", value, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkLessThan(String value) {
            addCriterion("cb_remark <", value, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkLessThanOrEqualTo(String value) {
            addCriterion("cb_remark <=", value, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkLike(String value) {
            addCriterion("cb_remark like", value, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkNotLike(String value) {
            addCriterion("cb_remark not like", value, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkIn(List<String> values) {
            addCriterion("cb_remark in", values, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkNotIn(List<String> values) {
            addCriterion("cb_remark not in", values, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkBetween(String value1, String value2) {
            addCriterion("cb_remark between", value1, value2, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andCbRemarkNotBetween(String value1, String value2) {
            addCriterion("cb_remark not between", value1, value2, "cbRemark");
            return (Criteria) this;
        }

        public Criteria andJoeCodeIsNull() {
            addCriterion("joe_code is null");
            return (Criteria) this;
        }

        public Criteria andJoeCodeIsNotNull() {
            addCriterion("joe_code is not null");
            return (Criteria) this;
        }

        public Criteria andJoeCodeEqualTo(String value) {
            addCriterion("joe_code =", value, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeNotEqualTo(String value) {
            addCriterion("joe_code <>", value, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeGreaterThan(String value) {
            addCriterion("joe_code >", value, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("joe_code >=", value, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeLessThan(String value) {
            addCriterion("joe_code <", value, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeLessThanOrEqualTo(String value) {
            addCriterion("joe_code <=", value, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeLike(String value) {
            addCriterion("joe_code like", value, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeNotLike(String value) {
            addCriterion("joe_code not like", value, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeIn(List<String> values) {
            addCriterion("joe_code in", values, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeNotIn(List<String> values) {
            addCriterion("joe_code not in", values, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeBetween(String value1, String value2) {
            addCriterion("joe_code between", value1, value2, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJoeCodeNotBetween(String value1, String value2) {
            addCriterion("joe_code not between", value1, value2, "joeCode");
            return (Criteria) this;
        }

        public Criteria andJcQuantityIsNull() {
            addCriterion("jc_quantity is null");
            return (Criteria) this;
        }

        public Criteria andJcQuantityIsNotNull() {
            addCriterion("jc_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andJcQuantityEqualTo(String value) {
            addCriterion("jc_quantity =", value, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityNotEqualTo(String value) {
            addCriterion("jc_quantity <>", value, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityGreaterThan(String value) {
            addCriterion("jc_quantity >", value, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("jc_quantity >=", value, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityLessThan(String value) {
            addCriterion("jc_quantity <", value, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityLessThanOrEqualTo(String value) {
            addCriterion("jc_quantity <=", value, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityLike(String value) {
            addCriterion("jc_quantity like", value, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityNotLike(String value) {
            addCriterion("jc_quantity not like", value, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityIn(List<String> values) {
            addCriterion("jc_quantity in", values, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityNotIn(List<String> values) {
            addCriterion("jc_quantity not in", values, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityBetween(String value1, String value2) {
            addCriterion("jc_quantity between", value1, value2, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcQuantityNotBetween(String value1, String value2) {
            addCriterion("jc_quantity not between", value1, value2, "jcQuantity");
            return (Criteria) this;
        }

        public Criteria andJcRemarkIsNull() {
            addCriterion("jc_remark is null");
            return (Criteria) this;
        }

        public Criteria andJcRemarkIsNotNull() {
            addCriterion("jc_remark is not null");
            return (Criteria) this;
        }

        public Criteria andJcRemarkEqualTo(String value) {
            addCriterion("jc_remark =", value, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkNotEqualTo(String value) {
            addCriterion("jc_remark <>", value, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkGreaterThan(String value) {
            addCriterion("jc_remark >", value, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("jc_remark >=", value, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkLessThan(String value) {
            addCriterion("jc_remark <", value, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkLessThanOrEqualTo(String value) {
            addCriterion("jc_remark <=", value, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkLike(String value) {
            addCriterion("jc_remark like", value, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkNotLike(String value) {
            addCriterion("jc_remark not like", value, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkIn(List<String> values) {
            addCriterion("jc_remark in", values, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkNotIn(List<String> values) {
            addCriterion("jc_remark not in", values, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkBetween(String value1, String value2) {
            addCriterion("jc_remark between", value1, value2, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andJcRemarkNotBetween(String value1, String value2) {
            addCriterion("jc_remark not between", value1, value2, "jcRemark");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450IsNull() {
            addCriterion("layer_board450 is null");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450IsNotNull() {
            addCriterion("layer_board450 is not null");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450EqualTo(String value) {
            addCriterion("layer_board450 =", value, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450NotEqualTo(String value) {
            addCriterion("layer_board450 <>", value, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450GreaterThan(String value) {
            addCriterion("layer_board450 >", value, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450GreaterThanOrEqualTo(String value) {
            addCriterion("layer_board450 >=", value, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450LessThan(String value) {
            addCriterion("layer_board450 <", value, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450LessThanOrEqualTo(String value) {
            addCriterion("layer_board450 <=", value, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450Like(String value) {
            addCriterion("layer_board450 like", value, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450NotLike(String value) {
            addCriterion("layer_board450 not like", value, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450In(List<String> values) {
            addCriterion("layer_board450 in", values, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450NotIn(List<String> values) {
            addCriterion("layer_board450 not in", values, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450Between(String value1, String value2) {
            addCriterion("layer_board450 between", value1, value2, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLayerBoard450NotBetween(String value1, String value2) {
            addCriterion("layer_board450 not between", value1, value2, "layerBoard450");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityIsNull() {
            addCriterion("lb450_quantity is null");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityIsNotNull() {
            addCriterion("lb450_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityEqualTo(String value) {
            addCriterion("lb450_quantity =", value, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityNotEqualTo(String value) {
            addCriterion("lb450_quantity <>", value, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityGreaterThan(String value) {
            addCriterion("lb450_quantity >", value, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityGreaterThanOrEqualTo(String value) {
            addCriterion("lb450_quantity >=", value, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityLessThan(String value) {
            addCriterion("lb450_quantity <", value, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityLessThanOrEqualTo(String value) {
            addCriterion("lb450_quantity <=", value, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityLike(String value) {
            addCriterion("lb450_quantity like", value, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityNotLike(String value) {
            addCriterion("lb450_quantity not like", value, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityIn(List<String> values) {
            addCriterion("lb450_quantity in", values, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityNotIn(List<String> values) {
            addCriterion("lb450_quantity not in", values, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityBetween(String value1, String value2) {
            addCriterion("lb450_quantity between", value1, value2, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450QuantityNotBetween(String value1, String value2) {
            addCriterion("lb450_quantity not between", value1, value2, "lb450Quantity");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkIsNull() {
            addCriterion("lb450_remark is null");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkIsNotNull() {
            addCriterion("lb450_remark is not null");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkEqualTo(String value) {
            addCriterion("lb450_remark =", value, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkNotEqualTo(String value) {
            addCriterion("lb450_remark <>", value, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkGreaterThan(String value) {
            addCriterion("lb450_remark >", value, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkGreaterThanOrEqualTo(String value) {
            addCriterion("lb450_remark >=", value, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkLessThan(String value) {
            addCriterion("lb450_remark <", value, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkLessThanOrEqualTo(String value) {
            addCriterion("lb450_remark <=", value, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkLike(String value) {
            addCriterion("lb450_remark like", value, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkNotLike(String value) {
            addCriterion("lb450_remark not like", value, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkIn(List<String> values) {
            addCriterion("lb450_remark in", values, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkNotIn(List<String> values) {
            addCriterion("lb450_remark not in", values, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkBetween(String value1, String value2) {
            addCriterion("lb450_remark between", value1, value2, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLb450RemarkNotBetween(String value1, String value2) {
            addCriterion("lb450_remark not between", value1, value2, "lb450Remark");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620IsNull() {
            addCriterion("layer_board620 is null");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620IsNotNull() {
            addCriterion("layer_board620 is not null");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620EqualTo(String value) {
            addCriterion("layer_board620 =", value, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620NotEqualTo(String value) {
            addCriterion("layer_board620 <>", value, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620GreaterThan(String value) {
            addCriterion("layer_board620 >", value, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620GreaterThanOrEqualTo(String value) {
            addCriterion("layer_board620 >=", value, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620LessThan(String value) {
            addCriterion("layer_board620 <", value, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620LessThanOrEqualTo(String value) {
            addCriterion("layer_board620 <=", value, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620Like(String value) {
            addCriterion("layer_board620 like", value, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620NotLike(String value) {
            addCriterion("layer_board620 not like", value, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620In(List<String> values) {
            addCriterion("layer_board620 in", values, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620NotIn(List<String> values) {
            addCriterion("layer_board620 not in", values, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620Between(String value1, String value2) {
            addCriterion("layer_board620 between", value1, value2, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLayerBoard620NotBetween(String value1, String value2) {
            addCriterion("layer_board620 not between", value1, value2, "layerBoard620");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityIsNull() {
            addCriterion("lb620_quantity is null");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityIsNotNull() {
            addCriterion("lb620_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityEqualTo(String value) {
            addCriterion("lb620_quantity =", value, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityNotEqualTo(String value) {
            addCriterion("lb620_quantity <>", value, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityGreaterThan(String value) {
            addCriterion("lb620_quantity >", value, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityGreaterThanOrEqualTo(String value) {
            addCriterion("lb620_quantity >=", value, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityLessThan(String value) {
            addCriterion("lb620_quantity <", value, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityLessThanOrEqualTo(String value) {
            addCriterion("lb620_quantity <=", value, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityLike(String value) {
            addCriterion("lb620_quantity like", value, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityNotLike(String value) {
            addCriterion("lb620_quantity not like", value, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityIn(List<String> values) {
            addCriterion("lb620_quantity in", values, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityNotIn(List<String> values) {
            addCriterion("lb620_quantity not in", values, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityBetween(String value1, String value2) {
            addCriterion("lb620_quantity between", value1, value2, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620QuantityNotBetween(String value1, String value2) {
            addCriterion("lb620_quantity not between", value1, value2, "lb620Quantity");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkIsNull() {
            addCriterion("lb620_remark is null");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkIsNotNull() {
            addCriterion("lb620_remark is not null");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkEqualTo(String value) {
            addCriterion("lb620_remark =", value, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkNotEqualTo(String value) {
            addCriterion("lb620_remark <>", value, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkGreaterThan(String value) {
            addCriterion("lb620_remark >", value, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkGreaterThanOrEqualTo(String value) {
            addCriterion("lb620_remark >=", value, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkLessThan(String value) {
            addCriterion("lb620_remark <", value, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkLessThanOrEqualTo(String value) {
            addCriterion("lb620_remark <=", value, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkLike(String value) {
            addCriterion("lb620_remark like", value, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkNotLike(String value) {
            addCriterion("lb620_remark not like", value, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkIn(List<String> values) {
            addCriterion("lb620_remark in", values, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkNotIn(List<String> values) {
            addCriterion("lb620_remark not in", values, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkBetween(String value1, String value2) {
            addCriterion("lb620_remark between", value1, value2, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andLb620RemarkNotBetween(String value1, String value2) {
            addCriterion("lb620_remark not between", value1, value2, "lb620Remark");
            return (Criteria) this;
        }

        public Criteria andTray1IsNull() {
            addCriterion("tray1 is null");
            return (Criteria) this;
        }

        public Criteria andTray1IsNotNull() {
            addCriterion("tray1 is not null");
            return (Criteria) this;
        }

        public Criteria andTray1EqualTo(String value) {
            addCriterion("tray1 =", value, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1NotEqualTo(String value) {
            addCriterion("tray1 <>", value, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1GreaterThan(String value) {
            addCriterion("tray1 >", value, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1GreaterThanOrEqualTo(String value) {
            addCriterion("tray1 >=", value, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1LessThan(String value) {
            addCriterion("tray1 <", value, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1LessThanOrEqualTo(String value) {
            addCriterion("tray1 <=", value, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1Like(String value) {
            addCriterion("tray1 like", value, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1NotLike(String value) {
            addCriterion("tray1 not like", value, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1In(List<String> values) {
            addCriterion("tray1 in", values, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1NotIn(List<String> values) {
            addCriterion("tray1 not in", values, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1Between(String value1, String value2) {
            addCriterion("tray1 between", value1, value2, "tray1");
            return (Criteria) this;
        }

        public Criteria andTray1NotBetween(String value1, String value2) {
            addCriterion("tray1 not between", value1, value2, "tray1");
            return (Criteria) this;
        }

        public Criteria andT1QuantityIsNull() {
            addCriterion("t1_quantity is null");
            return (Criteria) this;
        }

        public Criteria andT1QuantityIsNotNull() {
            addCriterion("t1_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andT1QuantityEqualTo(String value) {
            addCriterion("t1_quantity =", value, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityNotEqualTo(String value) {
            addCriterion("t1_quantity <>", value, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityGreaterThan(String value) {
            addCriterion("t1_quantity >", value, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityGreaterThanOrEqualTo(String value) {
            addCriterion("t1_quantity >=", value, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityLessThan(String value) {
            addCriterion("t1_quantity <", value, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityLessThanOrEqualTo(String value) {
            addCriterion("t1_quantity <=", value, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityLike(String value) {
            addCriterion("t1_quantity like", value, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityNotLike(String value) {
            addCriterion("t1_quantity not like", value, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityIn(List<String> values) {
            addCriterion("t1_quantity in", values, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityNotIn(List<String> values) {
            addCriterion("t1_quantity not in", values, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityBetween(String value1, String value2) {
            addCriterion("t1_quantity between", value1, value2, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1QuantityNotBetween(String value1, String value2) {
            addCriterion("t1_quantity not between", value1, value2, "t1Quantity");
            return (Criteria) this;
        }

        public Criteria andT1RemarkIsNull() {
            addCriterion("t1_remark is null");
            return (Criteria) this;
        }

        public Criteria andT1RemarkIsNotNull() {
            addCriterion("t1_remark is not null");
            return (Criteria) this;
        }

        public Criteria andT1RemarkEqualTo(String value) {
            addCriterion("t1_remark =", value, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkNotEqualTo(String value) {
            addCriterion("t1_remark <>", value, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkGreaterThan(String value) {
            addCriterion("t1_remark >", value, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkGreaterThanOrEqualTo(String value) {
            addCriterion("t1_remark >=", value, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkLessThan(String value) {
            addCriterion("t1_remark <", value, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkLessThanOrEqualTo(String value) {
            addCriterion("t1_remark <=", value, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkLike(String value) {
            addCriterion("t1_remark like", value, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkNotLike(String value) {
            addCriterion("t1_remark not like", value, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkIn(List<String> values) {
            addCriterion("t1_remark in", values, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkNotIn(List<String> values) {
            addCriterion("t1_remark not in", values, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkBetween(String value1, String value2) {
            addCriterion("t1_remark between", value1, value2, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andT1RemarkNotBetween(String value1, String value2) {
            addCriterion("t1_remark not between", value1, value2, "t1Remark");
            return (Criteria) this;
        }

        public Criteria andTray2IsNull() {
            addCriterion("tray2 is null");
            return (Criteria) this;
        }

        public Criteria andTray2IsNotNull() {
            addCriterion("tray2 is not null");
            return (Criteria) this;
        }

        public Criteria andTray2EqualTo(String value) {
            addCriterion("tray2 =", value, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2NotEqualTo(String value) {
            addCriterion("tray2 <>", value, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2GreaterThan(String value) {
            addCriterion("tray2 >", value, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2GreaterThanOrEqualTo(String value) {
            addCriterion("tray2 >=", value, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2LessThan(String value) {
            addCriterion("tray2 <", value, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2LessThanOrEqualTo(String value) {
            addCriterion("tray2 <=", value, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2Like(String value) {
            addCriterion("tray2 like", value, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2NotLike(String value) {
            addCriterion("tray2 not like", value, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2In(List<String> values) {
            addCriterion("tray2 in", values, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2NotIn(List<String> values) {
            addCriterion("tray2 not in", values, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2Between(String value1, String value2) {
            addCriterion("tray2 between", value1, value2, "tray2");
            return (Criteria) this;
        }

        public Criteria andTray2NotBetween(String value1, String value2) {
            addCriterion("tray2 not between", value1, value2, "tray2");
            return (Criteria) this;
        }

        public Criteria andT2QuantityIsNull() {
            addCriterion("t2_quantity is null");
            return (Criteria) this;
        }

        public Criteria andT2QuantityIsNotNull() {
            addCriterion("t2_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andT2QuantityEqualTo(String value) {
            addCriterion("t2_quantity =", value, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityNotEqualTo(String value) {
            addCriterion("t2_quantity <>", value, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityGreaterThan(String value) {
            addCriterion("t2_quantity >", value, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityGreaterThanOrEqualTo(String value) {
            addCriterion("t2_quantity >=", value, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityLessThan(String value) {
            addCriterion("t2_quantity <", value, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityLessThanOrEqualTo(String value) {
            addCriterion("t2_quantity <=", value, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityLike(String value) {
            addCriterion("t2_quantity like", value, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityNotLike(String value) {
            addCriterion("t2_quantity not like", value, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityIn(List<String> values) {
            addCriterion("t2_quantity in", values, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityNotIn(List<String> values) {
            addCriterion("t2_quantity not in", values, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityBetween(String value1, String value2) {
            addCriterion("t2_quantity between", value1, value2, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2QuantityNotBetween(String value1, String value2) {
            addCriterion("t2_quantity not between", value1, value2, "t2Quantity");
            return (Criteria) this;
        }

        public Criteria andT2RemarkIsNull() {
            addCriterion("t2_remark is null");
            return (Criteria) this;
        }

        public Criteria andT2RemarkIsNotNull() {
            addCriterion("t2_remark is not null");
            return (Criteria) this;
        }

        public Criteria andT2RemarkEqualTo(String value) {
            addCriterion("t2_remark =", value, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkNotEqualTo(String value) {
            addCriterion("t2_remark <>", value, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkGreaterThan(String value) {
            addCriterion("t2_remark >", value, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkGreaterThanOrEqualTo(String value) {
            addCriterion("t2_remark >=", value, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkLessThan(String value) {
            addCriterion("t2_remark <", value, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkLessThanOrEqualTo(String value) {
            addCriterion("t2_remark <=", value, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkLike(String value) {
            addCriterion("t2_remark like", value, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkNotLike(String value) {
            addCriterion("t2_remark not like", value, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkIn(List<String> values) {
            addCriterion("t2_remark in", values, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkNotIn(List<String> values) {
            addCriterion("t2_remark not in", values, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkBetween(String value1, String value2) {
            addCriterion("t2_remark between", value1, value2, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andT2RemarkNotBetween(String value1, String value2) {
            addCriterion("t2_remark not between", value1, value2, "t2Remark");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityIsNull() {
            addCriterion("ab1_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityIsNotNull() {
            addCriterion("ab1_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityEqualTo(String value) {
            addCriterion("ab1_quantity =", value, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityNotEqualTo(String value) {
            addCriterion("ab1_quantity <>", value, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityGreaterThan(String value) {
            addCriterion("ab1_quantity >", value, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityGreaterThanOrEqualTo(String value) {
            addCriterion("ab1_quantity >=", value, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityLessThan(String value) {
            addCriterion("ab1_quantity <", value, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityLessThanOrEqualTo(String value) {
            addCriterion("ab1_quantity <=", value, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityLike(String value) {
            addCriterion("ab1_quantity like", value, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityNotLike(String value) {
            addCriterion("ab1_quantity not like", value, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityIn(List<String> values) {
            addCriterion("ab1_quantity in", values, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityNotIn(List<String> values) {
            addCriterion("ab1_quantity not in", values, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityBetween(String value1, String value2) {
            addCriterion("ab1_quantity between", value1, value2, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1QuantityNotBetween(String value1, String value2) {
            addCriterion("ab1_quantity not between", value1, value2, "ab1Quantity");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkIsNull() {
            addCriterion("ab1_remark is null");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkIsNotNull() {
            addCriterion("ab1_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkEqualTo(String value) {
            addCriterion("ab1_remark =", value, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkNotEqualTo(String value) {
            addCriterion("ab1_remark <>", value, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkGreaterThan(String value) {
            addCriterion("ab1_remark >", value, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ab1_remark >=", value, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkLessThan(String value) {
            addCriterion("ab1_remark <", value, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkLessThanOrEqualTo(String value) {
            addCriterion("ab1_remark <=", value, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkLike(String value) {
            addCriterion("ab1_remark like", value, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkNotLike(String value) {
            addCriterion("ab1_remark not like", value, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkIn(List<String> values) {
            addCriterion("ab1_remark in", values, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkNotIn(List<String> values) {
            addCriterion("ab1_remark not in", values, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkBetween(String value1, String value2) {
            addCriterion("ab1_remark between", value1, value2, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb1RemarkNotBetween(String value1, String value2) {
            addCriterion("ab1_remark not between", value1, value2, "ab1Remark");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityIsNull() {
            addCriterion("ab2_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityIsNotNull() {
            addCriterion("ab2_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityEqualTo(String value) {
            addCriterion("ab2_quantity =", value, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityNotEqualTo(String value) {
            addCriterion("ab2_quantity <>", value, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityGreaterThan(String value) {
            addCriterion("ab2_quantity >", value, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityGreaterThanOrEqualTo(String value) {
            addCriterion("ab2_quantity >=", value, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityLessThan(String value) {
            addCriterion("ab2_quantity <", value, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityLessThanOrEqualTo(String value) {
            addCriterion("ab2_quantity <=", value, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityLike(String value) {
            addCriterion("ab2_quantity like", value, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityNotLike(String value) {
            addCriterion("ab2_quantity not like", value, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityIn(List<String> values) {
            addCriterion("ab2_quantity in", values, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityNotIn(List<String> values) {
            addCriterion("ab2_quantity not in", values, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityBetween(String value1, String value2) {
            addCriterion("ab2_quantity between", value1, value2, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2QuantityNotBetween(String value1, String value2) {
            addCriterion("ab2_quantity not between", value1, value2, "ab2Quantity");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkIsNull() {
            addCriterion("ab2_remark is null");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkIsNotNull() {
            addCriterion("ab2_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkEqualTo(String value) {
            addCriterion("ab2_remark =", value, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkNotEqualTo(String value) {
            addCriterion("ab2_remark <>", value, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkGreaterThan(String value) {
            addCriterion("ab2_remark >", value, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ab2_remark >=", value, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkLessThan(String value) {
            addCriterion("ab2_remark <", value, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkLessThanOrEqualTo(String value) {
            addCriterion("ab2_remark <=", value, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkLike(String value) {
            addCriterion("ab2_remark like", value, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkNotLike(String value) {
            addCriterion("ab2_remark not like", value, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkIn(List<String> values) {
            addCriterion("ab2_remark in", values, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkNotIn(List<String> values) {
            addCriterion("ab2_remark not in", values, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkBetween(String value1, String value2) {
            addCriterion("ab2_remark between", value1, value2, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andAb2RemarkNotBetween(String value1, String value2) {
            addCriterion("ab2_remark not between", value1, value2, "ab2Remark");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1IsNull() {
            addCriterion("vtr_activity_basin1 is null");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1IsNotNull() {
            addCriterion("vtr_activity_basin1 is not null");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1EqualTo(String value) {
            addCriterion("vtr_activity_basin1 =", value, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1NotEqualTo(String value) {
            addCriterion("vtr_activity_basin1 <>", value, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1GreaterThan(String value) {
            addCriterion("vtr_activity_basin1 >", value, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1GreaterThanOrEqualTo(String value) {
            addCriterion("vtr_activity_basin1 >=", value, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1LessThan(String value) {
            addCriterion("vtr_activity_basin1 <", value, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1LessThanOrEqualTo(String value) {
            addCriterion("vtr_activity_basin1 <=", value, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1Like(String value) {
            addCriterion("vtr_activity_basin1 like", value, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1NotLike(String value) {
            addCriterion("vtr_activity_basin1 not like", value, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1In(List<String> values) {
            addCriterion("vtr_activity_basin1 in", values, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1NotIn(List<String> values) {
            addCriterion("vtr_activity_basin1 not in", values, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1Between(String value1, String value2) {
            addCriterion("vtr_activity_basin1 between", value1, value2, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin1NotBetween(String value1, String value2) {
            addCriterion("vtr_activity_basin1 not between", value1, value2, "vtrActivityBasin1");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2IsNull() {
            addCriterion("vtr_activity_basin2 is null");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2IsNotNull() {
            addCriterion("vtr_activity_basin2 is not null");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2EqualTo(String value) {
            addCriterion("vtr_activity_basin2 =", value, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2NotEqualTo(String value) {
            addCriterion("vtr_activity_basin2 <>", value, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2GreaterThan(String value) {
            addCriterion("vtr_activity_basin2 >", value, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2GreaterThanOrEqualTo(String value) {
            addCriterion("vtr_activity_basin2 >=", value, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2LessThan(String value) {
            addCriterion("vtr_activity_basin2 <", value, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2LessThanOrEqualTo(String value) {
            addCriterion("vtr_activity_basin2 <=", value, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2Like(String value) {
            addCriterion("vtr_activity_basin2 like", value, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2NotLike(String value) {
            addCriterion("vtr_activity_basin2 not like", value, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2In(List<String> values) {
            addCriterion("vtr_activity_basin2 in", values, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2NotIn(List<String> values) {
            addCriterion("vtr_activity_basin2 not in", values, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2Between(String value1, String value2) {
            addCriterion("vtr_activity_basin2 between", value1, value2, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVtrActivityBasin2NotBetween(String value1, String value2) {
            addCriterion("vtr_activity_basin2 not between", value1, value2, "vtrActivityBasin2");
            return (Criteria) this;
        }

        public Criteria andVabQuantityIsNull() {
            addCriterion("vab_quantity is null");
            return (Criteria) this;
        }

        public Criteria andVabQuantityIsNotNull() {
            addCriterion("vab_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andVabQuantityEqualTo(String value) {
            addCriterion("vab_quantity =", value, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityNotEqualTo(String value) {
            addCriterion("vab_quantity <>", value, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityGreaterThan(String value) {
            addCriterion("vab_quantity >", value, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("vab_quantity >=", value, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityLessThan(String value) {
            addCriterion("vab_quantity <", value, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityLessThanOrEqualTo(String value) {
            addCriterion("vab_quantity <=", value, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityLike(String value) {
            addCriterion("vab_quantity like", value, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityNotLike(String value) {
            addCriterion("vab_quantity not like", value, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityIn(List<String> values) {
            addCriterion("vab_quantity in", values, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityNotIn(List<String> values) {
            addCriterion("vab_quantity not in", values, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityBetween(String value1, String value2) {
            addCriterion("vab_quantity between", value1, value2, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabQuantityNotBetween(String value1, String value2) {
            addCriterion("vab_quantity not between", value1, value2, "vabQuantity");
            return (Criteria) this;
        }

        public Criteria andVabRemarkIsNull() {
            addCriterion("vab_remark is null");
            return (Criteria) this;
        }

        public Criteria andVabRemarkIsNotNull() {
            addCriterion("vab_remark is not null");
            return (Criteria) this;
        }

        public Criteria andVabRemarkEqualTo(String value) {
            addCriterion("vab_remark =", value, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkNotEqualTo(String value) {
            addCriterion("vab_remark <>", value, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkGreaterThan(String value) {
            addCriterion("vab_remark >", value, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("vab_remark >=", value, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkLessThan(String value) {
            addCriterion("vab_remark <", value, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkLessThanOrEqualTo(String value) {
            addCriterion("vab_remark <=", value, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkLike(String value) {
            addCriterion("vab_remark like", value, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkNotLike(String value) {
            addCriterion("vab_remark not like", value, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkIn(List<String> values) {
            addCriterion("vab_remark in", values, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkNotIn(List<String> values) {
            addCriterion("vab_remark not in", values, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkBetween(String value1, String value2) {
            addCriterion("vab_remark between", value1, value2, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andVabRemarkNotBetween(String value1, String value2) {
            addCriterion("vab_remark not between", value1, value2, "vabRemark");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinIsNull() {
            addCriterion("lcd_activity_basin is null");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinIsNotNull() {
            addCriterion("lcd_activity_basin is not null");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinEqualTo(String value) {
            addCriterion("lcd_activity_basin =", value, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinNotEqualTo(String value) {
            addCriterion("lcd_activity_basin <>", value, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinGreaterThan(String value) {
            addCriterion("lcd_activity_basin >", value, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinGreaterThanOrEqualTo(String value) {
            addCriterion("lcd_activity_basin >=", value, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinLessThan(String value) {
            addCriterion("lcd_activity_basin <", value, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinLessThanOrEqualTo(String value) {
            addCriterion("lcd_activity_basin <=", value, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinLike(String value) {
            addCriterion("lcd_activity_basin like", value, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinNotLike(String value) {
            addCriterion("lcd_activity_basin not like", value, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinIn(List<String> values) {
            addCriterion("lcd_activity_basin in", values, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinNotIn(List<String> values) {
            addCriterion("lcd_activity_basin not in", values, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinBetween(String value1, String value2) {
            addCriterion("lcd_activity_basin between", value1, value2, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLcdActivityBasinNotBetween(String value1, String value2) {
            addCriterion("lcd_activity_basin not between", value1, value2, "lcdActivityBasin");
            return (Criteria) this;
        }

        public Criteria andLabQuantityIsNull() {
            addCriterion("lab_quantity is null");
            return (Criteria) this;
        }

        public Criteria andLabQuantityIsNotNull() {
            addCriterion("lab_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andLabQuantityEqualTo(String value) {
            addCriterion("lab_quantity =", value, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityNotEqualTo(String value) {
            addCriterion("lab_quantity <>", value, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityGreaterThan(String value) {
            addCriterion("lab_quantity >", value, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("lab_quantity >=", value, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityLessThan(String value) {
            addCriterion("lab_quantity <", value, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityLessThanOrEqualTo(String value) {
            addCriterion("lab_quantity <=", value, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityLike(String value) {
            addCriterion("lab_quantity like", value, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityNotLike(String value) {
            addCriterion("lab_quantity not like", value, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityIn(List<String> values) {
            addCriterion("lab_quantity in", values, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityNotIn(List<String> values) {
            addCriterion("lab_quantity not in", values, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityBetween(String value1, String value2) {
            addCriterion("lab_quantity between", value1, value2, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabQuantityNotBetween(String value1, String value2) {
            addCriterion("lab_quantity not between", value1, value2, "labQuantity");
            return (Criteria) this;
        }

        public Criteria andLabRemarkIsNull() {
            addCriterion("lab_remark is null");
            return (Criteria) this;
        }

        public Criteria andLabRemarkIsNotNull() {
            addCriterion("lab_remark is not null");
            return (Criteria) this;
        }

        public Criteria andLabRemarkEqualTo(String value) {
            addCriterion("lab_remark =", value, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkNotEqualTo(String value) {
            addCriterion("lab_remark <>", value, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkGreaterThan(String value) {
            addCriterion("lab_remark >", value, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("lab_remark >=", value, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkLessThan(String value) {
            addCriterion("lab_remark <", value, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkLessThanOrEqualTo(String value) {
            addCriterion("lab_remark <=", value, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkLike(String value) {
            addCriterion("lab_remark like", value, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkNotLike(String value) {
            addCriterion("lab_remark not like", value, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkIn(List<String> values) {
            addCriterion("lab_remark in", values, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkNotIn(List<String> values) {
            addCriterion("lab_remark not in", values, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkBetween(String value1, String value2) {
            addCriterion("lab_remark between", value1, value2, "labRemark");
            return (Criteria) this;
        }

        public Criteria andLabRemarkNotBetween(String value1, String value2) {
            addCriterion("lab_remark not between", value1, value2, "labRemark");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinIsNull() {
            addCriterion("keyboard_basin is null");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinIsNotNull() {
            addCriterion("keyboard_basin is not null");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinEqualTo(String value) {
            addCriterion("keyboard_basin =", value, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinNotEqualTo(String value) {
            addCriterion("keyboard_basin <>", value, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinGreaterThan(String value) {
            addCriterion("keyboard_basin >", value, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinGreaterThanOrEqualTo(String value) {
            addCriterion("keyboard_basin >=", value, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinLessThan(String value) {
            addCriterion("keyboard_basin <", value, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinLessThanOrEqualTo(String value) {
            addCriterion("keyboard_basin <=", value, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinLike(String value) {
            addCriterion("keyboard_basin like", value, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinNotLike(String value) {
            addCriterion("keyboard_basin not like", value, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinIn(List<String> values) {
            addCriterion("keyboard_basin in", values, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinNotIn(List<String> values) {
            addCriterion("keyboard_basin not in", values, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinBetween(String value1, String value2) {
            addCriterion("keyboard_basin between", value1, value2, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKeyboardBasinNotBetween(String value1, String value2) {
            addCriterion("keyboard_basin not between", value1, value2, "keyboardBasin");
            return (Criteria) this;
        }

        public Criteria andKbQuantityIsNull() {
            addCriterion("kb_quantity is null");
            return (Criteria) this;
        }

        public Criteria andKbQuantityIsNotNull() {
            addCriterion("kb_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andKbQuantityEqualTo(String value) {
            addCriterion("kb_quantity =", value, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityNotEqualTo(String value) {
            addCriterion("kb_quantity <>", value, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityGreaterThan(String value) {
            addCriterion("kb_quantity >", value, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("kb_quantity >=", value, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityLessThan(String value) {
            addCriterion("kb_quantity <", value, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityLessThanOrEqualTo(String value) {
            addCriterion("kb_quantity <=", value, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityLike(String value) {
            addCriterion("kb_quantity like", value, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityNotLike(String value) {
            addCriterion("kb_quantity not like", value, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityIn(List<String> values) {
            addCriterion("kb_quantity in", values, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityNotIn(List<String> values) {
            addCriterion("kb_quantity not in", values, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityBetween(String value1, String value2) {
            addCriterion("kb_quantity between", value1, value2, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbQuantityNotBetween(String value1, String value2) {
            addCriterion("kb_quantity not between", value1, value2, "kbQuantity");
            return (Criteria) this;
        }

        public Criteria andKbRemarkIsNull() {
            addCriterion("kb_remark is null");
            return (Criteria) this;
        }

        public Criteria andKbRemarkIsNotNull() {
            addCriterion("kb_remark is not null");
            return (Criteria) this;
        }

        public Criteria andKbRemarkEqualTo(String value) {
            addCriterion("kb_remark =", value, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkNotEqualTo(String value) {
            addCriterion("kb_remark <>", value, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkGreaterThan(String value) {
            addCriterion("kb_remark >", value, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("kb_remark >=", value, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkLessThan(String value) {
            addCriterion("kb_remark <", value, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkLessThanOrEqualTo(String value) {
            addCriterion("kb_remark <=", value, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkLike(String value) {
            addCriterion("kb_remark like", value, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkNotLike(String value) {
            addCriterion("kb_remark not like", value, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkIn(List<String> values) {
            addCriterion("kb_remark in", values, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkNotIn(List<String> values) {
            addCriterion("kb_remark not in", values, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkBetween(String value1, String value2) {
            addCriterion("kb_remark between", value1, value2, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andKbRemarkNotBetween(String value1, String value2) {
            addCriterion("kb_remark not between", value1, value2, "kbRemark");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelIsNull() {
            addCriterion("close_pump_barrel is null");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelIsNotNull() {
            addCriterion("close_pump_barrel is not null");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelEqualTo(String value) {
            addCriterion("close_pump_barrel =", value, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelNotEqualTo(String value) {
            addCriterion("close_pump_barrel <>", value, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelGreaterThan(String value) {
            addCriterion("close_pump_barrel >", value, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelGreaterThanOrEqualTo(String value) {
            addCriterion("close_pump_barrel >=", value, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelLessThan(String value) {
            addCriterion("close_pump_barrel <", value, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelLessThanOrEqualTo(String value) {
            addCriterion("close_pump_barrel <=", value, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelLike(String value) {
            addCriterion("close_pump_barrel like", value, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelNotLike(String value) {
            addCriterion("close_pump_barrel not like", value, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelIn(List<String> values) {
            addCriterion("close_pump_barrel in", values, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelNotIn(List<String> values) {
            addCriterion("close_pump_barrel not in", values, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelBetween(String value1, String value2) {
            addCriterion("close_pump_barrel between", value1, value2, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andClosePumpBarrelNotBetween(String value1, String value2) {
            addCriterion("close_pump_barrel not between", value1, value2, "closePumpBarrel");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityIsNull() {
            addCriterion("cpb_quantity is null");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityIsNotNull() {
            addCriterion("cpb_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityEqualTo(String value) {
            addCriterion("cpb_quantity =", value, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityNotEqualTo(String value) {
            addCriterion("cpb_quantity <>", value, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityGreaterThan(String value) {
            addCriterion("cpb_quantity >", value, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("cpb_quantity >=", value, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityLessThan(String value) {
            addCriterion("cpb_quantity <", value, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityLessThanOrEqualTo(String value) {
            addCriterion("cpb_quantity <=", value, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityLike(String value) {
            addCriterion("cpb_quantity like", value, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityNotLike(String value) {
            addCriterion("cpb_quantity not like", value, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityIn(List<String> values) {
            addCriterion("cpb_quantity in", values, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityNotIn(List<String> values) {
            addCriterion("cpb_quantity not in", values, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityBetween(String value1, String value2) {
            addCriterion("cpb_quantity between", value1, value2, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbQuantityNotBetween(String value1, String value2) {
            addCriterion("cpb_quantity not between", value1, value2, "cpbQuantity");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkIsNull() {
            addCriterion("cpb_remark is null");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkIsNotNull() {
            addCriterion("cpb_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkEqualTo(String value) {
            addCriterion("cpb_remark =", value, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkNotEqualTo(String value) {
            addCriterion("cpb_remark <>", value, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkGreaterThan(String value) {
            addCriterion("cpb_remark >", value, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("cpb_remark >=", value, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkLessThan(String value) {
            addCriterion("cpb_remark <", value, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkLessThanOrEqualTo(String value) {
            addCriterion("cpb_remark <=", value, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkLike(String value) {
            addCriterion("cpb_remark like", value, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkNotLike(String value) {
            addCriterion("cpb_remark not like", value, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkIn(List<String> values) {
            addCriterion("cpb_remark in", values, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkNotIn(List<String> values) {
            addCriterion("cpb_remark not in", values, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkBetween(String value1, String value2) {
            addCriterion("cpb_remark between", value1, value2, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andCpbRemarkNotBetween(String value1, String value2) {
            addCriterion("cpb_remark not between", value1, value2, "cpbRemark");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelIsNull() {
            addCriterion("open_pump_barrel is null");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelIsNotNull() {
            addCriterion("open_pump_barrel is not null");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelEqualTo(String value) {
            addCriterion("open_pump_barrel =", value, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelNotEqualTo(String value) {
            addCriterion("open_pump_barrel <>", value, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelGreaterThan(String value) {
            addCriterion("open_pump_barrel >", value, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelGreaterThanOrEqualTo(String value) {
            addCriterion("open_pump_barrel >=", value, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelLessThan(String value) {
            addCriterion("open_pump_barrel <", value, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelLessThanOrEqualTo(String value) {
            addCriterion("open_pump_barrel <=", value, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelLike(String value) {
            addCriterion("open_pump_barrel like", value, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelNotLike(String value) {
            addCriterion("open_pump_barrel not like", value, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelIn(List<String> values) {
            addCriterion("open_pump_barrel in", values, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelNotIn(List<String> values) {
            addCriterion("open_pump_barrel not in", values, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelBetween(String value1, String value2) {
            addCriterion("open_pump_barrel between", value1, value2, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpenPumpBarrelNotBetween(String value1, String value2) {
            addCriterion("open_pump_barrel not between", value1, value2, "openPumpBarrel");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityIsNull() {
            addCriterion("opb_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityIsNotNull() {
            addCriterion("opb_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityEqualTo(String value) {
            addCriterion("opb_quantity =", value, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityNotEqualTo(String value) {
            addCriterion("opb_quantity <>", value, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityGreaterThan(String value) {
            addCriterion("opb_quantity >", value, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("opb_quantity >=", value, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityLessThan(String value) {
            addCriterion("opb_quantity <", value, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityLessThanOrEqualTo(String value) {
            addCriterion("opb_quantity <=", value, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityLike(String value) {
            addCriterion("opb_quantity like", value, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityNotLike(String value) {
            addCriterion("opb_quantity not like", value, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityIn(List<String> values) {
            addCriterion("opb_quantity in", values, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityNotIn(List<String> values) {
            addCriterion("opb_quantity not in", values, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityBetween(String value1, String value2) {
            addCriterion("opb_quantity between", value1, value2, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbQuantityNotBetween(String value1, String value2) {
            addCriterion("opb_quantity not between", value1, value2, "opbQuantity");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkIsNull() {
            addCriterion("opb_remark is null");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkIsNotNull() {
            addCriterion("opb_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkEqualTo(String value) {
            addCriterion("opb_remark =", value, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkNotEqualTo(String value) {
            addCriterion("opb_remark <>", value, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkGreaterThan(String value) {
            addCriterion("opb_remark >", value, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("opb_remark >=", value, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkLessThan(String value) {
            addCriterion("opb_remark <", value, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkLessThanOrEqualTo(String value) {
            addCriterion("opb_remark <=", value, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkLike(String value) {
            addCriterion("opb_remark like", value, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkNotLike(String value) {
            addCriterion("opb_remark not like", value, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkIn(List<String> values) {
            addCriterion("opb_remark in", values, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkNotIn(List<String> values) {
            addCriterion("opb_remark not in", values, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkBetween(String value1, String value2) {
            addCriterion("opb_remark between", value1, value2, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andOpbRemarkNotBetween(String value1, String value2) {
            addCriterion("opb_remark not between", value1, value2, "opbRemark");
            return (Criteria) this;
        }

        public Criteria andTlQuantityIsNull() {
            addCriterion("tl_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTlQuantityIsNotNull() {
            addCriterion("tl_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTlQuantityEqualTo(String value) {
            addCriterion("tl_quantity =", value, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityNotEqualTo(String value) {
            addCriterion("tl_quantity <>", value, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityGreaterThan(String value) {
            addCriterion("tl_quantity >", value, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("tl_quantity >=", value, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityLessThan(String value) {
            addCriterion("tl_quantity <", value, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityLessThanOrEqualTo(String value) {
            addCriterion("tl_quantity <=", value, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityLike(String value) {
            addCriterion("tl_quantity like", value, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityNotLike(String value) {
            addCriterion("tl_quantity not like", value, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityIn(List<String> values) {
            addCriterion("tl_quantity in", values, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityNotIn(List<String> values) {
            addCriterion("tl_quantity not in", values, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityBetween(String value1, String value2) {
            addCriterion("tl_quantity between", value1, value2, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlQuantityNotBetween(String value1, String value2) {
            addCriterion("tl_quantity not between", value1, value2, "tlQuantity");
            return (Criteria) this;
        }

        public Criteria andTlRemarkIsNull() {
            addCriterion("tl_remark is null");
            return (Criteria) this;
        }

        public Criteria andTlRemarkIsNotNull() {
            addCriterion("tl_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTlRemarkEqualTo(String value) {
            addCriterion("tl_remark =", value, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkNotEqualTo(String value) {
            addCriterion("tl_remark <>", value, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkGreaterThan(String value) {
            addCriterion("tl_remark >", value, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("tl_remark >=", value, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkLessThan(String value) {
            addCriterion("tl_remark <", value, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkLessThanOrEqualTo(String value) {
            addCriterion("tl_remark <=", value, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkLike(String value) {
            addCriterion("tl_remark like", value, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkNotLike(String value) {
            addCriterion("tl_remark not like", value, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkIn(List<String> values) {
            addCriterion("tl_remark in", values, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkNotIn(List<String> values) {
            addCriterion("tl_remark not in", values, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkBetween(String value1, String value2) {
            addCriterion("tl_remark between", value1, value2, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTlRemarkNotBetween(String value1, String value2) {
            addCriterion("tl_remark not between", value1, value2, "tlRemark");
            return (Criteria) this;
        }

        public Criteria andTrQuantityIsNull() {
            addCriterion("tr_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTrQuantityIsNotNull() {
            addCriterion("tr_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTrQuantityEqualTo(String value) {
            addCriterion("tr_quantity =", value, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityNotEqualTo(String value) {
            addCriterion("tr_quantity <>", value, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityGreaterThan(String value) {
            addCriterion("tr_quantity >", value, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("tr_quantity >=", value, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityLessThan(String value) {
            addCriterion("tr_quantity <", value, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityLessThanOrEqualTo(String value) {
            addCriterion("tr_quantity <=", value, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityLike(String value) {
            addCriterion("tr_quantity like", value, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityNotLike(String value) {
            addCriterion("tr_quantity not like", value, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityIn(List<String> values) {
            addCriterion("tr_quantity in", values, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityNotIn(List<String> values) {
            addCriterion("tr_quantity not in", values, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityBetween(String value1, String value2) {
            addCriterion("tr_quantity between", value1, value2, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrQuantityNotBetween(String value1, String value2) {
            addCriterion("tr_quantity not between", value1, value2, "trQuantity");
            return (Criteria) this;
        }

        public Criteria andTrRemarkIsNull() {
            addCriterion("tr_remark is null");
            return (Criteria) this;
        }

        public Criteria andTrRemarkIsNotNull() {
            addCriterion("tr_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTrRemarkEqualTo(String value) {
            addCriterion("tr_remark =", value, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkNotEqualTo(String value) {
            addCriterion("tr_remark <>", value, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkGreaterThan(String value) {
            addCriterion("tr_remark >", value, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("tr_remark >=", value, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkLessThan(String value) {
            addCriterion("tr_remark <", value, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkLessThanOrEqualTo(String value) {
            addCriterion("tr_remark <=", value, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkLike(String value) {
            addCriterion("tr_remark like", value, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkNotLike(String value) {
            addCriterion("tr_remark not like", value, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkIn(List<String> values) {
            addCriterion("tr_remark in", values, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkNotIn(List<String> values) {
            addCriterion("tr_remark not in", values, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkBetween(String value1, String value2) {
            addCriterion("tr_remark between", value1, value2, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTrRemarkNotBetween(String value1, String value2) {
            addCriterion("tr_remark not between", value1, value2, "trRemark");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityIsNull() {
            addCriterion("tlp_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityIsNotNull() {
            addCriterion("tlp_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityEqualTo(String value) {
            addCriterion("tlp_quantity =", value, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityNotEqualTo(String value) {
            addCriterion("tlp_quantity <>", value, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityGreaterThan(String value) {
            addCriterion("tlp_quantity >", value, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("tlp_quantity >=", value, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityLessThan(String value) {
            addCriterion("tlp_quantity <", value, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityLessThanOrEqualTo(String value) {
            addCriterion("tlp_quantity <=", value, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityLike(String value) {
            addCriterion("tlp_quantity like", value, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityNotLike(String value) {
            addCriterion("tlp_quantity not like", value, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityIn(List<String> values) {
            addCriterion("tlp_quantity in", values, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityNotIn(List<String> values) {
            addCriterion("tlp_quantity not in", values, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityBetween(String value1, String value2) {
            addCriterion("tlp_quantity between", value1, value2, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpQuantityNotBetween(String value1, String value2) {
            addCriterion("tlp_quantity not between", value1, value2, "tlpQuantity");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkIsNull() {
            addCriterion("tlp_remark is null");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkIsNotNull() {
            addCriterion("tlp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkEqualTo(String value) {
            addCriterion("tlp_remark =", value, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkNotEqualTo(String value) {
            addCriterion("tlp_remark <>", value, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkGreaterThan(String value) {
            addCriterion("tlp_remark >", value, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("tlp_remark >=", value, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkLessThan(String value) {
            addCriterion("tlp_remark <", value, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkLessThanOrEqualTo(String value) {
            addCriterion("tlp_remark <=", value, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkLike(String value) {
            addCriterion("tlp_remark like", value, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkNotLike(String value) {
            addCriterion("tlp_remark not like", value, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkIn(List<String> values) {
            addCriterion("tlp_remark in", values, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkNotIn(List<String> values) {
            addCriterion("tlp_remark not in", values, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkBetween(String value1, String value2) {
            addCriterion("tlp_remark between", value1, value2, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andTlpRemarkNotBetween(String value1, String value2) {
            addCriterion("tlp_remark not between", value1, value2, "tlpRemark");
            return (Criteria) this;
        }

        public Criteria andWspQuantityIsNull() {
            addCriterion("wsp_quantity is null");
            return (Criteria) this;
        }

        public Criteria andWspQuantityIsNotNull() {
            addCriterion("wsp_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andWspQuantityEqualTo(String value) {
            addCriterion("wsp_quantity =", value, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityNotEqualTo(String value) {
            addCriterion("wsp_quantity <>", value, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityGreaterThan(String value) {
            addCriterion("wsp_quantity >", value, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("wsp_quantity >=", value, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityLessThan(String value) {
            addCriterion("wsp_quantity <", value, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityLessThanOrEqualTo(String value) {
            addCriterion("wsp_quantity <=", value, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityLike(String value) {
            addCriterion("wsp_quantity like", value, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityNotLike(String value) {
            addCriterion("wsp_quantity not like", value, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityIn(List<String> values) {
            addCriterion("wsp_quantity in", values, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityNotIn(List<String> values) {
            addCriterion("wsp_quantity not in", values, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityBetween(String value1, String value2) {
            addCriterion("wsp_quantity between", value1, value2, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspQuantityNotBetween(String value1, String value2) {
            addCriterion("wsp_quantity not between", value1, value2, "wspQuantity");
            return (Criteria) this;
        }

        public Criteria andWspRemarkIsNull() {
            addCriterion("wsp_remark is null");
            return (Criteria) this;
        }

        public Criteria andWspRemarkIsNotNull() {
            addCriterion("wsp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andWspRemarkEqualTo(String value) {
            addCriterion("wsp_remark =", value, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkNotEqualTo(String value) {
            addCriterion("wsp_remark <>", value, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkGreaterThan(String value) {
            addCriterion("wsp_remark >", value, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("wsp_remark >=", value, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkLessThan(String value) {
            addCriterion("wsp_remark <", value, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkLessThanOrEqualTo(String value) {
            addCriterion("wsp_remark <=", value, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkLike(String value) {
            addCriterion("wsp_remark like", value, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkNotLike(String value) {
            addCriterion("wsp_remark not like", value, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkIn(List<String> values) {
            addCriterion("wsp_remark in", values, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkNotIn(List<String> values) {
            addCriterion("wsp_remark not in", values, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkBetween(String value1, String value2) {
            addCriterion("wsp_remark between", value1, value2, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andWspRemarkNotBetween(String value1, String value2) {
            addCriterion("wsp_remark not between", value1, value2, "wspRemark");
            return (Criteria) this;
        }

        public Criteria andPowerBrandIsNull() {
            addCriterion("power_brand is null");
            return (Criteria) this;
        }

        public Criteria andPowerBrandIsNotNull() {
            addCriterion("power_brand is not null");
            return (Criteria) this;
        }

        public Criteria andPowerBrandEqualTo(String value) {
            addCriterion("power_brand =", value, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandNotEqualTo(String value) {
            addCriterion("power_brand <>", value, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandGreaterThan(String value) {
            addCriterion("power_brand >", value, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandGreaterThanOrEqualTo(String value) {
            addCriterion("power_brand >=", value, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandLessThan(String value) {
            addCriterion("power_brand <", value, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandLessThanOrEqualTo(String value) {
            addCriterion("power_brand <=", value, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandLike(String value) {
            addCriterion("power_brand like", value, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandNotLike(String value) {
            addCriterion("power_brand not like", value, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandIn(List<String> values) {
            addCriterion("power_brand in", values, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandNotIn(List<String> values) {
            addCriterion("power_brand not in", values, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandBetween(String value1, String value2) {
            addCriterion("power_brand between", value1, value2, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerBrandNotBetween(String value1, String value2) {
            addCriterion("power_brand not between", value1, value2, "powerBrand");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsIsNull() {
            addCriterion("power_digits is null");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsIsNotNull() {
            addCriterion("power_digits is not null");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsEqualTo(String value) {
            addCriterion("power_digits =", value, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsNotEqualTo(String value) {
            addCriterion("power_digits <>", value, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsGreaterThan(String value) {
            addCriterion("power_digits >", value, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsGreaterThanOrEqualTo(String value) {
            addCriterion("power_digits >=", value, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsLessThan(String value) {
            addCriterion("power_digits <", value, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsLessThanOrEqualTo(String value) {
            addCriterion("power_digits <=", value, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsLike(String value) {
            addCriterion("power_digits like", value, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsNotLike(String value) {
            addCriterion("power_digits not like", value, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsIn(List<String> values) {
            addCriterion("power_digits in", values, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsNotIn(List<String> values) {
            addCriterion("power_digits not in", values, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsBetween(String value1, String value2) {
            addCriterion("power_digits between", value1, value2, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerDigitsNotBetween(String value1, String value2) {
            addCriterion("power_digits not between", value1, value2, "powerDigits");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorIsNull() {
            addCriterion("power_shell_color is null");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorIsNotNull() {
            addCriterion("power_shell_color is not null");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorEqualTo(String value) {
            addCriterion("power_shell_color =", value, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorNotEqualTo(String value) {
            addCriterion("power_shell_color <>", value, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorGreaterThan(String value) {
            addCriterion("power_shell_color >", value, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorGreaterThanOrEqualTo(String value) {
            addCriterion("power_shell_color >=", value, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorLessThan(String value) {
            addCriterion("power_shell_color <", value, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorLessThanOrEqualTo(String value) {
            addCriterion("power_shell_color <=", value, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorLike(String value) {
            addCriterion("power_shell_color like", value, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorNotLike(String value) {
            addCriterion("power_shell_color not like", value, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorIn(List<String> values) {
            addCriterion("power_shell_color in", values, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorNotIn(List<String> values) {
            addCriterion("power_shell_color not in", values, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorBetween(String value1, String value2) {
            addCriterion("power_shell_color between", value1, value2, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerShellColorNotBetween(String value1, String value2) {
            addCriterion("power_shell_color not between", value1, value2, "powerShellColor");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayIsNull() {
            addCriterion("power_socket_way is null");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayIsNotNull() {
            addCriterion("power_socket_way is not null");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayEqualTo(String value) {
            addCriterion("power_socket_way =", value, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayNotEqualTo(String value) {
            addCriterion("power_socket_way <>", value, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayGreaterThan(String value) {
            addCriterion("power_socket_way >", value, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayGreaterThanOrEqualTo(String value) {
            addCriterion("power_socket_way >=", value, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayLessThan(String value) {
            addCriterion("power_socket_way <", value, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayLessThanOrEqualTo(String value) {
            addCriterion("power_socket_way <=", value, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayLike(String value) {
            addCriterion("power_socket_way like", value, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayNotLike(String value) {
            addCriterion("power_socket_way not like", value, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayIn(List<String> values) {
            addCriterion("power_socket_way in", values, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayNotIn(List<String> values) {
            addCriterion("power_socket_way not in", values, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayBetween(String value1, String value2) {
            addCriterion("power_socket_way between", value1, value2, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerSocketWayNotBetween(String value1, String value2) {
            addCriterion("power_socket_way not between", value1, value2, "powerSocketWay");
            return (Criteria) this;
        }

        public Criteria andPowerCordIsNull() {
            addCriterion("power_cord is null");
            return (Criteria) this;
        }

        public Criteria andPowerCordIsNotNull() {
            addCriterion("power_cord is not null");
            return (Criteria) this;
        }

        public Criteria andPowerCordEqualTo(String value) {
            addCriterion("power_cord =", value, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordNotEqualTo(String value) {
            addCriterion("power_cord <>", value, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordGreaterThan(String value) {
            addCriterion("power_cord >", value, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordGreaterThanOrEqualTo(String value) {
            addCriterion("power_cord >=", value, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordLessThan(String value) {
            addCriterion("power_cord <", value, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordLessThanOrEqualTo(String value) {
            addCriterion("power_cord <=", value, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordLike(String value) {
            addCriterion("power_cord like", value, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordNotLike(String value) {
            addCriterion("power_cord not like", value, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordIn(List<String> values) {
            addCriterion("power_cord in", values, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordNotIn(List<String> values) {
            addCriterion("power_cord not in", values, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordBetween(String value1, String value2) {
            addCriterion("power_cord between", value1, value2, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerCordNotBetween(String value1, String value2) {
            addCriterion("power_cord not between", value1, value2, "powerCord");
            return (Criteria) this;
        }

        public Criteria andPowerWiringIsNull() {
            addCriterion("power_wiring is null");
            return (Criteria) this;
        }

        public Criteria andPowerWiringIsNotNull() {
            addCriterion("power_wiring is not null");
            return (Criteria) this;
        }

        public Criteria andPowerWiringEqualTo(String value) {
            addCriterion("power_wiring =", value, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringNotEqualTo(String value) {
            addCriterion("power_wiring <>", value, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringGreaterThan(String value) {
            addCriterion("power_wiring >", value, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringGreaterThanOrEqualTo(String value) {
            addCriterion("power_wiring >=", value, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLessThan(String value) {
            addCriterion("power_wiring <", value, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLessThanOrEqualTo(String value) {
            addCriterion("power_wiring <=", value, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLike(String value) {
            addCriterion("power_wiring like", value, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringNotLike(String value) {
            addCriterion("power_wiring not like", value, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringIn(List<String> values) {
            addCriterion("power_wiring in", values, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringNotIn(List<String> values) {
            addCriterion("power_wiring not in", values, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringBetween(String value1, String value2) {
            addCriterion("power_wiring between", value1, value2, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringNotBetween(String value1, String value2) {
            addCriterion("power_wiring not between", value1, value2, "powerWiring");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthIsNull() {
            addCriterion("power_wiring_length is null");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthIsNotNull() {
            addCriterion("power_wiring_length is not null");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthEqualTo(String value) {
            addCriterion("power_wiring_length =", value, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthNotEqualTo(String value) {
            addCriterion("power_wiring_length <>", value, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthGreaterThan(String value) {
            addCriterion("power_wiring_length >", value, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthGreaterThanOrEqualTo(String value) {
            addCriterion("power_wiring_length >=", value, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthLessThan(String value) {
            addCriterion("power_wiring_length <", value, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthLessThanOrEqualTo(String value) {
            addCriterion("power_wiring_length <=", value, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthLike(String value) {
            addCriterion("power_wiring_length like", value, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthNotLike(String value) {
            addCriterion("power_wiring_length not like", value, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthIn(List<String> values) {
            addCriterion("power_wiring_length in", values, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthNotIn(List<String> values) {
            addCriterion("power_wiring_length not in", values, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthBetween(String value1, String value2) {
            addCriterion("power_wiring_length between", value1, value2, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerWiringLengthNotBetween(String value1, String value2) {
            addCriterion("power_wiring_length not between", value1, value2, "powerWiringLength");
            return (Criteria) this;
        }

        public Criteria andPowerPlugIsNull() {
            addCriterion("power_plug is null");
            return (Criteria) this;
        }

        public Criteria andPowerPlugIsNotNull() {
            addCriterion("power_plug is not null");
            return (Criteria) this;
        }

        public Criteria andPowerPlugEqualTo(String value) {
            addCriterion("power_plug =", value, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugNotEqualTo(String value) {
            addCriterion("power_plug <>", value, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugGreaterThan(String value) {
            addCriterion("power_plug >", value, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugGreaterThanOrEqualTo(String value) {
            addCriterion("power_plug >=", value, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugLessThan(String value) {
            addCriterion("power_plug <", value, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugLessThanOrEqualTo(String value) {
            addCriterion("power_plug <=", value, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugLike(String value) {
            addCriterion("power_plug like", value, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugNotLike(String value) {
            addCriterion("power_plug not like", value, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugIn(List<String> values) {
            addCriterion("power_plug in", values, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugNotIn(List<String> values) {
            addCriterion("power_plug not in", values, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugBetween(String value1, String value2) {
            addCriterion("power_plug between", value1, value2, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPowerPlugNotBetween(String value1, String value2) {
            addCriterion("power_plug not between", value1, value2, "powerPlug");
            return (Criteria) this;
        }

        public Criteria andPQuantityIsNull() {
            addCriterion("p_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPQuantityIsNotNull() {
            addCriterion("p_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPQuantityEqualTo(String value) {
            addCriterion("p_quantity =", value, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityNotEqualTo(String value) {
            addCriterion("p_quantity <>", value, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityGreaterThan(String value) {
            addCriterion("p_quantity >", value, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("p_quantity >=", value, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityLessThan(String value) {
            addCriterion("p_quantity <", value, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityLessThanOrEqualTo(String value) {
            addCriterion("p_quantity <=", value, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityLike(String value) {
            addCriterion("p_quantity like", value, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityNotLike(String value) {
            addCriterion("p_quantity not like", value, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityIn(List<String> values) {
            addCriterion("p_quantity in", values, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityNotIn(List<String> values) {
            addCriterion("p_quantity not in", values, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityBetween(String value1, String value2) {
            addCriterion("p_quantity between", value1, value2, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andPQuantityNotBetween(String value1, String value2) {
            addCriterion("p_quantity not between", value1, value2, "pQuantity");
            return (Criteria) this;
        }

        public Criteria andOtherPowerIsNull() {
            addCriterion("other_power is null");
            return (Criteria) this;
        }

        public Criteria andOtherPowerIsNotNull() {
            addCriterion("other_power is not null");
            return (Criteria) this;
        }

        public Criteria andOtherPowerEqualTo(String value) {
            addCriterion("other_power =", value, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerNotEqualTo(String value) {
            addCriterion("other_power <>", value, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerGreaterThan(String value) {
            addCriterion("other_power >", value, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerGreaterThanOrEqualTo(String value) {
            addCriterion("other_power >=", value, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerLessThan(String value) {
            addCriterion("other_power <", value, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerLessThanOrEqualTo(String value) {
            addCriterion("other_power <=", value, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerLike(String value) {
            addCriterion("other_power like", value, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerNotLike(String value) {
            addCriterion("other_power not like", value, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerIn(List<String> values) {
            addCriterion("other_power in", values, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerNotIn(List<String> values) {
            addCriterion("other_power not in", values, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerBetween(String value1, String value2) {
            addCriterion("other_power between", value1, value2, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOtherPowerNotBetween(String value1, String value2) {
            addCriterion("other_power not between", value1, value2, "otherPower");
            return (Criteria) this;
        }

        public Criteria andOpQuantityIsNull() {
            addCriterion("op_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOpQuantityIsNotNull() {
            addCriterion("op_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOpQuantityEqualTo(String value) {
            addCriterion("op_quantity =", value, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityNotEqualTo(String value) {
            addCriterion("op_quantity <>", value, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityGreaterThan(String value) {
            addCriterion("op_quantity >", value, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("op_quantity >=", value, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityLessThan(String value) {
            addCriterion("op_quantity <", value, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityLessThanOrEqualTo(String value) {
            addCriterion("op_quantity <=", value, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityLike(String value) {
            addCriterion("op_quantity like", value, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityNotLike(String value) {
            addCriterion("op_quantity not like", value, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityIn(List<String> values) {
            addCriterion("op_quantity in", values, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityNotIn(List<String> values) {
            addCriterion("op_quantity not in", values, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityBetween(String value1, String value2) {
            addCriterion("op_quantity between", value1, value2, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpQuantityNotBetween(String value1, String value2) {
            addCriterion("op_quantity not between", value1, value2, "opQuantity");
            return (Criteria) this;
        }

        public Criteria andOpRemarkIsNull() {
            addCriterion("op_remark is null");
            return (Criteria) this;
        }

        public Criteria andOpRemarkIsNotNull() {
            addCriterion("op_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOpRemarkEqualTo(String value) {
            addCriterion("op_remark =", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkNotEqualTo(String value) {
            addCriterion("op_remark <>", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkGreaterThan(String value) {
            addCriterion("op_remark >", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("op_remark >=", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkLessThan(String value) {
            addCriterion("op_remark <", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkLessThanOrEqualTo(String value) {
            addCriterion("op_remark <=", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkLike(String value) {
            addCriterion("op_remark like", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkNotLike(String value) {
            addCriterion("op_remark not like", value, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkIn(List<String> values) {
            addCriterion("op_remark in", values, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkNotIn(List<String> values) {
            addCriterion("op_remark not in", values, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkBetween(String value1, String value2) {
            addCriterion("op_remark between", value1, value2, "opRemark");
            return (Criteria) this;
        }

        public Criteria andOpRemarkNotBetween(String value1, String value2) {
            addCriterion("op_remark not between", value1, value2, "opRemark");
            return (Criteria) this;
        }

        public Criteria andPowerDragIsNull() {
            addCriterion("power_drag is null");
            return (Criteria) this;
        }

        public Criteria andPowerDragIsNotNull() {
            addCriterion("power_drag is not null");
            return (Criteria) this;
        }

        public Criteria andPowerDragEqualTo(String value) {
            addCriterion("power_drag =", value, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragNotEqualTo(String value) {
            addCriterion("power_drag <>", value, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragGreaterThan(String value) {
            addCriterion("power_drag >", value, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragGreaterThanOrEqualTo(String value) {
            addCriterion("power_drag >=", value, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragLessThan(String value) {
            addCriterion("power_drag <", value, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragLessThanOrEqualTo(String value) {
            addCriterion("power_drag <=", value, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragLike(String value) {
            addCriterion("power_drag like", value, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragNotLike(String value) {
            addCriterion("power_drag not like", value, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragIn(List<String> values) {
            addCriterion("power_drag in", values, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragNotIn(List<String> values) {
            addCriterion("power_drag not in", values, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragBetween(String value1, String value2) {
            addCriterion("power_drag between", value1, value2, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPowerDragNotBetween(String value1, String value2) {
            addCriterion("power_drag not between", value1, value2, "powerDrag");
            return (Criteria) this;
        }

        public Criteria andPdQuantityIsNull() {
            addCriterion("pd_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPdQuantityIsNotNull() {
            addCriterion("pd_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPdQuantityEqualTo(String value) {
            addCriterion("pd_quantity =", value, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityNotEqualTo(String value) {
            addCriterion("pd_quantity <>", value, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityGreaterThan(String value) {
            addCriterion("pd_quantity >", value, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("pd_quantity >=", value, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityLessThan(String value) {
            addCriterion("pd_quantity <", value, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityLessThanOrEqualTo(String value) {
            addCriterion("pd_quantity <=", value, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityLike(String value) {
            addCriterion("pd_quantity like", value, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityNotLike(String value) {
            addCriterion("pd_quantity not like", value, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityIn(List<String> values) {
            addCriterion("pd_quantity in", values, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityNotIn(List<String> values) {
            addCriterion("pd_quantity not in", values, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityBetween(String value1, String value2) {
            addCriterion("pd_quantity between", value1, value2, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdQuantityNotBetween(String value1, String value2) {
            addCriterion("pd_quantity not between", value1, value2, "pdQuantity");
            return (Criteria) this;
        }

        public Criteria andPdRemarkIsNull() {
            addCriterion("pd_remark is null");
            return (Criteria) this;
        }

        public Criteria andPdRemarkIsNotNull() {
            addCriterion("pd_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPdRemarkEqualTo(String value) {
            addCriterion("pd_remark =", value, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkNotEqualTo(String value) {
            addCriterion("pd_remark <>", value, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkGreaterThan(String value) {
            addCriterion("pd_remark >", value, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pd_remark >=", value, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkLessThan(String value) {
            addCriterion("pd_remark <", value, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkLessThanOrEqualTo(String value) {
            addCriterion("pd_remark <=", value, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkLike(String value) {
            addCriterion("pd_remark like", value, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkNotLike(String value) {
            addCriterion("pd_remark not like", value, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkIn(List<String> values) {
            addCriterion("pd_remark in", values, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkNotIn(List<String> values) {
            addCriterion("pd_remark not in", values, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkBetween(String value1, String value2) {
            addCriterion("pd_remark between", value1, value2, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPdRemarkNotBetween(String value1, String value2) {
            addCriterion("pd_remark not between", value1, value2, "pdRemark");
            return (Criteria) this;
        }

        public Criteria andPowerBoxIsNull() {
            addCriterion("power_box is null");
            return (Criteria) this;
        }

        public Criteria andPowerBoxIsNotNull() {
            addCriterion("power_box is not null");
            return (Criteria) this;
        }

        public Criteria andPowerBoxEqualTo(String value) {
            addCriterion("power_box =", value, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxNotEqualTo(String value) {
            addCriterion("power_box <>", value, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxGreaterThan(String value) {
            addCriterion("power_box >", value, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxGreaterThanOrEqualTo(String value) {
            addCriterion("power_box >=", value, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxLessThan(String value) {
            addCriterion("power_box <", value, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxLessThanOrEqualTo(String value) {
            addCriterion("power_box <=", value, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxLike(String value) {
            addCriterion("power_box like", value, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxNotLike(String value) {
            addCriterion("power_box not like", value, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxIn(List<String> values) {
            addCriterion("power_box in", values, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxNotIn(List<String> values) {
            addCriterion("power_box not in", values, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxBetween(String value1, String value2) {
            addCriterion("power_box between", value1, value2, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPowerBoxNotBetween(String value1, String value2) {
            addCriterion("power_box not between", value1, value2, "powerBox");
            return (Criteria) this;
        }

        public Criteria andPbQuantityIsNull() {
            addCriterion("pb_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPbQuantityIsNotNull() {
            addCriterion("pb_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPbQuantityEqualTo(String value) {
            addCriterion("pb_quantity =", value, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityNotEqualTo(String value) {
            addCriterion("pb_quantity <>", value, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityGreaterThan(String value) {
            addCriterion("pb_quantity >", value, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("pb_quantity >=", value, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityLessThan(String value) {
            addCriterion("pb_quantity <", value, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityLessThanOrEqualTo(String value) {
            addCriterion("pb_quantity <=", value, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityLike(String value) {
            addCriterion("pb_quantity like", value, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityNotLike(String value) {
            addCriterion("pb_quantity not like", value, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityIn(List<String> values) {
            addCriterion("pb_quantity in", values, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityNotIn(List<String> values) {
            addCriterion("pb_quantity not in", values, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityBetween(String value1, String value2) {
            addCriterion("pb_quantity between", value1, value2, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbQuantityNotBetween(String value1, String value2) {
            addCriterion("pb_quantity not between", value1, value2, "pbQuantity");
            return (Criteria) this;
        }

        public Criteria andPbRemarkIsNull() {
            addCriterion("pb_remark is null");
            return (Criteria) this;
        }

        public Criteria andPbRemarkIsNotNull() {
            addCriterion("pb_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPbRemarkEqualTo(String value) {
            addCriterion("pb_remark =", value, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkNotEqualTo(String value) {
            addCriterion("pb_remark <>", value, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkGreaterThan(String value) {
            addCriterion("pb_remark >", value, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pb_remark >=", value, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkLessThan(String value) {
            addCriterion("pb_remark <", value, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkLessThanOrEqualTo(String value) {
            addCriterion("pb_remark <=", value, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkLike(String value) {
            addCriterion("pb_remark like", value, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkNotLike(String value) {
            addCriterion("pb_remark not like", value, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkIn(List<String> values) {
            addCriterion("pb_remark in", values, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkNotIn(List<String> values) {
            addCriterion("pb_remark not in", values, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkBetween(String value1, String value2) {
            addCriterion("pb_remark between", value1, value2, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andPbRemarkNotBetween(String value1, String value2) {
            addCriterion("pb_remark not between", value1, value2, "pbRemark");
            return (Criteria) this;
        }

        public Criteria andFanBoxIsNull() {
            addCriterion("fan_box is null");
            return (Criteria) this;
        }

        public Criteria andFanBoxIsNotNull() {
            addCriterion("fan_box is not null");
            return (Criteria) this;
        }

        public Criteria andFanBoxEqualTo(String value) {
            addCriterion("fan_box =", value, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxNotEqualTo(String value) {
            addCriterion("fan_box <>", value, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxGreaterThan(String value) {
            addCriterion("fan_box >", value, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxGreaterThanOrEqualTo(String value) {
            addCriterion("fan_box >=", value, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxLessThan(String value) {
            addCriterion("fan_box <", value, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxLessThanOrEqualTo(String value) {
            addCriterion("fan_box <=", value, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxLike(String value) {
            addCriterion("fan_box like", value, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxNotLike(String value) {
            addCriterion("fan_box not like", value, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxIn(List<String> values) {
            addCriterion("fan_box in", values, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxNotIn(List<String> values) {
            addCriterion("fan_box not in", values, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxBetween(String value1, String value2) {
            addCriterion("fan_box between", value1, value2, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBoxNotBetween(String value1, String value2) {
            addCriterion("fan_box not between", value1, value2, "fanBox");
            return (Criteria) this;
        }

        public Criteria andFanBrandIsNull() {
            addCriterion("fan_brand is null");
            return (Criteria) this;
        }

        public Criteria andFanBrandIsNotNull() {
            addCriterion("fan_brand is not null");
            return (Criteria) this;
        }

        public Criteria andFanBrandEqualTo(String value) {
            addCriterion("fan_brand =", value, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandNotEqualTo(String value) {
            addCriterion("fan_brand <>", value, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandGreaterThan(String value) {
            addCriterion("fan_brand >", value, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandGreaterThanOrEqualTo(String value) {
            addCriterion("fan_brand >=", value, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandLessThan(String value) {
            addCriterion("fan_brand <", value, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandLessThanOrEqualTo(String value) {
            addCriterion("fan_brand <=", value, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandLike(String value) {
            addCriterion("fan_brand like", value, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandNotLike(String value) {
            addCriterion("fan_brand not like", value, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandIn(List<String> values) {
            addCriterion("fan_brand in", values, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandNotIn(List<String> values) {
            addCriterion("fan_brand not in", values, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandBetween(String value1, String value2) {
            addCriterion("fan_brand between", value1, value2, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanBrandNotBetween(String value1, String value2) {
            addCriterion("fan_brand not between", value1, value2, "fanBrand");
            return (Criteria) this;
        }

        public Criteria andFanPlugIsNull() {
            addCriterion("fan_plug is null");
            return (Criteria) this;
        }

        public Criteria andFanPlugIsNotNull() {
            addCriterion("fan_plug is not null");
            return (Criteria) this;
        }

        public Criteria andFanPlugEqualTo(String value) {
            addCriterion("fan_plug =", value, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugNotEqualTo(String value) {
            addCriterion("fan_plug <>", value, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugGreaterThan(String value) {
            addCriterion("fan_plug >", value, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugGreaterThanOrEqualTo(String value) {
            addCriterion("fan_plug >=", value, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugLessThan(String value) {
            addCriterion("fan_plug <", value, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugLessThanOrEqualTo(String value) {
            addCriterion("fan_plug <=", value, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugLike(String value) {
            addCriterion("fan_plug like", value, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugNotLike(String value) {
            addCriterion("fan_plug not like", value, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugIn(List<String> values) {
            addCriterion("fan_plug in", values, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugNotIn(List<String> values) {
            addCriterion("fan_plug not in", values, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugBetween(String value1, String value2) {
            addCriterion("fan_plug between", value1, value2, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFanPlugNotBetween(String value1, String value2) {
            addCriterion("fan_plug not between", value1, value2, "fanPlug");
            return (Criteria) this;
        }

        public Criteria andFQuantityIsNull() {
            addCriterion("f_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFQuantityIsNotNull() {
            addCriterion("f_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFQuantityEqualTo(String value) {
            addCriterion("f_quantity =", value, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityNotEqualTo(String value) {
            addCriterion("f_quantity <>", value, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityGreaterThan(String value) {
            addCriterion("f_quantity >", value, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("f_quantity >=", value, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityLessThan(String value) {
            addCriterion("f_quantity <", value, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityLessThanOrEqualTo(String value) {
            addCriterion("f_quantity <=", value, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityLike(String value) {
            addCriterion("f_quantity like", value, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityNotLike(String value) {
            addCriterion("f_quantity not like", value, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityIn(List<String> values) {
            addCriterion("f_quantity in", values, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityNotIn(List<String> values) {
            addCriterion("f_quantity not in", values, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityBetween(String value1, String value2) {
            addCriterion("f_quantity between", value1, value2, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFQuantityNotBetween(String value1, String value2) {
            addCriterion("f_quantity not between", value1, value2, "fQuantity");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNull() {
            addCriterion("f_remark is null");
            return (Criteria) this;
        }

        public Criteria andFRemarkIsNotNull() {
            addCriterion("f_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFRemarkEqualTo(String value) {
            addCriterion("f_remark =", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotEqualTo(String value) {
            addCriterion("f_remark <>", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThan(String value) {
            addCriterion("f_remark >", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("f_remark >=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThan(String value) {
            addCriterion("f_remark <", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLessThanOrEqualTo(String value) {
            addCriterion("f_remark <=", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkLike(String value) {
            addCriterion("f_remark like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotLike(String value) {
            addCriterion("f_remark not like", value, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkIn(List<String> values) {
            addCriterion("f_remark in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotIn(List<String> values) {
            addCriterion("f_remark not in", values, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkBetween(String value1, String value2) {
            addCriterion("f_remark between", value1, value2, "fRemark");
            return (Criteria) this;
        }

        public Criteria andFRemarkNotBetween(String value1, String value2) {
            addCriterion("f_remark not between", value1, value2, "fRemark");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdIsNull() {
            addCriterion("sal_work_card_subsidiary_id is null");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdIsNotNull() {
            addCriterion("sal_work_card_subsidiary_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdEqualTo(String value) {
            addCriterion("sal_work_card_subsidiary_id =", value, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdNotEqualTo(String value) {
            addCriterion("sal_work_card_subsidiary_id <>", value, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdGreaterThan(String value) {
            addCriterion("sal_work_card_subsidiary_id >", value, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("sal_work_card_subsidiary_id >=", value, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdLessThan(String value) {
            addCriterion("sal_work_card_subsidiary_id <", value, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdLessThanOrEqualTo(String value) {
            addCriterion("sal_work_card_subsidiary_id <=", value, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdLike(String value) {
            addCriterion("sal_work_card_subsidiary_id like", value, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdNotLike(String value) {
            addCriterion("sal_work_card_subsidiary_id not like", value, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdIn(List<String> values) {
            addCriterion("sal_work_card_subsidiary_id in", values, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdNotIn(List<String> values) {
            addCriterion("sal_work_card_subsidiary_id not in", values, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdBetween(String value1, String value2) {
            addCriterion("sal_work_card_subsidiary_id between", value1, value2, "salWorkCardSubsidiaryId");
            return (Criteria) this;
        }

        public Criteria andSalWorkCardSubsidiaryIdNotBetween(String value1, String value2) {
            addCriterion("sal_work_card_subsidiary_id not between", value1, value2, "salWorkCardSubsidiaryId");
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