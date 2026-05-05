import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtApp extends Application {

    private final int SIZE = 8;
    private Rectangle[][] cells = new Rectangle[SIZE][SIZE];

    private PixelGrid grid = new PixelGrid();

    private Command up = new MoveCursorUpCommand(grid);
    private Command down = new MoveCursorDownCommand(grid);
    private Command left = new MoveCursorLeftCommand(grid);
    private Command right = new MoveCursorRightCommand(grid);
    private Command toggle = new TogglePixelCommand(grid);
    private Command generate = new GenerateCodeCommand(grid);

    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Rectangle rect = new Rectangle(40, 40);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.GRAY);

                cells[i][j] = rect;
                gridPane.add(rect, j, i);
            }
        }

        Button generateBtn = new Button("Generate Code");
        generateBtn.setOnAction(e -> generate.execute());

        VBox root = new VBox(gridPane, generateBtn);

        Scene scene = new Scene(root);

        // keyboard ctrl
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP -> up.execute();
                case DOWN -> down.execute();
                case LEFT -> left.execute();
                case RIGHT -> right.execute();
                case SPACE -> toggle.execute();
            }
            refresh();
        });

        root.setOnMouseClicked(e -> root.requestFocus());
        root.requestFocus();

        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");

        refresh();

        stage.show();
    }

    private void refresh() {
        int[][] g = grid.getGrid();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (g[i][j] == 1) {
                    cells[i][j].setFill(Color.BLACK);
                } else {
                    cells[i][j].setFill(Color.WHITE);
                }

                // cursor highlight
                if (i == grid.getCursorRow() && j == grid.getCursorCol()) {
                    cells[i][j].setStroke(Color.RED);
                    cells[i][j].setStrokeWidth(3);
                } else {
                    cells[i][j].setStroke(Color.GRAY);
                    cells[i][j].setStrokeWidth(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}