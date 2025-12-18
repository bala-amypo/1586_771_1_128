package com.example.demo.service.impl;

import com.example.demo.model.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.InvestorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {

    private final InvestorProfileRepository investorProfileRepository;

    @Autowired
    public InvestorProfileServiceImpl(InvestorProfileRepository investorProfileRepository) {
        this.investorProfileRepository = investorProfileRepository;
    }

    @Override
    public InvestorProfile createInvestor(InvestorProfile investorProfile) {
        return investorProfileRepository.save(investorProfile);
    }

    @Override
    public Optional<InvestorProfile> getInvestorById(Long id) {
        return investorProfileRepository.findById(id);
    }

    @Override
    public List<InvestorProfile> getAllInvestors() {
        return investorProfileRepository.findAll();
    }

    @Override
    public InvestorProfile updateInvestorStatus(Long id, boolean active) {
        InvestorProfile existingInvestor = investorProfileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Investor with ID " + id + " not found."));

        existingInvestor.setActive(active);
        return investorProfileRepository.save(existingInvestor);
    }
}
