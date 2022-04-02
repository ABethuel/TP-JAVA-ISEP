package com.isep.entities;

public class Hunter extends Hero{

    private final int arrows;

    public Hunter(int arrows) {
        this.arrows = arrows;
    }

    @Override
    public int attack() {
        return 1;
    }

    @Override
    public int defend() {
        return 1;
    }

    @Override
    public void useConsumables(Consumable consumable) {

    }
}
