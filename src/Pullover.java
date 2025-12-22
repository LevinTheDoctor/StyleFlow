public class Pullover extends Oberteil
{
    private final String AusschnitArt;
    private final String Muster;
    private final String StrickArt;

    public Pullover(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int aermelLaenge, String schnitt, String ausschnitArt, String muster, String strickArt) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, aermelLaenge, schnitt);
        AusschnitArt = ausschnitArt;
        Muster = muster;
        StrickArt = strickArt;
    }

    public String getAusschnitArt() {
        return AusschnitArt;
    }

    public String getMuster() {
        return Muster;
    }

    public String getStrickArt() {
        return StrickArt;
    }
}
