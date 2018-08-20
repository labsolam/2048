import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application {

    private Model model;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("2048");
        primaryStage.fullScreenProperty();
        primaryStage.setMaximized(true);

        buildStartScreen(primaryStage);
    }

    private void buildStartScreen(Stage primaryStage) {
        VBox root = new VBox();
        Button start = new Button("Start Game");
        Button exit = new Button("Exit");

        start.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buildGame(primaryStage);
            }
        });

        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.close();
            }
        });

        root.setSpacing(10);
        root.getChildren().add(start);
        root.getChildren().add(exit);

        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    public void buildGame(Stage primaryStage){
        GridPane root = new GridPane();
        root.gridLinesVisibleProperty();
        root.addColumn(0);
        root.addColumn(1);
        root.addColumn(2);
        root.addColumn(3);

        root.addRow(0);
        root.addRow(1);
        root.addRow(2);
        root.addRow(3);

        root.add(new Button(), 0, 0);
        root.add(new Button(), 0, 1);
        root.add(new Button(), 0, 2);
        root.add(new Button(), 0, 3);

        root.add(new Button(), 1, 0);
        root.add(new Button(), 1, 1);
        root.add(new Button(), 1, 2);
        root.add(new Button(), 1, 3);

        root.add(new Button(), 2, 0);
        root.add(new Button(), 2, 1);
        root.add(new Button(), 2, 2);
        root.add(new Button(), 2, 3);

        root.add(new Button(), 3, 0);
        root.add(new Button(), 3, 1);
        root.add(new Button(), 3, 2);
        root.add(new Button(), 3, 3);

        Button back = new Button("Back");
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buildGame(primaryStage);
            }
        });

        root.add(back, 4,4);

        root.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()) {

                    case UP:
                        System.out.println("Up");; break;
                    case DOWN:
                        System.out.println("Down");; break;
                    case LEFT:
                        System.out.println("Left");; break;
                    case RIGHT:
                        System.out.println("Right");; break;

                }
            }
        });

        primaryStage.setScene(new Scene(root, 300, 300));
    }

}