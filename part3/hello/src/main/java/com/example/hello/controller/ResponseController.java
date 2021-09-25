package com.example.hello.controller;


import com.example.hello.dto.UserPostRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/response")
public class ResponseController {


    //Text
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    //json
    //req-> object mapper -> object -> method -> object -> object mapper -> response
    @PostMapping("/json")
    public UserPostRequestDTO json(@RequestBody UserPostRequestDTO requestDTO) {
        return requestDTO;
    }


    @PutMapping("/put")
    public ResponseEntity put(@RequestBody UserPostRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body((requestDTO));
    }
}
