public abstract class Unterteil extends Kleidungsstueck {
    private final int Laenge;
    private final int AnzahlTaschen;

    public Unterteil(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter,String BildDateiPfad,int laenge, int anzahlTaschen) {
        super(name, farbe, groesse, material, marke, anlass, wetter,BildDateiPfad);
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
