package com.suhacan.springbootpaginationsortingdemo.service;

import com.suhacan.springbootpaginationsortingdemo.dtos.UserDto;
import com.suhacan.springbootpaginationsortingdemo.entity.User;
import com.suhacan.springbootpaginationsortingdemo.mapper.UserMapper;
import com.suhacan.springbootpaginationsortingdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        return userMapper.toDto(
                userRepository.save(
                        userMapper.toEntity(userDto)
                )
        );
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUsersByPaginationAndSorting(int pageNo, int pageSize, String sortBy) {
        Sort sortedBy = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sortedBy.ascending());
        return userRepository.findAll(pageRequest).getContent().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
