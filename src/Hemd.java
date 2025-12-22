public class Hemd extends Oberteil
{
    private final String KragenArt;
    private final String KnopfMaterial;

    public Hemd(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int aermelLaenge, String schnitt, String kragenArt, String knopfMaterial) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, aermelLaenge, schnitt);
        KragenArt = kragenArt;
        KnopfMaterial = knopfMaterial;
    }

    public String getKragenArt() {
        return KragenArt;
    }

    public String getKnopfMaterial() {
        return KnopfMaterial;
    }
}
