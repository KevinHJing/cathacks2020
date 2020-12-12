package controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class EnterNameController {

    @FXML private TextField nameField;

    @FXML
    private void changeToGame(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Enter Your Name");
        System.out.println(nameField.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/GameScreen.fxml"));
        Parent root = loader.load();

        GameScreenController gameScreenController = loader.getController();
        gameScreenController.setLabelText(nameField.getText());

        Scene scene = new Scene(root, 900, 650);
//        scene.getStylesheets().add(getClass().getResource("css/Game.css").toExternalForm());
        stage.setScene(scene);

    }
}
