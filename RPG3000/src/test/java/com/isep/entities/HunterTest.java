package com.isep.entities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HunterTest {

    @Test
    public void testLessArrowsAfterShot(){
        Hunter hunter = new Hunter(5);
        int initialNumberOfArrows = hunter.getArrows();
        Enemy enemy = new BasicEnemy();
        enemy.receiveAttack(hunter);
        assertTrue(initialNumberOfArrows > hunter.getArrows());
    }

    @Test
    public void testAttackWithoutArrow(){
        Hunter hunter = new Hunter(0);
        assertEquals(hunter.attack(), hunter.getArrows());
    }

    @Test
    public void testAttackWithMana(){
        Hunter hunter = new Hunter(5);
        assertEquals(hunter.attack(), hunter.getWeaponDamage() );
    }
}
