package com.manbalboy.server.controller;

import com.manbalboy.server.dto.Req;
import com.manbalboy.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/naver")
    public String naver(@RequestParam String searchWord) {

//        String encode = Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8));
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", searchWord)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();


        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "zwnVziKfjiEWN82Pe1K7")
                .header("X-Naver-Client-Secret", "ib0V7Vzu0E")
                .build();


        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return result.getBody();


    }

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam Integer age) {
        User user = new User(name, age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public User user(
            @RequestBody User user,
            @PathVariable int userId,
            @PathVariable String userName,
            @RequestHeader("x-authorization") String header1,
            @RequestHeader("custom-header") String header2
    ) {
        log.info("userId : {} , userName : {}", userId, userName);
        log.info("header1 : {} , header2 : {}", header1, header2);
        log.info("User : {}", user);

        return user;
    }

    @PostMapping("/v1/user/{userId}/name/{userName}")
    public Req<User> userv1(
            @RequestBody Req<User> user,
            @PathVariable int userId,
            @PathVariable String userName,
            @RequestHeader("x-authorization") String header1,
            @RequestHeader("custom-header") String header2
    ) {
        log.info("userId : {} , userName : {}", userId, userName);
        log.info("header1 : {} , header2 : {}", header1, header2);
        log.info("User : {}", user);
        Req<User> response = new Req<>();
        response.setHeader(new Req.Header());
        response.setRBody(user.getRBody());
        return user;
    }
}
