package com.manbalboy.client.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequest {
    private String name;
    private Integer age;
}
