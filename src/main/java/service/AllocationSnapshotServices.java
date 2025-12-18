import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AllocationSnapshotService {

    private final AllocationSnapshotRepository snapshotRepository;
    private final HoldingRecordService holdingService;
    private final AllocationRulesService ruleService;
    private final RebalancingAlertService alertService;

    public AllocationSnapshotService(AllocationSnapshotRepository snapshotRepository,
                                     HoldingRecordService holdingService,
                                     AllocationRulesService ruleService,
                                     RebalancingAlertService alertService) {
        this.snapshotRepository = snapshotRepository;
        this.holdingService = holdingService;
        this.ruleService = ruleService;
        this.alertService = alertService;
    }

    public void computeSnapshot(Long investorId) {
        List<HoldingRecord> holdings = holdingService.getHoldingsByInvestor(investorId);
        if (holdings.isEmpty()) {
            throw new RuntimeException("No holdings");
        }

        double totalValue = holdings.stream().mapToDouble(HoldingRecord::getValue).sum();

        Map<String, Double> assetTotals = holdings.stream()
                .collect(Collectors.groupingBy(HoldingRecord::getAssetClass,
                        Collectors.summingDouble(HoldingRecord::getValue)));

        AllocationSnapshot snapshot = new AllocationSnapshot();
        snapshot.setInvestorId(investorId);
        snapshot.setTotalValue(totalValue);
        snapshotRepository.save(snapshot);

        List<AssetClassAllocationRule> activeRules = ruleService.getActiveRules(investorId);
        for (AssetClassAllocationRule rule : activeRules) {
            double currentVal = assetTotals.getOrDefault(rule.getAssetClass(), 0.0);
            double currentPercentage = (currentVal / totalValue) * 100;

            if (currentPercentage > rule.getPercentage()) {
                RebalancingAlertRecord alert = new RebalancingAlertRecord();
                alert.setInvestorId(investorId);
                alert.setCurrentPercentage(currentPercentage);
                alert.setTargetPercentage(rule.getPercentage());
                alertService.createAlert(alert);
            }
        }
    }

    public AllocationSnapshot getSnapshotById(Long id) {
        return snapshotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Snapshot not found"));
    }

    public List<AllocationSnapshot> getSnapshotsByInvestor(Long investorId) {
        return snapshotRepository.findByInvestorId(investorId);
    }

    public List<AllocationSnapshot> getAllSnapshots() {
        return snapshotRepository.findAll();
    }
}