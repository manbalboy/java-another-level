package com.manbalboy.exception.controller;


import com.manbalboy.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        return user;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity exception(MethodArgumentNotValidException e) {
        System.out.println("===============");
        System.out.println(e.getMessage());
        System.out.println("===============");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
