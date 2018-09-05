import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends Application {

    private Tile[] board;
    private int score;
    private Stage stage;

    private EventHandler handle = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            switch(event.getCode()){
                case UP:
                    moveUp();
                    event.consume();
                    break;
                case DOWN:
                    moveDown();
                    event.consume();
                    break;
                case LEFT:
                    moveLeft();
                    event.consume();
                    break;
                case RIGHT:
                    moveRight();
                    event.consume();
                    break;
            }
        }
    };


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        startGame();
    }

    private void startGame(){
        createBoard();
        score = 0;
        TilePane tilePane = new TilePane();

        for(Tile tile : board){
            tilePane.getChildren().add(new StackPane(tile, tile.getScoreText()));
        }

        Scene scene = new Scene(tilePane,400,400);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, handle);

        stage.setMaxHeight(400);
        stage.setMaxWidth(400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void createBoard(){
        board = new Tile[16];

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

    private void moveUp(){
        System.out.println("Up");
        addTile();

        if(checkGameOver()){
            gameOver();
            System.out.println("RANNNN");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resetGame();
        }
    }

    private void moveDown(){
        System.out.println("Down");
        addTile();
    }

    private void moveLeft(){
        System.out.println("Left");
        addTile();
    }

    private void moveRight(){
        System.out.println("Right");
        addTile();
    }

    private boolean checkGameOver(){
        for(Tile tile : board){
            if(tile.getScore() == 0) return false;
        }
        return true;
    }

    private void resetGame(){
        startGame();
    }

    private void gameOver(){
        stage.getScene().removeEventFilter(KeyEvent.KEY_PRESSED, handle);
        System.out.println("GAME OOOOOOOVVVVVVVVEEEEEEERRRRR");
    }
}
