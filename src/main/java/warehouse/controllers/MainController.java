package warehouse.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import warehouse.controllers.customers.AddCustomerController;
import warehouse.controllers.view.ViewLoader;
import warehouse.entities.Customer;
import warehouse.entities.Order;
import warehouse.repository.OrderRepository;

import java.net.URL;
import java.util.Date;
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
    public Button btnExit;

    @FXML
    private TableView<Order> tblOrders;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Main controller initialized!!");
        configureTable();
        populateTable();
    }

    private void configureTable() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustomer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalSum"));
        colIsPaid.setCellValueFactory(new PropertyValueFactory<>("isPaid"));
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

    //TODO: Need to change button action methods names
    @FXML
    public void addCustomer(ActionEvent event) {
        System.out.println("Add Customer");
    }
    @FXML
    public void addSupplier(ActionEvent event) {
        System.out.println("Add Supplier");
    }
    @FXML
    public void viewProducts(ActionEvent event) {
        System.out.println("View Products");
    }
    @FXML
    public void addUnit(ActionEvent event) {
        System.out.println("Add Unit");
    }
    @FXML
    public void exitProgram(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

}