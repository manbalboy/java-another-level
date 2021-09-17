package dto;

import java.util.List;

public class User {
    public List<Car> cars;
    private String name;
    private Integer age;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "cars=" + cars +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
