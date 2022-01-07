package com.example.hangman;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Rounds {
    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    public void popup() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Rounds.fxml"));
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
