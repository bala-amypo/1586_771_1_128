public class HoldingRecordServiceImpl {

    private final HoldingRecordRepository repo;

    public HoldingRecordServiceImpl(HoldingRecordRepository repo) {
        this.repo = repo;
    }

    public HoldingRecord recordHolding(HoldingRecord h) {
        if (h.getCurrentValue() <= 0)
            throw new IllegalArgumentException("must be > 0");
        return repo.save(h);
    }

    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }

    public Optional<HoldingRecord> getHoldingById(Long id) {
        return repo.findById(id);
    }
}
