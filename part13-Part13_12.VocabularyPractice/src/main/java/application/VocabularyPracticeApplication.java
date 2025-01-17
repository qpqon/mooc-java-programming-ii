package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


// END SOLUTION
public class VocabularyPracticeApplication extends Application {
    private Dictionary dictionary;
    
    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }
    
    @Override
    public void start(Stage window) throws Exception {
        // Elements
        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");
        
        InputView inputView = new InputView(this.dictionary);
        PracticeView practiceView = new PracticeView(this.dictionary);
        
        // Sub layout & adding elements
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        menu.getChildren().addAll(enterButton, practiceButton);
        
        // Meta layout & adding Elements
        BorderPane layout = new BorderPane();
        layout.setTop(menu);
        layout.setCenter(inputView.getView()); //default
        
        // Button action
        enterButton.setOnMouseClicked((event) -> {
            layout.setCenter(inputView.getView());
        });
        
        practiceButton.setOnMouseClicked((event) -> {
            layout.setCenter(practiceView.getView());
        });
        
        // Execute
        Scene scene = new Scene(layout, 400, 200);
        
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
