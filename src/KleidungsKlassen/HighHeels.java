package KleidungsKlassen;

public class HighHeels extends Schuhe
{
    private boolean IstOffen;

    public HighHeels(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, String solenMaterial, String verschlussTyp, boolean istOffen) {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, solenMaterial, verschlussTyp);
        IstOffen = istOffen;
    }

    public HighHeels(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, int kleidungsID, String solenMaterial, String verschlussTyp, boolean istOffen) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad, kleidungsID, solenMaterial, verschlussTyp);
        IstOffen = istOffen;
    }

    public boolean isIstOffen() {
        return IstOffen;
    }

    public void setIstOffen(boolean istOffen) {
        IstOffen = istOffen;
    }
}
