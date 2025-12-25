public class Jacke extends Oberteil
{
    private final String verschlussArt;
    private final boolean istWasserdicht;
    private final String FutterMaterial;

    public Jacke(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int aermelLaenge, String schnitt, String verschlussArt, boolean istWasserdicht,String FutterMaterial)
    {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, aermelLaenge, schnitt);
        this.verschlussArt = verschlussArt;
        this.istWasserdicht = istWasserdicht;
        this.FutterMaterial = FutterMaterial;
    }

    public String getVerschlussArt()
    {
        return verschlussArt;
    }

    public boolean isIstWasserdicht()
    {
        return istWasserdicht;
    }

    public String getFutterMaterial()
    {
        return FutterMaterial;
    }

}
