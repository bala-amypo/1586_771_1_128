import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {
    private final InvestorProfileService service;

    public InvestorProfileController(InvestorProfileService service) {
        this.service = service;
    }

    @PostMapping("/")
    public InvestorProfile createInvestor(@RequestBody InvestorProfile investor) {
        return service.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public InvestorProfile getInvestorById(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    @GetMapping("/")
    public List<InvestorProfile> getAll() {
        return service.getAllInvestors();
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        service.updateInvestorStatus(id, active);
    }

    @GetMapping("/lookup/{investorId}")
    public InvestorProfile lookup(@PathVariable String investorId) {
        return service.findByInvestorId(investorId)
                .orElseThrow(() -> new RuntimeException("Investor not found"));
    }
}