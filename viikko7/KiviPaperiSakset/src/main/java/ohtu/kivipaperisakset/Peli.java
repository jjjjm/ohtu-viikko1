package ohtu.kivipaperisakset;

import java.util.Scanner;

abstract class Peli {

    private Tuomari tuomari;
    private static final Scanner scanner = new Scanner(System.in);

    public Peli() {
        this.tuomari = new Tuomari();
    }

    public void pelaa() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        System.out.println("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto = toinenVuoro();
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            tokanSiirto = toinenVuoro();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    abstract protected String toinenVuoro();

    static Peli moninpeli() {
        return new PelaaVSPeli();
    }

    static Peli yksinPeli() {
        return new TekoalyPeli(new Tekoaly());
    }

    static Peli yksinPeliVaikea() {
        return new TekoalyPeli(new TekoalyParannettu(10));
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
