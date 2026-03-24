package com.grantserve.grantservebackend.module1_identity.config.repository;

import com.grantserve.grantservebackend.module1_identity.config.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {}