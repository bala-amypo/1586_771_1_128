package com.example.demo.repository;

import com.example.demo.entity.*;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.*;
import java.util.*;
public interface AssetClassAllocationRuleRepository
        extends JpaRepository<AssetClassAllocationRule, Long> {

    List<AssetClassAllocationRule> findByInvestorId(Long investorId);

    @Query("select r from AssetClassAllocationRule r where r.investorId=?1 and r.active=true")
    List<AssetClassAllocationRule> findActiveRulesHql(Long investorId);

    List<AssetClassAllocationRule> findByInvestorIdAndActiveTrue(Long investorId);
}
