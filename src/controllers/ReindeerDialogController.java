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
public class ReindeerDialogController implements Initializable {
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
                "Moodolph: Hey, " + EnterNameController.playerName + "!",
                "What’s up, Moodolph?",
                "What are you doing?");
        Dialog d2 = new Dialog(
                "I’m waiting for my big brother Rudolph to come\n" +
                        "home from delivering presents! Then we can\n" +
                        "celebrate together and he can give me my\n" +
                        "present!\n",
                "I’m delivering presents too!",
                "I also have a present for you.");
        Dialog d3 = new Dialog(
                "Moodolph: Wow, really?\n",
                "Give Moodolph his present",
                null);
        Dialog d4 = new Dialog(
                "Moodolph: It’s a scarf from Bowman! That’s really\n" +
                        "nice of him. Please tell him I said thanks.",
                "I will!",
                null);
        Dialog d5 = new Dialog(
                "Moodolph: I also have a present for you, " + EnterNameController.playerName + "! \n" +
                        "But you’ll have to play a game with me to get it.",
                "Uh, sure?",
                "What game?");
        Dialog d6 = new Dialog(
                "Moodolph: It’s a trivia game! You get points\n" +
                        "for getting the right answer.",
                "Start Game",
                null);
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
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ReindeerOverworldScreen.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/ReindeerOverworld.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }

        if (dialogNum == 3) {
            String newImgURL = "@../../assets/images/scarf reindeet.png";
            Image imageObject = new Image(newImgURL);
            imageView.setImage(imageObject);
        }
    }

    @FXML
    public void changeDialogOption2(javafx.event.ActionEvent actionEvent) throws IOException {
        if (dialogNum >= dialogslist.size()) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ReindeerOverworldScreen.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/ReindeerOverworld.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }
    }
}