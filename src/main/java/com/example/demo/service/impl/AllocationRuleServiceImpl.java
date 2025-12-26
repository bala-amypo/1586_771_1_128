package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AllocationRuleRepository repository;

    public AllocationRuleServiceImpl(AllocationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        if (rule.getTargetPercentage() < 0 || rule.getTargetPercentage() > 100) {
            throw new IllegalArgumentException("Invalid Percentage: between 0 and 100");
        }
        return repository.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updatedRule) {
        return repository.findById(id)
                .map(existing -> {
                    if (updatedRule.getTargetPercentage() < 0 || updatedRule.getTargetPercentage() > 100) {
                        throw new IllegalArgumentException("Invalid Percentage: between 0 and 100");
                    }
                    existing.setTargetPercentage(updatedRule.getTargetPercentage());
                    existing.setActive(updatedRule.getActive());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException("Rule not found"));
    }
}
