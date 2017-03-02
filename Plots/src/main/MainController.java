package main;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainController {

    public static final int MAX_SIZE = 100;

    @FXML
    public VBox itemsContainer;
    @FXML
    public Button btn;
    @FXML
    private AreaChart ac;

    @FXML
    public void initialize() {
        ac.setTitle("Общее название");
        addItem();
        XYChart.Series chart1 = getRandomChartSeries("График 1", MAX_SIZE);
        XYChart.Series chart2 = getRandomChartSeries("График 2", 20);
        XYChart.Series chart3 = getRandomChartSeries("График 3", 5);
        ac.getData().addAll(chart1, chart2, chart3);

        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> addItem());
    }

    private void addItem() {
        LayerItemPane pane = new LayerItemPane();
        double v1 = Math.random();
        double v2 = Math.random();
        double v3 = Math.random();
        pane.setText1(v1);
        pane.setText2(v2);
        pane.setText3(v3);
        pane.setMinHeight(40);
        itemsContainer.getChildren().add(pane);
    }

    private XYChart.Series getRandomChartSeries(String value, int size) {
        double koef = MAX_SIZE / size;
        XYChart.Series chart1 = new XYChart.Series();
        chart1.setName(value);
        for (int y = 0; y <= size; y++) {
            double x = Math.random();
            System.out.println(x + " " + y);
            chart1.getData().add(new XYChart.Data(koef * y, x));
        }
        return chart1;
    }
}
