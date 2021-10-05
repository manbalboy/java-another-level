package com.manbalboy.jpa.bookmanaber.service;

import com.manbalboy.jpa.bookmanaber.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        userService.put();

        System.out.println(userRepository.findByEmail("newUser@fastcampus.com"));
    }
}