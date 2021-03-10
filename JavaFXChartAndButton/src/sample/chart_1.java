package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.List;

public class chart_1 extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("The digits in my student ID");
        //defining the axes
        var xAxis = new NumberAxis();
        var yAxis = new NumberAxis();
        xAxis.setLabel("# of digits in my student ID");
        yAxis.setLabel("Digit Value");
        //creating the chart
        var lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        List<XYChart.Data<Number, Number>> data = List.of(
                new XYChart.Data<>(1, 2),
                new XYChart.Data<>(2, 1),
                new XYChart.Data<>(3, 6),
                new XYChart.Data<>(4, 1),
                new XYChart.Data<>(5, 5),
                new XYChart.Data<>(6, 1),
                new XYChart.Data<>(7, 2),
                new XYChart.Data<>(8, 6),
                new XYChart.Data<>(9, 9)
        );
        lineChart.setTitle("My Student ID is 216151268");
        //defining a series
        var series = new XYChart.Series<>("The digits in my student ID", FXCollections.observableList(data));
lineChart.setData(FXCollections.singletonObservableList(series));
        var scene  = new Scene(lineChart,800,600);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
