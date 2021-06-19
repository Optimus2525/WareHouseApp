package warehouse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class old_MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Main controller initialized!!");
    }

    @FXML
    private BorderPane content;

    @FXML
    public void switchCustomerPanel(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load((Objects
                .requireNonNull(getClass()
                .getResource("/userInterface/customer/old_customer_list.fxml"))));
        content.setLeft(pane);
    }

    @FXML
    public void switchProductPanel(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load((Objects
                .requireNonNull(getClass()
                .getResource("/userInterface/customer/product_list.fxml"))));
        content.setLeft(pane);
    }
    @FXML
    public void switchSupplierPanel(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load((Objects
                .requireNonNull(getClass()
                .getResource("/userInterface/customer/supplier_list.fxml"))));
        content.setLeft(pane);

 }
    @FXML
    public void switchOrderPanel(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load((Objects
                .requireNonNull(getClass()
                .getResource("/userInterface/customer/order_list.fxml"))));
        content.setLeft(pane);
    }

}
