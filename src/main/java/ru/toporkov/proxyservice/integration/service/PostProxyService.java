package ru.toporkov.proxyservice.integration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.toporkov.proxyservice.web.dto.post.PostProxyCreateEditDto;
import ru.toporkov.proxyservice.web.dto.post.PostProxyReadDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostProxyService {

    private final RestTemplate restTemplate;
    private final String postURI = "https://jsonplaceholder.typicode.com/posts";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<PostProxyReadDto> findAll() {
        var object = restTemplate.getForObject(postURI, Object[].class);

        return object != null ? Arrays.stream(object)
                .map(obj -> mapper.convertValue(obj, PostProxyReadDto.class))
                .collect(Collectors.toList()) : Collections.emptyList();
    }

    public PostProxyReadDto findById(Long id) {
        return restTemplate.getForObject(postURI + "/" + id, PostProxyReadDto.class);
    }

    public PostProxyReadDto create(PostProxyCreateEditDto postDto) {
        var postedObject = Optional.ofNullable(restTemplate.postForObject(postURI, postDto, PostProxyReadDto.class));
        return postedObject.orElse(null);
    }

    public PostProxyReadDto update(PostProxyCreateEditDto postDto, Long id) {
        return restTemplate.patchForObject(postURI + "/" + id, postDto, PostProxyReadDto.class);
    }

    public void delete(Long id) {
        restTemplate.delete(postURI + "/" + id);
    }
}
