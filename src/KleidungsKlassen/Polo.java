package KleidungsKlassen;

public class Polo extends Oberteil {
    private final String kragenArt;
    private final int anzahlKnopfe;

    public Polo(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String marke,int aermelLaenge, String schnitt, String kragenArt, int anzahlKnopfe) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, marke,aermelLaenge, schnitt);
        this.kragenArt = kragenArt;
        this.anzahlKnopfe = anzahlKnopfe;
    }

    public Polo(String[] StringAusJson) {
        super(StringAusJson);
        this.kragenArt = StringAusJson[8];
        this.anzahlKnopfe = Integer.parseInt(StringAusJson[9]);
    }


    public String getKragenArt() {
        return kragenArt;
    }

    public int getAnzahlKnopfe() {
        return anzahlKnopfe;
    }
}