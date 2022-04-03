package com.isep.entities;

public abstract class Enemy {
    int lifePoints;
    int damagePoints;

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public int attack(){
        return getDamagePoints();
    }

    public void receiveAttack(Hero hero){
        int newLifePoints = getLifePoints();
        newLifePoints -= hero.attack();
        setLifePoints(newLifePoints);
    }

    public boolean isEnemyAlive(int lifePoints){
        return this.lifePoints <= 0;
    }

}
