package KleidungsKlassen;

public class Rock extends Unterteil {
    private final String artRock;

    public Rock(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, int laenge, int anzahlTaschen, String artRock) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, marke,laenge, anzahlTaschen);
        this.artRock = artRock;
    }

    public Rock(String[] StringAusJson) {
        super(StringAusJson);
        this.artRock = StringAusJson[8];
    }


    public String getArtRock() {
        return artRock;
    }
}