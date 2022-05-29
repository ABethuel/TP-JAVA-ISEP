package com.isep.entities;

import java.util.List;

public class Hunter extends Hero{

    private int arrows;

    public Hunter(int arrows) {
        this.arrows = arrows;
        this.setLifePoints(10);
        this.setArmor(5);
        this.setWeaponDamage(3);
        this.setName("Hunter");
        Food food = new Food();
        this.setLembas(food);
        Potion potion = new Potion();
        this.setPotions(potion);
    }

    @Override
    public int attack() {
        if (arrows > 0){ // S'il reste des flèches il est possible d'attaquer
            setArrows(getArrows() - 1);
            return getWeaponDamage();
        }
        else{
            return 0;
        }
    }

    @Override
    public int defend() {
        return 1;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }
}
