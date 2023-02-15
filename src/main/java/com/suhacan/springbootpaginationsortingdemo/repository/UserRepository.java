package com.suhacan.springbootpaginationsortingdemo.repository;

import com.suhacan.springbootpaginationsortingdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
