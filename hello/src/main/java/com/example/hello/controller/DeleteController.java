package com.example.hello.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId) {
        System.out.println(userId);
    }
}

