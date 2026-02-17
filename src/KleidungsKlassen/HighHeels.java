package KleidungsKlassen;

public class HighHeels extends Schuhe {
    private boolean istOffen;

    public HighHeels(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, String absatzHoehe, String verschlussArt, boolean istOffen) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, absatzHoehe, verschlussArt);
        this.istOffen = istOffen;
    }

    public HighHeels(String bezeichnung, String[] farben, String bedecktesKoerperteil, String wettereignung, String bildDateiPfad, int kleidungsID, String absatzHoehe, String verschlussArt, boolean istOffen) {
        super(bezeichnung, farben, bedecktesKoerperteil, wettereignung, bildDateiPfad, kleidungsID, absatzHoehe, verschlussArt);
        this.istOffen = istOffen;
    }

    public boolean isIstOffen() {
        return istOffen;
    }

    public void setIstOffen(boolean istOffen) {
        this.istOffen = istOffen;
    }
}