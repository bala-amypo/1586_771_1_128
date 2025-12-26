package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.repositories.AllocationSnapshotRecordRepository;
import com.example.demo.repositories.RebalancingAlertRecordRepository;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository snapshotRepository;
    private final RebalancingAlertRecordRepository alertRecordRepository;

    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository snapshotRepository,
            RebalancingAlertRecordRepository alertRecordRepository) {
        this.snapshotRepository = snapshotRepository;
        this.alertRecordRepository = alertRecordRepository;
    }

    @Override
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord();
        snapshot.setInvestorId(investorId);

        // example logic (adjust as per your rules)
        List<RebalancingAlertRecord> alerts =
                alertRecordRepository.findByInvestorId(investorId);

        snapshot.setAlertCount(alerts.size());

        return snapshotRepository.save(snapshot);
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Snapshot not found"));
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        return snapshotRepository.findByInvestorId(investorId);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepository.findAll();
    }
}
