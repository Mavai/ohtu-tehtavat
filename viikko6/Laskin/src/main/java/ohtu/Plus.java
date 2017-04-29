package ohtu;

import javax.swing.*;

public class Plus implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    public Plus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        this.edellinen = sovellus.tulos();
        sovellus.setTulos(sovellus.tulos() + arvo);
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
