package warehouse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import warehouse.entities.Order;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Main controller initialized!!");
    }

    @FXML
    public AnchorPane root;

    @FXML
    private TableView<Order> table;

    @FXML
    public void handleButtonAction() {
        System.out.println("Show Customers");

    }

}