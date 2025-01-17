package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        Label firstLabel = new Label("My first UI");
        Button firstButton = new Button("My first button");
        
        FlowPane componentContainer = new FlowPane();
        componentContainer.getChildren().add(firstButton);
        componentContainer.getChildren().add(firstLabel);
        
        Scene firstScene = new Scene(componentContainer);
        
        window.setScene(firstScene);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
