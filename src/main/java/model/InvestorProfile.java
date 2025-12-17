package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // (Long, PK)

    @Column(unique = true, nullable = false)
    private String investorId; // (String, unique)

    private String fullName; // (String)
    
    @Column(unique = true, nullable = false)
    private String email; // (String, unique)

    // Rule: active defaults to true.
    private boolean active = true; // (Boolean)

    private LocalDateTime createdAt; // (LocalDateTime)

    // --- Rules Implemented by Annotations/Defaults ---
    // 1. investorId and email must be unique. (Implemented with @Column(unique = true))
    // 2. active defaults to true. (Implemented with initialization: = true)

    // Getters and Setters (omitted for brevity)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getInvestorId() { return investorId; }
    public void setInvestorId(String investorId) { this.investorId = investorId; }
    // ... other getters/setters ...
}
