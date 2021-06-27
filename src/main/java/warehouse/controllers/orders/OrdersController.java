package warehouse.controllers.orders;

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
import warehouse.controllers.products.ProductsController;
import warehouse.controllers.suppliers.SuppliersController;
import warehouse.controllers.view.ViewLoader;
import warehouse.entities.Customer;
import warehouse.entities.Order;
import warehouse.repository.OrderRepository;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class OrdersController implements Initializable {

    private final OrderRepository<Order> orderRepository = new OrderRepository<>();

    @FXML
    public AnchorPane ordersRoot;
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

    // TODO: Need to add AddOrderController to Controllers
//    @FXML
//    public void addOrder(ActionEvent event) {
//        AddOrderController controller = (AddOrderController) ViewLoader
//                .load(getClass().getResource("/userInterface/customers/add_order.fxml"), "Add New Order");
//        controller.addPostOperationCallback(this::populateTable);
//    }

    //TODO: Need to change button action methods names
    @FXML
    public void viewCustomer(ActionEvent event) {
        System.out.println("Add Customer");
    }

    @FXML
    public void viewSupplier(ActionEvent event) {
        SuppliersController controller = (SuppliersController) ViewLoader
                .load(getClass()
                        .getResource("/userInterface/suppliers/suppliers.fxml"), "Suppliers List");
    }

    @FXML
    public void viewProducts(ActionEvent event) {
        ProductsController controller = (ProductsController) ViewLoader
                .load(getClass()
                        .getResource("/userInterface/products/products.fxml"), "Products list");
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
// TODO: Must be inspected and corrected
//        private void populateTable() {
//            ObservableList<OrderInfo> list = FXCollections.observableArrayList();
//            for(Order order : orderRepository.findAll()){
//                System.out.println(order);
//                //Order{ id, ,,, Customer {id, name, ,,,} }
//                OrderInfo orderInfo = new OrderInfo();
//                //OrderInfo { int id, String number, String customerName}
//                orderInfo.setId(order.getId());
//                orderInfo.setNumber(order.getNumber());
//                orderInfo.setCustomerName(order.getCustomer().getName());
//                list.add(orderInfo);
//            }
//            table.setItems(list);
//        }