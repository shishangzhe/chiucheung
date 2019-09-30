package cn.chiucheung.po.sales.workcard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalWorkCardJg5Example implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalWorkCardJg5Example() {
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

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andOtherColorIsNull() {
            addCriterion("other_color is null");
            return (Criteria) this;
        }

        public Criteria andOtherColorIsNotNull() {
            addCriterion("other_color is not null");
            return (Criteria) this;
        }

        public Criteria andOtherColorEqualTo(String value) {
            addCriterion("other_color =", value, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorNotEqualTo(String value) {
            addCriterion("other_color <>", value, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorGreaterThan(String value) {
            addCriterion("other_color >", value, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorGreaterThanOrEqualTo(String value) {
            addCriterion("other_color >=", value, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorLessThan(String value) {
            addCriterion("other_color <", value, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorLessThanOrEqualTo(String value) {
            addCriterion("other_color <=", value, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorLike(String value) {
            addCriterion("other_color like", value, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorNotLike(String value) {
            addCriterion("other_color not like", value, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorIn(List<String> values) {
            addCriterion("other_color in", values, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorNotIn(List<String> values) {
            addCriterion("other_color not in", values, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorBetween(String value1, String value2) {
            addCriterion("other_color between", value1, value2, "otherColor");
            return (Criteria) this;
        }

        public Criteria andOtherColorNotBetween(String value1, String value2) {
            addCriterion("other_color not between", value1, value2, "otherColor");
            return (Criteria) this;
        }

        public Criteria andMfQuantityIsNull() {
            addCriterion("mf_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMfQuantityIsNotNull() {
            addCriterion("mf_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMfQuantityEqualTo(String value) {
            addCriterion("mf_quantity =", value, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityNotEqualTo(String value) {
            addCriterion("mf_quantity <>", value, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityGreaterThan(String value) {
            addCriterion("mf_quantity >", value, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("mf_quantity >=", value, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityLessThan(String value) {
            addCriterion("mf_quantity <", value, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityLessThanOrEqualTo(String value) {
            addCriterion("mf_quantity <=", value, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityLike(String value) {
            addCriterion("mf_quantity like", value, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityNotLike(String value) {
            addCriterion("mf_quantity not like", value, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityIn(List<String> values) {
            addCriterion("mf_quantity in", values, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityNotIn(List<String> values) {
            addCriterion("mf_quantity not in", values, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityBetween(String value1, String value2) {
            addCriterion("mf_quantity between", value1, value2, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfQuantityNotBetween(String value1, String value2) {
            addCriterion("mf_quantity not between", value1, value2, "mfQuantity");
            return (Criteria) this;
        }

        public Criteria andMfRemarkIsNull() {
            addCriterion("mf_remark is null");
            return (Criteria) this;
        }

        public Criteria andMfRemarkIsNotNull() {
            addCriterion("mf_remark is not null");
            return (Criteria) this;
        }

        public Criteria andMfRemarkEqualTo(String value) {
            addCriterion("mf_remark =", value, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkNotEqualTo(String value) {
            addCriterion("mf_remark <>", value, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkGreaterThan(String value) {
            addCriterion("mf_remark >", value, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("mf_remark >=", value, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkLessThan(String value) {
            addCriterion("mf_remark <", value, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkLessThanOrEqualTo(String value) {
            addCriterion("mf_remark <=", value, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkLike(String value) {
            addCriterion("mf_remark like", value, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkNotLike(String value) {
            addCriterion("mf_remark not like", value, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkIn(List<String> values) {
            addCriterion("mf_remark in", values, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkNotIn(List<String> values) {
            addCriterion("mf_remark not in", values, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkBetween(String value1, String value2) {
            addCriterion("mf_remark between", value1, value2, "mfRemark");
            return (Criteria) this;
        }

        public Criteria andMfRemarkNotBetween(String value1, String value2) {
            addCriterion("mf_remark not between", value1, value2, "mfRemark");
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

        public Criteria andFrontStandardAngleIsNull() {
            addCriterion("front_standard_angle is null");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleIsNotNull() {
            addCriterion("front_standard_angle is not null");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleEqualTo(String value) {
            addCriterion("front_standard_angle =", value, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleNotEqualTo(String value) {
            addCriterion("front_standard_angle <>", value, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleGreaterThan(String value) {
            addCriterion("front_standard_angle >", value, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleGreaterThanOrEqualTo(String value) {
            addCriterion("front_standard_angle >=", value, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleLessThan(String value) {
            addCriterion("front_standard_angle <", value, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleLessThanOrEqualTo(String value) {
            addCriterion("front_standard_angle <=", value, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleLike(String value) {
            addCriterion("front_standard_angle like", value, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleNotLike(String value) {
            addCriterion("front_standard_angle not like", value, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleIn(List<String> values) {
            addCriterion("front_standard_angle in", values, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleNotIn(List<String> values) {
            addCriterion("front_standard_angle not in", values, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleBetween(String value1, String value2) {
            addCriterion("front_standard_angle between", value1, value2, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleNotBetween(String value1, String value2) {
            addCriterion("front_standard_angle not between", value1, value2, "frontStandardAngle");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentIsNull() {
            addCriterion("front_standard_angle_content is null");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentIsNotNull() {
            addCriterion("front_standard_angle_content is not null");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentEqualTo(String value) {
            addCriterion("front_standard_angle_content =", value, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentNotEqualTo(String value) {
            addCriterion("front_standard_angle_content <>", value, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentGreaterThan(String value) {
            addCriterion("front_standard_angle_content >", value, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentGreaterThanOrEqualTo(String value) {
            addCriterion("front_standard_angle_content >=", value, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentLessThan(String value) {
            addCriterion("front_standard_angle_content <", value, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentLessThanOrEqualTo(String value) {
            addCriterion("front_standard_angle_content <=", value, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentLike(String value) {
            addCriterion("front_standard_angle_content like", value, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentNotLike(String value) {
            addCriterion("front_standard_angle_content not like", value, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentIn(List<String> values) {
            addCriterion("front_standard_angle_content in", values, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentNotIn(List<String> values) {
            addCriterion("front_standard_angle_content not in", values, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentBetween(String value1, String value2) {
            addCriterion("front_standard_angle_content between", value1, value2, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFrontStandardAngleContentNotBetween(String value1, String value2) {
            addCriterion("front_standard_angle_content not between", value1, value2, "frontStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityIsNull() {
            addCriterion("fsa_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityIsNotNull() {
            addCriterion("fsa_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityEqualTo(String value) {
            addCriterion("fsa_quantity =", value, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityNotEqualTo(String value) {
            addCriterion("fsa_quantity <>", value, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityGreaterThan(String value) {
            addCriterion("fsa_quantity >", value, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("fsa_quantity >=", value, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityLessThan(String value) {
            addCriterion("fsa_quantity <", value, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityLessThanOrEqualTo(String value) {
            addCriterion("fsa_quantity <=", value, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityLike(String value) {
            addCriterion("fsa_quantity like", value, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityNotLike(String value) {
            addCriterion("fsa_quantity not like", value, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityIn(List<String> values) {
            addCriterion("fsa_quantity in", values, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityNotIn(List<String> values) {
            addCriterion("fsa_quantity not in", values, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityBetween(String value1, String value2) {
            addCriterion("fsa_quantity between", value1, value2, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaQuantityNotBetween(String value1, String value2) {
            addCriterion("fsa_quantity not between", value1, value2, "fsaQuantity");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkIsNull() {
            addCriterion("fsa_remark is null");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkIsNotNull() {
            addCriterion("fsa_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkEqualTo(String value) {
            addCriterion("fsa_remark =", value, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkNotEqualTo(String value) {
            addCriterion("fsa_remark <>", value, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkGreaterThan(String value) {
            addCriterion("fsa_remark >", value, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("fsa_remark >=", value, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkLessThan(String value) {
            addCriterion("fsa_remark <", value, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkLessThanOrEqualTo(String value) {
            addCriterion("fsa_remark <=", value, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkLike(String value) {
            addCriterion("fsa_remark like", value, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkNotLike(String value) {
            addCriterion("fsa_remark not like", value, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkIn(List<String> values) {
            addCriterion("fsa_remark in", values, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkNotIn(List<String> values) {
            addCriterion("fsa_remark not in", values, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkBetween(String value1, String value2) {
            addCriterion("fsa_remark between", value1, value2, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andFsaRemarkNotBetween(String value1, String value2) {
            addCriterion("fsa_remark not between", value1, value2, "fsaRemark");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleIsNull() {
            addCriterion("after_standard_angle is null");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleIsNotNull() {
            addCriterion("after_standard_angle is not null");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleEqualTo(String value) {
            addCriterion("after_standard_angle =", value, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleNotEqualTo(String value) {
            addCriterion("after_standard_angle <>", value, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleGreaterThan(String value) {
            addCriterion("after_standard_angle >", value, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleGreaterThanOrEqualTo(String value) {
            addCriterion("after_standard_angle >=", value, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleLessThan(String value) {
            addCriterion("after_standard_angle <", value, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleLessThanOrEqualTo(String value) {
            addCriterion("after_standard_angle <=", value, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleLike(String value) {
            addCriterion("after_standard_angle like", value, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleNotLike(String value) {
            addCriterion("after_standard_angle not like", value, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleIn(List<String> values) {
            addCriterion("after_standard_angle in", values, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleNotIn(List<String> values) {
            addCriterion("after_standard_angle not in", values, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleBetween(String value1, String value2) {
            addCriterion("after_standard_angle between", value1, value2, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleNotBetween(String value1, String value2) {
            addCriterion("after_standard_angle not between", value1, value2, "afterStandardAngle");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentIsNull() {
            addCriterion("after_standard_angle_content is null");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentIsNotNull() {
            addCriterion("after_standard_angle_content is not null");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentEqualTo(String value) {
            addCriterion("after_standard_angle_content =", value, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentNotEqualTo(String value) {
            addCriterion("after_standard_angle_content <>", value, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentGreaterThan(String value) {
            addCriterion("after_standard_angle_content >", value, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentGreaterThanOrEqualTo(String value) {
            addCriterion("after_standard_angle_content >=", value, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentLessThan(String value) {
            addCriterion("after_standard_angle_content <", value, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentLessThanOrEqualTo(String value) {
            addCriterion("after_standard_angle_content <=", value, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentLike(String value) {
            addCriterion("after_standard_angle_content like", value, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentNotLike(String value) {
            addCriterion("after_standard_angle_content not like", value, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentIn(List<String> values) {
            addCriterion("after_standard_angle_content in", values, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentNotIn(List<String> values) {
            addCriterion("after_standard_angle_content not in", values, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentBetween(String value1, String value2) {
            addCriterion("after_standard_angle_content between", value1, value2, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAfterStandardAngleContentNotBetween(String value1, String value2) {
            addCriterion("after_standard_angle_content not between", value1, value2, "afterStandardAngleContent");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityIsNull() {
            addCriterion("asa_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityIsNotNull() {
            addCriterion("asa_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityEqualTo(String value) {
            addCriterion("asa_quantity =", value, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityNotEqualTo(String value) {
            addCriterion("asa_quantity <>", value, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityGreaterThan(String value) {
            addCriterion("asa_quantity >", value, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("asa_quantity >=", value, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityLessThan(String value) {
            addCriterion("asa_quantity <", value, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityLessThanOrEqualTo(String value) {
            addCriterion("asa_quantity <=", value, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityLike(String value) {
            addCriterion("asa_quantity like", value, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityNotLike(String value) {
            addCriterion("asa_quantity not like", value, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityIn(List<String> values) {
            addCriterion("asa_quantity in", values, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityNotIn(List<String> values) {
            addCriterion("asa_quantity not in", values, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityBetween(String value1, String value2) {
            addCriterion("asa_quantity between", value1, value2, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaQuantityNotBetween(String value1, String value2) {
            addCriterion("asa_quantity not between", value1, value2, "asaQuantity");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkIsNull() {
            addCriterion("asa_remark is null");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkIsNotNull() {
            addCriterion("asa_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkEqualTo(String value) {
            addCriterion("asa_remark =", value, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkNotEqualTo(String value) {
            addCriterion("asa_remark <>", value, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkGreaterThan(String value) {
            addCriterion("asa_remark >", value, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("asa_remark >=", value, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkLessThan(String value) {
            addCriterion("asa_remark <", value, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkLessThanOrEqualTo(String value) {
            addCriterion("asa_remark <=", value, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkLike(String value) {
            addCriterion("asa_remark like", value, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkNotLike(String value) {
            addCriterion("asa_remark not like", value, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkIn(List<String> values) {
            addCriterion("asa_remark in", values, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkNotIn(List<String> values) {
            addCriterion("asa_remark not in", values, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkBetween(String value1, String value2) {
            addCriterion("asa_remark between", value1, value2, "asaRemark");
            return (Criteria) this;
        }

        public Criteria andAsaRemarkNotBetween(String value1, String value2) {
            addCriterion("asa_remark not between", value1, value2, "asaRemark");
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

        public Criteria andFrontDoorSpeciallyMadeIsNull() {
            addCriterion("front_door_specially_made is null");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeIsNotNull() {
            addCriterion("front_door_specially_made is not null");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeEqualTo(String value) {
            addCriterion("front_door_specially_made =", value, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeNotEqualTo(String value) {
            addCriterion("front_door_specially_made <>", value, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeGreaterThan(String value) {
            addCriterion("front_door_specially_made >", value, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeGreaterThanOrEqualTo(String value) {
            addCriterion("front_door_specially_made >=", value, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeLessThan(String value) {
            addCriterion("front_door_specially_made <", value, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeLessThanOrEqualTo(String value) {
            addCriterion("front_door_specially_made <=", value, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeLike(String value) {
            addCriterion("front_door_specially_made like", value, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeNotLike(String value) {
            addCriterion("front_door_specially_made not like", value, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeIn(List<String> values) {
            addCriterion("front_door_specially_made in", values, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeNotIn(List<String> values) {
            addCriterion("front_door_specially_made not in", values, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeBetween(String value1, String value2) {
            addCriterion("front_door_specially_made between", value1, value2, "frontDoorSpeciallyMade");
            return (Criteria) this;
        }

        public Criteria andFrontDoorSpeciallyMadeNotBetween(String value1, String value2) {
            addCriterion("front_door_specially_made not between", value1, value2, "frontDoorSpeciallyMade");
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

        public Criteria andBcQuantityIsNull() {
            addCriterion("bc_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBcQuantityIsNotNull() {
            addCriterion("bc_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBcQuantityEqualTo(String value) {
            addCriterion("bc_quantity =", value, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityNotEqualTo(String value) {
            addCriterion("bc_quantity <>", value, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityGreaterThan(String value) {
            addCriterion("bc_quantity >", value, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("bc_quantity >=", value, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityLessThan(String value) {
            addCriterion("bc_quantity <", value, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityLessThanOrEqualTo(String value) {
            addCriterion("bc_quantity <=", value, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityLike(String value) {
            addCriterion("bc_quantity like", value, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityNotLike(String value) {
            addCriterion("bc_quantity not like", value, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityIn(List<String> values) {
            addCriterion("bc_quantity in", values, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityNotIn(List<String> values) {
            addCriterion("bc_quantity not in", values, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityBetween(String value1, String value2) {
            addCriterion("bc_quantity between", value1, value2, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcQuantityNotBetween(String value1, String value2) {
            addCriterion("bc_quantity not between", value1, value2, "bcQuantity");
            return (Criteria) this;
        }

        public Criteria andBcRemarkIsNull() {
            addCriterion("bc_remark is null");
            return (Criteria) this;
        }

        public Criteria andBcRemarkIsNotNull() {
            addCriterion("bc_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBcRemarkEqualTo(String value) {
            addCriterion("bc_remark =", value, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkNotEqualTo(String value) {
            addCriterion("bc_remark <>", value, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkGreaterThan(String value) {
            addCriterion("bc_remark >", value, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("bc_remark >=", value, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkLessThan(String value) {
            addCriterion("bc_remark <", value, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkLessThanOrEqualTo(String value) {
            addCriterion("bc_remark <=", value, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkLike(String value) {
            addCriterion("bc_remark like", value, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkNotLike(String value) {
            addCriterion("bc_remark not like", value, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkIn(List<String> values) {
            addCriterion("bc_remark in", values, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkNotIn(List<String> values) {
            addCriterion("bc_remark not in", values, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkBetween(String value1, String value2) {
            addCriterion("bc_remark between", value1, value2, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andBcRemarkNotBetween(String value1, String value2) {
            addCriterion("bc_remark not between", value1, value2, "bcRemark");
            return (Criteria) this;
        }

        public Criteria andCespQuantityIsNull() {
            addCriterion("cesp_quantity is null");
            return (Criteria) this;
        }

        public Criteria andCespQuantityIsNotNull() {
            addCriterion("cesp_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andCespQuantityEqualTo(String value) {
            addCriterion("cesp_quantity =", value, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityNotEqualTo(String value) {
            addCriterion("cesp_quantity <>", value, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityGreaterThan(String value) {
            addCriterion("cesp_quantity >", value, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("cesp_quantity >=", value, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityLessThan(String value) {
            addCriterion("cesp_quantity <", value, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityLessThanOrEqualTo(String value) {
            addCriterion("cesp_quantity <=", value, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityLike(String value) {
            addCriterion("cesp_quantity like", value, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityNotLike(String value) {
            addCriterion("cesp_quantity not like", value, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityIn(List<String> values) {
            addCriterion("cesp_quantity in", values, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityNotIn(List<String> values) {
            addCriterion("cesp_quantity not in", values, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityBetween(String value1, String value2) {
            addCriterion("cesp_quantity between", value1, value2, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespQuantityNotBetween(String value1, String value2) {
            addCriterion("cesp_quantity not between", value1, value2, "cespQuantity");
            return (Criteria) this;
        }

        public Criteria andCespRemarkIsNull() {
            addCriterion("cesp_remark is null");
            return (Criteria) this;
        }

        public Criteria andCespRemarkIsNotNull() {
            addCriterion("cesp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCespRemarkEqualTo(String value) {
            addCriterion("cesp_remark =", value, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkNotEqualTo(String value) {
            addCriterion("cesp_remark <>", value, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkGreaterThan(String value) {
            addCriterion("cesp_remark >", value, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("cesp_remark >=", value, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkLessThan(String value) {
            addCriterion("cesp_remark <", value, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkLessThanOrEqualTo(String value) {
            addCriterion("cesp_remark <=", value, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkLike(String value) {
            addCriterion("cesp_remark like", value, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkNotLike(String value) {
            addCriterion("cesp_remark not like", value, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkIn(List<String> values) {
            addCriterion("cesp_remark in", values, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkNotIn(List<String> values) {
            addCriterion("cesp_remark not in", values, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkBetween(String value1, String value2) {
            addCriterion("cesp_remark between", value1, value2, "cespRemark");
            return (Criteria) this;
        }

        public Criteria andCespRemarkNotBetween(String value1, String value2) {
            addCriterion("cesp_remark not between", value1, value2, "cespRemark");
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

        public Criteria andCopperQuantityIsNull() {
            addCriterion("copper_quantity is null");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityIsNotNull() {
            addCriterion("copper_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityEqualTo(String value) {
            addCriterion("copper_quantity =", value, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityNotEqualTo(String value) {
            addCriterion("copper_quantity <>", value, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityGreaterThan(String value) {
            addCriterion("copper_quantity >", value, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("copper_quantity >=", value, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityLessThan(String value) {
            addCriterion("copper_quantity <", value, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityLessThanOrEqualTo(String value) {
            addCriterion("copper_quantity <=", value, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityLike(String value) {
            addCriterion("copper_quantity like", value, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityNotLike(String value) {
            addCriterion("copper_quantity not like", value, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityIn(List<String> values) {
            addCriterion("copper_quantity in", values, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityNotIn(List<String> values) {
            addCriterion("copper_quantity not in", values, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityBetween(String value1, String value2) {
            addCriterion("copper_quantity between", value1, value2, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperQuantityNotBetween(String value1, String value2) {
            addCriterion("copper_quantity not between", value1, value2, "copperQuantity");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkIsNull() {
            addCriterion("copper_remark is null");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkIsNotNull() {
            addCriterion("copper_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkEqualTo(String value) {
            addCriterion("copper_remark =", value, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkNotEqualTo(String value) {
            addCriterion("copper_remark <>", value, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkGreaterThan(String value) {
            addCriterion("copper_remark >", value, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("copper_remark >=", value, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkLessThan(String value) {
            addCriterion("copper_remark <", value, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkLessThanOrEqualTo(String value) {
            addCriterion("copper_remark <=", value, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkLike(String value) {
            addCriterion("copper_remark like", value, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkNotLike(String value) {
            addCriterion("copper_remark not like", value, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkIn(List<String> values) {
            addCriterion("copper_remark in", values, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkNotIn(List<String> values) {
            addCriterion("copper_remark not in", values, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkBetween(String value1, String value2) {
            addCriterion("copper_remark between", value1, value2, "copperRemark");
            return (Criteria) this;
        }

        public Criteria andCopperRemarkNotBetween(String value1, String value2) {
            addCriterion("copper_remark not between", value1, value2, "copperRemark");
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