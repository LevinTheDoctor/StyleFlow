public class Cappe extends Kopfbedeckung
{
    private boolean SchrimGekruemt;
    private final String VerschlussaArt;

    public Cappe(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String BildDateiPfad, Boolean bedecktGesicht, Boolean SchrimGekruemt,String VerschlussaArt)
    {
        super(name, farbe, groesse, material, marke, anlass, wetter, BildDateiPfad, true, bedecktGesicht);
        this.SchrimGekruemt = SchrimGekruemt;
        this.VerschlussaArt = VerschlussaArt;
    }

    public boolean isSchrimGekruemt()
    {
        return SchrimGekruemt;
    }

    public void setSchrimGekruemt(boolean schrimGekruemt)
    {
        SchrimGekruemt = schrimGekruemt;
    }

    public String getVerschlussaArt()
    {
        return VerschlussaArt;
    }
}
