package com.example.demo.controller;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocation-rules")
public class AllocationRuleController {

    private final AllocationRuleService ruleService;

    public AllocationRuleController(AllocationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public AssetClassAllocationRule create(@RequestBody AssetClassAllocationRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public AssetClassAllocationRule update(@PathVariable Long id, @RequestBody AssetClassAllocationRule updatedRule) {
        return ruleService.updateRule(id, updatedRule);
    }

    @GetMapping("/investor/{investorId}")
    public List<AssetClassAllocationRule> getRulesByInvestor(@PathVariable Long investorId) {
        return ruleService.getRulesByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public AssetClassAllocationRule getById(@PathVariable Long id) {
        return ruleService.getRuleById(id);
    }

    @GetMapping
    public List<AssetClassAllocationRule> getAll() {
        return ruleService.getAllRules();
    }
}
