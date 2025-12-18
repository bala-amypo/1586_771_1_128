// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/holdings")
// public class HoldingRecordController {
//     private final HoldingRecordService service;

//     public HoldingRecordController(HoldingRecordService service) {
//         this.service = service;
//     }

//     @PostMapping("/")
//     public HoldingRecord recordHolding(@RequestBody HoldingRecord holding) {
//         return service.recordHolding(holding);
//     }

//     @GetMapping("/investor/{investorId}")
//     public List<HoldingRecord> getByInvestor(@PathVariable Long investorId) {
//         return service.getHoldingsByInvestor(investorId);
//     }

//     @GetMapping("/{id}")
//     public HoldingRecord getById(@PathVariable Long id) {
//         return service.getHoldingById(id);
//     }

//     @GetMapping("/")
//     public List<HoldingRecord> listAll() {
//         return service.getAllHoldings();
//     }
// }