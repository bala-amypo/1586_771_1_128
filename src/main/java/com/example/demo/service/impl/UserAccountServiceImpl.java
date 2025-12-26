package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.entity.enums.RoleType;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository userRepo,
                                  PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount registerUser(UserAccount user) {
        if (user.getRole() == null) {
            user = new UserAccount(user.getUsername(), user.getEmail(), user.getPassword(), RoleType.INVESTOR);
        }
        user.setActive(true);
        // our test mocks encoder so this is safe
        user = new UserAccount(user.getUsername(), user.getEmail(),
                passwordEncoder.encode(user.getPassword()), user.getRole());
        return userRepo.save(user);
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Optional<UserAccount> findById(Long id) {
        return userRepo.findById(id);
    }
}
