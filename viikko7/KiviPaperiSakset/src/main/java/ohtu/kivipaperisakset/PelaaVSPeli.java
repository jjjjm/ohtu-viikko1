package ohtu.kivipaperisakset;

import java.util.Scanner;

public class PelaaVSPeli extends Peli {

    private static final Scanner scanner = new Scanner(System.in);

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    @Override
    protected String toinenVuoro() {
        System.out.println("Toisen pelaajan siirto:");
        return scanner.nextLine();
    }
}
