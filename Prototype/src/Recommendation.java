import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {

    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        books.remove(index);
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public Recommendation clone() {

        Recommendation cloned = new Recommendation(this.targetAudience);

        // Deep copy
        for (Book book : books) {
            cloned.addBook(book.clone());
        }

        return cloned;
    }

    public void displayBooks() {
        System.out.println("\nAudience: " + targetAudience);

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i+1) + ". " + books.get(i));
        }
    }
}