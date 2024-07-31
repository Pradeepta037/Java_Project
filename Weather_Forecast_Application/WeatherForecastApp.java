import java.util.Scanner;

public class WeatherForecastApp {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherServiceImpl();
        WeatherReport weatherReport = new WeatherReport(weatherService);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the location for the weather forecast:");
        String location = scanner.nextLine();

        weatherReport.displayWeather(location);

        scanner.close();
    }
}
