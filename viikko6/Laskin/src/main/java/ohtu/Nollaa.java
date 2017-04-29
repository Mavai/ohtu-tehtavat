package ohtu;

import javax.swing.*;

public class Nollaa implements Komento{
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    @Override
    public void suorita() {
        this.edellinen = sovellus.tulos();
        sovellus.setTulos(0);
        setTextFields();
    }

    @Override
    public void peru() {
        sovellus.setTulos(edellinen);
        setTextFields();
    }

    private void setTextFields() {
        tuloskentta.setText("" + sovellus.tulos());
        syotekentta.setText("");
    }
}
