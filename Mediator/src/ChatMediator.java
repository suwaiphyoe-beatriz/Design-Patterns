import java.util.List;

public interface ChatMediator {
    void registerClient(ChatController client);
    void sendMessage(String message, ChatController sender, String recipient);
    List<String> getRegisteredUsernames();
    void notifyUserListUpdated();
}