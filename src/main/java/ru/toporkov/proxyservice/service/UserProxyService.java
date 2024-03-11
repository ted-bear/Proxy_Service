package ru.toporkov.proxyservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class UserProxyService {

    private final RestTemplate restTemplate;
    private final String uri = "https://jsonplaceholder.typicode.com/users";

    public void findAll() {
        restTemplate.getForObject(uri, String.class);
    }
}
