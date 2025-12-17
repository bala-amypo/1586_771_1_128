package com.demo.service.impl;

import com.demo.model.AssetClassAllocationRule;
import com.demo.repository.AllocationRuleRepository;
import com.demo.service.AllocationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AllocationRuleServiceImpl implements AllocationRuleService {

    @Autowired
    private AllocationRuleRepository ruleRepo;

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        if (rule.getPercentage() < 0 || rule.getPercentage() > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }
        return ruleRepo.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updatedRule) {
        if (!ruleRepo.existsById(id)) throw new RuntimeException("Rule not found");
        updatedRule.setId(id);
        return ruleRepo.save(updatedRule);
    }

    @Override
    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return ruleRepo.findByInvestorProfileId(investorId);
    }

    @Override
    public List<AssetClassAllocationRule> getActiveRules(Long investorId) {
        return ruleRepo.findByInvestorProfileIdAndIsActiveTrue(investorId);
    }

    @Override
    public AssetClassAllocationRule getRuleById(Long id) {
        return ruleRepo.findById(id).orElseThrow(() -> new RuntimeException("Rule not found"));
    }
}