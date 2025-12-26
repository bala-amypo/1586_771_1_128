public class AllocationRuleServiceImpl {

    private final AssetClassAllocationRuleRepository repo;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository repo) {
        this.repo = repo;
    }

    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        validate(rule.getTargetPercentage());
        return repo.save(rule);
    }

    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updated) {
        AssetClassAllocationRule r = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found " + id));
        validate(updated.getTargetPercentage());
        r.setTargetPercentage(updated.getTargetPercentage());
        return repo.save(r);
    }

    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }

    private void validate(Double p) {
        if (p < 0 || p > 100)
            throw new IllegalArgumentException("between 0 and 100");
    }
}
