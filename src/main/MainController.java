package main;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class MainController {


    @FXML
    public VBox itemsContainer;
    @FXML
    public Button btn;
    @FXML
    private AreaChart chart;
    private int maxPosition;
    private XYChart.Series series = new XYChart.Series();

    @FXML
    public void initialize() {
        chart.getData().add(series);

        series.setName("Y = R(λ)");

        addItem();
        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> addItem());
    }

    private void addItem() {
        LayerItemPane pane = new LayerItemPane(maxPosition, series.getData());
        pane.setMinHeight(40);
        itemsContainer.getChildren().add(pane);
        maxPosition++;
    }
}
