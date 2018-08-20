import javafx.application.Application;

public class Start {
    public static void main(String[] args){
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);

        Application.launch(View.class);
    }
}