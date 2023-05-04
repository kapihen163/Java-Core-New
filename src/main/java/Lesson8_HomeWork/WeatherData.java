package Lesson8_HomeWork;

public class WeatherData {
    private String city;
    private String date;
    private String weatherText;
    private Double temperature;


    public WeatherData(String city, String localDate, String weatherText, Double temperature) {
        this.city = city;
        this.date = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setLocalDate(String localDate) {
        this.date = localDate;
    }

    public String getText() {
        return weatherText;
    }

    public void setText(String text) {
        this.weatherText = weatherText;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
