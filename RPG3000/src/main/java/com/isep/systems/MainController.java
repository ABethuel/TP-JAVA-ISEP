package com.isep.systems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {

    @FXML
    public Button guideButton;

    @FXML
    public void onStartClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("choice-team-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        MainApplication.stage.setScene(scene);
        MainApplication.stage.show();
    }

    @FXML
    public void onGuideClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("guide-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        MainApplication.stage.setScene(scene);
        MainApplication.stage.show();
    }
}