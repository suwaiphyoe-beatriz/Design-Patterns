public class GeneralHandler extends Handler {

    public void handle(Message msg) {
        if (msg.type == MessageType.GENERAL) {
            System.out.println("General feedback: " + msg.content);
        } else if (next != null) {
            next.handle(msg);
        }
    }
}