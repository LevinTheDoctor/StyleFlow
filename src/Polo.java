public class Polo extends Oberteil
{
    private final String AusschnitArt;
    private final int  AnzahlKnopfe;
    private final String Muster;

    public Polo(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int aermelLaenge, String schnitt, String ausschnitArt, int anzahlKnopfe, String muster) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, aermelLaenge, schnitt);
        AusschnitArt = ausschnitArt;
        AnzahlKnopfe = anzahlKnopfe;
        Muster = muster;
    }

    public String getAusschnitArt() {
        return AusschnitArt;
    }

    public int getAnzahlKnopfe() {
        return AnzahlKnopfe;
    }

    public String getMuster() {
        return Muster;
    }
}
