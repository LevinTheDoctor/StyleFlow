public class Stiefel extends Schuhe
{
    private final int AbsatzGroesse;
    private final String Art;
    private final String Muster;

    public Stiefel(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, String solenMaterial, String verschlussTyp, int absatzGroesse, String art, String muster)
    {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, solenMaterial, verschlussTyp);
        AbsatzGroesse = absatzGroesse;
        Art = art;
        Muster = muster;
    }

    public int getAbsatzGroesse()
    {
        return AbsatzGroesse;
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
