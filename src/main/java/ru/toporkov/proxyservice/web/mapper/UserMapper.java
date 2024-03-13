package ru.toporkov.proxyservice.web.mapper;

import org.mapstruct.Mapper;
import ru.toporkov.proxyservice.domain.User;
import ru.toporkov.proxyservice.web.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
