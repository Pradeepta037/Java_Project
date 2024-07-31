public class WeatherData {
    private String location;
    private double temperature;
    private int humidity;
    private String condition;

    public WeatherData(String location, double temperature, int humidity, String condition) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
    }

    // Getters and Setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Location: " + location + "\nTemperature: " + temperature + "°C\nHumidity: " + humidity + "%\nCondition: " + condition;
    }
}
