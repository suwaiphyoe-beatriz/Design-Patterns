import java.util.*;

public class Library {
    private Map<String, DocumentInterface> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, String date, String content) {
        documents.put(id, new Document(id, date, content));
    }

    public void addProtectedDocument(String id, String date, String content) {
        Document realDoc = new Document(id, date, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }
}