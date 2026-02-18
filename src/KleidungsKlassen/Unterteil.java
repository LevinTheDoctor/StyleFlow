package KleidungsKlassen;

public abstract class Unterteil extends Kleidungsstueck {
    private final int laenge;
    private final int anzahlTaschen;

    public Unterteil(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int laenge, int anzahlTaschen) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
        this.laenge = laenge;
        this.anzahlTaschen = anzahlTaschen;
    }

    public Unterteil(String[] StringAusJson) {
        super(StringAusJson);
        this.laenge = Integer.parseInt(StringAusJson[6]);
        this.anzahlTaschen = Integer.parseInt(StringAusJson[7]);
    }


    public int getLaenge() {
        return laenge;
    }

    public int getAnzahlTaschen() {
        return anzahlTaschen;
    }
}