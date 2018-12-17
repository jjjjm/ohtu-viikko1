package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        main:
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
            String vastaus = scanner.nextLine();
            switch (vastaus) {
                case "a":
                    Peli.moninpeli().pelaa();
                    break;
                case "b":
                    Peli.yksinPeli().pelaa();
                    break;
                case "c":
                    Peli.yksinPeliVaikea().pelaa();
                    break;
                default:
                    break main;
            }

        }

    }
}
