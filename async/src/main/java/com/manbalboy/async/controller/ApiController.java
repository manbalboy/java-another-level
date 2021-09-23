package com.manbalboy.async.controller;


import com.manbalboy.async.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;


    @GetMapping("")
    public String hello() {
        apiService.hello();

        log.info("hello controller ");

        return "hello controller";
    }

}
