package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository alertRepo;

    public RebalancingAlertServiceImpl(RebalancingAlertRecordRepository alertRepo) {
        this.alertRepo = alertRepo;
    }

    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        // constructor validation enforces: currentPercentage > targetPercentage
        return alertRepo.save(alert);
    }

    @Override
    public RebalancingAlertRecord resolveAlert(Long id) {
        RebalancingAlertRecord alert = alertRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert with id " + id));

        alert.setResolved(true);
        return alertRepo.save(alert);
    }

    @Override
    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return alertRepo.findByInvestorId(investorId);
    }

    @Override
    public RebalancingAlertRecord getAlertById(Long id) {
        return alertRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert with id " + id));
    }

    @Override
    public List<RebalancingAlertRecord> getAllAlerts() {
        return alertRepo.findAll();
    }
}
