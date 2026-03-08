public class Main {

    public static void main(String[] args) {

        Handler h1 = new CompensationHandler();
        Handler h2 = new ContactHandler();
        Handler h3 = new DevelopmentHandler();
        Handler h4 = new GeneralHandler();

        // chain create dr
        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);

        Message m1 = new Message(MessageType.COMPENSATION, "Broken product", "su@email.com");
        Message m2 = new Message(MessageType.CONTACT, "Please call me", "wp@email.com");
        Message m3 = new Message(MessageType.DEVELOPMENT, "Add new feature", "sufen@email.com");
        Message m4 = new Message(MessageType.GENERAL, "Nice service", "service@email.com");

        h1.handle(m1);
        h1.handle(m2);
        h1.handle(m3);
        h1.handle(m4);
    }
}