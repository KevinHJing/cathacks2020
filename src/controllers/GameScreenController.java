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
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import java.awt.*;
import java.io.IOException;

public class GameScreenController {

    @FXML Label dialogue;

    public void setLabelText(String text){
        dialogue.setText("hey what's up " + text);
    }
  
    @FXML private Button option1;


    @FXML
    public void changeText(javafx.event.ActionEvent actionEvent) {
        dialogue.setText("it worked :)");
    }
}
