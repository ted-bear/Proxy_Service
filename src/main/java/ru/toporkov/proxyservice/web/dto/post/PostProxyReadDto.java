package ru.toporkov.proxyservice.web.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostProxyReadDto {

    private Long id;
    private Long userId;
    private String title;
    private String body;

}
