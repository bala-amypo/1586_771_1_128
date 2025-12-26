package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.repository.RebalancingAlertRepository;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRepository repository;

    public RebalancingAlertServiceImpl(RebalancingAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        if (alert.getCurrentPercentage() <= alert.getTargetPercentage()) {
            throw new IllegalArgumentException("Invalid Alert Logic: currentPercentage > targetPercentage");
        }
        return repository.save(alert);
    }

    @Override
    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    @Override
    public RebalancingAlertRecord resolveAlert(Long alertId) {
        return repository.findById(alertId)
                .map(alert -> {
                    alert.setResolved(true);
                    return repository.save(alert);
                })
                .orElseThrow(() -> new IllegalArgumentException("Alert not found"));
    }
}
