package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class InputView {    
    private Dictionary dictionary;
    
    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    
    public Parent getView() {
        // Elements
        Label wordInstruct = new Label("Word");
        TextField wordPut = new TextField();
        Label wordError = new Label("Field cannot be empty!");
        wordError.setVisible(false);
        
        Label translationInstruct = new Label("Translation");
        TextField translationPut = new TextField();
        Label translationError = new Label("Field cannot be empty!");
        translationError.setVisible(false);
        
        Button addButton = new Button("Add to dictionary");
        
        // Layout
        GridPane layout = new GridPane();       
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        // Adding elements to layout
        layout.add(wordInstruct, 0, 0);
        layout.add(wordPut, 1, 0);
        layout.add(wordError, 2, 0);
        
        layout.add(translationInstruct, 0, 1);
        layout.add(translationPut, 1, 1);
        layout.add(translationError, 2, 1);
        
        layout.add(addButton, 1, 2);
        
        // Button action
        addButton.setOnAction((event) -> {
            boolean error1 = ifTextFieldIsEmpty(wordPut, wordError);
            boolean error2 = ifTextFieldIsEmpty(translationPut, translationError);
            
            if (!error1 && !error2) {
                String word = wordPut.getText();
                String translation = translationPut.getText();
                
                this.dictionary.add(word, translation);
                
                wordPut.clear();
                translationPut.clear();
            }
        });
        
        return layout;
    }
        
    private boolean ifTextFieldIsEmpty(TextField textfield, Label label) {
        if (textfield.getText().isEmpty()) {
            label.setVisible(true);
            return true;
        }
        
        label.setVisible(false);
        return false;
    }
}
