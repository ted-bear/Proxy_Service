package ru.toporkov.proxyservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.toporkov.proxyservice.domain.aud.AuditAction;
import ru.toporkov.proxyservice.repository.AuditActionRepository;
import ru.toporkov.proxyservice.service.AuditService;

@Service
@RequiredArgsConstructor
@Transactional
public class AuditServiceImpl implements AuditService {

    private final AuditActionRepository auditActionRepository;

    public void create(AuditAction auditAction) {
        auditActionRepository.save(auditAction);
    }
}
