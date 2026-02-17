package KleidungsKlassen;

public abstract class Unterteil extends Kleidungsstueck {
    private final int laenge;
    private final int anzahlTaschen;

    public Unterteil(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int laenge, int anzahlTaschen) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
        this.laenge = laenge;
        this.anzahlTaschen = anzahlTaschen;
    }

    public Unterteil(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, int laenge, int anzahlTaschen) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID);
        this.laenge = laenge;
        this.anzahlTaschen = anzahlTaschen;
    }

    public int getLaenge() {
        return laenge;
    }

    public int getAnzahlTaschen() {
        return anzahlTaschen;
    }
}