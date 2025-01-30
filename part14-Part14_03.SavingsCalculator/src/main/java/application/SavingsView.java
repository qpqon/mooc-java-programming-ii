package application;

import javafx.scene.layout.BorderPane;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class SavingsView {
    private BorderPane root;
    private SliderBox sliderBox;
    private ChartPane chartPane;
    
    public SavingsView() {
        this.root = new BorderPane();
        this.sliderBox = new SliderBox();
        this.chartPane = new ChartPane(sliderBox);
        
        setupLayout();
    }
    
    public BorderPane getRoot() {
        return this.root;
    }
    
    private void setupLayout() {
        this.root.setTop(sliderBox.getSliderBox());
        this.root.setCenter(chartPane.getLineChart());
    }
}
