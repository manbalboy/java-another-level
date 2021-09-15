package com.example.hello;

import com.example.hello.dto.UserPostRequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTest {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-------------");

        UserPostRequestDTO user = new UserPostRequestDTO("test", "fdsa", 44, "fdsa");

        var objectMapper = new ObjectMapper();

        String text = objectMapper.writeValueAsString(user);

        System.out.println(text);


        //objectMapper 는 getter method 를 사용하므로 get 이라는 접두어를 사용한 비지니스 메서드를 만들면 안된다. 
        var object = objectMapper.readValue(text, UserPostRequestDTO.class);

        System.out.println(object);


    }
}