package com.manbalboy.server.controller;

import com.manbalboy.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam Integer age) {
        User user = new User(name, age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public User user(
            @RequestBody User user,
            @PathVariable int userId,
            @PathVariable String userName,
            @RequestHeader("x-authorization") String header1,
            @RequestHeader("custom-header") String header2
    ) {
        log.info("userId : {} , userName : {}", userId, userName);
        log.info("header1 : {} , header2 : {}", header1, header2);
        log.info("User : {}", user);

        return user;
    }
}
