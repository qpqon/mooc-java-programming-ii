package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Support");
        
        String filePath = "partiesdata.tsv";
        TSVReader tsv = new TSVReader(filePath);
        
        LineChart<Number, Number> lineChart = tsv.filledLineChart(xAxis, yAxis);
        lineChart.setTitle("Relative support in the years 1968-2008");
        
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
