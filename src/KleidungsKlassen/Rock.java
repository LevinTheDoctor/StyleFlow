package KleidungsKlassen;

public class Rock extends Unterteil {
    private final String art;

    public Rock(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int laenge, int anzahlTaschen, String art) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, laenge, anzahlTaschen);
        this.art = art;
    }

    public Rock(String[] StringAusJson) {
        super(StringAusJson);
        this.art = StringAusJson[8];
    }


    public String getArt() {
        return art;
    }
}