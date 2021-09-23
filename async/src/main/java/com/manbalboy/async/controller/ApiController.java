package com.manbalboy.async.controller;


import com.manbalboy.async.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;


    @GetMapping("")
    public CompletableFuture hello() {
        log.info("hello controller ");

        return apiService.run();
    }


}
