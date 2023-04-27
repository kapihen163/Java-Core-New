package Lesson7_HomeWork;

import Lesson7_HomeWork.model.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuWeatherProvider implements WeatherProvider {
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";

    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public WeatherResponse getWeather(String city, Period period) throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST_ENDPOINT)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(period.getApiDaysCode())
                .addPathSegment(city)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();


        Response response = client.newCall(request).execute();
        String result = response.body().string();

        WeatherResponse weatherResponse = objectMapper.readValue(result, WeatherResponse.class);

        return weatherResponse;
    }

    @Override
    public String findCityByUserInput(String userInput) throws IOException {
        // http://dataservice.accuweather.com/locations/v1/cities/autocomplete

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "en-en")
                .addQueryParameter("q", userInput)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();


        Response response = client.newCall(request).execute();
        String result = response.body().string();

        JsonNode jsonNode = objectMapper.readTree(result);

        // get first result
        JsonNode keyNode = jsonNode.findValue("Key");
        if (keyNode == null) {
            return "";
        }

        String key = keyNode.asText();

        return key;
    }


}

