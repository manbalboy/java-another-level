package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class User {
    @Max(value = 90)
    public int age;

    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다.")
    private String phoneNumber;

    @YearMonth
    private String reqYearMonth; // yyyyMM


//    @AssertTrue(message = "yyyyMM 형태가 아닙니다.")
//    public boolean isReqYearMonthValidation() {
//        System.out.println("123");
//        try {
//            LocalDate localDate = LocalDate.parse(getReqYearMonth() + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//        } catch (Exception e) {
//            System.out.println("123");
//            return false;
//        }
//        System.out.println("123");
//        return true;
//    }


    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }
}
