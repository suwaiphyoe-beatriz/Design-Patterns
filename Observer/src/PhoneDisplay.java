public class PhoneDisplay implements WeatherObserver {
    private String name;

    public PhoneDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(" " + name + " phone display: Current temperature is " + temperature + "°C");
    }
}
