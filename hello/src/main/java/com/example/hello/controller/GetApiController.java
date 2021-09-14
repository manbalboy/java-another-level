package com.example.hello.controller;


import com.example.hello.dto.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path = "/hello")
    public String getHello() {
        return "hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String getHi() {
        return "hi";
    }

    @GetMapping("/path-variable/{name}")
    public String getPathVariable(@PathVariable String name) {
        return "name : " + name;
    }

    @GetMapping("/path-variable/v2/{name}")
    public String getPathVariable2(@PathVariable(name = "name") String sPathName) {
        return "name : " + sPathName;
    }

    @GetMapping("/query")
    public String getQuery(@RequestParam Map<String, Object> requestParam) {
        StringBuilder sb = new StringBuilder();

        requestParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("==================");

            sb.append(entry.getKey() + "  =  " + entry.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping("/query-2")
    public String getQueryA(@RequestParam String name,
                            @RequestParam String email,
                            @RequestParam int age) {

        return name + " " + email + " " + age;
    }

    @GetMapping("/query-3")
    public String getQueryB(UserRequestDTO requestDTO) {

        return requestDTO.toString();
    }
}
