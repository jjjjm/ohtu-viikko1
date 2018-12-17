package ohtu.kivipaperisakset;

import java.util.Scanner;

public class TekoalyPeli extends Peli {

    private static final Scanner scanner = new Scanner(System.in);
    private Tekoaly tekoaly;

    public TekoalyPeli(Tekoaly tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    protected String toinenVuoro() {
        String tekoalynSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tekoalynSiirto);
        return tekoalynSiirto;
    }
}
