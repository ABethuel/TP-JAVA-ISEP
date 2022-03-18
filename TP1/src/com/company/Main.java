package com.company;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        volume(5.4f, 2.0f, 3.4f);
    }

    public static void displayName(){
        System.out.println(" Bonjour quel est votre prénom ?");
        String yourName = scanner.nextLine();

        System.out.println("Bonjour " + yourName);
    }

    public static void somme() {
        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();

        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();

        int somme = premierEntier + deuxiemeEntier;

        System.out.println("La somme de " + premierEntier + " avec " + deuxiemeEntier + " est egale a " + somme);

        System.out.println("Veuillez saisir le deuxieme entier");
    }

    public static void division(){
        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();

        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();

        int somme = premierEntier / deuxiemeEntier;

        System.out.println("La division de " + premierEntier + " avec " + deuxiemeEntier + " est egale a " + somme);

        System.out.println("Veuillez saisir le deuxieme entier");
    }

    public static void volume(float h, float l, float L){
        float volume = h * l * L;
        System.out.println("Le volume d'un pavé droit de longueur " + L + ", de largeur " + l + " et de hauteur " + h +
                " est de : " + volume);
    }
}
