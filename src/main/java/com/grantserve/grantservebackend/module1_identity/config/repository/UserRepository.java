package com.grantserve.grantservebackend.module1_identity.config.repository;

import com.grantserve.grantservebackend.module1_identity.config.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}