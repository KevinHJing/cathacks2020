package controllers;
import javafx.animation.FadeTransition;
import game.*;

import game.Character;
import game.Dialog;
import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

import java.awt.*;
import java.io.IOException;
    public class GameScreenController implements Initializable {
        @FXML
        Label dialogue;
        @FXML
        Label welcomeMessage;
        private Character character;
        @FXML
        Button option1;
        @FXML
        Button option2;
        @FXML
        StackPane GameRoot;

        public void setLabelText(String text) {
            dialogue.setText("hey what's up " + text);
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            GameRoot.setOpacity(0);
            makeFadeInTransition();
            Dialog d1 = new Dialog("hey what's up! how are you doing today!", "good :)", "not good :(");
            dialogue.setText(d1.getOutput());
            option1.setText(d1.getButtonText1());
            option2.setText(d1.getButtonText2());
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
        public void changeDialogOption1(javafx.event.ActionEvent actionEvent) {
            if (dialogue.getText().contains("! how are you doing today!")) {
                Dialog d2 = new Dialog("That's great to hear!", "Who are you?", "What's up with you?");
                dialogue.setText(d2.getOutput());
                option1.setText(d2.getButtonText1());
                option2.setText(d2.getButtonText2());
            } else if (dialogue.getText().equals("I'm one of Santa's elves! I am actually running behind on present deliveries. \nCould you help me out?")) {
                Dialog d2 = new Dialog("Thank you so much! Follow me to the town I'm delivering presents in!", "Ok!", "Coming!");
                dialogue.setText(d2.getOutput());
                option1.setText(d2.getButtonText1());
                option2.setText(d2.getButtonText2());
            } else if (dialogue.getText().equals("Thank you so much! Follow me to the town I'm delivering presents in!")) {
                //Change Screens
            } else {
                Dialog d2 = new Dialog("I'm one of Santa's elves! I am actually running behind on present deliveries. \nCould you help me out?", "Of course!", "Sure...");
                dialogue.setText(d2.getOutput());
                option1.setText(d2.getButtonText1());
                option2.setText(d2.getButtonText2());
            }
        }

        @FXML
        public void changeDialogOption2(javafx.event.ActionEvent actionEvent) {
            if (dialogue.getText().contains("! how are you doing today!")) {
                Dialog d2 = new Dialog("I'm sorry, I hope you feel better :(", "Who are you?", "What's up with you?");
                dialogue.setText(d2.getOutput());
                option1.setText(d2.getButtonText1());
                option2.setText(d2.getButtonText2());
            } else if (dialogue.getText().equals("I'm one of Santa's elves! I am actually running behind on present deliveries. \nCould you help me out?")) {
                Dialog d2 = new Dialog("Thank you so much! Follow me to the town I'm delivering presents in!", "Ok!", "Coming!");
                dialogue.setText(d2.getOutput());
                option1.setText(d2.getButtonText1());
                option2.setText(d2.getButtonText2());
            } else if (dialogue.getText().equals("Thank you so much! Follow me to the town I'm delivering presents in!")) {
                //Change Screens
            } else {
                Dialog d2 = new Dialog("I'm one of Santa's elves! I am actually running behind on present deliveries. \nCould you help me out?", "Of course!", "Sure...");
                dialogue.setText(d2.getOutput());
                option1.setText(d2.getButtonText1());
                option2.setText(d2.getButtonText2());
            }
        }

        public void imageClick(javafx.scene.input.MouseEvent mouseEvent) {
            dialogue.setText("You clicked the image!!!!!");
        }
    }