package cn.chiucheung.po.sales.workcard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalWorkCardKztExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalWorkCardKztExample() {
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

        public Criteria andBedplateMaterialIsNull() {
            addCriterion("bedplate_material is null");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialIsNotNull() {
            addCriterion("bedplate_material is not null");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialEqualTo(String value) {
            addCriterion("bedplate_material =", value, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialNotEqualTo(String value) {
            addCriterion("bedplate_material <>", value, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialGreaterThan(String value) {
            addCriterion("bedplate_material >", value, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("bedplate_material >=", value, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialLessThan(String value) {
            addCriterion("bedplate_material <", value, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialLessThanOrEqualTo(String value) {
            addCriterion("bedplate_material <=", value, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialLike(String value) {
            addCriterion("bedplate_material like", value, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialNotLike(String value) {
            addCriterion("bedplate_material not like", value, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialIn(List<String> values) {
            addCriterion("bedplate_material in", values, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialNotIn(List<String> values) {
            addCriterion("bedplate_material not in", values, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialBetween(String value1, String value2) {
            addCriterion("bedplate_material between", value1, value2, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialNotBetween(String value1, String value2) {
            addCriterion("bedplate_material not between", value1, value2, "bedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorIsNull() {
            addCriterion("bedplate_material_color is null");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorIsNotNull() {
            addCriterion("bedplate_material_color is not null");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorEqualTo(String value) {
            addCriterion("bedplate_material_color =", value, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorNotEqualTo(String value) {
            addCriterion("bedplate_material_color <>", value, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorGreaterThan(String value) {
            addCriterion("bedplate_material_color >", value, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorGreaterThanOrEqualTo(String value) {
            addCriterion("bedplate_material_color >=", value, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorLessThan(String value) {
            addCriterion("bedplate_material_color <", value, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorLessThanOrEqualTo(String value) {
            addCriterion("bedplate_material_color <=", value, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorLike(String value) {
            addCriterion("bedplate_material_color like", value, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorNotLike(String value) {
            addCriterion("bedplate_material_color not like", value, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorIn(List<String> values) {
            addCriterion("bedplate_material_color in", values, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorNotIn(List<String> values) {
            addCriterion("bedplate_material_color not in", values, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorBetween(String value1, String value2) {
            addCriterion("bedplate_material_color between", value1, value2, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andBedplateMaterialColorNotBetween(String value1, String value2) {
            addCriterion("bedplate_material_color not between", value1, value2, "bedplateMaterialColor");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialIsNull() {
            addCriterion("other_bedplate_material is null");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialIsNotNull() {
            addCriterion("other_bedplate_material is not null");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialEqualTo(String value) {
            addCriterion("other_bedplate_material =", value, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialNotEqualTo(String value) {
            addCriterion("other_bedplate_material <>", value, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialGreaterThan(String value) {
            addCriterion("other_bedplate_material >", value, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("other_bedplate_material >=", value, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialLessThan(String value) {
            addCriterion("other_bedplate_material <", value, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialLessThanOrEqualTo(String value) {
            addCriterion("other_bedplate_material <=", value, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialLike(String value) {
            addCriterion("other_bedplate_material like", value, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialNotLike(String value) {
            addCriterion("other_bedplate_material not like", value, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialIn(List<String> values) {
            addCriterion("other_bedplate_material in", values, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialNotIn(List<String> values) {
            addCriterion("other_bedplate_material not in", values, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialBetween(String value1, String value2) {
            addCriterion("other_bedplate_material between", value1, value2, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andOtherBedplateMaterialNotBetween(String value1, String value2) {
            addCriterion("other_bedplate_material not between", value1, value2, "otherBedplateMaterial");
            return (Criteria) this;
        }

        public Criteria andBedplateColorIsNull() {
            addCriterion("bedplate_color is null");
            return (Criteria) this;
        }

        public Criteria andBedplateColorIsNotNull() {
            addCriterion("bedplate_color is not null");
            return (Criteria) this;
        }

        public Criteria andBedplateColorEqualTo(String value) {
            addCriterion("bedplate_color =", value, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorNotEqualTo(String value) {
            addCriterion("bedplate_color <>", value, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorGreaterThan(String value) {
            addCriterion("bedplate_color >", value, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorGreaterThanOrEqualTo(String value) {
            addCriterion("bedplate_color >=", value, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorLessThan(String value) {
            addCriterion("bedplate_color <", value, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorLessThanOrEqualTo(String value) {
            addCriterion("bedplate_color <=", value, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorLike(String value) {
            addCriterion("bedplate_color like", value, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorNotLike(String value) {
            addCriterion("bedplate_color not like", value, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorIn(List<String> values) {
            addCriterion("bedplate_color in", values, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorNotIn(List<String> values) {
            addCriterion("bedplate_color not in", values, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorBetween(String value1, String value2) {
            addCriterion("bedplate_color between", value1, value2, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andBedplateColorNotBetween(String value1, String value2) {
            addCriterion("bedplate_color not between", value1, value2, "bedplateColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorIsNull() {
            addCriterion("internal_parts_color is null");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorIsNotNull() {
            addCriterion("internal_parts_color is not null");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorEqualTo(String value) {
            addCriterion("internal_parts_color =", value, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorNotEqualTo(String value) {
            addCriterion("internal_parts_color <>", value, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorGreaterThan(String value) {
            addCriterion("internal_parts_color >", value, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorGreaterThanOrEqualTo(String value) {
            addCriterion("internal_parts_color >=", value, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorLessThan(String value) {
            addCriterion("internal_parts_color <", value, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorLessThanOrEqualTo(String value) {
            addCriterion("internal_parts_color <=", value, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorLike(String value) {
            addCriterion("internal_parts_color like", value, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorNotLike(String value) {
            addCriterion("internal_parts_color not like", value, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorIn(List<String> values) {
            addCriterion("internal_parts_color in", values, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorNotIn(List<String> values) {
            addCriterion("internal_parts_color not in", values, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorBetween(String value1, String value2) {
            addCriterion("internal_parts_color between", value1, value2, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorNotBetween(String value1, String value2) {
            addCriterion("internal_parts_color not between", value1, value2, "internalPartsColor");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentIsNull() {
            addCriterion("internal_parts_color_content is null");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentIsNotNull() {
            addCriterion("internal_parts_color_content is not null");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentEqualTo(String value) {
            addCriterion("internal_parts_color_content =", value, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentNotEqualTo(String value) {
            addCriterion("internal_parts_color_content <>", value, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentGreaterThan(String value) {
            addCriterion("internal_parts_color_content >", value, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentGreaterThanOrEqualTo(String value) {
            addCriterion("internal_parts_color_content >=", value, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentLessThan(String value) {
            addCriterion("internal_parts_color_content <", value, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentLessThanOrEqualTo(String value) {
            addCriterion("internal_parts_color_content <=", value, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentLike(String value) {
            addCriterion("internal_parts_color_content like", value, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentNotLike(String value) {
            addCriterion("internal_parts_color_content not like", value, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentIn(List<String> values) {
            addCriterion("internal_parts_color_content in", values, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentNotIn(List<String> values) {
            addCriterion("internal_parts_color_content not in", values, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentBetween(String value1, String value2) {
            addCriterion("internal_parts_color_content between", value1, value2, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andInternalPartsColorContentNotBetween(String value1, String value2) {
            addCriterion("internal_parts_color_content not between", value1, value2, "internalPartsColorContent");
            return (Criteria) this;
        }

        public Criteria andKeybordIronIsNull() {
            addCriterion("keybord_iron is null");
            return (Criteria) this;
        }

        public Criteria andKeybordIronIsNotNull() {
            addCriterion("keybord_iron is not null");
            return (Criteria) this;
        }

        public Criteria andKeybordIronEqualTo(String value) {
            addCriterion("keybord_iron =", value, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronNotEqualTo(String value) {
            addCriterion("keybord_iron <>", value, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronGreaterThan(String value) {
            addCriterion("keybord_iron >", value, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronGreaterThanOrEqualTo(String value) {
            addCriterion("keybord_iron >=", value, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronLessThan(String value) {
            addCriterion("keybord_iron <", value, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronLessThanOrEqualTo(String value) {
            addCriterion("keybord_iron <=", value, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronLike(String value) {
            addCriterion("keybord_iron like", value, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronNotLike(String value) {
            addCriterion("keybord_iron not like", value, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronIn(List<String> values) {
            addCriterion("keybord_iron in", values, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronNotIn(List<String> values) {
            addCriterion("keybord_iron not in", values, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronBetween(String value1, String value2) {
            addCriterion("keybord_iron between", value1, value2, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordIronNotBetween(String value1, String value2) {
            addCriterion("keybord_iron not between", value1, value2, "keybordIron");
            return (Criteria) this;
        }

        public Criteria andKeybordZsIsNull() {
            addCriterion("keybord_zs is null");
            return (Criteria) this;
        }

        public Criteria andKeybordZsIsNotNull() {
            addCriterion("keybord_zs is not null");
            return (Criteria) this;
        }

        public Criteria andKeybordZsEqualTo(String value) {
            addCriterion("keybord_zs =", value, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsNotEqualTo(String value) {
            addCriterion("keybord_zs <>", value, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsGreaterThan(String value) {
            addCriterion("keybord_zs >", value, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsGreaterThanOrEqualTo(String value) {
            addCriterion("keybord_zs >=", value, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsLessThan(String value) {
            addCriterion("keybord_zs <", value, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsLessThanOrEqualTo(String value) {
            addCriterion("keybord_zs <=", value, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsLike(String value) {
            addCriterion("keybord_zs like", value, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsNotLike(String value) {
            addCriterion("keybord_zs not like", value, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsIn(List<String> values) {
            addCriterion("keybord_zs in", values, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsNotIn(List<String> values) {
            addCriterion("keybord_zs not in", values, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsBetween(String value1, String value2) {
            addCriterion("keybord_zs between", value1, value2, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andKeybordZsNotBetween(String value1, String value2) {
            addCriterion("keybord_zs not between", value1, value2, "keybordZs");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardIsNull() {
            addCriterion("bottom_ark_bottom_board is null");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardIsNotNull() {
            addCriterion("bottom_ark_bottom_board is not null");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardEqualTo(String value) {
            addCriterion("bottom_ark_bottom_board =", value, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardNotEqualTo(String value) {
            addCriterion("bottom_ark_bottom_board <>", value, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardGreaterThan(String value) {
            addCriterion("bottom_ark_bottom_board >", value, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardGreaterThanOrEqualTo(String value) {
            addCriterion("bottom_ark_bottom_board >=", value, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardLessThan(String value) {
            addCriterion("bottom_ark_bottom_board <", value, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardLessThanOrEqualTo(String value) {
            addCriterion("bottom_ark_bottom_board <=", value, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardLike(String value) {
            addCriterion("bottom_ark_bottom_board like", value, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardNotLike(String value) {
            addCriterion("bottom_ark_bottom_board not like", value, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardIn(List<String> values) {
            addCriterion("bottom_ark_bottom_board in", values, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardNotIn(List<String> values) {
            addCriterion("bottom_ark_bottom_board not in", values, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardBetween(String value1, String value2) {
            addCriterion("bottom_ark_bottom_board between", value1, value2, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkBottomBoardNotBetween(String value1, String value2) {
            addCriterion("bottom_ark_bottom_board not between", value1, value2, "bottomArkBottomBoard");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkIsNull() {
            addCriterion("babb_remark is null");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkIsNotNull() {
            addCriterion("babb_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkEqualTo(String value) {
            addCriterion("babb_remark =", value, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkNotEqualTo(String value) {
            addCriterion("babb_remark <>", value, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkGreaterThan(String value) {
            addCriterion("babb_remark >", value, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("babb_remark >=", value, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkLessThan(String value) {
            addCriterion("babb_remark <", value, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkLessThanOrEqualTo(String value) {
            addCriterion("babb_remark <=", value, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkLike(String value) {
            addCriterion("babb_remark like", value, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkNotLike(String value) {
            addCriterion("babb_remark not like", value, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkIn(List<String> values) {
            addCriterion("babb_remark in", values, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkNotIn(List<String> values) {
            addCriterion("babb_remark not in", values, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkBetween(String value1, String value2) {
            addCriterion("babb_remark between", value1, value2, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBabbRemarkNotBetween(String value1, String value2) {
            addCriterion("babb_remark not between", value1, value2, "babbRemark");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardIsNull() {
            addCriterion("bottom_ark_layer_board is null");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardIsNotNull() {
            addCriterion("bottom_ark_layer_board is not null");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardEqualTo(String value) {
            addCriterion("bottom_ark_layer_board =", value, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardNotEqualTo(String value) {
            addCriterion("bottom_ark_layer_board <>", value, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardGreaterThan(String value) {
            addCriterion("bottom_ark_layer_board >", value, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardGreaterThanOrEqualTo(String value) {
            addCriterion("bottom_ark_layer_board >=", value, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardLessThan(String value) {
            addCriterion("bottom_ark_layer_board <", value, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardLessThanOrEqualTo(String value) {
            addCriterion("bottom_ark_layer_board <=", value, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardLike(String value) {
            addCriterion("bottom_ark_layer_board like", value, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardNotLike(String value) {
            addCriterion("bottom_ark_layer_board not like", value, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardIn(List<String> values) {
            addCriterion("bottom_ark_layer_board in", values, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardNotIn(List<String> values) {
            addCriterion("bottom_ark_layer_board not in", values, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardBetween(String value1, String value2) {
            addCriterion("bottom_ark_layer_board between", value1, value2, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBottomArkLayerBoardNotBetween(String value1, String value2) {
            addCriterion("bottom_ark_layer_board not between", value1, value2, "bottomArkLayerBoard");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityIsNull() {
            addCriterion("balb_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityIsNotNull() {
            addCriterion("balb_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityEqualTo(String value) {
            addCriterion("balb_quantity =", value, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityNotEqualTo(String value) {
            addCriterion("balb_quantity <>", value, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityGreaterThan(String value) {
            addCriterion("balb_quantity >", value, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("balb_quantity >=", value, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityLessThan(String value) {
            addCriterion("balb_quantity <", value, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityLessThanOrEqualTo(String value) {
            addCriterion("balb_quantity <=", value, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityLike(String value) {
            addCriterion("balb_quantity like", value, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityNotLike(String value) {
            addCriterion("balb_quantity not like", value, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityIn(List<String> values) {
            addCriterion("balb_quantity in", values, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityNotIn(List<String> values) {
            addCriterion("balb_quantity not in", values, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityBetween(String value1, String value2) {
            addCriterion("balb_quantity between", value1, value2, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbQuantityNotBetween(String value1, String value2) {
            addCriterion("balb_quantity not between", value1, value2, "balbQuantity");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkIsNull() {
            addCriterion("balb_remark is null");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkIsNotNull() {
            addCriterion("balb_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkEqualTo(String value) {
            addCriterion("balb_remark =", value, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkNotEqualTo(String value) {
            addCriterion("balb_remark <>", value, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkGreaterThan(String value) {
            addCriterion("balb_remark >", value, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("balb_remark >=", value, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkLessThan(String value) {
            addCriterion("balb_remark <", value, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkLessThanOrEqualTo(String value) {
            addCriterion("balb_remark <=", value, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkLike(String value) {
            addCriterion("balb_remark like", value, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkNotLike(String value) {
            addCriterion("balb_remark not like", value, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkIn(List<String> values) {
            addCriterion("balb_remark in", values, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkNotIn(List<String> values) {
            addCriterion("balb_remark not in", values, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkBetween(String value1, String value2) {
            addCriterion("balb_remark between", value1, value2, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andBalbRemarkNotBetween(String value1, String value2) {
            addCriterion("balb_remark not between", value1, value2, "balbRemark");
            return (Criteria) this;
        }

        public Criteria andAbQuantityIsNull() {
            addCriterion("ab_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAbQuantityIsNotNull() {
            addCriterion("ab_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAbQuantityEqualTo(String value) {
            addCriterion("ab_quantity =", value, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityNotEqualTo(String value) {
            addCriterion("ab_quantity <>", value, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityGreaterThan(String value) {
            addCriterion("ab_quantity >", value, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("ab_quantity >=", value, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityLessThan(String value) {
            addCriterion("ab_quantity <", value, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityLessThanOrEqualTo(String value) {
            addCriterion("ab_quantity <=", value, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityLike(String value) {
            addCriterion("ab_quantity like", value, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityNotLike(String value) {
            addCriterion("ab_quantity not like", value, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityIn(List<String> values) {
            addCriterion("ab_quantity in", values, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityNotIn(List<String> values) {
            addCriterion("ab_quantity not in", values, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityBetween(String value1, String value2) {
            addCriterion("ab_quantity between", value1, value2, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbQuantityNotBetween(String value1, String value2) {
            addCriterion("ab_quantity not between", value1, value2, "abQuantity");
            return (Criteria) this;
        }

        public Criteria andAbRemarkIsNull() {
            addCriterion("ab_remark is null");
            return (Criteria) this;
        }

        public Criteria andAbRemarkIsNotNull() {
            addCriterion("ab_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAbRemarkEqualTo(String value) {
            addCriterion("ab_remark =", value, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkNotEqualTo(String value) {
            addCriterion("ab_remark <>", value, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkGreaterThan(String value) {
            addCriterion("ab_remark >", value, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ab_remark >=", value, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkLessThan(String value) {
            addCriterion("ab_remark <", value, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkLessThanOrEqualTo(String value) {
            addCriterion("ab_remark <=", value, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkLike(String value) {
            addCriterion("ab_remark like", value, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkNotLike(String value) {
            addCriterion("ab_remark not like", value, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkIn(List<String> values) {
            addCriterion("ab_remark in", values, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkNotIn(List<String> values) {
            addCriterion("ab_remark not in", values, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkBetween(String value1, String value2) {
            addCriterion("ab_remark between", value1, value2, "abRemark");
            return (Criteria) this;
        }

        public Criteria andAbRemarkNotBetween(String value1, String value2) {
            addCriterion("ab_remark not between", value1, value2, "abRemark");
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

        public Criteria andLcdStentsIsNull() {
            addCriterion("lcd_stents is null");
            return (Criteria) this;
        }

        public Criteria andLcdStentsIsNotNull() {
            addCriterion("lcd_stents is not null");
            return (Criteria) this;
        }

        public Criteria andLcdStentsEqualTo(String value) {
            addCriterion("lcd_stents =", value, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsNotEqualTo(String value) {
            addCriterion("lcd_stents <>", value, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsGreaterThan(String value) {
            addCriterion("lcd_stents >", value, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsGreaterThanOrEqualTo(String value) {
            addCriterion("lcd_stents >=", value, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsLessThan(String value) {
            addCriterion("lcd_stents <", value, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsLessThanOrEqualTo(String value) {
            addCriterion("lcd_stents <=", value, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsLike(String value) {
            addCriterion("lcd_stents like", value, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsNotLike(String value) {
            addCriterion("lcd_stents not like", value, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsIn(List<String> values) {
            addCriterion("lcd_stents in", values, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsNotIn(List<String> values) {
            addCriterion("lcd_stents not in", values, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsBetween(String value1, String value2) {
            addCriterion("lcd_stents between", value1, value2, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsNotBetween(String value1, String value2) {
            addCriterion("lcd_stents not between", value1, value2, "lcdStents");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorIsNull() {
            addCriterion("lcd_stents_color is null");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorIsNotNull() {
            addCriterion("lcd_stents_color is not null");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorEqualTo(String value) {
            addCriterion("lcd_stents_color =", value, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorNotEqualTo(String value) {
            addCriterion("lcd_stents_color <>", value, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorGreaterThan(String value) {
            addCriterion("lcd_stents_color >", value, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorGreaterThanOrEqualTo(String value) {
            addCriterion("lcd_stents_color >=", value, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorLessThan(String value) {
            addCriterion("lcd_stents_color <", value, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorLessThanOrEqualTo(String value) {
            addCriterion("lcd_stents_color <=", value, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorLike(String value) {
            addCriterion("lcd_stents_color like", value, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorNotLike(String value) {
            addCriterion("lcd_stents_color not like", value, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorIn(List<String> values) {
            addCriterion("lcd_stents_color in", values, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorNotIn(List<String> values) {
            addCriterion("lcd_stents_color not in", values, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorBetween(String value1, String value2) {
            addCriterion("lcd_stents_color between", value1, value2, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLcdStentsColorNotBetween(String value1, String value2) {
            addCriterion("lcd_stents_color not between", value1, value2, "lcdStentsColor");
            return (Criteria) this;
        }

        public Criteria andLsQuantityIsNull() {
            addCriterion("ls_quantity is null");
            return (Criteria) this;
        }

        public Criteria andLsQuantityIsNotNull() {
            addCriterion("ls_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andLsQuantityEqualTo(String value) {
            addCriterion("ls_quantity =", value, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityNotEqualTo(String value) {
            addCriterion("ls_quantity <>", value, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityGreaterThan(String value) {
            addCriterion("ls_quantity >", value, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("ls_quantity >=", value, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityLessThan(String value) {
            addCriterion("ls_quantity <", value, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityLessThanOrEqualTo(String value) {
            addCriterion("ls_quantity <=", value, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityLike(String value) {
            addCriterion("ls_quantity like", value, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityNotLike(String value) {
            addCriterion("ls_quantity not like", value, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityIn(List<String> values) {
            addCriterion("ls_quantity in", values, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityNotIn(List<String> values) {
            addCriterion("ls_quantity not in", values, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityBetween(String value1, String value2) {
            addCriterion("ls_quantity between", value1, value2, "lsQuantity");
            return (Criteria) this;
        }

        public Criteria andLsQuantityNotBetween(String value1, String value2) {
            addCriterion("ls_quantity not between", value1, value2, "lsQuantity");
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