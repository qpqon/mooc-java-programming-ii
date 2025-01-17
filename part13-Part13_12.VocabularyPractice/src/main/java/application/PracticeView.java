package application;

import java.util.concurrent.atomic.AtomicInteger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class PracticeView {
    private Dictionary dictionary;
    private String word;
    
    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = "...";
    }
    
    public Parent getView() {
        // Elements
        Label wordInstruct = new Label("Translate the word:\n" + this.word);
        TextField translationField = new TextField();
        
        Button newWord = new Button("Generate word");
        Button checkTranslation = new Button("Check");
                
        Label feedback = new Label("");
        feedback.setVisible(false);
                
        // Sub layout & adding elements
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
        gridPane.add(wordInstruct, 0, 0);
        gridPane.add(translationField, 1, 0);
        gridPane.add(newWord, 0, 1);
        gridPane.add(checkTranslation, 1, 1);
        
        // Meta layout & adding elements
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        
        layout.getChildren().addAll(gridPane, feedback);
        
        // Button action
        // generate random word
        AtomicInteger clickCounter = new AtomicInteger(0);
        
        newWord.setOnMouseClicked((event) -> {
            if (this.dictionary.isEmpty()) {
                feedback.setText("The dictionary is empty. Add some words!");
                feedback.setVisible(true);
            } else {
                feedback.setVisible(false);
                this.word = this.dictionary.getRandomWord();
                wordInstruct.setText("Translate the word:\n'" + this.word + "'");
                clickCounter.incrementAndGet();
                
                if (this.dictionary.isSparse() && clickCounter.get() > 1) {
                feedback.setText("The dictionary only has one word. Add some more!");
                feedback.setVisible(true);
                }
            }
        });
        
        // check translation
        checkTranslation.setOnMouseClicked((event) -> {
            if (!this.dictionary.contains(this.word)) {
                feedback.setText("This word is not in the dictionary.");
                feedback.setVisible(true);
            } else if (translationCorrect(translationField)) {
                feedback.setText("Great! Your translation turns out correct.");
                feedback.setVisible(true);
            } else {
                feedback.setText("Dang! The correct translation is " + correctTranslation());
                feedback.setVisible(true);
            }
        });
        
        return layout;
    }
    
    private boolean translationCorrect(TextField textField) {
        String translation = textField.getText().toLowerCase().trim();
        String correctTranslation = this.dictionary.get(word).toLowerCase().trim();
        
        if (correctTranslation.equals(translation)) {
            return true;
        }
        return false;
    }
    
    private String correctTranslation() {
        return "'" + this.dictionary.get(this.word) +"'";
    }
}
