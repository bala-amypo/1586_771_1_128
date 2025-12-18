import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RebalancingAlertService {

    private final RebalancingAlertRepository repository;

    public RebalancingAlertService(RebalancingAlertRepository repository) {
        this.repository = repository;
    }

    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        if (alert.getCurrentPercentage() <= alert.getTargetPercentage()) {
            throw new IllegalArgumentException("Validation failed: current must be > target");
        }
        return repository.save(alert);
    }

    public void resolveAlert(Long id) {
        RebalancingAlertRecord alert = getAlertById(id);
        alert.setResolved(true);
        repository.save(alert);
    }

    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    public RebalancingAlertRecord getAlertById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    public List<RebalancingAlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}