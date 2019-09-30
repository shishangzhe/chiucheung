package cn.chiucheung.po.sales.workcard;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SalWorkCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalWorkCardExample() {
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

        public Criteria andApprovalProceduresContent1IsNull() {
            addCriterion("approval_procedures_content1 is null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1IsNotNull() {
            addCriterion("approval_procedures_content1 is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1EqualTo(String value) {
            addCriterion("approval_procedures_content1 =", value, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1NotEqualTo(String value) {
            addCriterion("approval_procedures_content1 <>", value, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1GreaterThan(String value) {
            addCriterion("approval_procedures_content1 >", value, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1GreaterThanOrEqualTo(String value) {
            addCriterion("approval_procedures_content1 >=", value, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1LessThan(String value) {
            addCriterion("approval_procedures_content1 <", value, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1LessThanOrEqualTo(String value) {
            addCriterion("approval_procedures_content1 <=", value, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1Like(String value) {
            addCriterion("approval_procedures_content1 like", value, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1NotLike(String value) {
            addCriterion("approval_procedures_content1 not like", value, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1In(List<String> values) {
            addCriterion("approval_procedures_content1 in", values, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1NotIn(List<String> values) {
            addCriterion("approval_procedures_content1 not in", values, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1Between(String value1, String value2) {
            addCriterion("approval_procedures_content1 between", value1, value2, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent1NotBetween(String value1, String value2) {
            addCriterion("approval_procedures_content1 not between", value1, value2, "approvalProceduresContent1");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2IsNull() {
            addCriterion("approval_procedures_content2 is null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2IsNotNull() {
            addCriterion("approval_procedures_content2 is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2EqualTo(String value) {
            addCriterion("approval_procedures_content2 =", value, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2NotEqualTo(String value) {
            addCriterion("approval_procedures_content2 <>", value, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2GreaterThan(String value) {
            addCriterion("approval_procedures_content2 >", value, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2GreaterThanOrEqualTo(String value) {
            addCriterion("approval_procedures_content2 >=", value, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2LessThan(String value) {
            addCriterion("approval_procedures_content2 <", value, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2LessThanOrEqualTo(String value) {
            addCriterion("approval_procedures_content2 <=", value, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2Like(String value) {
            addCriterion("approval_procedures_content2 like", value, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2NotLike(String value) {
            addCriterion("approval_procedures_content2 not like", value, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2In(List<String> values) {
            addCriterion("approval_procedures_content2 in", values, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2NotIn(List<String> values) {
            addCriterion("approval_procedures_content2 not in", values, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2Between(String value1, String value2) {
            addCriterion("approval_procedures_content2 between", value1, value2, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent2NotBetween(String value1, String value2) {
            addCriterion("approval_procedures_content2 not between", value1, value2, "approvalProceduresContent2");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3IsNull() {
            addCriterion("approval_procedures_content3 is null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3IsNotNull() {
            addCriterion("approval_procedures_content3 is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3EqualTo(String value) {
            addCriterion("approval_procedures_content3 =", value, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3NotEqualTo(String value) {
            addCriterion("approval_procedures_content3 <>", value, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3GreaterThan(String value) {
            addCriterion("approval_procedures_content3 >", value, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3GreaterThanOrEqualTo(String value) {
            addCriterion("approval_procedures_content3 >=", value, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3LessThan(String value) {
            addCriterion("approval_procedures_content3 <", value, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3LessThanOrEqualTo(String value) {
            addCriterion("approval_procedures_content3 <=", value, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3Like(String value) {
            addCriterion("approval_procedures_content3 like", value, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3NotLike(String value) {
            addCriterion("approval_procedures_content3 not like", value, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3In(List<String> values) {
            addCriterion("approval_procedures_content3 in", values, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3NotIn(List<String> values) {
            addCriterion("approval_procedures_content3 not in", values, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3Between(String value1, String value2) {
            addCriterion("approval_procedures_content3 between", value1, value2, "approvalProceduresContent3");
            return (Criteria) this;
        }

        public Criteria andApprovalProceduresContent3NotBetween(String value1, String value2) {
            addCriterion("approval_procedures_content3 not between", value1, value2, "approvalProceduresContent3");
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

        public Criteria andSpecialInspectionIsNull() {
            addCriterion("special_inspection is null");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionIsNotNull() {
            addCriterion("special_inspection is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionEqualTo(Boolean value) {
            addCriterion("special_inspection =", value, "specialInspection");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionNotEqualTo(Boolean value) {
            addCriterion("special_inspection <>", value, "specialInspection");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionGreaterThan(Boolean value) {
            addCriterion("special_inspection >", value, "specialInspection");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionGreaterThanOrEqualTo(Boolean value) {
            addCriterion("special_inspection >=", value, "specialInspection");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionLessThan(Boolean value) {
            addCriterion("special_inspection <", value, "specialInspection");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionLessThanOrEqualTo(Boolean value) {
            addCriterion("special_inspection <=", value, "specialInspection");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionIn(List<Boolean> values) {
            addCriterion("special_inspection in", values, "specialInspection");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionNotIn(List<Boolean> values) {
            addCriterion("special_inspection not in", values, "specialInspection");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionBetween(Boolean value1, Boolean value2) {
            addCriterion("special_inspection between", value1, value2, "specialInspection");
            return (Criteria) this;
        }

        public Criteria andSpecialInspectionNotBetween(Boolean value1, Boolean value2) {
            addCriterion("special_inspection not between", value1, value2, "specialInspection");
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

        public Criteria andDeliveryPlaceContent1IsNull() {
            addCriterion("delivery_place_content1 is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1IsNotNull() {
            addCriterion("delivery_place_content1 is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1EqualTo(String value) {
            addCriterion("delivery_place_content1 =", value, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1NotEqualTo(String value) {
            addCriterion("delivery_place_content1 <>", value, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1GreaterThan(String value) {
            addCriterion("delivery_place_content1 >", value, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1GreaterThanOrEqualTo(String value) {
            addCriterion("delivery_place_content1 >=", value, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1LessThan(String value) {
            addCriterion("delivery_place_content1 <", value, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1LessThanOrEqualTo(String value) {
            addCriterion("delivery_place_content1 <=", value, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1Like(String value) {
            addCriterion("delivery_place_content1 like", value, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1NotLike(String value) {
            addCriterion("delivery_place_content1 not like", value, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1In(List<String> values) {
            addCriterion("delivery_place_content1 in", values, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1NotIn(List<String> values) {
            addCriterion("delivery_place_content1 not in", values, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1Between(String value1, String value2) {
            addCriterion("delivery_place_content1 between", value1, value2, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent1NotBetween(String value1, String value2) {
            addCriterion("delivery_place_content1 not between", value1, value2, "deliveryPlaceContent1");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2IsNull() {
            addCriterion("delivery_place_content2 is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2IsNotNull() {
            addCriterion("delivery_place_content2 is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2EqualTo(String value) {
            addCriterion("delivery_place_content2 =", value, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2NotEqualTo(String value) {
            addCriterion("delivery_place_content2 <>", value, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2GreaterThan(String value) {
            addCriterion("delivery_place_content2 >", value, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2GreaterThanOrEqualTo(String value) {
            addCriterion("delivery_place_content2 >=", value, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2LessThan(String value) {
            addCriterion("delivery_place_content2 <", value, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2LessThanOrEqualTo(String value) {
            addCriterion("delivery_place_content2 <=", value, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2Like(String value) {
            addCriterion("delivery_place_content2 like", value, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2NotLike(String value) {
            addCriterion("delivery_place_content2 not like", value, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2In(List<String> values) {
            addCriterion("delivery_place_content2 in", values, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2NotIn(List<String> values) {
            addCriterion("delivery_place_content2 not in", values, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2Between(String value1, String value2) {
            addCriterion("delivery_place_content2 between", value1, value2, "deliveryPlaceContent2");
            return (Criteria) this;
        }

        public Criteria andDeliveryPlaceContent2NotBetween(String value1, String value2) {
            addCriterion("delivery_place_content2 not between", value1, value2, "deliveryPlaceContent2");
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

        public Criteria andContractAmountIsNull() {
            addCriterion("contract_amount is null");
            return (Criteria) this;
        }

        public Criteria andContractAmountIsNotNull() {
            addCriterion("contract_amount is not null");
            return (Criteria) this;
        }

        public Criteria andContractAmountEqualTo(String value) {
            addCriterion("contract_amount =", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotEqualTo(String value) {
            addCriterion("contract_amount <>", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThan(String value) {
            addCriterion("contract_amount >", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThanOrEqualTo(String value) {
            addCriterion("contract_amount >=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThan(String value) {
            addCriterion("contract_amount <", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThanOrEqualTo(String value) {
            addCriterion("contract_amount <=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLike(String value) {
            addCriterion("contract_amount like", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotLike(String value) {
            addCriterion("contract_amount not like", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountIn(List<String> values) {
            addCriterion("contract_amount in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotIn(List<String> values) {
            addCriterion("contract_amount not in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountBetween(String value1, String value2) {
            addCriterion("contract_amount between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotBetween(String value1, String value2) {
            addCriterion("contract_amount not between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationIsNull() {
            addCriterion("scene_installation is null");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationIsNotNull() {
            addCriterion("scene_installation is not null");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationEqualTo(Boolean value) {
            addCriterion("scene_installation =", value, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationNotEqualTo(Boolean value) {
            addCriterion("scene_installation <>", value, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationGreaterThan(Boolean value) {
            addCriterion("scene_installation >", value, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationGreaterThanOrEqualTo(Boolean value) {
            addCriterion("scene_installation >=", value, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationLessThan(Boolean value) {
            addCriterion("scene_installation <", value, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationLessThanOrEqualTo(Boolean value) {
            addCriterion("scene_installation <=", value, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationIn(List<Boolean> values) {
            addCriterion("scene_installation in", values, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationNotIn(List<Boolean> values) {
            addCriterion("scene_installation not in", values, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationBetween(Boolean value1, Boolean value2) {
            addCriterion("scene_installation between", value1, value2, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andSceneInstallationNotBetween(Boolean value1, Boolean value2) {
            addCriterion("scene_installation not between", value1, value2, "sceneInstallation");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckIsNull() {
            addCriterion("assembly_after_check is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckIsNotNull() {
            addCriterion("assembly_after_check is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckEqualTo(String value) {
            addCriterion("assembly_after_check =", value, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckNotEqualTo(String value) {
            addCriterion("assembly_after_check <>", value, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckGreaterThan(String value) {
            addCriterion("assembly_after_check >", value, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckGreaterThanOrEqualTo(String value) {
            addCriterion("assembly_after_check >=", value, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckLessThan(String value) {
            addCriterion("assembly_after_check <", value, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckLessThanOrEqualTo(String value) {
            addCriterion("assembly_after_check <=", value, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckLike(String value) {
            addCriterion("assembly_after_check like", value, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckNotLike(String value) {
            addCriterion("assembly_after_check not like", value, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckIn(List<String> values) {
            addCriterion("assembly_after_check in", values, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckNotIn(List<String> values) {
            addCriterion("assembly_after_check not in", values, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckBetween(String value1, String value2) {
            addCriterion("assembly_after_check between", value1, value2, "assemblyAfterCheck");
            return (Criteria) this;
        }

        public Criteria andAssemblyAfterCheckNotBetween(String value1, String value2) {
            addCriterion("assembly_after_check not between", value1, value2, "assemblyAfterCheck");
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

        public Criteria andEquinoctialDeliveryIsNull() {
            addCriterion("equinoctial_delivery is null");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryIsNotNull() {
            addCriterion("equinoctial_delivery is not null");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryEqualTo(Boolean value) {
            addCriterion("equinoctial_delivery =", value, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryNotEqualTo(Boolean value) {
            addCriterion("equinoctial_delivery <>", value, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryGreaterThan(Boolean value) {
            addCriterion("equinoctial_delivery >", value, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("equinoctial_delivery >=", value, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryLessThan(Boolean value) {
            addCriterion("equinoctial_delivery <", value, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryLessThanOrEqualTo(Boolean value) {
            addCriterion("equinoctial_delivery <=", value, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryIn(List<Boolean> values) {
            addCriterion("equinoctial_delivery in", values, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryNotIn(List<Boolean> values) {
            addCriterion("equinoctial_delivery not in", values, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryBetween(Boolean value1, Boolean value2) {
            addCriterion("equinoctial_delivery between", value1, value2, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("equinoctial_delivery not between", value1, value2, "equinoctialDelivery");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeIsNull() {
            addCriterion("scene_electricity_time is null");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeIsNotNull() {
            addCriterion("scene_electricity_time is not null");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeEqualTo(String value) {
            addCriterion("scene_electricity_time =", value, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeNotEqualTo(String value) {
            addCriterion("scene_electricity_time <>", value, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeGreaterThan(String value) {
            addCriterion("scene_electricity_time >", value, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeGreaterThanOrEqualTo(String value) {
            addCriterion("scene_electricity_time >=", value, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeLessThan(String value) {
            addCriterion("scene_electricity_time <", value, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeLessThanOrEqualTo(String value) {
            addCriterion("scene_electricity_time <=", value, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeLike(String value) {
            addCriterion("scene_electricity_time like", value, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeNotLike(String value) {
            addCriterion("scene_electricity_time not like", value, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeIn(List<String> values) {
            addCriterion("scene_electricity_time in", values, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeNotIn(List<String> values) {
            addCriterion("scene_electricity_time not in", values, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeBetween(String value1, String value2) {
            addCriterion("scene_electricity_time between", value1, value2, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andSceneElectricityTimeNotBetween(String value1, String value2) {
            addCriterion("scene_electricity_time not between", value1, value2, "sceneElectricityTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeIsNull() {
            addCriterion("floor_complete_time is null");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeIsNotNull() {
            addCriterion("floor_complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeEqualTo(String value) {
            addCriterion("floor_complete_time =", value, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeNotEqualTo(String value) {
            addCriterion("floor_complete_time <>", value, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeGreaterThan(String value) {
            addCriterion("floor_complete_time >", value, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeGreaterThanOrEqualTo(String value) {
            addCriterion("floor_complete_time >=", value, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeLessThan(String value) {
            addCriterion("floor_complete_time <", value, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeLessThanOrEqualTo(String value) {
            addCriterion("floor_complete_time <=", value, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeLike(String value) {
            addCriterion("floor_complete_time like", value, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeNotLike(String value) {
            addCriterion("floor_complete_time not like", value, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeIn(List<String> values) {
            addCriterion("floor_complete_time in", values, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeNotIn(List<String> values) {
            addCriterion("floor_complete_time not in", values, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeBetween(String value1, String value2) {
            addCriterion("floor_complete_time between", value1, value2, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFloorCompleteTimeNotBetween(String value1, String value2) {
            addCriterion("floor_complete_time not between", value1, value2, "floorCompleteTime");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsIsNull() {
            addCriterion("equinoctial_delivery_instructions is null");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsIsNotNull() {
            addCriterion("equinoctial_delivery_instructions is not null");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsEqualTo(String value) {
            addCriterion("equinoctial_delivery_instructions =", value, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsNotEqualTo(String value) {
            addCriterion("equinoctial_delivery_instructions <>", value, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsGreaterThan(String value) {
            addCriterion("equinoctial_delivery_instructions >", value, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsGreaterThanOrEqualTo(String value) {
            addCriterion("equinoctial_delivery_instructions >=", value, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsLessThan(String value) {
            addCriterion("equinoctial_delivery_instructions <", value, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsLessThanOrEqualTo(String value) {
            addCriterion("equinoctial_delivery_instructions <=", value, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsLike(String value) {
            addCriterion("equinoctial_delivery_instructions like", value, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsNotLike(String value) {
            addCriterion("equinoctial_delivery_instructions not like", value, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsIn(List<String> values) {
            addCriterion("equinoctial_delivery_instructions in", values, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsNotIn(List<String> values) {
            addCriterion("equinoctial_delivery_instructions not in", values, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsBetween(String value1, String value2) {
            addCriterion("equinoctial_delivery_instructions between", value1, value2, "equinoctialDeliveryInstructions");
            return (Criteria) this;
        }

        public Criteria andEquinoctialDeliveryInstructionsNotBetween(String value1, String value2) {
            addCriterion("equinoctial_delivery_instructions not between", value1, value2, "equinoctialDeliveryInstructions");
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

        public Criteria andAssemblyWayContent1IsNull() {
            addCriterion("assembly_way_content1 is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1IsNotNull() {
            addCriterion("assembly_way_content1 is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1EqualTo(String value) {
            addCriterion("assembly_way_content1 =", value, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1NotEqualTo(String value) {
            addCriterion("assembly_way_content1 <>", value, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1GreaterThan(String value) {
            addCriterion("assembly_way_content1 >", value, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1GreaterThanOrEqualTo(String value) {
            addCriterion("assembly_way_content1 >=", value, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1LessThan(String value) {
            addCriterion("assembly_way_content1 <", value, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1LessThanOrEqualTo(String value) {
            addCriterion("assembly_way_content1 <=", value, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1Like(String value) {
            addCriterion("assembly_way_content1 like", value, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1NotLike(String value) {
            addCriterion("assembly_way_content1 not like", value, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1In(List<String> values) {
            addCriterion("assembly_way_content1 in", values, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1NotIn(List<String> values) {
            addCriterion("assembly_way_content1 not in", values, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1Between(String value1, String value2) {
            addCriterion("assembly_way_content1 between", value1, value2, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent1NotBetween(String value1, String value2) {
            addCriterion("assembly_way_content1 not between", value1, value2, "assemblyWayContent1");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2IsNull() {
            addCriterion("assembly_way_content2 is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2IsNotNull() {
            addCriterion("assembly_way_content2 is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2EqualTo(String value) {
            addCriterion("assembly_way_content2 =", value, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2NotEqualTo(String value) {
            addCriterion("assembly_way_content2 <>", value, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2GreaterThan(String value) {
            addCriterion("assembly_way_content2 >", value, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2GreaterThanOrEqualTo(String value) {
            addCriterion("assembly_way_content2 >=", value, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2LessThan(String value) {
            addCriterion("assembly_way_content2 <", value, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2LessThanOrEqualTo(String value) {
            addCriterion("assembly_way_content2 <=", value, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2Like(String value) {
            addCriterion("assembly_way_content2 like", value, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2NotLike(String value) {
            addCriterion("assembly_way_content2 not like", value, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2In(List<String> values) {
            addCriterion("assembly_way_content2 in", values, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2NotIn(List<String> values) {
            addCriterion("assembly_way_content2 not in", values, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2Between(String value1, String value2) {
            addCriterion("assembly_way_content2 between", value1, value2, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent2NotBetween(String value1, String value2) {
            addCriterion("assembly_way_content2 not between", value1, value2, "assemblyWayContent2");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3IsNull() {
            addCriterion("assembly_way_content3 is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3IsNotNull() {
            addCriterion("assembly_way_content3 is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3EqualTo(String value) {
            addCriterion("assembly_way_content3 =", value, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3NotEqualTo(String value) {
            addCriterion("assembly_way_content3 <>", value, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3GreaterThan(String value) {
            addCriterion("assembly_way_content3 >", value, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3GreaterThanOrEqualTo(String value) {
            addCriterion("assembly_way_content3 >=", value, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3LessThan(String value) {
            addCriterion("assembly_way_content3 <", value, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3LessThanOrEqualTo(String value) {
            addCriterion("assembly_way_content3 <=", value, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3Like(String value) {
            addCriterion("assembly_way_content3 like", value, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3NotLike(String value) {
            addCriterion("assembly_way_content3 not like", value, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3In(List<String> values) {
            addCriterion("assembly_way_content3 in", values, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3NotIn(List<String> values) {
            addCriterion("assembly_way_content3 not in", values, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3Between(String value1, String value2) {
            addCriterion("assembly_way_content3 between", value1, value2, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andAssemblyWayContent3NotBetween(String value1, String value2) {
            addCriterion("assembly_way_content3 not between", value1, value2, "assemblyWayContent3");
            return (Criteria) this;
        }

        public Criteria andPartsWayIsNull() {
            addCriterion("parts_way is null");
            return (Criteria) this;
        }

        public Criteria andPartsWayIsNotNull() {
            addCriterion("parts_way is not null");
            return (Criteria) this;
        }

        public Criteria andPartsWayEqualTo(String value) {
            addCriterion("parts_way =", value, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayNotEqualTo(String value) {
            addCriterion("parts_way <>", value, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayGreaterThan(String value) {
            addCriterion("parts_way >", value, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayGreaterThanOrEqualTo(String value) {
            addCriterion("parts_way >=", value, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayLessThan(String value) {
            addCriterion("parts_way <", value, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayLessThanOrEqualTo(String value) {
            addCriterion("parts_way <=", value, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayLike(String value) {
            addCriterion("parts_way like", value, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayNotLike(String value) {
            addCriterion("parts_way not like", value, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayIn(List<String> values) {
            addCriterion("parts_way in", values, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayNotIn(List<String> values) {
            addCriterion("parts_way not in", values, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayBetween(String value1, String value2) {
            addCriterion("parts_way between", value1, value2, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayNotBetween(String value1, String value2) {
            addCriterion("parts_way not between", value1, value2, "partsWay");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1IsNull() {
            addCriterion("parts_way_content1 is null");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1IsNotNull() {
            addCriterion("parts_way_content1 is not null");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1EqualTo(String value) {
            addCriterion("parts_way_content1 =", value, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1NotEqualTo(String value) {
            addCriterion("parts_way_content1 <>", value, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1GreaterThan(String value) {
            addCriterion("parts_way_content1 >", value, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1GreaterThanOrEqualTo(String value) {
            addCriterion("parts_way_content1 >=", value, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1LessThan(String value) {
            addCriterion("parts_way_content1 <", value, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1LessThanOrEqualTo(String value) {
            addCriterion("parts_way_content1 <=", value, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1Like(String value) {
            addCriterion("parts_way_content1 like", value, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1NotLike(String value) {
            addCriterion("parts_way_content1 not like", value, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1In(List<String> values) {
            addCriterion("parts_way_content1 in", values, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1NotIn(List<String> values) {
            addCriterion("parts_way_content1 not in", values, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1Between(String value1, String value2) {
            addCriterion("parts_way_content1 between", value1, value2, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent1NotBetween(String value1, String value2) {
            addCriterion("parts_way_content1 not between", value1, value2, "partsWayContent1");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2IsNull() {
            addCriterion("parts_way_content2 is null");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2IsNotNull() {
            addCriterion("parts_way_content2 is not null");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2EqualTo(String value) {
            addCriterion("parts_way_content2 =", value, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2NotEqualTo(String value) {
            addCriterion("parts_way_content2 <>", value, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2GreaterThan(String value) {
            addCriterion("parts_way_content2 >", value, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2GreaterThanOrEqualTo(String value) {
            addCriterion("parts_way_content2 >=", value, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2LessThan(String value) {
            addCriterion("parts_way_content2 <", value, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2LessThanOrEqualTo(String value) {
            addCriterion("parts_way_content2 <=", value, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2Like(String value) {
            addCriterion("parts_way_content2 like", value, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2NotLike(String value) {
            addCriterion("parts_way_content2 not like", value, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2In(List<String> values) {
            addCriterion("parts_way_content2 in", values, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2NotIn(List<String> values) {
            addCriterion("parts_way_content2 not in", values, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2Between(String value1, String value2) {
            addCriterion("parts_way_content2 between", value1, value2, "partsWayContent2");
            return (Criteria) this;
        }

        public Criteria andPartsWayContent2NotBetween(String value1, String value2) {
            addCriterion("parts_way_content2 not between", value1, value2, "partsWayContent2");
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

        public Criteria andAttachmentCadIsNull() {
            addCriterion("attachment_cad is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadIsNotNull() {
            addCriterion("attachment_cad is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadEqualTo(String value) {
            addCriterion("attachment_cad =", value, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadNotEqualTo(String value) {
            addCriterion("attachment_cad <>", value, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadGreaterThan(String value) {
            addCriterion("attachment_cad >", value, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_cad >=", value, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadLessThan(String value) {
            addCriterion("attachment_cad <", value, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadLessThanOrEqualTo(String value) {
            addCriterion("attachment_cad <=", value, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadLike(String value) {
            addCriterion("attachment_cad like", value, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadNotLike(String value) {
            addCriterion("attachment_cad not like", value, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadIn(List<String> values) {
            addCriterion("attachment_cad in", values, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadNotIn(List<String> values) {
            addCriterion("attachment_cad not in", values, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadBetween(String value1, String value2) {
            addCriterion("attachment_cad between", value1, value2, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andAttachmentCadNotBetween(String value1, String value2) {
            addCriterion("attachment_cad not between", value1, value2, "attachmentCad");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataIsNull() {
            addCriterion("sale_owe_data is null");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataIsNotNull() {
            addCriterion("sale_owe_data is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataEqualTo(String value) {
            addCriterion("sale_owe_data =", value, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataNotEqualTo(String value) {
            addCriterion("sale_owe_data <>", value, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataGreaterThan(String value) {
            addCriterion("sale_owe_data >", value, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataGreaterThanOrEqualTo(String value) {
            addCriterion("sale_owe_data >=", value, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataLessThan(String value) {
            addCriterion("sale_owe_data <", value, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataLessThanOrEqualTo(String value) {
            addCriterion("sale_owe_data <=", value, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataLike(String value) {
            addCriterion("sale_owe_data like", value, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataNotLike(String value) {
            addCriterion("sale_owe_data not like", value, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataIn(List<String> values) {
            addCriterion("sale_owe_data in", values, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataNotIn(List<String> values) {
            addCriterion("sale_owe_data not in", values, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataBetween(String value1, String value2) {
            addCriterion("sale_owe_data between", value1, value2, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andSaleOweDataNotBetween(String value1, String value2) {
            addCriterion("sale_owe_data not between", value1, value2, "saleOweData");
            return (Criteria) this;
        }

        public Criteria andEngLeaderIsNull() {
            addCriterion("eng_leader is null");
            return (Criteria) this;
        }

        public Criteria andEngLeaderIsNotNull() {
            addCriterion("eng_leader is not null");
            return (Criteria) this;
        }

        public Criteria andEngLeaderEqualTo(String value) {
            addCriterion("eng_leader =", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderNotEqualTo(String value) {
            addCriterion("eng_leader <>", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderGreaterThan(String value) {
            addCriterion("eng_leader >", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("eng_leader >=", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderLessThan(String value) {
            addCriterion("eng_leader <", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderLessThanOrEqualTo(String value) {
            addCriterion("eng_leader <=", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderLike(String value) {
            addCriterion("eng_leader like", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderNotLike(String value) {
            addCriterion("eng_leader not like", value, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderIn(List<String> values) {
            addCriterion("eng_leader in", values, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderNotIn(List<String> values) {
            addCriterion("eng_leader not in", values, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderBetween(String value1, String value2) {
            addCriterion("eng_leader between", value1, value2, "engLeader");
            return (Criteria) this;
        }

        public Criteria andEngLeaderNotBetween(String value1, String value2) {
            addCriterion("eng_leader not between", value1, value2, "engLeader");
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

        public Criteria andSalReviewerIdIsNull() {
            addCriterion("sal_reviewer_id is null");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdIsNotNull() {
            addCriterion("sal_reviewer_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdEqualTo(String value) {
            addCriterion("sal_reviewer_id =", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdNotEqualTo(String value) {
            addCriterion("sal_reviewer_id <>", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdGreaterThan(String value) {
            addCriterion("sal_reviewer_id >", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdGreaterThanOrEqualTo(String value) {
            addCriterion("sal_reviewer_id >=", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdLessThan(String value) {
            addCriterion("sal_reviewer_id <", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdLessThanOrEqualTo(String value) {
            addCriterion("sal_reviewer_id <=", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdLike(String value) {
            addCriterion("sal_reviewer_id like", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdNotLike(String value) {
            addCriterion("sal_reviewer_id not like", value, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdIn(List<String> values) {
            addCriterion("sal_reviewer_id in", values, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdNotIn(List<String> values) {
            addCriterion("sal_reviewer_id not in", values, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdBetween(String value1, String value2) {
            addCriterion("sal_reviewer_id between", value1, value2, "salReviewerId");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIdNotBetween(String value1, String value2) {
            addCriterion("sal_reviewer_id not between", value1, value2, "salReviewerId");
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