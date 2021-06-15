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
//        Parent rootScene = FXMLLoader
//                .load(Objects.
//                        requireNonNull(getClass()
//                                .getResource("/userInterface/main.fxml")));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/userInterface/main.fxml"));
        Parent rootScene = fxmlLoader.load();
        stage.setTitle("The Best Warehouse Application in The World ");
        stage.setScene(new Scene(rootScene));
        stage.show();
    }


    public static void main(String[] args) {
        DataBaseSession.getInstance();
        launch(args);
        DataBaseSession.shutdown();

    }


}
