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
import ru.toporkov.proxyservice.integration.service.AlbumProxyService;
import ru.toporkov.proxyservice.web.dto.album.AlbumProxyCreateEditDto;
import ru.toporkov.proxyservice.web.dto.album.AlbumProxyReadDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/albums")
public class AlbumController {

    private final AlbumProxyService albumProxyService;

    @GetMapping
    public List<AlbumProxyReadDto> findAll() {
        return albumProxyService.findAll();
    }

    @GetMapping("/{id}")
    public AlbumProxyReadDto findById(@PathVariable("id") Long id) {
        return albumProxyService.findById(id);
    }

    @PostMapping
    public AlbumProxyReadDto create(@RequestBody AlbumProxyCreateEditDto albumDto) {
        return albumProxyService.create(albumDto);
    }

    @PutMapping("/{id}")
    public AlbumProxyReadDto update(@PathVariable("id") Long id, @RequestBody  AlbumProxyCreateEditDto albumDto) {
        return albumProxyService.update(albumDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        albumProxyService.delete(id);
    }
}
