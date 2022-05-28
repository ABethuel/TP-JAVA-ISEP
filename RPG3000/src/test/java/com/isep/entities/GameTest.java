package com.isep.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    // Test si aucun joueur n'est en vie = défaite
    @Test
    public void TestGameOver(){
        List<Hero> listHero = new ArrayList<Hero>();
        Game game = new Game(listHero, 0);
        assertTrue(game.isGameOver());
    }

    @Test
    public void TestGameNotOver(){
        List<Hero> listHero = new ArrayList<Hero>();
        listHero.add(new Warrior());
        Game game = new Game(listHero, 0);
        assertFalse(game.isGameOver());
    }

}
