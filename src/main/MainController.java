package main;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
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
        ((NumberAxis) chart.getXAxis()).setLowerBound(Main.MIN_LAMBDA);
        chart.getData().add(series);

        series.setName("Y = R(λ)");
        for (int lambda = Main.MIN_LAMBDA; lambda < Main.MAX_LAMBDA; lambda++) {
            XYChart.Data point = new XYChart.Data(lambda, 1);
            series.getData().add(lambda - Main.MIN_LAMBDA, point);
        }
        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> addItem());
    }

    private void addItem() {
        LayerItemPane pane = new LayerItemPane(maxPosition, series.getData());
        pane.setMinHeight(40);
        itemsContainer.getChildren().add(pane);
        maxPosition++;
    }
}
