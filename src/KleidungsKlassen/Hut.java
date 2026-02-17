package KleidungsKlassen;

public class Hut extends Kopfbedeckung
{
    private final int hoehe;
    private final String art;

    public Hut(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int hoehe, String art)
    {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
        this.art = art;
        this.hoehe = hoehe;
    }

    public Hut(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int hoehe, String art, int kleidungsId)
    {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsId);
        this.art = art;
        this.hoehe = hoehe;
    }

    public int getHoehe()
    {
        return hoehe;
    }

    public String getArt()
    {
        return art;
    }
}