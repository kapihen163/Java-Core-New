package Lesson7_Class.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel {
//    http://dataservice.accuweather.com/forecasts/v1/daily/5day/

    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "E0ciJ0ySS1cSdeKm4F5IEPZjYqSzwGLS";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";


    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();



    @Override
    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period){
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

               Request request = new Request.Builder()
                       .url(httpUrl)
                       .build();

               Response oneDayForecasResponse = okHttpClient.newCall(request).execute();
               String weatherResponse = oneDayForecasResponse.body().string();
                System.out.println(weatherResponse);

                break;




            case FIVE_DAYS:
                httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment("25123")
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter("apikey", API_KEY_QUERY_PARAM)
                        .addQueryParameter("language", "ru-ru")
                        .addQueryParameter("metric", "true")
                        .build();

                request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response fiveDayForecasResponse = okHttpClient.newCall(request).execute();
                weatherResponse = fiveDayForecasResponse.body().string();
                System.out.println(weatherResponse);




                break;
        }



    }

    private String detectCityKey(String selectedCity) throws IOException {
//        http://dataservice.accuweather.com/locations/v1/cities/autocomplete

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response cityResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = cityResponse.body().string();

        String cityKey = objectMapper.readTree(weatherResponse).get(0).at("/Key").asText();

//        System.out.println(cityKey);

        return cityKey;
    }

    public static void main(String[] args) throws IOException {
//        AccuweatherModel accuweatherModel = new AccuweatherModel();
//        accuweatherModel.getWeather("Moscow", Period.NOW);
//        accuweatherModel.detectCityKey("Moscow");
//
//        accuweatherModel.getWeather("Moscow", Period.FIVE_DAYS);

        UserInterfaceView userInterfaceView = new UserInterfaceView();

        userInterfaceView.runInterface();
    }
}
