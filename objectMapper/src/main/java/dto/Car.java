package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String name;
    @JsonProperty("car_number")
    private String carNumer;
    @JsonProperty("TYPE")
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumer() {
        return carNumer;
    }

    public void setCarNumer(String carNumer) {
        this.carNumer = carNumer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carNumer='" + carNumer + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
