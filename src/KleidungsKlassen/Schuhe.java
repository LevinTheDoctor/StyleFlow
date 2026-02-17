package KleidungsKlassen;

public abstract class Schuhe extends Kleidungsstueck {
    private final String absatzHoehe;
    private final String verschlussArt;

    public Schuhe(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String absatzHoehe, String verschlussArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
        this.absatzHoehe = absatzHoehe;
        this.verschlussArt = verschlussArt;
    }

    public Schuhe(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, String absatzHoehe, String verschlussArt) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID);
        this.absatzHoehe = absatzHoehe;
        this.verschlussArt = verschlussArt;
    }

    public String getAbsatzHoehe() {
        return absatzHoehe;
    }

    public String getVerschlussArt() {
        return verschlussArt;
    }
}