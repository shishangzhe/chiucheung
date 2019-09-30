package cn.chiucheung.po.warehouse.standardaccessories;

import java.util.ArrayList;
import java.util.List;

public class WarStandardAccessoriesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarStandardAccessoriesExample() {
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

        public Criteria andAccessoriesCodeIsNull() {
            addCriterion("accessories_code is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeIsNotNull() {
            addCriterion("accessories_code is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeEqualTo(String value) {
            addCriterion("accessories_code =", value, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeNotEqualTo(String value) {
            addCriterion("accessories_code <>", value, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeGreaterThan(String value) {
            addCriterion("accessories_code >", value, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeGreaterThanOrEqualTo(String value) {
            addCriterion("accessories_code >=", value, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeLessThan(String value) {
            addCriterion("accessories_code <", value, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeLessThanOrEqualTo(String value) {
            addCriterion("accessories_code <=", value, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeLike(String value) {
            addCriterion("accessories_code like", value, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeNotLike(String value) {
            addCriterion("accessories_code not like", value, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeIn(List<String> values) {
            addCriterion("accessories_code in", values, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeNotIn(List<String> values) {
            addCriterion("accessories_code not in", values, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeBetween(String value1, String value2) {
            addCriterion("accessories_code between", value1, value2, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesCodeNotBetween(String value1, String value2) {
            addCriterion("accessories_code not between", value1, value2, "accessoriesCode");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeIsNull() {
            addCriterion("accessories_type is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeIsNotNull() {
            addCriterion("accessories_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeEqualTo(String value) {
            addCriterion("accessories_type =", value, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeNotEqualTo(String value) {
            addCriterion("accessories_type <>", value, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeGreaterThan(String value) {
            addCriterion("accessories_type >", value, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("accessories_type >=", value, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeLessThan(String value) {
            addCriterion("accessories_type <", value, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeLessThanOrEqualTo(String value) {
            addCriterion("accessories_type <=", value, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeLike(String value) {
            addCriterion("accessories_type like", value, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeNotLike(String value) {
            addCriterion("accessories_type not like", value, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeIn(List<String> values) {
            addCriterion("accessories_type in", values, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeNotIn(List<String> values) {
            addCriterion("accessories_type not in", values, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeBetween(String value1, String value2) {
            addCriterion("accessories_type between", value1, value2, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesTypeNotBetween(String value1, String value2) {
            addCriterion("accessories_type not between", value1, value2, "accessoriesType");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameIsNull() {
            addCriterion("accessories_name is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameIsNotNull() {
            addCriterion("accessories_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameEqualTo(String value) {
            addCriterion("accessories_name =", value, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameNotEqualTo(String value) {
            addCriterion("accessories_name <>", value, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameGreaterThan(String value) {
            addCriterion("accessories_name >", value, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameGreaterThanOrEqualTo(String value) {
            addCriterion("accessories_name >=", value, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameLessThan(String value) {
            addCriterion("accessories_name <", value, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameLessThanOrEqualTo(String value) {
            addCriterion("accessories_name <=", value, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameLike(String value) {
            addCriterion("accessories_name like", value, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameNotLike(String value) {
            addCriterion("accessories_name not like", value, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameIn(List<String> values) {
            addCriterion("accessories_name in", values, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameNotIn(List<String> values) {
            addCriterion("accessories_name not in", values, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameBetween(String value1, String value2) {
            addCriterion("accessories_name between", value1, value2, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andAccessoriesNameNotBetween(String value1, String value2) {
            addCriterion("accessories_name not between", value1, value2, "accessoriesName");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
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

        public Criteria andEachNumberIsNull() {
            addCriterion("each_number is null");
            return (Criteria) this;
        }

        public Criteria andEachNumberIsNotNull() {
            addCriterion("each_number is not null");
            return (Criteria) this;
        }

        public Criteria andEachNumberEqualTo(Integer value) {
            addCriterion("each_number =", value, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andEachNumberNotEqualTo(Integer value) {
            addCriterion("each_number <>", value, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andEachNumberGreaterThan(Integer value) {
            addCriterion("each_number >", value, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andEachNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("each_number >=", value, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andEachNumberLessThan(Integer value) {
            addCriterion("each_number <", value, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andEachNumberLessThanOrEqualTo(Integer value) {
            addCriterion("each_number <=", value, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andEachNumberIn(List<Integer> values) {
            addCriterion("each_number in", values, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andEachNumberNotIn(List<Integer> values) {
            addCriterion("each_number not in", values, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andEachNumberBetween(Integer value1, Integer value2) {
            addCriterion("each_number between", value1, value2, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andEachNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("each_number not between", value1, value2, "eachNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryIsNull() {
            addCriterion("warehouse_inventory is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryIsNotNull() {
            addCriterion("warehouse_inventory is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryEqualTo(String value) {
            addCriterion("warehouse_inventory =", value, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryNotEqualTo(String value) {
            addCriterion("warehouse_inventory <>", value, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryGreaterThan(String value) {
            addCriterion("warehouse_inventory >", value, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_inventory >=", value, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryLessThan(String value) {
            addCriterion("warehouse_inventory <", value, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryLessThanOrEqualTo(String value) {
            addCriterion("warehouse_inventory <=", value, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryLike(String value) {
            addCriterion("warehouse_inventory like", value, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryNotLike(String value) {
            addCriterion("warehouse_inventory not like", value, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryIn(List<String> values) {
            addCriterion("warehouse_inventory in", values, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryNotIn(List<String> values) {
            addCriterion("warehouse_inventory not in", values, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryBetween(String value1, String value2) {
            addCriterion("warehouse_inventory between", value1, value2, "warehouseInventory");
            return (Criteria) this;
        }

        public Criteria andWarehouseInventoryNotBetween(String value1, String value2) {
            addCriterion("warehouse_inventory not between", value1, value2, "warehouseInventory");
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