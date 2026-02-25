package KleidungsKlassen;

public class Sandalen extends Schuhe {
    private final boolean istOffen;
    private int almanFaktor;

    public Sandalen(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, String absatzHoehe, String verschlussArt, boolean istOffen, int almanFaktor) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke, absatzHoehe, verschlussArt);
        this.istOffen = istOffen;
        this.almanFaktor = almanFaktor;
    }

    public Sandalen(String[] StringAusJson) {
        super(StringAusJson);
        this.istOffen = Boolean.parseBoolean(StringAusJson[8]);
        this.almanFaktor = Integer.parseInt(StringAusJson[9]);
    }


    public void setAlmanFaktor(int almanFaktor) {
        this.almanFaktor = almanFaktor;
    }


    public boolean isIstOffen() {
        return istOffen;
    }

    public int getAlmanFaktor() {
        return almanFaktor;
    }
}