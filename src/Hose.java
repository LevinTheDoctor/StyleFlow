public class Hose extends Unterteil{
    private final Boolean HatDoppeltesKine;
    private final Boolean HatFalten;
    private final String Schnitt;
    private final String ArtDerHose;

    public Hose(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int laenge, int anzahlTaschen, Boolean hatDoppeltesKine, Boolean hatFalten, String schnitt, String artDerHose) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, laenge, anzahlTaschen);
        HatDoppeltesKine = hatDoppeltesKine;
        HatFalten = hatFalten;
        Schnitt = schnitt;
        ArtDerHose = artDerHose;
    }

    public Boolean isHatDoppeltesKine() {
        return HatDoppeltesKine;
    }

    public Boolean isHatFalten() {
        return HatFalten;
    }

    public String getSchnitt() {
        return Schnitt;
    }

    public String getArtDerHose() {
        return ArtDerHose;
    }
}
