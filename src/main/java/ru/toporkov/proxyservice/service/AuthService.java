package ru.toporkov.proxyservice.service;

import ru.toporkov.proxyservice.web.dto.auth.JwtRequest;
import ru.toporkov.proxyservice.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
