package controllers;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayersRoomController implements Initializable {

    @FXML AnchorPane GameRoot;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameRoot.setOpacity(0);
        makeFadeInTransition();
    }

    private void makeFadeInTransition() {
        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(2000));
        fadeout.setNode(GameRoot);
        fadeout.setFromValue(0);
        fadeout.setToValue(1);
        fadeout.play();
    }

    public void loadNextScene(MouseEvent mouseEvent) throws IOException {
        Parent secondView;
        secondView = (AnchorPane) FXMLLoader.load(getClass().getResource("fxml/ReindeerOverworldScreen.fxml"));
        Scene scene = new Scene(secondView, 900, 650);
        scene.getStylesheets().add(getClass().getResource("css/ReindeerOverworld.css").toExternalForm());

        Stage curr = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        curr.setTitle("Gamer hours");
        curr.setScene(scene);
    }
}
