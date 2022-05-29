package com.isep.entities;

public class Mage extends SpellCaster{

    private int magicDamage = 2;

    public Mage(){
        this.setLifePoints(10);
        this.setArmor(6);
        this.setWeaponDamage(3);
        this.setManaPoints(6);
        this.setManaUse(3);
        this.setName("Mage");
        Food food = new Food();
        this.setLembas(food);
        Potion potion = new Potion();
        this.setPotions(potion);
    }
    @Override
    public int attack() {
        if (getManaPoints() <= 0){
            return 0;
        }else {
            updateManaPointsAfterAttack();
            return getMagicDamage();
        }
    }

    @Override
    public int defend() {
        return 0;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }


}
