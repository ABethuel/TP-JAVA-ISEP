package com.isep.entities;

public class Potion implements Consumable {

    private int efficiency;

    public Potion() {
        setEfficiency(1);
    }

    @Override
    public void use(Hero hero) {
        hero.setWeaponDamage(hero.getWeaponDamage() + getEfficiency());
    }

    @Override
    public int getEfficiency() {
        return efficiency;
    }

    @Override
    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}
