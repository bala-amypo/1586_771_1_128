// package com.example.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "rebalancing_alert")
// public class RebalancingAlertRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "investor_id", nullable = false)
//     private Long investorId;

//     @Enumerated(EnumType.STRING)
//     @Column(name = "asset_class", nullable = false)
//     private AssetClassType assetClass;

//     @Column(name = "current_percentage", nullable = false)
//     private Double currentPercentage;

//     @Column(name = "target_percentage", nullable = false)
//     private Double targetPercentage;

//     @Enumerated(EnumType.STRING)
//     @Column(name = "severity", nullable = false)
//     private AlertSeverity severity;

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

//     public AssetClassType getAssetClass() {
//         return assetClass;
//     }

//     public void setAssetClass(AssetClassType assetClass) {
//         this.assetClass = assetClass;
//     }

//     public Double getCurrentPercentage() {
//         return currentPercentage;
//     }

//     public void setCurrentPercentage(Double currentPercentage) {
//         this.currentPercentage = currentPercentage;
//     }

//     public Double getTargetPercentage() {
//         return targetPercentage;
//     }

//     public void setTargetPercentage(Double targetPercentage) {
//         this.targetPercentage = targetPercentage;
//     }

//     public AlertSeverity getSeverity() {
//         return severity;
//     }

//     public void setSeverity(AlertSeverity severity) {
//         this.severity = severity;
//     }
// }
