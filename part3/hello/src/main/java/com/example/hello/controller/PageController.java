package com.example.hello.controller;

import com.example.hello.dto.UserPostRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {


    //page
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }


    //ResponseEntity

    @ResponseBody
    @GetMapping("user")
    public UserPostRequestDTO user() {
        var user = new UserPostRequestDTO();
        user.setAge(18);
        user.setName("fdsa");
        user.setPhoneNumber("123123213");

        return user;
    }


}
