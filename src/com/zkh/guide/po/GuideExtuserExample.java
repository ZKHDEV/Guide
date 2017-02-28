package com.zkh.guide.po;

import java.util.ArrayList;
import java.util.List;

public class GuideExtuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuideExtuserExample() {
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

        public Criteria andExtuserIdIsNull() {
            addCriterion("extuser_id is null");
            return (Criteria) this;
        }

        public Criteria andExtuserIdIsNotNull() {
            addCriterion("extuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserIdEqualTo(Integer value) {
            addCriterion("extuser_id =", value, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserIdNotEqualTo(Integer value) {
            addCriterion("extuser_id <>", value, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserIdGreaterThan(Integer value) {
            addCriterion("extuser_id >", value, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("extuser_id >=", value, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserIdLessThan(Integer value) {
            addCriterion("extuser_id <", value, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserIdLessThanOrEqualTo(Integer value) {
            addCriterion("extuser_id <=", value, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserIdIn(List<Integer> values) {
            addCriterion("extuser_id in", values, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserIdNotIn(List<Integer> values) {
            addCriterion("extuser_id not in", values, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserIdBetween(Integer value1, Integer value2) {
            addCriterion("extuser_id between", value1, value2, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("extuser_id not between", value1, value2, "extuserId");
            return (Criteria) this;
        }

        public Criteria andExtuserNameIsNull() {
            addCriterion("extuser_name is null");
            return (Criteria) this;
        }

        public Criteria andExtuserNameIsNotNull() {
            addCriterion("extuser_name is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserNameEqualTo(String value) {
            addCriterion("extuser_name =", value, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameNotEqualTo(String value) {
            addCriterion("extuser_name <>", value, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameGreaterThan(String value) {
            addCriterion("extuser_name >", value, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_name >=", value, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameLessThan(String value) {
            addCriterion("extuser_name <", value, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameLessThanOrEqualTo(String value) {
            addCriterion("extuser_name <=", value, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameLike(String value) {
            addCriterion("extuser_name like", value, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameNotLike(String value) {
            addCriterion("extuser_name not like", value, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameIn(List<String> values) {
            addCriterion("extuser_name in", values, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameNotIn(List<String> values) {
            addCriterion("extuser_name not in", values, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameBetween(String value1, String value2) {
            addCriterion("extuser_name between", value1, value2, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserNameNotBetween(String value1, String value2) {
            addCriterion("extuser_name not between", value1, value2, "extuserName");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeIsNull() {
            addCriterion("extuser_age is null");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeIsNotNull() {
            addCriterion("extuser_age is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeEqualTo(Byte value) {
            addCriterion("extuser_age =", value, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeNotEqualTo(Byte value) {
            addCriterion("extuser_age <>", value, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeGreaterThan(Byte value) {
            addCriterion("extuser_age >", value, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("extuser_age >=", value, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeLessThan(Byte value) {
            addCriterion("extuser_age <", value, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeLessThanOrEqualTo(Byte value) {
            addCriterion("extuser_age <=", value, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeIn(List<Byte> values) {
            addCriterion("extuser_age in", values, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeNotIn(List<Byte> values) {
            addCriterion("extuser_age not in", values, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeBetween(Byte value1, Byte value2) {
            addCriterion("extuser_age between", value1, value2, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserAgeNotBetween(Byte value1, Byte value2) {
            addCriterion("extuser_age not between", value1, value2, "extuserAge");
            return (Criteria) this;
        }

        public Criteria andExtuserSexIsNull() {
            addCriterion("extuser_sex is null");
            return (Criteria) this;
        }

        public Criteria andExtuserSexIsNotNull() {
            addCriterion("extuser_sex is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserSexEqualTo(String value) {
            addCriterion("extuser_sex =", value, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexNotEqualTo(String value) {
            addCriterion("extuser_sex <>", value, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexGreaterThan(String value) {
            addCriterion("extuser_sex >", value, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_sex >=", value, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexLessThan(String value) {
            addCriterion("extuser_sex <", value, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexLessThanOrEqualTo(String value) {
            addCriterion("extuser_sex <=", value, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexLike(String value) {
            addCriterion("extuser_sex like", value, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexNotLike(String value) {
            addCriterion("extuser_sex not like", value, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexIn(List<String> values) {
            addCriterion("extuser_sex in", values, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexNotIn(List<String> values) {
            addCriterion("extuser_sex not in", values, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexBetween(String value1, String value2) {
            addCriterion("extuser_sex between", value1, value2, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserSexNotBetween(String value1, String value2) {
            addCriterion("extuser_sex not between", value1, value2, "extuserSex");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadIsNull() {
            addCriterion("extuser_head is null");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadIsNotNull() {
            addCriterion("extuser_head is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadEqualTo(String value) {
            addCriterion("extuser_head =", value, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadNotEqualTo(String value) {
            addCriterion("extuser_head <>", value, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadGreaterThan(String value) {
            addCriterion("extuser_head >", value, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_head >=", value, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadLessThan(String value) {
            addCriterion("extuser_head <", value, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadLessThanOrEqualTo(String value) {
            addCriterion("extuser_head <=", value, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadLike(String value) {
            addCriterion("extuser_head like", value, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadNotLike(String value) {
            addCriterion("extuser_head not like", value, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadIn(List<String> values) {
            addCriterion("extuser_head in", values, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadNotIn(List<String> values) {
            addCriterion("extuser_head not in", values, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadBetween(String value1, String value2) {
            addCriterion("extuser_head between", value1, value2, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserHeadNotBetween(String value1, String value2) {
            addCriterion("extuser_head not between", value1, value2, "extuserHead");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryIsNull() {
            addCriterion("extuser_country is null");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryIsNotNull() {
            addCriterion("extuser_country is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryEqualTo(String value) {
            addCriterion("extuser_country =", value, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryNotEqualTo(String value) {
            addCriterion("extuser_country <>", value, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryGreaterThan(String value) {
            addCriterion("extuser_country >", value, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_country >=", value, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryLessThan(String value) {
            addCriterion("extuser_country <", value, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryLessThanOrEqualTo(String value) {
            addCriterion("extuser_country <=", value, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryLike(String value) {
            addCriterion("extuser_country like", value, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryNotLike(String value) {
            addCriterion("extuser_country not like", value, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryIn(List<String> values) {
            addCriterion("extuser_country in", values, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryNotIn(List<String> values) {
            addCriterion("extuser_country not in", values, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryBetween(String value1, String value2) {
            addCriterion("extuser_country between", value1, value2, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCountryNotBetween(String value1, String value2) {
            addCriterion("extuser_country not between", value1, value2, "extuserCountry");
            return (Criteria) this;
        }

        public Criteria andExtuserCityIsNull() {
            addCriterion("extuser_city is null");
            return (Criteria) this;
        }

        public Criteria andExtuserCityIsNotNull() {
            addCriterion("extuser_city is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserCityEqualTo(String value) {
            addCriterion("extuser_city =", value, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityNotEqualTo(String value) {
            addCriterion("extuser_city <>", value, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityGreaterThan(String value) {
            addCriterion("extuser_city >", value, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_city >=", value, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityLessThan(String value) {
            addCriterion("extuser_city <", value, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityLessThanOrEqualTo(String value) {
            addCriterion("extuser_city <=", value, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityLike(String value) {
            addCriterion("extuser_city like", value, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityNotLike(String value) {
            addCriterion("extuser_city not like", value, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityIn(List<String> values) {
            addCriterion("extuser_city in", values, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityNotIn(List<String> values) {
            addCriterion("extuser_city not in", values, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityBetween(String value1, String value2) {
            addCriterion("extuser_city between", value1, value2, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserCityNotBetween(String value1, String value2) {
            addCriterion("extuser_city not between", value1, value2, "extuserCity");
            return (Criteria) this;
        }

        public Criteria andExtuserPostIsNull() {
            addCriterion("extuser_post is null");
            return (Criteria) this;
        }

        public Criteria andExtuserPostIsNotNull() {
            addCriterion("extuser_post is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserPostEqualTo(String value) {
            addCriterion("extuser_post =", value, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostNotEqualTo(String value) {
            addCriterion("extuser_post <>", value, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostGreaterThan(String value) {
            addCriterion("extuser_post >", value, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_post >=", value, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostLessThan(String value) {
            addCriterion("extuser_post <", value, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostLessThanOrEqualTo(String value) {
            addCriterion("extuser_post <=", value, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostLike(String value) {
            addCriterion("extuser_post like", value, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostNotLike(String value) {
            addCriterion("extuser_post not like", value, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostIn(List<String> values) {
            addCriterion("extuser_post in", values, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostNotIn(List<String> values) {
            addCriterion("extuser_post not in", values, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostBetween(String value1, String value2) {
            addCriterion("extuser_post between", value1, value2, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserPostNotBetween(String value1, String value2) {
            addCriterion("extuser_post not between", value1, value2, "extuserPost");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailIsNull() {
            addCriterion("extuser_email is null");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailIsNotNull() {
            addCriterion("extuser_email is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailEqualTo(String value) {
            addCriterion("extuser_email =", value, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailNotEqualTo(String value) {
            addCriterion("extuser_email <>", value, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailGreaterThan(String value) {
            addCriterion("extuser_email >", value, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_email >=", value, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailLessThan(String value) {
            addCriterion("extuser_email <", value, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailLessThanOrEqualTo(String value) {
            addCriterion("extuser_email <=", value, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailLike(String value) {
            addCriterion("extuser_email like", value, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailNotLike(String value) {
            addCriterion("extuser_email not like", value, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailIn(List<String> values) {
            addCriterion("extuser_email in", values, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailNotIn(List<String> values) {
            addCriterion("extuser_email not in", values, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailBetween(String value1, String value2) {
            addCriterion("extuser_email between", value1, value2, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserEmailNotBetween(String value1, String value2) {
            addCriterion("extuser_email not between", value1, value2, "extuserEmail");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneIsNull() {
            addCriterion("extuser_phone is null");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneIsNotNull() {
            addCriterion("extuser_phone is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneEqualTo(String value) {
            addCriterion("extuser_phone =", value, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneNotEqualTo(String value) {
            addCriterion("extuser_phone <>", value, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneGreaterThan(String value) {
            addCriterion("extuser_phone >", value, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_phone >=", value, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneLessThan(String value) {
            addCriterion("extuser_phone <", value, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneLessThanOrEqualTo(String value) {
            addCriterion("extuser_phone <=", value, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneLike(String value) {
            addCriterion("extuser_phone like", value, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneNotLike(String value) {
            addCriterion("extuser_phone not like", value, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneIn(List<String> values) {
            addCriterion("extuser_phone in", values, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneNotIn(List<String> values) {
            addCriterion("extuser_phone not in", values, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneBetween(String value1, String value2) {
            addCriterion("extuser_phone between", value1, value2, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserPhoneNotBetween(String value1, String value2) {
            addCriterion("extuser_phone not between", value1, value2, "extuserPhone");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyIsNull() {
            addCriterion("extuser_hobby is null");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyIsNotNull() {
            addCriterion("extuser_hobby is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyEqualTo(String value) {
            addCriterion("extuser_hobby =", value, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyNotEqualTo(String value) {
            addCriterion("extuser_hobby <>", value, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyGreaterThan(String value) {
            addCriterion("extuser_hobby >", value, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_hobby >=", value, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyLessThan(String value) {
            addCriterion("extuser_hobby <", value, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyLessThanOrEqualTo(String value) {
            addCriterion("extuser_hobby <=", value, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyLike(String value) {
            addCriterion("extuser_hobby like", value, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyNotLike(String value) {
            addCriterion("extuser_hobby not like", value, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyIn(List<String> values) {
            addCriterion("extuser_hobby in", values, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyNotIn(List<String> values) {
            addCriterion("extuser_hobby not in", values, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyBetween(String value1, String value2) {
            addCriterion("extuser_hobby between", value1, value2, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserHobbyNotBetween(String value1, String value2) {
            addCriterion("extuser_hobby not between", value1, value2, "extuserHobby");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumIsNull() {
            addCriterion("extuser_likenum is null");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumIsNotNull() {
            addCriterion("extuser_likenum is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumEqualTo(Integer value) {
            addCriterion("extuser_likenum =", value, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumNotEqualTo(Integer value) {
            addCriterion("extuser_likenum <>", value, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumGreaterThan(Integer value) {
            addCriterion("extuser_likenum >", value, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("extuser_likenum >=", value, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumLessThan(Integer value) {
            addCriterion("extuser_likenum <", value, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumLessThanOrEqualTo(Integer value) {
            addCriterion("extuser_likenum <=", value, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumIn(List<Integer> values) {
            addCriterion("extuser_likenum in", values, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumNotIn(List<Integer> values) {
            addCriterion("extuser_likenum not in", values, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumBetween(Integer value1, Integer value2) {
            addCriterion("extuser_likenum between", value1, value2, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserLikenumNotBetween(Integer value1, Integer value2) {
            addCriterion("extuser_likenum not between", value1, value2, "extuserLikenum");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonIsNull() {
            addCriterion("extuser_modifiedon is null");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonIsNotNull() {
            addCriterion("extuser_modifiedon is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonEqualTo(String value) {
            addCriterion("extuser_modifiedon =", value, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonNotEqualTo(String value) {
            addCriterion("extuser_modifiedon <>", value, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonGreaterThan(String value) {
            addCriterion("extuser_modifiedon >", value, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonGreaterThanOrEqualTo(String value) {
            addCriterion("extuser_modifiedon >=", value, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonLessThan(String value) {
            addCriterion("extuser_modifiedon <", value, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonLessThanOrEqualTo(String value) {
            addCriterion("extuser_modifiedon <=", value, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonLike(String value) {
            addCriterion("extuser_modifiedon like", value, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonNotLike(String value) {
            addCriterion("extuser_modifiedon not like", value, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonIn(List<String> values) {
            addCriterion("extuser_modifiedon in", values, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonNotIn(List<String> values) {
            addCriterion("extuser_modifiedon not in", values, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonBetween(String value1, String value2) {
            addCriterion("extuser_modifiedon between", value1, value2, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserModifiedonNotBetween(String value1, String value2) {
            addCriterion("extuser_modifiedon not between", value1, value2, "extuserModifiedon");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdIsNull() {
            addCriterion("extuser_user_id is null");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdIsNotNull() {
            addCriterion("extuser_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdEqualTo(Integer value) {
            addCriterion("extuser_user_id =", value, "extuserUserId");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdNotEqualTo(Integer value) {
            addCriterion("extuser_user_id <>", value, "extuserUserId");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdGreaterThan(Integer value) {
            addCriterion("extuser_user_id >", value, "extuserUserId");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("extuser_user_id >=", value, "extuserUserId");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdLessThan(Integer value) {
            addCriterion("extuser_user_id <", value, "extuserUserId");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("extuser_user_id <=", value, "extuserUserId");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdIn(List<Integer> values) {
            addCriterion("extuser_user_id in", values, "extuserUserId");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdNotIn(List<Integer> values) {
            addCriterion("extuser_user_id not in", values, "extuserUserId");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdBetween(Integer value1, Integer value2) {
            addCriterion("extuser_user_id between", value1, value2, "extuserUserId");
            return (Criteria) this;
        }

        public Criteria andExtuserUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("extuser_user_id not between", value1, value2, "extuserUserId");
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