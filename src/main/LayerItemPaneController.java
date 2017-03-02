package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LayerItemPaneController implements Initializable {


    @FXML
    public HBox container;
    @FXML
    public TextField tf1;
    @FXML
    public TextField tf2;
    @FXML
    public TextField tf3;

    @FXML
    public Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText("слой");
    }
}
