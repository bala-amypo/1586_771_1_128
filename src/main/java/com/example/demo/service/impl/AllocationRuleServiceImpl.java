package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AssetClassAllocationRuleRepository ruleRepo;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        // constructor already validates 0-100 range
        return ruleRepo.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updatedRule) {
        AssetClassAllocationRule existing = ruleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule with id " + id));

        existing.setAssetClass(updatedRule.getAssetClass());
        existing.setTargetPercentage(updatedRule.getTargetPercentage());
        existing.setActive(updatedRule.getActive());
        existing.setInvestorId(updatedRule.getInvestorId());

        return ruleRepo.save(existing);
    }

    @Override
    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return ruleRepo.findByInvestorId(investorId);
    }

    @Override
    public List<AssetClassAllocationRule> getActiveRules(Long investorId) {
        return ruleRepo.findByInvestorIdAndActiveTrue(investorId);
    }

    @Override
    public AssetClassAllocationRule getRuleById(Long id) {
        return ruleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule with id " + id));
    }

    @Override
    public List<AssetClassAllocationRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
