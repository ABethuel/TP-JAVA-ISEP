package com.isep.rpg;

import com.isep.utils.InputParser;

import java.util.List;

public class Game {
    private List<Hero> heroes;
    private int playerTurn;
    private InputParser inputParser;

    public Game(List<Hero> heroes, int playerTurn) {
        this.heroes = heroes;
        this.playerTurn = playerTurn;
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }

    public int getPlayerTurn() {
        return this.playerTurn;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void playGame() {}
    public void generateCombat() {}

}
