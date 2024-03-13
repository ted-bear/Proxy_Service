package ru.toporkov.proxyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.toporkov.proxyservice.domain.aud.AuditAction;

public interface AuditActionRepository extends JpaRepository<AuditAction, Long> {
}
