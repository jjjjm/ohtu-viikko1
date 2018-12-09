package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa implements Komento {

    private TextField tuloskentta, syotekentta;
    private Button nollaa, undo;
    private Sovelluslogiikka sovellus;
    private int edellinenLuku;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovelluslogiikka;
        this.edellinenLuku = 0;
    }

    @Override
    public void suorita() {
        int nykyinenLuku = Integer.parseInt(this.syotekentta.getText());
        this.edellinenLuku = nykyinenLuku;
        this.sovellus.plus(nykyinenLuku);
        this.tuloskentta.setText(Integer.toString(this.sovellus.tulos()));
    }

    @Override
    public void peru() {
        this.sovellus.miinus(edellinenLuku);
        this.tuloskentta.setText(Integer.toString(this.sovellus.tulos()));
    }

}
