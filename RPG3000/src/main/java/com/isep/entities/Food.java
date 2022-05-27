package com.isep.entities;

public class Food implements Consumable {

    private int efficiency;

    public Food() {
        setEfficiency(1);
    }

    @Override
    public void use(Hero hero) {
        hero.setLifePoints(hero.getLifePoints() + getEfficiency());
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
