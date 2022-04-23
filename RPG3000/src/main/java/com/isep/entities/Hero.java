package com.isep.entities;

import java.util.List;

public abstract class Hero {

    // Attributs
    private int lifePoints;
    private int armor;
    private int weaponDamage;
    private List<Potion> potions;
    private List<Food> lembas;
    private String name;

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

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    // Méthodes
    public abstract int attack();

    public void receiveAttack(Enemy enemy){
        if (getArmor() <= 0){
            int newLifePoints = getLifePoints();
            newLifePoints -= enemy.attack();
            setLifePoints(newLifePoints);
        }else{
            int newArmorPoints = getArmor();
            newArmorPoints -= enemy.attack();
            setArmor(newArmorPoints);
        }
    }

    public boolean isHeroAlive(int lifePoints){
        return this.lifePoints <= 0;
    }

    public abstract int defend();

    public boolean isListItemsEmpty(List<Consumable> listItems) {
        return listItems.size() <= 0;
    }

    public void useConsumables(Consumable consumable, List<Consumable> listItems){
        if (isListItemsEmpty(listItems)){
            System.out.println("Pas d'items dans cette liste");
        }else{
            listItems.remove(consumable);
            setLifePoints(getLifePoints() + 2);
        }
    }
}
