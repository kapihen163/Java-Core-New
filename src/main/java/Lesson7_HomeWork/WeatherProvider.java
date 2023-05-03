package Lesson7_HomeWork;

import Lesson7_HomeWork.model.WeatherResponse;

import java.io.IOException;

public interface WeatherProvider {
    WeatherResponse getWeather(String city, Period period) throws IOException;

    String findCityByUserInput(String userInput) throws IOException;

//    WeatherData getAllFromDb() throws IOException;
}

