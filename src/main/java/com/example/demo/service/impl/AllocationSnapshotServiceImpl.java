package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.entity.enums.AlertSeverity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository snapshotRepo;
    private final HoldingRecordRepository holdingRepo;
    private final AssetClassAllocationRuleRepository ruleRepo;
    private final RebalancingAlertRecordRepository alertRepo;

    // order matches test suite constructor expectations
    public AllocationSnapshotServiceImpl(AllocationSnapshotRecordRepository snapshotRepo,
                                         HoldingRecordRepository holdingRepo,
                                         AssetClassAllocationRuleRepository ruleRepo,
                                         RebalancingAlertRecordRepository alertRepo) {
        this.snapshotRepo = snapshotRepo;
        this.holdingRepo = holdingRepo;
        this.ruleRepo = ruleRepo;
        this.alertRepo = alertRepo;
    }

    @Override
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        List<HoldingRecord> holdings = holdingRepo.findByInvestorId(investorId);

        if (holdings.isEmpty()) {
            throw new IllegalArgumentException("No holdings for investor " + investorId);
        }

        // --- total value ---
        double total = holdings.stream()
                .mapToDouble(HoldingRecord::getCurrentValue)
                .sum();

        if (total <= 0) {
            throw new IllegalArgumentException("Invalid Value: must be > 0");
        }

        // --- calculate per-asset percentages ---
        Map<String, Double> allocation = new HashMap<>();
        for (HoldingRecord h : holdings) {
            double percent = (h.getCurrentValue() / total) * 100.0;
            allocation.merge(h.getAssetClass().name(), percent, Double::sum);
        }

        // --- build allocation JSON (simple key-value) ---
        StringBuilder jsonBuilder = new StringBuilder("{");
        allocation.forEach((k, v) -> jsonBuilder.append("\"").append(k).append("\":").append(v).append(","));
        if (jsonBuilder.length() > 1) {
            jsonBuilder.setLength(jsonBuilder.length() - 1);
        }
        jsonBuilder.append("}");

        // --- create snapshot record ---
        AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord(
                investorId,
                LocalDateTime.now(),
                total,
                jsonBuilder.toString()
        );

        snapshotRepo.save(snapshot);

        // --- load active rules ---
        List<AssetClassAllocationRule> rules = ruleRepo.findByInvestorIdAndActiveTrue(investorId);

        // --- generate alerts if percentage > target ---
        for (AssetClassAllocationRule rule : rules) {
            double currentPct = allocation.getOrDefault(rule.getAssetClass().name(), 0.0);

            if (currentPct > rule.getTargetPercentage()) {
                RebalancingAlertRecord alert = new RebalancingAlertRecord(
                        investorId,
                        rule.getAssetClass(),
                        currentPct,
                        rule.getTargetPercentage(),
                        determineSeverity(currentPct, rule.getTargetPercentage()),
                        "Rebalancing required",
                        LocalDateTime.now(),
                        false
                );
                alertRepo.save(alert);
            }
        }

        return snapshot;
    }

    // simple severity logic for demo
    private AlertSeverity determineSeverity(double current, double target) {
        double deviation = current - target;
        if (deviation > 20) return AlertSeverity.HIGH;
        if (deviation > 10) return AlertSeverity.MEDIUM;
        return AlertSeverity.LOW;
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snapshot with id " + id));
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        return snapshotRepo.findByInvestorId(investorId);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepo.findAll();
    }
}
