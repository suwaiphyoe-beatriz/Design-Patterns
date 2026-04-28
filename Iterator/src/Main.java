import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Sequence fibSequence = new FibonacciSequence(10);
        Iterator<Integer> iterator = fibSequence.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}