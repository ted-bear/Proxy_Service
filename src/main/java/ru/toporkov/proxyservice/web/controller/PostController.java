package ru.toporkov.proxyservice.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.toporkov.proxyservice.domain.aud.AuditAction;
import ru.toporkov.proxyservice.integration.service.PostProxyService;
import ru.toporkov.proxyservice.service.AuditService;
import ru.toporkov.proxyservice.web.dto.post.PostProxyCreateEditDto;
import ru.toporkov.proxyservice.web.dto.post.PostProxyReadDto;

import java.security.Principal;
import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostProxyService postProxyService;
    private final AuditService auditService;

    @GetMapping
    public List<PostProxyReadDto> findAll(HttpServletRequest request, Principal principal) {
        auditService.create(request, principal, "");
        return postProxyService.findAll();
    }

    @GetMapping("/{id}")
    public PostProxyReadDto findById(@PathVariable("id") Long id, HttpServletRequest request, Principal principal) {
        auditService.create(request, principal, "");
        return postProxyService.findById(id);
    }

    @PostMapping
    public PostProxyReadDto create(@RequestBody PostProxyCreateEditDto postDto, HttpServletRequest request, Principal principal) {
        auditService.create(request, principal, postDto.toString());
        return postProxyService.create(postDto);
    }

    @PutMapping("/{id}")
    public PostProxyReadDto update(@PathVariable("id") Long id,
                                   @RequestBody PostProxyCreateEditDto postDto,
                                   HttpServletRequest request,
                                   Principal principal) {
        auditService.create(request, principal, postDto.toString());
        return postProxyService.update(postDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id, HttpServletRequest request, Principal principal) {
        auditService.create(request, principal, "");
        postProxyService.delete(id);
    }

}
