public class ContactHandler extends Handler {

    public void handle(Message msg) {
        if (msg.type == MessageType.CONTACT) {
            System.out.println("Handling contact request from " + msg.email);
        } else if (next != null) {
            next.handle(msg);
        }
    }
}