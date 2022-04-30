package com.isep.entities;

public class Potion extends Consumable {

    public Potion() {
        setEfficiency(1);
    }

    @Override
    public void use(Hero hero) {
        hero.setWeaponDamage(hero.getWeaponDamage() + getEfficiency());
    }
}
