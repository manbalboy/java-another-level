package com.manbalboy.client.service;


import com.manbalboy.client.dto.UserRequest;
import com.manbalboy.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class RestTemplateService {
    public final String BASE_URI = "http://localhost:9090";

    public String hello() {
        URI uri = UriComponentsBuilder.fromUriString(BASE_URI)
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
        URI uri = UriComponentsBuilder.fromUriString(BASE_URI)
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


    public UserResponse post() {
        URI uri = UriComponentsBuilder
                .fromUriString(BASE_URI)
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();

        log.info("uri : {} ", uri.toString());

        UserRequest req = new UserRequest();
        req.setAge(10);
        req.setName("훈");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> responseEntity = restTemplate.postForEntity(uri, req, UserResponse.class);

        log.info("resultEntity body : {}", responseEntity.getBody());


        return responseEntity.getBody();
    }

    public UserResponse exchange() {
        URI uri = UriComponentsBuilder
                .fromUriString(BASE_URI)
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();

        log.info("uri : {} ", uri.toString());

        UserRequest req = new UserRequest();
        req.setAge(10);
        req.setName("훈");

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(req);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserResponse> responseEntity = restTemplate.exchange(requestEntity, UserResponse.class);

        log.info("resultEntity body : {}", responseEntity.getBody());


        return responseEntity.getBody();
    }
}
