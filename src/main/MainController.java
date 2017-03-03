package main;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MainController {

    private ArrayList<Points> pointsList = new ArrayList<>();

    @FXML
    public VBox itemsContainer;
    @FXML
    public Button btn;
    @FXML
    private AreaChart chart;
    private double d;
    private int i;
    private XYChart.Series series = new XYChart.Series();

    @FXML
    public void initialize() {
        chart.getData().add(series);

//        Node line = chart.lookup(".default-color0.series-series-area-line");
//        line.setStyle("-fx-stroke: #26a9e3; ");
//        Node area = chart.lookup(".default-color0.series-series-area-fill");
//        area.setStyle("-fx-fill: rgba(38,169,227,0.21); ");

        series.setName("Y = R(λ)");

        addItem();
        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> addItem());
    }

    private void addItem() {
        LayerItemPane pane = new LayerItemPane();
        Points p = new Points();
        pointsList.add(p);
        pane.setText1(p.v1);
        d = Double.valueOf(pane.getText1());
        System.out.println(d);
//        pane.setText2(p.v2);
//        pane.setText3(p.v3);
        pane.setMinHeight(40);
        itemsContainer.getChildren().add(pane);
        series.getData().add(new XYChart.Data((float) i / 2f, getFunctionResult(p)));
        i++;
    }

    private double getFunctionResult(Points p) {
        return p.v1;
    }

    private class Points {
        double v1 = Math.random();
    }
}
