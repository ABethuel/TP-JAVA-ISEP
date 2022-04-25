package com.isep.entities;

public class Food extends Consumable {

    public Food() {
        setEfficiency(1);
    }

    @Override
    public int use(Hero hero) {
        hero.setLifePoints(hero.getLifePoints() + getEfficiency());
        return 0;
    }
}
