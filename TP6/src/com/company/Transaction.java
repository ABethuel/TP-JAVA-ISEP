package com.company;

public class Transaction {

    private final int originWallet;
    private final int destinationWallet;
    private final int isepCoins;
    private boolean payed;


    public Transaction(int originWallet, int destinationWallet, int isepCoins) {
        this.originWallet = originWallet;
        this.destinationWallet = destinationWallet;
        this.isepCoins = isepCoins;
    }

    public int getOriginWallet() {
        return originWallet;
    }

    public int getDestinationWallet() {
        return destinationWallet;
    }

    public int getIsepCoins() {
        return isepCoins;
    }

    public boolean isPayed() {
        return payed;
    }


}
