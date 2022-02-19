package com.company;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //discriminant();
        //parite();
        //max();
        //egaliteStr();
        //factorielle();
        //countdown();
        //carres();
        //tableMultiplication();
        //division();
        //regle();
        nombrePremier();
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

    public static void countdown() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier positif");
        int n = scanner.nextInt();
        if (n == 0){
            System.out.println("Veuillez saisir un entier strictement positif");
        }else{
            while (n >= 0 ){
                System.out.println(n);
                n -= 1;
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("BOUM!");
        }
    }

    private static void carres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un entier:");
        int n = scanner.nextInt();
        System.out.println(n + "\t" + n*n);
    }

    private static void tableMultiplication(){
        for(int i = 1; i<=10; i++){
            System.out.print(i + "\t");
            for (int j=2; j<=10; j++){
                if (j == 10){
                    System.out.println(j*i + "\t");
                }else{
                    System.out.print(j*i + "\t");
                }
            }
        }
    }

    private static void division(){
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;

        System.out.print("Veuillez saisir un entier a : ");
        a = scanner.nextInt();

        do{
            System.out.print("Veuillez saisir un entier b : ");
            b = scanner.nextInt();
        }while(b==0);

        double division = a/b;
        System.out.println("la division de a par b donne : " + division);
    }

    private static void regle(){
        int a;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Longueur ? ");
            a = scanner.nextInt();
        }while(a<=0);
        int n = 0;
        while (n<a){

            n+=1;
            if (n%10==0){
                System.out.print(" | ");
            }
            else if (n==1){
                System.out.print(" | -");
            }else{
                System.out.print("-");
            }
        }
    }

    private static void nombrePremier(){
        int a;
        boolean premier = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("Saisir un entier > 0 : ");
            a = scanner.nextInt();
        }while(a<=0);

        for (int i=2; i<=a/2; i++){
            if (a%i==0){
                premier = false;
                break;
            }
        }

        if (premier){
            System.out.println("le nombre " + a + " est premier");
        }else{
            System.out.println("le nombre " + a + " n'est pas premier");
        }
    }
}

