package warehouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import warehouse.configuration.DataBaseSession;

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
        launch(args);
        DataBaseSession.shutdown();
    }


}
