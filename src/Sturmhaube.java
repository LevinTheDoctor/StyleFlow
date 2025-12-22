public class Sturmhaube extends Kopfbedeckung
{
    private final String StrickArt;
    private final String AugenAusschnitsArt;

    public Sturmhaube(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, Boolean hatSchirm, String strickArt, String augenAusschnitsArt) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, hatSchirm, true);
        StrickArt = strickArt;
        AugenAusschnitsArt = augenAusschnitsArt;
    }

    public String getStrickArt() {
        return StrickArt;
    }

    public String getAugenAusschnitsArt() {
        return AugenAusschnitsArt;
    }
}
