package com.demo.service.impl;

import com.demo.model.RebalancingAlertRecord;
import com.demo.repository.RebalancingAlertRepository;
import com.demo.service.RebalancingAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    @Autowired
    private RebalancingAlertRepository alertRepo;

    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        if (alert.getCurrentValue() > alert.getTargetValue()) {
            return alertRepo.save(alert);
        }
        return null;
    }

    @Override
    public void resolveAlert(Long id) {
        alertRepo.deleteById(id);
    }

    @Override
    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return alertRepo.findByInvestorId(investorId);
    }

    @Override
    public RebalancingAlertRecord getAlertById(Long id) {
        return alertRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @Override
    public List<RebalancingAlertRecord> getAllAlerts() {
        return alertRepo.findAll();
    }
}