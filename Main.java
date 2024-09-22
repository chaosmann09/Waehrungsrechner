package net.kxinmensch;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Rechner rechner = new Rechner();

    public static void main(String[] args) {
        System.out.println("Willkommen zum Währungsumrechner \n" +
                            "Gebe die Währung an!");
        String basecurrency = scanner.next().toUpperCase();
        System.out.println("Gebe nun den Betrag in " + basecurrency + " an");
        double amount = scanner.nextDouble();
        System.out.println("In welche Währung möchtest du das umrechnen?");
        String targetcurrency = scanner.next().toUpperCase();

        double rate = rechner.getExchangeRate(basecurrency, targetcurrency);
        double convertedAmount = amount * rate;

        System.out.println("Wechselkurs: 1 " + basecurrency + " = " + rate + " " + targetcurrency);
        System.out.println("Umgerechneter Betrag: " + convertedAmount + " " + targetcurrency);

    }
}