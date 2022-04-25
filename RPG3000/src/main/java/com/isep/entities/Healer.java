package com.isep.entities;

public class Healer extends SpellCaster{

    private int manaHeal = 1;

    public Healer(){
        this.setLifePoints(7);
        this.setArmor(3);
        this.setWeaponDamage(1);
        this.setManaPoints(6);
        this.setManaUse(3);
        this.setName("Healer");
        Food food = new Food();
        this.setLembas(food);
        Potion potion = new Potion();
        this.setPotions(potion);
    }

    @Override
    public int attack() {
        if (getManaPoints() <= 0){
            System.out.println("T'as plus de magie frr");
            return 0;
        }else {
            updateManaPointsAfterAttack();
            return getWeaponDamage();
        }
    }

    private void updateManaPointsAfterAttack() {
        setManaPoints(getManaPoints() - getManaUse());
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
