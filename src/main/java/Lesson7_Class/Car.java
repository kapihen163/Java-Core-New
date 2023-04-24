package Lesson7_Class;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Car {
    private String color;
    private String type;

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public Car() {
    }
}
