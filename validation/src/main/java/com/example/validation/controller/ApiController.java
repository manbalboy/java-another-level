package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {
    @PostMapping("/user")
    public User user(@Valid @RequestBody User user, BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        bindingResult.getAllErrors().forEach(objectError -> {
            FieldError field = (FieldError) objectError;
            String message = objectError.getDefaultMessage();
            System.out.println(field);
            System.out.println(message);
        });
        return user;
    }
}
