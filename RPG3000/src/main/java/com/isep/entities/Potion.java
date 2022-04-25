package com.isep.entities;

public class Potion extends Consumable {

    public Potion() {
        setEfficiency(1);
    }

    @Override
    public int use(Hero hero) {
        hero.setWeaponDamage(hero.getLifePoints() + getEfficiency());
        return 0;
    }
}
