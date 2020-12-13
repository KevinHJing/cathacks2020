package controllers;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PenguinOverworldScreenController implements Initializable {

    static boolean penguinVisited = false;
    static boolean seanVisited = false;
    @FXML AnchorPane GameRoot;
    @FXML ImageView imageView;
    @FXML ImageView imageView2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameRoot.setOpacity(0);
        makeFadeInTransition();

        if (penguinVisited) {
            imageView.setMouseTransparent(false);
            imageView.setDisable(true);
        }
        if (seanVisited) {
            imageView2.setMouseTransparent(false);
            imageView2.setDisable(true);
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

    public void loadPenguinDialogScene(MouseEvent mouseEvent) throws IOException {
        penguinVisited = true;
        Parent secondView;
        secondView = (StackPane) FXMLLoader.load(getClass().getResource("fxml/PenguinDialogScreen.fxml"));
        Scene scene = new Scene(secondView, 900, 650);
        scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());

        Stage curr = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        curr.setTitle("Penguin");
        curr.setScene(scene);
    }

    public void loadSeanDialogScene(MouseEvent mouseEvent) throws IOException {
        seanVisited = true;
        Parent secondView;
        secondView = (StackPane) FXMLLoader.load(getClass().getResource("fxml/SeanDialogScreen.fxml"));
        Scene scene = new Scene(secondView, 900, 650);
        scene.getStylesheets().add(getClass().getResource("css/characterdialog.css").toExternalForm());

        Stage curr = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        curr.setTitle("Sean");
        curr.setScene(scene);
    }

    public void loadReindeerOverworld(MouseEvent mouseEvent) throws IOException {
        Parent secondView;
        secondView = (AnchorPane) FXMLLoader.load(getClass().getResource("fxml/ReindeerOverworldScreen.fxml"));
        Scene scene = new Scene(secondView, 900, 650);
        scene.getStylesheets().add(getClass().getResource("css/ReindeerOverworld.css").toExternalForm());

        Stage curr = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        curr.setTitle("Igloo");
        curr.setScene(scene);
    }
}
