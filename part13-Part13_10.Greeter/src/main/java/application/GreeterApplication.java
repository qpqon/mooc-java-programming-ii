package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        // first layout/ Scene elements
        Label label = new Label("Enter your name and start.");
        TextField nameField = new TextField();
        Button start = new Button("Start");
        
        // first layout add elements
        GridPane firstLayout = new GridPane();
        firstLayout.add(label, 0, 0);
        firstLayout.add(nameField, 0, 1);
        firstLayout.add(start, 0, 2);
        
        // styling first layout
        firstLayout.setPrefSize(300, 180);
        firstLayout.setAlignment(Pos.CENTER);
        firstLayout.setVgap(10);
        
        // second layout/ scene elements
        Label welcomeMessage = new Label();
        
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.getChildren().add(welcomeMessage);
        
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.setAlignment(Pos.CENTER);        
        
        // scenes
        Scene firstScene = new Scene(firstLayout);
        Scene secondScene = new Scene(welcomeLayout);
        
        // button action
        start.setOnAction((event) -> {          
             welcomeMessage.setText("Welcome " + nameField.getText() + "!");
             window.setScene(secondScene);
        });
        
        // start
        window.setScene(firstScene);
        window.show();
    }
    

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
