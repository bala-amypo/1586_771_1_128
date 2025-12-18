import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/snapshots")
public class AllocationSnapshotController {
    private final AllocationSnapshotService service;

    public AllocationSnapshotController(AllocationSnapshotService service) {
        this.service = service;
    }

    @PostMapping("/compute/{investorId}")
    public void computeSnapshot(@PathVariable Long investorId) {
        service.computeSnapshot(investorId);
    }

    @GetMapping("/investor/{investorId}")
    public List<AllocationSnapshot> getByInvestor(@PathVariable Long investorId) {
        return service.getSnapshotsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public AllocationSnapshot getById(@PathVariable Long id) {
        return service.getSnapshotById(id);
    }

    @GetMapping("/")
    public List<AllocationSnapshot> listAll() {
        return service.getAllSnapshots();
    }
}