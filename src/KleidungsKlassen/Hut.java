package KleidungsKlassen;

public class Hut extends Kopfbedeckung
{
    private int hoehe;
    private final String artHut;

    public Hut(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, int hoehe, String artHut)
    {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke);
        this.hoehe = hoehe;
        this.artHut = artHut;
    }

    public Hut(String[] StringAusJson)
    {
        super(StringAusJson);
        this.hoehe = Integer.parseInt(StringAusJson[6]);
        this.artHut = StringAusJson[7];
    }


    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }


    public int getHoehe()
    {
        return hoehe;
    }

    public String getArtHut()
    {
        return artHut;
    }
}