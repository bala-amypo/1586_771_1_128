package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;

@Entity
@Table(name = "allocation_rules")
public class AssetClassAllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private Double targetPercentage;

    private Boolean active = true;

    // ---- Constructors ----
    public AssetClassAllocationRule() {}

    public AssetClassAllocationRule(Long investorId, AssetClassType assetClass,
                                    Double targetPercentage, Boolean active) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.targetPercentage = targetPercentage;
        this.active = active;
    }

    // ---- Getters & Setters ----
    public Long getId() { return id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public Double getTargetPercentage() { return targetPercentage; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }
    public void setAssetClass(AssetClassType assetClass) { this.assetClass = assetClass; }
    public void setTargetPercentage(Double targetPercentage) { this.targetPercentage = targetPercentage; }
    public void setActive(Boolean active) { this.active = active; }
}
