package ru.toporkov.proxyservice.service;

import ru.toporkov.proxyservice.domain.aud.AuditAction;

public interface AuditService {

    void create(AuditAction auditAction);
}
