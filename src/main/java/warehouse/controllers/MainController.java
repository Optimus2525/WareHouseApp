package warehouse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Main controller initialized!!");
    }


    @FXML
    private BorderPane content;

    @FXML
    public void switchPanel(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/userInterface/main.fxml")));
        content.setLeft(pane);
    }

}
