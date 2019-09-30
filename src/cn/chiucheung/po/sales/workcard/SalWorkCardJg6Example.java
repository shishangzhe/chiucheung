package cn.chiucheung.po.sales.workcard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalWorkCardJg6Example implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalWorkCardJg6Example() {
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

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andDepthIsNull() {
            addCriterion("depth is null");
            return (Criteria) this;
        }

        public Criteria andDepthIsNotNull() {
            addCriterion("depth is not null");
            return (Criteria) this;
        }

        public Criteria andDepthEqualTo(String value) {
            addCriterion("depth =", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotEqualTo(String value) {
            addCriterion("depth <>", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthGreaterThan(String value) {
            addCriterion("depth >", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthGreaterThanOrEqualTo(String value) {
            addCriterion("depth >=", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLessThan(String value) {
            addCriterion("depth <", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLessThanOrEqualTo(String value) {
            addCriterion("depth <=", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLike(String value) {
            addCriterion("depth like", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotLike(String value) {
            addCriterion("depth not like", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthIn(List<String> values) {
            addCriterion("depth in", values, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotIn(List<String> values) {
            addCriterion("depth not in", values, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthBetween(String value1, String value2) {
            addCriterion("depth between", value1, value2, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotBetween(String value1, String value2) {
            addCriterion("depth not between", value1, value2, "depth");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(String value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(String value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(String value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(String value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(String value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(String value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLike(String value) {
            addCriterion("width like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotLike(String value) {
            addCriterion("width not like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<String> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<String> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(String value1, String value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(String value1, String value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
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

        public Criteria andFrontDoorColorIsNull() {
            addCriterion("front_door_color is null");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorIsNotNull() {
            addCriterion("front_door_color is not null");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorEqualTo(String value) {
            addCriterion("front_door_color =", value, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorNotEqualTo(String value) {
            addCriterion("front_door_color <>", value, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorGreaterThan(String value) {
            addCriterion("front_door_color >", value, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorGreaterThanOrEqualTo(String value) {
            addCriterion("front_door_color >=", value, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorLessThan(String value) {
            addCriterion("front_door_color <", value, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorLessThanOrEqualTo(String value) {
            addCriterion("front_door_color <=", value, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorLike(String value) {
            addCriterion("front_door_color like", value, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorNotLike(String value) {
            addCriterion("front_door_color not like", value, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorIn(List<String> values) {
            addCriterion("front_door_color in", values, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorNotIn(List<String> values) {
            addCriterion("front_door_color not in", values, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorBetween(String value1, String value2) {
            addCriterion("front_door_color between", value1, value2, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorColorNotBetween(String value1, String value2) {
            addCriterion("front_door_color not between", value1, value2, "frontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorIsNull() {
            addCriterion("other_front_door_color is null");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorIsNotNull() {
            addCriterion("other_front_door_color is not null");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorEqualTo(String value) {
            addCriterion("other_front_door_color =", value, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorNotEqualTo(String value) {
            addCriterion("other_front_door_color <>", value, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorGreaterThan(String value) {
            addCriterion("other_front_door_color >", value, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorGreaterThanOrEqualTo(String value) {
            addCriterion("other_front_door_color >=", value, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorLessThan(String value) {
            addCriterion("other_front_door_color <", value, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorLessThanOrEqualTo(String value) {
            addCriterion("other_front_door_color <=", value, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorLike(String value) {
            addCriterion("other_front_door_color like", value, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorNotLike(String value) {
            addCriterion("other_front_door_color not like", value, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorIn(List<String> values) {
            addCriterion("other_front_door_color in", values, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorNotIn(List<String> values) {
            addCriterion("other_front_door_color not in", values, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorBetween(String value1, String value2) {
            addCriterion("other_front_door_color between", value1, value2, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andOtherFrontDoorColorNotBetween(String value1, String value2) {
            addCriterion("other_front_door_color not between", value1, value2, "otherFrontDoorColor");
            return (Criteria) this;
        }

        public Criteria andMainSuiteIsNull() {
            addCriterion("main_suite is null");
            return (Criteria) this;
        }

        public Criteria andMainSuiteIsNotNull() {
            addCriterion("main_suite is not null");
            return (Criteria) this;
        }

        public Criteria andMainSuiteEqualTo(String value) {
            addCriterion("main_suite =", value, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteNotEqualTo(String value) {
            addCriterion("main_suite <>", value, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteGreaterThan(String value) {
            addCriterion("main_suite >", value, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteGreaterThanOrEqualTo(String value) {
            addCriterion("main_suite >=", value, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteLessThan(String value) {
            addCriterion("main_suite <", value, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteLessThanOrEqualTo(String value) {
            addCriterion("main_suite <=", value, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteLike(String value) {
            addCriterion("main_suite like", value, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteNotLike(String value) {
            addCriterion("main_suite not like", value, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteIn(List<String> values) {
            addCriterion("main_suite in", values, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteNotIn(List<String> values) {
            addCriterion("main_suite not in", values, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteBetween(String value1, String value2) {
            addCriterion("main_suite between", value1, value2, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteNotBetween(String value1, String value2) {
            addCriterion("main_suite not between", value1, value2, "mainSuite");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeIsNull() {
            addCriterion("main_suite_special_made is null");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeIsNotNull() {
            addCriterion("main_suite_special_made is not null");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeEqualTo(String value) {
            addCriterion("main_suite_special_made =", value, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeNotEqualTo(String value) {
            addCriterion("main_suite_special_made <>", value, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeGreaterThan(String value) {
            addCriterion("main_suite_special_made >", value, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeGreaterThanOrEqualTo(String value) {
            addCriterion("main_suite_special_made >=", value, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeLessThan(String value) {
            addCriterion("main_suite_special_made <", value, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeLessThanOrEqualTo(String value) {
            addCriterion("main_suite_special_made <=", value, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeLike(String value) {
            addCriterion("main_suite_special_made like", value, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeNotLike(String value) {
            addCriterion("main_suite_special_made not like", value, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeIn(List<String> values) {
            addCriterion("main_suite_special_made in", values, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeNotIn(List<String> values) {
            addCriterion("main_suite_special_made not in", values, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeBetween(String value1, String value2) {
            addCriterion("main_suite_special_made between", value1, value2, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMainSuiteSpecialMadeNotBetween(String value1, String value2) {
            addCriterion("main_suite_special_made not between", value1, value2, "mainSuiteSpecialMade");
            return (Criteria) this;
        }

        public Criteria andMsQuantityIsNull() {
            addCriterion("ms_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMsQuantityIsNotNull() {
            addCriterion("ms_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMsQuantityEqualTo(String value) {
            addCriterion("ms_quantity =", value, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityNotEqualTo(String value) {
            addCriterion("ms_quantity <>", value, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityGreaterThan(String value) {
            addCriterion("ms_quantity >", value, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("ms_quantity >=", value, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityLessThan(String value) {
            addCriterion("ms_quantity <", value, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityLessThanOrEqualTo(String value) {
            addCriterion("ms_quantity <=", value, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityLike(String value) {
            addCriterion("ms_quantity like", value, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityNotLike(String value) {
            addCriterion("ms_quantity not like", value, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityIn(List<String> values) {
            addCriterion("ms_quantity in", values, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityNotIn(List<String> values) {
            addCriterion("ms_quantity not in", values, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityBetween(String value1, String value2) {
            addCriterion("ms_quantity between", value1, value2, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andMsQuantityNotBetween(String value1, String value2) {
            addCriterion("ms_quantity not between", value1, value2, "msQuantity");
            return (Criteria) this;
        }

        public Criteria andWireSlotIsNull() {
            addCriterion("wire_slot is null");
            return (Criteria) this;
        }

        public Criteria andWireSlotIsNotNull() {
            addCriterion("wire_slot is not null");
            return (Criteria) this;
        }

        public Criteria andWireSlotEqualTo(String value) {
            addCriterion("wire_slot =", value, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotNotEqualTo(String value) {
            addCriterion("wire_slot <>", value, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotGreaterThan(String value) {
            addCriterion("wire_slot >", value, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotGreaterThanOrEqualTo(String value) {
            addCriterion("wire_slot >=", value, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotLessThan(String value) {
            addCriterion("wire_slot <", value, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotLessThanOrEqualTo(String value) {
            addCriterion("wire_slot <=", value, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotLike(String value) {
            addCriterion("wire_slot like", value, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotNotLike(String value) {
            addCriterion("wire_slot not like", value, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotIn(List<String> values) {
            addCriterion("wire_slot in", values, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotNotIn(List<String> values) {
            addCriterion("wire_slot not in", values, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotBetween(String value1, String value2) {
            addCriterion("wire_slot between", value1, value2, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWireSlotNotBetween(String value1, String value2) {
            addCriterion("wire_slot not between", value1, value2, "wireSlot");
            return (Criteria) this;
        }

        public Criteria andWsQuantityIsNull() {
            addCriterion("ws_quantity is null");
            return (Criteria) this;
        }

        public Criteria andWsQuantityIsNotNull() {
            addCriterion("ws_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andWsQuantityEqualTo(String value) {
            addCriterion("ws_quantity =", value, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityNotEqualTo(String value) {
            addCriterion("ws_quantity <>", value, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityGreaterThan(String value) {
            addCriterion("ws_quantity >", value, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("ws_quantity >=", value, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityLessThan(String value) {
            addCriterion("ws_quantity <", value, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityLessThanOrEqualTo(String value) {
            addCriterion("ws_quantity <=", value, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityLike(String value) {
            addCriterion("ws_quantity like", value, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityNotLike(String value) {
            addCriterion("ws_quantity not like", value, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityIn(List<String> values) {
            addCriterion("ws_quantity in", values, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityNotIn(List<String> values) {
            addCriterion("ws_quantity not in", values, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityBetween(String value1, String value2) {
            addCriterion("ws_quantity between", value1, value2, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsQuantityNotBetween(String value1, String value2) {
            addCriterion("ws_quantity not between", value1, value2, "wsQuantity");
            return (Criteria) this;
        }

        public Criteria andWsRemarkIsNull() {
            addCriterion("ws_remark is null");
            return (Criteria) this;
        }

        public Criteria andWsRemarkIsNotNull() {
            addCriterion("ws_remark is not null");
            return (Criteria) this;
        }

        public Criteria andWsRemarkEqualTo(String value) {
            addCriterion("ws_remark =", value, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkNotEqualTo(String value) {
            addCriterion("ws_remark <>", value, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkGreaterThan(String value) {
            addCriterion("ws_remark >", value, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ws_remark >=", value, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkLessThan(String value) {
            addCriterion("ws_remark <", value, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkLessThanOrEqualTo(String value) {
            addCriterion("ws_remark <=", value, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkLike(String value) {
            addCriterion("ws_remark like", value, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkNotLike(String value) {
            addCriterion("ws_remark not like", value, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkIn(List<String> values) {
            addCriterion("ws_remark in", values, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkNotIn(List<String> values) {
            addCriterion("ws_remark not in", values, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkBetween(String value1, String value2) {
            addCriterion("ws_remark between", value1, value2, "wsRemark");
            return (Criteria) this;
        }

        public Criteria andWsRemarkNotBetween(String value1, String value2) {
            addCriterion("ws_remark not between", value1, value2, "wsRemark");
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

        public Criteria andBackDoorIsNull() {
            addCriterion("back_door is null");
            return (Criteria) this;
        }

        public Criteria andBackDoorIsNotNull() {
            addCriterion("back_door is not null");
            return (Criteria) this;
        }

        public Criteria andBackDoorEqualTo(String value) {
            addCriterion("back_door =", value, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorNotEqualTo(String value) {
            addCriterion("back_door <>", value, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorGreaterThan(String value) {
            addCriterion("back_door >", value, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorGreaterThanOrEqualTo(String value) {
            addCriterion("back_door >=", value, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorLessThan(String value) {
            addCriterion("back_door <", value, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorLessThanOrEqualTo(String value) {
            addCriterion("back_door <=", value, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorLike(String value) {
            addCriterion("back_door like", value, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorNotLike(String value) {
            addCriterion("back_door not like", value, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorIn(List<String> values) {
            addCriterion("back_door in", values, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorNotIn(List<String> values) {
            addCriterion("back_door not in", values, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorBetween(String value1, String value2) {
            addCriterion("back_door between", value1, value2, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorNotBetween(String value1, String value2) {
            addCriterion("back_door not between", value1, value2, "backDoor");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeIsNull() {
            addCriterion("back_door_specially_made is null");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeIsNotNull() {
            addCriterion("back_door_specially_made is not null");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeEqualTo(String value) {
            addCriterion("back_door_specially_made =", value, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeNotEqualTo(String value) {
            addCriterion("back_door_specially_made <>", value, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeGreaterThan(String value) {
            addCriterion("back_door_specially_made >", value, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeGreaterThanOrEqualTo(String value) {
            addCriterion("back_door_specially_made >=", value, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeLessThan(String value) {
            addCriterion("back_door_specially_made <", value, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeLessThanOrEqualTo(String value) {
            addCriterion("back_door_specially_made <=", value, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeLike(String value) {
            addCriterion("back_door_specially_made like", value, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeNotLike(String value) {
            addCriterion("back_door_specially_made not like", value, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeIn(List<String> values) {
            addCriterion("back_door_specially_made in", values, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeNotIn(List<String> values) {
            addCriterion("back_door_specially_made not in", values, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeBetween(String value1, String value2) {
            addCriterion("back_door_specially_made between", value1, value2, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBackDoorSpeciallyMadeNotBetween(String value1, String value2) {
            addCriterion("back_door_specially_made not between", value1, value2, "backDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andBdQuantityIsNull() {
            addCriterion("bd_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBdQuantityIsNotNull() {
            addCriterion("bd_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBdQuantityEqualTo(String value) {
            addCriterion("bd_quantity =", value, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityNotEqualTo(String value) {
            addCriterion("bd_quantity <>", value, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityGreaterThan(String value) {
            addCriterion("bd_quantity >", value, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("bd_quantity >=", value, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityLessThan(String value) {
            addCriterion("bd_quantity <", value, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityLessThanOrEqualTo(String value) {
            addCriterion("bd_quantity <=", value, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityLike(String value) {
            addCriterion("bd_quantity like", value, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityNotLike(String value) {
            addCriterion("bd_quantity not like", value, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityIn(List<String> values) {
            addCriterion("bd_quantity in", values, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityNotIn(List<String> values) {
            addCriterion("bd_quantity not in", values, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityBetween(String value1, String value2) {
            addCriterion("bd_quantity between", value1, value2, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdQuantityNotBetween(String value1, String value2) {
            addCriterion("bd_quantity not between", value1, value2, "bdQuantity");
            return (Criteria) this;
        }

        public Criteria andBdRemarkIsNull() {
            addCriterion("bd_remark is null");
            return (Criteria) this;
        }

        public Criteria andBdRemarkIsNotNull() {
            addCriterion("bd_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBdRemarkEqualTo(String value) {
            addCriterion("bd_remark =", value, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkNotEqualTo(String value) {
            addCriterion("bd_remark <>", value, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkGreaterThan(String value) {
            addCriterion("bd_remark >", value, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("bd_remark >=", value, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkLessThan(String value) {
            addCriterion("bd_remark <", value, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkLessThanOrEqualTo(String value) {
            addCriterion("bd_remark <=", value, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkLike(String value) {
            addCriterion("bd_remark like", value, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkNotLike(String value) {
            addCriterion("bd_remark not like", value, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkIn(List<String> values) {
            addCriterion("bd_remark in", values, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkNotIn(List<String> values) {
            addCriterion("bd_remark not in", values, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkBetween(String value1, String value2) {
            addCriterion("bd_remark between", value1, value2, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andBdRemarkNotBetween(String value1, String value2) {
            addCriterion("bd_remark not between", value1, value2, "bdRemark");
            return (Criteria) this;
        }

        public Criteria andSQuantityIsNull() {
            addCriterion("s_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSQuantityIsNotNull() {
            addCriterion("s_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSQuantityEqualTo(String value) {
            addCriterion("s_quantity =", value, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityNotEqualTo(String value) {
            addCriterion("s_quantity <>", value, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityGreaterThan(String value) {
            addCriterion("s_quantity >", value, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("s_quantity >=", value, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityLessThan(String value) {
            addCriterion("s_quantity <", value, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityLessThanOrEqualTo(String value) {
            addCriterion("s_quantity <=", value, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityLike(String value) {
            addCriterion("s_quantity like", value, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityNotLike(String value) {
            addCriterion("s_quantity not like", value, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityIn(List<String> values) {
            addCriterion("s_quantity in", values, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityNotIn(List<String> values) {
            addCriterion("s_quantity not in", values, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityBetween(String value1, String value2) {
            addCriterion("s_quantity between", value1, value2, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSQuantityNotBetween(String value1, String value2) {
            addCriterion("s_quantity not between", value1, value2, "sQuantity");
            return (Criteria) this;
        }

        public Criteria andSRemarkIsNull() {
            addCriterion("s_remark is null");
            return (Criteria) this;
        }

        public Criteria andSRemarkIsNotNull() {
            addCriterion("s_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSRemarkEqualTo(String value) {
            addCriterion("s_remark =", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotEqualTo(String value) {
            addCriterion("s_remark <>", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkGreaterThan(String value) {
            addCriterion("s_remark >", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("s_remark >=", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkLessThan(String value) {
            addCriterion("s_remark <", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkLessThanOrEqualTo(String value) {
            addCriterion("s_remark <=", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkLike(String value) {
            addCriterion("s_remark like", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotLike(String value) {
            addCriterion("s_remark not like", value, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkIn(List<String> values) {
            addCriterion("s_remark in", values, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotIn(List<String> values) {
            addCriterion("s_remark not in", values, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkBetween(String value1, String value2) {
            addCriterion("s_remark between", value1, value2, "sRemark");
            return (Criteria) this;
        }

        public Criteria andSRemarkNotBetween(String value1, String value2) {
            addCriterion("s_remark not between", value1, value2, "sRemark");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityIsNull() {
            addCriterion("bpnc_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityIsNotNull() {
            addCriterion("bpnc_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityEqualTo(String value) {
            addCriterion("bpnc_quantity =", value, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityNotEqualTo(String value) {
            addCriterion("bpnc_quantity <>", value, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityGreaterThan(String value) {
            addCriterion("bpnc_quantity >", value, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("bpnc_quantity >=", value, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityLessThan(String value) {
            addCriterion("bpnc_quantity <", value, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityLessThanOrEqualTo(String value) {
            addCriterion("bpnc_quantity <=", value, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityLike(String value) {
            addCriterion("bpnc_quantity like", value, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityNotLike(String value) {
            addCriterion("bpnc_quantity not like", value, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityIn(List<String> values) {
            addCriterion("bpnc_quantity in", values, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityNotIn(List<String> values) {
            addCriterion("bpnc_quantity not in", values, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityBetween(String value1, String value2) {
            addCriterion("bpnc_quantity between", value1, value2, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncQuantityNotBetween(String value1, String value2) {
            addCriterion("bpnc_quantity not between", value1, value2, "bpncQuantity");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkIsNull() {
            addCriterion("bpnc_remark is null");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkIsNotNull() {
            addCriterion("bpnc_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkEqualTo(String value) {
            addCriterion("bpnc_remark =", value, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkNotEqualTo(String value) {
            addCriterion("bpnc_remark <>", value, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkGreaterThan(String value) {
            addCriterion("bpnc_remark >", value, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("bpnc_remark >=", value, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkLessThan(String value) {
            addCriterion("bpnc_remark <", value, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkLessThanOrEqualTo(String value) {
            addCriterion("bpnc_remark <=", value, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkLike(String value) {
            addCriterion("bpnc_remark like", value, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkNotLike(String value) {
            addCriterion("bpnc_remark not like", value, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkIn(List<String> values) {
            addCriterion("bpnc_remark in", values, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkNotIn(List<String> values) {
            addCriterion("bpnc_remark not in", values, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkBetween(String value1, String value2) {
            addCriterion("bpnc_remark between", value1, value2, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andBpncRemarkNotBetween(String value1, String value2) {
            addCriterion("bpnc_remark not between", value1, value2, "bpncRemark");
            return (Criteria) this;
        }

        public Criteria andFrontDoorIsNull() {
            addCriterion("front_door is null");
            return (Criteria) this;
        }

        public Criteria andFrontDoorIsNotNull() {
            addCriterion("front_door is not null");
            return (Criteria) this;
        }

        public Criteria andFrontDoorEqualTo(String value) {
            addCriterion("front_door =", value, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorNotEqualTo(String value) {
            addCriterion("front_door <>", value, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorGreaterThan(String value) {
            addCriterion("front_door >", value, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorGreaterThanOrEqualTo(String value) {
            addCriterion("front_door >=", value, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorLessThan(String value) {
            addCriterion("front_door <", value, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorLessThanOrEqualTo(String value) {
            addCriterion("front_door <=", value, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorLike(String value) {
            addCriterion("front_door like", value, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorNotLike(String value) {
            addCriterion("front_door not like", value, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorIn(List<String> values) {
            addCriterion("front_door in", values, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorNotIn(List<String> values) {
            addCriterion("front_door not in", values, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorBetween(String value1, String value2) {
            addCriterion("front_door between", value1, value2, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFrontDoorNotBetween(String value1, String value2) {
            addCriterion("front_door not between", value1, value2, "frontDoor");
            return (Criteria) this;
        }

        public Criteria andFdQuantityIsNull() {
            addCriterion("fd_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFdQuantityIsNotNull() {
            addCriterion("fd_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFdQuantityEqualTo(String value) {
            addCriterion("fd_quantity =", value, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityNotEqualTo(String value) {
            addCriterion("fd_quantity <>", value, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityGreaterThan(String value) {
            addCriterion("fd_quantity >", value, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("fd_quantity >=", value, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityLessThan(String value) {
            addCriterion("fd_quantity <", value, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityLessThanOrEqualTo(String value) {
            addCriterion("fd_quantity <=", value, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityLike(String value) {
            addCriterion("fd_quantity like", value, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityNotLike(String value) {
            addCriterion("fd_quantity not like", value, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityIn(List<String> values) {
            addCriterion("fd_quantity in", values, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityNotIn(List<String> values) {
            addCriterion("fd_quantity not in", values, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityBetween(String value1, String value2) {
            addCriterion("fd_quantity between", value1, value2, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdQuantityNotBetween(String value1, String value2) {
            addCriterion("fd_quantity not between", value1, value2, "fdQuantity");
            return (Criteria) this;
        }

        public Criteria andFdRemarkIsNull() {
            addCriterion("fd_remark is null");
            return (Criteria) this;
        }

        public Criteria andFdRemarkIsNotNull() {
            addCriterion("fd_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFdRemarkEqualTo(String value) {
            addCriterion("fd_remark =", value, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkNotEqualTo(String value) {
            addCriterion("fd_remark <>", value, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkGreaterThan(String value) {
            addCriterion("fd_remark >", value, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("fd_remark >=", value, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkLessThan(String value) {
            addCriterion("fd_remark <", value, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkLessThanOrEqualTo(String value) {
            addCriterion("fd_remark <=", value, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkLike(String value) {
            addCriterion("fd_remark like", value, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkNotLike(String value) {
            addCriterion("fd_remark not like", value, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkIn(List<String> values) {
            addCriterion("fd_remark in", values, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkNotIn(List<String> values) {
            addCriterion("fd_remark not in", values, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkBetween(String value1, String value2) {
            addCriterion("fd_remark between", value1, value2, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andFdRemarkNotBetween(String value1, String value2) {
            addCriterion("fd_remark not between", value1, value2, "fdRemark");
            return (Criteria) this;
        }

        public Criteria andBpQuantityIsNull() {
            addCriterion("bp_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBpQuantityIsNotNull() {
            addCriterion("bp_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBpQuantityEqualTo(String value) {
            addCriterion("bp_quantity =", value, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityNotEqualTo(String value) {
            addCriterion("bp_quantity <>", value, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityGreaterThan(String value) {
            addCriterion("bp_quantity >", value, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("bp_quantity >=", value, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityLessThan(String value) {
            addCriterion("bp_quantity <", value, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityLessThanOrEqualTo(String value) {
            addCriterion("bp_quantity <=", value, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityLike(String value) {
            addCriterion("bp_quantity like", value, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityNotLike(String value) {
            addCriterion("bp_quantity not like", value, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityIn(List<String> values) {
            addCriterion("bp_quantity in", values, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityNotIn(List<String> values) {
            addCriterion("bp_quantity not in", values, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityBetween(String value1, String value2) {
            addCriterion("bp_quantity between", value1, value2, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpQuantityNotBetween(String value1, String value2) {
            addCriterion("bp_quantity not between", value1, value2, "bpQuantity");
            return (Criteria) this;
        }

        public Criteria andBpRemarkIsNull() {
            addCriterion("bp_remark is null");
            return (Criteria) this;
        }

        public Criteria andBpRemarkIsNotNull() {
            addCriterion("bp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBpRemarkEqualTo(String value) {
            addCriterion("bp_remark =", value, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkNotEqualTo(String value) {
            addCriterion("bp_remark <>", value, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkGreaterThan(String value) {
            addCriterion("bp_remark >", value, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("bp_remark >=", value, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkLessThan(String value) {
            addCriterion("bp_remark <", value, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkLessThanOrEqualTo(String value) {
            addCriterion("bp_remark <=", value, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkLike(String value) {
            addCriterion("bp_remark like", value, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkNotLike(String value) {
            addCriterion("bp_remark not like", value, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkIn(List<String> values) {
            addCriterion("bp_remark in", values, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkNotIn(List<String> values) {
            addCriterion("bp_remark not in", values, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkBetween(String value1, String value2) {
            addCriterion("bp_remark between", value1, value2, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andBpRemarkNotBetween(String value1, String value2) {
            addCriterion("bp_remark not between", value1, value2, "bpRemark");
            return (Criteria) this;
        }

        public Criteria andNwQuantityIsNull() {
            addCriterion("nw_quantity is null");
            return (Criteria) this;
        }

        public Criteria andNwQuantityIsNotNull() {
            addCriterion("nw_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andNwQuantityEqualTo(String value) {
            addCriterion("nw_quantity =", value, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityNotEqualTo(String value) {
            addCriterion("nw_quantity <>", value, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityGreaterThan(String value) {
            addCriterion("nw_quantity >", value, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("nw_quantity >=", value, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityLessThan(String value) {
            addCriterion("nw_quantity <", value, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityLessThanOrEqualTo(String value) {
            addCriterion("nw_quantity <=", value, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityLike(String value) {
            addCriterion("nw_quantity like", value, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityNotLike(String value) {
            addCriterion("nw_quantity not like", value, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityIn(List<String> values) {
            addCriterion("nw_quantity in", values, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityNotIn(List<String> values) {
            addCriterion("nw_quantity not in", values, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityBetween(String value1, String value2) {
            addCriterion("nw_quantity between", value1, value2, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwQuantityNotBetween(String value1, String value2) {
            addCriterion("nw_quantity not between", value1, value2, "nwQuantity");
            return (Criteria) this;
        }

        public Criteria andNwRemarkIsNull() {
            addCriterion("nw_remark is null");
            return (Criteria) this;
        }

        public Criteria andNwRemarkIsNotNull() {
            addCriterion("nw_remark is not null");
            return (Criteria) this;
        }

        public Criteria andNwRemarkEqualTo(String value) {
            addCriterion("nw_remark =", value, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkNotEqualTo(String value) {
            addCriterion("nw_remark <>", value, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkGreaterThan(String value) {
            addCriterion("nw_remark >", value, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("nw_remark >=", value, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkLessThan(String value) {
            addCriterion("nw_remark <", value, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkLessThanOrEqualTo(String value) {
            addCriterion("nw_remark <=", value, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkLike(String value) {
            addCriterion("nw_remark like", value, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkNotLike(String value) {
            addCriterion("nw_remark not like", value, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkIn(List<String> values) {
            addCriterion("nw_remark in", values, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkNotIn(List<String> values) {
            addCriterion("nw_remark not in", values, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkBetween(String value1, String value2) {
            addCriterion("nw_remark between", value1, value2, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andNwRemarkNotBetween(String value1, String value2) {
            addCriterion("nw_remark not between", value1, value2, "nwRemark");
            return (Criteria) this;
        }

        public Criteria andRQuantityIsNull() {
            addCriterion("r_quantity is null");
            return (Criteria) this;
        }

        public Criteria andRQuantityIsNotNull() {
            addCriterion("r_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andRQuantityEqualTo(String value) {
            addCriterion("r_quantity =", value, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityNotEqualTo(String value) {
            addCriterion("r_quantity <>", value, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityGreaterThan(String value) {
            addCriterion("r_quantity >", value, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("r_quantity >=", value, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityLessThan(String value) {
            addCriterion("r_quantity <", value, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityLessThanOrEqualTo(String value) {
            addCriterion("r_quantity <=", value, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityLike(String value) {
            addCriterion("r_quantity like", value, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityNotLike(String value) {
            addCriterion("r_quantity not like", value, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityIn(List<String> values) {
            addCriterion("r_quantity in", values, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityNotIn(List<String> values) {
            addCriterion("r_quantity not in", values, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityBetween(String value1, String value2) {
            addCriterion("r_quantity between", value1, value2, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRQuantityNotBetween(String value1, String value2) {
            addCriterion("r_quantity not between", value1, value2, "rQuantity");
            return (Criteria) this;
        }

        public Criteria andRRemarkIsNull() {
            addCriterion("r_remark is null");
            return (Criteria) this;
        }

        public Criteria andRRemarkIsNotNull() {
            addCriterion("r_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRRemarkEqualTo(String value) {
            addCriterion("r_remark =", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotEqualTo(String value) {
            addCriterion("r_remark <>", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkGreaterThan(String value) {
            addCriterion("r_remark >", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("r_remark >=", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkLessThan(String value) {
            addCriterion("r_remark <", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkLessThanOrEqualTo(String value) {
            addCriterion("r_remark <=", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkLike(String value) {
            addCriterion("r_remark like", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotLike(String value) {
            addCriterion("r_remark not like", value, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkIn(List<String> values) {
            addCriterion("r_remark in", values, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotIn(List<String> values) {
            addCriterion("r_remark not in", values, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkBetween(String value1, String value2) {
            addCriterion("r_remark between", value1, value2, "rRemark");
            return (Criteria) this;
        }

        public Criteria andRRemarkNotBetween(String value1, String value2) {
            addCriterion("r_remark not between", value1, value2, "rRemark");
            return (Criteria) this;
        }

        public Criteria andCopperIsNull() {
            addCriterion("copper is null");
            return (Criteria) this;
        }

        public Criteria andCopperIsNotNull() {
            addCriterion("copper is not null");
            return (Criteria) this;
        }

        public Criteria andCopperEqualTo(String value) {
            addCriterion("copper =", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperNotEqualTo(String value) {
            addCriterion("copper <>", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperGreaterThan(String value) {
            addCriterion("copper >", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperGreaterThanOrEqualTo(String value) {
            addCriterion("copper >=", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperLessThan(String value) {
            addCriterion("copper <", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperLessThanOrEqualTo(String value) {
            addCriterion("copper <=", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperLike(String value) {
            addCriterion("copper like", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperNotLike(String value) {
            addCriterion("copper not like", value, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperIn(List<String> values) {
            addCriterion("copper in", values, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperNotIn(List<String> values) {
            addCriterion("copper not in", values, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperBetween(String value1, String value2) {
            addCriterion("copper between", value1, value2, "copper");
            return (Criteria) this;
        }

        public Criteria andCopperNotBetween(String value1, String value2) {
            addCriterion("copper not between", value1, value2, "copper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperIsNull() {
            addCriterion("special_copper is null");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperIsNotNull() {
            addCriterion("special_copper is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperEqualTo(String value) {
            addCriterion("special_copper =", value, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperNotEqualTo(String value) {
            addCriterion("special_copper <>", value, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperGreaterThan(String value) {
            addCriterion("special_copper >", value, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperGreaterThanOrEqualTo(String value) {
            addCriterion("special_copper >=", value, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperLessThan(String value) {
            addCriterion("special_copper <", value, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperLessThanOrEqualTo(String value) {
            addCriterion("special_copper <=", value, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperLike(String value) {
            addCriterion("special_copper like", value, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperNotLike(String value) {
            addCriterion("special_copper not like", value, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperIn(List<String> values) {
            addCriterion("special_copper in", values, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperNotIn(List<String> values) {
            addCriterion("special_copper not in", values, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperBetween(String value1, String value2) {
            addCriterion("special_copper between", value1, value2, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andSpecialCopperNotBetween(String value1, String value2) {
            addCriterion("special_copper not between", value1, value2, "specialCopper");
            return (Criteria) this;
        }

        public Criteria andCQuantityIsNull() {
            addCriterion("c_quantity is null");
            return (Criteria) this;
        }

        public Criteria andCQuantityIsNotNull() {
            addCriterion("c_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andCQuantityEqualTo(String value) {
            addCriterion("c_quantity =", value, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityNotEqualTo(String value) {
            addCriterion("c_quantity <>", value, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityGreaterThan(String value) {
            addCriterion("c_quantity >", value, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("c_quantity >=", value, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityLessThan(String value) {
            addCriterion("c_quantity <", value, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityLessThanOrEqualTo(String value) {
            addCriterion("c_quantity <=", value, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityLike(String value) {
            addCriterion("c_quantity like", value, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityNotLike(String value) {
            addCriterion("c_quantity not like", value, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityIn(List<String> values) {
            addCriterion("c_quantity in", values, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityNotIn(List<String> values) {
            addCriterion("c_quantity not in", values, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityBetween(String value1, String value2) {
            addCriterion("c_quantity between", value1, value2, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCQuantityNotBetween(String value1, String value2) {
            addCriterion("c_quantity not between", value1, value2, "cQuantity");
            return (Criteria) this;
        }

        public Criteria andCRemarkIsNull() {
            addCriterion("c_remark is null");
            return (Criteria) this;
        }

        public Criteria andCRemarkIsNotNull() {
            addCriterion("c_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCRemarkEqualTo(String value) {
            addCriterion("c_remark =", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotEqualTo(String value) {
            addCriterion("c_remark <>", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkGreaterThan(String value) {
            addCriterion("c_remark >", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("c_remark >=", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkLessThan(String value) {
            addCriterion("c_remark <", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkLessThanOrEqualTo(String value) {
            addCriterion("c_remark <=", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkLike(String value) {
            addCriterion("c_remark like", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotLike(String value) {
            addCriterion("c_remark not like", value, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkIn(List<String> values) {
            addCriterion("c_remark in", values, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotIn(List<String> values) {
            addCriterion("c_remark not in", values, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkBetween(String value1, String value2) {
            addCriterion("c_remark between", value1, value2, "cRemark");
            return (Criteria) this;
        }

        public Criteria andCRemarkNotBetween(String value1, String value2) {
            addCriterion("c_remark not between", value1, value2, "cRemark");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightIsNull() {
            addCriterion("ground_plane_height is null");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightIsNotNull() {
            addCriterion("ground_plane_height is not null");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightEqualTo(String value) {
            addCriterion("ground_plane_height =", value, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightNotEqualTo(String value) {
            addCriterion("ground_plane_height <>", value, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightGreaterThan(String value) {
            addCriterion("ground_plane_height >", value, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightGreaterThanOrEqualTo(String value) {
            addCriterion("ground_plane_height >=", value, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightLessThan(String value) {
            addCriterion("ground_plane_height <", value, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightLessThanOrEqualTo(String value) {
            addCriterion("ground_plane_height <=", value, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightLike(String value) {
            addCriterion("ground_plane_height like", value, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightNotLike(String value) {
            addCriterion("ground_plane_height not like", value, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightIn(List<String> values) {
            addCriterion("ground_plane_height in", values, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightNotIn(List<String> values) {
            addCriterion("ground_plane_height not in", values, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightBetween(String value1, String value2) {
            addCriterion("ground_plane_height between", value1, value2, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGroundPlaneHeightNotBetween(String value1, String value2) {
            addCriterion("ground_plane_height not between", value1, value2, "groundPlaneHeight");
            return (Criteria) this;
        }

        public Criteria andGpQuantityIsNull() {
            addCriterion("gp_quantity is null");
            return (Criteria) this;
        }

        public Criteria andGpQuantityIsNotNull() {
            addCriterion("gp_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andGpQuantityEqualTo(String value) {
            addCriterion("gp_quantity =", value, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityNotEqualTo(String value) {
            addCriterion("gp_quantity <>", value, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityGreaterThan(String value) {
            addCriterion("gp_quantity >", value, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("gp_quantity >=", value, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityLessThan(String value) {
            addCriterion("gp_quantity <", value, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityLessThanOrEqualTo(String value) {
            addCriterion("gp_quantity <=", value, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityLike(String value) {
            addCriterion("gp_quantity like", value, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityNotLike(String value) {
            addCriterion("gp_quantity not like", value, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityIn(List<String> values) {
            addCriterion("gp_quantity in", values, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityNotIn(List<String> values) {
            addCriterion("gp_quantity not in", values, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityBetween(String value1, String value2) {
            addCriterion("gp_quantity between", value1, value2, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpQuantityNotBetween(String value1, String value2) {
            addCriterion("gp_quantity not between", value1, value2, "gpQuantity");
            return (Criteria) this;
        }

        public Criteria andGpRemarkIsNull() {
            addCriterion("gp_remark is null");
            return (Criteria) this;
        }

        public Criteria andGpRemarkIsNotNull() {
            addCriterion("gp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andGpRemarkEqualTo(String value) {
            addCriterion("gp_remark =", value, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkNotEqualTo(String value) {
            addCriterion("gp_remark <>", value, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkGreaterThan(String value) {
            addCriterion("gp_remark >", value, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("gp_remark >=", value, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkLessThan(String value) {
            addCriterion("gp_remark <", value, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkLessThanOrEqualTo(String value) {
            addCriterion("gp_remark <=", value, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkLike(String value) {
            addCriterion("gp_remark like", value, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkNotLike(String value) {
            addCriterion("gp_remark not like", value, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkIn(List<String> values) {
            addCriterion("gp_remark in", values, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkNotIn(List<String> values) {
            addCriterion("gp_remark not in", values, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkBetween(String value1, String value2) {
            addCriterion("gp_remark between", value1, value2, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andGpRemarkNotBetween(String value1, String value2) {
            addCriterion("gp_remark not between", value1, value2, "gpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityIsNull() {
            addCriterion("blrp_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityIsNotNull() {
            addCriterion("blrp_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityEqualTo(String value) {
            addCriterion("blrp_quantity =", value, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityNotEqualTo(String value) {
            addCriterion("blrp_quantity <>", value, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityGreaterThan(String value) {
            addCriterion("blrp_quantity >", value, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("blrp_quantity >=", value, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityLessThan(String value) {
            addCriterion("blrp_quantity <", value, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityLessThanOrEqualTo(String value) {
            addCriterion("blrp_quantity <=", value, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityLike(String value) {
            addCriterion("blrp_quantity like", value, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityNotLike(String value) {
            addCriterion("blrp_quantity not like", value, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityIn(List<String> values) {
            addCriterion("blrp_quantity in", values, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityNotIn(List<String> values) {
            addCriterion("blrp_quantity not in", values, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityBetween(String value1, String value2) {
            addCriterion("blrp_quantity between", value1, value2, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpQuantityNotBetween(String value1, String value2) {
            addCriterion("blrp_quantity not between", value1, value2, "blrpQuantity");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkIsNull() {
            addCriterion("blrp_remark is null");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkIsNotNull() {
            addCriterion("blrp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkEqualTo(String value) {
            addCriterion("blrp_remark =", value, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkNotEqualTo(String value) {
            addCriterion("blrp_remark <>", value, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkGreaterThan(String value) {
            addCriterion("blrp_remark >", value, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("blrp_remark >=", value, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkLessThan(String value) {
            addCriterion("blrp_remark <", value, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkLessThanOrEqualTo(String value) {
            addCriterion("blrp_remark <=", value, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkLike(String value) {
            addCriterion("blrp_remark like", value, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkNotLike(String value) {
            addCriterion("blrp_remark not like", value, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkIn(List<String> values) {
            addCriterion("blrp_remark in", values, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkNotIn(List<String> values) {
            addCriterion("blrp_remark not in", values, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkBetween(String value1, String value2) {
            addCriterion("blrp_remark between", value1, value2, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlrpRemarkNotBetween(String value1, String value2) {
            addCriterion("blrp_remark not between", value1, value2, "blrpRemark");
            return (Criteria) this;
        }

        public Criteria andBlQuantityIsNull() {
            addCriterion("bl_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBlQuantityIsNotNull() {
            addCriterion("bl_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBlQuantityEqualTo(String value) {
            addCriterion("bl_quantity =", value, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityNotEqualTo(String value) {
            addCriterion("bl_quantity <>", value, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityGreaterThan(String value) {
            addCriterion("bl_quantity >", value, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("bl_quantity >=", value, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityLessThan(String value) {
            addCriterion("bl_quantity <", value, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityLessThanOrEqualTo(String value) {
            addCriterion("bl_quantity <=", value, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityLike(String value) {
            addCriterion("bl_quantity like", value, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityNotLike(String value) {
            addCriterion("bl_quantity not like", value, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityIn(List<String> values) {
            addCriterion("bl_quantity in", values, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityNotIn(List<String> values) {
            addCriterion("bl_quantity not in", values, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityBetween(String value1, String value2) {
            addCriterion("bl_quantity between", value1, value2, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlQuantityNotBetween(String value1, String value2) {
            addCriterion("bl_quantity not between", value1, value2, "blQuantity");
            return (Criteria) this;
        }

        public Criteria andBlRemarkIsNull() {
            addCriterion("bl_remark is null");
            return (Criteria) this;
        }

        public Criteria andBlRemarkIsNotNull() {
            addCriterion("bl_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBlRemarkEqualTo(String value) {
            addCriterion("bl_remark =", value, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkNotEqualTo(String value) {
            addCriterion("bl_remark <>", value, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkGreaterThan(String value) {
            addCriterion("bl_remark >", value, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("bl_remark >=", value, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkLessThan(String value) {
            addCriterion("bl_remark <", value, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkLessThanOrEqualTo(String value) {
            addCriterion("bl_remark <=", value, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkLike(String value) {
            addCriterion("bl_remark like", value, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkNotLike(String value) {
            addCriterion("bl_remark not like", value, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkIn(List<String> values) {
            addCriterion("bl_remark in", values, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkNotIn(List<String> values) {
            addCriterion("bl_remark not in", values, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkBetween(String value1, String value2) {
            addCriterion("bl_remark between", value1, value2, "blRemark");
            return (Criteria) this;
        }

        public Criteria andBlRemarkNotBetween(String value1, String value2) {
            addCriterion("bl_remark not between", value1, value2, "blRemark");
            return (Criteria) this;
        }

        public Criteria andSpQuantityIsNull() {
            addCriterion("sp_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSpQuantityIsNotNull() {
            addCriterion("sp_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSpQuantityEqualTo(String value) {
            addCriterion("sp_quantity =", value, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityNotEqualTo(String value) {
            addCriterion("sp_quantity <>", value, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityGreaterThan(String value) {
            addCriterion("sp_quantity >", value, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("sp_quantity >=", value, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityLessThan(String value) {
            addCriterion("sp_quantity <", value, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityLessThanOrEqualTo(String value) {
            addCriterion("sp_quantity <=", value, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityLike(String value) {
            addCriterion("sp_quantity like", value, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityNotLike(String value) {
            addCriterion("sp_quantity not like", value, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityIn(List<String> values) {
            addCriterion("sp_quantity in", values, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityNotIn(List<String> values) {
            addCriterion("sp_quantity not in", values, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityBetween(String value1, String value2) {
            addCriterion("sp_quantity between", value1, value2, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpQuantityNotBetween(String value1, String value2) {
            addCriterion("sp_quantity not between", value1, value2, "spQuantity");
            return (Criteria) this;
        }

        public Criteria andSpRemarkIsNull() {
            addCriterion("sp_remark is null");
            return (Criteria) this;
        }

        public Criteria andSpRemarkIsNotNull() {
            addCriterion("sp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSpRemarkEqualTo(String value) {
            addCriterion("sp_remark =", value, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkNotEqualTo(String value) {
            addCriterion("sp_remark <>", value, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkGreaterThan(String value) {
            addCriterion("sp_remark >", value, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sp_remark >=", value, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkLessThan(String value) {
            addCriterion("sp_remark <", value, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkLessThanOrEqualTo(String value) {
            addCriterion("sp_remark <=", value, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkLike(String value) {
            addCriterion("sp_remark like", value, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkNotLike(String value) {
            addCriterion("sp_remark not like", value, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkIn(List<String> values) {
            addCriterion("sp_remark in", values, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkNotIn(List<String> values) {
            addCriterion("sp_remark not in", values, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkBetween(String value1, String value2) {
            addCriterion("sp_remark between", value1, value2, "spRemark");
            return (Criteria) this;
        }

        public Criteria andSpRemarkNotBetween(String value1, String value2) {
            addCriterion("sp_remark not between", value1, value2, "spRemark");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityIsNull() {
            addCriterion("tada_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityIsNotNull() {
            addCriterion("tada_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityEqualTo(String value) {
            addCriterion("tada_quantity =", value, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityNotEqualTo(String value) {
            addCriterion("tada_quantity <>", value, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityGreaterThan(String value) {
            addCriterion("tada_quantity >", value, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("tada_quantity >=", value, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityLessThan(String value) {
            addCriterion("tada_quantity <", value, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityLessThanOrEqualTo(String value) {
            addCriterion("tada_quantity <=", value, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityLike(String value) {
            addCriterion("tada_quantity like", value, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityNotLike(String value) {
            addCriterion("tada_quantity not like", value, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityIn(List<String> values) {
            addCriterion("tada_quantity in", values, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityNotIn(List<String> values) {
            addCriterion("tada_quantity not in", values, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityBetween(String value1, String value2) {
            addCriterion("tada_quantity between", value1, value2, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaQuantityNotBetween(String value1, String value2) {
            addCriterion("tada_quantity not between", value1, value2, "tadaQuantity");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkIsNull() {
            addCriterion("tada_remark is null");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkIsNotNull() {
            addCriterion("tada_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkEqualTo(String value) {
            addCriterion("tada_remark =", value, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkNotEqualTo(String value) {
            addCriterion("tada_remark <>", value, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkGreaterThan(String value) {
            addCriterion("tada_remark >", value, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("tada_remark >=", value, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkLessThan(String value) {
            addCriterion("tada_remark <", value, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkLessThanOrEqualTo(String value) {
            addCriterion("tada_remark <=", value, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkLike(String value) {
            addCriterion("tada_remark like", value, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkNotLike(String value) {
            addCriterion("tada_remark not like", value, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkIn(List<String> values) {
            addCriterion("tada_remark in", values, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkNotIn(List<String> values) {
            addCriterion("tada_remark not in", values, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkBetween(String value1, String value2) {
            addCriterion("tada_remark between", value1, value2, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andTadaRemarkNotBetween(String value1, String value2) {
            addCriterion("tada_remark not between", value1, value2, "tadaRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityIsNull() {
            addCriterion("connector_quantity is null");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityIsNotNull() {
            addCriterion("connector_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityEqualTo(String value) {
            addCriterion("connector_quantity =", value, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityNotEqualTo(String value) {
            addCriterion("connector_quantity <>", value, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityGreaterThan(String value) {
            addCriterion("connector_quantity >", value, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("connector_quantity >=", value, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityLessThan(String value) {
            addCriterion("connector_quantity <", value, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityLessThanOrEqualTo(String value) {
            addCriterion("connector_quantity <=", value, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityLike(String value) {
            addCriterion("connector_quantity like", value, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityNotLike(String value) {
            addCriterion("connector_quantity not like", value, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityIn(List<String> values) {
            addCriterion("connector_quantity in", values, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityNotIn(List<String> values) {
            addCriterion("connector_quantity not in", values, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityBetween(String value1, String value2) {
            addCriterion("connector_quantity between", value1, value2, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorQuantityNotBetween(String value1, String value2) {
            addCriterion("connector_quantity not between", value1, value2, "connectorQuantity");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkIsNull() {
            addCriterion("connector_remark is null");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkIsNotNull() {
            addCriterion("connector_remark is not null");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkEqualTo(String value) {
            addCriterion("connector_remark =", value, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkNotEqualTo(String value) {
            addCriterion("connector_remark <>", value, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkGreaterThan(String value) {
            addCriterion("connector_remark >", value, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("connector_remark >=", value, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkLessThan(String value) {
            addCriterion("connector_remark <", value, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkLessThanOrEqualTo(String value) {
            addCriterion("connector_remark <=", value, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkLike(String value) {
            addCriterion("connector_remark like", value, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkNotLike(String value) {
            addCriterion("connector_remark not like", value, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkIn(List<String> values) {
            addCriterion("connector_remark in", values, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkNotIn(List<String> values) {
            addCriterion("connector_remark not in", values, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkBetween(String value1, String value2) {
            addCriterion("connector_remark between", value1, value2, "connectorRemark");
            return (Criteria) this;
        }

        public Criteria andConnectorRemarkNotBetween(String value1, String value2) {
            addCriterion("connector_remark not between", value1, value2, "connectorRemark");
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