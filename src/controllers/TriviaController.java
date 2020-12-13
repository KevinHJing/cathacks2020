package controllers;

import game.Dialog;
import game.Trivia;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TriviaController implements Initializable {

    // buttons
    @FXML Button option1;
    @FXML Button option2;
    @FXML Button option3;

    @FXML
    StackPane GameRoot;

    @FXML
    ImageView imageView;

    @FXML ImageView imageView2;

    @FXML
    TextArea text;

    // number of questions answered right
    @FXML private int correct = 0;

    // dialogs arraylist
    ArrayList<Trivia> triviaList = new ArrayList<Trivia>();
    private int triviaNum = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameRoot.setOpacity(0);
        makeFadeInTransition();

        text.setWrapText(true);
        text.setEditable(false);
        text.setMouseTransparent(true);
        text.setFocusTraversable(false);
        text.setFont(new Font("Lucida Console", 20));
        imageView2.setImage(null);

        option1.setWrapText(true);
        option1.setFont(new Font("Segoe UI", 17));

        option2.setWrapText(true);
        option2.setFont(new Font("Segoe UI", 17));

        option3.setWrapText(true);
        option3.setFont(new Font("Segoe UI", 17));

        Trivia t1 = new Trivia(
                "Moodolph: Ok, " + EnterNameController.playerName + "," + "I'm going to ask you three questions" +
                        " about reindeer like me! If you get at least 2 right, I'll give you your present.",
                "Sounds good!",
                null,
                null,
                0);
        Trivia q1 = new Trivia(
                "Moodolph: Awesome! Question 1: Where do most reindeer live?",
                "A. Antarctica",
                "B. Santa's Stables",
                "C. Arctic Circle",
                3);
        Trivia q1c = new Trivia(
                "Moodolph: Correct!",
                "Bet!",
                null,
                null,
                0);
        Trivia q1w = new Trivia(
                "Moodolph: Wrong! The correct answer is C. Arctic Circle",
                "Shoot!",
                null,
                null,
                0);
        Trivia q2 = new Trivia(
                "Moodolph: Alright. Question 2: Which reindeer can grow antlers?",
                "A. males",
                "B. females",
                "C. both males and females",
                3);
        Trivia q2c = new Trivia(
                "Moodolph: Correct!",
                "Awesome!",
                null,
                null,
                0);
        Trivia q2w = new Trivia(
                "Moodolph: Wrong! The correct answer is C. both males and females",
                "Dang it!",
                null,
                null,
                0);
        Trivia q3 = new Trivia(
                "Moodolph: Last one! Question 3: What do reindeer love to eat?",
                "A. lichen",
                "B. leaves",
                "C. berries",
                1);
        Trivia q3c = new Trivia(
                "Moodolph: Correct!",
                "Yay!",
                null,
                null,
                0);
        Trivia q3w = new Trivia(
                "Moodolph: Wrong! The correct answer is A. lichen",
                "So close!",
                null,
                null,
                0);
        Trivia l = new Trivia(
                "Moodolph: Sorry, you didn't pass the quiz. But I'll give you another try!",
                "Sure!",
                "Awesome!",
                "Phew!",
                0);
        Trivia w1 = new Trivia(
                "Moodolph: Yay! You did well in my trivia game!",
                "I learned a lot about reindeers!",
                "I'm now a reindeer expert.",
                null,
                0);
        Trivia w2 = new Trivia(
                "Moodolph: As your prize ... you receive ...\nA FORK!",
                "Huh?",
                "That's ... interesting",
                null,
                0);
        Trivia w3 = new Trivia(
                "Moodolph: Well, it's a practical gift, right? Well anyways, I have to go!",
                "I guess so ...",
                "Thanks?",
                null,
                0);
        setTriviaValues(t1);
        //triviaList.add(t1);
        triviaList.add(q1);
        triviaList.add(q1c);
        triviaList.add(q1w);
        triviaList.add(q2);
        triviaList.add(q2c);
        triviaList.add(q2w);
        triviaList.add(q3);
        triviaList.add(q3c);
        triviaList.add(q3w);
        triviaList.add(l);
        triviaList.add(w1);
        triviaList.add(w2);
        triviaList.add(w3);
    }

    private void setTriviaValues(Trivia t) {
        text.setText(t.getOutput());
        // set button1
        option1.setText(t.getButtonText1());
        // if button 2 is null
        if (t.getButtonText2() == null) {
            // make it invisible
            option2.setVisible(false);
        } else {
            // if button 2 has stuff, set it as visible
            option2.setVisible(true);
            option2.setText(t.getButtonText2());
        }
        // if button 3 is null
        if (t.getButtonText3() == null){
            // make it invisible
            option3.setVisible(false);
        } else{
            // if button 3 has stuff, set it as visible
            option3.setVisible(true);
            option3.setText(t.getButtonText3());
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
    public void changeTriviaOption1(javafx.event.ActionEvent actionEvent) throws IOException {
        // if done with dialogues
        if (triviaNum >= triviaList.size()) {
            // and you've talked to everyone else
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            if (GameScreenController.numCharactersVisited >= 3) {
                Parent root = FXMLLoader.load(getClass().getResource("fxml/EndTransitionScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/blackscreen.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            } else {
                Parent root = FXMLLoader.load(getClass().getResource("fxml/ReindeerOverworldScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/ReindeerOverworld.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            }
        }
        // if not done with dialogues
        else {
            // if current dialogue is a question
            if (triviaNum == 1 || triviaNum == 4 || triviaNum == 7){
                // if the answer given was correct
                if (triviaList.get(triviaNum-1).getAnswer() == 1){
                    setTriviaValues(triviaList.get(triviaNum));
                    // skip the wrong one
                    triviaNum+=2;
                    // add correct
                    correct++;
                }
                // if the answer given was incorrect
                else {
                    // skip correct answer response
                    triviaNum++;
                    setTriviaValues(triviaList.get(triviaNum));
                    // move to next question
                    triviaNum++;
                }
            }
            // if the current dialogue is the result of last question
            else if(triviaNum == 8){
                // if pass
                if (correct >= 2){
                    //skip 3
                    triviaNum++;
                    setTriviaValues(triviaList.get(triviaNum));
                    triviaNum++;
                }
                // if fail
                else{
                    setTriviaValues(triviaList.get(triviaNum));
                }
            }
            else if(triviaNum == 9){
                // if pass
                if (correct >= 2){
                    // skip loser response
                    triviaNum++;
                    setTriviaValues(triviaList.get(triviaNum));
                    triviaNum++;
                }
                // if fail
                else{
                    // move to next question
                    setTriviaValues(triviaList.get(triviaNum));
                    triviaNum++;
                }
            }
            // if current dialogue is the loser
            else if(triviaNum == 10){
                // reset correct
                correct = 0;
                // reload trivia
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("fxml/Trivia.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/Trivia.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            }
            // if the current dialogue is normal
            else {
                setTriviaValues(triviaList.get(triviaNum));
                // proceed normally
                triviaNum++;
            }

            if (triviaList.get(triviaNum).getOutput().contains("Moodolph: Well, it's a practical gift, right? Well anyways, I have to go!")) {
                String newImgURL = "@../../assets/images/fork.png";
                Image imageObject = new Image(newImgURL);
                imageView2.setImage(imageObject);
                FadeTransition fade = new FadeTransition();
                fade.setDuration(Duration.millis(1000));
                fade.setFromValue(0.0);
                fade.setToValue(1.0);
                fade.setNode(imageView2);
                fade.play();
            }

        }

    }

    // there are no questions with B as an answer
    @FXML
    public void changeTriviaOption2(javafx.event.ActionEvent actionEvent) throws IOException {
        // if done with dialogues
        if (triviaNum >= triviaList.size()) {
            // and you've talked to everyone else
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            if (GameScreenController.numCharactersVisited >= 3) {
                Parent root = FXMLLoader.load(getClass().getResource("fxml/EndTransitionScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/blackscreen.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            } else {
                Parent root = FXMLLoader.load(getClass().getResource("fxml/ReindeerOverworldScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/ReindeerOverworld.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            }
        }
        // if not done with dialogues
        else {
            // if current dialogue is a question
            if (triviaNum == 1 || triviaNum == 4 || triviaNum == 7){
                // reaching this point means that the answer given was wrong
                // skip correct answer response
                triviaNum++;
                setTriviaValues(triviaList.get(triviaNum));
                // move to next question
                triviaNum++;
            }
            // if the current dialogue is the result of last question
            else if(triviaNum == 8){
                // if pass
                if (correct >= 2){
                    //skip 3
                    triviaNum++;
                    setTriviaValues(triviaList.get(triviaNum));
                    triviaNum++;
                }
                // if fail
                else{
                    setTriviaValues(triviaList.get(triviaNum));
                }
            }
            else if(triviaNum == 9){
                // if pass
                if (correct >= 2){
                    // skip loser response
                    triviaNum++;
                    setTriviaValues(triviaList.get(triviaNum));
                    triviaNum++;
                }
                // if fail
                else{
                    // move to next question
                    setTriviaValues(triviaList.get(triviaNum));
                    triviaNum++;
                }
            }
            // if current dialogue is the loser
            else if(triviaNum == 10){
                // reset correct
                correct = 0;
                // reload trivia
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("fxml/Trivia.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/Trivia.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            }
            // if the current dialogue is normal
            else {
                setTriviaValues(triviaList.get(triviaNum));
                // proceed normally
                triviaNum++;
            }

            if (triviaList.get(triviaNum).getOutput().contains("Moodolph: Well, it's a practical gift, right? Well anyways, I have to go!")) {
                String newImgURL = "@../../assets/images/fork.png";
                Image imageObject = new Image(newImgURL);
                imageView2.setImage(imageObject);
                FadeTransition fade = new FadeTransition();
                fade.setDuration(Duration.millis(1000));
                fade.setFromValue(0.0);
                fade.setToValue(1.0);
                fade.setNode(imageView2);
                fade.play();
            }


        }

    }

    @FXML
    public void changeTriviaOption3(javafx.event.ActionEvent actionEvent) throws IOException {
        // if done with dialogues
        if (triviaNum >= triviaList.size()) {
            // and you've talked to everyone else
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            if (GameScreenController.numCharactersVisited >= 3) {
                Parent root = FXMLLoader.load(getClass().getResource("fxml/EndTransitionScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/blackscreen.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            } else {
                Parent root = FXMLLoader.load(getClass().getResource("fxml/ReindeerOverworldScreen.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/ReindeerOverworld.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            }
        }
        // if not done with dialogues
        else {
            // if current dialogue is a question
            if (triviaNum == 1 || triviaNum == 4 || triviaNum == 7){
                // if the answer given was correct
                if (triviaList.get(triviaNum-1).getAnswer() == 3){
                    setTriviaValues(triviaList.get(triviaNum));
                    // skip the wrong one
                    triviaNum+=2;
                    // add correct
                    correct++;
                }
                // if the answer given was incorrect
                else {
                    // skip correct answer response
                    triviaNum++;
                    setTriviaValues(triviaList.get(triviaNum));
                    // move to next question
                    triviaNum++;
                }
            }
            // if the current dialogue is the result of last question
            else if(triviaNum == 8){
                // if pass
                if (correct >= 2){
                    //skip 3
                    triviaNum++;
                    setTriviaValues(triviaList.get(triviaNum));
                    triviaNum++;
                }
                // if fail
                else{
                    setTriviaValues(triviaList.get(triviaNum));
                }
            }
            else if(triviaNum == 9){
                // if pass
                if (correct >= 2){
                    // skip loser response
                    triviaNum++;
                    setTriviaValues(triviaList.get(triviaNum));
                    triviaNum++;
                }
                // if fail
                else{
                    // move to next question
                    setTriviaValues(triviaList.get(triviaNum));
                    triviaNum++;
                }
            }
            // if current dialogue is the loser
            else if(triviaNum == 10){
                // reset correct
                correct = 0;
                // reload trivia
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("fxml/Trivia.fxml"));
                Scene scene = new Scene(root, 900, 650);
                scene.getStylesheets().add(getClass().getResource("css/Trivia.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());
                scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
                stage.setScene(scene);
            }
            // if the current dialogue is normal
            else {
                setTriviaValues(triviaList.get(triviaNum));
                // proceed normally
                triviaNum++;
            }

            if (triviaList.get(triviaNum).getOutput().contains("Moodolph: Well, it's a practical gift, right? Well anyways, I have to go!")) {
                String newImgURL = "@../../assets/images/fork.png";
                Image imageObject = new Image(newImgURL);
                imageView2.setImage(imageObject);
                FadeTransition fade = new FadeTransition();
                fade.setDuration(Duration.millis(1000));
                fade.setFromValue(0.0);
                fade.setToValue(1.0);
                fade.setNode(imageView2);
                fade.play();
            }


        }

    }

}
