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
public class EndTransitionController implements Initializable {
    @FXML Label dialogue;
    @FXML Label welcomeMessage;
    @FXML Button option1;
    @FXML Button option2;
    @FXML AnchorPane GameRoot;
    @FXML TextArea text;

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
                EnterNameController.playerName + ": Well, I finished " +
                        "handing out all of the presents…. Guess I better go home.",
                "Head back home.",
                null);

        setDialogValues(d1);
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

    //TODO update redirect to Ending
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
    }

    //TODO update redirect to Ending
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
    }
}