package com.isep.entities;

public interface Consumable {

    void use(Hero hero);
    int getEfficiency() ;
    void setEfficiency(int efficiency);
}
