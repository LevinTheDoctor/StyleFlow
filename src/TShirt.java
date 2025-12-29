public class TShirt extends Oberteil
{
    private final String AusschnitArt;
    private final String Motiv;

    public TShirt(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int aermelLaenge, String schnitt, String ausschnitArt, String motiv) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, aermelLaenge, schnitt);
        AusschnitArt = ausschnitArt;
        Motiv = motiv;
    }

    public TShirt(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, int kleidungsID, int aermelLaenge, String schnitt, String ausschnitArt, String motiv) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad, kleidungsID, aermelLaenge, schnitt);
        AusschnitArt = ausschnitArt;
        Motiv = motiv;
    }

    public String getAusschnitArt() {
        return AusschnitArt;
    }

    public String getMotiv() {
        return Motiv;
    }
}
