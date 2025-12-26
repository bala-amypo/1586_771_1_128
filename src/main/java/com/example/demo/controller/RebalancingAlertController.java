package com.example.demo.controller;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class RebalancingAlertController {

    private final RebalancingAlertService alertService;

    public RebalancingAlertController(RebalancingAlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public RebalancingAlertRecord create(@RequestBody RebalancingAlertRecord alert) {
        return alertService.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public RebalancingAlertRecord resolve(@PathVariable Long id) {
        return alertService.resolveAlert(id);
    }

    @GetMapping("/investor/{investorId}")
    public List<RebalancingAlertRecord> getByInvestor(@PathVariable Long investorId) {
        return alertService.getAlertsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public RebalancingAlertRecord getById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @GetMapping
    public List<RebalancingAlertRecord> getAll() {
        return alertService.getAllAlerts();
    }
}
