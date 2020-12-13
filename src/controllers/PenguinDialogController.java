package controllers;
import javafx.animation.FadeTransition;
import game.*;

import game.Character;
import game.Dialog;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.io.IOException;
public class PenguinDialogController implements Initializable {
    @FXML Label dialogue;
    @FXML Label welcomeMessage;
    @FXML Button option1;
    @FXML Button option2;
    @FXML Button option3;
    @FXML StackPane GameRoot;
    @FXML ImageView imageView;

    private Character character;
    ArrayList<Dialog> dialogslist = new ArrayList<Dialog>();
    private int dialogNum = 0;
    String playerName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameRoot.setOpacity(0);
        makeFadeInTransition();
        dialogue.setFont(new Font("Lucida Console", 20));
        option1.setFont(new Font("Segoe UI", 17));
        option2.setFont(new Font("Segoe UI", 17));
        Dialog d1 = new Dialog(
                "Iceberg: Heya, " + EnterNameController.playerName + "!",
                "How're you doing, Iceberg?",
                "Heya.");
        Dialog d2 = new Dialog(
                "Iceberg: Guess what? I got to go skiing with\n" +
                        "all my friends today! It was a lot of fun!",
                "Penguins can ski?",
                null);
        Dialog d3 = new Dialog(
                "Iceberg: Of course! Some of my cousins cheated \n" +
                        "though. They slid down the hill on their bellies.",
                "Sounds like fun.",
                "Isn't that dangerous?");
        Dialog d4 = new Dialog(
                "Iceberg: Yeah. Mom says we have to go home now.\n",
                "Before you go, I have a \npresent for you.",
                "Bowman got you a present.");
        Dialog d5 = new Dialog(
                "Iceberg: Woah! What is it?",
                "(Give Iceberg her present)",
                null);
        Dialog d6 = new Dialog(
                "Iceberg: WOW! It’s a new set of skis. \n" +
                        "Now I’m going to be the fastest one \n" +
                        "racing down the mountainside!",
                "Make sure to be careful.",
                "Have a good time.");
        setDialogValues(d1);
        dialogslist.add(d2);
        dialogslist.add(d3);
        dialogslist.add(d4);
        dialogslist.add(d5);
        dialogslist.add(d6);
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
        fadeout.setDuration(Duration.millis(2000));
        fadeout.setNode(GameRoot);
        fadeout.setFromValue(0);
        fadeout.setToValue(1);
        fadeout.play();
    }

    @FXML
    public void changeDialogOption1(javafx.event.ActionEvent actionEvent) throws IOException {
        if (dialogNum >= dialogslist.size()) {
            if (GameScreenController.numCharactersVisited == 4) {
                System.out.println("Game End");
            } else {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("fxml/PenguinOverworldScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/PenguinOverworld.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            }
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }

        if (dialogNum == 5) {
            String newImgURL = "@../../assets/images/penguinski.png";
            Image imageObject = new Image(newImgURL);
            imageView.setImage(imageObject);
        }
    }

    @FXML
    public void changeDialogOption2(javafx.event.ActionEvent actionEvent) throws IOException {
        if (dialogNum >= dialogslist.size()) {
            if (GameScreenController.numCharactersVisited == 4) {
                System.out.println("Game End");
            } else {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("fxml/PenguinOverworldScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/PenguinOverworld.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            }
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }
    }
}