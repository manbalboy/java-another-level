package com.manbalboy.filter.controller;

import com.manbalboy.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class ApiController {
    @PostMapping("")
    public User post(@RequestBody User user) {
        log.info("User : {}", user);

        return user;
    }
}
