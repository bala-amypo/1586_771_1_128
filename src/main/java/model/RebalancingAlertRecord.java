package com.example.demo.model;
public class RebalancingAlertRecord {
    private Long id;
    private Long investorId;
    private AssetClassType assetClass; // Enum
    private Double currentPercentage;
    private Double targetPercentage;
    private AlertSeverity severity; // Enum
    private String message;
    private LocalDateTime alertDate;
    private Boolean resolved;
    public RebalancingAlertRecord(Long investorId, AssetClassType assetClass, Double currentPercentage,
            Double targetPercentage, AlertSeverity severity, String message, LocalDateTime alertDate,
            Boolean resolved) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentPercentage = currentPercentage;
        this.targetPercentage = targetPercentage;
        this.severity = severity;
        this.message = message;
        this.alertDate = alertDate;
        this.resolved = resolved;
    }
    public Long getInvestorId() {
        return investorId;
    }
    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }
    public AssetClassType getAssetClass() {
        return assetClass;
    }
    public void setAssetClass(AssetClassType assetClass) {
        this.assetClass = assetClass;
    }
    public Double getCurrentPercentage() {
        return currentPercentage;
    }
    public void setCurrentPercentage(Double currentPercentage) {
        this.currentPercentage = currentPercentage;
    }
    public Double getTargetPercentage() {
        return targetPercentage;
    }
    public void setTargetPercentage(Double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }
    public AlertSeverity getSeverity() {
        return severity;
    }
    public void setSeverity(AlertSeverity severity) {
        this.severity = severity;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getAlertDate() {
        return alertDate;
    }
    public void setAlertDate(LocalDateTime alertDate) {
        this.alertDate = alertDate;
    }
    public Boolean getResolved() {
        return resolved;
    }
    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
    
}