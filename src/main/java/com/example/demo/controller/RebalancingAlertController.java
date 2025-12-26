package com.example.demo.controller;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.service.RebalancingAlertServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class RebalancingAlertController {

    private final RebalancingAlertServiceImpl service;

    public RebalancingAlertController(RebalancingAlertServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RebalancingAlertRecord> createAlert(
            @RequestBody RebalancingAlertRecord alert) {
        return ResponseEntity.ok(service.createAlert(alert));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<RebalancingAlertRecord> resolveAlert(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.resolveAlert(id));
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<RebalancingAlertRecord>> getAlerts(
            @PathVariable Long investorId) {
        return ResponseEntity.ok(service.getAlertsByInvestor(investorId));
    }
}
