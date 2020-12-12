package controllers;

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
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import java.awt.*;
import java.io.IOException;

public class GameScreenController {
    @FXML Label welcomeMessage;
    private Character character;
    @FXML Label dialogue;
    @FXML Button option1;
    @FXML Button option2;

    public void setLabelText(String text){
        Dialog d1 = new Dialog("hey what's up " + text + "! how are you doing today!", "good :)", "not good :(");
        dialogue.setText(d1.getOutput());
        option1.setText(d1.getButtonText1());
        option2.setText(d1.getButtonText2());
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
}
