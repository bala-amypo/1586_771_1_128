package com.example.demo.service;

import com.example.demo.model.InvestorProfile;
import java.util.List;
import java.util.Optional;

public interface InvestorProfileService {
    InvestorProfile createInvestor(InvestorProfile investorProfile);
    Optional<InvestorProfile> getInvestorById(Long id);
    List<InvestorProfile> getAllInvestors();
    InvestorProfile updateInvestorStatus(Long id, boolean active);
}
