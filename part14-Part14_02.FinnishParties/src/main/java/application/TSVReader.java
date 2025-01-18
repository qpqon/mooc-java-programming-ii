package application;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class TSVReader {
    private String tsvFile;
    
    public TSVReader(String tsv) {
        this.tsvFile = tsv;
    }
    
    public LineChart filledLineChart(NumberAxis xAxis, NumberAxis yAxis) {
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        
        try (BufferedReader br = Files.newBufferedReader(Paths.get(this.tsvFile))) {
            // the first line holds the years 
            String row = br.readLine();
            String[] years = row.split("\t");
            
            List<Integer> xValues = new ArrayList<>();
            for (int i = 1; i < years.length; i++) {
                xValues.add(Integer.valueOf(years[i]));
            }
            
            // the following lines hold election results per party
            while ((row = br.readLine()) != null) {
                 String[] partyValues = row.split("\t");
                 String partyName = partyValues[0];
                 
                 List<Double> yValues = new ArrayList<>();
                 for (int i = 1; i < partyValues.length; i++) {
                     if (partyValues[i].equals("-")) {
                         yValues.add(null);
                     } else {
                         yValues.add(Double.valueOf(partyValues[i]));
                     }                     
                 }
                 
                 // Add Data to a chart
                 XYChart.Series<Number, Number> partyData = new XYChart.Series();
                 partyData.setName(partyName);
                 
                 for (int i = 0; i < xValues.size(); i++) {
                     Integer x = xValues.get(i);
                     Double y = yValues.get(i);
                     
                     if (y != null) {
                         partyData.getData().add(new XYChart.Data(x, y));
                     }
                 }          
                 
                 // Add chart to LineChart
                 lineChart.getData().add(partyData);
            }           
        } catch (Exception e) {
            System.err.println("Error reading TSV file: " + e.getMessage());
            e.printStackTrace();
        }
        
        return lineChart;
    }
}
