package org.example.dictionaryApp.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFxApp extends Application {

    private static Stage primaryStage;

    private static final double WINDOW_WIDTH = 320;
    private static final double WINDOW_HEIGHT = 440;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setResizable(false);

        stage.setTitle("Dictionary app");
        showDictionaryPage();

        stage.show();
    }

    public static void showDictionaryPage() throws IOException {
        Parent root = FXMLLoader.load(JavaFxApp.class.getResource("/org/example/dictionaryApp/DictionaryPage.fxml"));
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
    }
    public static void showSecondPage() throws IOException {
        Parent root = FXMLLoader.load(JavaFxApp.class.getResource("/org/example/dictionaryApp/DictionarySettingPage.fxml"));
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setScene(scene);
    }





}