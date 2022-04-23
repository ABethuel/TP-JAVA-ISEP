package com.isep.systems;

import com.isep.entities.Game;
import com.isep.entities.Hero;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public List<Hero> heroes = (List<Hero>) MainApplication.stage.getUserData();

    @FXML
    public void initialize(){
        System.out.println("Your heroes : " + heroes);
        Game game = new Game(heroes, 1);
    }

}
