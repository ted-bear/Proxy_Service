package ru.toporkov.proxyservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.toporkov.proxyservice.web.dto.user.UserProxyCreateEditDto;
import ru.toporkov.proxyservice.web.dto.user.UserProxyReadDto;
import ru.toporkov.proxyservice.integration.service.UserProxyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserProxyService userProxyService;

    @GetMapping
    public List<UserProxyReadDto> findAll() {
        return userProxyService.findAll();
    }

    @GetMapping("/{id}")
    public UserProxyReadDto findById(@PathVariable("id") Long id) {
        return userProxyService.findById(id);
    }

    @PostMapping
    public UserProxyReadDto create(@RequestBody UserProxyCreateEditDto userDto) {
        return userProxyService.create(userDto);
    }

    @PutMapping("/{id}")
    public UserProxyReadDto update(@PathVariable("id") Long id, @RequestBody  UserProxyCreateEditDto userDto) {
        return userProxyService.update(userDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userProxyService.delete(id);
    }
}
