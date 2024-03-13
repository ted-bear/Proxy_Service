package ru.toporkov.proxyservice.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.toporkov.proxyservice.domain.aud.AuditAction;
import ru.toporkov.proxyservice.service.AuditService;
import ru.toporkov.proxyservice.web.dto.user.UserProxyCreateEditDto;
import ru.toporkov.proxyservice.web.dto.user.UserProxyReadDto;
import ru.toporkov.proxyservice.integration.service.UserProxyService;

import java.security.Principal;
import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserProxyService userProxyService;
    private final AuditService auditService;

    @GetMapping
    public List<UserProxyReadDto> findAll(HttpServletRequest request, Principal principal) {
        audit(request, principal, "");
        return userProxyService.findAll();
    }

    @GetMapping("/{id}")
    public UserProxyReadDto findById(@PathVariable("id") Long id, HttpServletRequest request, Principal principal) {
        audit(request, principal, "");
        return userProxyService.findById(id);
    }

    @PostMapping
    public UserProxyReadDto create(@RequestBody UserProxyCreateEditDto userDto, HttpServletRequest request, Principal principal) {
        audit(request, principal, userDto.toString());
        return userProxyService.create(userDto);
    }

    @PutMapping("/{id}")
    public UserProxyReadDto update(@PathVariable("id") Long id, @RequestBody  UserProxyCreateEditDto userDto, HttpServletRequest request, Principal principal) {
        audit(request, principal, userDto.toString());
        return userProxyService.update(userDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id, HttpServletRequest request, Principal principal) {
        audit(request, principal, "");
        userProxyService.delete(id);
    }

    private void audit(HttpServletRequest request, Principal principal, String body) {
        AuditAction auditAction = new AuditAction();
        auditAction.setMethod(request.getMethod());
        auditAction.setCreatedAt(Instant.now());
        auditAction.setUrl(request.getRequestURL().toString());
        auditAction.setRequestBody(body != null ? body : "");
        auditAction.setCreatedBy(principal.getName());
        auditService.create(auditAction);
    }
}
