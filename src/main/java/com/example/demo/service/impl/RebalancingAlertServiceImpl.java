public class RebalancingAlertServiceImpl {

    private final RebalancingAlertRecordRepository repo;

    public RebalancingAlertServiceImpl(RebalancingAlertRecordRepository repo) {
        this.repo = repo;
    }

    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        if (alert.getCurrentPercentage() <= alert.getTargetPercentage())
            throw new IllegalArgumentException("currentPercentage > targetPercentage");
        return repo.save(alert);
    }

    public RebalancingAlertRecord resolveAlert(Long id) {
        RebalancingAlertRecord a = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found " + id));
        a.setResolved(true);
        return repo.save(a);
    }

    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }
}
