package com.example.demo.repository;

import com.example.demo.entity.*;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.*;
import java.util.*;
public interface RebalancingAlertRecordRepository
        extends JpaRepository<RebalancingAlertRecord, Long> {

    List<RebalancingAlertRecord> findByInvestorId(Long investorId);
}
