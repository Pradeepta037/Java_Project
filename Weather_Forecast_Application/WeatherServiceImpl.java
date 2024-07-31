public class WeatherServiceImpl implements WeatherService {
    @Override
    public WeatherData getWeather(String location) {
        // In a real application, you would fetch this data from an API or database.
        // For simplicity, we are returning dummy data.
        if (location.equalsIgnoreCase("New York")) {
            return new WeatherData(location, 25.0, 60, "Sunny");
        } else if (location.equalsIgnoreCase("London")) {
            return new WeatherData(location, 15.0, 80, "Rainy");
        } else {
            return new WeatherData(location, 20.0, 50, "Partly Cloudy");
        }
    }
}
