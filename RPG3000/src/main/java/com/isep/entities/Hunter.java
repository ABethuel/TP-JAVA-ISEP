package com.isep.entities;

import java.util.List;

public class Hunter extends Hero{

    private int arrows;

    public Hunter(int arrows) {
        this.arrows = arrows;
        this.setLifePoints(5);
        this.setArmor(5);
        this.setWeaponDamage(2);
    }

    @Override
    public int attack() {
        if (arrows > 0){
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
