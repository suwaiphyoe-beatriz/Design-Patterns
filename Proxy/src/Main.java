public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        // Users
        User alice = new User("alice");
        User bob = new User("bob");

        // Documents
        library.addUnprotectedDocument("doc1", "2026-03-31", "Public Content");
        library.addProtectedDocument("doc2", "2026-03-31", "Secret Content");

        // Access control
        AccessControlService acs = AccessControlService.getInstance();
        acs.grantAccess("doc2", "alice");

        // Public access
        System.out.println("Bob reads public doc:");
        System.out.println(library.getDocument("doc1").getContent(bob));

        // Authorized access
        System.out.println("\nAlice reads protected doc:");
        System.out.println(library.getDocument("doc2").getContent(alice));

        //Unauthorized access
        System.out.println("\nBob tries to read protected doc:");
        try {
            System.out.println(library.getDocument("doc2").getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}