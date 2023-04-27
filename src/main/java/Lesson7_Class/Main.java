package Lesson7_Class;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("белый", "Lada");

        String carFromJSON = objectMapper.writeValueAsString(car);

        System.out.println(carFromJSON);

        Car car1 = objectMapper.readValue(carFromJSON, Car.class);

        System.out.println(car1);

        List<Car> carList = new ArrayList<>(Arrays.asList(
                new Car("Black", "Mersedes"),
                new Car("Red", "renault"))
        );

        System.out.println(carList);

        String carsAsJSON = objectMapper.writeValueAsString(carList);
        System.out.println(carsAsJSON);

        List<Car> carsFromJSON = objectMapper.readValue(carsAsJSON, new TypeReference<ArrayList<Car>>() {
        });

        System.out.println(carsFromJSON);

//        String jasonCarAfterUpdate = "{\"color\":\"белый\",\"type\":\"Lada\",\"year\":\"Lada\"}";

        String jsonCarAfterUpdate = "{\"color\":\"белый\",\"type\":\"Lada\",\"year\":\"Lada\"}";

//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car carAfterUpdate = objectMapper.readValue(jsonCarAfterUpdate, Car.class);
        System.out.println(carAfterUpdate);

        String jsonCarAfterRefactoring = "{\"color\":\"белый\",\"model\":\"Lada\"}";
        Car CarAfterRefactoring = objectMapper.readValue(jsonCarAfterRefactoring, Car.class);

        System.out.println(CarAfterRefactoring);


        Car carWithSeat = new Car("Yellow","Peugot");
        carWithSeat.setSeat(new Seat(5));

        String carWithSaetLSON = objectMapper.writeValueAsString(carWithSeat);
        System.out.println(carWithSaetLSON);

        Car carWithSeatFromJSON = objectMapper.readValue(carWithSaetLSON, Car.class);
        System.out.println(carWithSeatFromJSON);





    }
}
