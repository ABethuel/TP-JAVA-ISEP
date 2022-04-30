package com.isep.systems;

import com.isep.entities.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class EndgameController {

    @FXML
    public Label numberOfRoundsSurvivedLabel;
    public int rounds = (int) MainApplication.stage.getUserData();

    @FXML
    public void initialize(){
        System.out.println(rounds);
        numberOfRoundsSurvivedLabel.setText("Vous avez survécu " + rounds + " tours");
    }
}
