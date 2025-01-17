package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        // button menu
        Button buttonJoke = new Button("Joke");
        Button buttonAnsw = new Button("Answer");
        Button buttonExpl = new Button("Explanation");
        
        HBox buttons = new HBox();
        buttons.setPadding(new Insets(0, 20, 0, 10));
        buttons.setSpacing(10);
        buttons.getChildren().addAll(buttonJoke, buttonAnsw, buttonExpl);
        
        // default subview
        Label buttonOutcome = new Label("What do you call a bear with no teeth?");
        
        // organizing layout
        BorderPane layout = new BorderPane();
        layout.setPrefSize(300, 180);
        layout.setTop(buttons);
        layout.setCenter(buttonOutcome);
        
        // button action
        buttonJoke.setOnAction((event) -> buttonOutcome.setText("What do you call a bear with no teeth?"));
        buttonAnsw.setOnAction((event) -> buttonOutcome.setText("A gummy bear."));
        buttonExpl.setOnAction((event) -> buttonOutcome.setText("Well, it is not a good joke..."));
        
        // scene & start
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
