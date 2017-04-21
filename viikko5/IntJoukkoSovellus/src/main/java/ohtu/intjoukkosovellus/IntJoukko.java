
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }


    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        validate(kapasiteetti, kasvatuskoko);
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }


    private void validate(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
    }


    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm++] = luku;
            if (alkioidenLkm % ljono.length == 0) {
                kasvataLukujonoa();
            }
            return true;
        }
        return false;
    }


    private void kasvataLukujonoa() {
        int[] taulukkoOld = new int[ljono.length];
        taulukkoOld = ljono;
        kopioiTaulukko(ljono, taulukkoOld);
        ljono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, ljono);
    }


    public boolean kuuluu(int luku) {
        int on = 0;
        on = getOn(luku, on);
        if (on > 0) {
            return true;
        } else {
            return false;
        }
    }


    private int getOn(int luku, int on) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                on++;
            }
        }
        return on;
    }


    public boolean poista(int luku) {
        int kohta = -1;
        kohta = getKohta(luku, kohta);
        if (kohta != -1) {
            siirraLuvut(kohta);
            alkioidenLkm--;
            return true;
        }
        return false;
    }


    private void siirraLuvut(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apu;
        }
    }


    private int getKohta(int luku, int kohta) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                ljono[kohta] = 0;
                break;
            }
        }
        return kohta;
    }


    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }


    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else {
            String tuotos = muodostaTuotos();
            return tuotos;
        }
    }


    private String muodostaTuotos() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += ljono[i];
            tuotos += ", ";
        }
        tuotos += ljono[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }


    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }


    public static IntJoukko operaatio(IntJoukko a, IntJoukko b, String operaatio) {
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        switch (operaatio) {
            case "yhdiste":
                return muodostaYhdiste(aTaulu, bTaulu);
            case "leikkaus":
                return muodostaLeikkaus(aTaulu, bTaulu);
            case "erotus":
                return muodostaErotus(aTaulu, bTaulu);
        }
        return new IntJoukko();
    }


    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        return operaatio(a, b, "yhdiste");
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        return operaatio(a, b, "leikkaus");
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        return operaatio(a, b, "erotus");
    }


    private static void lisaaAlkiot(int[] aTaulu, ohtu.intjoukkosovellus.IntJoukko x) {
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
    }


    private static void poistaAlkiot(int[] bTaulu, ohtu.intjoukkosovellus.IntJoukko z) {
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }
    }

    private static void lisaaYhteisetAlkiot(int[] aTaulu, int[] bTaulu, ohtu.intjoukkosovellus.IntJoukko y) {
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
    }


    public static IntJoukko muodostaYhdiste(int[] aTaulu, int[] bTaulu) {
        IntJoukko x = new IntJoukko();
        lisaaAlkiot(aTaulu, x);
        lisaaAlkiot(bTaulu, x);
        return x;
    }


    private static IntJoukko muodostaLeikkaus(int[] aTaulu, int[] bTaulu) {
        IntJoukko y = new IntJoukko();
        lisaaYhteisetAlkiot(aTaulu, bTaulu, y);
        return y;
    }


    private static IntJoukko muodostaErotus(int[] aTaulu, int[] bTaulu) {
        IntJoukko z = new IntJoukko();
        lisaaAlkiot(aTaulu, z);
        poistaAlkiot(bTaulu, z);
        return z;
    }
}