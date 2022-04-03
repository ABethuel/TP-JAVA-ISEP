package com.isep.entities;

public class Warrior extends Hero {

    public Warrior(){
        this.setLifePoints(10);
        this.setArmor(10);
        this.setWeaponDamage(3);
    }

    @Override
    public int attack() {
        return getWeaponDamage();
    }

    @Override
    public int defend() {
        return 1;
    }

    @Override
    public void useConsumables(Consumable consumable) {

    }
}
