package com.manbalboy.swagger.controller;


import com.manbalboy.swagger.dto.UserReq;
import com.manbalboy.swagger.dto.UserRes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/plus/{x}")
    public int plus(
            @ApiParam(value = "x값", defaultValue = "20", required = true)
            @PathVariable int x,

            @ApiParam(value = "y값", defaultValue = "10", required = true)
            @RequestParam int y) {
        return x + y;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", value = "x 값"),
            @ApiImplicitParam(name = "Y", value = "y 값")
    })
    @GetMapping("/plus-a/{x}")
    public int plusA(
            @PathVariable int x,
            @RequestParam int y) {

        return x + y;
    }

    @ApiResponse(code = 500, message = "사용자의 나이가 10살 이하일때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴 하는 메소드")
    @GetMapping("/user")
    public UserRes user(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @ApiResponse(code = 500, message = "사용자의 나이가 10살 이하일때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴 하는 메소드")
    @PostMapping("/user")
    public UserRes userPost(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }
}
