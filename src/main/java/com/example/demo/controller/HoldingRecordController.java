package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class HoldingRecordController {

    private final HoldingRecordServiceImpl service;

    public HoldingRecordController(HoldingRecordServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HoldingRecord> recordHolding(
            @RequestBody HoldingRecord holding) {
        return ResponseEntity.ok(service.recordHolding(holding));
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<HoldingRecord>> getHoldings(
            @PathVariable Long investorId) {
        return ResponseEntity.ok(service.getHoldingsByInvestor(investorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoldingRecord> getHolding(@PathVariable Long id) {
        return service.getHoldingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
