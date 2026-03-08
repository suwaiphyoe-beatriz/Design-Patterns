import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] smallArray = randomArray(30);
        int[] bigArray = randomArray(100000);

        test("Bubble Sort", new BubbleSort(), smallArray.clone());
        test("Insertion Sort", new InsertionSort(), smallArray.clone());
        test("Selection Sort", new SelectionSort(), smallArray.clone());

        System.out.println("\nLarge dataset:");

        test("Bubble Sort", new BubbleSort(), bigArray.clone());
        test("Insertion Sort", new InsertionSort(), bigArray.clone());
        test("Selection Sort", new SelectionSort(), bigArray.clone());
    }

    static int[] randomArray(int size) {

        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        return arr;
    }

    static void test(String name, SortStrategy strategy, int[] arr) {

        SortContext context = new SortContext(strategy);

        long start = System.nanoTime();
        context.sortArray(arr);
        long end = System.nanoTime();

        System.out.println(name + " time: " + (end - start));
    }
}