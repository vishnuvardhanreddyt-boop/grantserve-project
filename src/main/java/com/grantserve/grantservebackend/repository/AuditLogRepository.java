package com.grantserve.grantservebackend.repository;

import com.grantserve.grantservebackend.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {}