package warehouse.controllers.products;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import warehouse.entities.Customer;
import warehouse.entities.Product;
import warehouse.repository.ProductRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    private final ProductRepository productRepository = new ProductRepository();

    @FXML
    private TableView<Product> productsTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configureTable();
        populateTable();
    }

    private void configureTable() {
        TableColumn<Product, Integer> column1 = new TableColumn<>("Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Product, String> column2 = new TableColumn<>("Product Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, String> column3 = new TableColumn<>("Unit");
        column3.setCellValueFactory(new PropertyValueFactory<>("unit"));

        TableColumn<Product, String> column4 = new TableColumn<>("In Stock");
        column4.setCellValueFactory(new PropertyValueFactory<>("inStock"));

        TableColumn<Product, String> column5 = new TableColumn<>("Unit Price");
        column5.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        TableColumn<Product, String> column6 = new TableColumn<>("Supplier");
        column6.setCellValueFactory(new PropertyValueFactory<>("supplier"));

        productsTableView.getColumns().add(column1);
        productsTableView.getColumns().add(column2);
        productsTableView.getColumns().add(column3);
        productsTableView.getColumns().add(column4);
        productsTableView.getColumns().add(column5);
        productsTableView.getColumns().add(column6);
    }

    private void populateTable() {
        ObservableList<Product> list = FXCollections.observableArrayList();
        list.addAll(productRepository.findAll());
        productsTableView.setItems(list);
    }

}
