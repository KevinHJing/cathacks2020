package controllers;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import java.awt.*;
import java.io.IOException;

public class GameScreenController implements Initializable{

    @FXML
    Label dialogue;

    @FXML
    StackPane GameRoot;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameRoot.setOpacity(0);
        makeFadeInTrasition();
    }

    private void makeFadeInTrasition() {
        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(1000));
        fadeout.setNode(GameRoot);
        fadeout.setFromValue(0);
        fadeout.setToValue(1);
        fadeout.play();
    }


    public void setLabelText(String text){
        dialogue.setText("hey what's up " + text);
    }
  
    @FXML private Button option1;


    @FXML
    public void changeText(javafx.event.ActionEvent actionEvent) {
        dialogue.setText("it worked :)");
    }
}
