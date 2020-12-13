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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.awt.*;
import java.io.IOException;
    public class GameScreenController implements Initializable {
        @FXML Label dialogue;
        @FXML Label welcomeMessage;
        @FXML Button option1;
        @FXML Button option2;
        @FXML StackPane GameRoot;

        private Character character;
        ArrayList<Dialog> dialogslist = new ArrayList<Dialog>();
        private int dialogNum = 0;

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            GameRoot.setOpacity(0);
            makeFadeInTransition();
            dialogue.setFont(new Font("Lucida Console", 20));
            option1.setFont(new Font("Segoe UI", 17));
            option2.setFont(new Font("Segoe UI", 17));
            Dialog d1 = new Dialog(
                    "Bowman: Nah, don’t be silly. It’s just me,\n" +
                            "Bowman the wildcat. I’m here to wish you a\n" +
                            "happy holidays! Well, I couldn’t visit you in\n" +
                            "person, but I thought I’d drop by your dream\n" +
                            "to say hi.\n",
                    "That’s… unconventional.",
                    "Happy holidays to you too...?");
            Dialog d2 = new Dialog(
                    "Bowman: Dang, not even a warm welcome? It would\n" +
                            "make me feel a lot better about giving you this\n" +
                            "job.",
                    "Job?",
                    null);
            Dialog d3 = new Dialog(
                    "Bowman: Well…. I had all these presents to give\n" +
                            "to everyone, but I don’t have the time to give\n" +
                            "them out. So… could you do me a little favor?",
                    "Sure thing, pal.",
                    "Do I have a choice?");
            Dialog d4 = new Dialog(
                    "That’s the spirit! When you wake up, you’ll see\n" +
                            "the presents in your room. Go travel into town\n" +
                            "to find Moodolph the Reindeer, Iceberg the\n" +
                            "Penguin, and [Name] the snowman. Just talk to\n" +
                            "them to give them a present!",
                    "Wait, I don’t get one?",
                    null);
            Dialog d5 = new Dialog(
                    "Bowman: Oops, I guess I missed you on the list!\n" +
                            "Sorry bud. Anyways, gotta be going now!.",
                    "Wait a minute!",
                    "(wake up)");
            setDialogValues(d1);
            dialogslist.add(d2);
            dialogslist.add(d3);
            dialogslist.add(d4);
            dialogslist.add(d5);
        }

        private void setDialogValues(Dialog d) {
            dialogue.setText(d.getOutput());
            option1.setText(d.getButtonText1());
            if (d.getButtonText2() == null) {
                option2.setVisible(false);
            } else {
                option2.setVisible(true);
                option2.setText(d.getButtonText2());
            }
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
            if (dialogNum >= dialogslist.size()) {
                System.out.println("done");
            } else {
                setDialogValues(dialogslist.get(dialogNum));
                dialogNum++;
            }
        }

        @FXML
        public void changeBackground() {

        }

        @FXML
        public void changeDialogOption2(javafx.event.ActionEvent actionEvent) {
            if (dialogNum >= dialogslist.size()) {
                System.out.println("done");
            } else {
                setDialogValues(dialogslist.get(dialogNum));
                dialogNum++;
            }
        }

        public void imageClick(javafx.scene.input.MouseEvent mouseEvent) {
            dialogue.setText("You clicked the image!!!!!");
        }
    }