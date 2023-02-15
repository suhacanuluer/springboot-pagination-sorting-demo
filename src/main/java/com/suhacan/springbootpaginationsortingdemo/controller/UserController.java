package com.suhacan.springbootpaginationsortingdemo.controller;

import com.suhacan.springbootpaginationsortingdemo.dtos.UserDto;
import com.suhacan.springbootpaginationsortingdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<UserDto>> getUsersByPaginationAndSorting(@RequestParam(defaultValue = "0") int pageNo,
                                                                        @RequestParam(defaultValue = "10")int pageSize,
                                                                        @RequestParam(defaultValue = "name")String sortBy) {
        return new ResponseEntity<>(userService.getUsersByPaginationAndSorting(pageNo, pageSize, sortBy), HttpStatus.OK);
    }
}

