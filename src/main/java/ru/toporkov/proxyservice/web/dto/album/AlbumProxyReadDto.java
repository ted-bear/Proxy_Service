package ru.toporkov.proxyservice.web.dto.album;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumProxyReadDto {

    private Long id;
    private Long userId;
    private String title;
}
