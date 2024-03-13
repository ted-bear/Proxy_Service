package ru.toporkov.proxyservice.integration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.toporkov.proxyservice.web.dto.user.UserProxyCreateEditDto;
import ru.toporkov.proxyservice.web.dto.user.UserProxyReadDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProxyService {

    private final RestTemplate restTemplate;
    private final String userURI = "https://jsonplaceholder.typicode.com/users";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<UserProxyReadDto> findAll() {
        var object = restTemplate.getForObject(userURI, Object[].class);

        return object != null ? Arrays.stream(object)
                .map(obj -> mapper.convertValue(obj, UserProxyReadDto.class))
                .collect(Collectors.toList()) : Collections.emptyList();
    }

    public UserProxyReadDto findById(Long id) {
        return restTemplate.getForObject(userURI + "/" + id, UserProxyReadDto.class);
    }

    public UserProxyReadDto create(UserProxyCreateEditDto user) {
        var postedObject = Optional.ofNullable(restTemplate.postForObject(userURI, user, UserProxyReadDto.class));
        return postedObject.orElse(null);
    }

    public UserProxyReadDto update(UserProxyCreateEditDto userDto, Long id) {
        return restTemplate.patchForObject(userURI + "/" + id, userDto, UserProxyReadDto.class);
    }

    public void delete(Long id) {
        restTemplate.delete(userURI + "/" + id);
    }
}
