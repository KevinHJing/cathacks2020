package controllers;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.util.Stack;

public class EnterNameController {

    @FXML private TextField nameField;
    @FXML private StackPane mainbox;

    @FXML
    private void changeToGame(ActionEvent event) throws IOException {
        makeFadeOut();

    }

    private void loadNextScene() throws IOException{

        Parent secondView;
        secondView = (AnchorPane) FXMLLoader.load(getClass().getResource("fxml/OverworldScreen.fxml"));
        Scene scene = new Scene(secondView, 900, 650);
        scene.getStylesheets().add(getClass().getResource("css/Overworld.css").toExternalForm());
        Stage curr = (Stage) mainbox.getScene().getWindow();
        curr.setTitle("Overworld");
        curr.setScene(scene);

        /*
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Enter Your Name");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/GameScreen.fxml"));
        Parent root = loader.load();

        GameScreenController gameScreenController = loader.getController();
        gameScreenController.setLabelText(nameField.getText());

        Scene scene = new Scene(root, 900, 650);
        scene.getStylesheets().add(getClass().getResource("css/game.css").toExternalForm());
        stage.setScene(scene); */
    }

    private void makeFadeOut() {
        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(1000));
        fadeout.setNode(mainbox);
        fadeout.setFromValue(1);
        fadeout.setToValue(0);
        fadeout.setOnFinished((ActionEvent actionEvent) -> {
            try {
                loadNextScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fadeout.play();
    }


}
