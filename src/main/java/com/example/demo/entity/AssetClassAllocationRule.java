package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;

@Entity
public class AssetClassAllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private Double targetPercentage;
    private Boolean active;

    public AssetClassAllocationRule() {}

    public AssetClassAllocationRule(Long investorId, AssetClassType assetClass,
                                    Double targetPercentage, Boolean active) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.targetPercentage = targetPercentage;
        this.active = active;
    }

    // getters
    public Long getId() { return id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public Double getTargetPercentage() { return targetPercentage; }
    public Boolean getActive() { return active; }

    // ✅ REQUIRED SETTERS (THIS WAS MISSING)
    public void setId(Long id) {
        this.id = id;
    }

    public void setTargetPercentage(Double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
