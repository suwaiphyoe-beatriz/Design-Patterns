public class WindowDisplay implements WeatherObserver {
    private String location;

    public WindowDisplay(String location) {
        this.location = location;
    }

    @Override
    public void update(int temperature) {
        System.out.println(" Window display in " + location + ": Temperature updated to " + temperature + "°C");
    }
}
