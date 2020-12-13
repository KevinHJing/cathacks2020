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
public class SeanDialogController implements Initializable {
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
                "??: Your time has come.",
                "Uh, hi?",
                "Did I do something wrong?");
        Dialog d2 = new Dialog(
                "??: Haha, I’m just messing with you.",
                "Okay…what are you doing here Bean?",
                "Is your name Bean?");
        Dialog d3 = new Dialog(
                "Sean: Oh, you’re looking for Bean. I’m Sean. " +
                        "Bean is busy *awakening his third eye*",
                "My bad.",
                null);
        Dialog d4 = new Dialog(
                "Sean: No worries, we’re identical twins so " +
                        "people get us confused all the time.",
                "It was nice meeting you!",
                "I gotta get going.");
        setDialogValues(d1);
        dialogslist.add(d2);
        dialogslist.add(d3);
        dialogslist.add(d4);
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
            if (GameScreenController.numCharactersVisited >= 3) {
                Parent root = FXMLLoader.load(getClass().getResource("fxml/EndTransitionScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/blackscreen.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            } else {
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

    @FXML
    public void changeDialogOption2(javafx.event.ActionEvent actionEvent) throws IOException {
        if (dialogNum >= dialogslist.size()) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            if (GameScreenController.numCharactersVisited >= 3) {
                Parent root = FXMLLoader.load(getClass().getResource("fxml/EndTransitionScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/blackscreen.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            } else {
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