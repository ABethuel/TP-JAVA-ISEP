package com.isep.entities;

import java.util.List;

public abstract class Hero {

    // Attributs
    private int lifePoints;
    private int armor;
    private int weaponDamage;
    private List<Potion> potions;
    private List<Food> lembas;

    // Getter/Setters
    public int getLifePoints() {
        return lifePoints;
    }
    public int getArmor() {
        return armor;
    }
    public int getWeaponDamage() {
        return weaponDamage;
    }
    public List<Potion> getPotions() {
        return potions;
    }
    public List<Food> getLembas() {
        return lembas;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }
    public void setLembas(List<Food> lembas) {
        this.lembas = lembas;
    }

    // Méthodes
    public abstract int attack();
    public abstract int defend();
    public abstract void useConsumables(Consumable consumable);
}
