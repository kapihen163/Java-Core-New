package Lesson7_HomeWork;

import Lesson7_HomeWork.model.DailyForecast;
import Lesson7_HomeWork.model.WeatherResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class UserInterface {

    public void runApplication() throws Exception {

        WorkFlow workFlow = new WorkFlow();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (Step step : workFlow.steps) {
                if (!step.isComplete) {
                    System.out.println(step.text);
                    String input = scanner.nextLine();
                    checkIsExit(input);
                    step.validateAndSet(input);
                }
            }
            boolean isAllComplete = workFlow.steps.stream()
                    .allMatch(step -> step.isComplete);

            if (isAllComplete) {
                break;
            }
        }

        Step step = workFlow.steps.stream().findFirst().get();

        WeatherProvider weatherProvider = new AccuWeatherProvider();
        String cityByUserInput = weatherProvider.findCityByUserInput(step.stepUserInput);

        if (StringUtils.isBlank(cityByUserInput)) {
            throw new RuntimeException(String.format("City %s is not found", step.stepUserInput));
        }

        WeatherResponse weather = weatherProvider.getWeather(cityByUserInput, Period.FIVE_DAYS);

        List<DailyForecast> dailyForecasts = weather.getDailyForecasts();

        saveToDB(dailyForecasts);


        printResult(step, dailyForecasts);
    }

    private void saveToDB(List<DailyForecast> dailyForecasts) {
        try {
            DatabaseRepository databaseRepository = new DataBaseRepositoryImpl();
            databaseRepository.initDB();

            WeatherData weatherData = new WeatherData("city", "date", "test", 4.0);


            databaseRepository.saveWeatherData(weatherData);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void printResult(Step step, List<DailyForecast> dailyForecasts) {
        for (int i = 0; i < dailyForecasts.size(); i++) {
            DailyForecast dailyForecast = dailyForecasts.get(i);

            int day = i + 1;
            String city = step.stepUserInput;
            String date = dailyForecast.getDate();
            String weatherText = dailyForecast.getDay().getIconPhrase();

            String temperature = dailyForecast.getTemperature().getMinimum().getValue().toString()
                    + " " +
                    dailyForecast.getTemperature().getMinimum().getUnit();

            String result = String.format("%d день В городе %s на дату %s ожидается %s, температура [ %s ]", day, city, date, weatherText, temperature);

            System.out.println(result);
        }
    }

    private void checkIsExit(String results) {
        if (results.toLowerCase().equals("выход") || results.toLowerCase().equals("exit")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().getSelectedCity(city);
    }


    static class WorkFlow {
        List<Step> steps = new LinkedList<>();

        public WorkFlow() {
            steps.add(new CityStep("Введите название города на англ. языке"));
            steps.add(new ConfirmStep("Введите ответ:1 - Получить погоду на следующие 5дней," + "выход (exit) - завершить работу"));
        }
    }


    static class ConfirmStep extends Step {

        public ConfirmStep(String text) {
            super(text);
        }

        @Override
        void validateAndSet(String userInput) throws IOException {
            super.validateAndSet(userInput);

            if (!NumberUtils.isParsable(userInput)) {
                throw new IOException("Incorrect user input");
            }
        }
    }

    static class CityStep extends Step {

        public CityStep(String text) {
            super(text);
        }

        @Override
        void validateAndSet(String userInput) throws IOException {
            super.validateAndSet(userInput);
        }
    }


    abstract static class Step {

        private boolean isComplete;

        private String text;

        private String stepUserInput;

        public Step(String text) {
            this.text = text;
        }

        void validateAndSet(String userInput) throws IOException {
            if (StringUtils.isBlank(userInput)) {
                throw new IOException("Incorrect user input");
            }

            stepUserInput = userInput;
            isComplete = true;
        }
    }

}

