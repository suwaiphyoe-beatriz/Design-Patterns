public class DevelopmentHandler extends Handler {

    public void handle(Message msg) {
        if (msg.type == MessageType.DEVELOPMENT) {
            System.out.println("Saving development idea: " + msg.content);
        } else if (next != null) {
            next.handle(msg);
        }
    }
}