package com.isep.entities;


import java.util.List;

public class Game {
    private List<Hero> heroes;
    private int playerTurn;

    public static enum Status {START_COMBAT, HERO_TURN, ENEMY_TURN, END_GAME, BREAK }

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

    public void playGame() {
        
    }

    public void generateCombat() {}
}
