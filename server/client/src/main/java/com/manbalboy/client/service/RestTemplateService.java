package com.manbalboy.client.service;


import com.manbalboy.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class RestTemplateService {

    public String hello() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();


        log.info("uri : {} ", uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }

    public UserResponse responseEntityHello() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "훈")
                .queryParam("age", 11)
                .encode()
                .build()
                .toUri();


        log.info("uri : {} ", uri.toString());

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(uri, String.class);
        ResponseEntity<UserResponse> resultEntity = restTemplate.getForEntity(uri, UserResponse.class);

        log.info("resultEntity body : {}", resultEntity.getBody());

        return resultEntity.getBody();
    }
}
