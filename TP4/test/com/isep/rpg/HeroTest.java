package com.isep.rpg;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {

    @Test
    public void testPV(){
        Hero hero = new Hunter(5);
        hero.setLifePoints(-5);
        assertTrue(hero.getLifePoints() < 0);
    }
    @Test
    public void testFaux(){
        Hero hero = new Hunter(5);
        hero.setLifePoints(5);
        assertTrue(hero.getLifePoints() < 0);
    }
}
