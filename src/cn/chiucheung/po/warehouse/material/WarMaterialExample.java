package cn.chiucheung.po.warehouse.material;

import java.util.ArrayList;
import java.util.List;

public class WarMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarMaterialExample() {
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

        public Criteria andMaterialCodeIsNull() {
            addCriterion("material_code is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNotNull() {
            addCriterion("material_code is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeEqualTo(String value) {
            addCriterion("material_code =", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotEqualTo(String value) {
            addCriterion("material_code <>", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThan(String value) {
            addCriterion("material_code >", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("material_code >=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThan(String value) {
            addCriterion("material_code <", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThanOrEqualTo(String value) {
            addCriterion("material_code <=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLike(String value) {
            addCriterion("material_code like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotLike(String value) {
            addCriterion("material_code not like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIn(List<String> values) {
            addCriterion("material_code in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotIn(List<String> values) {
            addCriterion("material_code not in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeBetween(String value1, String value2) {
            addCriterion("material_code between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotBetween(String value1, String value2) {
            addCriterion("material_code not between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNull() {
            addCriterion("material_type is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNotNull() {
            addCriterion("material_type is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeEqualTo(String value) {
            addCriterion("material_type =", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotEqualTo(String value) {
            addCriterion("material_type <>", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThan(String value) {
            addCriterion("material_type >", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_type >=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThan(String value) {
            addCriterion("material_type <", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThanOrEqualTo(String value) {
            addCriterion("material_type <=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLike(String value) {
            addCriterion("material_type like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotLike(String value) {
            addCriterion("material_type not like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIn(List<String> values) {
            addCriterion("material_type in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotIn(List<String> values) {
            addCriterion("material_type not in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeBetween(String value1, String value2) {
            addCriterion("material_type between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotBetween(String value1, String value2) {
            addCriterion("material_type not between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNull() {
            addCriterion("material_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNotNull() {
            addCriterion("material_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameEqualTo(String value) {
            addCriterion("material_name =", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotEqualTo(String value) {
            addCriterion("material_name <>", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThan(String value) {
            addCriterion("material_name >", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_name >=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThan(String value) {
            addCriterion("material_name <", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("material_name <=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLike(String value) {
            addCriterion("material_name like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotLike(String value) {
            addCriterion("material_name not like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIn(List<String> values) {
            addCriterion("material_name in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotIn(List<String> values) {
            addCriterion("material_name not in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameBetween(String value1, String value2) {
            addCriterion("material_name between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotBetween(String value1, String value2) {
            addCriterion("material_name not between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andApplicableProductIsNull() {
            addCriterion("applicable_product is null");
            return (Criteria) this;
        }

        public Criteria andApplicableProductIsNotNull() {
            addCriterion("applicable_product is not null");
            return (Criteria) this;
        }

        public Criteria andApplicableProductEqualTo(String value) {
            addCriterion("applicable_product =", value, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductNotEqualTo(String value) {
            addCriterion("applicable_product <>", value, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductGreaterThan(String value) {
            addCriterion("applicable_product >", value, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductGreaterThanOrEqualTo(String value) {
            addCriterion("applicable_product >=", value, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductLessThan(String value) {
            addCriterion("applicable_product <", value, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductLessThanOrEqualTo(String value) {
            addCriterion("applicable_product <=", value, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductLike(String value) {
            addCriterion("applicable_product like", value, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductNotLike(String value) {
            addCriterion("applicable_product not like", value, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductIn(List<String> values) {
            addCriterion("applicable_product in", values, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductNotIn(List<String> values) {
            addCriterion("applicable_product not in", values, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductBetween(String value1, String value2) {
            addCriterion("applicable_product between", value1, value2, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andApplicableProductNotBetween(String value1, String value2) {
            addCriterion("applicable_product not between", value1, value2, "applicableProduct");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNull() {
            addCriterion("classification is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNotNull() {
            addCriterion("classification is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationEqualTo(String value) {
            addCriterion("classification =", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotEqualTo(String value) {
            addCriterion("classification <>", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThan(String value) {
            addCriterion("classification >", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThanOrEqualTo(String value) {
            addCriterion("classification >=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThan(String value) {
            addCriterion("classification <", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThanOrEqualTo(String value) {
            addCriterion("classification <=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLike(String value) {
            addCriterion("classification like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotLike(String value) {
            addCriterion("classification not like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationIn(List<String> values) {
            addCriterion("classification in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotIn(List<String> values) {
            addCriterion("classification not in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationBetween(String value1, String value2) {
            addCriterion("classification between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotBetween(String value1, String value2) {
            addCriterion("classification not between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesIsNull() {
            addCriterion("material_properties is null");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesIsNotNull() {
            addCriterion("material_properties is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesEqualTo(String value) {
            addCriterion("material_properties =", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesNotEqualTo(String value) {
            addCriterion("material_properties <>", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesGreaterThan(String value) {
            addCriterion("material_properties >", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesGreaterThanOrEqualTo(String value) {
            addCriterion("material_properties >=", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesLessThan(String value) {
            addCriterion("material_properties <", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesLessThanOrEqualTo(String value) {
            addCriterion("material_properties <=", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesLike(String value) {
            addCriterion("material_properties like", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesNotLike(String value) {
            addCriterion("material_properties not like", value, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesIn(List<String> values) {
            addCriterion("material_properties in", values, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesNotIn(List<String> values) {
            addCriterion("material_properties not in", values, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesBetween(String value1, String value2) {
            addCriterion("material_properties between", value1, value2, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertiesNotBetween(String value1, String value2) {
            addCriterion("material_properties not between", value1, value2, "materialProperties");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(String value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(String value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(String value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(String value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLike(String value) {
            addCriterion("specifications like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotLike(String value) {
            addCriterion("specifications not like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<String> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<String> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(String value1, String value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(String value1, String value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("length is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("length is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(String value) {
            addCriterion("length =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(String value) {
            addCriterion("length <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(String value) {
            addCriterion("length >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(String value) {
            addCriterion("length >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(String value) {
            addCriterion("length <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(String value) {
            addCriterion("length <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLike(String value) {
            addCriterion("length like", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotLike(String value) {
            addCriterion("length not like", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<String> values) {
            addCriterion("length in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<String> values) {
            addCriterion("length not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(String value1, String value2) {
            addCriterion("length between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(String value1, String value2) {
            addCriterion("length not between", value1, value2, "length");
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

        public Criteria andPurchaseUnitIsNull() {
            addCriterion("purchase_unit is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIsNotNull() {
            addCriterion("purchase_unit is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitEqualTo(String value) {
            addCriterion("purchase_unit =", value, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNotEqualTo(String value) {
            addCriterion("purchase_unit <>", value, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitGreaterThan(String value) {
            addCriterion("purchase_unit >", value, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_unit >=", value, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitLessThan(String value) {
            addCriterion("purchase_unit <", value, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitLessThanOrEqualTo(String value) {
            addCriterion("purchase_unit <=", value, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitLike(String value) {
            addCriterion("purchase_unit like", value, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNotLike(String value) {
            addCriterion("purchase_unit not like", value, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitIn(List<String> values) {
            addCriterion("purchase_unit in", values, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNotIn(List<String> values) {
            addCriterion("purchase_unit not in", values, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitBetween(String value1, String value2) {
            addCriterion("purchase_unit between", value1, value2, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseUnitNotBetween(String value1, String value2) {
            addCriterion("purchase_unit not between", value1, value2, "purchaseUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyIsNull() {
            addCriterion("purchase_quantity_accuracy is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyIsNotNull() {
            addCriterion("purchase_quantity_accuracy is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyEqualTo(Integer value) {
            addCriterion("purchase_quantity_accuracy =", value, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyNotEqualTo(Integer value) {
            addCriterion("purchase_quantity_accuracy <>", value, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyGreaterThan(Integer value) {
            addCriterion("purchase_quantity_accuracy >", value, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_quantity_accuracy >=", value, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyLessThan(Integer value) {
            addCriterion("purchase_quantity_accuracy <", value, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_quantity_accuracy <=", value, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyIn(List<Integer> values) {
            addCriterion("purchase_quantity_accuracy in", values, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyNotIn(List<Integer> values) {
            addCriterion("purchase_quantity_accuracy not in", values, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyBetween(Integer value1, Integer value2) {
            addCriterion("purchase_quantity_accuracy between", value1, value2, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityAccuracyNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_quantity_accuracy not between", value1, value2, "purchaseQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseUnitIsNull() {
            addCriterion("use_unit is null");
            return (Criteria) this;
        }

        public Criteria andUseUnitIsNotNull() {
            addCriterion("use_unit is not null");
            return (Criteria) this;
        }

        public Criteria andUseUnitEqualTo(String value) {
            addCriterion("use_unit =", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitNotEqualTo(String value) {
            addCriterion("use_unit <>", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitGreaterThan(String value) {
            addCriterion("use_unit >", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitGreaterThanOrEqualTo(String value) {
            addCriterion("use_unit >=", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitLessThan(String value) {
            addCriterion("use_unit <", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitLessThanOrEqualTo(String value) {
            addCriterion("use_unit <=", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitLike(String value) {
            addCriterion("use_unit like", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitNotLike(String value) {
            addCriterion("use_unit not like", value, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitIn(List<String> values) {
            addCriterion("use_unit in", values, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitNotIn(List<String> values) {
            addCriterion("use_unit not in", values, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitBetween(String value1, String value2) {
            addCriterion("use_unit between", value1, value2, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseUnitNotBetween(String value1, String value2) {
            addCriterion("use_unit not between", value1, value2, "useUnit");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyIsNull() {
            addCriterion("use_quantity_accuracy is null");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyIsNotNull() {
            addCriterion("use_quantity_accuracy is not null");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyEqualTo(Integer value) {
            addCriterion("use_quantity_accuracy =", value, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyNotEqualTo(Integer value) {
            addCriterion("use_quantity_accuracy <>", value, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyGreaterThan(Integer value) {
            addCriterion("use_quantity_accuracy >", value, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_quantity_accuracy >=", value, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyLessThan(Integer value) {
            addCriterion("use_quantity_accuracy <", value, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyLessThanOrEqualTo(Integer value) {
            addCriterion("use_quantity_accuracy <=", value, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyIn(List<Integer> values) {
            addCriterion("use_quantity_accuracy in", values, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyNotIn(List<Integer> values) {
            addCriterion("use_quantity_accuracy not in", values, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyBetween(Integer value1, Integer value2) {
            addCriterion("use_quantity_accuracy between", value1, value2, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUseQuantityAccuracyNotBetween(Integer value1, Integer value2) {
            addCriterion("use_quantity_accuracy not between", value1, value2, "useQuantityAccuracy");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaIsNull() {
            addCriterion("unit_conversion_formula is null");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaIsNotNull() {
            addCriterion("unit_conversion_formula is not null");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaEqualTo(String value) {
            addCriterion("unit_conversion_formula =", value, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaNotEqualTo(String value) {
            addCriterion("unit_conversion_formula <>", value, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaGreaterThan(String value) {
            addCriterion("unit_conversion_formula >", value, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("unit_conversion_formula >=", value, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaLessThan(String value) {
            addCriterion("unit_conversion_formula <", value, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaLessThanOrEqualTo(String value) {
            addCriterion("unit_conversion_formula <=", value, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaLike(String value) {
            addCriterion("unit_conversion_formula like", value, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaNotLike(String value) {
            addCriterion("unit_conversion_formula not like", value, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaIn(List<String> values) {
            addCriterion("unit_conversion_formula in", values, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaNotIn(List<String> values) {
            addCriterion("unit_conversion_formula not in", values, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaBetween(String value1, String value2) {
            addCriterion("unit_conversion_formula between", value1, value2, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andUnitConversionFormulaNotBetween(String value1, String value2) {
            addCriterion("unit_conversion_formula not between", value1, value2, "unitConversionFormula");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(Integer value) {
            addCriterion("batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(Integer value) {
            addCriterion("batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(Integer value) {
            addCriterion("batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(Integer value) {
            addCriterion("batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(Integer value) {
            addCriterion("batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<Integer> values) {
            addCriterion("batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<Integer> values) {
            addCriterion("batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(Integer value1, Integer value2) {
            addCriterion("batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(Integer value1, Integer value2) {
            addCriterion("batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleIsNull() {
            addCriterion("procurement_cycle is null");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleIsNotNull() {
            addCriterion("procurement_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleEqualTo(Integer value) {
            addCriterion("procurement_cycle =", value, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleNotEqualTo(Integer value) {
            addCriterion("procurement_cycle <>", value, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleGreaterThan(Integer value) {
            addCriterion("procurement_cycle >", value, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("procurement_cycle >=", value, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleLessThan(Integer value) {
            addCriterion("procurement_cycle <", value, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleLessThanOrEqualTo(Integer value) {
            addCriterion("procurement_cycle <=", value, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleIn(List<Integer> values) {
            addCriterion("procurement_cycle in", values, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleNotIn(List<Integer> values) {
            addCriterion("procurement_cycle not in", values, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleBetween(Integer value1, Integer value2) {
            addCriterion("procurement_cycle between", value1, value2, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andProcurementCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("procurement_cycle not between", value1, value2, "procurementCycle");
            return (Criteria) this;
        }

        public Criteria andDivisionIsNull() {
            addCriterion("division is null");
            return (Criteria) this;
        }

        public Criteria andDivisionIsNotNull() {
            addCriterion("division is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionEqualTo(Integer value) {
            addCriterion("division =", value, "division");
            return (Criteria) this;
        }

        public Criteria andDivisionNotEqualTo(Integer value) {
            addCriterion("division <>", value, "division");
            return (Criteria) this;
        }

        public Criteria andDivisionGreaterThan(Integer value) {
            addCriterion("division >", value, "division");
            return (Criteria) this;
        }

        public Criteria andDivisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("division >=", value, "division");
            return (Criteria) this;
        }

        public Criteria andDivisionLessThan(Integer value) {
            addCriterion("division <", value, "division");
            return (Criteria) this;
        }

        public Criteria andDivisionLessThanOrEqualTo(Integer value) {
            addCriterion("division <=", value, "division");
            return (Criteria) this;
        }

        public Criteria andDivisionIn(List<Integer> values) {
            addCriterion("division in", values, "division");
            return (Criteria) this;
        }

        public Criteria andDivisionNotIn(List<Integer> values) {
            addCriterion("division not in", values, "division");
            return (Criteria) this;
        }

        public Criteria andDivisionBetween(Integer value1, Integer value2) {
            addCriterion("division between", value1, value2, "division");
            return (Criteria) this;
        }

        public Criteria andDivisionNotBetween(Integer value1, Integer value2) {
            addCriterion("division not between", value1, value2, "division");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopIsNull() {
            addCriterion("production_workshop is null");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopIsNotNull() {
            addCriterion("production_workshop is not null");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopEqualTo(String value) {
            addCriterion("production_workshop =", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopNotEqualTo(String value) {
            addCriterion("production_workshop <>", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopGreaterThan(String value) {
            addCriterion("production_workshop >", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopGreaterThanOrEqualTo(String value) {
            addCriterion("production_workshop >=", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopLessThan(String value) {
            addCriterion("production_workshop <", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopLessThanOrEqualTo(String value) {
            addCriterion("production_workshop <=", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopLike(String value) {
            addCriterion("production_workshop like", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopNotLike(String value) {
            addCriterion("production_workshop not like", value, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopIn(List<String> values) {
            addCriterion("production_workshop in", values, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopNotIn(List<String> values) {
            addCriterion("production_workshop not in", values, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopBetween(String value1, String value2) {
            addCriterion("production_workshop between", value1, value2, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andProductionWorkshopNotBetween(String value1, String value2) {
            addCriterion("production_workshop not between", value1, value2, "productionWorkshop");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityIsNull() {
            addCriterion("lowest_warehousing_quantity is null");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityIsNotNull() {
            addCriterion("lowest_warehousing_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityEqualTo(Integer value) {
            addCriterion("lowest_warehousing_quantity =", value, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityNotEqualTo(Integer value) {
            addCriterion("lowest_warehousing_quantity <>", value, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityGreaterThan(Integer value) {
            addCriterion("lowest_warehousing_quantity >", value, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("lowest_warehousing_quantity >=", value, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityLessThan(Integer value) {
            addCriterion("lowest_warehousing_quantity <", value, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("lowest_warehousing_quantity <=", value, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityIn(List<Integer> values) {
            addCriterion("lowest_warehousing_quantity in", values, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityNotIn(List<Integer> values) {
            addCriterion("lowest_warehousing_quantity not in", values, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("lowest_warehousing_quantity between", value1, value2, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andLowestWarehousingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("lowest_warehousing_quantity not between", value1, value2, "lowestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityIsNull() {
            addCriterion("highest_warehousing_quantity is null");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityIsNotNull() {
            addCriterion("highest_warehousing_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityEqualTo(Integer value) {
            addCriterion("highest_warehousing_quantity =", value, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityNotEqualTo(Integer value) {
            addCriterion("highest_warehousing_quantity <>", value, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityGreaterThan(Integer value) {
            addCriterion("highest_warehousing_quantity >", value, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("highest_warehousing_quantity >=", value, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityLessThan(Integer value) {
            addCriterion("highest_warehousing_quantity <", value, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("highest_warehousing_quantity <=", value, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityIn(List<Integer> values) {
            addCriterion("highest_warehousing_quantity in", values, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityNotIn(List<Integer> values) {
            addCriterion("highest_warehousing_quantity not in", values, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("highest_warehousing_quantity between", value1, value2, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andHighestWarehousingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("highest_warehousing_quantity not between", value1, value2, "highestWarehousingQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityIsNull() {
            addCriterion("once_produce_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityIsNotNull() {
            addCriterion("once_produce_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityEqualTo(Integer value) {
            addCriterion("once_produce_quantity =", value, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityNotEqualTo(Integer value) {
            addCriterion("once_produce_quantity <>", value, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityGreaterThan(Integer value) {
            addCriterion("once_produce_quantity >", value, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("once_produce_quantity >=", value, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityLessThan(Integer value) {
            addCriterion("once_produce_quantity <", value, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("once_produce_quantity <=", value, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityIn(List<Integer> values) {
            addCriterion("once_produce_quantity in", values, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityNotIn(List<Integer> values) {
            addCriterion("once_produce_quantity not in", values, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityBetween(Integer value1, Integer value2) {
            addCriterion("once_produce_quantity between", value1, value2, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andOnceProduceQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("once_produce_quantity not between", value1, value2, "onceProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityIsNull() {
            addCriterion("min_produce_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityIsNotNull() {
            addCriterion("min_produce_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityEqualTo(Integer value) {
            addCriterion("min_produce_quantity =", value, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityNotEqualTo(Integer value) {
            addCriterion("min_produce_quantity <>", value, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityGreaterThan(Integer value) {
            addCriterion("min_produce_quantity >", value, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_produce_quantity >=", value, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityLessThan(Integer value) {
            addCriterion("min_produce_quantity <", value, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("min_produce_quantity <=", value, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityIn(List<Integer> values) {
            addCriterion("min_produce_quantity in", values, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityNotIn(List<Integer> values) {
            addCriterion("min_produce_quantity not in", values, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityBetween(Integer value1, Integer value2) {
            addCriterion("min_produce_quantity between", value1, value2, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andMinProduceQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("min_produce_quantity not between", value1, value2, "minProduceQuantity");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberIsNull() {
            addCriterion("drawing_number is null");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberIsNotNull() {
            addCriterion("drawing_number is not null");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberEqualTo(String value) {
            addCriterion("drawing_number =", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberNotEqualTo(String value) {
            addCriterion("drawing_number <>", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberGreaterThan(String value) {
            addCriterion("drawing_number >", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberGreaterThanOrEqualTo(String value) {
            addCriterion("drawing_number >=", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberLessThan(String value) {
            addCriterion("drawing_number <", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberLessThanOrEqualTo(String value) {
            addCriterion("drawing_number <=", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberLike(String value) {
            addCriterion("drawing_number like", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberNotLike(String value) {
            addCriterion("drawing_number not like", value, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberIn(List<String> values) {
            addCriterion("drawing_number in", values, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberNotIn(List<String> values) {
            addCriterion("drawing_number not in", values, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberBetween(String value1, String value2) {
            addCriterion("drawing_number between", value1, value2, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andDrawingNumberNotBetween(String value1, String value2) {
            addCriterion("drawing_number not between", value1, value2, "drawingNumber");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardIsNull() {
            addCriterion("inspection_standard is null");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardIsNotNull() {
            addCriterion("inspection_standard is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardEqualTo(String value) {
            addCriterion("inspection_standard =", value, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardNotEqualTo(String value) {
            addCriterion("inspection_standard <>", value, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardGreaterThan(String value) {
            addCriterion("inspection_standard >", value, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_standard >=", value, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardLessThan(String value) {
            addCriterion("inspection_standard <", value, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardLessThanOrEqualTo(String value) {
            addCriterion("inspection_standard <=", value, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardLike(String value) {
            addCriterion("inspection_standard like", value, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardNotLike(String value) {
            addCriterion("inspection_standard not like", value, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardIn(List<String> values) {
            addCriterion("inspection_standard in", values, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardNotIn(List<String> values) {
            addCriterion("inspection_standard not in", values, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardBetween(String value1, String value2) {
            addCriterion("inspection_standard between", value1, value2, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionStandardNotBetween(String value1, String value2) {
            addCriterion("inspection_standard not between", value1, value2, "inspectionStandard");
            return (Criteria) this;
        }

        public Criteria andInspectionWayIsNull() {
            addCriterion("inspection_way is null");
            return (Criteria) this;
        }

        public Criteria andInspectionWayIsNotNull() {
            addCriterion("inspection_way is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionWayEqualTo(String value) {
            addCriterion("inspection_way =", value, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayNotEqualTo(String value) {
            addCriterion("inspection_way <>", value, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayGreaterThan(String value) {
            addCriterion("inspection_way >", value, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_way >=", value, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayLessThan(String value) {
            addCriterion("inspection_way <", value, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayLessThanOrEqualTo(String value) {
            addCriterion("inspection_way <=", value, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayLike(String value) {
            addCriterion("inspection_way like", value, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayNotLike(String value) {
            addCriterion("inspection_way not like", value, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayIn(List<String> values) {
            addCriterion("inspection_way in", values, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayNotIn(List<String> values) {
            addCriterion("inspection_way not in", values, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayBetween(String value1, String value2) {
            addCriterion("inspection_way between", value1, value2, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andInspectionWayNotBetween(String value1, String value2) {
            addCriterion("inspection_way not between", value1, value2, "inspectionWay");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNull() {
            addCriterion("warehouse is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNotNull() {
            addCriterion("warehouse is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseEqualTo(String value) {
            addCriterion("warehouse =", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotEqualTo(String value) {
            addCriterion("warehouse <>", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThan(String value) {
            addCriterion("warehouse >", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse >=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThan(String value) {
            addCriterion("warehouse <", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThanOrEqualTo(String value) {
            addCriterion("warehouse <=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLike(String value) {
            addCriterion("warehouse like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotLike(String value) {
            addCriterion("warehouse not like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseIn(List<String> values) {
            addCriterion("warehouse in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotIn(List<String> values) {
            addCriterion("warehouse not in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseBetween(String value1, String value2) {
            addCriterion("warehouse between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotBetween(String value1, String value2) {
            addCriterion("warehouse not between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsIsNull() {
            addCriterion("warehouse_positions is null");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsIsNotNull() {
            addCriterion("warehouse_positions is not null");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsEqualTo(String value) {
            addCriterion("warehouse_positions =", value, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsNotEqualTo(String value) {
            addCriterion("warehouse_positions <>", value, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsGreaterThan(String value) {
            addCriterion("warehouse_positions >", value, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_positions >=", value, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsLessThan(String value) {
            addCriterion("warehouse_positions <", value, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsLessThanOrEqualTo(String value) {
            addCriterion("warehouse_positions <=", value, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsLike(String value) {
            addCriterion("warehouse_positions like", value, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsNotLike(String value) {
            addCriterion("warehouse_positions not like", value, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsIn(List<String> values) {
            addCriterion("warehouse_positions in", values, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsNotIn(List<String> values) {
            addCriterion("warehouse_positions not in", values, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsBetween(String value1, String value2) {
            addCriterion("warehouse_positions between", value1, value2, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andWarehousePositionsNotBetween(String value1, String value2) {
            addCriterion("warehouse_positions not between", value1, value2, "warehousePositions");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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