package com.manbalboy.exception.advice;


import com.manbalboy.exception.controller.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = ApiController.class)
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        System.out.println("===============");
        System.out.println(e.getClass().getName());
        System.out.println("===============");
        System.out.println(e.getMessage());
        System.out.println("===============");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity exception(MethodArgumentNotValidException e) {
        System.out.println("===============MethodArgumentNotValidException");
        System.out.println(e.getMessage());
        System.out.println("===============");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }





}
