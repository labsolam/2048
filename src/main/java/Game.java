import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends Application {

    public Tile[] board;
    int score;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Display board
        //Add tiles
        createGame();

        TilePane tilePane = new TilePane();
        //tilePane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        for(Tile tile : board){
            tilePane.getChildren().add(new StackPane(tile, tile.getScoreText()));
        }

        Scene scene = new Scene(tilePane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createGame(){
        board = new Tile[15];

        for(int i = 0; i < board.length; i++){
            board[i] = new Tile();
        }

        addTile();
        addTile();
    }

    private void addTile(){
        ArrayList<Tile> empty = new ArrayList<>();

        for(Tile tile : board){
            if(tile.getScore() == 0)
                empty.add(tile);
        }

        empty.get(ThreadLocalRandom.current().nextInt(empty.size())).setScore(getRandomTile());
    }

    private int getRandomTile(){
        if(ThreadLocalRandom.current().nextDouble() > .5)
            return 2;

        return 4;
    }

}
