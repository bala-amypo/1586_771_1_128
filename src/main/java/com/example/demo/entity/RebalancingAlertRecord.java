package com.example.demo.entity;

import com.example.demo.entity.enums.AlertSeverity;
import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;

@Entity
@Table(name = "rebalancing_alerts")
public class RebalancingAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private Double currentPercentage;

    private Double targetPercentage;

    @Enumerated(EnumType.STRING)
    private AlertSeverity severity;

    private Boolean resolved = false;

    public RebalancingAlertRecord() {}

    public RebalancingAlertRecord(Long investorId, AssetClassType assetClass,
                                  Double currentPercentage, Double targetPercentage,
                                  AlertSeverity severity) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentPercentage = currentPercentage;
        this.targetPercentage = targetPercentage;
        this.severity = severity;
    }

    public Long getId() { return id; }
    public Long getInvestorId() { return investorId; }
    public AssetClassType getAssetClass() { return assetClass; }
    public Double getCurrentPercentage() { return currentPercentage; }
    public Double getTargetPercentage() { return targetPercentage; }
    public AlertSeverity getSeverity() { return severity; }
    public Boolean getResolved() { return resolved; }

    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
