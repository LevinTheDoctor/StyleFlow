public class Top extends Oberteil
{
    private final String AusschnitArt;
    private final String TraegerArt;

    public Top(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int aermelLaenge, String schnitt, String ausschnitArt, String traegerArt) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, aermelLaenge, schnitt);
        AusschnitArt = ausschnitArt;
        TraegerArt = traegerArt;
    }

    public String getAusschnitArt() {
        return AusschnitArt;
    }

    public String getTraegerArt() {
        return TraegerArt;
    }
}
