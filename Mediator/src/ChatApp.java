import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ChatMediator mediator = new ChatServer();

        createClientWindow("Alice", mediator);
        createClientWindow("Bob", mediator);
        createClientWindow("Charlie", mediator);
    }

    private void createClientWindow(String username, ChatMediator mediator) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("chat.fxml"));
        Parent root = loader.load();

        ChatController controller = loader.getController();
        controller.setup(username, mediator);

        mediator.registerClient(controller);

        Stage stage = new Stage();
        stage.setTitle(username);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}