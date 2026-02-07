import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {

    private List<WeatherObserver> observers = new ArrayList<>();
    private Random random = new Random();

    private int temperature;
    private final int MIN_TEMP = -10;
    private final int MAX_TEMP = 40;

    public WeatherStation() {
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
        System.out.println(" Initial temperature: " + temperature + "°C");
    }

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        temperature += change;

        if (temperature < MIN_TEMP) temperature = MIN_TEMP;
        if (temperature > MAX_TEMP) temperature = MAX_TEMP;

        System.out.println("\n WeatherStation: Temperature changed to " + temperature + "°C");
        notifyObservers();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int sleepTime = (random.nextInt(5) + 1) * 1000; // 1–5 seconds
                Thread.sleep(sleepTime);
                updateTemperature();
            } catch (InterruptedException e) {
                System.out.println("Weather station stopped.");
                break;
            }
        }
    }
}
