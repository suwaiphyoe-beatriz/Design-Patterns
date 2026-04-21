import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class ChatController {

    @FXML
    private TextArea chatArea;

    @FXML
    private TextField messageField;

    @FXML
    private ComboBox<String> recipientBox;

    private String username;
    private ChatMediator mediator;

    public void setup(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }

    public String getUsername() {
        return username;
    }

    @FXML
    public void sendButtonClicked() {
        String message = messageField.getText().trim();
        String recipient = recipientBox.getValue();

        if (message.isEmpty() || recipient == null) {
            return;
        }

        mediator.sendMessage(message, this, recipient);

        chatArea.appendText("To " + recipient + ": " + message + "\n");
        messageField.clear();
    }

    public void receiveMessage(String message) {
        chatArea.appendText(message + "\n");
    }

    // Called by mediator when user list changes
    public void updateUserList(List<String> users) {
        String previous = recipientBox.getValue();

        recipientBox.getItems().clear();

        for (String user : users) {
            if (!user.equals(username)) {
                recipientBox.getItems().add(user);
            }
        }

        if (previous != null && recipientBox.getItems().contains(previous)) {
            recipientBox.setValue(previous);
        } else if (!recipientBox.getItems().isEmpty()) {
            recipientBox.getSelectionModel().selectFirst();
        }
    }
}