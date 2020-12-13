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
public class PlayersRoomController implements Initializable {
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

    private AudioClip ac;
    private boolean isPlaying;

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
                EnterNameController.playerName + ": That was a really weird dream... " +
                        "Maybe if I slept earlier, these things wouldn’t happen. " +
                        "Wait, what’s that?",
                "Next",
                null);
        Dialog d2 = new Dialog(
                EnterNameController.playerName + ": Huh, I guess I have to hand these out. " +
                        "If Bowman could deliver the presents here, " +
                        "why couldn’t he hand them out himself?... " +
                        "Well, I should get started then. The sooner I " +
                        "get done, the sooner I can enjoy my holiday.",
                "Pick up the presents",
                null);
        setDialogValues(d1);
        dialogslist.add(d2);
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
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ReindeerOverworldScreen.fxml"));
            Scene scene = new Scene(root, 900, 650);
            scene.getStylesheets().add(getClass().getResource("css/ReindeerOverworld.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            stage.setScene(scene);
            playMusic();
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }

        if (dialogNum == 1) {
            String newImgURL = "@../../assets/images/presents.png";
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

        if (dialogNum == 1) {
            String newImgURL = "@../../assets/images/presents.png";
            Image imageObject = new Image(newImgURL);
            imageView.setImage(imageObject);
            FadeTransition fade = new FadeTransition();
        }
    }
    private void playMusic() {
        if(isPlaying) {
            return;
        }
        isPlaying = true;
        String s = "src/assets/music/sleigh ride.mp3";
        ac = new AudioClip(Paths.get(s).toUri().toString());
        ac.setCycleCount(AudioClip.INDEFINITE);
        ac.setVolume(0.5);
//        ac.play();
    }
}
