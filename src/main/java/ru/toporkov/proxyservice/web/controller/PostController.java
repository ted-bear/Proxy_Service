package ru.toporkov.proxyservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.toporkov.proxyservice.integration.service.PostProxyService;
import ru.toporkov.proxyservice.web.dto.post.PostProxyCreateEditDto;
import ru.toporkov.proxyservice.web.dto.post.PostProxyReadDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostProxyService postProxyService;

    @GetMapping
    public List<PostProxyReadDto> findAll() {
        return postProxyService.findAll();
    }

    @GetMapping("/{id}")
    public PostProxyReadDto findById(@PathVariable("id") Long id) {
        return postProxyService.findById(id);
    }

    @PostMapping
    public PostProxyReadDto create(@RequestBody PostProxyCreateEditDto postDto) {
        return postProxyService.create(postDto);
    }

    @PutMapping("/{id}")
    public PostProxyReadDto update(@PathVariable("id") Long id, @RequestBody PostProxyCreateEditDto postDto) {
        return postProxyService.update(postDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        postProxyService.delete(id);
    }

}
