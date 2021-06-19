package warehouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import warehouse.configuration.DataBaseSession;

import java.util.Objects;

public class WarehouseApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects
                .requireNonNull(getClass()
                        .getResource("/userInterface/main.fxml")));

        stage.setTitle("No Doubt - I'm The Best Warehouse Application in The World ");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        // TODO - remove comments
        DataBaseSession.getInstance();
        launch(args);
        DataBaseSession.shutdown();

    }


}
