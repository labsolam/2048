import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application {

    public Tile[] board;
    int score;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Display board
        //Add tiles
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setMinSize(400, 400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(100);
        rectangle.setWidth(100);

        Rectangle rectangle1 = new Rectangle();
        rectangle.setHeight(100);
        rectangle.setWidth(100);

        Rectangle rectangle2 = new Rectangle();
        rectangle.setHeight(100);
        rectangle.setWidth(100);

        //gridPane.add(rectangle, 0,0);
        //gridPane.add(rectangle1, 1,1);
        //gridPane.add(rectangle2, 2,2);
        gridPane.add(new Text("heyy"), 1, 3);


        Scene scene = new Scene(gridPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
