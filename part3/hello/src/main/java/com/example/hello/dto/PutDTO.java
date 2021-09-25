package com.example.hello.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PutDTO {
    private String name;
    private int age;
    private List<PutCarDTO> carList;

    @Override
    public String toString() {
        return "PutDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<PutCarDTO> getCarList() {
        return carList;
    }

    public void setCarList(List<PutCarDTO> carList) {
        this.carList = carList;
    }
}
