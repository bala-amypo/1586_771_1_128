package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RebalancingAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;
    private String assetClass;

    private Double currentPercentage;
    private Double targetPercentage;

    private boolean resolved = false;
    private LocalDateTime createdAt = LocalDateTime.now();

    public RebalancingAlertRecord() {}

    public RebalancingAlertRecord(Long investorId, String assetClass,
                                  Double currentPercentage, Double targetPercentage) {

        if (currentPercentage <= targetPercentage) {
            throw new IllegalArgumentException("Invalid Alert Logic: currentPercentage > targetPercentage");
        }

        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentPercentage = currentPercentage;
        this.targetPercentage = targetPercentage;
    }

    public Long getId() { return id; }
    public Long getInvestorId() { return investorId; }
    public String getAssetClass() { return assetClass; }
    public Double getCurrentPercentage() { return currentPercentage; }
    public Double getTargetPercentage() { return targetPercentage; }
    public boolean isResolved() { return resolved; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
