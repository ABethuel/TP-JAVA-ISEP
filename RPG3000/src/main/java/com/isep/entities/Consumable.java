package com.isep.entities;

public interface Consumable {

    public abstract void use(Hero hero);

    int getEfficiency() ;
    void setEfficiency(int efficiency);
}
