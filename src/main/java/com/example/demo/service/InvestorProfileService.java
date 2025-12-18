package com.example.demo.service;

import com.example.demo.entity.InvestorProfile;
import java.util.List;

public interface InvestorProfileService {
    InvestorProfile createInvestor(InvestorProfile investor);
    InvestorProfile getById(Long id);
    List<InvestorProfile> getAll();
    InvestorProfile updateStatus(Long id, boolean active);
}
