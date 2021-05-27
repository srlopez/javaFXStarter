package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    void cmdHello_click(ActionEvent event) {
        System.out.println("Hello "+ txtName.getText() );
    }

    @FXML
    void initialize() {

    }
}
