package controllers;
import javafx.animation.FadeTransition;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.io.IOException;
    public class GameScreenController implements Initializable {
        @FXML Label dialogue;
        @FXML Label welcomeMessage;
        @FXML Button option1;
        @FXML Button option2;
        @FXML StackPane GameRoot;
        @FXML ImageView imageView;
        @FXML TextArea text;

        private Character character;
        ArrayList<Dialog> dialogslist = new ArrayList<Dialog>();
        private int dialogNum = 0;
        static double numCharactersVisited = 0;



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
            imageView.setImage(null);
            Dialog d1 = new Dialog(
                    "...........",
                    "Hello???",
                    null);
            Dialog d2 = new Dialog(
                    "??: Hey, you there?",
                    "Is that a ghost?!",
                    "I’m losing it...");
            Dialog d3 = new Dialog(
                    "Bowman: Nah, don’t be silly " + EnterNameController.playerName + ". " +
                            "It’s just me, Bowman the wildcat. I’m here to " +
                            "wish you a happy holidays! Well, I couldn’t " +
                            "visit you in person, but I thought I’d drop " +
                            "by your dream to say hi.",
                    "That’s...unconventional.",
                    "Happy holidays to you too...?");
            Dialog d4 = new Dialog(
                    "Bowman: Dang, not even a warm welcome? It would " +
                            "make me feel a lot better about giving you this " +
                            "job.",
                    "Job?",
                    null);
            Dialog d5 = new Dialog(
                    "Bowman: Well...I had all these presents to give " +
                            "to everyone, but I don’t have the time to give " +
                            "them out. So...could you do me a little favor?",
                    "Sure thing, pal.",
                    "Do I have a choice?");
            Dialog d6 = new Dialog(
                    "Bowman: That’s the spirit! When you wake up, you’ll see " +
                            "the presents in your room. Go travel into town " +
                            "to find Moodolph the Reindeer, Iceberg the " +
                            "Penguin, and Bean the Snowman. Just talk to " +
                            "them to give them each a present!",
                    "Wait, I don’t get one?",
                    null);
            Dialog d7 = new Dialog(
                    "Bowman: Oops, I guess I missed you on the list! " +
                            "Sorry bud. Anyways, gotta be going now! " +
                            "Good luck " + EnterNameController.playerName + "!",
                    "Wait a minute!",
                    "(wake up)");
            setDialogValues(d1);
            dialogslist.add(d2);
            dialogslist.add(d3);
            dialogslist.add(d4);
            dialogslist.add(d5);
            dialogslist.add(d6);
            dialogslist.add(d7);
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
                Parent secondView;
                secondView = (StackPane) FXMLLoader.load(getClass().getResource("fxml/PlayerRoomScreen.fxml"));
                Scene scene = new Scene(secondView, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/playersroom.css").toExternalForm());

                Stage curr = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                curr.setTitle("Gamer Time");
                curr.setScene(scene);
            } else {
                setDialogValues(dialogslist.get(dialogNum));
                dialogNum++;
            }

            String newImgURL = "@../../assets/images/wildcat.png";
            Image imageObject = new Image(newImgURL);
            imageView.setImage(imageObject);

            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(2000));
            fade.setFromValue(0.1);
            fade.setToValue(10);
            fade.setCycleCount(1000);
            fade.setAutoReverse(true);
            fade.setNode(imageView);
            fade.play();
        }

        @FXML
        public void changeDialogOption2(javafx.event.ActionEvent actionEvent) throws IOException {
            if (dialogNum >= dialogslist.size()) {
                Parent secondView;
                secondView = (StackPane) FXMLLoader.load(getClass().getResource("fxml/PlayerRoomScreen.fxml"));
                Scene scene = new Scene(secondView, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/playersroom.css").toExternalForm());

                Stage curr = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                curr.setTitle("Gamer Time");
                curr.setScene(scene);
            } else {
                setDialogValues(dialogslist.get(dialogNum));
                dialogNum++;
            }

            String newImgURL = "@../../assets/images/wildcat.png";
            Image imageObject = new Image(newImgURL);
            imageView.setImage(imageObject);

            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(2000));
            fade.setFromValue(0.1);
            fade.setToValue(10);
            fade.setCycleCount(1000);
            fade.setAutoReverse(true);
            fade.setNode(imageView);
            fade.play();
        }

        public void imageClick(javafx.scene.input.MouseEvent mouseEvent) {
            dialogue.setText("You clicked the image!!!!!");
        }

    }