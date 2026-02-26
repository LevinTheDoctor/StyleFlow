package KleidungsKlassen;

public abstract class Schuhe extends Kleidungsstueck {
    private String absatzHoehe;
    private String verschlussArt;


    public Schuhe(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String marke,String absatzHoehe, String verschlussArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, marke);
        this.absatzHoehe = absatzHoehe;
        this.verschlussArt = verschlussArt;
    }

    public Schuhe(String[] StringAusJson) {
        super(StringAusJson);
        this.absatzHoehe = StringAusJson[7];
        this.verschlussArt = StringAusJson[8];
    }


    public void setAbsatzHoehe(String absatzHoehe) {
        this.absatzHoehe = absatzHoehe;
    }

    public void setVerschlussArt(String verschlussArt) {
        this.verschlussArt = verschlussArt;
    }


    public String getAbsatzHoehe() {
        return absatzHoehe;
    }

    public String getVerschlussArt() {
        return verschlussArt;
    }
}