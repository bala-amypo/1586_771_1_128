package com.example.demo.service;

import com.example.demo.entity.RebalancingAlertRecord;

import java.util.List;

public interface RebalancingAlertService {

    RebalancingAlertRecord createAlert(RebalancingAlertRecord alert);

    RebalancingAlertRecord resolveAlert(Long id);

    List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId);

    // ✅ ADD THESE (controller needs them)
    RebalancingAlertRecord getAlertById(Long id);

    List<RebalancingAlertRecord> getAllAlerts();
}
