package ru.toporkov.proxyservice.service;

import jakarta.servlet.http.HttpServletRequest;

import java.security.Principal;

public interface AuditService {

    void create(HttpServletRequest request, Principal principal, String body);
}
