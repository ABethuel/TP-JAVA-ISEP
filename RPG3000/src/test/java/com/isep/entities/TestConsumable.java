package com.isep.entities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestConsumable {

    @Test
    public void testUsePotion(){
        Potion potion = new Potion();
        Hero hero = new Warrior();
        int initialDamage = hero.getWeaponDamage();
        potion.use(hero);
        assertTrue(initialDamage < hero.getWeaponDamage());
    }

    @Test
    public void testUseLembas(){
        Food food = new Food();
        Hero hero = new Warrior();
        int initialLifePoints = hero.getLifePoints();
        food.use(hero);
        assertTrue(initialLifePoints < hero.getLifePoints());
    }
}
