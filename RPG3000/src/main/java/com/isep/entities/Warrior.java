package com.isep.entities;

import java.util.List;
import java.util.Random;

public class Warrior extends Hero {

    public Warrior(){
        this.setLifePoints(12);
        this.setArmor(10);
        this.setWeaponDamage(4);
        this.setName("Warrior");
        Food food = new Food();
        this.setLembas(food);
        Potion potion = new Potion();
        this.setPotions(potion);
    }

    @Override
    public int attack() {
        Random random = new Random();
        int nb = random.nextInt(4);
        if (nb == 3){ // Le warrior va au contact, il peut donc aléatoirement perdre des points de vie lors de son offensive
            setLifePoints(getLifePoints() - 1);
        }
        return getWeaponDamage();
    }

    @Override
    public int defend() {
        return 1;
    }


}
