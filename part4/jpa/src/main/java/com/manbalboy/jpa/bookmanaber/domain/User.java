package com.manbalboy.jpa.bookmanaber.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String name;
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
