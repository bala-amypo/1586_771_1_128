import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class RebalancingAlertController {
    private final RebalancingAlertService service;

    public RebalancingAlertController(RebalancingAlertService service) {
        this.service = service;
    }

    @PostMapping("/")
    public RebalancingAlertRecord createAlert(@RequestBody RebalancingAlertRecord alert) {
        return service.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public void resolveAlert(@PathVariable Long id) {
        service.resolveAlert(id);
    }

    @GetMapping("/investor/{investorId}")
    public List<RebalancingAlertRecord> getByInvestor(@PathVariable Long investorId) {
        return service.getAlertsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public RebalancingAlertRecord getById(@PathVariable Long id) {
        return service.getAlertById(id);
    }

    @GetMapping("/")
    public List<RebalancingAlertRecord> listAll() {
        return service.getAllAlerts();
    }
}