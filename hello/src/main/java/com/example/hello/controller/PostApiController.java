package com.example.hello.controller;

import com.example.hello.dto.UserPostRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
            System.out.println("===================");
            System.out.println("===================");
            System.out.println("===================");
        });
    }

    @PostMapping("/post2")
    public String postA(@RequestBody UserPostRequestDTO requestData) {
        return requestData.toString();
    }

}
