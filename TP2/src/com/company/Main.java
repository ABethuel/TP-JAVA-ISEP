package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        choice();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 13){
            System.out.println("Veuillez saisir un nombre entre 1 et 12 pour choisir votre exercice");
            choice();
            choice = scanner.nextInt();
        }

        switch (choice){
            case (1):
                discriminant();
                break;
            case (2):
                parite();
                break;
            case (3):
                max();
                break;
            case (4):
                egaliteStr();
                break;
            case (5):
                factorielle();
                break;
            case (6):
                countdown();
                break;
            case (7):
                carres();
                break;
            case (8):
                tableMultiplication();
                break;
            case (9):
                division();
                break;
            case (10):
                regle();
                break;
            case (11):
                nombrePremier();
                break;
            case (12):
                initialisationTableau();
                break;
        }
    }

    public static void choice(){
        String[] arrayExercices = {"1. Discriminant", "2. Parité d’un nombre", "3. Calcul d’extremum",
                "4. Égalité entre chaînes de caractères", "5. Factorielle", "6. Compte à rebours", "7. Valeurs de carrés",
                "8. Table de multiplication", "9. Division d’entiers", "10. Règle graduée", "11. Nombres premiers",
                "12. Manipulations sur un tableau" };

        System.out.println("\n\nQuel Exercice Saisissez : ");
        for (int i = 0; i < arrayExercices.length; i++){
            System.out.println(arrayExercices[i]);
        }
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

    public static void initialisationTableau() {
        int[] tableau = new int[8];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < tableau.length; i++) {
            System.out.println("Saisir un entier");
            int entier = scanner.nextInt();
            tableau[i] = entier;
        }
        int max = tableau[0];
        int min = tableau[0];
        // On détermine le max et le min
        for (int i = 0; i < tableau.length; i++) {
            int a = tableau[i];
            if (a > max) {
                max = a;
            } else if (a < min) {
                min = a;
            }
        }
        System.out.println("Le maximum du tableau est " + max + "\n" +
                "Le minimum du tableau est " + min);

        // Calcul de la somme
        int somme = 0;
        for (int i = 0; i < tableau.length; i++) {
            somme += tableau[i];
        }
        System.out.println("La somme des éléments du tableau donne " + somme);

        // Elements pairs du tableau
        int[] pairValeurs = new int[0];
        int[] pairIndex = new int[0];
        System.out.print("Les valeurs paires du tableau sont : ");
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] % 2 == 0){
                pairValeurs = Arrays.copyOf(pairValeurs, pairValeurs.length + 1);
                pairValeurs[pairValeurs.length - 1 ] = tableau[i];
                System.out.print(pairValeurs[pairValeurs.length - 1] + "\t");
            }
            if (i % 2 == 0) {
                pairIndex = Arrays.copyOf(pairIndex, pairIndex.length + 1);
                pairIndex[pairIndex.length - 1 ] = tableau[i];
            }
        }
        System.out.print("\nLes éléments du tableau d'indice pair sont : ");
        for (int i = 0; i < pairIndex.length; i++){
            System.out.print(pairIndex[i] + "\t");
        }

        inverseTableau(tableau);
    }

    public static void inverseTableau(int[] tableau){
        int[] tableauInverse = new int[0];
        System.out.print("Le tableau inverse renvoie les valeurs suivantes : ");
        for (int i = tableau.length-1; i > 0 ; i--){
            tableauInverse = Arrays.copyOf(tableauInverse, tableauInverse.length + 1 );
            tableauInverse[tableauInverse.length - 1] = tableau[i];
        }
        System.out.println("\n" + Arrays.toString(tableauInverse));
    }
}


