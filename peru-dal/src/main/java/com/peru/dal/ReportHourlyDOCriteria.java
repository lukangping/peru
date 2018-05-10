package com.peru.dal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportHourlyDOCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportHourlyDOCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("`date` is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("`date` is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Integer value) {
            addCriterion("`date` =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Integer value) {
            addCriterion("`date` <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Integer value) {
            addCriterion("`date` >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`date` >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Integer value) {
            addCriterion("`date` <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Integer value) {
            addCriterion("`date` <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Integer> values) {
            addCriterion("`date` in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Integer> values) {
            addCriterion("`date` not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Integer value1, Integer value2) {
            addCriterion("`date` between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Integer value1, Integer value2) {
            addCriterion("`date` not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andFacebookIdIsNull() {
            addCriterion("facebook_id is null");
            return (Criteria) this;
        }

        public Criteria andFacebookIdIsNotNull() {
            addCriterion("facebook_id is not null");
            return (Criteria) this;
        }

        public Criteria andFacebookIdEqualTo(String value) {
            addCriterion("facebook_id =", value, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdNotEqualTo(String value) {
            addCriterion("facebook_id <>", value, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdGreaterThan(String value) {
            addCriterion("facebook_id >", value, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdGreaterThanOrEqualTo(String value) {
            addCriterion("facebook_id >=", value, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdLessThan(String value) {
            addCriterion("facebook_id <", value, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdLessThanOrEqualTo(String value) {
            addCriterion("facebook_id <=", value, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdLike(String value) {
            addCriterion("facebook_id like", value, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdNotLike(String value) {
            addCriterion("facebook_id not like", value, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdIn(List<String> values) {
            addCriterion("facebook_id in", values, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdNotIn(List<String> values) {
            addCriterion("facebook_id not in", values, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdBetween(String value1, String value2) {
            addCriterion("facebook_id between", value1, value2, "facebookId");
            return (Criteria) this;
        }

        public Criteria andFacebookIdNotBetween(String value1, String value2) {
            addCriterion("facebook_id not between", value1, value2, "facebookId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdIsNull() {
            addCriterion("adset_id is null");
            return (Criteria) this;
        }

        public Criteria andAdsetIdIsNotNull() {
            addCriterion("adset_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdsetIdEqualTo(String value) {
            addCriterion("adset_id =", value, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdNotEqualTo(String value) {
            addCriterion("adset_id <>", value, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdGreaterThan(String value) {
            addCriterion("adset_id >", value, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdGreaterThanOrEqualTo(String value) {
            addCriterion("adset_id >=", value, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdLessThan(String value) {
            addCriterion("adset_id <", value, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdLessThanOrEqualTo(String value) {
            addCriterion("adset_id <=", value, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdLike(String value) {
            addCriterion("adset_id like", value, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdNotLike(String value) {
            addCriterion("adset_id not like", value, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdIn(List<String> values) {
            addCriterion("adset_id in", values, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdNotIn(List<String> values) {
            addCriterion("adset_id not in", values, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdBetween(String value1, String value2) {
            addCriterion("adset_id between", value1, value2, "adsetId");
            return (Criteria) this;
        }

        public Criteria andAdsetIdNotBetween(String value1, String value2) {
            addCriterion("adset_id not between", value1, value2, "adsetId");
            return (Criteria) this;
        }

        public Criteria andGmvIsNull() {
            addCriterion("gmv is null");
            return (Criteria) this;
        }

        public Criteria andGmvIsNotNull() {
            addCriterion("gmv is not null");
            return (Criteria) this;
        }

        public Criteria andGmvEqualTo(BigDecimal value) {
            addCriterion("gmv =", value, "gmv");
            return (Criteria) this;
        }

        public Criteria andGmvNotEqualTo(BigDecimal value) {
            addCriterion("gmv <>", value, "gmv");
            return (Criteria) this;
        }

        public Criteria andGmvGreaterThan(BigDecimal value) {
            addCriterion("gmv >", value, "gmv");
            return (Criteria) this;
        }

        public Criteria andGmvGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gmv >=", value, "gmv");
            return (Criteria) this;
        }

        public Criteria andGmvLessThan(BigDecimal value) {
            addCriterion("gmv <", value, "gmv");
            return (Criteria) this;
        }

        public Criteria andGmvLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gmv <=", value, "gmv");
            return (Criteria) this;
        }

        public Criteria andGmvIn(List<BigDecimal> values) {
            addCriterion("gmv in", values, "gmv");
            return (Criteria) this;
        }

        public Criteria andGmvNotIn(List<BigDecimal> values) {
            addCriterion("gmv not in", values, "gmv");
            return (Criteria) this;
        }

        public Criteria andGmvBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gmv between", value1, value2, "gmv");
            return (Criteria) this;
        }

        public Criteria andGmvNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gmv not between", value1, value2, "gmv");
            return (Criteria) this;
        }

        public Criteria andSpendIsNull() {
            addCriterion("spend is null");
            return (Criteria) this;
        }

        public Criteria andSpendIsNotNull() {
            addCriterion("spend is not null");
            return (Criteria) this;
        }

        public Criteria andSpendEqualTo(BigDecimal value) {
            addCriterion("spend =", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendNotEqualTo(BigDecimal value) {
            addCriterion("spend <>", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendGreaterThan(BigDecimal value) {
            addCriterion("spend >", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("spend >=", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendLessThan(BigDecimal value) {
            addCriterion("spend <", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("spend <=", value, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendIn(List<BigDecimal> values) {
            addCriterion("spend in", values, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendNotIn(List<BigDecimal> values) {
            addCriterion("spend not in", values, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spend between", value1, value2, "spend");
            return (Criteria) this;
        }

        public Criteria andSpendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spend not between", value1, value2, "spend");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNull() {
            addCriterion("budget is null");
            return (Criteria) this;
        }

        public Criteria andBudgetIsNotNull() {
            addCriterion("budget is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetEqualTo(BigDecimal value) {
            addCriterion("budget =", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotEqualTo(BigDecimal value) {
            addCriterion("budget <>", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThan(BigDecimal value) {
            addCriterion("budget >", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("budget >=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThan(BigDecimal value) {
            addCriterion("budget <", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("budget <=", value, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetIn(List<BigDecimal> values) {
            addCriterion("budget in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotIn(List<BigDecimal> values) {
            addCriterion("budget not in", values, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("budget between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("budget not between", value1, value2, "budget");
            return (Criteria) this;
        }

        public Criteria andImpressionsIsNull() {
            addCriterion("impressions is null");
            return (Criteria) this;
        }

        public Criteria andImpressionsIsNotNull() {
            addCriterion("impressions is not null");
            return (Criteria) this;
        }

        public Criteria andImpressionsEqualTo(Integer value) {
            addCriterion("impressions =", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotEqualTo(Integer value) {
            addCriterion("impressions <>", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsGreaterThan(Integer value) {
            addCriterion("impressions >", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("impressions >=", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsLessThan(Integer value) {
            addCriterion("impressions <", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsLessThanOrEqualTo(Integer value) {
            addCriterion("impressions <=", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsIn(List<Integer> values) {
            addCriterion("impressions in", values, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotIn(List<Integer> values) {
            addCriterion("impressions not in", values, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsBetween(Integer value1, Integer value2) {
            addCriterion("impressions between", value1, value2, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotBetween(Integer value1, Integer value2) {
            addCriterion("impressions not between", value1, value2, "impressions");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Float value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Float value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Float value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Float value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Float value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Float value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Float> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Float> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Float value1, Float value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Float value1, Float value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andReachsIsNull() {
            addCriterion("reachs is null");
            return (Criteria) this;
        }

        public Criteria andReachsIsNotNull() {
            addCriterion("reachs is not null");
            return (Criteria) this;
        }

        public Criteria andReachsEqualTo(Integer value) {
            addCriterion("reachs =", value, "reachs");
            return (Criteria) this;
        }

        public Criteria andReachsNotEqualTo(Integer value) {
            addCriterion("reachs <>", value, "reachs");
            return (Criteria) this;
        }

        public Criteria andReachsGreaterThan(Integer value) {
            addCriterion("reachs >", value, "reachs");
            return (Criteria) this;
        }

        public Criteria andReachsGreaterThanOrEqualTo(Integer value) {
            addCriterion("reachs >=", value, "reachs");
            return (Criteria) this;
        }

        public Criteria andReachsLessThan(Integer value) {
            addCriterion("reachs <", value, "reachs");
            return (Criteria) this;
        }

        public Criteria andReachsLessThanOrEqualTo(Integer value) {
            addCriterion("reachs <=", value, "reachs");
            return (Criteria) this;
        }

        public Criteria andReachsIn(List<Integer> values) {
            addCriterion("reachs in", values, "reachs");
            return (Criteria) this;
        }

        public Criteria andReachsNotIn(List<Integer> values) {
            addCriterion("reachs not in", values, "reachs");
            return (Criteria) this;
        }

        public Criteria andReachsBetween(Integer value1, Integer value2) {
            addCriterion("reachs between", value1, value2, "reachs");
            return (Criteria) this;
        }

        public Criteria andReachsNotBetween(Integer value1, Integer value2) {
            addCriterion("reachs not between", value1, value2, "reachs");
            return (Criteria) this;
        }

        public Criteria andClicksIsNull() {
            addCriterion("clicks is null");
            return (Criteria) this;
        }

        public Criteria andClicksIsNotNull() {
            addCriterion("clicks is not null");
            return (Criteria) this;
        }

        public Criteria andClicksEqualTo(Integer value) {
            addCriterion("clicks =", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotEqualTo(Integer value) {
            addCriterion("clicks <>", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThan(Integer value) {
            addCriterion("clicks >", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThanOrEqualTo(Integer value) {
            addCriterion("clicks >=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThan(Integer value) {
            addCriterion("clicks <", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThanOrEqualTo(Integer value) {
            addCriterion("clicks <=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksIn(List<Integer> values) {
            addCriterion("clicks in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotIn(List<Integer> values) {
            addCriterion("clicks not in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksBetween(Integer value1, Integer value2) {
            addCriterion("clicks between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotBetween(Integer value1, Integer value2) {
            addCriterion("clicks not between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andPurchasesIsNull() {
            addCriterion("purchases is null");
            return (Criteria) this;
        }

        public Criteria andPurchasesIsNotNull() {
            addCriterion("purchases is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasesEqualTo(Integer value) {
            addCriterion("purchases =", value, "purchases");
            return (Criteria) this;
        }

        public Criteria andPurchasesNotEqualTo(Integer value) {
            addCriterion("purchases <>", value, "purchases");
            return (Criteria) this;
        }

        public Criteria andPurchasesGreaterThan(Integer value) {
            addCriterion("purchases >", value, "purchases");
            return (Criteria) this;
        }

        public Criteria andPurchasesGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchases >=", value, "purchases");
            return (Criteria) this;
        }

        public Criteria andPurchasesLessThan(Integer value) {
            addCriterion("purchases <", value, "purchases");
            return (Criteria) this;
        }

        public Criteria andPurchasesLessThanOrEqualTo(Integer value) {
            addCriterion("purchases <=", value, "purchases");
            return (Criteria) this;
        }

        public Criteria andPurchasesIn(List<Integer> values) {
            addCriterion("purchases in", values, "purchases");
            return (Criteria) this;
        }

        public Criteria andPurchasesNotIn(List<Integer> values) {
            addCriterion("purchases not in", values, "purchases");
            return (Criteria) this;
        }

        public Criteria andPurchasesBetween(Integer value1, Integer value2) {
            addCriterion("purchases between", value1, value2, "purchases");
            return (Criteria) this;
        }

        public Criteria andPurchasesNotBetween(Integer value1, Integer value2) {
            addCriterion("purchases not between", value1, value2, "purchases");
            return (Criteria) this;
        }

        public Criteria andCostGeneralIsNull() {
            addCriterion("cost_general is null");
            return (Criteria) this;
        }

        public Criteria andCostGeneralIsNotNull() {
            addCriterion("cost_general is not null");
            return (Criteria) this;
        }

        public Criteria andCostGeneralEqualTo(BigDecimal value) {
            addCriterion("cost_general =", value, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostGeneralNotEqualTo(BigDecimal value) {
            addCriterion("cost_general <>", value, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostGeneralGreaterThan(BigDecimal value) {
            addCriterion("cost_general >", value, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostGeneralGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_general >=", value, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostGeneralLessThan(BigDecimal value) {
            addCriterion("cost_general <", value, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostGeneralLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_general <=", value, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostGeneralIn(List<BigDecimal> values) {
            addCriterion("cost_general in", values, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostGeneralNotIn(List<BigDecimal> values) {
            addCriterion("cost_general not in", values, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostGeneralBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_general between", value1, value2, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostGeneralNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_general not between", value1, value2, "costGeneral");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingIsNull() {
            addCriterion("cost_purchasing is null");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingIsNotNull() {
            addCriterion("cost_purchasing is not null");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingEqualTo(BigDecimal value) {
            addCriterion("cost_purchasing =", value, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingNotEqualTo(BigDecimal value) {
            addCriterion("cost_purchasing <>", value, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingGreaterThan(BigDecimal value) {
            addCriterion("cost_purchasing >", value, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_purchasing >=", value, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingLessThan(BigDecimal value) {
            addCriterion("cost_purchasing <", value, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_purchasing <=", value, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingIn(List<BigDecimal> values) {
            addCriterion("cost_purchasing in", values, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingNotIn(List<BigDecimal> values) {
            addCriterion("cost_purchasing not in", values, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_purchasing between", value1, value2, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andCostPurchasingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_purchasing not between", value1, value2, "costPurchasing");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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