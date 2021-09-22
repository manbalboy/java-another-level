package com.manbalboy.interceptor.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class PublicController {
    @GetMapping("/hello")
    public String hello() {

        log.info("============");
        return "public hello";
    }

}
