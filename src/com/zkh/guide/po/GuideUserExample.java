package com.zkh.guide.po;

import java.util.ArrayList;
import java.util.List;

public class GuideUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideUserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("user_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("user_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("user_pwd =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("user_pwd <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("user_pwd >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_pwd >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("user_pwd <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("user_pwd <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("user_pwd like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("user_pwd not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("user_pwd in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("user_pwd not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("user_pwd between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("user_pwd not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeIsNull() {
            addCriterion("user_subtime is null");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeIsNotNull() {
            addCriterion("user_subtime is not null");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeEqualTo(String value) {
            addCriterion("user_subtime =", value, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeNotEqualTo(String value) {
            addCriterion("user_subtime <>", value, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeGreaterThan(String value) {
            addCriterion("user_subtime >", value, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeGreaterThanOrEqualTo(String value) {
            addCriterion("user_subtime >=", value, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeLessThan(String value) {
            addCriterion("user_subtime <", value, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeLessThanOrEqualTo(String value) {
            addCriterion("user_subtime <=", value, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeLike(String value) {
            addCriterion("user_subtime like", value, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeNotLike(String value) {
            addCriterion("user_subtime not like", value, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeIn(List<String> values) {
            addCriterion("user_subtime in", values, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeNotIn(List<String> values) {
            addCriterion("user_subtime not in", values, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeBetween(String value1, String value2) {
            addCriterion("user_subtime between", value1, value2, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserSubtimeNotBetween(String value1, String value2) {
            addCriterion("user_subtime not between", value1, value2, "userSubtime");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonIsNull() {
            addCriterion("user_modifiedon is null");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonIsNotNull() {
            addCriterion("user_modifiedon is not null");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonEqualTo(String value) {
            addCriterion("user_modifiedon =", value, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonNotEqualTo(String value) {
            addCriterion("user_modifiedon <>", value, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonGreaterThan(String value) {
            addCriterion("user_modifiedon >", value, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonGreaterThanOrEqualTo(String value) {
            addCriterion("user_modifiedon >=", value, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonLessThan(String value) {
            addCriterion("user_modifiedon <", value, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonLessThanOrEqualTo(String value) {
            addCriterion("user_modifiedon <=", value, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonLike(String value) {
            addCriterion("user_modifiedon like", value, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonNotLike(String value) {
            addCriterion("user_modifiedon not like", value, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonIn(List<String> values) {
            addCriterion("user_modifiedon in", values, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonNotIn(List<String> values) {
            addCriterion("user_modifiedon not in", values, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonBetween(String value1, String value2) {
            addCriterion("user_modifiedon between", value1, value2, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserModifiedonNotBetween(String value1, String value2) {
            addCriterion("user_modifiedon not between", value1, value2, "userModifiedon");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNull() {
            addCriterion("user_state is null");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNotNull() {
            addCriterion("user_state is not null");
            return (Criteria) this;
        }

        public Criteria andUserStateEqualTo(Byte value) {
            addCriterion("user_state =", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotEqualTo(Byte value) {
            addCriterion("user_state <>", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThan(Byte value) {
            addCriterion("user_state >", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_state >=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThan(Byte value) {
            addCriterion("user_state <", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThanOrEqualTo(Byte value) {
            addCriterion("user_state <=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateIn(List<Byte> values) {
            addCriterion("user_state in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotIn(List<Byte> values) {
            addCriterion("user_state not in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateBetween(Byte value1, Byte value2) {
            addCriterion("user_state between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotBetween(Byte value1, Byte value2) {
            addCriterion("user_state not between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserVerifyIsNull() {
            addCriterion("user_verify is null");
            return (Criteria) this;
        }

        public Criteria andUserVerifyIsNotNull() {
            addCriterion("user_verify is not null");
            return (Criteria) this;
        }

        public Criteria andUserVerifyEqualTo(String value) {
            addCriterion("user_verify =", value, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyNotEqualTo(String value) {
            addCriterion("user_verify <>", value, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyGreaterThan(String value) {
            addCriterion("user_verify >", value, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyGreaterThanOrEqualTo(String value) {
            addCriterion("user_verify >=", value, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyLessThan(String value) {
            addCriterion("user_verify <", value, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyLessThanOrEqualTo(String value) {
            addCriterion("user_verify <=", value, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyLike(String value) {
            addCriterion("user_verify like", value, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyNotLike(String value) {
            addCriterion("user_verify not like", value, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyIn(List<String> values) {
            addCriterion("user_verify in", values, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyNotIn(List<String> values) {
            addCriterion("user_verify not in", values, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyBetween(String value1, String value2) {
            addCriterion("user_verify between", value1, value2, "userVerify");
            return (Criteria) this;
        }

        public Criteria andUserVerifyNotBetween(String value1, String value2) {
            addCriterion("user_verify not between", value1, value2, "userVerify");
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