package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class InvestorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String investorId;

    private String fullName;

    @Column(unique = true)
    private String email;

    private Boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    public InvestorProfile() {}

    // getters and setters
}
