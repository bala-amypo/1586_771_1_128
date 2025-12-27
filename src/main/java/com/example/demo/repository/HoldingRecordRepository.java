package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {

    // holdings for investor
    List<HoldingRecord> findByInvestorId(Long investorId);

    // HQL-like test — test checks signature
    List<HoldingRecord> findBycurrentValueGreaterThan(Double currentValue);

    // used in testGetHoldingByAssetClass (signature exact)
    List<HoldingRecord> findByInvestorAndAssetClass(Long investorId, AssetClassType assetClass);
}
