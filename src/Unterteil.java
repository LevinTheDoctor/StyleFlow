public class Unterteil extends Kleidungsstueck {
    private int Laenge;
    private int AnzahlTaschen;

    public Unterteil(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter,int laenge, int anzahlTaschen) {
        super(name, farbe, groesse, material, marke, anlass, wetter);
        this.AnzahlTaschen = anzahlTaschen;
        this.Laenge = laenge;
    }

    public int getLaenge() {
        return Laenge;
    }

    public int getAnzahlTaschen() {
        return AnzahlTaschen;
    }
}
