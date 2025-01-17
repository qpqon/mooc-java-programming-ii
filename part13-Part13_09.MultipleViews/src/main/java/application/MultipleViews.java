package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    @Override
    public void start(Stage window) throws Exception {
        // first layout
        Label firstLabel = new Label("First view!");
        Button toSecond = new Button("To the second view!");
        
        BorderPane firstLayout = new BorderPane();
        firstLayout.setTop(firstLabel);
        firstLayout.setCenter(toSecond);
        
        // second Layout
        Button toThird = new Button("To the third view!");
        Label secondLabel = new Label("Second view!");
        
        VBox secondLayout = new VBox();
        secondLayout.getChildren().addAll(toThird, secondLabel);
        
        // third layout
        Label thirdLabel = new Label("Third view!");
        Button toFirst = new Button("To the first view!");
        
        GridPane thirdLayout = new GridPane();
        thirdLayout.add(thirdLabel, 0, 0);
        thirdLayout.add(toFirst, 1, 1);
        
        // scene organisation
        Scene firstScene = new Scene(firstLayout);
        Scene secondScene = new Scene(secondLayout);
        Scene thirdScene = new Scene(thirdLayout);
        
        // events
        toSecond.setOnAction((event) -> {
            window.setScene(secondScene);
        });
        
        toThird.setOnAction((event) -> {
            window.setScene(thirdScene);
        });
        
        toFirst.setOnAction((event) -> {
            window.setScene(firstScene);
        });
        
        // start screen
        window.setScene(firstScene);
        window.show();
    }
    

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
