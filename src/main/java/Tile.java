import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class Tile extends Rectangle {

    private int score;
    private boolean merged;
    private Text scoreText;

    Tile() {
        this.merged = false;
        scoreText = new Text();
        this.setHeight(100);
        this.setWidth(100);
        this.setScore(0);
    }

    int getScore(){
        return this.score;
    }

    void setScore(int score){
        this.score = score;
        this.setFill(getBackgroundColour());
        this.scoreText.setText(String.valueOf(getScore()));

        if(getScore() == 0) {
            this.scoreText.setFill(Color.WHITE);
        }
        else {
            this.scoreText.setFill(Color.BLACK);
        }
    }

    Text getScoreText(){
        return scoreText;
    }

    private Color getBackgroundColour() {
        switch (this.score) {
            case 0:
                return Color.WHITE;
            case 2:
                return Color.BLUE;
            case 4:
                return Color.PINK;
            case 8:
                return Color.RED;
            case 16:
                return Color.BROWN;
            default:
                return Color.TOMATO;
        }
    }

}
