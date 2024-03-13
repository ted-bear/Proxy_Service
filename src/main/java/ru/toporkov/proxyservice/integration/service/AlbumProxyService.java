package ru.toporkov.proxyservice.integration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.toporkov.proxyservice.web.dto.album.AlbumProxyCreateEditDto;
import ru.toporkov.proxyservice.web.dto.album.AlbumProxyReadDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumProxyService {

    private final RestTemplate restTemplate;
    private final String albumURI = "https://jsonplaceholder.typicode.com/albums";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<AlbumProxyReadDto> findAll() {
        var object = restTemplate.getForObject(albumURI, Object[].class);

        return object != null ? Arrays.stream(object)
                .map(obj -> mapper.convertValue(obj, AlbumProxyReadDto.class))
                .collect(Collectors.toList()) : Collections.emptyList();
    }

    public AlbumProxyReadDto findById(Long id) {
        return restTemplate.getForObject(albumURI + "/" + id, AlbumProxyReadDto.class);
    }

    public AlbumProxyReadDto create(AlbumProxyCreateEditDto album) {
        var postedObject = Optional.ofNullable(restTemplate.postForObject(albumURI, album, AlbumProxyReadDto.class));
        return postedObject.orElse(null);
    }

    public AlbumProxyReadDto update(AlbumProxyCreateEditDto album, Long id) {
        return restTemplate.patchForObject(albumURI + "/" + id, album, AlbumProxyReadDto.class);
    }

    public void delete(Long id) {
        restTemplate.delete(albumURI + "/" + id);
    }
}
