package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {

    // get holdings for a given investor
    List<HoldingRecord> findByInvestorId(Long investorId);

    // compare using field `currentValue`
    List<HoldingRecord> findByCurrentValueGreaterThan(Double currentValue);

    // FIXED: use investorId, not investor
    List<HoldingRecord> findByInvestorIdAndAssetClass(Long investorId, AssetClassType assetClass);
}
