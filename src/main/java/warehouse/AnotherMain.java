package warehouse;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import warehouse.configuration.DataBaseSession;

public class AnotherMain extends Application {

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title Of The Window");
        window = primaryStage;

        Label label1 = new Label("This is the first scene");
        Button button1 = new Button("Take me to the Scene 2");
        button1.setOnAction(actionEvent -> {
            window.setScene(scene2);
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1,300, 300);

        Label label2 = new Label("This is the second scene");
        Button button2 = new Button("Take me to the Scene 1");
        button2.setOnAction(actionEvent -> {
            window.setScene(scene1);
        });

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 300, 300);

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //DataBaseSession.getInstance();
        launch(args);
        //DataBaseSession.shutdown();
    }

}

