package ru.toporkov.proxyservice.web.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostProxyCreateEditDto {

    private Long userId;
    private String title;
    private String body;

}
