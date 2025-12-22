public class Hut extends Kopfbedeckung
{
    private final int Hoehe;
    private final String Form;
    private final boolean istSteif;
    private final boolean hatBand;

    public Hut(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, int hoehe, String form, boolean istSteif, boolean hatBand)
    {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, true, false);
        this.Hoehe = hoehe;
        this.Form = form;
        this.istSteif = istSteif;
        this.hatBand = hatBand;
    }

    public int getHoehe()
    {
        return Hoehe;
    }

    public String getForm()
    {
        return Form;
    }

    public boolean isIstSteif()
    {
        return istSteif;
    }

    public boolean isHatBand()
    {
        return hatBand;
    }
}
