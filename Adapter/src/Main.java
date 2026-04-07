public class Main {
    public static void main(String[] args) {

        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setDay(19);
        date.setMonth(2);
        date.setYear(2026);

        System.out.println("Initial Date:");
        System.out.println(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        //Advance 10 days
        date.advanceDays(10);

        System.out.println("After advancing 10 days:");
        System.out.println(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}