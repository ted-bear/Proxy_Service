package ru.toporkov.proxyservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.toporkov.proxyservice.domain.User;
import ru.toporkov.proxyservice.service.AuthService;
import ru.toporkov.proxyservice.service.UserService;
import ru.toporkov.proxyservice.web.dto.UserDto;
import ru.toporkov.proxyservice.web.dto.auth.JwtRequest;
import ru.toporkov.proxyservice.web.dto.auth.JwtResponse;
import ru.toporkov.proxyservice.web.mapper.UserMapper;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody
                             JwtRequest loginRequest) {

        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);

        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);

    }

}
