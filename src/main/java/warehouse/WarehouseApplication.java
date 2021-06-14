package warehouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.type.TrueFalseType;
import warehouse.configuration.DataBaseSession;

import java.util.Objects;


public class WarehouseApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/userInterface/main.fxml")));
        stage.setTitle("The Best Warehouse of The World ");
        stage.setScene(new Scene(rootScene));

//        Additional options for primary Stage
//        stage.setX(50);
//        stage.setY(50);
//        stage.setWidth(600);
//        stage.setHeight(400);
//        stage.initStyle(StageStyle.DECORATED);
//        stage.setFullScreen(true);

        stage.show();
    }


    public static void main(String[] args) {
        DataBaseSession.getInstance();
        launch(args);
        DataBaseSession.shutdown();

    }


}
