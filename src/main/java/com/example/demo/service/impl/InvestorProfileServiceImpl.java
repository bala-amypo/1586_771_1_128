public class InvestorProfileServiceImpl {

    private final InvestorProfileRepository repo;

    public InvestorProfileServiceImpl(InvestorProfileRepository repo) {
        this.repo = repo;
    }

    public InvestorProfile createInvestor(InvestorProfile i) {
        return repo.save(i);
    }

    public InvestorProfile getInvestorById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investor not found " + id));
    }

    public List<InvestorProfile> getAllInvestors() {
        return repo.findAll();
    }

    public InvestorProfile updateInvestorStatus(Long id, boolean active) {
        InvestorProfile i = getInvestorById(id);
        i.setActive(active);
        return repo.save(i);
    }

    public Optional<InvestorProfile> findByInvestorId(String investorId) {
        return repo.findByInvestorId(investorId);
    }
}
