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

import java.awt.*;
import java.io.IOException;

public class MainScreenController {

    @FXML
    private void changeToEnterName(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Enter Your Name");
        Parent root = FXMLLoader.load(getClass().getResource("fxml/EnterNameScreen.fxml"));
        Scene scene = new Scene(root, 640, 400);
        scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("css/EnterName.css").toExternalForm());
        stage.setScene(scene);

    }


}
