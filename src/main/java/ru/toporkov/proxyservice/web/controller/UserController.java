package ru.toporkov.proxyservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.toporkov.proxyservice.integration.domain.user.User;
import ru.toporkov.proxyservice.service.UserProxyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserProxyService userProxyService;

    @GetMapping
    public List<User> findAll() {
        return userProxyService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userProxyService.findById(id);
    }
}
