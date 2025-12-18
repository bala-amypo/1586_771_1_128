package com.example.project.repository;

import com.example.project.model.InvestorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorProfileRepository extends JpaRepository<InvestorProfile, Long> {
}