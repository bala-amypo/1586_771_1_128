// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/allocation-rules")
// public class AllocationRuleController {
//     private final AllocationRulesService service;

//     public AllocationRuleController(AllocationRulesService service) {
//         this.service = service;
//     }

//     @PostMapping("/")
//     public AssetClassAllocationRule createRule(@RequestBody AssetClassAllocationRule rule) {
//         return service.createRule(rule);
//     }

//     @PutMapping("/{id}")
//     public AssetClassAllocationRule updateRule(@PathVariable Long id, @RequestBody AssetClassAllocationRule rule) {
//         return service.updateRule(id, rule);
//     }

//     @GetMapping("/investor/{investorId}")
//     public List<AssetClassAllocationRule> getRulesByInvestor(@PathVariable Long investorId) {
//         return service.getRulesByInvestor(investorId);
//     }

//     @GetMapping("/{id}")
//     public AssetClassAllocationRule getRule(@PathVariable Long id) {
//         return service.getRuleById(id);
//     }

//     @GetMapping("/")
//     public List<AssetClassAllocationRule> getAll() {
//         return service.getActiveRules(null); // Or repository.findAll()
//     }
// }