// package com.example.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "allocation_snapshot")
// public class AllocationSnapshotRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "investor_id", nullable = false)
//     private Long investorId;

//     @Column(name = "snapshot_date", nullable = false)
//     private LocalDateTime snapshotDate;

//     @Column(name = "total_portfolio_value", nullable = false)
//     private Double totalPortfolioValue;

//     @Column(name = "allocation_json", columnDefinition = "TEXT")
//     private String allocationJson;

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getInvestorId() {
//         return investorId;
//     }

//     public void setInvestorId(Long investorId) {
//         this.investorId = investorId;
//     }

//     public LocalDateTime getSnapshotDate() {
//         return snapshotDate;
//     }

//     public void setSnapshotDate(LocalDateTime snapshotDate) {
//         this.snapshotDate = snapshotDate;
//     }

//     public Double getTotalPortfolioValue() {
//         return totalPortfolioValue;
//     }

//     public void setTotalPortfolioValue(Double totalPortfolioValue) {
//         this.totalPortfolioValue = totalPortfolioValue;
//     }

//     public String getAllocationJson() {
//         return allocationJson;
//     }

//     public void setAllocationJson(String allocationJson) {
//         this.allocationJson = allocationJson;
//     }
// }