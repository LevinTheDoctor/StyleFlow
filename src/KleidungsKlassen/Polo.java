package KleidungsKlassen;

public class Polo extends Oberteil {
    private final String kragenArt;
    private final int anzahlKnopfe;

    public Polo(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int aermelLaenge, String schnitt, String kragenArt, int anzahlKnopfe) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, aermelLaenge, schnitt);
        this.kragenArt = kragenArt;
        this.anzahlKnopfe = anzahlKnopfe;
    }

    public Polo(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt, String kragenArt, int anzahlKnopfe) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, aermelLaenge, schnitt);
        this.kragenArt = kragenArt;
        this.anzahlKnopfe = anzahlKnopfe;
    }

    public String getKragenArt() {
        return kragenArt;
    }

    public int getAnzahlKnopfe() {
        return anzahlKnopfe;
    }
}