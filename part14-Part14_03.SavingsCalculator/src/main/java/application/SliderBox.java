package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
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
public class SliderBox {
    private Slider sliSavings;
    private Slider sliInterest;    
    private SimpleDoubleProperty savingsProperty;
    private SimpleDoubleProperty interestProperty;
    
    
    public SliderBox() {
        this.sliSavings = new Slider(25, 250, 25);
        this.sliInterest = new Slider(0, 10, 0);    
        giveMarksToSliderTracks();
        
        this.savingsProperty = createSliderProperty(sliSavings, 25.0);
        this.interestProperty = createSliderProperty(sliInterest, 0.0);
    }
    
    private void giveMarksToSliderTracks() {
        sliSavings.setSnapToTicks(true);
        sliSavings.setBlockIncrement(500);
        sliSavings.setShowTickMarks(true);
        sliSavings.setShowTickLabels(true);
        
        sliInterest.setMinorTickCount(10);
        sliInterest.setShowTickMarks(true);
        sliInterest.setShowTickLabels(true);
    }
    
    private SimpleDoubleProperty createSliderProperty(Slider slider, Double initialVal) {
        SimpleDoubleProperty sliderListener = new SimpleDoubleProperty(initialVal);    
        sliderListener.bind(slider.valueProperty());
        
        return sliderListener;
    }
    
    public VBox getSliderBox() {
        VBox vbox = new VBox(10);
        vbox.getChildren().add(sliderLayout("Monthly savings", sliSavings, savingsProperty));
        vbox.getChildren().add(sliderLayout("Yearly interest rate", sliInterest, interestProperty));
        
        return vbox;
    }
    
    private BorderPane sliderLayout(String sliderName, Slider slider, SimpleDoubleProperty sliderValue) {
        Label currentSliderValue = new Label();
        currentSliderValue.textProperty().bind(sliderValue.asString("%.2f"));
        
        BorderPane layout = new BorderPane();        
        layout.setLeft(new Label(sliderName));
        layout.setCenter(slider);
        layout.setRight(currentSliderValue);
        
        return layout;
    }
        
    public SimpleDoubleProperty getSavingsProperty() {
        return this.savingsProperty;
    } 
    
    public SimpleDoubleProperty getInterestProperty() {
        return this.interestProperty;
    }
}
