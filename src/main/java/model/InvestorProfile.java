package com.example.demo.model;

import java.time.LocalDateTime;

public class InvestorProfile {
    private Long id;
    private String investorId;
    private String fullname;
    private String email;
    private Boolean active;
    private LocalDateTime createdAt;
    public InvestorProfile(String investorId, String fullname, String email, Boolean active, LocalDateTime createdAt) {
        this.investorId = investorId;
        this.fullname = fullname;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
    }
    // Getters and Setters
    public String getInvestorId() {
        return investorId;
    }
    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    

    
}