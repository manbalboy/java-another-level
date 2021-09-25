package com.manbalboy.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserReq {

    @ApiModelProperty(value = "사용자의 이름", example = "훈", required = true)
    private String name;
    @ApiModelProperty(value = "사용자의 나이", example = "20", required = true)
    private int age;
}
