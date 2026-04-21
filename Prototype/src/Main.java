import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Original recommendation
        Recommendation fantasy = new Recommendation("Fantasy Readers");

        fantasy.addBook(new Book(
                "J.R.R Tolkien",
                "The Hobbit",
                "Fantasy",
                1937));

        fantasy.addBook(new Book(
                "George R.R Martin",
                "Game of Thrones",
                "Fantasy",
                1996));

        System.out.println("Original Recommendation:");
        fantasy.displayBooks();


        // Clone recommendation
        Recommendation youngAdults = fantasy.clone();

        youngAdults.setTargetAudience("Young Adult Readers");

        youngAdults.addBook(new Book(
                "Suzanne Collins",
                "The Hunger Games",
                "Dystopian",
                2008));

        youngAdults.removeBook(0); // removes The Hobbit only from clone

        System.out.println("\nCloned & Modified Recommendation:");
        youngAdults.displayBooks();

        // Original unchanged
        System.out.println("\nOriginal Still Unchanged:");
        fantasy.displayBooks();

        sc.close();
    }
}