package com.isep.entities;

public interface Consumable {


    void use(Hero hero); // méthode pour utiliser un consommable
    int getEfficiency() ;
    void setEfficiency(int efficiency);
}
