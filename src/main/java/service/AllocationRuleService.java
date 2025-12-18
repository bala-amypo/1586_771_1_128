// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class AllocationRulesService {

//     private final AllocationRuleRepository repository;

//     public AllocationRulesService(AllocationRuleRepository repository) {
//         this.repository = repository;
//     }

//     public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
//         if (rule.getPercentage() < 0 || rule.getPercentage() > 100) {
//             throw new IllegalArgumentException("Percentage must be between 0-100");
//         }
//         return repository.save(rule);
//     }

//     public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updatedRule) {
//         AssetClassAllocationRule existing = getRuleById(id);
//         existing.setPercentage(updatedRule.getPercentage());
//         existing.setAssetClass(updatedRule.getAssetClass());
//         return repository.save(existing);
//     }

//     public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
//         return repository.findByInvestorId(investorId);
//     }

//     public List<AssetClassAllocationRule> getActiveRules(Long investorId) {
//         return repository.findByInvestorIdAndActiveTrue(investorId);
//     }

//     public AssetClassAllocationRule getRuleById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Rule not found"));
//     }
// }