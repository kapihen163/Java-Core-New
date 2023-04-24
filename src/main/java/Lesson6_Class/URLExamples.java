package Lesson6_Class;

import java.net.MalformedURLException;
import java.net.URL;

public class URLExamples {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.accuweather.com:80/ru/ru/samara/290396/weather-forecast/290396");

        System.out.println(url.getProtocol());
        System.out.println(url.getAuthority());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());

        URL url1 = new URL("https","accuweather.com", "/ru/ru/samara/290396/weather-forecast/290396");
    }
}
