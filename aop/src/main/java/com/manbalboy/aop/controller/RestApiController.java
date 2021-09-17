package com.manbalboy.aop.controller;


import com.manbalboy.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable String id, @RequestParam String name) {
        System.out.println("get method");
        System.out.println("id  : " + id);
        System.out.println("name  : " + name);

        return id + "  " + name;
    }
    

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        System.out.println(user);
        return user;
    }


}
