package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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


    public LayerItemPane(int i) {
        position = i;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layer_item.fxml"));
        fxmlLoader.setControllerFactory(param -> controller = new LayerItemPaneController());
        try {
            view = fxmlLoader.load();
        } catch (IOException ignored) {
        }
        getChildren().add(view);

        controller.cbAl.valueProperty().addListener((observable, oldAl, newAl) -> {
            setAl((Double) newAl);
            updateKoefs();
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
            updateKoefs();
        });

        int positionAl = controller.cbAl.getSelectionModel().getSelectedIndex();
        setAl(LayerItemPaneController.alKoefs[positionAl]);
        setD(controller.dTextField.getText());
        updateKoefs();
    }

    public void updateKoefs() {
        Data.getInstance().setKoefs(position, al, ga, d);
    }

    private void setAl(Double alKoef) {
        al = alKoef;
        ga = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(al)).doubleValue();
        controller.labelGa.setText(String.valueOf(ga));
    }

    private void setD(String newD) {
        if (newD != null && !newD.isEmpty()) {
            d = Integer.valueOf(newD);
        }
    }
}
