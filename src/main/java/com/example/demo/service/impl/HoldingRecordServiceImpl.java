package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository holdingRepo;

    public HoldingRecordServiceImpl(HoldingRecordRepository holdingRepo) {
        this.holdingRepo = holdingRepo;
    }

    @Override
    public HoldingRecord recordHolding(HoldingRecord holding) {
        // validation is enforced in constructor + setter
        return holdingRepo.save(holding);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return holdingRepo.findByInvestorId(investorId);
    }

    @Override
    public Optional<HoldingRecord> getHoldingById(Long id) {
        return holdingRepo.findById(id);
    }

    @Override
    public List<HoldingRecord> getAllHoldings() {
        return holdingRepo.findAll();
    }
}
