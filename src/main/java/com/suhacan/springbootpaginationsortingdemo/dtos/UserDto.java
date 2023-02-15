package com.suhacan.springbootpaginationsortingdemo.dtos;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String password;
    private String about;
    private String email;
}
