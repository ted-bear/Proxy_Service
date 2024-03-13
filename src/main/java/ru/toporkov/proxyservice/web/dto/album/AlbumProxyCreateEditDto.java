package ru.toporkov.proxyservice.web.dto.album;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumProxyCreateEditDto {

    private Long userId;
    private String title;

}
