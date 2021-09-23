package com.manbalboy.client.controller;

import com.manbalboy.client.dto.UserResponse;
import com.manbalboy.client.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiController {

    private final RestTemplateService restTemplateService;

    @GetMapping("")
    public UserResponse getHello() {
        return restTemplateService.responseEntityHello();
    }
}
