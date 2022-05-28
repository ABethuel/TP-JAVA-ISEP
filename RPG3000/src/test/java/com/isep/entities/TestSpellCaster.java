package com.isep.entities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSpellCaster {

    @Test
    public void testAttackWithoutMana(){
        SpellCaster mage = new Mage();
        mage.setManaPoints(0);
        assertEquals(mage.attack(), 0);
    }

    @Test
    public void testAttackWithMana(){
        SpellCaster mage = new Mage();
        // Par défaut, le mana est > 0, pas besoin de l'instancier
        assertEquals(mage.attack(), mage.getWeaponDamage() );
    }

    @Test
    public void testHealerCanHeal(){
        Healer healer = new Healer();
        Hero hero = new Warrior();
        int initialLifePoints = hero.getLifePoints();
        healer.healHero(hero);
        assertTrue(initialLifePoints < hero.getLifePoints());
    }
}
