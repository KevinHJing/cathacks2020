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
import javafx.scene.control.TextArea;
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
public class SnowmanDialogController implements Initializable {
    @FXML Label dialogue;
    @FXML Label welcomeMessage;
    @FXML Button option1;
    @FXML Button option2;
    @FXML Button option3;
    @FXML StackPane GameRoot;
    @FXML ImageView imageView;
    @FXML TextArea text;

    private Character character;
    ArrayList<Dialog> dialogslist = new ArrayList<Dialog>();
    private int dialogNum = 0;
    String playerName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameRoot.setOpacity(0);
        makeFadeInTransition();

        text.setWrapText(true);
        text.setEditable(false);
        text.setMouseTransparent(true);
        text.setFocusTraversable(false);
        text.setFont(new Font("Lucida Console", 20));

        option1.setWrapText(true);
        option1.setFont(new Font("Segoe UI", 17));

        option2.setWrapText(true);
        option2.setFont(new Font("Segoe UI", 17));
        Dialog d1 = new Dialog(
                "??: Oh hey, I didn’t realize someone else was there. ",
                "Hey, I'm " + EnterNameController.playerName + ".",
                "Who are you?");
        Dialog d2 = new Dialog(
                "Bean: I’m Bean! It’s nice to meet you. " +
                        "You might have seen my twin, Sean, around " +
                        "the town earlier.",
                "What are you doing here?",
                null);
        Dialog d3 = new Dialog(
                "Bean: The forest is quiet, so I like to come here " +
                        "for meditation. I’m trying to open my third eye.",
                "Snowman... meditation?",
                "Uh, your third eye?");
        Dialog d4 = new Dialog(
                "Bean: Never mind that. Why were you out here?",
                "I was looking for you.",
                "Bowman wanted me to " +
                            "give you a present.");
        Dialog d5 = new Dialog(
                "Bean: Oh? I’m so excited, what is it?",
                "Give Bean his present",
                null);
        Dialog d6 = new Dialog(
                "Bean: Wow, a top hat! I’ve been looking for " +
                        "one for ages! Wait...what’s this inside the hat?",
                "You got two presents and " +
                            "I didn’t even get one…",
                "Oooh what is it?");
        Dialog d7 = new Dialog(
                "Bean: It's... a lump of coal??? I HAVE AWAKENED MY THIRD EYE!!!",
                "What... is happening...",
                null);
        Dialog d8 = new Dialog(
                "Bean: Thank you so much for your help! " +
                        "I have a present for you too, but you " +
                        "need to play a game with me first!",
                "Start game",
                null);
        setDialogValues(d1);
        dialogslist.add(d2);
        dialogslist.add(d3);
        dialogslist.add(d4);
        dialogslist.add(d5);
        dialogslist.add(d6);
        dialogslist.add(d7);
        dialogslist.add(d8);
    }

    private void setDialogValues(Dialog d) {
        text.setText(d.getOutput());
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
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/SnowmanOverworldScreen.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/SnowmanOverworld.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }

        if (dialogNum == 5) {
            String newImgURL = "@../../assets/images/hatman.png";
            Image imageObject = new Image(newImgURL);
            imageView.setImage(imageObject);
        }

        if (dialogNum == 6) {
            String newImgURL = "@../../assets/images/awakenman.png";
            Image imageObject = new Image(newImgURL);
            imageView.setImage(imageObject);
        }
    }

    @FXML
    public void changeDialogOption2(javafx.event.ActionEvent actionEvent) throws IOException {
        if (dialogNum >= dialogslist.size()) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/SnowmanOverworldScreen.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/SnowmanOverworld.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }
    }
}