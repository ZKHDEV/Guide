package com.zkh.guide.po;

import java.util.ArrayList;
import java.util.List;

public class GuideLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideLinkExample() {
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

        public Criteria andLinkIdIsNull() {
            addCriterion("link_id is null");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNotNull() {
            addCriterion("link_id is not null");
            return (Criteria) this;
        }

        public Criteria andLinkIdEqualTo(Integer value) {
            addCriterion("link_id =", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotEqualTo(Integer value) {
            addCriterion("link_id <>", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThan(Integer value) {
            addCriterion("link_id >", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_id >=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThan(Integer value) {
            addCriterion("link_id <", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThanOrEqualTo(Integer value) {
            addCriterion("link_id <=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdIn(List<Integer> values) {
            addCriterion("link_id in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotIn(List<Integer> values) {
            addCriterion("link_id not in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdBetween(Integer value1, Integer value2) {
            addCriterion("link_id between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("link_id not between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkTitleIsNull() {
            addCriterion("link_title is null");
            return (Criteria) this;
        }

        public Criteria andLinkTitleIsNotNull() {
            addCriterion("link_title is not null");
            return (Criteria) this;
        }

        public Criteria andLinkTitleEqualTo(String value) {
            addCriterion("link_title =", value, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleNotEqualTo(String value) {
            addCriterion("link_title <>", value, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleGreaterThan(String value) {
            addCriterion("link_title >", value, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleGreaterThanOrEqualTo(String value) {
            addCriterion("link_title >=", value, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleLessThan(String value) {
            addCriterion("link_title <", value, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleLessThanOrEqualTo(String value) {
            addCriterion("link_title <=", value, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleLike(String value) {
            addCriterion("link_title like", value, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleNotLike(String value) {
            addCriterion("link_title not like", value, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleIn(List<String> values) {
            addCriterion("link_title in", values, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleNotIn(List<String> values) {
            addCriterion("link_title not in", values, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleBetween(String value1, String value2) {
            addCriterion("link_title between", value1, value2, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkTitleNotBetween(String value1, String value2) {
            addCriterion("link_title not between", value1, value2, "linkTitle");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeIsNull() {
            addCriterion("link_datetime is null");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeIsNotNull() {
            addCriterion("link_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeEqualTo(String value) {
            addCriterion("link_datetime =", value, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeNotEqualTo(String value) {
            addCriterion("link_datetime <>", value, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeGreaterThan(String value) {
            addCriterion("link_datetime >", value, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("link_datetime >=", value, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeLessThan(String value) {
            addCriterion("link_datetime <", value, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeLessThanOrEqualTo(String value) {
            addCriterion("link_datetime <=", value, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeLike(String value) {
            addCriterion("link_datetime like", value, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeNotLike(String value) {
            addCriterion("link_datetime not like", value, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeIn(List<String> values) {
            addCriterion("link_datetime in", values, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeNotIn(List<String> values) {
            addCriterion("link_datetime not in", values, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeBetween(String value1, String value2) {
            addCriterion("link_datetime between", value1, value2, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkDatetimeNotBetween(String value1, String value2) {
            addCriterion("link_datetime not between", value1, value2, "linkDatetime");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdIsNull() {
            addCriterion("link_category_id is null");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdIsNotNull() {
            addCriterion("link_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdEqualTo(Integer value) {
            addCriterion("link_category_id =", value, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdNotEqualTo(Integer value) {
            addCriterion("link_category_id <>", value, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdGreaterThan(Integer value) {
            addCriterion("link_category_id >", value, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_category_id >=", value, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdLessThan(Integer value) {
            addCriterion("link_category_id <", value, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("link_category_id <=", value, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdIn(List<Integer> values) {
            addCriterion("link_category_id in", values, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdNotIn(List<Integer> values) {
            addCriterion("link_category_id not in", values, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("link_category_id between", value1, value2, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("link_category_id not between", value1, value2, "linkCategoryId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdIsNull() {
            addCriterion("link_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdIsNotNull() {
            addCriterion("link_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdEqualTo(Integer value) {
            addCriterion("link_user_id =", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdNotEqualTo(Integer value) {
            addCriterion("link_user_id <>", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdGreaterThan(Integer value) {
            addCriterion("link_user_id >", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_user_id >=", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdLessThan(Integer value) {
            addCriterion("link_user_id <", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("link_user_id <=", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdIn(List<Integer> values) {
            addCriterion("link_user_id in", values, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdNotIn(List<Integer> values) {
            addCriterion("link_user_id not in", values, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdBetween(Integer value1, Integer value2) {
            addCriterion("link_user_id between", value1, value2, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("link_user_id not between", value1, value2, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagIsNull() {
            addCriterion("link_favflag is null");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagIsNotNull() {
            addCriterion("link_favflag is not null");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagEqualTo(Byte value) {
            addCriterion("link_favflag =", value, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagNotEqualTo(Byte value) {
            addCriterion("link_favflag <>", value, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagGreaterThan(Byte value) {
            addCriterion("link_favflag >", value, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagGreaterThanOrEqualTo(Byte value) {
            addCriterion("link_favflag >=", value, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagLessThan(Byte value) {
            addCriterion("link_favflag <", value, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagLessThanOrEqualTo(Byte value) {
            addCriterion("link_favflag <=", value, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagIn(List<Byte> values) {
            addCriterion("link_favflag in", values, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagNotIn(List<Byte> values) {
            addCriterion("link_favflag not in", values, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagBetween(Byte value1, Byte value2) {
            addCriterion("link_favflag between", value1, value2, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkFavflagNotBetween(Byte value1, Byte value2) {
            addCriterion("link_favflag not between", value1, value2, "linkFavflag");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonIsNull() {
            addCriterion("link_modifiedon is null");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonIsNotNull() {
            addCriterion("link_modifiedon is not null");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonEqualTo(String value) {
            addCriterion("link_modifiedon =", value, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonNotEqualTo(String value) {
            addCriterion("link_modifiedon <>", value, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonGreaterThan(String value) {
            addCriterion("link_modifiedon >", value, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonGreaterThanOrEqualTo(String value) {
            addCriterion("link_modifiedon >=", value, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonLessThan(String value) {
            addCriterion("link_modifiedon <", value, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonLessThanOrEqualTo(String value) {
            addCriterion("link_modifiedon <=", value, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonLike(String value) {
            addCriterion("link_modifiedon like", value, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonNotLike(String value) {
            addCriterion("link_modifiedon not like", value, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonIn(List<String> values) {
            addCriterion("link_modifiedon in", values, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonNotIn(List<String> values) {
            addCriterion("link_modifiedon not in", values, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonBetween(String value1, String value2) {
            addCriterion("link_modifiedon between", value1, value2, "linkModifiedon");
            return (Criteria) this;
        }

        public Criteria andLinkModifiedonNotBetween(String value1, String value2) {
            addCriterion("link_modifiedon not between", value1, value2, "linkModifiedon");
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