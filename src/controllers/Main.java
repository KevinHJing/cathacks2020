package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/MainScreen.fxml"));
        stage.setTitle("Welcome Screen testing");
        Scene mainScene = new Scene(root, 640, 400);
        mainScene.getStylesheets().add(getClass().getResource("css/Main.css").toExternalForm());
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
