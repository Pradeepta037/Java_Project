public class WeatherReport {
    private WeatherService weatherService;

    public WeatherReport(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void displayWeather(String location) {
        WeatherData weatherData = weatherService.getWeather(location);
        System.out.println("Weather Report for " + location + ":\n");
        System.out.println(weatherData);
    }
}
