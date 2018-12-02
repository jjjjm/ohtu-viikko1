package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        lukujono = alusta(new int[KAPASITEETTI]);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin on oltava yli 0");
        }
        lukujono = alusta(new int[kapasiteetti]);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin on oltava yli 0");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasavatuskoon on oltava yli 0");
        }
        lukujono = alusta(new int[kapasiteetti]);
        this.kasvatuskoko = kasvatuskoko;
    }

    private int[] alusta(int[] joukko) {
        for (int i = 0; i < joukko.length; i++) {
            joukko[i] = 0;
        }
        this.alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
        return joukko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            this.kasvataLukujonoa();
            this.lukujono[alkioidenLkm] = luku;
            this.alkioidenLkm++;
            return true;
        } else {
            return false;
        }
    }

    private void kasvataLukujonoa() {
        if (this.alkioidenLkm == this.lukujono.length) {
            this.kasvataLukujonoa();
        }
        int[] uusiLukuJono = this.kopioiTaulukko(lukujono, new int[alkioidenLkm + kasvatuskoko]);
        this.lukujono = uusiLukuJono;
    }

    public boolean kuuluu(int luku) {
        if (luvunIndeksiLukujonossa(luku) != -1) {
            return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        if (kuuluu(luku)) {
            this.lukujono = poistaLukujonosta(luku);
            this.alkioidenLkm--;
            return true;
        } else {
            return false;
        }
    }

    private int[] poistaLukujonosta(int luku) {
        int[] uusi = this.kopioiTaulukko(lukujono, new int[this.alkioidenLkm]);
        int luvunIndeksi = luvunIndeksiLukujonossa(luku);
        for (int i = luvunIndeksi; i < alkioidenLkm - 1; i++) {
            uusi[i] = uusi[i + 1];
        }
        return uusi;
    }

    private int luvunIndeksiLukujonossa(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (lukujono[i] == luku) {
                return i;
            }
        }
        return -1;
    }

    private int[] kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < this.alkioidenLkm; i++) {
            uusi[i] = vanha[i];
        }
        return uusi;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String palautetuttava = "{";
        if (alkioidenLkm != 0) {
            palautetuttava += alkiotToString();
        }
        palautetuttava += "}";
        return palautetuttava;
    }

    private String alkiotToString() {
        String alkiot = "";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            alkiot += lukujono[i];
            alkiot += ", ";
        }
        alkiot += lukujono[alkioidenLkm - 1];
        return alkiot;
    }

    public int[] toIntArray() {
        int[] uusi = this.kopioiTaulukko(this.lukujono, new int[this.alkioidenLkm]);
        return uusi;
    }

    private static int[] yhdistaTaulut(int[] taulu1, int[] taulu2) {
        int[] yhdiste = new int[taulu1.length + taulu2.length];
        for (int i = 0; i < taulu1.length; i++) {
            yhdiste[i] = taulu1[i];
        }
        for (int i = taulu1.length; i < taulu1.length + taulu2.length; i++) {
            yhdiste[i] = taulu2[i - taulu1.length];
        }
        return yhdiste;
    }

    public static IntJoukko yhdiste(IntJoukko joukko1, IntJoukko joukko2) {
        IntJoukko yhdiste = new IntJoukko();
        int[] yhdistetytTaulut = yhdistaTaulut(joukko1.toIntArray(), joukko2.toIntArray());
        for (int luku : yhdistetytTaulut) {
            yhdiste.lisaa(luku);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko joukko1, IntJoukko joukko2) {
        IntJoukko leikkausJoukko = new IntJoukko();
        for (int alkio : joukko1.toIntArray()) {
            if (joukko2.kuuluu(alkio)) {
                leikkausJoukko.lisaa(alkio);
            }
        }
        return leikkausJoukko;
    }

    public static IntJoukko erotus(IntJoukko joukko1, IntJoukko joukko2) {
        IntJoukko erotusJoukko = new IntJoukko();
        for (int alkio : joukko1.toIntArray()) {
            erotusJoukko.lisaa(alkio);
        }
        for (int alkio : joukko2.toIntArray()) {
            erotusJoukko.poista(alkio);
        }
        return erotusJoukko;
    }
}
