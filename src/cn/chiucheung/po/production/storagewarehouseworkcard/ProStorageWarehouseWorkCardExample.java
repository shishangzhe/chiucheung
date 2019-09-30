package cn.chiucheung.po.production.storagewarehouseworkcard;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProStorageWarehouseWorkCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProStorageWarehouseWorkCardExample() {
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

        public Criteria andQuotationNoIsNull() {
            addCriterion("quotation_no is null");
            return (Criteria) this;
        }

        public Criteria andQuotationNoIsNotNull() {
            addCriterion("quotation_no is not null");
            return (Criteria) this;
        }

        public Criteria andQuotationNoEqualTo(String value) {
            addCriterion("quotation_no =", value, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoNotEqualTo(String value) {
            addCriterion("quotation_no <>", value, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoGreaterThan(String value) {
            addCriterion("quotation_no >", value, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoGreaterThanOrEqualTo(String value) {
            addCriterion("quotation_no >=", value, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoLessThan(String value) {
            addCriterion("quotation_no <", value, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoLessThanOrEqualTo(String value) {
            addCriterion("quotation_no <=", value, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoLike(String value) {
            addCriterion("quotation_no like", value, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoNotLike(String value) {
            addCriterion("quotation_no not like", value, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoIn(List<String> values) {
            addCriterion("quotation_no in", values, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoNotIn(List<String> values) {
            addCriterion("quotation_no not in", values, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoBetween(String value1, String value2) {
            addCriterion("quotation_no between", value1, value2, "quotationNo");
            return (Criteria) this;
        }

        public Criteria andQuotationNoNotBetween(String value1, String value2) {
            addCriterion("quotation_no not between", value1, value2, "quotationNo");
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

        public Criteria andWorkCardDateIsNull() {
            addCriterion("work_card_date is null");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateIsNotNull() {
            addCriterion("work_card_date is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateEqualTo(Date value) {
            addCriterionForJDBCDate("work_card_date =", value, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("work_card_date <>", value, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateGreaterThan(Date value) {
            addCriterionForJDBCDate("work_card_date >", value, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("work_card_date >=", value, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateLessThan(Date value) {
            addCriterionForJDBCDate("work_card_date <", value, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("work_card_date <=", value, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateIn(List<Date> values) {
            addCriterionForJDBCDate("work_card_date in", values, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("work_card_date not in", values, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("work_card_date between", value1, value2, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andWorkCardDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("work_card_date not between", value1, value2, "workCardDate");
            return (Criteria) this;
        }

        public Criteria andStandardProductIsNull() {
            addCriterion("standard_product is null");
            return (Criteria) this;
        }

        public Criteria andStandardProductIsNotNull() {
            addCriterion("standard_product is not null");
            return (Criteria) this;
        }

        public Criteria andStandardProductEqualTo(Boolean value) {
            addCriterion("standard_product =", value, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andStandardProductNotEqualTo(Boolean value) {
            addCriterion("standard_product <>", value, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andStandardProductGreaterThan(Boolean value) {
            addCriterion("standard_product >", value, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andStandardProductGreaterThanOrEqualTo(Boolean value) {
            addCriterion("standard_product >=", value, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andStandardProductLessThan(Boolean value) {
            addCriterion("standard_product <", value, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andStandardProductLessThanOrEqualTo(Boolean value) {
            addCriterion("standard_product <=", value, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andStandardProductIn(List<Boolean> values) {
            addCriterion("standard_product in", values, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andStandardProductNotIn(List<Boolean> values) {
            addCriterion("standard_product not in", values, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andStandardProductBetween(Boolean value1, Boolean value2) {
            addCriterion("standard_product between", value1, value2, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andStandardProductNotBetween(Boolean value1, Boolean value2) {
            addCriterion("standard_product not between", value1, value2, "standardProduct");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresIsNull() {
            addCriterion("approval_procedures is null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresIsNotNull() {
            addCriterion("approval_procedures is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresEqualTo(String value) {
            addCriterion("approval_procedures =", value, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresNotEqualTo(String value) {
            addCriterion("approval_procedures <>", value, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresGreaterThan(String value) {
            addCriterion("approval_procedures >", value, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresGreaterThanOrEqualTo(String value) {
            addCriterion("approval_procedures >=", value, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresLessThan(String value) {
            addCriterion("approval_procedures <", value, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresLessThanOrEqualTo(String value) {
            addCriterion("approval_procedures <=", value, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresLike(String value) {
            addCriterion("approval_procedures like", value, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresNotLike(String value) {
            addCriterion("approval_procedures not like", value, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresIn(List<String> values) {
            addCriterion("approval_procedures in", values, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresNotIn(List<String> values) {
            addCriterion("approval_procedures not in", values, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresBetween(String value1, String value2) {
            addCriterion("approval_procedures between", value1, value2, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresNotBetween(String value1, String value2) {
            addCriterion("approval_procedures not between", value1, value2, "approvalProcedures");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentIsNull() {
            addCriterion("approval_procedures_content is null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentIsNotNull() {
            addCriterion("approval_procedures_content is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentEqualTo(String value) {
            addCriterion("approval_procedures_content =", value, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentNotEqualTo(String value) {
            addCriterion("approval_procedures_content <>", value, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentGreaterThan(String value) {
            addCriterion("approval_procedures_content >", value, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentGreaterThanOrEqualTo(String value) {
            addCriterion("approval_procedures_content >=", value, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentLessThan(String value) {
            addCriterion("approval_procedures_content <", value, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentLessThanOrEqualTo(String value) {
            addCriterion("approval_procedures_content <=", value, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentLike(String value) {
            addCriterion("approval_procedures_content like", value, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentNotLike(String value) {
            addCriterion("approval_procedures_content not like", value, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentIn(List<String> values) {
            addCriterion("approval_procedures_content in", values, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentNotIn(List<String> values) {
            addCriterion("approval_procedures_content not in", values, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentBetween(String value1, String value2) {
            addCriterion("approval_procedures_content between", value1, value2, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContentNotBetween(String value1, String value2) {
            addCriterion("approval_procedures_content not between", value1, value2, "approvalProceduresContent");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsIsNull() {
            addCriterion("raw_materials is null");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsIsNotNull() {
            addCriterion("raw_materials is not null");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsEqualTo(String value) {
            addCriterion("raw_materials =", value, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsNotEqualTo(String value) {
            addCriterion("raw_materials <>", value, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsGreaterThan(String value) {
            addCriterion("raw_materials >", value, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsGreaterThanOrEqualTo(String value) {
            addCriterion("raw_materials >=", value, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsLessThan(String value) {
            addCriterion("raw_materials <", value, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsLessThanOrEqualTo(String value) {
            addCriterion("raw_materials <=", value, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsLike(String value) {
            addCriterion("raw_materials like", value, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsNotLike(String value) {
            addCriterion("raw_materials not like", value, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsIn(List<String> values) {
            addCriterion("raw_materials in", values, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsNotIn(List<String> values) {
            addCriterion("raw_materials not in", values, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsBetween(String value1, String value2) {
            addCriterion("raw_materials between", value1, value2, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andRawMaterialsNotBetween(String value1, String value2) {
            addCriterion("raw_materials not between", value1, value2, "rawMaterials");
            return (Criteria) this;
        }

        public Criteria andThicknessIsNull() {
            addCriterion("thickness is null");
            return (Criteria) this;
        }

        public Criteria andThicknessIsNotNull() {
            addCriterion("thickness is not null");
            return (Criteria) this;
        }

        public Criteria andThicknessEqualTo(String value) {
            addCriterion("thickness =", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotEqualTo(String value) {
            addCriterion("thickness <>", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessGreaterThan(String value) {
            addCriterion("thickness >", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessGreaterThanOrEqualTo(String value) {
            addCriterion("thickness >=", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessLessThan(String value) {
            addCriterion("thickness <", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessLessThanOrEqualTo(String value) {
            addCriterion("thickness <=", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessLike(String value) {
            addCriterion("thickness like", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotLike(String value) {
            addCriterion("thickness not like", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessIn(List<String> values) {
            addCriterion("thickness in", values, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotIn(List<String> values) {
            addCriterion("thickness not in", values, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessBetween(String value1, String value2) {
            addCriterion("thickness between", value1, value2, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotBetween(String value1, String value2) {
            addCriterion("thickness not between", value1, value2, "thickness");
            return (Criteria) this;
        }

        public Criteria andPerformanceIsNull() {
            addCriterion("performance is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIsNotNull() {
            addCriterion("performance is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceEqualTo(String value) {
            addCriterion("performance =", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotEqualTo(String value) {
            addCriterion("performance <>", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceGreaterThan(String value) {
            addCriterion("performance >", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceGreaterThanOrEqualTo(String value) {
            addCriterion("performance >=", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLessThan(String value) {
            addCriterion("performance <", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLessThanOrEqualTo(String value) {
            addCriterion("performance <=", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLike(String value) {
            addCriterion("performance like", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotLike(String value) {
            addCriterion("performance not like", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceIn(List<String> values) {
            addCriterion("performance in", values, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotIn(List<String> values) {
            addCriterion("performance not in", values, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceBetween(String value1, String value2) {
            addCriterion("performance between", value1, value2, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotBetween(String value1, String value2) {
            addCriterion("performance not between", value1, value2, "performance");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentIsNull() {
            addCriterion("surface_treatment is null");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentIsNotNull() {
            addCriterion("surface_treatment is not null");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentEqualTo(String value) {
            addCriterion("surface_treatment =", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentNotEqualTo(String value) {
            addCriterion("surface_treatment <>", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentGreaterThan(String value) {
            addCriterion("surface_treatment >", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentGreaterThanOrEqualTo(String value) {
            addCriterion("surface_treatment >=", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentLessThan(String value) {
            addCriterion("surface_treatment <", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentLessThanOrEqualTo(String value) {
            addCriterion("surface_treatment <=", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentLike(String value) {
            addCriterion("surface_treatment like", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentNotLike(String value) {
            addCriterion("surface_treatment not like", value, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentIn(List<String> values) {
            addCriterion("surface_treatment in", values, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentNotIn(List<String> values) {
            addCriterion("surface_treatment not in", values, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentBetween(String value1, String value2) {
            addCriterion("surface_treatment between", value1, value2, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andSurfaceTreatmentNotBetween(String value1, String value2) {
            addCriterion("surface_treatment not between", value1, value2, "surfaceTreatment");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersIsNull() {
            addCriterion("qc_attention_matters is null");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersIsNotNull() {
            addCriterion("qc_attention_matters is not null");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersEqualTo(String value) {
            addCriterion("qc_attention_matters =", value, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersNotEqualTo(String value) {
            addCriterion("qc_attention_matters <>", value, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersGreaterThan(String value) {
            addCriterion("qc_attention_matters >", value, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersGreaterThanOrEqualTo(String value) {
            addCriterion("qc_attention_matters >=", value, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersLessThan(String value) {
            addCriterion("qc_attention_matters <", value, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersLessThanOrEqualTo(String value) {
            addCriterion("qc_attention_matters <=", value, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersLike(String value) {
            addCriterion("qc_attention_matters like", value, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersNotLike(String value) {
            addCriterion("qc_attention_matters not like", value, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersIn(List<String> values) {
            addCriterion("qc_attention_matters in", values, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersNotIn(List<String> values) {
            addCriterion("qc_attention_matters not in", values, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersBetween(String value1, String value2) {
            addCriterion("qc_attention_matters between", value1, value2, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andQcAttentionMattersNotBetween(String value1, String value2) {
            addCriterion("qc_attention_matters not between", value1, value2, "qcAttentionMatters");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldIsNull() {
            addCriterion("special_mold is null");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldIsNotNull() {
            addCriterion("special_mold is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldEqualTo(String value) {
            addCriterion("special_mold =", value, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldNotEqualTo(String value) {
            addCriterion("special_mold <>", value, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldGreaterThan(String value) {
            addCriterion("special_mold >", value, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldGreaterThanOrEqualTo(String value) {
            addCriterion("special_mold >=", value, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldLessThan(String value) {
            addCriterion("special_mold <", value, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldLessThanOrEqualTo(String value) {
            addCriterion("special_mold <=", value, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldLike(String value) {
            addCriterion("special_mold like", value, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldNotLike(String value) {
            addCriterion("special_mold not like", value, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldIn(List<String> values) {
            addCriterion("special_mold in", values, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldNotIn(List<String> values) {
            addCriterion("special_mold not in", values, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldBetween(String value1, String value2) {
            addCriterion("special_mold between", value1, value2, "specialMold");
            return (Criteria) this;
        }

        public Criteria andSpecialMoldNotBetween(String value1, String value2) {
            addCriterion("special_mold not between", value1, value2, "specialMold");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingIsNull() {
            addCriterion("outward_processing is null");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingIsNotNull() {
            addCriterion("outward_processing is not null");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingEqualTo(String value) {
            addCriterion("outward_processing =", value, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingNotEqualTo(String value) {
            addCriterion("outward_processing <>", value, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingGreaterThan(String value) {
            addCriterion("outward_processing >", value, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingGreaterThanOrEqualTo(String value) {
            addCriterion("outward_processing >=", value, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingLessThan(String value) {
            addCriterion("outward_processing <", value, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingLessThanOrEqualTo(String value) {
            addCriterion("outward_processing <=", value, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingLike(String value) {
            addCriterion("outward_processing like", value, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingNotLike(String value) {
            addCriterion("outward_processing not like", value, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingIn(List<String> values) {
            addCriterion("outward_processing in", values, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingNotIn(List<String> values) {
            addCriterion("outward_processing not in", values, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingBetween(String value1, String value2) {
            addCriterion("outward_processing between", value1, value2, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andOutwardProcessingNotBetween(String value1, String value2) {
            addCriterion("outward_processing not between", value1, value2, "outwardProcessing");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceIsNull() {
            addCriterion("delivery_place is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceIsNotNull() {
            addCriterion("delivery_place is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceEqualTo(String value) {
            addCriterion("delivery_place =", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceNotEqualTo(String value) {
            addCriterion("delivery_place <>", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceGreaterThan(String value) {
            addCriterion("delivery_place >", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_place >=", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceLessThan(String value) {
            addCriterion("delivery_place <", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceLessThanOrEqualTo(String value) {
            addCriterion("delivery_place <=", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceLike(String value) {
            addCriterion("delivery_place like", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceNotLike(String value) {
            addCriterion("delivery_place not like", value, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceIn(List<String> values) {
            addCriterion("delivery_place in", values, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceNotIn(List<String> values) {
            addCriterion("delivery_place not in", values, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceBetween(String value1, String value2) {
            addCriterion("delivery_place between", value1, value2, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceNotBetween(String value1, String value2) {
            addCriterion("delivery_place not between", value1, value2, "deliveryPlace");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentIsNull() {
            addCriterion("delivery_place_content is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentIsNotNull() {
            addCriterion("delivery_place_content is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentEqualTo(String value) {
            addCriterion("delivery_place_content =", value, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentNotEqualTo(String value) {
            addCriterion("delivery_place_content <>", value, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentGreaterThan(String value) {
            addCriterion("delivery_place_content >", value, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_place_content >=", value, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentLessThan(String value) {
            addCriterion("delivery_place_content <", value, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentLessThanOrEqualTo(String value) {
            addCriterion("delivery_place_content <=", value, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentLike(String value) {
            addCriterion("delivery_place_content like", value, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentNotLike(String value) {
            addCriterion("delivery_place_content not like", value, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentIn(List<String> values) {
            addCriterion("delivery_place_content in", values, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentNotIn(List<String> values) {
            addCriterion("delivery_place_content not in", values, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentBetween(String value1, String value2) {
            addCriterion("delivery_place_content between", value1, value2, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContentNotBetween(String value1, String value2) {
            addCriterion("delivery_place_content not between", value1, value2, "deliveryPlaceContent");
            return (Criteria) this;
        }

        public Criteria andShipmentWayIsNull() {
            addCriterion("shipment_way is null");
            return (Criteria) this;
        }

        public Criteria andShipmentWayIsNotNull() {
            addCriterion("shipment_way is not null");
            return (Criteria) this;
        }

        public Criteria andShipmentWayEqualTo(String value) {
            addCriterion("shipment_way =", value, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayNotEqualTo(String value) {
            addCriterion("shipment_way <>", value, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayGreaterThan(String value) {
            addCriterion("shipment_way >", value, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayGreaterThanOrEqualTo(String value) {
            addCriterion("shipment_way >=", value, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayLessThan(String value) {
            addCriterion("shipment_way <", value, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayLessThanOrEqualTo(String value) {
            addCriterion("shipment_way <=", value, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayLike(String value) {
            addCriterion("shipment_way like", value, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayNotLike(String value) {
            addCriterion("shipment_way not like", value, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayIn(List<String> values) {
            addCriterion("shipment_way in", values, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayNotIn(List<String> values) {
            addCriterion("shipment_way not in", values, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayBetween(String value1, String value2) {
            addCriterion("shipment_way between", value1, value2, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andShipmentWayNotBetween(String value1, String value2) {
            addCriterion("shipment_way not between", value1, value2, "shipmentWay");
            return (Criteria) this;
        }

        public Criteria andInstallRequirIsNull() {
            addCriterion("install_requir is null");
            return (Criteria) this;
        }

        public Criteria andInstallRequirIsNotNull() {
            addCriterion("install_requir is not null");
            return (Criteria) this;
        }

        public Criteria andInstallRequirEqualTo(String value) {
            addCriterion("install_requir =", value, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirNotEqualTo(String value) {
            addCriterion("install_requir <>", value, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirGreaterThan(String value) {
            addCriterion("install_requir >", value, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirGreaterThanOrEqualTo(String value) {
            addCriterion("install_requir >=", value, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirLessThan(String value) {
            addCriterion("install_requir <", value, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirLessThanOrEqualTo(String value) {
            addCriterion("install_requir <=", value, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirLike(String value) {
            addCriterion("install_requir like", value, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirNotLike(String value) {
            addCriterion("install_requir not like", value, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirIn(List<String> values) {
            addCriterion("install_requir in", values, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirNotIn(List<String> values) {
            addCriterion("install_requir not in", values, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirBetween(String value1, String value2) {
            addCriterion("install_requir between", value1, value2, "installRequir");
            return (Criteria) this;
        }

        public Criteria andInstallRequirNotBetween(String value1, String value2) {
            addCriterion("install_requir not between", value1, value2, "installRequir");
            return (Criteria) this;
        }

        public Criteria andPackagingIsNull() {
            addCriterion("packaging is null");
            return (Criteria) this;
        }

        public Criteria andPackagingIsNotNull() {
            addCriterion("packaging is not null");
            return (Criteria) this;
        }

        public Criteria andPackagingEqualTo(String value) {
            addCriterion("packaging =", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingNotEqualTo(String value) {
            addCriterion("packaging <>", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingGreaterThan(String value) {
            addCriterion("packaging >", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingGreaterThanOrEqualTo(String value) {
            addCriterion("packaging >=", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingLessThan(String value) {
            addCriterion("packaging <", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingLessThanOrEqualTo(String value) {
            addCriterion("packaging <=", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingLike(String value) {
            addCriterion("packaging like", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingNotLike(String value) {
            addCriterion("packaging not like", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingIn(List<String> values) {
            addCriterion("packaging in", values, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingNotIn(List<String> values) {
            addCriterion("packaging not in", values, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingBetween(String value1, String value2) {
            addCriterion("packaging between", value1, value2, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingNotBetween(String value1, String value2) {
            addCriterion("packaging not between", value1, value2, "packaging");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayIsNull() {
            addCriterion("assembly_way is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayIsNotNull() {
            addCriterion("assembly_way is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayEqualTo(String value) {
            addCriterion("assembly_way =", value, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayNotEqualTo(String value) {
            addCriterion("assembly_way <>", value, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayGreaterThan(String value) {
            addCriterion("assembly_way >", value, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayGreaterThanOrEqualTo(String value) {
            addCriterion("assembly_way >=", value, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayLessThan(String value) {
            addCriterion("assembly_way <", value, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayLessThanOrEqualTo(String value) {
            addCriterion("assembly_way <=", value, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayLike(String value) {
            addCriterion("assembly_way like", value, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayNotLike(String value) {
            addCriterion("assembly_way not like", value, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayIn(List<String> values) {
            addCriterion("assembly_way in", values, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayNotIn(List<String> values) {
            addCriterion("assembly_way not in", values, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayBetween(String value1, String value2) {
            addCriterion("assembly_way between", value1, value2, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayNotBetween(String value1, String value2) {
            addCriterion("assembly_way not between", value1, value2, "assemblyWay");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeIsNull() {
            addCriterion("min_channel_size is null");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeIsNotNull() {
            addCriterion("min_channel_size is not null");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeEqualTo(String value) {
            addCriterion("min_channel_size =", value, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeNotEqualTo(String value) {
            addCriterion("min_channel_size <>", value, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeGreaterThan(String value) {
            addCriterion("min_channel_size >", value, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeGreaterThanOrEqualTo(String value) {
            addCriterion("min_channel_size >=", value, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeLessThan(String value) {
            addCriterion("min_channel_size <", value, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeLessThanOrEqualTo(String value) {
            addCriterion("min_channel_size <=", value, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeLike(String value) {
            addCriterion("min_channel_size like", value, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeNotLike(String value) {
            addCriterion("min_channel_size not like", value, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeIn(List<String> values) {
            addCriterion("min_channel_size in", values, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeNotIn(List<String> values) {
            addCriterion("min_channel_size not in", values, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeBetween(String value1, String value2) {
            addCriterion("min_channel_size between", value1, value2, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andMinChannelSizeNotBetween(String value1, String value2) {
            addCriterion("min_channel_size not between", value1, value2, "minChannelSize");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayIsNull() {
            addCriterion("accessories_way is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayIsNotNull() {
            addCriterion("accessories_way is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayEqualTo(String value) {
            addCriterion("accessories_way =", value, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayNotEqualTo(String value) {
            addCriterion("accessories_way <>", value, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayGreaterThan(String value) {
            addCriterion("accessories_way >", value, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayGreaterThanOrEqualTo(String value) {
            addCriterion("accessories_way >=", value, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayLessThan(String value) {
            addCriterion("accessories_way <", value, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayLessThanOrEqualTo(String value) {
            addCriterion("accessories_way <=", value, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayLike(String value) {
            addCriterion("accessories_way like", value, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayNotLike(String value) {
            addCriterion("accessories_way not like", value, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayIn(List<String> values) {
            addCriterion("accessories_way in", values, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayNotIn(List<String> values) {
            addCriterion("accessories_way not in", values, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayBetween(String value1, String value2) {
            addCriterion("accessories_way between", value1, value2, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayNotBetween(String value1, String value2) {
            addCriterion("accessories_way not between", value1, value2, "accessoriesWay");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentIsNull() {
            addCriterion("accessories_way_content is null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentIsNotNull() {
            addCriterion("accessories_way_content is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentEqualTo(String value) {
            addCriterion("accessories_way_content =", value, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentNotEqualTo(String value) {
            addCriterion("accessories_way_content <>", value, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentGreaterThan(String value) {
            addCriterion("accessories_way_content >", value, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentGreaterThanOrEqualTo(String value) {
            addCriterion("accessories_way_content >=", value, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentLessThan(String value) {
            addCriterion("accessories_way_content <", value, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentLessThanOrEqualTo(String value) {
            addCriterion("accessories_way_content <=", value, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentLike(String value) {
            addCriterion("accessories_way_content like", value, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentNotLike(String value) {
            addCriterion("accessories_way_content not like", value, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentIn(List<String> values) {
            addCriterion("accessories_way_content in", values, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentNotIn(List<String> values) {
            addCriterion("accessories_way_content not in", values, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentBetween(String value1, String value2) {
            addCriterion("accessories_way_content between", value1, value2, "accessoriesWayContent");
            return (Criteria) this;
        }

        public Criteria andAccessoriesWayContentNotBetween(String value1, String value2) {
            addCriterion("accessories_way_content not between", value1, value2, "accessoriesWayContent");
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

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(String value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(String value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(String value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(String value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(String value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLike(String value) {
            addCriterion("attachment like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotLike(String value) {
            addCriterion("attachment not like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<String> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<String> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(String value1, String value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(String value1, String value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andCopyToIsNull() {
            addCriterion("copy_to is null");
            return (Criteria) this;
        }

        public Criteria andCopyToIsNotNull() {
            addCriterion("copy_to is not null");
            return (Criteria) this;
        }

        public Criteria andCopyToEqualTo(String value) {
            addCriterion("copy_to =", value, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToNotEqualTo(String value) {
            addCriterion("copy_to <>", value, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToGreaterThan(String value) {
            addCriterion("copy_to >", value, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToGreaterThanOrEqualTo(String value) {
            addCriterion("copy_to >=", value, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToLessThan(String value) {
            addCriterion("copy_to <", value, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToLessThanOrEqualTo(String value) {
            addCriterion("copy_to <=", value, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToLike(String value) {
            addCriterion("copy_to like", value, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToNotLike(String value) {
            addCriterion("copy_to not like", value, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToIn(List<String> values) {
            addCriterion("copy_to in", values, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToNotIn(List<String> values) {
            addCriterion("copy_to not in", values, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToBetween(String value1, String value2) {
            addCriterion("copy_to between", value1, value2, "copyTo");
            return (Criteria) this;
        }

        public Criteria andCopyToNotBetween(String value1, String value2) {
            addCriterion("copy_to not between", value1, value2, "copyTo");
            return (Criteria) this;
        }

        public Criteria andPreparerIsNull() {
            addCriterion("preparer is null");
            return (Criteria) this;
        }

        public Criteria andPreparerIsNotNull() {
            addCriterion("preparer is not null");
            return (Criteria) this;
        }

        public Criteria andPreparerEqualTo(String value) {
            addCriterion("preparer =", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotEqualTo(String value) {
            addCriterion("preparer <>", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerGreaterThan(String value) {
            addCriterion("preparer >", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerGreaterThanOrEqualTo(String value) {
            addCriterion("preparer >=", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerLessThan(String value) {
            addCriterion("preparer <", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerLessThanOrEqualTo(String value) {
            addCriterion("preparer <=", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerLike(String value) {
            addCriterion("preparer like", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotLike(String value) {
            addCriterion("preparer not like", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerIn(List<String> values) {
            addCriterion("preparer in", values, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotIn(List<String> values) {
            addCriterion("preparer not in", values, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerBetween(String value1, String value2) {
            addCriterion("preparer between", value1, value2, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotBetween(String value1, String value2) {
            addCriterion("preparer not between", value1, value2, "preparer");
            return (Criteria) this;
        }

        public Criteria andProLeaderIsNull() {
            addCriterion("pro_leader is null");
            return (Criteria) this;
        }

        public Criteria andProLeaderIsNotNull() {
            addCriterion("pro_leader is not null");
            return (Criteria) this;
        }

        public Criteria andProLeaderEqualTo(String value) {
            addCriterion("pro_leader =", value, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderNotEqualTo(String value) {
            addCriterion("pro_leader <>", value, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderGreaterThan(String value) {
            addCriterion("pro_leader >", value, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("pro_leader >=", value, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderLessThan(String value) {
            addCriterion("pro_leader <", value, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderLessThanOrEqualTo(String value) {
            addCriterion("pro_leader <=", value, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderLike(String value) {
            addCriterion("pro_leader like", value, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderNotLike(String value) {
            addCriterion("pro_leader not like", value, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderIn(List<String> values) {
            addCriterion("pro_leader in", values, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderNotIn(List<String> values) {
            addCriterion("pro_leader not in", values, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderBetween(String value1, String value2) {
            addCriterion("pro_leader between", value1, value2, "proLeader");
            return (Criteria) this;
        }

        public Criteria andProLeaderNotBetween(String value1, String value2) {
            addCriterion("pro_leader not between", value1, value2, "proLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderIsNull() {
            addCriterion("work_card_leader is null");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderIsNotNull() {
            addCriterion("work_card_leader is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderEqualTo(String value) {
            addCriterion("work_card_leader =", value, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderNotEqualTo(String value) {
            addCriterion("work_card_leader <>", value, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderGreaterThan(String value) {
            addCriterion("work_card_leader >", value, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("work_card_leader >=", value, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderLessThan(String value) {
            addCriterion("work_card_leader <", value, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderLessThanOrEqualTo(String value) {
            addCriterion("work_card_leader <=", value, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderLike(String value) {
            addCriterion("work_card_leader like", value, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderNotLike(String value) {
            addCriterion("work_card_leader not like", value, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderIn(List<String> values) {
            addCriterion("work_card_leader in", values, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderNotIn(List<String> values) {
            addCriterion("work_card_leader not in", values, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderBetween(String value1, String value2) {
            addCriterion("work_card_leader between", value1, value2, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andWorkCardLeaderNotBetween(String value1, String value2) {
            addCriterion("work_card_leader not between", value1, value2, "workCardLeader");
            return (Criteria) this;
        }

        public Criteria andSignerIsNull() {
            addCriterion("signer is null");
            return (Criteria) this;
        }

        public Criteria andSignerIsNotNull() {
            addCriterion("signer is not null");
            return (Criteria) this;
        }

        public Criteria andSignerEqualTo(String value) {
            addCriterion("signer =", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerNotEqualTo(String value) {
            addCriterion("signer <>", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerGreaterThan(String value) {
            addCriterion("signer >", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerGreaterThanOrEqualTo(String value) {
            addCriterion("signer >=", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerLessThan(String value) {
            addCriterion("signer <", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerLessThanOrEqualTo(String value) {
            addCriterion("signer <=", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerLike(String value) {
            addCriterion("signer like", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerNotLike(String value) {
            addCriterion("signer not like", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerIn(List<String> values) {
            addCriterion("signer in", values, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerNotIn(List<String> values) {
            addCriterion("signer not in", values, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerBetween(String value1, String value2) {
            addCriterion("signer between", value1, value2, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerNotBetween(String value1, String value2) {
            addCriterion("signer not between", value1, value2, "signer");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNull() {
            addCriterion("process_instance_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNotNull() {
            addCriterion("process_instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdEqualTo(String value) {
            addCriterion("process_instance_id =", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotEqualTo(String value) {
            addCriterion("process_instance_id <>", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThan(String value) {
            addCriterion("process_instance_id >", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_instance_id >=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThan(String value) {
            addCriterion("process_instance_id <", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("process_instance_id <=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLike(String value) {
            addCriterion("process_instance_id like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotLike(String value) {
            addCriterion("process_instance_id not like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIn(List<String> values) {
            addCriterion("process_instance_id in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotIn(List<String> values) {
            addCriterion("process_instance_id not in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdBetween(String value1, String value2) {
            addCriterion("process_instance_id between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotBetween(String value1, String value2) {
            addCriterion("process_instance_id not between", value1, value2, "processInstanceId");
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