package com.demo.controller;

import com.demo.model.InvestorProfile;
import com.demo.service.InvestorProfileService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investors")
public class InvestorProfileController {

    private final InvestorProfileService service;

    public InvestorProfileController(InvestorProfileService service) {
        this.service = service;
    }

    @PostMapping
    public InvestorProfile create(@RequestBody InvestorProfile investorProfile) {
        return service.createInvestor(investorProfile);
    }

    @GetMapping("/{id}")
    public InvestorProfile getById(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    @GetMapping
    public List<InvestorProfile> getAll() {
        return service.getAllInvestors();
    }

    @PutMapping("/{id}")
    public InvestorProfile update(
            @PathVariable Long id,
            @RequestBody InvestorProfile investorProfile) {
        return service.updateInvestor(id, investorProfile);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteInvestor(id);
    }
}
