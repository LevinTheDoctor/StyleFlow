package KleidungsKlassen;

public class Hemd extends Oberteil {
    private final String kragenArt;
    private String muster;

    public Hemd(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, int aermelLaenge, String schnitt, String kragenArt, String muster) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, marke, aermelLaenge, schnitt);
        this.kragenArt = kragenArt;
        this.muster = muster;
    }

    public Hemd(String[] StringAusJson) {
        super(StringAusJson);
        this.kragenArt = StringAusJson[9];
        this.muster = StringAusJson[10];
    }


    public void setMuster(String muster) {
        this.muster = muster;
    }


    public String getKragenArt() {
        return kragenArt;
    }

    public String getMuster() {
        return muster;
    }
}