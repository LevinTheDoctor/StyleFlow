package KleidungsKlassen;

public class Cap extends Kopfbedeckung
{
    private boolean istSchirmGekruemmt;
    private final String verschlussArt;

    public Cap(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad,String marke, boolean istSchirmGekruemmt, String verschlussArt)
    {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke);
        this.istSchirmGekruemmt = istSchirmGekruemmt;
        this.verschlussArt = verschlussArt;
    }

    public Cap(String[] StringAusJson)
    {
        super(StringAusJson);
        this.istSchirmGekruemmt = Boolean.parseBoolean(StringAusJson[6]);
        this.verschlussArt = StringAusJson[7];
    }


    public void setSchirmGekruemmt(boolean istSchirmGekruemmt)
    {
        this.istSchirmGekruemmt = istSchirmGekruemmt;
    }


    public boolean isIstSchirmGekruemmt()
    {
        return istSchirmGekruemmt;
    }

    public String getVerschlussArt()
    {
        return verschlussArt;
    }
}