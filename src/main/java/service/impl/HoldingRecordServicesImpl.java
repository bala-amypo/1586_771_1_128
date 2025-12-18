// package com.demo.service.impl;

// import com.demo.model.HoldingRecord;
// import com.demo.repository.HoldingRecordRepository;
// import com.demo.service.HoldingRecordService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import java.util.List;

// @Service
// @Transactional
// public class HoldingRecordServiceImpl implements HoldingRecordService {

//     @Autowired
//     private HoldingRecordRepository holdingRepo;

//     @Override
//     public HoldingRecord recordHolding(HoldingRecord holding) {
//         if (holding.getValue() <= 0) {
//             throw new IllegalArgumentException("Value must be > 0");
//         }
//         return holdingRepo.save(holding);
//     }

//     @Override
//     public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
//         return holdingRepo.findByInvestorProfileId(investorId);
//     }

//     @Override
//     public HoldingRecord getHoldingById(Long id) {
//         return holdingRepo.findById(id).orElseThrow(() -> new RuntimeException("Holding not found"));
//     }

//     @Override
//     public List<HoldingRecord> getAllHoldings() {
//         return holdingRepo.findAll();
//     }
// }