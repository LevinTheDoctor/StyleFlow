package KleidungsKlassen;

public class Muetze extends Kopfbedeckung
{
    private final String strickArt;
    private final String stil;

    public Muetze(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String stil, String strickArt)
    {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
        this.stil = stil;
        this.strickArt = strickArt;
    }

    public Muetze(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String stil, String strickArt, int kleidungsId)
    {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsId);
        this.stil = stil;
        this.strickArt = strickArt;
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