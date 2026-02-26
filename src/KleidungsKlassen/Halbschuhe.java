package KleidungsKlassen;

public class Halbschuhe extends Schuhe {
    private final String art;
    private String muster;

    public Halbschuhe(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, String absatzHoehe, String verschlussArt, String art, String muster) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, marke,absatzHoehe, verschlussArt);
        this.art = art;
        this.muster = muster;
    }

    public Halbschuhe(String[] StringAusJson) {
        super(StringAusJson);
        this.art = StringAusJson[9];
        this.muster = StringAusJson[10];
    }


    public void setMuster(String muster) {
        this.muster = muster;
    }


    public String getArt() {
        return art;
    }

    public String getMuster() {
        return muster;
    }
}