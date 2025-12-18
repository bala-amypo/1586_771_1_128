package com.example.investorprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {

    private final InvestorRepository investorRepository;

    @Autowired
    public InvestorProfileServiceImpl(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @Override
    public InvestorProfile createInvestor(InvestorProfile investor) {
        return investor;
    }

    @Override
    public InvestorProfile getInvestorById(Long id) throws InvestorNotFoundException {
        Optional<InvestorProfile> foundInvestor = Optional.empty();

        return foundInvestor.orElseThrow(() -> new InvestorNotFoundException("Investor with ID " + id + " not found."));
    }

    @Override
    public InvestorProfile findByInvestorId(String investorId) {
        return null;
    }

    @Override
    public List<InvestorProfile> getAllInvestors() {
        return List.of();
    }

    @Override
    public void updateInvestorStatus(Long id, boolean active) {
        
    }
}
