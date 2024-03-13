package ru.toporkov.proxyservice.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.toporkov.proxyservice.domain.aud.AuditAction;
import ru.toporkov.proxyservice.repository.AuditActionRepository;
import ru.toporkov.proxyservice.service.AuditService;

import java.security.Principal;
import java.time.Instant;

@Service
@RequiredArgsConstructor
@Transactional
public class AuditServiceImpl implements AuditService {

    private final AuditActionRepository auditActionRepository;

    public void create(HttpServletRequest request, Principal principal, String body) {
        AuditAction auditAction = new AuditAction();
        auditAction.setMethod(request.getMethod());
        auditAction.setCreatedAt(Instant.now());
        auditAction.setUrl(request.getRequestURL().toString());
        auditAction.setRequestBody(body != null ? body : "");
        auditAction.setCreatedBy(principal.getName());
        auditActionRepository.save(auditAction);
    }
}
