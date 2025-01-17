package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {        
        BorderPane layout = new BorderPane();

        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is:");
        
        TextArea text = new TextArea();
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int charCount = newValue.length();
            String[] parts = newValue.split(" ");
            int wordCount = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();  
            
            letters.setText("Letters: " + charCount);
            words.setText("Words: " + wordCount);
            longestWord.setText("The longest word is: " + longest);
        });
        
        HBox counters = new HBox();
        counters.setSpacing(8);
        counters.getChildren().add(letters);
        counters.getChildren().add(words);
        counters.getChildren().add(longestWord);
        
        layout.setCenter(text);
        layout.setBottom(counters);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
