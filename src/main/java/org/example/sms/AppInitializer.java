package org.example.sms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/org/example/sms/view/startingPageForm.fxml"));
        stage.setScene(new Scene(load));
        stage.setTitle("Starting Page");
        stage.centerOnScreen();

        stage.show();
    }
}
