package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //discriminant();
        //parite();
        //max();
        //egaliteStr();
        factorielle();
    }

    public static void discriminant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quelle est la valeur de c ?");
        float c = scanner.nextFloat();

        System.out.println("Quelle est la valeur de a ?");
        float a = scanner.nextFloat();

        System.out.println("Quelle est la valeur de b ?");
        float b = scanner.nextFloat();

        float delta = (float) (Math.pow(b, 2) - 4 * a * c);

        if (delta < 0) {
            System.out.println("Ce polynome n’a pas de racine reelle");
        }
        else if (delta == 0) {
            double r = (-b) / (2*a);
            System.out.println("Ce polynome possède une racine double : " + r);
        }else{
            double r1 = (-b + Math.sqrt(delta)) / (2*a);
            double r2 = (-b - Math.sqrt(delta)) / (2*a);
            System.out.println("Ce polynome possède deux racines avec : r1 = " + r1 + " et r2 = " + r2);
        }
    }

    public static void parite() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir un entier : ");
        int integer = scanner.nextInt();

        if (integer % 2 ==0 ){
            System.out.println("Le nombre " + integer + " est pair");
        }else {
            System.out.println("Le nombre " + integer + " est impair");
        }
    }

    public static void max() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir un entier a : ");
        int a = scanner.nextInt();

        System.out.print("Veuillez saisir un entier b : ");
        int b = scanner.nextInt();

        if (a == b) {
            System.out.println("les deux entiers a et b sont égaux");
        }else{
            System.out.println("Le maximum des deux entiers a et b est : " + Math.max(a, b));
            System.out.println("Le minimum des deux entiers a et b est : " + Math.min(a, b));
        }
    }

    public static void egaliteStr(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir une chaine de caractère : ");
        String a = scanner.nextLine();

        System.out.print("Veuillez saisir une chaine de caractère : ");
        String b = scanner.nextLine();

        if (a.equals(b)){
            System.out.println("les chaines de caractères sont identiques");
        }else{
            System.out.println("Les chaines de caractères ne sont pas identiques");
        }
    }

    public static void factorielle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier positif ou nul");
        int n = scanner.nextInt();

        int factorielle = 1;
        for (int i = 1; i <= n; i++) {
            factorielle *= i;
        }
        System.out.println(n + "! = " + factorielle);

    }
}

