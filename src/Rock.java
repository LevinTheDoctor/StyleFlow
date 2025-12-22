public class Rock extends Unterteil{
    private final String BundDetails;
    private final int WeiteInCM;
    private final String Art;

    public Rock(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int laenge, int anzahlTaschen, String bundDetails, int weiteInCM, String art)
    {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, laenge, anzahlTaschen);
        BundDetails = bundDetails;
        WeiteInCM = weiteInCM;
        Art = art;
    }

    public String getBundDetails()
    {
        return BundDetails;
    }

    public int getWeiteInCM()
    {
        return WeiteInCM;
    }

    public String getArt()
    {
        return Art;
    }
}
