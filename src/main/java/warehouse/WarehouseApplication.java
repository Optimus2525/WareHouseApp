package warehouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import warehouse.configuration.DataBaseSession;
import warehouse.entities.Customer;
import warehouse.repository.CustomerRepository;

public class WarehouseApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootScene = FXMLLoader.load(getClass().getResource("/userInterface/main.fxml"));
        stage.setTitle("Warehouse");
        stage.setScene(new Scene(rootScene));
        stage.show();
    }

    public static void main(String[] args) {
        DataBaseSession.getInstance();
        Customer customer = new Customer();
        customer.setAddress("Lauvas iela");
        customer.setName("Laima");
        customer.setPhone("+37123455667");
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.save(customer);
//        launch(args);
        DataBaseSession.shutdown();

    }


}
