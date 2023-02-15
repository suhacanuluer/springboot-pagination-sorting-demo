package com.suhacan.springbootpaginationsortingdemo.service;

import com.suhacan.springbootpaginationsortingdemo.dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    List<UserDto> getUsersByPaginationAndSorting(int pageNo, int pageSize, String sortBy);
}
