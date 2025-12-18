package com.example.demo.service.impl;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.InvestorProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {

    private final InvestorProfileRepository repository;

    public InvestorProfileServiceImpl(InvestorProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public InvestorProfile createInvestor(InvestorProfile investor) {
        return repository.save(investor);
    }

    @Override
    public InvestorProfile getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<InvestorProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public InvestorProfile updateStatus(Long id, boolean active) {
        InvestorProfile p = getById(id);
        p.setActive(active);
        return repository.save(p);
    }
}
