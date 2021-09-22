package com.manbalboy.exception.controller;


import com.manbalboy.exception.dto.Error;
import com.manbalboy.exception.dto.ErrorResponse;
import com.manbalboy.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

    @GetMapping("")
    public User get(
            @Size(min = 1, max = 10)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        return user;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity exception(MethodArgumentNotValidException e
            , HttpServletRequest httpServletRequest) {
        System.out.println("===============MethodArgumentNotValidException");

        List<Error> errorList = new ArrayList<>();

        BindingResult bindingResult = e.getBindingResult();

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();
                String fieldName = Objects.requireNonNull(field.getRejectedValue()).toString();
                String value = field.getRejectedValue().toString();

                System.out.println("--------------------------");
                System.out.println("fieldName : " + fieldName);
                System.out.println("message : " + message);
                System.out.println("value : " + value);
                System.out.println("--------------------------");


                Error error = new Error();
                error.setMessage(message);
                error.setField(fieldName);
                error.setInvalidValue(value);

                errorList.add(error);
            });
        }

        return getResponseEntity(httpServletRequest, errorList);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(ConstraintViolationException e
            , HttpServletRequest httpServletRequest) {
        System.out.println("===============ConstraintViolationException");

        List<Error> errorList = new ArrayList<>();

        e.getConstraintViolations().forEach(error -> {
            Stream<Path.Node> stream = StreamSupport.stream(error.getPropertyPath().spliterator(), false);

            List<Path.Node> list = stream.collect(Collectors.toList());

            String field = list.get(list.size() - 1).getName();
            String message = error.getMessage();
            String invalidValue = error.getInvalidValue().toString();

            System.out.println("--------------------------");
            System.out.println("field : " + field);
            System.out.println("message : " + message);
            System.out.println("invalidValue : " + invalidValue);
            System.out.println("--------------------------");
            Error errorObject = new Error();
            errorObject.setMessage(message);
            errorObject.setField(field);
            errorObject.setInvalidValue(invalidValue);

            errorList.add(errorObject);
        });

        return getResponseEntity(httpServletRequest, errorList);
    }

    private ResponseEntity getResponseEntity(HttpServletRequest httpServletRequest
            , List<Error> errorList) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(errorList);
        errorResponse.setMessage("");
        errorResponse.setCode("");
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e
            , HttpServletRequest httpServletRequest) {
        System.out.println("===============MissingServletRequestParameterException");
        String fieldName = e.getParameterName();
        String fieldType = e.getParameterType();
        String invalidValue = e.getMessage();

        System.out.println("fieldName : " + fieldName);
        System.out.println("fieldType : " + fieldType);
        System.out.println("invalidValue : " + invalidValue);
        System.out.println("===============");
        List<Error> errorList = new ArrayList<>();

        Error errorObject = new Error();
        errorObject.setMessage(invalidValue);
        errorObject.setField(fieldName);
        errorObject.setInvalidValue(invalidValue);

        errorList.add(errorObject);

        return getResponseEntity(httpServletRequest, errorList);
    }

}
