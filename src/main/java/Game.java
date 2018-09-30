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
    public void start(Stage primaryStage) {
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
        if(ThreadLocalRandom.current().nextDouble() > .33)
            return 2;

        return 4;
    }

    private void moveUp(){

        for(int i = 0; i < 4; i++){
            for(int j = i + 4; j < board.length; j += 4){
                if(board[j].getScore() == 0) continue;

                for (int k = j - 4; k >= 0; k -= 4) {
                    if (board[k].getScore() == 0){
                        board[k].setScore(board[k+4].getScore());
                        board[k+4].setScore(0);
                    }
                }
            }
        }

        addTile();

        if(checkGameOver()){
            gameOver();
        }
    }

    private void moveDown(){

        for(int i = 0; i < 4; i++){ //Iterates through each column in the board
            for(int j = i + 8; j >= 0 ; j -= 4){ //Finds empty cells
                if(board[j].getScore() == 0) continue;

                for (int k = j + 4; k <= 15; k += 4) { //Moves cells down
                    if(board[k].getScore() == 0){
                        board[k].setScore(board[k-4].getScore());
                        board[k-4].setScore(0);
                    }
                }
            }
        }

        addTile();

        if(checkGameOver()){
            gameOver();
        }
    }

    private void moveLeft(){

        for(int i = 0; i < board.length; i += 4){
            for(int j = i + 1; j < i + 4; j++ ){
                if(board[j].getScore() == 0) continue;

                for(int k = j; k > i; k--){ //Go backwards
                    if (board[k - 1].getScore() == 0){
                        board[k - 1].setScore(board[k].getScore());
                        board[k].setScore(0);
                    }
                }
            }
        }

        addTile();

        if(checkGameOver()){
            gameOver();
        }
    }

    private void moveRight(){

        for(int i = 0; i < board.length; i += 4){
            for(int j = i + 2; j >= i; j-- ){
                if(board[j].getScore() == 0) continue;

                for(int k = j; k < i + 3; k++){ //Go backwards
                    if (board[k + 1].getScore() == 0){
                        board[k + 1].setScore(board[k].getScore());
                        board[k].setScore(0);
                    }
                }
            }
        }

        addTile();

        if(checkGameOver()){
            gameOver();
        }
    }

    private boolean checkGameOver(){
        for(Tile tile : board){
            if(tile.getScore() == 0) return false;
        }
        return true;
    }

    private void gameOver(){
        stage.getScene().removeEventFilter(KeyEvent.KEY_PRESSED, handle);
        System.out.println("GAME OOOOOOOVVVVVVVVEEEEEEERRRRR");
    }
}
