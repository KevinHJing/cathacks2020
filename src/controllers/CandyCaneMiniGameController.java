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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
public class CandyCaneMiniGameController implements Initializable {
    @FXML Label dialogue;
    @FXML Label welcomeMessage;
    @FXML Button option1;
    @FXML Button option2;
    @FXML Button option3;
    @FXML StackPane GameRoot;
    @FXML ImageView imageView;
    @FXML ImageView imageView1;
    @FXML ImageView imageView2;
    @FXML ImageView imageView3;
    @FXML ImageView imageView4;
    @FXML ImageView imageView5;
    @FXML TextArea text;
    @FXML Label label;
    private int numCandyCanesFound = 0;

    private int x1, y1, x2, y2, x3, y3, x4, y4, x5, y5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameRoot.setOpacity(0);
        makeFadeInTransition();

        Random rand = new Random();

        text.setWrapText(true);
        text.setEditable(false);
        text.setMouseTransparent(true);
        text.setFocusTraversable(false);
        text.setFont(new Font("Lucida Console", 20));
        label.setFont(new Font("Lucida Console", 40));
        text.setText("I seem to have lost 5 of my candy canes in my home. can you help me find them?\n" +
                "\nWhen you see a candy cane, click on it to collect it. You win when you find all 5!");
        label.setText("Number of candy canes found: " + numCandyCanesFound);
        label.setTextFill(Color.WHITE);

        // making candy canes come up in random locations
        x1 = rand.nextInt(750)+1;
        x2 = rand.nextInt(750)+1;
        x3 = rand.nextInt(750)+1;
        x4 = rand.nextInt(750)+1;
        x5 = rand.nextInt(750)+1;
        y1 = rand.nextInt(370)+1;
        y2 = rand.nextInt(370)+1;
        y3 = rand.nextInt(370)+1;
        y4 = rand.nextInt(370)+1;
        y5 = rand.nextInt(370)+1;

        imageView1.setTranslateX(x1);
        imageView1.setTranslateY(y1);
        imageView2.setTranslateX(x2);
        imageView2.setTranslateY(y2);
        imageView3.setTranslateX(x3);
        imageView3.setTranslateY(y3);
        imageView4.setTranslateX(x4);
        imageView4.setTranslateY(y4);
        imageView5.setTranslateX(x5);
        imageView5.setTranslateY(y5);
    }

    @FXML
    public void foundCandyCane1(MouseEvent mouseEvent) throws IOException {
        imageView1.setImage(null);
        imageView1.setMouseTransparent(false);
        imageView1.setDisable(true);
        numCandyCanesFound++;
        label.setText("Number of candy canes found: " + numCandyCanesFound);

        if (numCandyCanesFound == 5) {
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/PenguinDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        }
    }

    @FXML
    public void foundCandyCane2(MouseEvent mouseEvent) throws IOException {
        imageView2.setImage(null);
        imageView2.setMouseTransparent(false);
        imageView2.setDisable(true);
        numCandyCanesFound++;
        label.setText("Number of candy canes found: " + numCandyCanesFound);

        if (numCandyCanesFound == 5) {
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/PenguinDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        }
    }

    @FXML
    public void foundCandyCane3(MouseEvent mouseEvent) throws IOException {
        imageView3.setImage(null);
        imageView3.setMouseTransparent(false);
        imageView3.setDisable(true);
        numCandyCanesFound++;
        label.setText("Number of candy canes found: " + numCandyCanesFound);

        if (numCandyCanesFound == 5) {
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/PenguinDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        }
    }


    @FXML
    public void foundCandyCane4(MouseEvent mouseEvent) throws IOException {
        imageView4.setImage(null);
        imageView4.setMouseTransparent(false);
        imageView4.setDisable(true);
        numCandyCanesFound++;
        label.setText("Number of candy canes found: " + numCandyCanesFound);

        if (numCandyCanesFound == 5) {
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/PenguinDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
        }
    }


    @FXML
    public void foundCandyCane5(MouseEvent mouseEvent) throws IOException {
        imageView5.setImage(null);
        imageView5.setMouseTransparent(false);
        imageView5.setDisable(true);
        numCandyCanesFound++;
        label.setText("Number of candy canes found: " + numCandyCanesFound);

        if (numCandyCanesFound == 5) {
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/PenguinDialogScreen2.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
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
}
