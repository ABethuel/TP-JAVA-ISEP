package com.isep.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {

    // Attributs
    private int lifePoints;
    private int armor;
    private int weaponDamage;
    private List<Potion> potions= new ArrayList<Potion>();
    private List<Food> lembas = new ArrayList<Food>();
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
    public void setPotions(Potion potion) {
        this.potions.add(potion);
    }
    public void setLembas(Food lembas) {
        this.lembas.add(lembas);
    }
    public void setName(String name) {
        this.name = name;
    }

    // Méthodes
    public abstract int attack();

    // Lorsque l'enemi attaque
    public void receiveAttack(Enemy enemy){
        if (getArmor() <= 0){  // Il s'attaque d'abord à l'armure
            int newLifePoints = getLifePoints();
            newLifePoints -= enemy.attack();
            setLifePoints(newLifePoints);
        }else{                  // Puis au points de vie
            int newArmorPoints = getArmor();
            newArmorPoints -= enemy.attack();
            setArmor(newArmorPoints);
        }
    }

    public boolean isHeroAlive(int lifePoints){
        return this.lifePoints <= 0;
    }

    public abstract int defend();

    // Utilisation d'un consummable
    public void useConsumable(Consumable consumable){
        consumable.use(this);
    }
}
