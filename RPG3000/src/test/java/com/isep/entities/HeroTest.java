package com.isep.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {

    @Test
    public void testPV(){
        Hero hero = new Hunter(5);
        hero.setLifePoints(-5);
        assertTrue(hero.getLifePoints() < 0);
    }

    @Test
    public void testAttack(){
        Enemy enemy = new Boss();
        Hero hero = new Warrior();
        hero.receiveAttack(enemy);

    }


}
