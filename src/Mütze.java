public class Mütze extends Kopfbedeckung
{
    private final String StrickArt;
    private final String Stil;
    private final Boolean hatUmschlag;

    public Mütze(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad,  String strickArt, String stil, Boolean hatUmschlag)
    {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, true,false);
        StrickArt = strickArt;
        Stil = stil;
        this.hatUmschlag = hatUmschlag;
    }

    public String getStrickArt() {
        return StrickArt;
    }

    public String getStil() {
        return Stil;
    }

    public Boolean getHatUmschlag() {
        return hatUmschlag;
    }
}
