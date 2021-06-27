package warehouse.controllers.suppliers;

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
import warehouse.entities.Supplier;
import warehouse.repository.SupplierRepository;
import java.net.URL;
import java.util.ResourceBundle;

public class SuppliersController implements Initializable {

    private final SupplierRepository supplierRepository = new SupplierRepository();

    @FXML
    public AnchorPane apSuppliers;
    @FXML
    public TableView<Supplier> tblSuppliers;

    @FXML
    private TableColumn<Supplier, Integer> colId;
    @FXML
    private TableColumn<Supplier, String> colSupplierName;
    @FXML
    private TableColumn<Supplier, String> colAddress;
    @FXML
    private TableColumn<Supplier, String> colPhone;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Suppliers controller initialized!!");
        configureTable();
        populateTable();
    }

    private void configureTable() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    private void populateTable() {
        ObservableList<Supplier> list = FXCollections.observableArrayList();
        list.addAll(supplierRepository.findAll());
        tblSuppliers.setItems(list);
    }

    @FXML
    public Button btnExitScene;
    @FXML
    public void exitScene(ActionEvent event) {
        Stage stage = (Stage) btnExitScene.getScene().getWindow();
        stage.close();
    }

    @FXML
    public Button btnAddSupplier;
    @FXML
    public void addSupplier(ActionEvent event) {
        System.out.println("Add Supplier");
    }

    @FXML
    public Button btnEditSupplier;
    @FXML
    public void editSupplier(ActionEvent event) {
        System.out.println("Edit Supplier");
    }

    @FXML
    public Button btnDeleteSupplier;
    @FXML
    public void deleteSupplier(ActionEvent event) {
        System.out.println("Delete Supplier");
    }

}
