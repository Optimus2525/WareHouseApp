package warehouse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import warehouse.controllers.products.ProductsController;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Warehouse Application Main controller initialized!");
    }

    @FXML
    public void showAllOrders(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/orders/orders.fxml"));
        content.setCenter(pane);
    }
    @FXML
    public void addNewOrder(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/orders/addNewOrder.fxml"));
        content.setCenter(pane);
    }

    @FXML
    public void showAllCustomers(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/customers/customers.fxml"));
        content.setCenter(pane);
    }
    @FXML
    public void addNewCustomer(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/customers/addNewCustomer.fxml"));
        content.setCenter(pane);
    }

    public void showAllProducts(ActionEvent event) throws Exception {
        ProductsController productsController = new ProductsController();
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/products/products.fxml"));
        content.setCenter(pane);
    }
    @FXML
    public void addNewProduct(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/products/addNewProduct.fxml"));
        content.setCenter(pane);
    }

    public void showAllSuppliers(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/suppliers/suppliers.fxml"));
        content.setCenter(pane);
    }
    @FXML
    public void addNewSupplier(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/suppliers/addNewSupplier.fxml"));
        content.setCenter(pane);
    }

    public void showAllUnits(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/units/units.fxml"));
        content.setCenter(pane);
    }
    @FXML
    public void addNewUnit(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/userInterface/units/addNewUnit.fxml"));
        content.setCenter(pane);
    }

    @FXML
    public void exitProgram(ActionEvent event) throws Exception {
        System.out.println("Exiting Program");
    }

}
