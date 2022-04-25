package com.isep.entities;

public abstract class Consumable {

    private int efficiency;
    public abstract int use(Hero hero);

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}
