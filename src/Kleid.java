public class Kleid extends Kleidungsstueck
{
    private final String AuschnitArt;
    private final String Schnitt;
    private final int LangeInCM;
    private final boolean HatAermel;

    public Kleid(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, String auschnitArt, String schnitt, int langeInCM, boolean hatAermel) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad);
        AuschnitArt = auschnitArt;
        Schnitt = schnitt;
        LangeInCM = langeInCM;
        HatAermel = hatAermel;
    }

    public Kleid(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, int kleidungsID, String auschnitArt, String schnitt, int langeInCM, boolean hatAermel) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad, kleidungsID);
        AuschnitArt = auschnitArt;
        Schnitt = schnitt;
        LangeInCM = langeInCM;
        HatAermel = hatAermel;
    }

    public String getAuschnitArt() {
        return AuschnitArt;
    }

    public String getSchnitt() {
        return Schnitt;
    }

    public int getLangeInCM() {
        return LangeInCM;
    }

    public boolean isHatAermel() {
        return HatAermel;
    }
}
