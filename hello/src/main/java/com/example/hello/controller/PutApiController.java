package com.example.hello.controller;


import com.example.hello.dto.PutDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/put")
public class PutApiController {

    @PutMapping("/put")
    public PutDTO post(@RequestBody PutDTO requestData) {
        return requestData;
    }
}
