package com.isep.entities;


import java.util.List;
import java.util.Random;

public class Game {
    private List<Hero> heroes;
    private int playerTurn;
    private int numberOfRounds;

    public static enum Status {START_COMBAT, HERO_TURN, ENEMY_TURN, END_GAME, BREAK }

    public Game(List<Hero> heroes, int playerTurn) {
        this.heroes = heroes;
        this.playerTurn = playerTurn;
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }

    public Hero getHero(){
        return getHeroes().get(playerTurn);
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

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void playGame() {
        
    }

    public Enemy generateCombat() {
        Random random = new Random();
        Enemy enemy;
        int nb = random.nextInt(6);
        if (nb == 0 || nb == 1){
            enemy = new Boss();
        }else if (nb == 2){
            enemy = new BigBoss();
        }else{
            enemy = new BasicEnemy();
        }
        return enemy;
    }
}
