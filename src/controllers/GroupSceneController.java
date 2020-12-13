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
public class GroupSceneController implements Initializable {
    @FXML Label dialogue;
    @FXML Label welcomeMessage;
    @FXML Button option1;
    @FXML Button option2;
    @FXML StackPane GameRoot;
    @FXML ImageView imageView1;
    @FXML ImageView imageView2;
    @FXML ImageView imageView3;
    @FXML ImageView imageView4;
    @FXML ImageView imageView5;
    @FXML ImageView mainSpeaker;

    @FXML TextArea text;

    private Character character;
    ArrayList<Dialog> dialogslist = new ArrayList<Dialog>();
    private int dialogNum = 0;
    String playerName;

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
        mainSpeaker.setImage(null);
        Dialog d1 = new Dialog(
                "???: SURPRISE!!",
                "Intruder!!",
                "WHAT’S GOING ON?!");
        Dialog d2 = new Dialog(
                "Everyone: Happy Holidays!",
                "Alright, what’s all this then?",
                "I thought you said you " +
                        "couldn’t visit me, Bowman.");
        Dialog d3 = new Dialog(
                "Bowman: Haha, got you good, huh? We wanted to do something " +
                        "special for you to show how much we appreciate you!",
                "So… what was that dream?",
                null);
        Dialog d4 = new Dialog(
                "Bowman: Well, I had to get you out of the house so I could" +
                        " decorate and bake you a cake! I’d say it worked pretty well. " +
                        "Learning how to dreamwalk was so worth it.",
                "Where'd you learn how to dreamwalk?",
                "How'd you come up with that idea?");
        Dialog d5 = new Dialog(
                "Hehe... trade secret.",
                "...",
                "what kind of trade...");
        Dialog d6 = new Dialog(
                "Moodolph: See, now the fork I got you can be used to eat the cake!",
                "That… makes a lot more sense now.",
                null);
        Dialog d7 = new Dialog(
                "Iceberg: The candle too! You can put it on the cake and " +
                        "pretend it’s your birthday. Isn’t that fun?",
                "That does sound fun!",
                null);
        Dialog d8 = new Dialog(
                "Bean: Whipped cream good. Especially on cake.",
                "That's facts.",
                null);
        Dialog d9 = new Dialog(
                "Bowman: Well, I hope you enjoyed this little adventure. " +
                        "Now we can sit back, relax, and listen to the most iconic -- " +
                        "and might I say, BEST, -- holiday song.",
                "Sounds like a plan!",
                null);

        setDialogValues(d1);
        dialogslist.add(d2);
        dialogslist.add(d3);
        dialogslist.add(d4);
        dialogslist.add(d5);
        dialogslist.add(d6);
        dialogslist.add(d7);
        dialogslist.add(d8);
        dialogslist.add(d9);
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
            mainSpeaker.setImage(null);

            String newImgURL = "@../../assets/images/wildcatsmile.png";
            Image imageObject = new Image(newImgURL);
            imageView1.setImage(imageObject);

            String newImgURL2 = "@../../assets/images/penguinsmile.png";
            Image imageObject2 = new Image(newImgURL2);
            imageView2.setImage(imageObject2);

            String newImgURL3 = "@../../assets/images/reindeersmile.png";
            Image imageObject3 = new Image(newImgURL3);
            imageView3.setImage(imageObject3);

            String newImgURL4 = "@../../assets/images/smileman.png";
            Image imageObject4 = new Image(newImgURL4);
            imageView4.setImage(imageObject4);

            String newImgURL5 = "@../../assets/images/seansmile.png";
            Image imageObject5 = new Image(newImgURL5);
            imageView5.setImage(imageObject5);

