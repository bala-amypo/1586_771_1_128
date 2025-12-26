package com.example.demo.controller;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorProfileService investorService;

    public InvestorProfileController(InvestorProfileService investorService) {
        this.investorService = investorService;
    }

    @PostMapping
    public InvestorProfile create(@RequestBody InvestorProfile investor) {
        return investorService.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public InvestorProfile getById(@PathVariable Long id) {
        return investorService.getInvestorById(id);
    }

    @GetMapping
    public List<InvestorProfile> getAll() {
        return investorService.getAllInvestors();
    }

    @PutMapping("/{id}/status")
    public InvestorProfile updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return investorService.updateInvestorStatus(id, active);
    }

    @GetMapping("/lookup/{investorId}")
    public Optional<InvestorProfile> findByInvestorId(@PathVariable String investorId) {
        return investorService.findByInvestorId(investorId);
    }
}
