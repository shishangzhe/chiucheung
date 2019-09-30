package cn.chiucheung.po.sales.reviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SalReviewerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalReviewerExample() {
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

        public Criteria andInfoRecordNumberIsNull() {
            addCriterion("info_record_number is null");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberIsNotNull() {
            addCriterion("info_record_number is not null");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberEqualTo(Integer value) {
            addCriterion("info_record_number =", value, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberNotEqualTo(Integer value) {
            addCriterion("info_record_number <>", value, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberGreaterThan(Integer value) {
            addCriterion("info_record_number >", value, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_record_number >=", value, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberLessThan(Integer value) {
            addCriterion("info_record_number <", value, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberLessThanOrEqualTo(Integer value) {
            addCriterion("info_record_number <=", value, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberIn(List<Integer> values) {
            addCriterion("info_record_number in", values, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberNotIn(List<Integer> values) {
            addCriterion("info_record_number not in", values, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberBetween(Integer value1, Integer value2) {
            addCriterion("info_record_number between", value1, value2, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andInfoRecordNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("info_record_number not between", value1, value2, "infoRecordNumber");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andOtherProjectIsNull() {
            addCriterion("other_project is null");
            return (Criteria) this;
        }

        public Criteria andOtherProjectIsNotNull() {
            addCriterion("other_project is not null");
            return (Criteria) this;
        }

        public Criteria andOtherProjectEqualTo(String value) {
            addCriterion("other_project =", value, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectNotEqualTo(String value) {
            addCriterion("other_project <>", value, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectGreaterThan(String value) {
            addCriterion("other_project >", value, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectGreaterThanOrEqualTo(String value) {
            addCriterion("other_project >=", value, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectLessThan(String value) {
            addCriterion("other_project <", value, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectLessThanOrEqualTo(String value) {
            addCriterion("other_project <=", value, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectLike(String value) {
            addCriterion("other_project like", value, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectNotLike(String value) {
            addCriterion("other_project not like", value, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectIn(List<String> values) {
            addCriterion("other_project in", values, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectNotIn(List<String> values) {
            addCriterion("other_project not in", values, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectBetween(String value1, String value2) {
            addCriterion("other_project between", value1, value2, "otherProject");
            return (Criteria) this;
        }

        public Criteria andOtherProjectNotBetween(String value1, String value2) {
            addCriterion("other_project not between", value1, value2, "otherProject");
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

        public Criteria andOtherPackagingIsNull() {
            addCriterion("other_packaging is null");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingIsNotNull() {
            addCriterion("other_packaging is not null");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingEqualTo(String value) {
            addCriterion("other_packaging =", value, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingNotEqualTo(String value) {
            addCriterion("other_packaging <>", value, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingGreaterThan(String value) {
            addCriterion("other_packaging >", value, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingGreaterThanOrEqualTo(String value) {
            addCriterion("other_packaging >=", value, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingLessThan(String value) {
            addCriterion("other_packaging <", value, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingLessThanOrEqualTo(String value) {
            addCriterion("other_packaging <=", value, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingLike(String value) {
            addCriterion("other_packaging like", value, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingNotLike(String value) {
            addCriterion("other_packaging not like", value, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingIn(List<String> values) {
            addCriterion("other_packaging in", values, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingNotIn(List<String> values) {
            addCriterion("other_packaging not in", values, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingBetween(String value1, String value2) {
            addCriterion("other_packaging between", value1, value2, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andOtherPackagingNotBetween(String value1, String value2) {
            addCriterion("other_packaging not between", value1, value2, "otherPackaging");
            return (Criteria) this;
        }

        public Criteria andDeliveryIsNull() {
            addCriterion("delivery is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIsNotNull() {
            addCriterion("delivery is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryEqualTo(String value) {
            addCriterion("delivery =", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotEqualTo(String value) {
            addCriterion("delivery <>", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThan(String value) {
            addCriterion("delivery >", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThanOrEqualTo(String value) {
            addCriterion("delivery >=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThan(String value) {
            addCriterion("delivery <", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThanOrEqualTo(String value) {
            addCriterion("delivery <=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLike(String value) {
            addCriterion("delivery like", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotLike(String value) {
            addCriterion("delivery not like", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryIn(List<String> values) {
            addCriterion("delivery in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotIn(List<String> values) {
            addCriterion("delivery not in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryBetween(String value1, String value2) {
            addCriterion("delivery between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotBetween(String value1, String value2) {
            addCriterion("delivery not between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryIsNull() {
            addCriterion("other_delivery is null");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryIsNotNull() {
            addCriterion("other_delivery is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryEqualTo(String value) {
            addCriterion("other_delivery =", value, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryNotEqualTo(String value) {
            addCriterion("other_delivery <>", value, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryGreaterThan(String value) {
            addCriterion("other_delivery >", value, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryGreaterThanOrEqualTo(String value) {
            addCriterion("other_delivery >=", value, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryLessThan(String value) {
            addCriterion("other_delivery <", value, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryLessThanOrEqualTo(String value) {
            addCriterion("other_delivery <=", value, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryLike(String value) {
            addCriterion("other_delivery like", value, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryNotLike(String value) {
            addCriterion("other_delivery not like", value, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryIn(List<String> values) {
            addCriterion("other_delivery in", values, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryNotIn(List<String> values) {
            addCriterion("other_delivery not in", values, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryBetween(String value1, String value2) {
            addCriterion("other_delivery between", value1, value2, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andOtherDeliveryNotBetween(String value1, String value2) {
            addCriterion("other_delivery not between", value1, value2, "otherDelivery");
            return (Criteria) this;
        }

        public Criteria andSalPreparerIsNull() {
            addCriterion("sal_preparer is null");
            return (Criteria) this;
        }

        public Criteria andSalPreparerIsNotNull() {
            addCriterion("sal_preparer is not null");
            return (Criteria) this;
        }

        public Criteria andSalPreparerEqualTo(String value) {
            addCriterion("sal_preparer =", value, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerNotEqualTo(String value) {
            addCriterion("sal_preparer <>", value, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerGreaterThan(String value) {
            addCriterion("sal_preparer >", value, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerGreaterThanOrEqualTo(String value) {
            addCriterion("sal_preparer >=", value, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerLessThan(String value) {
            addCriterion("sal_preparer <", value, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerLessThanOrEqualTo(String value) {
            addCriterion("sal_preparer <=", value, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerLike(String value) {
            addCriterion("sal_preparer like", value, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerNotLike(String value) {
            addCriterion("sal_preparer not like", value, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerIn(List<String> values) {
            addCriterion("sal_preparer in", values, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerNotIn(List<String> values) {
            addCriterion("sal_preparer not in", values, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerBetween(String value1, String value2) {
            addCriterion("sal_preparer between", value1, value2, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andSalPreparerNotBetween(String value1, String value2) {
            addCriterion("sal_preparer not between", value1, value2, "salPreparer");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("destination like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("destination not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("destination not between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andIsInstallIsNull() {
            addCriterion("is_install is null");
            return (Criteria) this;
        }

        public Criteria andIsInstallIsNotNull() {
            addCriterion("is_install is not null");
            return (Criteria) this;
        }

        public Criteria andIsInstallEqualTo(Boolean value) {
            addCriterion("is_install =", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallNotEqualTo(Boolean value) {
            addCriterion("is_install <>", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallGreaterThan(Boolean value) {
            addCriterion("is_install >", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_install >=", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallLessThan(Boolean value) {
            addCriterion("is_install <", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallLessThanOrEqualTo(Boolean value) {
            addCriterion("is_install <=", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallIn(List<Boolean> values) {
            addCriterion("is_install in", values, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallNotIn(List<Boolean> values) {
            addCriterion("is_install not in", values, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallBetween(Boolean value1, Boolean value2) {
            addCriterion("is_install between", value1, value2, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_install not between", value1, value2, "isInstall");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateIsNull() {
            addCriterion("expected_layout_date is null");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateIsNotNull() {
            addCriterion("expected_layout_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateEqualTo(Date value) {
            addCriterionForJDBCDate("expected_layout_date =", value, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expected_layout_date <>", value, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateGreaterThan(Date value) {
            addCriterionForJDBCDate("expected_layout_date >", value, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expected_layout_date >=", value, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateLessThan(Date value) {
            addCriterionForJDBCDate("expected_layout_date <", value, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expected_layout_date <=", value, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateIn(List<Date> values) {
            addCriterionForJDBCDate("expected_layout_date in", values, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expected_layout_date not in", values, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expected_layout_date between", value1, value2, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andExpectedLayoutDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expected_layout_date not between", value1, value2, "expectedLayoutDate");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNull() {
            addCriterion("project_leader is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNotNull() {
            addCriterion("project_leader is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEqualTo(String value) {
            addCriterion("project_leader =", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotEqualTo(String value) {
            addCriterion("project_leader <>", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThan(String value) {
            addCriterion("project_leader >", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("project_leader >=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThan(String value) {
            addCriterion("project_leader <", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThanOrEqualTo(String value) {
            addCriterion("project_leader <=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLike(String value) {
            addCriterion("project_leader like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotLike(String value) {
            addCriterion("project_leader not like", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIn(List<String> values) {
            addCriterion("project_leader in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotIn(List<String> values) {
            addCriterion("project_leader not in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderBetween(String value1, String value2) {
            addCriterion("project_leader between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotBetween(String value1, String value2) {
            addCriterion("project_leader not between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andImportanceIsNull() {
            addCriterion("importance is null");
            return (Criteria) this;
        }

        public Criteria andImportanceIsNotNull() {
            addCriterion("importance is not null");
            return (Criteria) this;
        }

        public Criteria andImportanceEqualTo(String value) {
            addCriterion("importance =", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceNotEqualTo(String value) {
            addCriterion("importance <>", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceGreaterThan(String value) {
            addCriterion("importance >", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceGreaterThanOrEqualTo(String value) {
            addCriterion("importance >=", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceLessThan(String value) {
            addCriterion("importance <", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceLessThanOrEqualTo(String value) {
            addCriterion("importance <=", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceLike(String value) {
            addCriterion("importance like", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceNotLike(String value) {
            addCriterion("importance not like", value, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceIn(List<String> values) {
            addCriterion("importance in", values, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceNotIn(List<String> values) {
            addCriterion("importance not in", values, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceBetween(String value1, String value2) {
            addCriterion("importance between", value1, value2, "importance");
            return (Criteria) this;
        }

        public Criteria andImportanceNotBetween(String value1, String value2) {
            addCriterion("importance not between", value1, value2, "importance");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateIsNull() {
            addCriterion("contract_delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateIsNotNull() {
            addCriterion("contract_delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateEqualTo(String value) {
            addCriterion("contract_delivery_date =", value, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateNotEqualTo(String value) {
            addCriterion("contract_delivery_date <>", value, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateGreaterThan(String value) {
            addCriterion("contract_delivery_date >", value, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateGreaterThanOrEqualTo(String value) {
            addCriterion("contract_delivery_date >=", value, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateLessThan(String value) {
            addCriterion("contract_delivery_date <", value, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateLessThanOrEqualTo(String value) {
            addCriterion("contract_delivery_date <=", value, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateLike(String value) {
            addCriterion("contract_delivery_date like", value, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateNotLike(String value) {
            addCriterion("contract_delivery_date not like", value, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateIn(List<String> values) {
            addCriterion("contract_delivery_date in", values, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateNotIn(List<String> values) {
            addCriterion("contract_delivery_date not in", values, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateBetween(String value1, String value2) {
            addCriterion("contract_delivery_date between", value1, value2, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andContractDeliveryDateNotBetween(String value1, String value2) {
            addCriterion("contract_delivery_date not between", value1, value2, "contractDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIsNull() {
            addCriterion("sal_reviewer is null");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIsNotNull() {
            addCriterion("sal_reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andSalReviewerEqualTo(String value) {
            addCriterion("sal_reviewer =", value, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerNotEqualTo(String value) {
            addCriterion("sal_reviewer <>", value, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerGreaterThan(String value) {
            addCriterion("sal_reviewer >", value, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerGreaterThanOrEqualTo(String value) {
            addCriterion("sal_reviewer >=", value, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerLessThan(String value) {
            addCriterion("sal_reviewer <", value, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerLessThanOrEqualTo(String value) {
            addCriterion("sal_reviewer <=", value, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerLike(String value) {
            addCriterion("sal_reviewer like", value, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerNotLike(String value) {
            addCriterion("sal_reviewer not like", value, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerIn(List<String> values) {
            addCriterion("sal_reviewer in", values, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerNotIn(List<String> values) {
            addCriterion("sal_reviewer not in", values, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerBetween(String value1, String value2) {
            addCriterion("sal_reviewer between", value1, value2, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andSalReviewerNotBetween(String value1, String value2) {
            addCriterion("sal_reviewer not between", value1, value2, "salReviewer");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectIsNull() {
            addCriterion("required_cost_of_project is null");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectIsNotNull() {
            addCriterion("required_cost_of_project is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectEqualTo(String value) {
            addCriterion("required_cost_of_project =", value, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectNotEqualTo(String value) {
            addCriterion("required_cost_of_project <>", value, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectGreaterThan(String value) {
            addCriterion("required_cost_of_project >", value, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectGreaterThanOrEqualTo(String value) {
            addCriterion("required_cost_of_project >=", value, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectLessThan(String value) {
            addCriterion("required_cost_of_project <", value, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectLessThanOrEqualTo(String value) {
            addCriterion("required_cost_of_project <=", value, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectLike(String value) {
            addCriterion("required_cost_of_project like", value, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectNotLike(String value) {
            addCriterion("required_cost_of_project not like", value, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectIn(List<String> values) {
            addCriterion("required_cost_of_project in", values, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectNotIn(List<String> values) {
            addCriterion("required_cost_of_project not in", values, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectBetween(String value1, String value2) {
            addCriterion("required_cost_of_project between", value1, value2, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCostOfProjectNotBetween(String value1, String value2) {
            addCriterion("required_cost_of_project not between", value1, value2, "requiredCostOfProject");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateIsNull() {
            addCriterion("required_completion_date is null");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateIsNotNull() {
            addCriterion("required_completion_date is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateEqualTo(Date value) {
            addCriterionForJDBCDate("required_completion_date =", value, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("required_completion_date <>", value, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("required_completion_date >", value, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("required_completion_date >=", value, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateLessThan(Date value) {
            addCriterionForJDBCDate("required_completion_date <", value, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("required_completion_date <=", value, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateIn(List<Date> values) {
            addCriterionForJDBCDate("required_completion_date in", values, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("required_completion_date not in", values, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("required_completion_date between", value1, value2, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andRequiredCompletionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("required_completion_date not between", value1, value2, "requiredCompletionDate");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentIsNull() {
            addCriterion("about_department is null");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentIsNotNull() {
            addCriterion("about_department is not null");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentEqualTo(String value) {
            addCriterion("about_department =", value, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentNotEqualTo(String value) {
            addCriterion("about_department <>", value, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentGreaterThan(String value) {
            addCriterion("about_department >", value, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("about_department >=", value, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentLessThan(String value) {
            addCriterion("about_department <", value, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentLessThanOrEqualTo(String value) {
            addCriterion("about_department <=", value, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentLike(String value) {
            addCriterion("about_department like", value, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentNotLike(String value) {
            addCriterion("about_department not like", value, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentIn(List<String> values) {
            addCriterion("about_department in", values, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentNotIn(List<String> values) {
            addCriterion("about_department not in", values, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentBetween(String value1, String value2) {
            addCriterion("about_department between", value1, value2, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andAboutDepartmentNotBetween(String value1, String value2) {
            addCriterion("about_department not between", value1, value2, "aboutDepartment");
            return (Criteria) this;
        }

        public Criteria andDevelopIsNull() {
            addCriterion("develop is null");
            return (Criteria) this;
        }

        public Criteria andDevelopIsNotNull() {
            addCriterion("develop is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopEqualTo(String value) {
            addCriterion("develop =", value, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopNotEqualTo(String value) {
            addCriterion("develop <>", value, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopGreaterThan(String value) {
            addCriterion("develop >", value, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopGreaterThanOrEqualTo(String value) {
            addCriterion("develop >=", value, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopLessThan(String value) {
            addCriterion("develop <", value, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopLessThanOrEqualTo(String value) {
            addCriterion("develop <=", value, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopLike(String value) {
            addCriterion("develop like", value, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopNotLike(String value) {
            addCriterion("develop not like", value, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopIn(List<String> values) {
            addCriterion("develop in", values, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopNotIn(List<String> values) {
            addCriterion("develop not in", values, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopBetween(String value1, String value2) {
            addCriterion("develop between", value1, value2, "develop");
            return (Criteria) this;
        }

        public Criteria andDevelopNotBetween(String value1, String value2) {
            addCriterion("develop not between", value1, value2, "develop");
            return (Criteria) this;
        }

        public Criteria andArrangeIsNull() {
            addCriterion("arrange is null");
            return (Criteria) this;
        }

        public Criteria andArrangeIsNotNull() {
            addCriterion("arrange is not null");
            return (Criteria) this;
        }

        public Criteria andArrangeEqualTo(String value) {
            addCriterion("arrange =", value, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeNotEqualTo(String value) {
            addCriterion("arrange <>", value, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeGreaterThan(String value) {
            addCriterion("arrange >", value, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeGreaterThanOrEqualTo(String value) {
            addCriterion("arrange >=", value, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeLessThan(String value) {
            addCriterion("arrange <", value, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeLessThanOrEqualTo(String value) {
            addCriterion("arrange <=", value, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeLike(String value) {
            addCriterion("arrange like", value, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeNotLike(String value) {
            addCriterion("arrange not like", value, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeIn(List<String> values) {
            addCriterion("arrange in", values, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeNotIn(List<String> values) {
            addCriterion("arrange not in", values, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeBetween(String value1, String value2) {
            addCriterion("arrange between", value1, value2, "arrange");
            return (Criteria) this;
        }

        public Criteria andArrangeNotBetween(String value1, String value2) {
            addCriterion("arrange not between", value1, value2, "arrange");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialIsNull() {
            addCriterion("special_material is null");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialIsNotNull() {
            addCriterion("special_material is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialEqualTo(String value) {
            addCriterion("special_material =", value, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialNotEqualTo(String value) {
            addCriterion("special_material <>", value, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialGreaterThan(String value) {
            addCriterion("special_material >", value, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("special_material >=", value, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialLessThan(String value) {
            addCriterion("special_material <", value, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialLessThanOrEqualTo(String value) {
            addCriterion("special_material <=", value, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialLike(String value) {
            addCriterion("special_material like", value, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialNotLike(String value) {
            addCriterion("special_material not like", value, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialIn(List<String> values) {
            addCriterion("special_material in", values, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialNotIn(List<String> values) {
            addCriterion("special_material not in", values, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialBetween(String value1, String value2) {
            addCriterion("special_material between", value1, value2, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andSpecialMaterialNotBetween(String value1, String value2) {
            addCriterion("special_material not between", value1, value2, "specialMaterial");
            return (Criteria) this;
        }

        public Criteria andEngReviewerIsNull() {
            addCriterion("eng_reviewer is null");
            return (Criteria) this;
        }

        public Criteria andEngReviewerIsNotNull() {
            addCriterion("eng_reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andEngReviewerEqualTo(String value) {
            addCriterion("eng_reviewer =", value, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerNotEqualTo(String value) {
            addCriterion("eng_reviewer <>", value, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerGreaterThan(String value) {
            addCriterion("eng_reviewer >", value, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerGreaterThanOrEqualTo(String value) {
            addCriterion("eng_reviewer >=", value, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerLessThan(String value) {
            addCriterion("eng_reviewer <", value, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerLessThanOrEqualTo(String value) {
            addCriterion("eng_reviewer <=", value, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerLike(String value) {
            addCriterion("eng_reviewer like", value, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerNotLike(String value) {
            addCriterion("eng_reviewer not like", value, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerIn(List<String> values) {
            addCriterion("eng_reviewer in", values, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerNotIn(List<String> values) {
            addCriterion("eng_reviewer not in", values, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerBetween(String value1, String value2) {
            addCriterion("eng_reviewer between", value1, value2, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerNotBetween(String value1, String value2) {
            addCriterion("eng_reviewer not between", value1, value2, "engReviewer");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateIsNull() {
            addCriterion("eng_reviewer_date is null");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateIsNotNull() {
            addCriterion("eng_reviewer_date is not null");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateEqualTo(Date value) {
            addCriterionForJDBCDate("eng_reviewer_date =", value, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("eng_reviewer_date <>", value, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateGreaterThan(Date value) {
            addCriterionForJDBCDate("eng_reviewer_date >", value, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_reviewer_date >=", value, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateLessThan(Date value) {
            addCriterionForJDBCDate("eng_reviewer_date <", value, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eng_reviewer_date <=", value, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateIn(List<Date> values) {
            addCriterionForJDBCDate("eng_reviewer_date in", values, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("eng_reviewer_date not in", values, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_reviewer_date between", value1, value2, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andEngReviewerDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eng_reviewer_date not between", value1, value2, "engReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurPeriodIsNull() {
            addCriterion("pur_period is null");
            return (Criteria) this;
        }

        public Criteria andPurPeriodIsNotNull() {
            addCriterion("pur_period is not null");
            return (Criteria) this;
        }

        public Criteria andPurPeriodEqualTo(String value) {
            addCriterion("pur_period =", value, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodNotEqualTo(String value) {
            addCriterion("pur_period <>", value, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodGreaterThan(String value) {
            addCriterion("pur_period >", value, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("pur_period >=", value, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodLessThan(String value) {
            addCriterion("pur_period <", value, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodLessThanOrEqualTo(String value) {
            addCriterion("pur_period <=", value, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodLike(String value) {
            addCriterion("pur_period like", value, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodNotLike(String value) {
            addCriterion("pur_period not like", value, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodIn(List<String> values) {
            addCriterion("pur_period in", values, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodNotIn(List<String> values) {
            addCriterion("pur_period not in", values, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodBetween(String value1, String value2) {
            addCriterion("pur_period between", value1, value2, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurPeriodNotBetween(String value1, String value2) {
            addCriterion("pur_period not between", value1, value2, "purPeriod");
            return (Criteria) this;
        }

        public Criteria andPurReviewerIsNull() {
            addCriterion("pur_reviewer is null");
            return (Criteria) this;
        }

        public Criteria andPurReviewerIsNotNull() {
            addCriterion("pur_reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andPurReviewerEqualTo(String value) {
            addCriterion("pur_reviewer =", value, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerNotEqualTo(String value) {
            addCriterion("pur_reviewer <>", value, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerGreaterThan(String value) {
            addCriterion("pur_reviewer >", value, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerGreaterThanOrEqualTo(String value) {
            addCriterion("pur_reviewer >=", value, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerLessThan(String value) {
            addCriterion("pur_reviewer <", value, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerLessThanOrEqualTo(String value) {
            addCriterion("pur_reviewer <=", value, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerLike(String value) {
            addCriterion("pur_reviewer like", value, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerNotLike(String value) {
            addCriterion("pur_reviewer not like", value, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerIn(List<String> values) {
            addCriterion("pur_reviewer in", values, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerNotIn(List<String> values) {
            addCriterion("pur_reviewer not in", values, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerBetween(String value1, String value2) {
            addCriterion("pur_reviewer between", value1, value2, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerNotBetween(String value1, String value2) {
            addCriterion("pur_reviewer not between", value1, value2, "purReviewer");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateIsNull() {
            addCriterion("pur_reviewer_date is null");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateIsNotNull() {
            addCriterion("pur_reviewer_date is not null");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateEqualTo(Date value) {
            addCriterionForJDBCDate("pur_reviewer_date =", value, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pur_reviewer_date <>", value, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pur_reviewer_date >", value, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pur_reviewer_date >=", value, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateLessThan(Date value) {
            addCriterionForJDBCDate("pur_reviewer_date <", value, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pur_reviewer_date <=", value, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateIn(List<Date> values) {
            addCriterionForJDBCDate("pur_reviewer_date in", values, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pur_reviewer_date not in", values, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pur_reviewer_date between", value1, value2, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andPurReviewerDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pur_reviewer_date not between", value1, value2, "purReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeIsNull() {
            addCriterion("pro_expected_shortest_completion_time is null");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeIsNotNull() {
            addCriterion("pro_expected_shortest_completion_time is not null");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeEqualTo(String value) {
            addCriterion("pro_expected_shortest_completion_time =", value, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeNotEqualTo(String value) {
            addCriterion("pro_expected_shortest_completion_time <>", value, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeGreaterThan(String value) {
            addCriterion("pro_expected_shortest_completion_time >", value, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_expected_shortest_completion_time >=", value, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeLessThan(String value) {
            addCriterion("pro_expected_shortest_completion_time <", value, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeLessThanOrEqualTo(String value) {
            addCriterion("pro_expected_shortest_completion_time <=", value, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeLike(String value) {
            addCriterion("pro_expected_shortest_completion_time like", value, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeNotLike(String value) {
            addCriterion("pro_expected_shortest_completion_time not like", value, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeIn(List<String> values) {
            addCriterion("pro_expected_shortest_completion_time in", values, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeNotIn(List<String> values) {
            addCriterion("pro_expected_shortest_completion_time not in", values, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeBetween(String value1, String value2) {
            addCriterion("pro_expected_shortest_completion_time between", value1, value2, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedShortestCompletionTimeNotBetween(String value1, String value2) {
            addCriterion("pro_expected_shortest_completion_time not between", value1, value2, "proExpectedShortestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeIsNull() {
            addCriterion("pro_expected_longest_completion_time is null");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeIsNotNull() {
            addCriterion("pro_expected_longest_completion_time is not null");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeEqualTo(String value) {
            addCriterion("pro_expected_longest_completion_time =", value, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeNotEqualTo(String value) {
            addCriterion("pro_expected_longest_completion_time <>", value, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeGreaterThan(String value) {
            addCriterion("pro_expected_longest_completion_time >", value, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_expected_longest_completion_time >=", value, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeLessThan(String value) {
            addCriterion("pro_expected_longest_completion_time <", value, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeLessThanOrEqualTo(String value) {
            addCriterion("pro_expected_longest_completion_time <=", value, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeLike(String value) {
            addCriterion("pro_expected_longest_completion_time like", value, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeNotLike(String value) {
            addCriterion("pro_expected_longest_completion_time not like", value, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeIn(List<String> values) {
            addCriterion("pro_expected_longest_completion_time in", values, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeNotIn(List<String> values) {
            addCriterion("pro_expected_longest_completion_time not in", values, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeBetween(String value1, String value2) {
            addCriterion("pro_expected_longest_completion_time between", value1, value2, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedLongestCompletionTimeNotBetween(String value1, String value2) {
            addCriterion("pro_expected_longest_completion_time not between", value1, value2, "proExpectedLongestCompletionTime");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberIsNull() {
            addCriterion("install_people_number is null");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberIsNotNull() {
            addCriterion("install_people_number is not null");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberEqualTo(String value) {
            addCriterion("install_people_number =", value, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberNotEqualTo(String value) {
            addCriterion("install_people_number <>", value, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberGreaterThan(String value) {
            addCriterion("install_people_number >", value, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberGreaterThanOrEqualTo(String value) {
            addCriterion("install_people_number >=", value, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberLessThan(String value) {
            addCriterion("install_people_number <", value, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberLessThanOrEqualTo(String value) {
            addCriterion("install_people_number <=", value, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberLike(String value) {
            addCriterion("install_people_number like", value, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberNotLike(String value) {
            addCriterion("install_people_number not like", value, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberIn(List<String> values) {
            addCriterion("install_people_number in", values, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberNotIn(List<String> values) {
            addCriterion("install_people_number not in", values, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberBetween(String value1, String value2) {
            addCriterion("install_people_number between", value1, value2, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeopleNumberNotBetween(String value1, String value2) {
            addCriterion("install_people_number not between", value1, value2, "installPeopleNumber");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodIsNull() {
            addCriterion("install_period is null");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodIsNotNull() {
            addCriterion("install_period is not null");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodEqualTo(String value) {
            addCriterion("install_period =", value, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodNotEqualTo(String value) {
            addCriterion("install_period <>", value, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodGreaterThan(String value) {
            addCriterion("install_period >", value, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("install_period >=", value, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodLessThan(String value) {
            addCriterion("install_period <", value, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodLessThanOrEqualTo(String value) {
            addCriterion("install_period <=", value, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodLike(String value) {
            addCriterion("install_period like", value, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodNotLike(String value) {
            addCriterion("install_period not like", value, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodIn(List<String> values) {
            addCriterion("install_period in", values, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodNotIn(List<String> values) {
            addCriterion("install_period not in", values, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodBetween(String value1, String value2) {
            addCriterion("install_period between", value1, value2, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andInstallPeriodNotBetween(String value1, String value2) {
            addCriterion("install_period not between", value1, value2, "installPeriod");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingIsNull() {
            addCriterion("is_special_processing is null");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingIsNotNull() {
            addCriterion("is_special_processing is not null");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingEqualTo(Boolean value) {
            addCriterion("is_special_processing =", value, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingNotEqualTo(Boolean value) {
            addCriterion("is_special_processing <>", value, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingGreaterThan(Boolean value) {
            addCriterion("is_special_processing >", value, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_special_processing >=", value, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingLessThan(Boolean value) {
            addCriterion("is_special_processing <", value, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingLessThanOrEqualTo(Boolean value) {
            addCriterion("is_special_processing <=", value, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingIn(List<Boolean> values) {
            addCriterion("is_special_processing in", values, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingNotIn(List<Boolean> values) {
            addCriterion("is_special_processing not in", values, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingBetween(Boolean value1, Boolean value2) {
            addCriterion("is_special_processing between", value1, value2, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andIsSpecialProcessingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_special_processing not between", value1, value2, "isSpecialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingIsNull() {
            addCriterion("special_processing is null");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingIsNotNull() {
            addCriterion("special_processing is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingEqualTo(String value) {
            addCriterion("special_processing =", value, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingNotEqualTo(String value) {
            addCriterion("special_processing <>", value, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingGreaterThan(String value) {
            addCriterion("special_processing >", value, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingGreaterThanOrEqualTo(String value) {
            addCriterion("special_processing >=", value, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingLessThan(String value) {
            addCriterion("special_processing <", value, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingLessThanOrEqualTo(String value) {
            addCriterion("special_processing <=", value, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingLike(String value) {
            addCriterion("special_processing like", value, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingNotLike(String value) {
            addCriterion("special_processing not like", value, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingIn(List<String> values) {
            addCriterion("special_processing in", values, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingNotIn(List<String> values) {
            addCriterion("special_processing not in", values, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingBetween(String value1, String value2) {
            addCriterion("special_processing between", value1, value2, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andSpecialProcessingNotBetween(String value1, String value2) {
            addCriterion("special_processing not between", value1, value2, "specialProcessing");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeIsNull() {
            addCriterion("pro_expected_start_time is null");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeIsNotNull() {
            addCriterion("pro_expected_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("pro_expected_start_time =", value, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("pro_expected_start_time <>", value, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("pro_expected_start_time >", value, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_expected_start_time >=", value, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("pro_expected_start_time <", value, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_expected_start_time <=", value, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("pro_expected_start_time in", values, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("pro_expected_start_time not in", values, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_expected_start_time between", value1, value2, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProExpectedStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_expected_start_time not between", value1, value2, "proExpectedStartTime");
            return (Criteria) this;
        }

        public Criteria andProPreparerIsNull() {
            addCriterion("pro_preparer is null");
            return (Criteria) this;
        }

        public Criteria andProPreparerIsNotNull() {
            addCriterion("pro_preparer is not null");
            return (Criteria) this;
        }

        public Criteria andProPreparerEqualTo(String value) {
            addCriterion("pro_preparer =", value, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerNotEqualTo(String value) {
            addCriterion("pro_preparer <>", value, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerGreaterThan(String value) {
            addCriterion("pro_preparer >", value, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerGreaterThanOrEqualTo(String value) {
            addCriterion("pro_preparer >=", value, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerLessThan(String value) {
            addCriterion("pro_preparer <", value, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerLessThanOrEqualTo(String value) {
            addCriterion("pro_preparer <=", value, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerLike(String value) {
            addCriterion("pro_preparer like", value, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerNotLike(String value) {
            addCriterion("pro_preparer not like", value, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerIn(List<String> values) {
            addCriterion("pro_preparer in", values, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerNotIn(List<String> values) {
            addCriterion("pro_preparer not in", values, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerBetween(String value1, String value2) {
            addCriterion("pro_preparer between", value1, value2, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProPreparerNotBetween(String value1, String value2) {
            addCriterion("pro_preparer not between", value1, value2, "proPreparer");
            return (Criteria) this;
        }

        public Criteria andProReviewerIsNull() {
            addCriterion("pro_reviewer is null");
            return (Criteria) this;
        }

        public Criteria andProReviewerIsNotNull() {
            addCriterion("pro_reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andProReviewerEqualTo(String value) {
            addCriterion("pro_reviewer =", value, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerNotEqualTo(String value) {
            addCriterion("pro_reviewer <>", value, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerGreaterThan(String value) {
            addCriterion("pro_reviewer >", value, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerGreaterThanOrEqualTo(String value) {
            addCriterion("pro_reviewer >=", value, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerLessThan(String value) {
            addCriterion("pro_reviewer <", value, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerLessThanOrEqualTo(String value) {
            addCriterion("pro_reviewer <=", value, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerLike(String value) {
            addCriterion("pro_reviewer like", value, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerNotLike(String value) {
            addCriterion("pro_reviewer not like", value, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerIn(List<String> values) {
            addCriterion("pro_reviewer in", values, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerNotIn(List<String> values) {
            addCriterion("pro_reviewer not in", values, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerBetween(String value1, String value2) {
            addCriterion("pro_reviewer between", value1, value2, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerNotBetween(String value1, String value2) {
            addCriterion("pro_reviewer not between", value1, value2, "proReviewer");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateIsNull() {
            addCriterion("pro_reviewer_date is null");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateIsNotNull() {
            addCriterion("pro_reviewer_date is not null");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateEqualTo(Date value) {
            addCriterionForJDBCDate("pro_reviewer_date =", value, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pro_reviewer_date <>", value, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pro_reviewer_date >", value, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_reviewer_date >=", value, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateLessThan(Date value) {
            addCriterionForJDBCDate("pro_reviewer_date <", value, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pro_reviewer_date <=", value, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateIn(List<Date> values) {
            addCriterionForJDBCDate("pro_reviewer_date in", values, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pro_reviewer_date not in", values, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_reviewer_date between", value1, value2, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andProReviewerDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pro_reviewer_date not between", value1, value2, "proReviewerDate");
            return (Criteria) this;
        }

        public Criteria andIsAttachedIsNull() {
            addCriterion("is_attached is null");
            return (Criteria) this;
        }

        public Criteria andIsAttachedIsNotNull() {
            addCriterion("is_attached is not null");
            return (Criteria) this;
        }

        public Criteria andIsAttachedEqualTo(Boolean value) {
            addCriterion("is_attached =", value, "isAttached");
            return (Criteria) this;
        }

        public Criteria andIsAttachedNotEqualTo(Boolean value) {
            addCriterion("is_attached <>", value, "isAttached");
            return (Criteria) this;
        }

        public Criteria andIsAttachedGreaterThan(Boolean value) {
            addCriterion("is_attached >", value, "isAttached");
            return (Criteria) this;
        }

        public Criteria andIsAttachedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_attached >=", value, "isAttached");
            return (Criteria) this;
        }

        public Criteria andIsAttachedLessThan(Boolean value) {
            addCriterion("is_attached <", value, "isAttached");
            return (Criteria) this;
        }

        public Criteria andIsAttachedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_attached <=", value, "isAttached");
            return (Criteria) this;
        }

        public Criteria andIsAttachedIn(List<Boolean> values) {
            addCriterion("is_attached in", values, "isAttached");
            return (Criteria) this;
        }

        public Criteria andIsAttachedNotIn(List<Boolean> values) {
            addCriterion("is_attached not in", values, "isAttached");
            return (Criteria) this;
        }

        public Criteria andIsAttachedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_attached between", value1, value2, "isAttached");
            return (Criteria) this;
        }

        public Criteria andIsAttachedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_attached not between", value1, value2, "isAttached");
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

        public Criteria andIsCostIsNull() {
            addCriterion("is_cost is null");
            return (Criteria) this;
        }

        public Criteria andIsCostIsNotNull() {
            addCriterion("is_cost is not null");
            return (Criteria) this;
        }

        public Criteria andIsCostEqualTo(Boolean value) {
            addCriterion("is_cost =", value, "isCost");
            return (Criteria) this;
        }

        public Criteria andIsCostNotEqualTo(Boolean value) {
            addCriterion("is_cost <>", value, "isCost");
            return (Criteria) this;
        }

        public Criteria andIsCostGreaterThan(Boolean value) {
            addCriterion("is_cost >", value, "isCost");
            return (Criteria) this;
        }

        public Criteria andIsCostGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_cost >=", value, "isCost");
            return (Criteria) this;
        }

        public Criteria andIsCostLessThan(Boolean value) {
            addCriterion("is_cost <", value, "isCost");
            return (Criteria) this;
        }

        public Criteria andIsCostLessThanOrEqualTo(Boolean value) {
            addCriterion("is_cost <=", value, "isCost");
            return (Criteria) this;
        }

        public Criteria andIsCostIn(List<Boolean> values) {
            addCriterion("is_cost in", values, "isCost");
            return (Criteria) this;
        }

        public Criteria andIsCostNotIn(List<Boolean> values) {
            addCriterion("is_cost not in", values, "isCost");
            return (Criteria) this;
        }

        public Criteria andIsCostBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cost between", value1, value2, "isCost");
            return (Criteria) this;
        }

        public Criteria andIsCostNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cost not between", value1, value2, "isCost");
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