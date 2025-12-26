package com.example.demo.repositories;

import com.example.demo.model.RebalancingAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebalancingAlertRecordRepository
        extends JpaRepository<RebalancingAlertRecord, Long> {
}
