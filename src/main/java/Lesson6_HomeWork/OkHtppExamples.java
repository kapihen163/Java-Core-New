package Lesson6_HomeWork;

import Lesson6_Class.OkHttpExamples;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге
//        на период времени, пересекающийся со следующим занятием (например, выборка
//        погода на следующие 5 дней - подойдет)
//        2. Подобрать источник самостоятельно. Можно использовать api accuweather,
//        порядок следующий: зарегистрироваться, зарегистрировать тестовое приложение
//        для получения api ключа, найдите нужный endpoint и изучите документацию.
//        Бесплатный тарифный план предполагает получение погоды не более чем на
//        5 дней вперед (этого достаточно для выполнения д/з).

public class OkHtppExamples {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("/forecasts/v1/daily/5day/25123?E0ciJ0ySS1cSdeKm4F5IEPZjYqSzwGLS")
//                .addQueryParameter(E0ciJ0ySS1cSdeKm4F5IEPZjYqSzwGLS)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();


        Response response = okHttpClient.newCall(request).execute();

        System.out.println("Код ответа " + response.code());
        System.out.println(response.headers());
        System.out.println(response.body().string());
        System.out.println("Метод запроса " + request.method());


    }
}
