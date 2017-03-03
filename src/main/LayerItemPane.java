package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LayerItemPane extends Pane {

    private Node view;
    private LayerItemPaneController controller;

    public LayerItemPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layer_item.fxml"));
        fxmlLoader.setControllerFactory(param -> controller = new LayerItemPaneController());
        try {
            view = fxmlLoader.load();
        } catch (IOException ignored) {
        }
        getChildren().add(view);
    }

    public void setText1(double str) {
        controller.tf1.setText(String.valueOf(str));
    }
    public String getText1() {
        return controller.tf1.getText();
    }
    public void setText2(double str) {
        controller.tf2.setText(String.valueOf(str));
    }
    public String getText2() {
        return controller.tf2.getText();
    }
    public void setText3(double str) {
        controller.tf3.setText(String.valueOf(str));
    }
}
