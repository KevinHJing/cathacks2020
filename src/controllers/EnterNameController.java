package controllers;

import game.Player;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import javax.swing.*;
import java.io.IOException;
import java.util.Stack;

public class EnterNameController {

    @FXML private TextField nameField;
    @FXML private Button startButton;
    @FXML private StackPane mainbox;
    static String playerName;

    @FXML
    private void handleButtonSubmit(ActionEvent event) throws IOException {
        // if nameField is empty
        if (nameField.getText().isBlank()){
            Alert fail= new Alert(Alert.AlertType.ERROR);
            fail.setHeaderText("Please enter a valid name");
            fail.showAndWait();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("fxml/EnterNameScreen.fxml"));
            Scene scene = new Scene(root, 640, 400);
            scene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("css/EnterName.css").toExternalForm());
            stage.setScene(scene);
            return;
        }

        // call changeToGame
        this.changeToGame(event);

    }

    @FXML
    private void changeToGame(ActionEvent event) throws IOException {
        // call fade out
        makeFadeOut();

    }

    private void loadNextScene() throws IOException{

        playerName = nameField.getText();
        Player player = new Player(nameField.getText());
        Parent secondView;
        secondView = (StackPane) FXMLLoader.load(getClass().getResource("fxml/GameScreen.fxml"));


//        // MAKE REINDEER BUTTON
//        // creating a graphic
//        Image reindeerImage = new Image(getClass().getResourceAsStream("../assets/images/reindeer.png"));
//        ImageView reindeerIV = new ImageView(reindeerImage);
//        reindeerIV.setFitHeight(275.0);
//        reindeerIV.setFitWidth(603.0);
//        reindeerIV.setPickOnBounds(true);
//        reindeerIV.setPreserveRatio(true);
//        // creating button
//        Button reindeerButton = new Button();
//        // setting the characteristics of button
//        reindeerButton.setStyle("-fx-background-color: transparent;");
//        reindeerButton.setTranslateX(500);
//        reindeerButton.setTranslateY(300);
//        // setting the graphic to the button
//        reindeerButton.setGraphic(reindeerIV);
//        // setting if button is hovered
//        reindeerButton.setId("reindeer-char");



        // add button as child of secondView
//        ((AnchorPane)secondView).getChildren().add(reindeerButton);

        Scene scene = new Scene(secondView, 900, 650);
        scene.getStylesheets().add(getClass().getResource("css/game.css").toExternalForm());
        Stage curr = (Stage) mainbox.getScene().getWindow();
        curr.setTitle("Dreaming....");
        curr.setScene(scene);

        /*
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Enter Your Name");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/GameScreen.fxml"));
        Parent root = loader.load();

        GameScreenController gameScreenController = loader.getController();
        gameScreenController.setLabelText(nameField.getText());

        Scene scene = new Scene(root, 900, 650);
        scene.getStylesheets().add(getClass().getResource("css/game.css").toExternalForm());
        stage.setScene(scene); */
    }

    private void makeFadeOut() {
        FadeTransition fadeout = new FadeTransition();
        fadeout.setDuration(Duration.millis(1000));
        fadeout.setNode(mainbox);
        fadeout.setFromValue(1);
        fadeout.setToValue(0);
        fadeout.setOnFinished((ActionEvent actionEvent) -> {
            try {
                // after fading out, load next scene
                loadNextScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fadeout.play();
    }

    public void keyPressed(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ENTER)
            handleButtonSubmit(new ActionEvent(keyEvent.getSource(),
                    ((Node)keyEvent.getSource()).getScene().lookup("startButton")));
    }

}
