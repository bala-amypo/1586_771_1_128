package com.demo.example.service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InvestorProfileService {

    private final InvestorProfileRepository repository;

    public InvestorProfileService(InvestorProfileRepository repository) {
        this.repository = repository;
    }

    public InvestorProfile createInvestor(InvestorProfile investor) {
        return repository.save(investor);
    }

    public InvestorProfile getInvestorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investor not found"));
    }

    public Optional<InvestorProfile> findByInvestorId(String investorId) {
        return repository.findByInvestorId(investorId);
    }

    public List<InvestorProfile> getAllInvestors() {
        return repository.findAll();
    }

    public void updateInvestorStatus(Long id, boolean active) {
        InvestorProfile investor = getInvestorById(id);
        investor.setActive(active);
        repository.save(investor);
    }
}