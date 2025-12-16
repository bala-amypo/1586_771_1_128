package com.example.demo.model;

import java.time.LocalDateTime;

public class AllocationSnapshotRecord {
    private Long id;
    private Long investorId;
    private LocalDateTime snapshotDate;
    private Double totalPortfolioValue;
    private String allocationJson;
    public AllocationSnapshotRecord(Long investorId, LocalDateTime snapshotDate, Double totalPortfolioValue, String allocationJson) {
        this.investorId = investorId;
        this.snapshotDate = snapshotDate;
        this.totalPortfolioValue = totalPortfolioValue;
        this.allocationJson = allocationJson;
    }
    public Long getInvestorId() {
        return investorId;
    }
    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }
    public LocalDateTime getSnapshotDate() {
        return snapshotDate;
    }
    public void setSnapshotDate(LocalDateTime snapshotDate) {
        this.snapshotDate = snapshotDate;
    }
    public Double getTotalPortfolioValue() {
        return totalPortfolioValue;
    }
    public void setTotalPortfolioValue(Double totalPortfolioValue) {
        this.totalPortfolioValue = totalPortfolioValue;
    }
    public String getAllocationJson() {
        return allocationJson;
    }
    public void setAllocationJson(String allocationJson) {
        this.allocationJson = allocationJson;
    }
    
}
