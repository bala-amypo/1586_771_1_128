// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class HoldingRecordService {

//     private final HoldingRecordRepository repository;

//     public HoldingRecordService(HoldingRecordRepository repository) {
//         this.repository = repository;
//     }

//     public HoldingRecord recordHolding(HoldingRecord holding) {
//         if (holding.getValue() <= 0) {
//             throw new IllegalArgumentException("Value must be > 0");
//         }
//         return repository.save(holding);
//     }

//     public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
//         return repository.findByInvestorId(investorId);
//     }

//     public HoldingRecord getHoldingById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Holding not found"));
//     }

//     public List<HoldingRecord> getAllHoldings() {
//         return repository.findAll();
//     }
// }