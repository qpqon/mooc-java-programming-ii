package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class ChartPane {
    private SimpleDoubleProperty savingsProperty;
    private SimpleDoubleProperty interestProperty;
    
    private LineChart<Number, Number> lineChart;
    private XYChart.Series<Number, Number> savingsGraph;
    private XYChart.Series<Number, Number> interestGraph;
    
    
    public ChartPane(SliderBox sliderBox) {
        this.savingsProperty = sliderBox.getSavingsProperty();
        this.interestProperty = sliderBox.getInterestProperty();
        
        this.lineChart = initChart();
        this.savingsGraph = newGraph("Savings without interest");
        this.interestGraph = newGraph("Savings with interest");
        
        initGraphs();
        makeGraphsListenToSliders();
    }
    
    public LineChart getLineChart() {
        return this.lineChart;
    }
    
    private LineChart initChart() {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();        
        xAxis.setLabel("Years");
        yAxis.setLabel("Euro");
        
        return new LineChart<>(xAxis, yAxis);
    }
    
    private XYChart.Series newGraph(String name) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(name);
        
        return series;
    }
    
        private void initGraphs() {
        updateGraphs();
    }
        
    private void makeGraphsListenToSliders() {
        Timeline updateDelay = new Timeline(new KeyFrame(Duration.millis(200), e -> updateGraphs()));
        updateDelay.setCycleCount(1);
        
        this.savingsProperty.addListener((obs, oldVal, newVal) -> {
            updateDelay.playFromStart(); 
        });

        this.interestProperty.addListener((obs, oldVal, newVal) -> {
            updateDelay.playFromStart();
        });
    }
        
    private void updateGraphs() {
        this.savingsGraph.getData().clear();
        this.interestGraph.getData().clear();
        
        double savingsWithoutInterest = 0.0;
        double totalSavings = 0.0;
        double monthlySavingsRate = this.savingsProperty.get();   
        double annualInterestRate = this.interestProperty.get();
        
        final int YEARS = 30;
        
        // initial values for month 0
        savingsGraph.getData().add(new XYChart.Data<>(0, savingsWithoutInterest)); 
        interestGraph.getData().add(new XYChart.Data<>(0, totalSavings));
        
        // calculate values for month 1 to 30
        for (int year = 1; year <= YEARS; year++) {
            double annualSavings = monthlySavingsRate * 12;
            savingsWithoutInterest += annualSavings;
            savingsGraph.getData().add(new XYChart.Data<>(year, savingsWithoutInterest));
            
            totalSavings += annualSavings;
            double interest = totalSavings * (annualInterestRate / 100);
            totalSavings += interest;            
            interestGraph.getData().add(new XYChart.Data<>(year, totalSavings));
        }
        
        if (!this.lineChart.getData().contains(savingsGraph)) {
        this.lineChart.getData().add(savingsGraph);
        }
        if (!this.lineChart.getData().contains(interestGraph)) {
            this.lineChart.getData().add(interestGraph);
        }
    }
}
