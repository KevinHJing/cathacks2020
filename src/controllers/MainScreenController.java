package controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {

    @FXML
    private void changeToGame(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Game");
        Parent root = FXMLLoader.load(getClass().getResource("fxml/GameScreen.fxml"));
        Scene scene = new Scene(root, 640, 400);
        stage.setScene(scene);

    }


}
