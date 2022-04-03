package com.isep.systems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    public void onStartClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("choice-team-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        MainApplication.stage.setScene(scene);
        MainApplication.stage.show();
    }
}