package com.isep.entities;

public class Food extends Consumable {

    public Food() {
        setEfficiency(1);
    }

    @Override
    public void use(Hero hero) {
        hero.setLifePoints(hero.getLifePoints() + getEfficiency());
    }
}
