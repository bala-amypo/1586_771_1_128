package com.demo.service.impl;

import com.demo.model.*;
import com.demo.repository.AllocationSnapshotRepository;
import com.demo.repository.RebalancingAlertRepository;
import com.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    @Autowired
    private HoldingRecordService holdingService;

    @Autowired
    private AllocationRuleService ruleService;

    @Autowired
    private AllocationSnapshotRepository snapshotRepo;

    @Autowired
    private RebalancingAlertRepository alertRepo;

    @Override
    public void computeSnapshot(Long investorId) {
        List<HoldingRecord> holdings = holdingService.getHoldingsByInvestor(investorId);
        if (holdings == null || holdings.isEmpty()) {
            throw new RuntimeException("No holdings");
        }

        double totalValue = holdings.stream().mapToDouble(HoldingRecord::getValue).sum();
        List<AssetClassAllocationRule> activeRules = ruleService.getActiveRules(investorId);

        for (AssetClassAllocationRule rule : activeRules) {
            double currentAssetValue = holdings.stream()
                    .filter(h -> h.getAssetClass().equalsIgnoreCase(rule.getAssetClass()))
                    .mapToDouble(HoldingRecord::getValue)
                    .sum();

            double currentPercentage = (currentAssetValue / totalValue) * 100;

            AllocationSnapshot snapshot = new AllocationSnapshot();
            snapshot.setInvestorId(investorId);
            snapshot.setAssetClass(rule.getAssetClass());
            snapshot.setActualPercentage(currentPercentage);
            snapshotRepo.save(snapshot);

            if (Math.abs(currentPercentage - rule.getPercentage()) > 5.0) {
                RebalancingAlert alert = new RebalancingAlert();
                alert.setInvestorId(investorId);
                alert.setMessage("Threshold exceeded for " + rule.getAssetClass());
                alertRepo.save(alert);
            }
        }
    }
}