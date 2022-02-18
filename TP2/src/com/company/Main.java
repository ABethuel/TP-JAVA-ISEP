package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //discriminant();
        parite();
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

    }
}

