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
public class BlackScreen1Controller implements Initializable {
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
                ".........",
                "hello?",
                null);
        Dialog d2 = new Dialog(
                "??: Hey, you there?",
                "Is that a ghost?!",
                "I’m losing it...");
        setDialogValues(d1);
        dialogslist.add(d2);
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
            Parent root = FXMLLoader.load(getClass().getResource("fxml/GameScreen.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/game.css").toExternalForm());
            stage.setScene(scene);
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }
    }

    @FXML
    public void changeBackground() {

    }

    @FXML
    public void changeDialogOption2(javafx.event.ActionEvent actionEvent) throws IOException {
        if (dialogNum >= dialogslist.size()) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/GameScreen.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/game.css").toExternalForm());
            stage.setScene(scene);
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }
    }

    public void imageClick(javafx.scene.input.MouseEvent mouseEvent) {
        dialogue.setText("You clicked the image!!!!!");
    }
}