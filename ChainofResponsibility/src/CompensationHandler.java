public class CompensationHandler extends Handler {

    public void handle(Message msg) {
        if (msg.type == MessageType.COMPENSATION) {
            System.out.println("Handling compensation for " + msg.email);
        } else if (next != null) {
            next.handle(msg);
        }
    }
}