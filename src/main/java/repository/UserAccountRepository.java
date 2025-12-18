// package com.example.project.repository;

// import com.example.project.model.UserAccount;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import java.util.Optional;

// @Repository
// public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
//     // Common helper method for authentication/lookup
//     Optional<UserAccount> findByUsername(String username);
// }