package ru.toporkov.proxyservice.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geo {

    private String lat;
    private String lng;

}
