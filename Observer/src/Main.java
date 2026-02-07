public class Main {
    public static void main(String[] args) throws InterruptedException {

        WeatherStation station = new WeatherStation();

        WeatherObserver phone1 = new PhoneDisplay("Su");
        WeatherObserver phone2 = new PhoneDisplay("Wai");
        WeatherObserver window = new WindowDisplay("Living Room");

        station.registerObserver(phone1);
        station.registerObserver(phone2);
        station.registerObserver(window);

        Thread stationThread = new Thread(station);
        stationThread.start();

        //simulation run for a while
        Thread.sleep(15000);

        System.out.println("\n Removing Wai's phone display...\n");
        station.removeObserver(phone2);

        // run more so we see Wai is no longer notified
        Thread.sleep(15000);

        stationThread.interrupt();
    }
}
