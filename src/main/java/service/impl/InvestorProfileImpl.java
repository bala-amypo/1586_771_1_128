package com.example.onetomany.model;

import com.demo.model.InvestorProfile;
import com.demo.repository.InvestorProfileRepository;
import com.demo.service.InvestorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class InvestorProfileServiceImpl implements InvestorProfileService {

    @Autowired
    private InvestorProfileRepository investorRepo;

    @Override
    public InvestorProfile createInvestor(InvestorProfile investor) {
        return investorRepo.save(investor);
    }

    @Override
    public InvestorProfile getInvestorById(Long id) {
        return investorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Investor not found"));
    }

    @Override
    public InvestorProfile findByInvestorId(String investorId) {
        return investorRepo.findByInvestorId(investorId);
    }

    @Override
    public List<InvestorProfile> getAllInvestors() {
        return investorRepo.findAll();
    }

    @Override
    public void updateInvestorStatus(Long id, boolean active) {
        InvestorProfile investor = getInvestorById(id);
        investor.setActive(active);
        investorRepo.save(investor);
    }
}