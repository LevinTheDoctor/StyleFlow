package KleidungsKlassen;

public class Cap extends Kopfbedeckung
{
    private boolean schirmGekruemmt;
    private final String verschlussArt;

    public Cap(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, boolean schirmGekruemmt, String verschlussArt)
    {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad);
        this.schirmGekruemmt = schirmGekruemmt;
        this.verschlussArt = verschlussArt;
    }

    public Cap(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, boolean schirmGekruemmt, String verschlussArt, int kleidungsID)
    {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID);
        this.schirmGekruemmt = schirmGekruemmt;
        this.verschlussArt = verschlussArt;
    }

    public void setSchirmGekruemmt(boolean schirmGekruemmt)
    {
        this.schirmGekruemmt = schirmGekruemmt;
    }

    public boolean isSchirmGekruemmt()
    {
        return schirmGekruemmt;
    }

    public String getVerschlussArt()
    {
        return verschlussArt;
    }
}