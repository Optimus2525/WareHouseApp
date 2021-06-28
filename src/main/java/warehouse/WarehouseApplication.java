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
    public void start(Stage primaryStage) throws Exception {
        Parent rootScene = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("/userInterface/start.fxml")));
        primaryStage.setTitle("The Best Warehouse Application in The World");
        primaryStage.setScene(new Scene(rootScene));
        primaryStage.show();
    }

    public static void main(String[] args) {
        DataBaseSession.getInstance();
        launch(args);
        DataBaseSession.shutdown();
    }
}
