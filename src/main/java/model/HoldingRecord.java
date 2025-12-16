package com.example.demo.model;

import java.time.LocalDateTime;

public class AssetClassAllocationRule {
    private Long id;
    private long investrId;
    private  assetClassType assertclass;
    private Double currentvalue;
    private LocalDateTime snapshotDate;
    public AssetClassAllocationRule(long investrId, Double currentvalue, LocalDateTime snapshotDate) {
        this.investrId = investrId;
        this.currentvalue = currentvalue;
        this.snapshotDate = snapshotDate;
    }
    public long getInvestrId() {
        return investrId;
    }
    public void setInvestrId(long investrId) {
        this.investrId = investrId;
    }
    public Double getCurrentvalue() {
        return currentvalue;
    }
    public void setCurrentvalue(Double currentvalue) {
        this.currentvalue = currentvalue;
    }
    public LocalDateTime getSnapshotDate() {
        return snapshotDate;
    }
    public void setSnapshotDate(LocalDateTime snapshotDate) {
        this.snapshotDate = snapshotDate;
    }
    
}