package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameScreenController{
    @FXML private Button option1;
    @FXML private Label dialogue;


    @FXML
    public void changeText(javafx.event.ActionEvent actionEvent) {
        dialogue.setText("it worked :)");
    }
}
