package main;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MainController {

    public static final int MAX_SIZE = 100;

    ArrayList<Points> pointsList = new ArrayList<>();

    ArrayList<XYChart.Series> charts = new ArrayList<>();

    @FXML
    public VBox itemsContainer;
    @FXML
    public Button btn;
    @FXML
    private AreaChart ac;
    private int i;

    @FXML
    public void initialize() {
        ac.setTitle("Общее название");

        charts.add(new XYChart.Series());
        charts.add(new XYChart.Series());
        charts.add(new XYChart.Series());

        addItem();

        ac.getData().addAll(charts);

        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> addItem());
    }

    private void addItem() {
        LayerItemPane pane = new LayerItemPane();
        Points p = new Points();
        pointsList.add(p);
        pane.setText1(p.v1);
        pane.setText2(p.v2);
        pane.setText3(p.v3);
        pane.setMinHeight(40);
        itemsContainer.getChildren().add(pane);
        charts.get(0).getData().add(new XYChart.Data(i, p.v1));
        charts.get(1).getData().add(new XYChart.Data(i, p.v2));
        charts.get(2).getData().add(new XYChart.Data(i, p.v3));
        i++;
    }

//    private XYChart.Series getRandomChartSeries(String value, int size) {
//        double koef = MAX_SIZE / size;
//        XYChart.Series chart1 = new XYChart.Series();
//        chart1.setName(value);
//        for (int y = 0; y <= size; y++) {
//            double x = Math.random();
//            System.out.println(x + " " + y);
//            chart1.getData().add(new XYChart.Data(koef * y, x));
//        }
//        return chart1;
//    }

    private class Points {
        double v1 = Math.random();
        double v2 = Math.random();
        double v3 = Math.random();
    }
}
