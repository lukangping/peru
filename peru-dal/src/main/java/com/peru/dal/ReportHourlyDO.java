package com.peru.dal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ReportHourlyDO implements Serializable {
    private Integer id;

    private Integer date;

    private String facebookId;

    private String adsetId;

    private BigDecimal gmv;

    private BigDecimal spend;

    private BigDecimal budget;

    private Integer impressions;

    private Float frequency;

    private Integer reachs;

    private Integer clicks;

    private Integer purchases;

    private BigDecimal costGeneral;

    private BigDecimal costPurchasing;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId == null ? null : facebookId.trim();
    }

    public String getAdsetId() {
        return adsetId;
    }

    public void setAdsetId(String adsetId) {
        this.adsetId = adsetId == null ? null : adsetId.trim();
    }

    public BigDecimal getGmv() {
        return gmv;
    }

    public void setGmv(BigDecimal gmv) {
        this.gmv = gmv;
    }

    public BigDecimal getSpend() {
        return spend;
    }

    public void setSpend(BigDecimal spend) {
        this.spend = spend;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Integer getImpressions() {
        return impressions;
    }

    public void setImpressions(Integer impressions) {
        this.impressions = impressions;
    }

    public Float getFrequency() {
        return frequency;
    }

    public void setFrequency(Float frequency) {
        this.frequency = frequency;
    }

    public Integer getReachs() {
        return reachs;
    }

    public void setReachs(Integer reachs) {
        this.reachs = reachs;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Integer getPurchases() {
        return purchases;
    }

    public void setPurchases(Integer purchases) {
        this.purchases = purchases;
    }

    public BigDecimal getCostGeneral() {
        return costGeneral;
    }

    public void setCostGeneral(BigDecimal costGeneral) {
        this.costGeneral = costGeneral;
    }

    public BigDecimal getCostPurchasing() {
        return costPurchasing;
    }

    public void setCostPurchasing(BigDecimal costPurchasing) {
        this.costPurchasing = costPurchasing;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}