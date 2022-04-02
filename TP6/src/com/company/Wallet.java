package com.company;

import java.util.Random;

public class Wallet {

    private static int a = new  Random().nextInt(1000000);
    private final String owner;
    private final int token = a;
    private int isepCoins = 0;

    public Wallet(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public int getIsepCoins() {
        return isepCoins;
    }

    public int getToken() {
        return token;
    }

    public void setIsepCoins(int isepCoins) {
        this.isepCoins = isepCoins;
    }
}
