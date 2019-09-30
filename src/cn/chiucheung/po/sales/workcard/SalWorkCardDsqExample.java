package cn.chiucheung.po.sales.workcard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalWorkCardDsqExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalWorkCardDsqExample() {
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

        public Criteria andBottomBackDoorIsNull() {
            addCriterion("bottom_back_door is null");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorIsNotNull() {
            addCriterion("bottom_back_door is not null");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorEqualTo(String value) {
            addCriterion("bottom_back_door =", value, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorNotEqualTo(String value) {
            addCriterion("bottom_back_door <>", value, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorGreaterThan(String value) {
            addCriterion("bottom_back_door >", value, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorGreaterThanOrEqualTo(String value) {
            addCriterion("bottom_back_door >=", value, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorLessThan(String value) {
            addCriterion("bottom_back_door <", value, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorLessThanOrEqualTo(String value) {
            addCriterion("bottom_back_door <=", value, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorLike(String value) {
            addCriterion("bottom_back_door like", value, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorNotLike(String value) {
            addCriterion("bottom_back_door not like", value, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorIn(List<String> values) {
            addCriterion("bottom_back_door in", values, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorNotIn(List<String> values) {
            addCriterion("bottom_back_door not in", values, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorBetween(String value1, String value2) {
            addCriterion("bottom_back_door between", value1, value2, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBottomBackDoorNotBetween(String value1, String value2) {
            addCriterion("bottom_back_door not between", value1, value2, "bottomBackDoor");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityIsNull() {
            addCriterion("bbd_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityIsNotNull() {
            addCriterion("bbd_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityEqualTo(String value) {
            addCriterion("bbd_quantity =", value, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityNotEqualTo(String value) {
            addCriterion("bbd_quantity <>", value, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityGreaterThan(String value) {
            addCriterion("bbd_quantity >", value, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("bbd_quantity >=", value, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityLessThan(String value) {
            addCriterion("bbd_quantity <", value, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityLessThanOrEqualTo(String value) {
            addCriterion("bbd_quantity <=", value, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityLike(String value) {
            addCriterion("bbd_quantity like", value, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityNotLike(String value) {
            addCriterion("bbd_quantity not like", value, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityIn(List<String> values) {
            addCriterion("bbd_quantity in", values, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityNotIn(List<String> values) {
            addCriterion("bbd_quantity not in", values, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityBetween(String value1, String value2) {
            addCriterion("bbd_quantity between", value1, value2, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdQuantityNotBetween(String value1, String value2) {
            addCriterion("bbd_quantity not between", value1, value2, "bbdQuantity");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkIsNull() {
            addCriterion("bbd_remark is null");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkIsNotNull() {
            addCriterion("bbd_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkEqualTo(String value) {
            addCriterion("bbd_remark =", value, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkNotEqualTo(String value) {
            addCriterion("bbd_remark <>", value, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkGreaterThan(String value) {
            addCriterion("bbd_remark >", value, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("bbd_remark >=", value, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkLessThan(String value) {
            addCriterion("bbd_remark <", value, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkLessThanOrEqualTo(String value) {
            addCriterion("bbd_remark <=", value, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkLike(String value) {
            addCriterion("bbd_remark like", value, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkNotLike(String value) {
            addCriterion("bbd_remark not like", value, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkIn(List<String> values) {
            addCriterion("bbd_remark in", values, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkNotIn(List<String> values) {
            addCriterion("bbd_remark not in", values, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkBetween(String value1, String value2) {
            addCriterion("bbd_remark between", value1, value2, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andBbdRemarkNotBetween(String value1, String value2) {
            addCriterion("bbd_remark not between", value1, value2, "bbdRemark");
            return (Criteria) this;
        }

        public Criteria andAfterTheIsNull() {
            addCriterion("after_the is null");
            return (Criteria) this;
        }

        public Criteria andAfterTheIsNotNull() {
            addCriterion("after_the is not null");
            return (Criteria) this;
        }

        public Criteria andAfterTheEqualTo(String value) {
            addCriterion("after_the =", value, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheNotEqualTo(String value) {
            addCriterion("after_the <>", value, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheGreaterThan(String value) {
            addCriterion("after_the >", value, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheGreaterThanOrEqualTo(String value) {
            addCriterion("after_the >=", value, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheLessThan(String value) {
            addCriterion("after_the <", value, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheLessThanOrEqualTo(String value) {
            addCriterion("after_the <=", value, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheLike(String value) {
            addCriterion("after_the like", value, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheNotLike(String value) {
            addCriterion("after_the not like", value, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheIn(List<String> values) {
            addCriterion("after_the in", values, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheNotIn(List<String> values) {
            addCriterion("after_the not in", values, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheBetween(String value1, String value2) {
            addCriterion("after_the between", value1, value2, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAfterTheNotBetween(String value1, String value2) {
            addCriterion("after_the not between", value1, value2, "afterThe");
            return (Criteria) this;
        }

        public Criteria andAtQuantityIsNull() {
            addCriterion("at_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAtQuantityIsNotNull() {
            addCriterion("at_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAtQuantityEqualTo(String value) {
            addCriterion("at_quantity =", value, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityNotEqualTo(String value) {
            addCriterion("at_quantity <>", value, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityGreaterThan(String value) {
            addCriterion("at_quantity >", value, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("at_quantity >=", value, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityLessThan(String value) {
            addCriterion("at_quantity <", value, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityLessThanOrEqualTo(String value) {
            addCriterion("at_quantity <=", value, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityLike(String value) {
            addCriterion("at_quantity like", value, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityNotLike(String value) {
            addCriterion("at_quantity not like", value, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityIn(List<String> values) {
            addCriterion("at_quantity in", values, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityNotIn(List<String> values) {
            addCriterion("at_quantity not in", values, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityBetween(String value1, String value2) {
            addCriterion("at_quantity between", value1, value2, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtQuantityNotBetween(String value1, String value2) {
            addCriterion("at_quantity not between", value1, value2, "atQuantity");
            return (Criteria) this;
        }

        public Criteria andAtRemarkIsNull() {
            addCriterion("at_remark is null");
            return (Criteria) this;
        }

        public Criteria andAtRemarkIsNotNull() {
            addCriterion("at_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAtRemarkEqualTo(String value) {
            addCriterion("at_remark =", value, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkNotEqualTo(String value) {
            addCriterion("at_remark <>", value, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkGreaterThan(String value) {
            addCriterion("at_remark >", value, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("at_remark >=", value, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkLessThan(String value) {
            addCriterion("at_remark <", value, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkLessThanOrEqualTo(String value) {
            addCriterion("at_remark <=", value, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkLike(String value) {
            addCriterion("at_remark like", value, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkNotLike(String value) {
            addCriterion("at_remark not like", value, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkIn(List<String> values) {
            addCriterion("at_remark in", values, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkNotIn(List<String> values) {
            addCriterion("at_remark not in", values, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkBetween(String value1, String value2) {
            addCriterion("at_remark between", value1, value2, "atRemark");
            return (Criteria) this;
        }

        public Criteria andAtRemarkNotBetween(String value1, String value2) {
            addCriterion("at_remark not between", value1, value2, "atRemark");
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

        public Criteria andNcQuantityIsNull() {
            addCriterion("nc_quantity is null");
            return (Criteria) this;
        }

        public Criteria andNcQuantityIsNotNull() {
            addCriterion("nc_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andNcQuantityEqualTo(String value) {
            addCriterion("nc_quantity =", value, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityNotEqualTo(String value) {
            addCriterion("nc_quantity <>", value, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityGreaterThan(String value) {
            addCriterion("nc_quantity >", value, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("nc_quantity >=", value, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityLessThan(String value) {
            addCriterion("nc_quantity <", value, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityLessThanOrEqualTo(String value) {
            addCriterion("nc_quantity <=", value, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityLike(String value) {
            addCriterion("nc_quantity like", value, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityNotLike(String value) {
            addCriterion("nc_quantity not like", value, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityIn(List<String> values) {
            addCriterion("nc_quantity in", values, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityNotIn(List<String> values) {
            addCriterion("nc_quantity not in", values, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityBetween(String value1, String value2) {
            addCriterion("nc_quantity between", value1, value2, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcQuantityNotBetween(String value1, String value2) {
            addCriterion("nc_quantity not between", value1, value2, "ncQuantity");
            return (Criteria) this;
        }

        public Criteria andNcRemarkIsNull() {
            addCriterion("nc_remark is null");
            return (Criteria) this;
        }

        public Criteria andNcRemarkIsNotNull() {
            addCriterion("nc_remark is not null");
            return (Criteria) this;
        }

        public Criteria andNcRemarkEqualTo(String value) {
            addCriterion("nc_remark =", value, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkNotEqualTo(String value) {
            addCriterion("nc_remark <>", value, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkGreaterThan(String value) {
            addCriterion("nc_remark >", value, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("nc_remark >=", value, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkLessThan(String value) {
            addCriterion("nc_remark <", value, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkLessThanOrEqualTo(String value) {
            addCriterion("nc_remark <=", value, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkLike(String value) {
            addCriterion("nc_remark like", value, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkNotLike(String value) {
            addCriterion("nc_remark not like", value, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkIn(List<String> values) {
            addCriterion("nc_remark in", values, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkNotIn(List<String> values) {
            addCriterion("nc_remark not in", values, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkBetween(String value1, String value2) {
            addCriterion("nc_remark between", value1, value2, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andNcRemarkNotBetween(String value1, String value2) {
            addCriterion("nc_remark not between", value1, value2, "ncRemark");
            return (Criteria) this;
        }

        public Criteria andMvQuantityIsNull() {
            addCriterion("mv_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMvQuantityIsNotNull() {
            addCriterion("mv_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMvQuantityEqualTo(String value) {
            addCriterion("mv_quantity =", value, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityNotEqualTo(String value) {
            addCriterion("mv_quantity <>", value, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityGreaterThan(String value) {
            addCriterion("mv_quantity >", value, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("mv_quantity >=", value, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityLessThan(String value) {
            addCriterion("mv_quantity <", value, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityLessThanOrEqualTo(String value) {
            addCriterion("mv_quantity <=", value, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityLike(String value) {
            addCriterion("mv_quantity like", value, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityNotLike(String value) {
            addCriterion("mv_quantity not like", value, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityIn(List<String> values) {
            addCriterion("mv_quantity in", values, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityNotIn(List<String> values) {
            addCriterion("mv_quantity not in", values, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityBetween(String value1, String value2) {
            addCriterion("mv_quantity between", value1, value2, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvQuantityNotBetween(String value1, String value2) {
            addCriterion("mv_quantity not between", value1, value2, "mvQuantity");
            return (Criteria) this;
        }

        public Criteria andMvRemarkIsNull() {
            addCriterion("mv_remark is null");
            return (Criteria) this;
        }

        public Criteria andMvRemarkIsNotNull() {
            addCriterion("mv_remark is not null");
            return (Criteria) this;
        }

        public Criteria andMvRemarkEqualTo(String value) {
            addCriterion("mv_remark =", value, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkNotEqualTo(String value) {
            addCriterion("mv_remark <>", value, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkGreaterThan(String value) {
            addCriterion("mv_remark >", value, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("mv_remark >=", value, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkLessThan(String value) {
            addCriterion("mv_remark <", value, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkLessThanOrEqualTo(String value) {
            addCriterion("mv_remark <=", value, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkLike(String value) {
            addCriterion("mv_remark like", value, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkNotLike(String value) {
            addCriterion("mv_remark not like", value, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkIn(List<String> values) {
            addCriterion("mv_remark in", values, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkNotIn(List<String> values) {
            addCriterion("mv_remark not in", values, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkBetween(String value1, String value2) {
            addCriterion("mv_remark between", value1, value2, "mvRemark");
            return (Criteria) this;
        }

        public Criteria andMvRemarkNotBetween(String value1, String value2) {
            addCriterion("mv_remark not between", value1, value2, "mvRemark");
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