            if(!isPlaying) playMusic();
            return;
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }

        if (dialogNum == 2 || dialogNum == 8) {
            imageView1.setImage(null);
            imageView2.setImage(null);
            imageView3.setImage(null);
            imageView4.setImage(null);
            imageView5.setImage(null);

            String newImgURL = "@../../assets/images/wildcatsmile.png";
            Image imageObject = new Image(newImgURL);
            mainSpeaker.setImage(imageObject);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(1000));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setNode(mainSpeaker);
            fade.play();
        }

        if (dialogNum == 5) {
            String newImgURL = "@../../assets/images/reindeersmile.png";
            Image imageObject = new Image(newImgURL);
            mainSpeaker.setImage(imageObject);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(1000));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setNode(mainSpeaker);
            fade.play();
        }

        if (dialogNum == 6) {
            String newImgURL = "@../../assets/images/penguinsmile.png";
            Image imageObject = new Image(newImgURL);
            mainSpeaker.setImage(imageObject);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(1000));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setNode(mainSpeaker);
            fade.play();
        }

        if (dialogNum == 7) {
            String newImgURL = "@../../assets/images/smileman.png";
            Image imageObject = new Image(newImgURL);
            mainSpeaker.setImage(imageObject);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(1000));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setNode(mainSpeaker);
            fade.play();
        }
    }

    @FXML
    public void changeDialogOption2(javafx.event.ActionEvent actionEvent) throws IOException {
        if (dialogNum >= dialogslist.size()) {
            mainSpeaker.setImage(null);

            String newImgURL = "@../../assets/images/wildcatsmile.png";
            Image imageObject = new Image(newImgURL);
            imageView1.setImage(imageObject);

            String newImgURL2 = "@../../assets/images/penguinsmile.png";
            Image imageObject2 = new Image(newImgURL2);
            imageView2.setImage(imageObject2);

            String newImgURL3 = "@../../assets/images/reindeersmile.png";
            Image imageObject3 = new Image(newImgURL3);
            imageView3.setImage(imageObject3);

            String newImgURL4 = "@../../assets/images/smileman.png";
            Image imageObject4 = new Image(newImgURL4);
            imageView4.setImage(imageObject4);

            String newImgURL5 = "@../../assets/images/seansmile.png";
            Image imageObject5 = new Image(newImgURL5);
            imageView5.setImage(imageObject5);

            if(!isPlaying) playMusic();
            return;
        } else {
            setDialogValues(dialogslist.get(dialogNum));
            dialogNum++;
        }

        if (dialogNum == 2 || dialogNum == 8) {
            imageView1.setImage(null);
            imageView2.setImage(null);
            imageView3.setImage(null);
            imageView4.setImage(null);
            imageView5.setImage(null);

            String newImgURL = "@../../assets/images/wildcatsmile.png";
            Image imageObject = new Image(newImgURL);
            mainSpeaker.setImage(imageObject);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(1000));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setNode(mainSpeaker);
            fade.play();
        }

        if (dialogNum == 5) {
            String newImgURL = "@../../assets/images/reindeersmile.png";
            Image imageObject = new Image(newImgURL);
            mainSpeaker.setImage(imageObject);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(1000));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setNode(mainSpeaker);
            fade.play();
        }

        if (dialogNum == 6) {
            String newImgURL = "@../../assets/images/penguinsmile.png";
            Image imageObject = new Image(newImgURL);
            mainSpeaker.setImage(imageObject);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(1000));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setNode(mainSpeaker);
            fade.play();
        }

        if (dialogNum == 7) {
            String newImgURL = "@../../assets/images/smileman.png";
            Image imageObject = new Image(newImgURL);
            mainSpeaker.setImage(imageObject);
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(1000));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setNode(mainSpeaker);
            fade.play();
        }
    }

    private void playMusic() {
        if(isPlaying) return;

        isPlaying = true;
        String s = "src/assets/music/all i want.mp3";
        PlayersRoomController.ac.stop();
        PlayersRoomController.ac = new AudioClip(Paths.get(s).toUri().toString());
        PlayersRoomController.ac.setCycleCount(AudioClip.INDEFINITE);
        PlayersRoomController.ac.setVolume(0.5);
        PlayersRoomController.ac.play();
    }
}