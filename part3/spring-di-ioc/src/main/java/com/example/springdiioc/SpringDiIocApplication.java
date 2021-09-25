package com.example.springdiioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.UnsupportedEncodingException;

@SpringBootApplication
public class SpringDiIocApplication {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(SpringDiIocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();
        Encoder encoder = context.getBean(Encoder.class);

        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
        String url = "www.naver.com/books/it?page=10&size=20&name=spirng-boot";

        //Base64 Encoder
        String result = encoder.encode(url);
        System.out.println(result);


        encoder.setIEncoder(urlEncoder);
        String result2 = encoder.encode(url);
        System.out.println(result2);


    }

}
