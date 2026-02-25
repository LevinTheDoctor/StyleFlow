package KleidungsKlassen;

public class Muetze extends Kopfbedeckung
{
    private final String strickArt;
    private final String stil;

    public Muetze(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String marke,String stil, String strickArt)
    {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad,marke);
        this.stil = stil;
        this.strickArt = strickArt;
    }

    public Muetze(String[] StringAusJson)
    {
        super(StringAusJson);
        this.stil = StringAusJson[6];
        this.strickArt = StringAusJson[7];
    }


    public String getStrickArt()
    {
        return strickArt;
    }

    public String getStil()
    {
        return stil;
    }
}