package main;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainController {


    @FXML
    public VBox itemsContainer;
    @FXML
    public Button btn;
    @FXML
    public AnchorPane chartPane;
    private int maxPosition;

    @FXML
    public void initialize() {
        final NumberAxis xAxis = new NumberAxis(Data.MIN_LAMBDA, Data.MAX_LAMBDA, 10);
        final NumberAxis yAxis = new NumberAxis();
        AreaChart chart = new AreaChart<>(xAxis, yAxis);
        XYChart.Series series = Data.getInstance().series;
        chart.getData().add(series);
        chart.setAnimated(false);
        chart.setMinSize(2000, -1);
        chartPane.getChildren().add(chart);
        AnchorPane.setBottomAnchor(chart, 5.0);
        AnchorPane.setTopAnchor(chart, 5.0);
        AnchorPane.setLeftAnchor(chart, 5.0);
        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> addItem());
    }

    private void addItem() {
        LayerItemPane pane = new LayerItemPane(maxPosition);
        pane.setMinHeight(40);
        itemsContainer.getChildren().add(pane);
        maxPosition++;
    }
}
