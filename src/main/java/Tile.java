import javafx.scene.paint.Color;

public class Tile {

    Color colour;
    int score;
    boolean merged;

    public Tile() {
        this.score = 0;
        this.merged = false;
    }

    public Color getBackgroundColour(){
        switch(this.score){
            case 2 : return Color.BLUE;
            case 4 : return Color.PINK;
            case 8 : return Color.RED;
            case 16 : return Color.BROWN;
            default: return Color.TOMATO;
        }
    }

}
