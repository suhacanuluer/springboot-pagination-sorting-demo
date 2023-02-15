package com.suhacan.springbootpaginationsortingdemo.mapper;

import com.suhacan.springbootpaginationsortingdemo.dtos.UserDto;
import com.suhacan.springbootpaginationsortingdemo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
