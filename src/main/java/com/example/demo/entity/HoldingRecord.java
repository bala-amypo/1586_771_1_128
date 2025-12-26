package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;

@Entity
@Table(name = "holding_records")
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private Double currentValue;

    public HoldingRecord() {}

    public HoldingRecord(Long investorId, AssetClassType assetClass, Double currentValue) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentValue = currentValue;
    }

    public Long getId() { return id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public Double getCurrentValue() { return currentValue; }

    public void setId(Long id) { this.id = id; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }
    public void setAssetClass(AssetClassType assetClass) { this.assetClass = assetClass; }
    public void setCurrentValue(Double currentValue) { this.currentValue = currentValue; }
}
