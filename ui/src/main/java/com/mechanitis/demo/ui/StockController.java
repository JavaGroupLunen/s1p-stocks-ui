package com.mechanitis.demo.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import org.springframework.stereotype.Component;

import static javafx.collections.FXCollections.observableArrayList;

@Component
public class StockController {

    @FXML
    private LineChart<String, Number> chart;

    //this is the controller, and what it does is wires stuff together
    @FXML
    public void initialize() {
        //series is the UI (View) element
        final XYChart.Series<String, Number> series = new XYChart.Series<>();
        //needs to be wired in to the data (Model)
        series.setData(new StockPrice().getData());

        //a chart supports more than one series of data, so the data for the chart is a list of series
        //but we only have one element in this list, our single series
        ObservableList<XYChart.Series<String, Number>> allSeriesForChart = observableArrayList(series);
        chart.setData(allSeriesForChart);


    }

    private class StockPrice {
        public ObservableList<XYChart.Data<String, Number>> getData() {
            return FXCollections.observableArrayList();
        }
    }
}
