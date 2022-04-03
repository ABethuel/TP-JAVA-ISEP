package com.isep.systems;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChoiceTeamController {
    ObservableList<String> list= FXCollections.observableArrayList();

    @FXML
    public TextField inputNumberHeroes;
    @FXML
    public Label titleLabel;
    @FXML
    public ChoiceBox<String> heroChoiceBox;

    @FXML
    public void initialize(){
        loadChoiceBox();
    }

    private void loadChoiceBox(){
        list.removeAll();
        list.addAll("Warrior", "Mage", "Healer", "Hunter");
        heroChoiceBox.getItems().addAll(list);
    }
}
