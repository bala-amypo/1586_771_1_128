package com.example.investor.controller;

import com.example.investor.model.Investor;
import com.example.investor.service.InvestorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorService service;

    public InvestorProfileController(InvestorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Investor> create(@RequestBody Investor investor) {
        return ResponseEntity.ok(service.create(investor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investor> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Investor>> listAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestBody String status) {
        service.updateStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lookup/{investorId}")
    public ResponseEntity<Investor> lookup(@PathVariable Long investorId) {
        // In this context, lookup is similar to getById
        return ResponseEntity.ok(service.getById(investorId));
    }
}