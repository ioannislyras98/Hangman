package com.example.hangman;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Application extends javafx.application.Application {

    private static Stage stage ;
    private static Scene scene ;
    private static Parent root ;

    @Override
    public void start(Stage s) throws IOException {
        root =FXMLLoader.load(getClass().getResource("game.fxml"));
        scene = new Scene(root,750,590);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public static void exit() throws IOException{
        stage.close();
    }

    public static void main(String[] args) {
        launch();
    }
}