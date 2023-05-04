package Lesson8_HomeWork;

import Lesson8_HomeWork.model.WeatherResponse;

import java.io.IOException;

public interface WeatherProvider {
    WeatherResponse getWeather(String city, Period period) throws IOException;

    String findCityByUserInput(String userInput) throws IOException;

//    WeatherData getAllFromDb() throws IOException;
}

