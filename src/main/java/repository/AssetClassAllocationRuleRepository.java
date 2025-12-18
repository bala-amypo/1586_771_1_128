package com.example.project.repository;

import com.example.project.model.AssetClassAllocationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetClassAllocationRuleRepository extends JpaRepository<AssetClassAllocationRule, Long> {
}