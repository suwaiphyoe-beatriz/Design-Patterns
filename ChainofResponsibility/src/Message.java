public class Message {

    MessageType type;
    String content;
    String email;

    public Message(MessageType type, String content, String email) {
        this.type = type;
        this.content = content;
        this.email = email;
    }
}