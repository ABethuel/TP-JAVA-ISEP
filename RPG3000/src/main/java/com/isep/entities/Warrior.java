package com.isep.entities;

public class Warrior extends Hero {

    @Override
    public int attack() {
        return 1;
    }

    @Override
    public int defend() {
        return 1;
    }

    @Override
    public void useConsumables(Consumable consumable) {

    }
}
