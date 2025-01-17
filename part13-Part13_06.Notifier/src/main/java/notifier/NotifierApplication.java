package notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        TextField inputText = new TextField("");
        Label outputText = new Label("");       
        Button button = new Button("Update");
        
        button.setOnAction((event) -> {
            outputText.setText(inputText.getText());
        });
        
        VBox layout = new VBox();
        layout.setSpacing(4);
        layout.getChildren().addAll(inputText, button, outputText);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
