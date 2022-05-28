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
    public void testIsHeroDying(){
        Hero hero = new Warrior();
        hero.setArmor(0);
        Enemy enemy = new Boss();
        enemy.setDamagePoints(200);
        hero.receiveAttack(enemy);
        assertTrue(hero.isHeroAlive(hero.getLifePoints()));
    }

    @Test
    public void testEnemyAttackOnArmor(){
        Enemy enemy = new Boss();
        Hero hero = new Warrior();
        int armor = hero.getArmor();
        hero.receiveAttack(enemy);
        assertTrue(armor > hero.getArmor());
    }

    @Test
    public void testEnemyAttackOnLifePoints(){
        Enemy enemy = new Boss();
        Hero hero = new Warrior();
        hero.setArmor(0);
        int heroLife = hero.getLifePoints();
        hero.receiveAttack(enemy);
        assertTrue(heroLife > hero.getLifePoints());
    }

    @Test
    public void testHeroAttack(){
        Enemy enemy = new Boss();
        Hero hero = new Warrior();
        int lifeEnemy = enemy.getLifePoints();
        enemy.receiveAttack(hero);
        assertTrue(lifeEnemy > enemy.getLifePoints());
    }

    @Test
    public void heroAttackWithGoodDamage(){
        Enemy enemy = new Boss();
        Hero hero = new Warrior();
        int initialEnemyLife = enemy.getLifePoints();
        enemy.receiveAttack(hero);
        assertEquals(initialEnemyLife - hero.getWeaponDamage(), enemy.getLifePoints());
    }
}
