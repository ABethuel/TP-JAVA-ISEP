package com.isep.entities;

public class Healer extends SpellCaster{

    private int manaHeal = 1;

    public Healer(){
        this.setLifePoints(7);
        this.setArmor(3);
        this.setWeaponDamage(1);
        this.setManaPoints(6);
        this.setManaUse(3);
    }

    @Override
    public int attack() {
        return getWeaponDamage();
    }

    @Override
    public int defend() {
        return 0;
    }

    public int getManaHeal() {
        return manaHeal;
    }

    public void setManaHeal(int manaHeal) {
        this.manaHeal = manaHeal;
    }

    public void healHero(Hero hero){
        if (getManaPoints() >= 0){
            hero.setLifePoints(hero.getLifePoints() + getManaHeal());
            setManaPoints(getManaPoints() - getManaUse());
        }else{
            System.out.println("T'as plus de magie =(");
        }
    }

}
