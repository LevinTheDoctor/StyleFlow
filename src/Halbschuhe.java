public class Halbschuhe extends Schuhe
{
    private final String Art;
    private final String Muster;

    public Halbschuhe(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, String solenMaterial, String verschlussTyp, String art, String muster)
    {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, solenMaterial, verschlussTyp);
        Art = art;
        Muster = muster;
    }

    public String getArt()
    {
        return Art;
    }

    public String getMuster()
    {
        return Muster;
    }
}
