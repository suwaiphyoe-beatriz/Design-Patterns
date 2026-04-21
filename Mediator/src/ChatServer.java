import java.util.*;

public class ChatServer implements ChatMediator {

    private final Map<String, ChatController> clients = new LinkedHashMap<>();

    @Override
    public void registerClient(ChatController client) {
        clients.put(client.getUsername(), client);
        notifyUserListUpdated(); // auto update
    }

    @Override
    public void sendMessage(String message, ChatController sender, String recipient) {
        ChatController receiver = clients.get(recipient);

        if (receiver != null) {
            receiver.receiveMessage("From " + sender.getUsername() + ": " + message);
        }
    }

    @Override
    public List<String> getRegisteredUsernames() {
        return new ArrayList<>(clients.keySet());
    }

    @Override
    public void notifyUserListUpdated() {
        List<String> users = getRegisteredUsernames();

        for (ChatController client : clients.values()) {
            client.updateUserList(users);
        }
    }
}