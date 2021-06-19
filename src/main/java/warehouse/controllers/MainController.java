package warehouse.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;
import warehouse.controllers.customers.AddCustomerController;
import warehouse.controllers.view.ViewLoader;
import warehouse.entities.Customer;
import warehouse.entities.Order;
import warehouse.repository.OrderRepository;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    OrderRepository orderRepository = new OrderRepository();

    @FXML
    public AnchorPane apRoot;
    @FXML
    private TableColumn<Order, Integer> colId;
    @FXML
    private TableColumn<Order, Customer> colCustomer;
    @FXML
    private TableColumn<Order, Date> colDate;
    @FXML
    private TableColumn<Order, Double> colTotal;
    @FXML
    private TableColumn<Order, Boolean> colIsPaid;

    @FXML
    private TableView<Order> tblOrders;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Main controller initialized!!");
        configureTable();
        populateTable();
    }

    private void configureTable() {
        colId.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        colCustomer.setCellValueFactory(new PropertyValueFactory<Order, Customer>("customers"));
        colDate.setCellValueFactory(new PropertyValueFactory<Order, Date>("orderDate"));
        colTotal.setCellValueFactory(new PropertyValueFactory<Order, Double>("totalSum"));
        colIsPaid.setCellValueFactory(new PropertyValueFactory<Order, Boolean>("isPaid"));
    }

    private void populateTable() {
        ObservableList<Order> list = FXCollections.observableArrayList();
        list.addAll(orderRepository.findAll());
        tblOrders.setItems(list);
    }

    @FXML
    public void addOrder(ActionEvent event) {
        AddCustomerController controller = (AddCustomerController) ViewLoader
                .load(getClass().getResource("/userInterface/customer/add_customer.fxml"), "Add Customer");
        controller.addPostOperationCallback(this::populateTable);
    }
    @FXML
    public void addCustomer(ActionEvent event) {
        System.out.println("Add Customer");
    }
    @FXML
    public void addSupplier(ActionEvent event) {
        System.out.println("Add Supplier");
    }
    @FXML
    public void addProduct(ActionEvent event) {
        System.out.println("Add Product");
    }
    @FXML
    public void addUnit(ActionEvent event) {
        System.out.println("Add Unit");
    }
    @FXML
    public void exitProgram(ActionEvent event) {
        System.out.println("Exit Program");
    }

}