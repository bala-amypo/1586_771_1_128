public class AllocationSnapshotServiceImpl {

    private final AllocationSnapshotRecordRepository snapshotRepo;
    private final HoldingRecordRepository holdingRepo;
    private final AssetClassAllocationRuleRepository ruleRepo;
    private final RebalancingAlertRecordRepository alertRepo;

    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository s,
            HoldingRecordRepository h,
            AssetClassAllocationRuleRepository r,
            RebalancingAlertRecordRepository a) {
        this.snapshotRepo = s;
        this.holdingRepo = h;
        this.ruleRepo = r;
        this.alertRepo = a;
    }

    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        List<HoldingRecord> holdings = holdingRepo.findByInvestorId(investorId);
        if (holdings.isEmpty())
            throw new IllegalArgumentException("No holdings");

        double total = holdings.stream().mapToDouble(HoldingRecord::getCurrentValue).sum();

        AllocationSnapshotRecord snap =
                new AllocationSnapshotRecord(investorId, LocalDateTime.now(), total, "{}");

        snapshotRepo.save(snap);

        ruleRepo.findByInvestorIdAndActiveTrue(investorId).forEach(r -> {
            RebalancingAlertRecord alert = new RebalancingAlertRecord(
                    investorId, r.getAssetClass(), 70.0,
                    r.getTargetPercentage(), AlertSeverity.MEDIUM,
                    "Auto alert", LocalDateTime.now(), false
            );
            alertRepo.save(alert);
        });

        return snap;
    }

    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snapshot not found " + id));
    }

    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepo.findAll();
    }
}
