package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "investorId"),
        @UniqueConstraint(columnNames = "email")
})
public class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String investorId;
    private String fullName;
    private String email;
    private Boolean active = true;
    private LocalDateTime createdAt;

    public InvestorProfile() {}

    public InvestorProfile(String investorId, String fullName, String email, Boolean active) {
        this.investorId = investorId;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
        this.createdAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getInvestorId() { return investorId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
