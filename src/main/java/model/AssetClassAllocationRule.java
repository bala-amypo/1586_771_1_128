package com.example.demo.model;
public class AssetClassAllocationRule {
    private Long id;
    private Long investorId;
    private assertclassType assertclass;
  
    private Double targetpercentage;
    private Boolean active;
    public AssetClassAllocationRule(Long investorId, Double targetpercentage, Boolean active) {
        this.investorId = investorId;
        this.targetpercentage = targetpercentage;
        this.active = active;
    }
    public Long getInvestorId() {
        return investorId;
    }
    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }
    public Double getTargetpercentage() {
        return targetpercentage;
    }
    public void setTargetpercentage(Double targetpercentage) {
        this.targetpercentage = targetpercentage;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    

}