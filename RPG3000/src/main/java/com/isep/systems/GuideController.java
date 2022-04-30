package com.isep.systems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class GuideController {

    @FXML
    public void onClickBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        MainApplication.stage.setScene(scene);
        MainApplication.stage.show();
    }
}
