package com.grantserve.grantservebackend.module1_identity.config.service;

import com.grantserve.grantservebackend.module1_identity.config.entity.User;
import com.grantserve.grantservebackend.module1_identity.config.entity.AuditLog;
import com.grantserve.grantservebackend.module1_identity.config.repository.UserRepository;
import com.grantserve.grantservebackend.module1_identity.config.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuditLogRepository auditLogRepository;

    public UserService(UserRepository userRepository, AuditLogRepository auditLogRepository) {
        this.userRepository = userRepository;
        this.auditLogRepository = auditLogRepository;
    }

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Save a new user and log the action
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);

        // Create audit log entry
        AuditLog log = new AuditLog();
        log.setUserID(savedUser.getUserID());
        log.setAction("CREATE");
        log.setResource("User");
        log.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(log);

        return savedUser;
    }

    // Update an existing user and log the action
    public User updateUser(User user) {
        User updatedUser = userRepository.save(user);

        AuditLog log = new AuditLog();
        log.setUserID(updatedUser.getUserID());
        log.setAction("UPDATE");
        log.setResource("User");
        log.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(log);

        return updatedUser;
    }

    // Delete a user and log the action
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

        AuditLog log = new AuditLog();
        log.setUserID(userId);
        log.setAction("DELETE");
        log.setResource("User");
        log.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(log);
    }
}