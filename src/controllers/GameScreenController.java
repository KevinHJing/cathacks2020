package controllers;
import javafx.animation.FadeTransition;

import game.Character;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class GameScreenController implements Initializable {

    @FXML
    Label dialogue;
    @FXML 
        Label welcomeMessage;
    private Character character;
    
    public void setLabelText(String text){
        dialogue.setText("hey what's up " + text);
    }
  
    @FXML private Button option1;


    @FXML
    public void changeText(javafx.event.ActionEvent actionEvent) {
        dialogue.setText("it worked :)");
    }

    @FXML
    StackPane GameRoot;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameRoot.setOpacity(0);
        makeFadeInTransition();
    }

    private void makeFadeInTransition() {
        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(1000));
        fadeout.setNode(GameRoot);
        fadeout.setFromValue(0);
        fadeout.setToValue(1);
        fadeout.play();
    }

    @FXML
    public void imageClick(javafx.scene.input.MouseEvent mouseEvent) {
        dialogue.setText("You clicked the image!!!!!");
    }
}

