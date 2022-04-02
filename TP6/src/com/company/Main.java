package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] eleves = {"Jean", "Claude", "Van", "Damne", "Thierry Henry"};
    }

    public static Map<Integer, Wallet> createDictionary(String[] list){
        Map<Integer, Wallet> dictionnary = new HashMap<Integer, Wallet>();
        for (String name: list){
            System.out.println(name);
            Wallet wallet = new Wallet(name);
            wallet.setIsepCoins(10);
            dictionnary.put(wallet.getToken(), wallet);
            System.out.println(dictionnary.get(wallet.getToken()));
        }
        return dictionnary;
    }
}
