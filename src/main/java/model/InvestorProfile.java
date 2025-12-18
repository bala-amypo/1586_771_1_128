package com.example.investor.profile;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "investor_profiles")
class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String investorId;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private Boolean active = true;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getInvestorId() { return investorId; }
    public void setInvestorId(String investorId) { this.investorId = investorId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

@Repository
interface InvestorProfileRepository extends JpaRepository<InvestorProfile, Long> {
    Optional<InvestorProfile> findByInvestorId(String investorId);
}

@Service
class InvestorProfileService {

    private final InvestorProfileRepository repository;

    public InvestorProfileService(InvestorProfileRepository repository) {
        this.repository = repository;
    }

    public InvestorProfile createInvestor(InvestorProfile investor) {
        return repository.save(investor);
    }

    public InvestorProfile getInvestorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Investor not found"));
    }

    public Optional<InvestorProfile> findByInvestorId(String investorId) {
        return repository.findByInvestorId(investorId);
    }

    public List<InvestorProfile> getAllInvestors() {
        return repository.findAll();
    }

    public InvestorProfile updateInvestorStatus(Long id, boolean active) {
        InvestorProfile investor = getInvestorById(id);
        investor.setActive(active);
        return repository.save(investor);
    }
}

@RestController
@RequestMapping("/api/investors")
class InvestorProfileController {

    private final InvestorProfileService service;

    public InvestorProfileController(InvestorProfileService service) {
        this.service = service;
    }

    @PostMapping("/")
    public InvestorProfile create(@RequestBody InvestorProfile investor) {
        return service.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public InvestorProfile getById(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    @GetMapping("/")
    public List<InvestorProfile> listAll() {
        return service.getAllInvestors();
    }

    @PutMapping("/{id}/status")
    public InvestorProfile updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateInvestorStatus(id, active);
    }

    @GetMapping("/lookup/{investorId}")
    public InvestorProfile lookup(@PathVariable String investorId) {
        return service.findByInvestorId(investorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}