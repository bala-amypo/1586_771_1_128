package com.example.demo.repository;

import com.example.demo.model.InvestorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InvestorProfileRepository extends JpaRepository<InvestorProfile, Long> {
    
    // Custom finder method to enforce uniqueness check if needed elsewhere
    Optional<InvestorProfile> findByInvestorId(String investorId);
    
    // Custom finder method for unique email check
    Optional<InvestorProfile> findByEmail(String email);
}
