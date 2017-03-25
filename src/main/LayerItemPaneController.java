package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LayerItemPaneController implements Initializable {

    @FXML
    public HBox container;
    @FXML
    public TextField dTextField;
    @FXML
    public Label labelGa;
    public Label labelD;
    public Label labelAl;
    public static final Double alKoefs[] = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};
    public ChoiceBox cbAl;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbAl.getItems().addAll(alKoefs);
        cbAl.getSelectionModel().select(0);
    }
}
