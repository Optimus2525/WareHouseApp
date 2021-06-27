package warehouse.controllers.products;

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
import warehouse.entities.*;
import warehouse.repository.ProductRepository;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    private final ProductRepository productRepository = new ProductRepository();

    @FXML
    public AnchorPane apProducts;
    @FXML
    private TableView<Product> tblProducts;

    @FXML
    private TableColumn<Product, Integer> colId;
    @FXML
    private TableColumn<Product, String> colProductName;
    @FXML
    private TableColumn<Product, Unit> colUnit;
    @FXML
    private TableColumn<Product, Integer> colInStock;
    @FXML
    private TableColumn<Product, Double> colUnitPrice;
    @FXML
    private TableColumn<Product, Supplier> colSupplier;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Products controller initialized!!");
        configureTable();
        populateTable();
    }

    private void configureTable(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUnit.setCellValueFactory(new PropertyValueFactory<>("units"));
        colInStock.setCellValueFactory(new PropertyValueFactory<>("unitsInStock"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colSupplier.setCellValueFactory(new PropertyValueFactory<>("suppliers"));
    }

    private void populateTable() {
        ObservableList<Product> list = FXCollections.observableArrayList();
        list.addAll(productRepository.findAll());
        tblProducts.setItems(list);
    }

    @FXML
    public Button btnExitScene;
    @FXML
    public void exitScene(ActionEvent event) {
        Stage stage = (Stage) btnExitScene.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void editProduct(ActionEvent event) {
        System.out.println("Edit Product");
    }
    @FXML
    public void addProduct(ActionEvent event) {
        System.out.println("Add Product");
    }
    @FXML
    public void deleteProduct(ActionEvent event) {
        System.out.println("Delete Product");
    }


}
