package com.example.demo.service;

import com.example.demo.entity.RebalancingAlertRecord;

import java.util.List;

public interface RebalancingAlertService {

    RebalancingAlertRecord createAlert(RebalancingAlertRecord alert);

    RebalancingAlertRecord getAlertById(Long id);   // ✅ ADD THIS

    List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId);

    RebalancingAlertRecord resolveAlert(Long alertId);

    List<RebalancingAlertRecord> getAllAlerts();
}
