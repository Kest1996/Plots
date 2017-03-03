package main;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.math.BigDecimal;

public class LayerItemPane extends Pane {

    private final int position;
    private Node view;
    private LayerItemPaneController controller;
    private double ga;
    private double al;
    private int d;
    private ObservableList data;


    public LayerItemPane(int i, ObservableList data) {
        position = i;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layer_item.fxml"));
        fxmlLoader.setControllerFactory(param -> controller = new LayerItemPaneController());
        try {
            view = fxmlLoader.load();
        } catch (IOException ignored) {
        }
        getChildren().add(view);

        setDataSeries(data);
        setAl(LayerItemPaneController.alKoefs[controller.cbAl.getSelectionModel().getSelectedIndex()]);
        setD(controller.dTextField.getText());
        updateChartPoint();
    }

    private void setAl(Double alKoef) {
        al = alKoef;
        ga = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(al)).doubleValue();
        controller.labelGa.setText(String.valueOf(ga));
    }


    public void setDataSeries(ObservableList data) {
        this.data = data;
        controller.cbAl.valueProperty().addListener((observable, oldAl, newAl) -> {
            setAl((Double) newAl);
            updateChartPoint();
        });

        controller.dTextField.textProperty().addListener((observable, oldD, newD) -> {

            if (!newD.matches("\\d*")) {
                newD = newD.replaceAll("[^\\d]", "");
                controller.dTextField.setText(newD);
            }

            if (newD.length() > 3) {
                newD = newD.substring(0, 3);
                controller.dTextField.setText(newD);
            }

            setD(newD);
            updateChartPoint();
        });
    }

    private void setD(String newD) {
        if (newD != null && !newD.isEmpty()) {
            d = Integer.valueOf(newD);
        }
    }

    private void updateChartPoint() {
        XYChart.Data point = new XYChart.Data(position, getFunctionResult());
        if (position >= data.size()) {
            data.add(position, point);
        } else {
            data.set(position, point);
        }
    }

    private double getFunctionResult() {
        return d * al * ga;
    }
}
