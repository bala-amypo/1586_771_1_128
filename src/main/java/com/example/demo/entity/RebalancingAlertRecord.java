package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.repository.RebalancingAlertRepository;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.stereotype.Service;

@Service
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRepository repository;

    public RebalancingAlertServiceImpl(RebalancingAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        // Tests expect:
        // throw IllegalArgumentException when currentPercentage <= targetPercentage
        if (alert.getCurrentPercentage() <= alert.getTargetPercentage()) {
            throw new IllegalArgumentException("Invalid Alert Logic: currentPercentage > targetPercentage");
        }
        return repository.save(alert);
    }
}
