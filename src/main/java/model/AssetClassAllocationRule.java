// package com.example.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "asset_allocation_rule")
// public class AssetClassAllocationRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "investor_id", nullable = false)
//     private Long investorId;

//     @Enumerated(EnumType.STRING)
//     @Column(name = "asset_class", nullable = false)
//     private AssetClassType assetClass;

//     @Column(name = "target_percentage", nullable = false)
//     private Double targetPercentage;

//     @Column(name = "active", nullable = false)
//     private Boolean active;

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

//     public Double getTargetPercentage() {
//         return targetPercentage;
//     }

//     public void setTargetPercentage(Double targetPercentage) {
//         this.targetPercentage = targetPercentage;
//     }

//     public Boolean getActive() {
//         return active;
//     }

//     public void setActive(Boolean active) {
//         this.active = active;
//     }
// }
