package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        SavingsView savingsView = new SavingsView();
        BorderPane layout = savingsView.getRoot();
        
        Scene view = new Scene(layout);
        stage.setScene(view);
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
