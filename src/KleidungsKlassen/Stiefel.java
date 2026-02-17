package KleidungsKlassen;

public class Stiefel extends Schuhe {
    private final String art;
    private final String muster;

    public Stiefel(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String absatzHoehe, String verschlussArt, String art, String muster) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, absatzHoehe, verschlussArt);
        this.art = art;
        this.muster = muster;
    }

    public Stiefel(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, String absatzHoehe, String verschlussArt, String art, String muster) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, absatzHoehe, verschlussArt);
        this.art = art;
        this.muster = muster;
    }

    public String getArt() {
        return art;
    }

    public String getMuster() {
        return muster;
    }
}