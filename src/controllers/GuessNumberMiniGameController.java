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
import java.util.Random;
import java.util.ResourceBundle;

import java.io.IOException;
public class GuessNumberMiniGameController implements Initializable {
    @FXML Label dialogue;
    @FXML Button option1;
    @FXML Button option2;
    @FXML Button option3;
    @FXML Button option4;
    @FXML Button option5;

    @FXML StackPane GameRoot;
    @FXML ImageView imageView;
    @FXML TextArea text;

    private Character character;
    ArrayList<Dialog> dialogslist = new ArrayList<Dialog>();
    private int dialogNum = 0;
    String playerName;
    private int randomNumber;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameRoot.setOpacity(0);
        makeFadeInTransition();
        Random rand = new Random();
        randomNumber = rand.nextInt(5) + 1;

        text.setWrapText(true);
        text.setEditable(false);
        text.setMouseTransparent(true);
        text.setFocusTraversable(false);
        text.setFont(new Font("Lucida Console", 20));
        text.setText("Okay, it’s really easy. I am thinking of a number 1 - 5. What number is it?");

        option1.setFont(new Font("Segoe UI", 25));
        option2.setFont(new Font("Segoe UI", 25));
        option3.setFont(new Font("Segoe UI", 25));
        option4.setFont(new Font("Segoe UI", 25));
        option5.setFont(new Font("Segoe UI", 25));
        option1.setText("1");
        option2.setText("2");
        option3.setText("3");
        option4.setText("4");
        option5.setText("5");

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

//    @FXML
//    public void changeDialogOption1(javafx.event.ActionEvent actionEvent) throws IOException {
//        if (dialogNum >= dialogslist.size()) {
//            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            Parent root = FXMLLoader.load(getClass().getResource("fxml/GuessNumberMiniGameScreen.fxml"));
//            Scene scene = new Scene(root, 900, 650);
//            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
//            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
//            stage.setScene(scene);
//        } else {
//            setDialogValues(dialogslist.get(dialogNum));
//            dialogNum++;
//        }
//    }
    @FXML
    public void changeDialogOption1(javafx.event.ActionEvent actionEvent) throws IOException {
        if (randomNumber == 1) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/SnowmanDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        } else {
            text.setText("Nope. Keep Guessing!");
        }
    }

    @FXML
    public void changeDialogOption2(javafx.event.ActionEvent actionEvent) throws IOException {
        if (randomNumber == 2) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/SnowmanDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        } else {
            text.setText("Nope. Keep Guessing!");
        }
    }

    @FXML
    public void changeDialogOption3(javafx.event.ActionEvent actionEvent) throws IOException {
        if (randomNumber == 3) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/SnowmanDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        } else {
            text.setText("Nope. Keep Guessing!");
        }
    }

    @FXML
    public void changeDialogOption4(javafx.event.ActionEvent actionEvent) throws IOException {
        if (randomNumber == 4) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/SnowmanDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        } else {
            text.setText("Nope. Keep Guessing!");
        }
    }

    @FXML
    public void changeDialogOption5(javafx.event.ActionEvent actionEvent) throws IOException {
        if (randomNumber == 5) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/SnowmanDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        } else {
            text.setText("Nope. Keep Guessing!");
        }
    }
}