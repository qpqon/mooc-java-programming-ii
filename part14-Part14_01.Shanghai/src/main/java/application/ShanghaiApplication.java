package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    @Override
public void start(Stage stage) {
    NumberAxis xAxis = new NumberAxis(2006 , 2018, 2);
    xAxis.setLabel("Year");    
    NumberAxis yAxis = new NumberAxis(0, 100, 5);
    yAxis.setLabel("Ranking");     

    LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
    lineChart.setTitle("University of Helsinki, Shanghai Ranking");
    
    // adding data sets
    XYChart.Series chart = new XYChart.Series();  

    int[] yData = {73, 68, 72, 72, 74, 73, 76, 73, 67, 56, 56};   
    final int DATA_LENGTH = 11;
    for (int i = 0; i < DATA_LENGTH; i++) {
        int xData = 2007 + i;
        chart.getData().add(new XYChart.Data(xData, yData[i]));
    }
    
    lineChart.getData().add(chart);
    
    // display the line chart
    Scene view = new Scene(lineChart, 640, 480);
    stage.setScene(view);
    stage.show();
}
    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

}
