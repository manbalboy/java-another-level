package com.manbalboy.jpa.bookmanaber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookmanaberApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmanaberApplication.class, args);
    }

}
