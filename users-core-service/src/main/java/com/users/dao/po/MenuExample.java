package com.users.dao.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table menu
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table menu
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table menu
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public MenuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table menu
     *
     * @mbg.generated
     */
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIsNull() {
            addCriterion("menu_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIsNotNull() {
            addCriterion("menu_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdEqualTo(Integer value) {
            addCriterion("menu_parent_id =", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotEqualTo(Integer value) {
            addCriterion("menu_parent_id <>", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdGreaterThan(Integer value) {
            addCriterion("menu_parent_id >", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_parent_id >=", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdLessThan(Integer value) {
            addCriterion("menu_parent_id <", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_parent_id <=", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIn(List<Integer> values) {
            addCriterion("menu_parent_id in", values, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotIn(List<Integer> values) {
            addCriterion("menu_parent_id not in", values, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_parent_id between", value1, value2, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_parent_id not between", value1, value2, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeIsNull() {
            addCriterion("menu_describe is null");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeIsNotNull() {
            addCriterion("menu_describe is not null");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeEqualTo(String value) {
            addCriterion("menu_describe =", value, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeNotEqualTo(String value) {
            addCriterion("menu_describe <>", value, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeGreaterThan(String value) {
            addCriterion("menu_describe >", value, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("menu_describe >=", value, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeLessThan(String value) {
            addCriterion("menu_describe <", value, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeLessThanOrEqualTo(String value) {
            addCriterion("menu_describe <=", value, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeLike(String value) {
            addCriterion("menu_describe like", value, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeNotLike(String value) {
            addCriterion("menu_describe not like", value, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeIn(List<String> values) {
            addCriterion("menu_describe in", values, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeNotIn(List<String> values) {
            addCriterion("menu_describe not in", values, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeBetween(String value1, String value2) {
            addCriterion("menu_describe between", value1, value2, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andMenuDescribeNotBetween(String value1, String value2) {
            addCriterion("menu_describe not between", value1, value2, "menuDescribe");
            return (Criteria) this;
        }

        public Criteria andIsDisableIsNull() {
            addCriterion("is_disable is null");
            return (Criteria) this;
        }

        public Criteria andIsDisableIsNotNull() {
            addCriterion("is_disable is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisableEqualTo(Integer value) {
            addCriterion("is_disable =", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableNotEqualTo(Integer value) {
            addCriterion("is_disable <>", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableGreaterThan(Integer value) {
            addCriterion("is_disable >", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_disable >=", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableLessThan(Integer value) {
            addCriterion("is_disable <", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableLessThanOrEqualTo(Integer value) {
            addCriterion("is_disable <=", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableIn(List<Integer> values) {
            addCriterion("is_disable in", values, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableNotIn(List<Integer> values) {
            addCriterion("is_disable not in", values, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableBetween(Integer value1, Integer value2) {
            addCriterion("is_disable between", value1, value2, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableNotBetween(Integer value1, Integer value2) {
            addCriterion("is_disable not between", value1, value2, "isDisable");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("create_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("create_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("create_datetime =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("create_datetime <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("create_datetime >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_datetime >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("create_datetime <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("create_datetime <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("create_datetime in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("create_datetime not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("create_datetime between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("create_datetime not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNull() {
            addCriterion("update_datetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNotNull() {
            addCriterion("update_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeEqualTo(Date value) {
            addCriterion("update_datetime =", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotEqualTo(Date value) {
            addCriterion("update_datetime <>", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThan(Date value) {
            addCriterion("update_datetime >", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_datetime >=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThan(Date value) {
            addCriterion("update_datetime <", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("update_datetime <=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIn(List<Date> values) {
            addCriterion("update_datetime in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotIn(List<Date> values) {
            addCriterion("update_datetime not in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeBetween(Date value1, Date value2) {
            addCriterion("update_datetime between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("update_datetime not between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table menu
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table menu
     *
     * @mbg.generated
     */
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