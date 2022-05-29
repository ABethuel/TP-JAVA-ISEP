package com.isep.entities;

public abstract class SpellCaster extends Hero {

    private int manaPoints;
    private int manaUse;

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public void setManaUse(int manaUse) {
        this.manaUse = manaUse;
    }

    public int getManaUse() {
        return manaUse;
    }

    public void updateManaPointsAfterAttack(){
        setManaPoints(getManaPoints() - getManaUse());
    }


}
